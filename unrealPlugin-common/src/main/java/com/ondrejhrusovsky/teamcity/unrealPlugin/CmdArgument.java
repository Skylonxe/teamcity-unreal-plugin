package com.ondrejhrusovsky.teamcity.unrealPlugin;

import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class CmdArgument {
    public String friendlyName = "<argument is missing friendly name>";
    public String description = "";
    public String longDescription = "";
    public String defaultValue = "";
    public String group = "";
    public List<String> helpLinks = new ArrayList<>();
    public boolean required = false;
    public boolean advanced = true;
    public boolean hasParent = false;

    public String getFriendlyName() { return friendlyName; }
    public String getDescription() { return description; }
    public String getLongDescription() { return longDescription; }
    public String getType() {  return ""; }
    public boolean getRequired() { return required; }
    public String getDefaultValue() { return defaultValue; }
    public List<String> getHelpLinks() { return helpLinks; }
    public boolean getAdvanced() { return advanced; }
    public String getGroup() { return group; }
    public boolean getHasParent() { return hasParent; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger)
    {
        return "";
    }
    public String makeArgumentStringFromCmdLine(Map<String, String> params, String currentCmd)
    {
        return "";
    }

    public String IfArgIsTrue(Map<String, String> params, String ifTrue)
    {
        return params.getOrDefault(toString(), "").equals("true") ? ifTrue : "";
    }

    public String IfArgIsTrueVsFalse(Map<String, String> params, String ifTrue, String ifFalse)
    {
        return params.getOrDefault(toString(), "").equals("true") ? ifTrue : ifFalse;
    }

    public String IfArgIsFalse(Map<String, String> params, String ifFalse)
    {
        return params.getOrDefault(toString(), "").equals("true") ? "" : ifFalse;
    }

    public String IfArgIsPresent(Map<String, String> params, String ifPresent)
    {
        return params.containsKey(toString()) ? ifPresent : "";
    }

    public String IfArgIsPresentAndNonEmpty(Map<String, String> params, String ifPresent)
    {
        return params.containsKey(toString()) && !params.get(toString()).trim().isEmpty() ? ifPresent : "";
    }

    public String StringAfter(String str, String checkFor)
    {
        return str.substring(str.lastIndexOf(checkFor) + checkFor.length() + 1);
    }
}
