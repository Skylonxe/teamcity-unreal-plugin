package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.Custom;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;

import java.util.Map;

public class Arg_Custom_Command extends ArgBase_String {
    public Arg_Custom_Command() {
        friendlyName = "Command";
        description = "Command line arguments passed to the UAT.";
        defaultValue = "";
        required = false;
        advanced = false;
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsPresent(params, params.get(toString()));
    }
}
