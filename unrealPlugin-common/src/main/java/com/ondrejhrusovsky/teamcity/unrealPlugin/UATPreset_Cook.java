package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public class UATPreset_Cook extends UATPreset_BuildCookRun {
    UATPreset_Cook()
    {
        friendlyName = "Cook (assets)";
        arguments = new ArrayList<UATArgument>(Arrays.asList(
                new Arg_Clean()
        ));
    }
}
