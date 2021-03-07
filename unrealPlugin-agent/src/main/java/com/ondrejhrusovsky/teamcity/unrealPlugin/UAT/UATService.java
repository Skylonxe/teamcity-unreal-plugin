package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.google.gson.Gson;
import com.ondrejhrusovsky.teamcity.unrealPlugin.Arg_EnginePath;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPreset;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UBT.UBTConstants;
import com.ondrejhrusovsky.teamcity.unrealPlugin.Util;
import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.runner.BuildServiceAdapter;
import jetbrains.buildServer.agent.runner.ProgramCommandLine;
import jetbrains.buildServer.agent.runner.SimpleProgramCommandLine;
import jetbrains.buildServer.util.FileUtil;
import jetbrains.buildServer.util.TCStreamUtil;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UATService extends BuildServiceAdapter {

    private final Set<File> myFilesToDelete = new HashSet<File>();
    @NotNull
    @Override
    public ProgramCommandLine makeProgramCommandLine() throws RunBuildException {
        getLogger().message("Input runner parameters: " + getRunnerParameters().toString());

        final String PresetName = getRunnerParameters().getOrDefault(UATConstants.get().getPresetKey(), "");
        HashMap<String, String> relevantRunnerParameters = new HashMap<>();
        for(Map.Entry<String, String> param : getRunnerParameters().entrySet())
        {
            if(param.getKey().contains(PresetName) || !param.getKey().contains(CmdPreset.class.getSimpleName()))
            {
                final String afterDot = param.getKey().substring(param.getKey().indexOf(".")+1);
                relevantRunnerParameters.put(afterDot, param.getValue());
            }
        }

        getLogger().message("Relevant runner parameters: " + relevantRunnerParameters.toString());

        final Path engineBaseDir = Paths.get(relevantRunnerParameters.get(Arg_EnginePath.class.getSimpleName()));
        final Path RunUAT = UATConstants.get().getExePath(engineBaseDir);
        final CmdPreset preset = UATConstants.get().getPresetByName(PresetName);

        Map<String, String> makeArgsParams = new HashMap<>();
        makeArgsParams.putAll(relevantRunnerParameters);
        makeArgsParams.putAll(getEnvironmentVariables());
        makeArgsParams.putAll(getBuildParameters().getAllParameters());

        final String globalArguments = Util.parametersMapToCmdArgsString(getRunnerParameters(), UATConstants.get().getGlobalArguments(), getLogger());
        final String presetArguments = preset.makeArgumentsString(relevantRunnerParameters, getLogger());
        final String UATArguments = presetArguments + (!globalArguments.isEmpty() ? " " + globalArguments : "");

        // Now implemented using makeCommandLine
        //final Path uprojectFile = Paths.get(relevantRunnerParameters.getOrDefault(Arg_UProjectFile.class.getSimpleName(), ""));

        StringBuilder scriptContent = new StringBuilder(RunUAT.toString());

        if(UATArguments.length() > 0)
        {
            scriptContent.append(' ');
            scriptContent.append(UATArguments);
        }

        // Now implemented using makeCommandLine
        /*if(uprojectFile.toString().length() > 0)
        {
            scriptContent.append(" -project=\"");
            scriptContent.append(uprojectFile);
            scriptContent.append('"');
        }*/

        getLogger().message("ScriptContent: " + scriptContent);

        final String script = getCustomScript(scriptContent.toString());
        setExecutableAttribute(script);
        return new SimpleProgramCommandLine(getRunnerContext(), script, Collections.<String>emptyList());
    }

    String getCustomScript(String scriptContent) throws RunBuildException {
        try {
            final File scriptFile = File.createTempFile("custom_script", ".bat", getAgentTempDirectory());
            FileUtil.writeFileAndReportErrors(scriptFile, scriptContent);
            myFilesToDelete.add(scriptFile);
            return scriptFile.getAbsolutePath();
        } catch (IOException e) {
            RunBuildException exception = new RunBuildException("Failed to create temporary custom script file in directory" + getAgentTempDirectory().toString(), e);
            exception.setLogStacktrace(false);
            throw exception;
        }
    }

    private void setExecutableAttribute(@NotNull final String script) throws RunBuildException {
        try {
            TCStreamUtil.setFileMode(new File(script), "a+x");
        } catch(Throwable t) {
            throw new RunBuildException("Failed to set executable attribute for custom script '" + script + "'", t);
        }
    }

    @Override
    public void beforeProcessStarted() throws RunBuildException {

        super.beforeProcessStarted();
        // something logic
    }

    @Override
    public void afterProcessFinished() throws RunBuildException {
        super.afterProcessFinished();
        for(File file : myFilesToDelete) {
            FileUtil.delete(file);
        }
        myFilesToDelete.clear();
    }
}
