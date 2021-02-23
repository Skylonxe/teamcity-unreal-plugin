package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Stage;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_Pak extends ArgBase_Bool {
    public Arg_Pak()
    {
        friendlyName = "Pak";
        description = "Creates joined pak archive files from asset instead of leaving them in file per asset format.";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-pak");
    }
}
