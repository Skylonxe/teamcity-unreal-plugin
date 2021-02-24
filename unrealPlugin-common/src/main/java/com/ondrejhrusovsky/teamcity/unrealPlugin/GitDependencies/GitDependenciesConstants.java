package com.ondrejhrusovsky.teamcity.unrealPlugin.GitDependencies;

import com.ondrejhrusovsky.teamcity.unrealPlugin.Arg_EnginePath;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdArgument;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdRunnerConstants;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GitDependenciesConstants extends CmdRunnerConstants {
    private static GitDependenciesConstants instance = null;

    private GitDependenciesConstants() {}
    public static GitDependenciesConstants get() { if(instance == null) instance = new GitDependenciesConstants(); return instance; }

    public String getRunnerType() {
        return "GitDependenciesRunnerType";
    }

    @Override
    public String getShortName() {
        return "GitDependencies";
    }

    @Override
    public String getDisplayName() {
        return "Unreal Git Dependencies";
    }

    @Override
    public String getDescription() {
        return "Runs Unreal's GitDependencies tool to download binary files for the GitHub source distribution of the engine. Similar to running Setup.bat file manually.";
    }

    @Override
    public List<CmdArgument> getGlobalArguments() {
        return new ArrayList<CmdArgument>(Arrays.asList(
                new Arg_EnginePath()
        ));
    }

    @Override
    public Path getExePath(Path EngineRootFolder) {
        return Paths.get(EngineRootFolder.toString(),"Engine\\Binaries\\DotNET\\GitDependencies.exe");
    }
}
