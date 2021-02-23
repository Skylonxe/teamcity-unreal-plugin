package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_IgnoreCookErrors extends ArgBase_Bool {
    public Arg_IgnoreCookErrors() {
        friendlyName = "Ignore Errors";
        description = "Ignore errors which happen while cooking.";
        longDescription = "Can be observed in logs when errors happen and following log is printed:\n" +
                "Ignoring cook failure.\n" +
                "instead of:\n" +
                "Cook failed.";
        advanced = false;
        group = "Process";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-IgnoreCookErrors");
    }
}

