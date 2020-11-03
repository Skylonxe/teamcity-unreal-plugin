package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.Map;

public abstract class UATArgument {
    String friendlyName = "<argument is missing friendly name>";
    String description = "";
    String defaultValue = "";
    boolean required = false;

    public String getFriendlyName() { return friendlyName; }
    public String getDescription() { return description; }
    public String getType() {  return ""; }
    public boolean getRequired() { return required; }
    public String getDefaultValue() { return defaultValue; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public abstract String makeArgumentString(Map<String, String> params);

    public String IfArgIsTrue(Map<String, String> params, String ifTrue)
    {
        return params.getOrDefault(toString(), "").equals("true") ? "-clean" : "";
    }

    public String IfArgIsPresent(Map<String, String> params, String ifPresent)
    {
        return params.containsKey(toString()) ? ifPresent : "";
    }

    public String StringAfter(String str, String checkFor)
    {
        return str.substring(str.lastIndexOf(checkFor) + checkFor.length() + 1);
    }
}
