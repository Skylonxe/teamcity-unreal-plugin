package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.util.Map;

public class Arg_WarningsAsErrors extends ArgBase_Bool {
    Arg_WarningsAsErrors()
    {
        friendlyName = "Warnings as Errors";
        description = "Step will fail if warning happens during the process.";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsTrue(params, "-WarningsAsErrors");
    }
}
