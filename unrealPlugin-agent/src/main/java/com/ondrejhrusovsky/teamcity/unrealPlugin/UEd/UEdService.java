package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd;

import com.ondrejhrusovsky.teamcity.unrealPlugin.Arg_EnginePath;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPreset;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.*;
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

public class UEdService extends BuildServiceAdapter {
    UEdConstants constants;

    private final Set<File> myFilesToDelete = new HashSet<File>();
    @NotNull
    @Override
    public ProgramCommandLine makeProgramCommandLine() throws RunBuildException {
        getLogger().message("Input runner parameters: " + getRunnerParameters().toString());
        constants = UEdConstants.get();

        final String PresetName = getRunnerParameters().getOrDefault(constants.getPresetKey(), "");
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
        final Path uprojectFile = Paths.get(relevantRunnerParameters.getOrDefault(Arg_UProjectFile.class.getSimpleName(), ""));

        final Path Exe = constants.getExePath(engineBaseDir);
        final CmdPreset Preset = constants.getPresetByName(PresetName);
        final String presetArgumentsString = Preset.makeArgumentsString(relevantRunnerParameters);

        StringBuilder fullCommandLineToRun = new StringBuilder(Exe.toString());

        if(presetArgumentsString.length() > 0)
        {
            fullCommandLineToRun.append(' ');
            fullCommandLineToRun.append(presetArgumentsString);
        }

        /*if(uprojectFile.toString().length() > 0)
        {
            scriptContent.append(" -project=\"");
            scriptContent.append(uprojectFile);
            scriptContent.append('"');
        }*/

        getLogger().message("Prepared command line: " + fullCommandLineToRun);

        final String script = getCustomScript(fullCommandLineToRun.toString());
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
