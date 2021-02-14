package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPreset;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildGraph.Arg_BuildGraph_Options;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildGraph.Arg_BuildGraph_Script;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildGraph.Arg_BuildGraph_Target;

import java.util.Arrays;
import java.util.Map;

public class CmdPreset_BuildGraph extends CmdPreset {
    CmdPreset_BuildGraph()
    {
        super();
        friendlyName = "BuildGraph";
        description = "Runs script of Unreal's built-in automation system";

        arguments.addAll(Arrays.asList(
                new Arg_BuildGraph_Script(),
                new Arg_BuildGraph_Target(),
                new Arg_BuildGraph_Options()
        ));

        sortArguments(arguments);
    }

    @Override
    public String makeArgumentsString(Map<String, String> params) {
        StringBuilder result = new StringBuilder("BuildGraph " + super.makeArgumentsString(params));
        return result.toString();
    }
}
