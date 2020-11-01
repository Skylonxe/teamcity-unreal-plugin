package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public class Arg_Configuration extends ArgBase_Select {
    public Arg_Configuration() {
        friendlyName = "Configuration";
        description = "See Unreal Engine docs (Build Configurations Reference) for details.";

        for(UATRunnerConstants.UEBuildConfiguration v : UATRunnerConstants.UEBuildConfiguration.values())
        {
            options.add(v.name());
        }
    }
}
