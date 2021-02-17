package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.nio.file.Path;
import java.util.List;

public abstract class CmdRunnerConstants {
    public abstract String getShortName();
    public String getRunnerType() { return this.getClass().getSimpleName(); }
    public abstract  String getDisplayName();
    public abstract String getDescription();
    public abstract List<CmdArgument> getGlobalArguments();
    public abstract Path getExePath(Path EngineRootFolder);
}
