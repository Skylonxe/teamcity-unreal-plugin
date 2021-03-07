package com.ondrejhrusovsky.teamcity.unrealPlugin.PostBadgeStatus;

import com.ondrejhrusovsky.teamcity.unrealPlugin.Arg_EnginePath;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdArgument;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdRunnerConstants;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostBadgeStatusConstants extends CmdRunnerConstants {
    private static PostBadgeStatusConstants instance = null;

    private PostBadgeStatusConstants() {}
    public static PostBadgeStatusConstants get() { if(instance == null) instance = new PostBadgeStatusConstants(); return instance; }

    public String getRunnerType() {
        return "PostBadgeStatusRunnerType";
    }

    @Override
    public String getShortName() {
        return "PostBadgeStatus";
    }

    @Override
    public String getDisplayName() {
        return "Unreal Game Sync (Post Badge Status)";
    }

    @Override
    public String getDescription() {
        return "Updates badge status on the Unreal Game Sync's meta data server.";
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
