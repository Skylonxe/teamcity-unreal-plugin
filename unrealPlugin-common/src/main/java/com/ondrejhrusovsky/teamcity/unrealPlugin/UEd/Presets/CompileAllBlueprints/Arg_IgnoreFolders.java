package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.CompileAllBlueprints;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_StringList;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Arrays;
import java.util.Map;

public class Arg_IgnoreFolders extends ArgBase_StringList {
    public Arg_IgnoreFolders()
    {
        friendlyName = "Ignored Folders";
        description = "These folders will be excluded from checking. Specify one folder per line.";
        commandSeparator = ",";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsPresentAndNonEmpty(params, "-IgnoreFolders=" + super.makeArgumentString(params, logger));
    }
}
