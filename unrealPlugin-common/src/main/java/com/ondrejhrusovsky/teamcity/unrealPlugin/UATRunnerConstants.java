package com.ondrejhrusovsky.teamcity.unrealPlugin;

import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.*;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Arg_Compile;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Arg_CompileEditor;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Arg_Ini;

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

    enum UECookTargetPlatform {
        Android,
        IOS,
        PS4,
        LinuxServer,
        WindowsServer,
        WindowsNoEditor,
        XboxOne
    }

    enum UECookFlavors {
        DXT,
        ASTC,
        ETC2
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
    String DESCRIPTION = "Runs Unreal's multi-purpose automation tool.";

    String PRESET_KEY = "PRESET";

    ArrayList<CmdArgument> Arguments = new ArrayList<CmdArgument>(Arrays.asList(
            new Arg_EnginePath(),
            new Arg_WarningsAsErrors(),
            new Arg_Compile(),
            new Arg_CompileEditor(),
            new Arg_Ini()
    ));

    ArrayList<UATPreset> PRESETS = new ArrayList<UATPreset>(Arrays.asList(
            new UATPreset_BuildGraph(),
            new UATPreset_Compile(),
            new UATPreset_Build(),
            new UATPreset_Cook(),
            new UATPreset_Stage(),
            new UATPreset_Package(),
            new UATPreset_Custom()
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

    public static Path GetRunUATPath(Path BaseEngine)
    {
        return Paths.get(BaseEngine.toString(),"Engine\\Build\\BatchFiles\\RunUAT.bat");
    }
}
