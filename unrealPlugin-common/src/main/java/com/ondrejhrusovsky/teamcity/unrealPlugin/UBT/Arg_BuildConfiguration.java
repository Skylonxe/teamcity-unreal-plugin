package com.ondrejhrusovsky.teamcity.unrealPlugin.UBT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_BuildConfiguration extends ArgBase_String {
    public Arg_BuildConfiguration() {
        friendlyName = "Build Configuration";
        description = "Examples: Development, Shipping, Debug";
        defaultValue = "Development";
        required = true;
        advanced = false;
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsPresent(params, params.get(toString()));
    }
}
