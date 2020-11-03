package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public abstract class UATPreset {
    ArrayList<UATArgument> arguments = new ArrayList<UATArgument>();
    String friendlyName = "Unknown preset";

    public ArrayList<UATArgument> getArguments() { return arguments; }
    public String getFriendlyName() { return friendlyName; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public String makeArgumentsString(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        for(UATArgument arg : arguments)
        {
            String argStr = arg.makeArgumentString(params);
            if(argStr.length() > 0)
            {
                if(result.length() > 0)
                {
                    result.append(" ");
                }
                result.append(argStr);
            }
        }
        return result.toString();
    }
}
