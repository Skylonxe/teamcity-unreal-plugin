package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.Map;

public class Arg_Clean extends ArgBase_Bool {
    Arg_Clean()
    {
        friendlyName = "Clean";
        description = "Deletes task files from previous run and starts from scratch instead of processing only changed files.";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsTrue(params, "-clean");
    }
}
