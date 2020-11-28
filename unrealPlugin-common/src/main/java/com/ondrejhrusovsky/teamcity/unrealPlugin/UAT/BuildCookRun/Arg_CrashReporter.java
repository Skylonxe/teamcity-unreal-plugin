package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;

import java.util.Map;

public class Arg_CrashReporter extends ArgBase_Bool {
    public Arg_CrashReporter()
    {
        friendlyName = "Include crash reporter";
        description = "???";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsTrue(params, "-CrashReporter");
    }
}
