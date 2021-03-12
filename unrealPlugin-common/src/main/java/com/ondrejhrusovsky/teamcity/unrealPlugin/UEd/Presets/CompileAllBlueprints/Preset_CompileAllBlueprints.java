package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.CompileAllBlueprints;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPreset;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Arg_UProjectFile;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.Cook.Arg_CookPlatform;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Arrays;
import java.util.Map;

public class Preset_CompileAllBlueprints extends CmdPreset {
    public Preset_CompileAllBlueprints()
    {
        super();
        friendlyName = "Compile All Blueprints";
        description = "Compiles all blueprints of the project. Useful for checking blueprint compilation errors.";

        arguments.addAll(Arrays.asList(
            new Arg_UProjectFile(),
            new Arg_ShowResultsOnly(),
            new Arg_SimpleAssetList(),
            new Arg_BlueprintBaseClass(),
            new Arg_ExcludeTags(),
            new Arg_RequireTags(),
            new Arg_IgnoreFolders(),
            new Arg_WhitelistFile(),
            new Arg_CookedOnly(),
            new Arg_DirtyOnly()
        ));

        sortArguments(arguments);
    }

    @Override
    public String makeArgumentsString(Map<String, String> params, BuildProgressLogger logger) {
        final String uprojectFile = params.getOrDefault(Arg_UProjectFile.class.getSimpleName(), "");
        params.remove(Arg_UProjectFile.class.getSimpleName());
        final String otherArgs = super.makeArgumentsString(params, logger);
        return (uprojectFile.isEmpty() ? "" : uprojectFile + " ") + "-run=CompileAllBlueprints -buildmachine -unattended" + (otherArgs.isEmpty() ? "" : " " + otherArgs);
    }
}
