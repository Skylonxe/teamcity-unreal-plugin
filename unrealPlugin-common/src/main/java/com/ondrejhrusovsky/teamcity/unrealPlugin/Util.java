package com.ondrejhrusovsky.teamcity.unrealPlugin;

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
}
