package com.ondrejhrusovsky.teamcity.unrealPlugin;

import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Arg_Client;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Arg_DedicatedServer;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook.Arg_CookCultures;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Stage.Arg_Pak;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.Custom.Arg_Custom_Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class UATPreset_Custom extends UATPreset {
    UATPreset_Custom()
    {
        friendlyName = "Custom";
        description = "Allows passing user-defined command line arguments to the UAT.";

        arguments = new ArrayList<CmdArgument>(Arrays.asList(
                new Arg_Custom_Command()
        ));
    }
}
