package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class CmdPresetConstants extends CmdRunnerConstants {
    public String getPresetKey() { return "PRESET"; }
    public abstract List<CmdPreset> getPresets();

    public CmdPreset getPresetByName(String Name)
    {
        for(CmdPreset preset : getPresets())
        {
            if(preset.toString().equals(Name))
            {
                return preset;
            }
        }
        return null;
    }
}
