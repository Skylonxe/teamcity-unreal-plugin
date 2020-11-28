package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;

import java.util.Map;

public class Arg_CookPartialGC extends ArgBase_Bool {
    public Arg_CookPartialGC() {
        friendlyName = "Partial GC";
        description = "While cooking clean up memory as we go along rather then cleaning everything (and potentially having to reload some of it) when we run out of space.\n"
                + "Can improve cook times.";
        group = "Cook Time Optimization";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsTrue(params, "-CookPartialGC");
    }
}
