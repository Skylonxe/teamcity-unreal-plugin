package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class CmdPresetConstants {
    public abstract String getShortName();
    public String getRunnerType() { return this.getClass().getSimpleName(); }
    public abstract  String getDisplayName();
    public abstract String getDescription();
    public String getPresetKey() { return "PRESET_KEY"; }
    public abstract List<CmdArgument> getGlobalArguments();
    public abstract List<CmdPreset> getPresets();
    public abstract Path GetExePath(Path EngineRootFolder);
}
