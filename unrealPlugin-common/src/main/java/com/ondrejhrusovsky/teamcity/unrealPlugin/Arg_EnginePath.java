package com.ondrejhrusovsky.teamcity.unrealPlugin;

public class Arg_EnginePath extends ArgBase_String {
    public Arg_EnginePath() {
        allowPickFromVCS = true;
        friendlyName = "Engine Root Dir";
        description = "For example: C:\\Program Files (x86)\\Epic Games\\UE_4.25";
        required = true;
    }
}
