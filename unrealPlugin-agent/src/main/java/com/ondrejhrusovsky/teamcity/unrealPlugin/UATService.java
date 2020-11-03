package com.ondrejhrusovsky.teamcity.unrealPlugin;

import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.runner.BuildServiceAdapter;
import jetbrains.buildServer.agent.runner.ProgramCommandLine;
import jetbrains.buildServer.agent.runner.SimpleProgramCommandLine;
import jetbrains.buildServer.util.FileUtil;
import jetbrains.buildServer.util.TCStreamUtil;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UATService extends BuildServiceAdapter {

    private final Set<File> myFilesToDelete = new HashSet<File>();
    @NotNull
    @Override
    public ProgramCommandLine makeProgramCommandLine() throws RunBuildException {
        final Path engineBaseDir = Paths.get(getRunnerParameters().get(Arg_EnginePath.class.getSimpleName()));
        final Path RunUAT = UAT.GetRunUATPath(engineBaseDir);
        final String PresetName = getRunnerParameters().getOrDefault(UATRunnerConstants.PRESET_KEY, "");
        final UATPreset Preset = UATRunnerConstants.GetPresetByName(PresetName);
        final String UATArguments = Preset.makeArgumentsString(getRunnerParameters());
        final Path uprojectFile = Paths.get(getRunnerParameters().get(Arg_UProjectFile.class.getSimpleName()));

        StringBuilder scriptContent = new StringBuilder(RunUAT.toString());

        if(UATArguments.length() > 0)
        {
            scriptContent.append(' ');
            scriptContent.append(UATArguments);
        }

        if(uprojectFile.toString().length() > 0)
        {
            scriptContent.append(" -project=\"");
            scriptContent.append(uprojectFile);
            scriptContent.append('"');
        }

        getLogger().message("Runner Parameters: " + getRunnerParameters().toString());
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
