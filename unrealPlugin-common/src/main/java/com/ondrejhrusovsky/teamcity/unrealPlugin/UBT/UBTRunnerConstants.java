package com.ondrejhrusovsky.teamcity.unrealPlugin.UBT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdArgument;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.Arg_EnginePath;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public interface UBTRunnerConstants {
    String RUNNER_TYPE = "UBTRunnerType";
    String DISPLAY_NAME = "Unreal Build Tool";
    String DESCRIPTION = "Runs Unreal's custom C++ compilation tool";

    ArrayList<CmdArgument> Arguments = new ArrayList<CmdArgument>(Arrays.asList(
            new Arg_EnginePath(),
            new Arg_BuildTarget(),
            new Arg_Platform(),
            new Arg_BuildConfiguration(),
            new Arg_NoUBTMakefiles(),
            new Arg_NoBuildUHT(),
            new Arg_Manifest(),
            new Arg_NoHotReload()
    ));

    public static Path GetUBTExePath(Path BaseEngine)
    {
        return Paths.get(BaseEngine.toString(),"Engine\\Binaries\\DotNET\\UnrealBuildTool.exe");
    }
}
