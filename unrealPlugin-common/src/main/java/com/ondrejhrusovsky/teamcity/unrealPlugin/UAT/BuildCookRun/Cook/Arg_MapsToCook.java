package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_StringList;

import java.util.Arrays;
import java.util.Map;

public class Arg_MapsToCook extends ArgBase_StringList {
    public Arg_MapsToCook()
    {
        friendlyName = "Maps to cook";
        description = "List of maps which should be cooked together with their referenced assets. If empty, maps from Project Settings are used.";
        helpLinks = Arrays.asList("https://bebylon.dev/ue4guide/packaging-cooking/selecting-maps-to-cook/");
        group = "Assets";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsPresentAndNonEmpty(params, "-MapsToCook=" + super.makeArgumentString(params));
    }
}
