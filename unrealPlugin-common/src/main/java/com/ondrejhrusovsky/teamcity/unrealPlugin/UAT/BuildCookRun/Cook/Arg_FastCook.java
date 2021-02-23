package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_FastCook extends ArgBase_Bool {
    public Arg_FastCook() {
        friendlyName = "Fast Cook";
        description = "Flag which will be sent to the engine and can be optionally utilized by its individual systems. It is telling it to focus on shorter cook times rather than other metrics like runtime performance.\n" +
                "By default this is used mostly by PhysX to sacrifice some game runtime performance for faster cook times. Useful for quick smoke checks on build machine (e.g. during the day).";
        advanced = false;
        group = "Cook Time Optimization";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-FastCook");
    }
}
