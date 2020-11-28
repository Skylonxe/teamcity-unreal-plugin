package com.ondrejhrusovsky.teamcity.unrealPlugin;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_StringList;

public abstract class ArgBase_PathList extends ArgBase_StringList {
    public ArgBase_PathList()
    {
        super();
        encloseValuesWith = "\"";
    }
}
