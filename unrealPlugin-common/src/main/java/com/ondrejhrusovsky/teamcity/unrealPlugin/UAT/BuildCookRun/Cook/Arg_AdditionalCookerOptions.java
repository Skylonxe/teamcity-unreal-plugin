package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_AdditionalCookerOptions extends ArgBase_String {
    public Arg_AdditionalCookerOptions() {
        friendlyName = "Additional Cook Options";
        description = "Allows you to pass additional custom commandline directly to the cooker.";
        defaultValue = "";
        group = "Process";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsPresent(params, "-AdditionalCookerOptions=\"" + params.get(toString()) + "\"");
    }
}
