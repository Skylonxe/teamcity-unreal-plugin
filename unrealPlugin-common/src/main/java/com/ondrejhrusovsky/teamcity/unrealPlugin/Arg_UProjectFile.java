package com.ondrejhrusovsky.teamcity.unrealPlugin;

public class Arg_UProjectFile extends ArgBase_String {
    public Arg_UProjectFile() {
        allowPickFromVCS = true;
        friendlyName = ".uproject File";
        description = "For example: C:\\Users\\UserName\\Documents\\Unreal Projects\\MyProject\\MyProject.uproject";
        required = true;
    }
}
