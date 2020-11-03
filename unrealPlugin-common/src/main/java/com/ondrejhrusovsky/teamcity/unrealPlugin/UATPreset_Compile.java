package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public class UATPreset_Compile extends UATPreset_BuildCookRun {
    UATPreset_Compile()
    {
        friendlyName = "Compile (C# tools)";
        /*arguments = new ArrayList<UATArgument>(Arrays.asList(
                new Arg_Clean()
        ));*/
    }
}
