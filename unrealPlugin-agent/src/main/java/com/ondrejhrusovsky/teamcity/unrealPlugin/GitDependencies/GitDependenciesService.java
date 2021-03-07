package com.ondrejhrusovsky.teamcity.unrealPlugin.GitDependencies;

import com.ondrejhrusovsky.teamcity.unrealPlugin.Arg_EnginePath;
import com.ondrejhrusovsky.teamcity.unrealPlugin.Util;
import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.runner.BuildServiceAdapter;
import jetbrains.buildServer.agent.runner.ProgramCommandLine;
import jetbrains.buildServer.agent.runner.SimpleProgramCommandLine;
import jetbrains.buildServer.util.FileUtil;
import jetbrains.buildServer.util.TCStreamUtil;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GitDependenciesService extends BuildServiceAdapter {
    private final Set<File> myFilesToDelete = new HashSet<File>();

    @NotNull
    @Override
    public ProgramCommandLine makeProgramCommandLine() throws RunBuildException {
        getLogger().message("Input runner parameters: " + getRunnerParameters().toString());

        final Path engineBaseDir = Paths.get(getRunnerParameters().get(Arg_EnginePath.class.getSimpleName()));
        final Path Exe = GitDependenciesConstants.get().getExePath(engineBaseDir);
        final String cmdArgs = Util.parametersMapToCmdArgsString(getRunnerParameters(), GitDependenciesConstants.get().getGlobalArguments(), getLogger());

        final String runOnlyOnce = getRunnerParameters().getOrDefault("run_only_once", "");

        if(runOnlyOnce.equals("true"))
        {
            final String relTestFilePathStr = "Engine\\Binaries\\DotNET\\Ionic.Zip.Reduced.dll";
            final Path testFilePath = Paths.get(getCheckoutDirectory().toPath().toString(), engineBaseDir.toString(), relTestFilePathStr);
            if(Files.exists(testFilePath))
            {
                getLogger().message("Run only once behavior decided to not check git dependencies because file " + relTestFilePathStr + " is already present.");

                final String script = getCustomScript("@");
                setExecutableAttribute(script);
                return new SimpleProgramCommandLine(getRunnerContext(), script, Collections.<String>emptyList());
            }
            else
            {
                getLogger().message(("Run only once behavior could not find file " + relTestFilePathStr + ", therefore it decided to continue with dependency checking"));
            }
        }

        try {
            final String ignoreFileContent = getRunnerParameters().getOrDefault("ignore_file", "");
            ignoreFileContent.replace("\"", "");
            final String ignoreFilePathStr = Paths.get(getCheckoutDirectory().toPath().toString(), engineBaseDir.toString(),".gitdepsignore").toString();
            final File ignoreFile = new File(ignoreFilePathStr);
            getLogger().message("Deleting old ignore file");
            FileUtil.delete(ignoreFile);

            if(!ignoreFileContent.isEmpty())
            {
                getLogger().message("Writing git dependencies ignore file to: " + ignoreFilePathStr);
                myFilesToDelete.add(ignoreFile);

                FileWriter ignoreFileWriter = new FileWriter(ignoreFilePathStr);
                ignoreFileWriter.write(ignoreFileContent);
                ignoreFileWriter.close();
            }
        } catch (IOException e) {
            getLogger().exception(e);
        }

        StringBuilder scriptContent = new StringBuilder(Exe.toString());

        if(cmdArgs.length() > 0)
        {
            scriptContent.append(' ');
            scriptContent.append(cmdArgs);
        }

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
    public void afterProcessFinished() throws RunBuildException {
        super.afterProcessFinished();
        for(File file : myFilesToDelete) {
            FileUtil.delete(file);
        }
        myFilesToDelete.clear();
    }
}
