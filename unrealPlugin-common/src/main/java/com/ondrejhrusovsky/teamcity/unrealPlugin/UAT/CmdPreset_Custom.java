package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdArgument;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPreset;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.Custom.Arg_Custom_Command;

import java.util.ArrayList;
import java.util.Arrays;

public class CmdPreset_Custom extends CmdPreset {
    CmdPreset_Custom()
    {
        friendlyName = "Custom";
        description = "Allows passing user-defined command line arguments to the UAT.";

        arguments = new ArrayList<CmdArgument>(Arrays.asList(
                new Arg_Custom_Command()
        ));
    }
}
