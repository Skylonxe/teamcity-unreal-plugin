package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import com.ondrejhrusovsky.teamcity.unrealPlugin.Arg_EnginePath;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.Arg_UProjectFile;
import jetbrains.buildServer.agent.BuildProgressLogger;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class MetaArg_AutoDeduceTargetToStage extends ArgBase_Bool {
    public MetaArg_AutoDeduceTargetToStage()
    {
        friendlyName = "Automatically deduce target to stage";
        description = "If enabled, build step will look for project's .target file, read platform and configuration from there and append respective target and platform arguments to the commandline.\n" +
                "If disabled, target platform and configuration to stage should be set manually using settings of this step.";
        defaultValue = "true";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, deduceTargetArgumentsFromTargetFiles(params, logger));
    }

    public String deduceTargetArgumentsFromTargetFiles(Map<String, String> params, BuildProgressLogger logger) {
        if(logger != null)
        {
            logger.message(params.toString());
        }

        final String checkoutDir = params.get("build.checkoutDir");

        if(checkoutDir == null)
        {
            return "-(server/client)config=? -(client/target)platform=?";
        }

        final Path engineBaseDir = Paths.get(params.get(Arg_EnginePath.class.getSimpleName()));
        final Path uprojectFilePath = Paths.get(checkoutDir.toString(), engineBaseDir.toString(), params.get(Arg_UProjectFile.class.getSimpleName()));
        final Path projectBinariesPath = Paths.get(uprojectFilePath.getParent().toString(), "Binaries");
        final File uprojectBinariesFolder = new File(projectBinariesPath.toString());
        Path targetFilePath = null;
        String result = "";
        String fileContent = null;
        JSONObject targetJson = null;
        String type = null;

        final String[] suffix = { "target" };
        for(File f : FileUtils.listFiles(uprojectBinariesFolder, suffix, true))
        {
            targetFilePath = f.toPath();
            try {
                fileContent = new String(Files.readAllBytes(targetFilePath));
                targetJson = new JSONObject(fileContent);
                type = targetJson.getString("TargetType");

                // Skip editor targets
                if(type.equals("Editor") || type.equals("Program"))
                {
                    targetFilePath = null;
                    fileContent = null;
                    targetJson = null;
                    type = null;
                    continue;
                }
            } catch (IOException e) {
                if(logger != null)
                {
                    logger.exception(e);
                }
                else
                {
                    e.printStackTrace();
                }
            }

            break;
        }

        if(targetFilePath != null)
        {
            if(logger != null)
            {
                logger.message("Deducing target parameters from " + targetFilePath.toString());
            }

            final String platform = targetJson.getString("Platform");
            final String configuration = targetJson.getString("Configuration");

            if(logger != null)
            {
                logger.message(".target file content: Platform=" + platform + " Configuration=" + configuration + " Type=" + type);
            }

            String typeString = "";
            String platformTypeString = "";

            if(type.equals("Server"))
            {
                typeString = "server";
                platformTypeString = "server";
            }
            else
            {
                typeString = "client";
                platformTypeString = "target";
            }

            result = " -" + typeString + "config=" + configuration + " -" + platformTypeString + "platform=" + platform;
        }
        else
        {
            if(logger != null)
            {
                logger.warning("Could not deduce target parameters because .target file was not found");
            }

        }

        if(logger != null)
        {
            logger.message("Deduced parameters: " + result);
        }

        return result;
    }
}
