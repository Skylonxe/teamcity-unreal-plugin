package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.Map;

public class Arg_Platforms extends ArgBase_BoolMatrix {
    public Arg_Platforms() {
        friendlyName = "Target Platforms";
        description = "Platforms on which your end product should run.";
        minWidth = 105;
        required = true;

        for(UATRunnerConstants.UETargetPlatform v : UATRunnerConstants.UETargetPlatform.values())
        {
            bools.add(v.name());
        }
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        StringBuilder allPlatforms = new StringBuilder();
        for(Map.Entry<String, String> e : params.entrySet())
        {
            if(e.getKey().contains(toString()) && e.getValue().equals("true"))
            {
                if(allPlatforms.length() > 0)
                {
                    allPlatforms.append("+");
                }
                allPlatforms.append(StringAfter(e.getKey(), toString()));
            }
        }
        return allPlatforms.length() > 0 ? "-targetplatform=" + allPlatforms.toString() : "";
    }
}
