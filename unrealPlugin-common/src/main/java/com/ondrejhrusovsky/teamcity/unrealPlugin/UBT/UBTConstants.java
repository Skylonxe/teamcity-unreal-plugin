package com.ondrejhrusovsky.teamcity.unrealPlugin.UBT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdArgument;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdRunnerConstants;
import com.ondrejhrusovsky.teamcity.unrealPlugin.Arg_EnginePath;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class UBTConstants extends CmdRunnerConstants {
    private static UBTConstants instance = null;

    private UBTConstants() {}
    public static UBTConstants get() { if(instance == null) instance = new UBTConstants(); return instance; }

    public String getRunnerType() {
        return "UBTRunnerType";
    }

    @Override
    public String getShortName() {
        return "UBT";
    }

    @Override
    public String getDisplayName() {
        return "Unreal Build Tool";
    }

    @Override
    public String getDescription() {
        return "Runs Unreal's custom C++ compilation tool";
    }

    @Override
    public List<CmdArgument> getGlobalArguments() {
        return new ArrayList<CmdArgument>(Arrays.asList(
                new Arg_EnginePath(),
                new Arg_BuildTarget(),
                new Arg_Platform(),
                new Arg_BuildConfiguration(),
                new Arg_NoUBTMakefiles(),
                new Arg_NoBuildUHT(),
                new Arg_Manifest(),
                new Arg_NoHotReload()
        ));
    }

    @Override
    public Path getExePath(Path EngineRootFolder) {
        return Paths.get(EngineRootFolder.toString(),"Engine\\Binaries\\DotNET\\UnrealBuildTool.exe");
    }
}
