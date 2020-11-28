package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;
import java.util.Map;

public abstract class ArgBase_BoolMatrix extends UATArgument {
    public ArrayList<String> bools = new ArrayList<>();
    public int minWidth = 105;
    public String optionSeparator = "+";

    @Override
    public String getType() {
        return "BoolMatrix";
    }

    public ArrayList<String> getBools() {
        return bools;
    }

    public int getMinWidth() {
        return minWidth;
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        StringBuilder allOptions = new StringBuilder();
        for(Map.Entry<String, String> e : params.entrySet())
        {
            if(e.getKey().contains(toString()) && e.getValue().equals("true"))
            {
                if(allOptions.length() > 0)
                {
                    allOptions.append(optionSeparator);
                }
                allOptions.append(StringAfter(e.getKey(), toString()));
            }
        }
        return allOptions.toString();
    }
}
