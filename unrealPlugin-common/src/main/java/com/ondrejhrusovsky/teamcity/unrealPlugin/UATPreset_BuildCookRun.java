package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public abstract class UATPreset_BuildCookRun extends UATPreset {
    public String makeArgumentsString(Map<String, String> params) {
        StringBuilder result = new StringBuilder("BuildCookRun");

        final String arguments = super.makeArgumentsString(params);
        if(arguments.length() > 0)
        {
            result.append(' ');
            result.append(arguments);
        }

        return result.toString();
    }
}
