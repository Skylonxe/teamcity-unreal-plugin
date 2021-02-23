package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_WarningsAsErrors extends ArgBase_Bool {
    public Arg_WarningsAsErrors()
    {
        friendlyName = "Warnings as Errors";
        description = "Step will fail if warning happens during the process.";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-WarningsAsErrors");
    }
}
