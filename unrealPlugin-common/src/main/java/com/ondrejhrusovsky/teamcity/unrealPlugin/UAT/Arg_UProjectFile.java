package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;

import java.util.Map;

public class Arg_UProjectFile extends ArgBase_String {
    public Arg_UProjectFile() {
        allowPickFromVCS = true;
        friendlyName = ".uproject File";
        description = "For example: C:\\Users\\UserName\\Documents\\Unreal Projects\\MyProject\\MyProject.uproject";
        defaultValue = "%env.unreal.project.file%";
        required = true;
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsPresent(params, "-project=" + params.get(toString()));
    }
}
