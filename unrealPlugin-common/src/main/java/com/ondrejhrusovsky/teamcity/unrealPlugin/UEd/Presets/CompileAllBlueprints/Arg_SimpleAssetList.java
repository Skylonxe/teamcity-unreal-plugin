package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.CompileAllBlueprints;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_SimpleAssetList extends ArgBase_Bool {
    public Arg_SimpleAssetList()
    {
        friendlyName = "List Assets";
        description = "If enabled, besides listing all errors and warnings, task will also add simple list of all assets causing problems.";
        defaultValue = "false";
        advanced = false;
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-SimpleAssetList");
    }
}
