package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_BoolMatrix;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.UATRunnerConstants;

import java.util.Map;

public class Arg_ServerTargetPlatform extends ArgBase_BoolMatrix {
    public Arg_ServerTargetPlatform() {
        friendlyName = "Server Target Platforms";
        description = "Server-side platforms on which your dedicated server should run.";
        group = "Server";
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
        return allOptions.length() > 0 ? "-ServerPlatform=" + allOptions : "";
    }
}