package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;

public abstract class ArgBase_Select extends UATArgument {
    public int fieldSize = 56;
    public int maxLength = 100;
    public ArrayList<String> options = new ArrayList<>();

    public int getFieldSize() { return fieldSize; }
    public int getMaxLength() { return maxLength; }
    public String getType() { return "Select"; }

    public ArrayList<String> getOptions() {
        return options;
    }
}
