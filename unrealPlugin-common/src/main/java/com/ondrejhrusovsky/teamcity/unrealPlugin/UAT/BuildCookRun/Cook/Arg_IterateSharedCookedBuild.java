package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_IterateSharedCookedBuild extends ArgBase_Bool {
    public Arg_IterateSharedCookedBuild() {
        friendlyName = "Iterates Shared Cooked Build";
        description = "Enables iterative cooking but checks into specified network drive directory to see if there is a newer build than our local one.\n" +
                "If yes, we iterate over shared cooked build instead of iterating on a local one.\n" +
                "This can be used for example to let your build machine nightly prepare shared cooked content usable for iterative cooking performed on local machines of developers during the day.";
        group = "Team";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-IterateSharedCookedBuild");
    }
}
