package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildGraph;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_StringList;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Arrays;
import java.util.Map;

public class Arg_BuildGraph_Options extends ArgBase_StringList {
    public Arg_BuildGraph_Options()
    {
        friendlyName = "Script Options";
        description = "Custom parameters which will be send to the BuildGraph script. These are translated into -Set commandline arguments.\n" +
                "Use Key=Value format and separate parameters by newline.";
        helpLinks = Arrays.asList("https://docs.unrealengine.com/en-US/Programming/BuildTools/AutomationTool/BuildGraph/Usage/index.html");
        commandSeparator = " -Set:";
        advanced = false;
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsPresentAndNonEmpty(params, "-Set:" + super.makeArgumentString(params, logger));
    }
}
