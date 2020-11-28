package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;

import java.util.Map;

public class Arg_SkipCookingEditorContent extends ArgBase_Bool {
    public Arg_SkipCookingEditorContent()
    {
        friendlyName = "Cook Editor Content";
        description = "If enabled, content of the editor will also be cooked. This may be necessary for some games which use it.";
        defaultValue = "true";
        group = "Assets";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsFalse(params, "-SkipCookingEditorContent");
    }
}
