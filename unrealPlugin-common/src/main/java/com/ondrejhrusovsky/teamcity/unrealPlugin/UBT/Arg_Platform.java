package com.ondrejhrusovsky.teamcity.unrealPlugin.UBT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_BoolMatrix;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UnrealTypes;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_Platform extends ArgBase_BoolMatrix {
    public Arg_Platform() {
        friendlyName = "Platform";
        description = "Platform for which should be code compiled.";
        minWidth = 105;
        required = false;
        advanced = false;

        for(UnrealTypes.UETargetPlatform v : UnrealTypes.UETargetPlatform.values())
        {
            bools.add(v.name());
        }
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        final String allOptions = super.makeArgumentString(params, logger);
        return allOptions.length() > 0 ? allOptions : "";
    }
}