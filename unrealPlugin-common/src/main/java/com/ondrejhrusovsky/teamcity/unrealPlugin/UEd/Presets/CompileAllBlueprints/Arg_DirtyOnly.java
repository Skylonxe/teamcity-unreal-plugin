package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.CompileAllBlueprints;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_DirtyOnly extends ArgBase_Bool {
    public Arg_DirtyOnly()
    {
        friendlyName = "Dirty Only";
        description = "If enabled, only unsaved assets will be checked. This might not make sense when running on the build machine because there are usually no unsaved changes.";
        defaultValue = "false";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-DirtyOnly");
    }
}
