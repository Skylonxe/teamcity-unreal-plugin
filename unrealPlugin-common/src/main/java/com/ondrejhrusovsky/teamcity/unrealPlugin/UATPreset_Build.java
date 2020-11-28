package com.ondrejhrusovsky.teamcity.unrealPlugin;

import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.*;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Build.*;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class UATPreset_Build extends UATPreset_BuildCookRun {
    UATPreset_Build()
    {
        friendlyName = "Build (C++)";
        arguments = new ArrayList<UATArgument>(Arrays.asList(
                new Arg_Clean(),
                new Arg_ClientConfig(),
                new Arg_ClientTargetPlatform()
        ));
    }

    @Override
    public String makeArgumentsString(Map<String, String> params) {
        StringBuilder result = new StringBuilder(super.makeArgumentsString(params));
        Util.AppendArgToStringBuilder(result, "-build");
        return result.toString();
    }
}
