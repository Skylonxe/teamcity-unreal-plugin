package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.ArrayList;

public abstract class ArgBase_BoolMatrix extends UATArgument {
    ArrayList<String> bools = new ArrayList<>();
    int minWidth = 105;

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
}
