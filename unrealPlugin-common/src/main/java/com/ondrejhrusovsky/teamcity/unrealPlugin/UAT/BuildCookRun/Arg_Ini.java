package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_StringList;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Arrays;
import java.util.Map;

public class Arg_Ini extends ArgBase_StringList {
    public Arg_Ini()
    {
        friendlyName = "Override ini values";
        description = "This affects only ini values which are read during this task, any config files which are in the output of this task won't have this override reflected.\n" +
                "Example: Game:[/Script/UnrealEd.ProjectPackagingSettings]:BlueprintNativizationMethod=Disabled";
        helpLinks = Arrays.asList("https://bebylon.dev/ue4guide/packaging-cooking/selecting-maps-to-cook/");
        commandSeparator = " -ini:";
        advanced = true;
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsPresentAndNonEmpty(params, "-ini:" + super.makeArgumentString(params, logger));
    }
}
