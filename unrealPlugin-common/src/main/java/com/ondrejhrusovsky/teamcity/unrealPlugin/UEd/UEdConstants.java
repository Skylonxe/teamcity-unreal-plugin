package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd;

import com.ondrejhrusovsky.teamcity.unrealPlugin.Arg_EnginePath;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdArgument;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPreset;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPresetConstants;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.CompileAllBlueprints.Preset_CompileAllBlueprints;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.Cook.Preset_Cook;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

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
        return new ArrayList<CmdArgument>(
                asList(new Arg_EnginePath())
        );
    }

    @Override
    public List<CmdPreset> getPresets() {
        return new ArrayList<>(
                asList(
                        new Preset_Cook(),
                        new Preset_CompileAllBlueprints()
                )
        );
    }

    @Override
    public Path getExePath(Path EngineRootFolder) {
        return Paths.get(EngineRootFolder.toString(),"Engine\\Binaries\\Win64\\UE4Editor-Cmd.exe");
    }
}
