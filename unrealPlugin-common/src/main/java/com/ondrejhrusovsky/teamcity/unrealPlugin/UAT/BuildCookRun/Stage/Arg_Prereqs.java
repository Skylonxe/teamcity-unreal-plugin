package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Stage;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;

import java.util.Map;

public class Arg_Prereqs extends ArgBase_Bool {
    public Arg_Prereqs()
    {
        friendlyName = "Include prerequisites";
        description = "???";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsTrue(params, "-prereqs");
    }
}
