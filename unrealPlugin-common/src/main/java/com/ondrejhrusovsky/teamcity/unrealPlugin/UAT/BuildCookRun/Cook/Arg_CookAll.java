package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;

import java.util.Map;

public class Arg_CookAll extends ArgBase_Bool {
    public Arg_CookAll() {
        friendlyName = "Cook All Content";
        description = "If enabled, all content, even unreferenced assets will be cooked.";
        group = "Assets";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsTrue(params, "-CookAll");
    }
}
