package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Stage;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;

import java.util.Map;

public class Arg_CreateChunkInstall extends ArgBase_Bool {
    Arg_CreateChunkInstall()
    {
        friendlyName = "Create Chunk Install";
        description = "???";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsTrue(params, "-createchunkinstall");
    }
}
