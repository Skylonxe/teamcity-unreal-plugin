package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_CookMapsOnly extends ArgBase_Bool {
    public Arg_CookMapsOnly() {
        friendlyName = "Cook Only Maps";
        description = "If Cook All Content is enabled, we can restrict it to cooking only all maps and assets referenced by these maps.";
        group = "Assets";
        hasParent = true;
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params,"-CookMapsOnly");
    }
}
