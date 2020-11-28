package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.Map;

public abstract class ArgBase_StringList extends ArgBase_MultilineString {
    public String fieldEntrySeparator = "\n";
    public String commandSeparator = "+";
    public String encloseValuesWith = "";

    @Override
    public String makeArgumentString(Map<String, String> params) {
        final String value = params.getOrDefault(toString(), "");
        String entries[] = value.split("\\Q" + fieldEntrySeparator + "\\E");

        if(encloseValuesWith.length() > 0)
        {
            for(int i = 0; i < entries.length; i++)
            {
                if(!entries[i].startsWith(encloseValuesWith) && !entries[i].endsWith(encloseValuesWith))
                {
                    entries[i] = encloseValuesWith + entries[i] + encloseValuesWith;
                }
            }
        }

        return String.join(commandSeparator, entries);
    }
}
