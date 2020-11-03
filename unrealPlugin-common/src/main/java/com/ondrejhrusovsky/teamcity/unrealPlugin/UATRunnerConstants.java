package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public interface UATRunnerConstants {
    enum UETargetPlatform {
        Android,
        HTML5,
        HoloLens,
        IOS,
        Linux,
        Lumin,
        MPX,
        Mac,
        PS4,
        PS5,
        Quail,
        Switch,
        TvOS,
        UWP32,
        UWP64,
        Win32,
        Win64,
        WinAnvil,
        XboxOne,
        XboxOneAnvil
    }

    enum UEBuildConfiguration {
        Debug,
        DebugGame,
        Development,
        Shipping,
        Test
    }

    String RUNNER_TYPE = "UATRunnerType";
    String DISPLAY_NAME = "Unreal Automation Tool";
    String DESCRIPTION = "Runs Unreal's UAT program";

    String PRESET_KEY = "PRESET";

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

    public static UATPreset GetPresetByName(String Name)
    {
        for(UATPreset preset : UATRunnerConstants.PRESETS)
        {
            if(preset.toString().equals(Name))
            {
                return preset;
            }
        }
        return null;
    }
}
