package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdArgument;

import java.util.ArrayList;
import java.util.Arrays;

public class CmdPreset_Archive extends CmdPreset_BuildCookRun {
    CmdPreset_Archive()
    {
        friendlyName = "Archive (zip)";
        arguments = new ArrayList<CmdArgument>(Arrays.asList(

        ));
    }
}
