package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_BoolMatrix;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UnrealTypes;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_CookPlatform extends ArgBase_BoolMatrix {
    public Arg_CookPlatform() {
        friendlyName = "Platform";
        description = "Platform for which should we cook the content.";
        minWidth = 105;
        required = true;
        advanced = false;

        for(UnrealTypes.UECookTargetPlatform v : UnrealTypes.UECookTargetPlatform.values())
        {
            bools.add(v.name());
        }
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        final String allOptions = super.makeArgumentString(params, logger);
        return allOptions.length() > 0 ? "-targetplatform=" + allOptions : "";
    }
}