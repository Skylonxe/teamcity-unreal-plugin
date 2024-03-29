package com.ondrejhrusovsky.teamcity.unrealPlugin;

import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.*;

public abstract class CmdPreset {
    public ArrayList<CmdArgument> arguments = new ArrayList<CmdArgument>();
    public String friendlyName = "Unknown preset";
    public String description = "";

    public CmdPreset()
    {
        super();
    }

    public ArrayList<CmdArgument> getArguments() { return arguments; }
    public String getFriendlyName() { return friendlyName; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public String makeArgumentsString(Map<String, String> params, BuildProgressLogger logger) {
        StringBuilder result = new StringBuilder();
        for(CmdArgument arg : arguments)
        {
            String argStr = arg.makeArgumentString(params, logger);
            if(argStr.length() > 0)
            {
                if(result.length() > 0)
                {
                    result.append(" ");
                }
                result.append(argStr);
            }
        }

        for(CmdArgument arg : arguments)
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

    public void sortArguments(List<CmdArgument> args)
    {
        Map<String, List<CmdArgument>> groupLists = new LinkedHashMap<>();

        for(CmdArgument a : args)
        {
            if(!groupLists.containsKey(a.getGroup()))
            {
                groupLists.put(a.getGroup(), new ArrayList<>());
            }

            groupLists.get(a.getGroup()).add(a);
        }

        List<CmdArgument> result = new ArrayList<>();
        args.clear();

        for(List<CmdArgument> group : groupLists.values())
        {
            args.addAll(group);
        }
    }
}
