package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public class UATPreset_Build extends UATPreset {
    UATPreset_Build()
    {
        friendlyName = "Build (C++)";
        arguments = new ArrayList<UATArgument>(Arrays.asList(
                new Arg_Clean(),
                new Arg_Configuration(),
                new Arg_Platforms()
        ));
    }
}
