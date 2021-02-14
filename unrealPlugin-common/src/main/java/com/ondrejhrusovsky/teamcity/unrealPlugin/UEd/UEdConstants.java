package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdArgument;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPreset;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPresetConstants;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.Arg_EnginePath;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.Arg_WarningsAsErrors;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Arg_Compile;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.CmdPreset_BuildGraph;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.CmdPreset_Compile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UEdConstants extends CmdPresetConstants {
    private static UEdConstants instance = null;

    private UEdConstants() {}
    public static UEdConstants get() { if(instance == null) instance = new UEdConstants(); return instance; }

    @Override
    public String getShortName() {
        return "UEd";
    }

    @Override
    public String getDisplayName() {
        return "Unreal Editor";
    }

    @Override
    public String getDescription() {
        return "Runs Unreal Editor instance.";
    }

    @Override
    public List<CmdArgument> getGlobalArguments() {
        return new ArrayList<>();
    }

    @Override
    public List<CmdPreset> getPresets() {
        return new ArrayList<>();
    }

    @Override
    public Path GetExePath(Path EngineRootFolder) {
        return Paths.get(EngineRootFolder.toString(),"Engine\\Binaries\\Win64\\UE4Editor-Cmd.exe");
    }
}
