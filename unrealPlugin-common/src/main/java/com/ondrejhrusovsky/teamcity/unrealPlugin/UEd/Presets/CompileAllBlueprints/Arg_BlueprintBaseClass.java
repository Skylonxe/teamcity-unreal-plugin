package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.CompileAllBlueprints;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_BlueprintBaseClass extends ArgBase_String {
    public Arg_BlueprintBaseClass() {
        friendlyName = "Blueprint Base Class";
        description = "Only blueprints derived from this class will be checked. Leave empty for no restriction. For example: Character";
        helpLinks.add("https://answers.unrealengine.com/questions/547069/asset-registry-get-all-assets-of-specific-class.html");
        advanced = false;
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsPresentAndNonEmpty(params, "-BlueprintBaseClass=" + params.get(toString()));
    }
}
