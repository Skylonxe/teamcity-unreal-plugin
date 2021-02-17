package com.ondrejhrusovsky.teamcity.unrealPlugin;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;

import java.util.Map;

public class Arg_EnginePath extends ArgBase_String {
    public Arg_EnginePath() {
        allowPickFromVCS = true;
        friendlyName = "Engine Root Dir";
        description = "For example: C:\\Program Files (x86)\\Epic Games\\UE_4.25";
        defaultValue = "%env.unreal.engine.dir%";
        required = true;
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return "";
    }
}
