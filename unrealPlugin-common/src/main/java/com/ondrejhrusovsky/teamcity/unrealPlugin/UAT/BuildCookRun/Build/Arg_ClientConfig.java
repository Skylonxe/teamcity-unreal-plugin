package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Build;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Select;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UATRunnerConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Arg_ClientConfig extends ArgBase_Select {
    public Arg_ClientConfig() {
        friendlyName = "Client Configuration";
        description = "Specifies compiler build configuration for the target client-side application. Usually it is tradeoff between ease of debugging and performance optimization.";

        for(UATRunnerConstants.UEBuildConfiguration v : UATRunnerConstants.UEBuildConfiguration.values())
        {
            options.add(v.name());
        }
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsPresent(params, "-clientconfig=" + params.get(toString()));
    }

    // -client / -noclient(?)
}