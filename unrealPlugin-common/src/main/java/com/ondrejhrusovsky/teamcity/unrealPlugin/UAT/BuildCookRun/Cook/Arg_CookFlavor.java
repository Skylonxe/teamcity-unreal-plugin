package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_BoolMatrix;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UnrealTypes;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_CookFlavor extends ArgBase_BoolMatrix {
    public Arg_CookFlavor() {
        friendlyName = "Flavors";
        description = "Usually used only to specify texture compression format for Android.";
        minWidth = 105;
        required = false;
        advanced = false;
        group = "Assets";

        for(UnrealTypes.UECookFlavors v : UnrealTypes.UECookFlavors.values())
        {
            bools.add(v.name());
        }
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        String allOptions = super.makeArgumentString(params, logger);
        return allOptions.length() > 0 ? "-cookflavor=" + allOptions.toString() : "";
    }
}
