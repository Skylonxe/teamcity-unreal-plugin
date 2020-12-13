package com.ondrejhrusovsky.teamcity.unrealPlugin.UBT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;

import java.util.Map;

public class Arg_BuildTarget extends ArgBase_String {
    public Arg_BuildTarget() {
        friendlyName = "Build Target";
        description = "Examples: MyGameName, MyGameNameEditor, UnrealHeaderTool";
        defaultValue = "";
        required = true;
        advanced = false;
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsPresent(params, params.get(toString()));
    }
}