package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;

public abstract class ArgBase_Select extends UATArgument {
    int fieldSize = 56;
    int maxLength = 100;
    ArrayList<String> options = new ArrayList<>();

    public int getFieldSize() { return fieldSize; }
    public int getMaxLength() { return maxLength; }
    public String getType() { return "Select"; }

    public ArrayList<String> getOptions() {
        return options;
    }
}
