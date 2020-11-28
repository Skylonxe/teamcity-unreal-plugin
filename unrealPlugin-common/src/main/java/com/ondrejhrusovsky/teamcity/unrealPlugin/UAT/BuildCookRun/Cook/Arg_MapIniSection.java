package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;

import java.util.Arrays;
import java.util.Map;

public class Arg_MapIniSection extends ArgBase_String {
    public Arg_MapIniSection() {
        allowPickFromVCS = false;
        friendlyName = "Maps .ini section";
        description = "Cook maps listed in the specified ini section.";
        defaultValue = "";
        required = false;
        group = "Assets";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsPresent(params, "-MapIniSectionsToCook=" + params.getOrDefault(toString(), ""));
    }
}
