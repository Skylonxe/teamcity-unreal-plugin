package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_BoolMatrix;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.UATRunnerConstants;

import java.util.Map;

public class Arg_ClientTargetPlatform extends ArgBase_BoolMatrix {
    public Arg_ClientTargetPlatform() {
        friendlyName = "Target Platforms";
        description = "Client-side platforms on which your end product should run.";
        minWidth = 105;
        required = false;
        advanced = false;
        group = "Client";

        for(UATRunnerConstants.UETargetPlatform v : UATRunnerConstants.UETargetPlatform.values())
        {
            bools.add(v.name());
        }
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        final String allOptions = super.makeArgumentString(params);
        return allOptions.length() > 0 ? "-targetplatform=" + allOptions : "";
    }
}
