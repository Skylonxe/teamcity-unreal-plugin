package com.ondrejhrusovsky.teamcity.unrealPlugin;

public class Arg_Clean extends ArgBase_Bool {
    Arg_Clean()
    {
        friendlyName = "Clean";
        description = "Deletes task files from previous run and starts from scratch instead of processing only changed files.";
    }
}
