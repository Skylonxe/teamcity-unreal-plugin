package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_IterativeCooking extends ArgBase_Bool {
    public Arg_IterativeCooking()
    {
        friendlyName = "Iterate";
        description = "Check only hashes of the assets and cook only assets with changed hashes.\n" +
                "This can significantly improve cook times when most of the assets were unchanged since last cook.\n" +
                "This may not be safe in case of code changes as these can change how assets are cooked without changing the resulting hashes and therefore leaving cooked asset outdated.\n" +
                "Asset metadata are stored in cook output directory, doing a clean cook deletes it. As iterative cooks process only changed assets, it may hide previous warnings or errors\n" +
                "because it shows warnings and errors only if you change the erroneous files.";
        longDescription = "Enabling should show additional log lines in the output which can be similar to:" +
                "LogCook: Display: Iterative cooking summary for WindowsNoEditor,\n" +
                "Considered: 471,\n" +
                "File Hash missmatch: 0,\n" +
                "Packages Kept: 471,\n" +
                "Packages failed save kept: 2,\n" +
                "Missing Cooked Info(expected 0): 0";
        advanced = false;
        group = "Cook Time Optimization";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-iterativecooking");
    }
}
