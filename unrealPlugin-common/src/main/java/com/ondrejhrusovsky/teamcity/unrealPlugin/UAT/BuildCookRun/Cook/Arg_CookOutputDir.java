package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_CookOutputDir extends ArgBase_String {
    public Arg_CookOutputDir() {
        allowPickFromVCS = true;
        friendlyName = "Output Dir";
        description = "Leaving this empty will use default at <Project>/Saved/Cooked/<PlatformName>. Default is fine unless you are doing some special custom setup.";
        group = "Process";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsPresentAndNonEmpty(params, "-CookOutputDir=" + params.get(toString()));
    }
}
