package com.ondrejhrusovsky.teamcity.unrealPlugin;

import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Arg_Client;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Arg_DedicatedServer;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook.Arg_CookCultures;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Stage.Arg_Pak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class UATPreset_Stage extends UATPreset_BuildCookRun {
    UATPreset_Stage()
    {
        friendlyName = "Stage";
        description = "Copies cooked assets, compiled binaries and other game files like configs into same folder, forming there final standalone application.";

        arguments = new ArrayList<CmdArgument>(Arrays.asList(
                new Arg_Client(),
                new Arg_DedicatedServer(),
                new Arg_Pak(),
                new Arg_CookCultures()
        ));
    }

    @Override
    public String makeArgumentsString(Map<String, String> params) {
        StringBuilder result = new StringBuilder(super.makeArgumentsString(params));
        Util.AppendArgToStringBuilder(result, "-skipcook -stage");
        return result.toString();
    }
}
