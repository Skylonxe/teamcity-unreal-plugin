package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildGraph;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;

import java.util.Map;

public class Arg_BuildGraph_Script extends ArgBase_String {
    public Arg_BuildGraph_Script() {
        allowPickFromVCS = true;
        friendlyName = "Script (.xml)";
        description = "For example: %env.unreal.engine.dir%\\Engine\\Build\\Graph\\Examples\\BuildEditorAndTools.xml";
        defaultValue = "%env.unreal.engine.dir%\\Engine\\Build\\Graph\\";
        helpLinks.add("https://docs.unrealengine.com/en-US/Programming/BuildTools/AutomationTool/BuildGraph/index.html");
        required = true;
        advanced = false;
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsPresentAndNonEmpty(params, "-Script=\"" + params.get(toString()) + "\"");
    }
}
