package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPreset;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.Arg_UProjectFile;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Arrays;
import java.util.Map;

public abstract class CmdPreset_BuildCookRun extends CmdPreset {
    CmdPreset_BuildCookRun()
    {
        super();
        arguments.addAll(Arrays.asList(
                new Arg_UProjectFile()
        ));
    }


    public String makeArgumentsString(Map<String, String> params, BuildProgressLogger logger) {
        StringBuilder result = new StringBuilder("BuildCookRun");

        final String arguments = super.makeArgumentsString(params, logger);
        if(arguments.length() > 0)
        {
            result.append(' ');
            result.append(arguments);
        }

        return result.toString();
    }
}
