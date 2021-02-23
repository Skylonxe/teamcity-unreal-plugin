package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_Compressed extends ArgBase_Bool {
    public Arg_Compressed()
    {
        friendlyName = "Compress";
        description = "Produces smaller output which then will be uncompressed into memory when loaded.";
        group = "Assets";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-compressed");
    }
}
