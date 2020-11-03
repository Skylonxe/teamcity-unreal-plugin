package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Arg_Configuration extends ArgBase_Select {
    public Arg_Configuration() {
        friendlyName = "Configuration";
        description = "See Unreal Engine docs (Build Configurations Reference) for details.";

        for(UATRunnerConstants.UEBuildConfiguration v : UATRunnerConstants.UEBuildConfiguration.values())
        {
            options.add(v.name());
        }
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsPresent(params, "-clientconfig=" + params.get(toString()));
    }
}
