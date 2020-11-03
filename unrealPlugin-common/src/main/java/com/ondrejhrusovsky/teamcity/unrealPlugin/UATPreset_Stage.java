package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public class UATPreset_Stage extends UATPreset_BuildCookRun {
    UATPreset_Stage()
    {
        friendlyName = "Stage";
        arguments = new ArrayList<UATArgument>(Arrays.asList(
                new Arg_Clean()
        ));
    }
}
