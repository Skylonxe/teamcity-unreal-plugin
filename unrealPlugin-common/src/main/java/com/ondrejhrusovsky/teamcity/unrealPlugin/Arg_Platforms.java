package com.ondrejhrusovsky.teamcity.unrealPlugin;

public class Arg_Platforms extends ArgBase_BoolMatrix {
    public Arg_Platforms() {
        friendlyName = "Target Platforms";
        description = "Platforms on which your end product should run.";
        minWidth = 105;
        required = true;

        for(UATRunnerConstants.UETargetPlatform v : UATRunnerConstants.UETargetPlatform.values())
        {
            bools.add(v.name());
        }
    }
}
