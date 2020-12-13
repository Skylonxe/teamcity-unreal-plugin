package com.ondrejhrusovsky.teamcity.unrealPlugin;

public abstract class ArgBase_MultilineString extends CmdArgument {
    public int rowsNum = 10;
    public int colsNum = 58;
    public String linkTitle = "";

    public int getRowsNum() { return rowsNum; }
    public int getColsNum() { return colsNum; }
    public String getLinkTitle() { return linkTitle; }

    public String getType() { return "MultilineString"; }
}
