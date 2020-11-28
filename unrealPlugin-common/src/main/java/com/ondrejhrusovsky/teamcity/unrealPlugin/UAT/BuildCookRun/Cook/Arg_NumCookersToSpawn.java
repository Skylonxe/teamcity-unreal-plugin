package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;

import java.util.Map;

public class Arg_NumCookersToSpawn extends ArgBase_String {
    public Arg_NumCookersToSpawn() {
        friendlyName = "Number of Cookers To Spawn";
        description = "Specifies number of parallel processes which should be launched for the cooking.";
        group = "Process";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsPresentAndNonEmpty(params, "-NumCookersToSpawn=" + params.getOrDefault(toString(), ""));
    }
}
