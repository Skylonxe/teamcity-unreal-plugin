package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_Compile extends ArgBase_Bool {
    public Arg_Compile()
    {
        friendlyName = "Compile";
        description = "???";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-compile");
    }
}
