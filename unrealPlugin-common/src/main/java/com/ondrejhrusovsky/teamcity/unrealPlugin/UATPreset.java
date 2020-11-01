package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class UATPreset {
    ArrayList<UATArgument> arguments = new ArrayList<UATArgument>();
    String friendlyName = "Unknown preset";

    public ArrayList<UATArgument> getArguments() { return arguments; }
    public String getFriendlyName() { return friendlyName; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
