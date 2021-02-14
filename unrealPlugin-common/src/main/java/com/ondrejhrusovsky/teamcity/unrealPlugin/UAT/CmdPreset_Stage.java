package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdArgument;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Arg_Client;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Arg_DedicatedServer;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook.Arg_CookCultures;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Stage.Arg_Pak;
import com.ondrejhrusovsky.teamcity.unrealPlugin.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class CmdPreset_Stage extends CmdPreset_BuildCookRun {
    CmdPreset_Stage()
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
