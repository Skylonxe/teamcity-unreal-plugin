package com.ondrejhrusovsky.teamcity.unrealPlugin.UBT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_NoBuildUHT extends ArgBase_Bool {
    public Arg_NoBuildUHT()
    {
        friendlyName = "No Build UHT";
        description = "If enabled, UBT will skip building Unreal Header Tool (UHT) first. It will expect UHT was already built and is available." +
                "UHT is tool which allows compilation of Unreal's customized C++ code.";
        defaultValue = "false";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-NoBuildUHT");
    }
}
