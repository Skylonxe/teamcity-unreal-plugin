package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdArgument;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.*;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Build.*;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook.*;
import com.ondrejhrusovsky.teamcity.unrealPlugin.Util;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class CmdPreset_Build extends CmdPreset_BuildCookRun {
    CmdPreset_Build()
    {
        friendlyName = "Build (C++)";
        arguments.addAll(new ArrayList<CmdArgument>(Arrays.asList(
                new Arg_Clean(),
                new Arg_ClientConfig(),
                new Arg_ClientTargetPlatform(),

                new Arg_ServerConfig(),
                new Arg_ServerTargetPlatform()
        )));
    }

    @Override
    public String makeArgumentsString(Map<String, String> params, BuildProgressLogger logger) {
        StringBuilder result = new StringBuilder(super.makeArgumentsString(params, logger));
        Util.AppendArgToStringBuilder(result, "-build");
        return result.toString();
    }
}
