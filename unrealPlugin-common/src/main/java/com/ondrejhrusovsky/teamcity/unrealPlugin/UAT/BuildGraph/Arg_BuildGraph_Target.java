package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildGraph;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_BuildGraph_Target extends ArgBase_String {
    public Arg_BuildGraph_Target() {
        friendlyName = "Target";
        description = "Name of the node or named output which we want to execute from the .xml script. BuildGraph will then automatically prepare all its dependencies specified by the script.\n" +
                "Example from built-in example script BuildEditorAndTools.xml: Submit To Perforce For UGS";
        defaultValue = "";
        helpLinks.add("https://docs.unrealengine.com/en-US/Programming/BuildTools/AutomationTool/BuildGraph/Usage/index.html");
        required = true;
        advanced = false;
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsPresentAndNonEmpty(params, "-Target=\"" + params.get(toString()) + "\"");
    }
}
