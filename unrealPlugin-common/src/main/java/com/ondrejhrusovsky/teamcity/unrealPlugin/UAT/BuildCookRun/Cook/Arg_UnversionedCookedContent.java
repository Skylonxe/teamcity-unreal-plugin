package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;

import java.util.Map;

public class Arg_UnversionedCookedContent extends ArgBase_Bool {
    public Arg_UnversionedCookedContent()
    {
        friendlyName = "Unversioned Content";
        description = "Cooked assets will not have engine versioned stored and can be then loaded by any engine version (even uncompatible one).";
        group = "Assets";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsTrue(params, "-unversionedcookedcontent");
    }
}
