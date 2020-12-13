package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public class UATPreset_Archive extends UATPreset_BuildCookRun {
    UATPreset_Archive()
    {
        friendlyName = "Archive (zip)";
        arguments = new ArrayList<CmdArgument>(Arrays.asList(

        ));
    }
}
