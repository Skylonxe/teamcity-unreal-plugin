package com.ondrejhrusovsky.teamcity.unrealPlugin;

public abstract class ArgBase_String extends UATArgument {
    int fieldSize = 56;
    int maxLength = 100;
    boolean allowPickFromVCS = false;

    public int getFieldSize() { return fieldSize; }
    public int getMaxLength() { return maxLength; }
    public boolean getAllowPickFromVCS() { return allowPickFromVCS; }
    public String getType() { return "String"; }
}
