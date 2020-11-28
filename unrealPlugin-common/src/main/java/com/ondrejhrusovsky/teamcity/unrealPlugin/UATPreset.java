package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.lang.reflect.Array;
import java.util.*;

public abstract class UATPreset {
    ArrayList<UATArgument> arguments = new ArrayList<UATArgument>();
    String friendlyName = "Unknown preset";
    String description = "";

    UATPreset()
    {
        super();
    }

    public ArrayList<UATArgument> getArguments() { return arguments; }
    public String getFriendlyName() { return friendlyName; }
    public String getDescription() { return description; }

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

        for(UATArgument arg : arguments)
        {
            String argStr = arg.makeArgumentStringFromCmdLine(params, result.toString());
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

    public void sortArguments(List<UATArgument> args)
    {
        Map<String, List<UATArgument>> groupLists = new LinkedHashMap<>();

        for(UATArgument a : args)
        {
            if(!groupLists.containsKey(a.getGroup()))
            {
                groupLists.put(a.getGroup(), new ArrayList<>());
            }

            groupLists.get(a.getGroup()).add(a);
        }

        List<UATArgument> result = new ArrayList<>();
        args.clear();

        for(List<UATArgument> group : groupLists.values())
        {
            args.addAll(group);
        }
    }
}
