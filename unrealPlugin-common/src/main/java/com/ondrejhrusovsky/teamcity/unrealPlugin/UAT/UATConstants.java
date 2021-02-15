package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdArgument;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPreset;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPresetConstants;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Arg_Compile;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Arg_CompileEditor;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Arg_Ini;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UBT.UBTConstants;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UATConstants extends CmdPresetConstants {
    private static UATConstants instance = null;

    private UATConstants() {}
    public static UATConstants get() { if(instance == null) instance = new UATConstants(); return instance; }

    @Override
    public List<CmdPreset> getPresets() {
        return new ArrayList<CmdPreset>(Arrays.asList(
                new CmdPreset_BuildGraph(),
                new CmdPreset_Compile(),
                new CmdPreset_Build(),
                new CmdPreset_Cook(),
                new CmdPreset_Stage(),
                new CmdPreset_Package(),
                new CmdPreset_Custom()
        ));
    }

    @Override
    public String getRunnerType() {
        return "UATRunnerType";
    }

    @Override
    public String getShortName() {
        return "UAT";
    }

    @Override
    public String getDisplayName() {
        return "Unreal Automation Tool";
    }

    @Override
    public String getDescription() {
        return "Runs Unreal's multi-purpose automation tool.";
    }

    @Override
    public List<CmdArgument> getGlobalArguments() {
        return new ArrayList<CmdArgument>(Arrays.asList(
                new Arg_EnginePath(),
                new Arg_WarningsAsErrors(),
                new Arg_Compile(),
                new Arg_CompileEditor(),
                new Arg_Ini()
        ));
    }

    @Override
    public Path GetExePath(Path EngineRootFolder) {
        return Paths.get(EngineRootFolder.toString(),"Engine\\Build\\BatchFiles\\RunUAT.bat");
    }
}
