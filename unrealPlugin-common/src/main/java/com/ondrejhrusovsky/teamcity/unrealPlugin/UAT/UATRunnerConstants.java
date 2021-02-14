package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdArgument;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPreset;
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

    ArrayList<CmdPreset> PRESETS = new ArrayList<CmdPreset>(Arrays.asList(
            new CmdPreset_BuildGraph(),
            new CmdPreset_Compile(),
            new CmdPreset_Build(),
            new CmdPreset_Cook(),
            new CmdPreset_Stage(),
            new CmdPreset_Package(),
            new CmdPreset_Custom()
    ));

    public static CmdPreset GetPresetByName(String Name)
    {
        for(CmdPreset preset : UATRunnerConstants.PRESETS)
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
