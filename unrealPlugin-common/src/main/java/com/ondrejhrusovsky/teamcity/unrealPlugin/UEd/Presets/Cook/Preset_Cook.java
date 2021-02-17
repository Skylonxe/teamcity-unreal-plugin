package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPreset;
import com.ondrejhrusovsky.teamcity.unrealPlugin.Util;

import java.util.Arrays;
import java.util.Map;

public class Preset_Cook extends CmdPreset {
    public Preset_Cook()
    {
        super();
        friendlyName = "Cook (assets)";
        description = "Prepares and optimizes your asset files to be used in standalone application on specified platforms.";

        arguments.addAll(Arrays.asList(
            new Arg_CookPlatform()
        ));

        sortArguments(arguments);
    }

    @Override
    public String makeArgumentsString(Map<String, String> params) {
        return "-run=cook " + super.makeArgumentsString(params);
    }
}
