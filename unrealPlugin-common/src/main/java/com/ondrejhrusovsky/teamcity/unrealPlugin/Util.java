package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
    public static void AppendArgToStringBuilder(StringBuilder sb, String arg)
    {
        if(arg.length() > 0)
        {
            if(sb.length() > 0)
            {
                sb.append(' ');
            }
            sb.append(arg);
        }
    }

    public static String parametersMapToCmdArgsString(Map<String, String> parameters, List<CmdArgument> Arguments) {
        HashMap<String, String> result = new HashMap<>();
        StringBuilder joinedArgsString = new StringBuilder();

        for(CmdArgument arg : Arguments)
        {
            final String argString = arg.makeArgumentString(parameters, null);

            if(!argString.isEmpty())
            {
                if(joinedArgsString.length() > 0)
                {
                    joinedArgsString.append(" ");
                }
                joinedArgsString.append(argString);
            }
        }

        return joinedArgsString.toString();
    }
}
