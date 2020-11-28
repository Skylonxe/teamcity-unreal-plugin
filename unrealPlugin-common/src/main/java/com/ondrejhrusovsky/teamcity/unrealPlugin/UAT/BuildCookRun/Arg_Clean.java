package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;

import java.util.Map;

public class Arg_Clean extends ArgBase_Bool {
    public Arg_Clean()
    {
        friendlyName = "Clean";
        description = "Deletes files produced by previous run and starts from scratch instead of having a potential to process only changed files.";
        group = "Process";
        advanced = false;
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsTrue(params, "-clean");
    }
}
