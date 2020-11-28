package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_PathList;

import java.util.Map;

public class Arg_DirectoriesToCook extends ArgBase_PathList {
    public Arg_DirectoriesToCook()
    {
        super();
        friendlyName = "Additional asset directories to cook";
        description = "Forces assets at specified paths to be always cooked even if not used. Multiple paths can be separated using a newline.";
        group = "Assets";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsPresentAndNonEmpty(params, "-CookDir=" + super.makeArgumentString(params));
    }
}
