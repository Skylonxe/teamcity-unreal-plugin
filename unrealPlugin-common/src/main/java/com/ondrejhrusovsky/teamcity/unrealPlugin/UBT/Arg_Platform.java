package com.ondrejhrusovsky.teamcity.unrealPlugin.UBT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_BoolMatrix;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.UATRunnerConstants;

import java.util.Map;

public class Arg_Platform extends ArgBase_BoolMatrix {
    public Arg_Platform() {
        friendlyName = "Platform";
        description = "Platform for which should be code compiled.";
        minWidth = 105;
        required = false;
        advanced = false;

        for(UATRunnerConstants.UETargetPlatform v : UATRunnerConstants.UETargetPlatform.values())
        {
            bools.add(v.name());
        }
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        final String allOptions = super.makeArgumentString(params);
        return allOptions.length() > 0 ? allOptions : "";
    }
}