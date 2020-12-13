package com.ondrejhrusovsky.teamcity.unrealPlugin;

public abstract class ArgBase_String extends CmdArgument {
    public int fieldSize = 56;
    public int maxLength = 999;
    public boolean allowPickFromVCS = false;

    public int getFieldSize() { return fieldSize; }
    public int getMaxLength() { return maxLength; }
    public boolean getAllowPickFromVCS() { return allowPickFromVCS; }
    public String getType() { return "String"; }
}
