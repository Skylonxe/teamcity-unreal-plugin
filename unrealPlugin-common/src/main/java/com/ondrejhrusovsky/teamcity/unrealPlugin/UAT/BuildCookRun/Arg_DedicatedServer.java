package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;

import java.util.Map;

public class Arg_DedicatedServer extends ArgBase_Bool {
    public Arg_DedicatedServer() {
        friendlyName = "Dedicated Server";
        description = "If enabled, data necessary for dedicated server application will be produced.";
        advanced = false;
        group = "Server";
        helpLinks.add("https://docs.unrealengine.com/en-US/Programming/UnrealBuildSystem/TargetFiles/index.html");
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsTrue(params, "-DedicatedServer");
    }
}
