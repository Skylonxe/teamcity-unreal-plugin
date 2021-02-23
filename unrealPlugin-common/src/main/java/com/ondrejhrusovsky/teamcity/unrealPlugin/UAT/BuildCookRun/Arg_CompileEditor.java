package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_CompileEditor extends ArgBase_Bool {
    public Arg_CompileEditor()
    {
        friendlyName = "Compile Editor";
        description = "???";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-compileeditor");
    }
}
