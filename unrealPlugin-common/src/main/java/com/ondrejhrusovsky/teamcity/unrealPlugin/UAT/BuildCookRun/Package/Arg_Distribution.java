package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Package;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_Distribution extends ArgBase_Bool {
    public Arg_Distribution()
    {
        friendlyName = "For Distribution";
        description = "???";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-distribution");
    }
}
