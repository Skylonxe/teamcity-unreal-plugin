package com.ondrejhrusovsky.teamcity.unrealPlugin.UBT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;

import java.util.Map;

public class Arg_NoBuildUHT extends ArgBase_Bool {
    public Arg_NoBuildUHT()
    {
        friendlyName = "No Build UHT";
        description = "???";
        defaultValue = "true";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsTrue(params, "-NoBuildUHT");
    }
}