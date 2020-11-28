package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;

import java.util.Map;

public class Arg_UTF8Output extends ArgBase_Bool {
    public Arg_UTF8Output()
    {
        friendlyName = "UTF8 Output";
        description = "???";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsTrue(params, "-utf8output");
    }
}
