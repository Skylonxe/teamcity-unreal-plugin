package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_P4 extends ArgBase_Bool
{
    public Arg_P4()
    {
        friendlyName = "Perforce";
        description = "???";
        defaultValue = "true";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-nop4") + IfArgIsFalse(params, "-p4");
    }
}
