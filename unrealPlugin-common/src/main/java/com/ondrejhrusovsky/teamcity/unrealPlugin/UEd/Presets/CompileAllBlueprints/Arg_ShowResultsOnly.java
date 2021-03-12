package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.CompileAllBlueprints;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_ShowResultsOnly extends ArgBase_Bool {
    public Arg_ShowResultsOnly()
    {
        friendlyName = "Show Results Only";
        description = "If enabled, there will be no process log and task will output only resulting list of warnings and errors when it is finished.";
        defaultValue = "false";
        advanced = false;
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-ShowResultsOnly");
    }
}
