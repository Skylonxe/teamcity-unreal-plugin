package com.ondrejhrusovsky.teamcity.unrealPlugin.UBT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;

import java.util.Map;

public class Arg_NoHotReload extends ArgBase_Bool {
    public Arg_NoHotReload()
    {
        friendlyName = "No HotReload";
        description = "???";
        defaultValue = "true";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsTrue(params, "-NoHotReload");
    }
}
