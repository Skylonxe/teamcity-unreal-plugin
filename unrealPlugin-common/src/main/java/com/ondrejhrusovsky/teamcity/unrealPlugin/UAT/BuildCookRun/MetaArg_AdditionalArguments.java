package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun;


import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class MetaArg_AdditionalArguments extends ArgBase_String {
    public MetaArg_AdditionalArguments()
    {
        friendlyName = "Additional Arguments";
        description = "Command line parameters to append to the end of the executed command line.";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsPresentAndNonEmpty(params, params.get(toString()));
    }
}

