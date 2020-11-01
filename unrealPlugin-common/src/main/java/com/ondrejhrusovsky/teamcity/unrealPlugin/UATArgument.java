package com.ondrejhrusovsky.teamcity.unrealPlugin;

public abstract class UATArgument {
    String key = "LOL";
    String friendlyName = "<argument is missing friendly name>";
    String description = "";
    boolean required = false;

    public String getFriendlyName() { return friendlyName; }
    public String getDescription() { return description; }
    public String getType() {  return ""; }
    public boolean getRequired() { return required; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
