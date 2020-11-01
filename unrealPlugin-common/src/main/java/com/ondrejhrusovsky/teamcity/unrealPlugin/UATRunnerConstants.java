package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public interface UATRunnerConstants {
    enum UETargetPlatform {
        ANDROID,
        HOLOLENS,
        HTML5,
        IOS,
        LINUX,
        LUMIN,
        MAC,
        PS4,
        QUAIL,
        SWITCH,
        TVOS,
        UWP32,
        UWP64,
        XBOXONE,
        WIN32,
        WIN64,
        WINANVIL,
        XBOXONEANVIL,
        PS5,
        MPX
    }

    enum UEBuildConfiguration {
        DEBUG,
        DEBUGGAME,
        DEVELOPMENT,
        SHIPPING,
        TEST
    }

    String RUNNER_TYPE = "UATRunnerType";
    String DISPLAY_NAME = "Unreal Automation Tool";
    String DESCRIPTION = "Runs Unreal's UAT program";

    String PRESET_KEY = "PRESET_A_KEY";

    ArrayList<UATArgument> Arguments = new ArrayList<UATArgument>(Arrays.asList(
            new Arg_EnginePath(),
            new Arg_UProjectFile(),
            new Arg_WarningsAsErrors()
    ));

    ArrayList<UATPreset> PRESETS = new ArrayList<UATPreset>(Arrays.asList(
            new UATPreset_Compile(),
            new UATPreset_Build(),
            new UATPreset_Cook(),
            new UATPreset_Stage(),
            new UATPreset_Package()
    ));
}
