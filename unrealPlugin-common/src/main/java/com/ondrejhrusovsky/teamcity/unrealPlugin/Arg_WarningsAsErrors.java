package com.ondrejhrusovsky.teamcity.unrealPlugin;

public class Arg_WarningsAsErrors extends ArgBase_Bool {
    Arg_WarningsAsErrors()
    {
        friendlyName = "Warnings as Errors";
        description = "Step will fail if warning happens during the process.";
    }
}
