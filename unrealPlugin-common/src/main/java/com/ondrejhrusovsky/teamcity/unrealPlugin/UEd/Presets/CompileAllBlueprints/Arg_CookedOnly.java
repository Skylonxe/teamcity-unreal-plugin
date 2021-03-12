package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.CompileAllBlueprints;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_CookedOnly extends ArgBase_Bool {
    public Arg_CookedOnly()
    {
        friendlyName = "Cooked Only";
        description = "If enabled, only cooked assets will be checked.";
        defaultValue = "false";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-CookedOnly");
    }
}
