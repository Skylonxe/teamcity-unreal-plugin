package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.CompileAllBlueprints;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_StringList;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Arrays;
import java.util.Map;

public class Arg_RequireTags extends ArgBase_StringList {
    public Arg_RequireTags()
    {
        friendlyName = "Required Tags";
        description = "Only assets containing these AssetData tags will be checked. AssetData tags are a map of values for properties that were marked AssetRegistrySearchable or added by GetAssetRegistryTags() function.\n" +
                "Enter single key and possible values separated by , per line. For example Key,PossibleValue1,PossibleValue2,PossibleValue3";
        helpLinks = Arrays.asList("https://docs.unrealengine.com/en-US/ProgrammingAndScripting/ProgrammingWithCPP/Assets/Registry/index.html");
        commandSeparator = ";";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsPresentAndNonEmpty(params, "-RequireTags=" + super.makeArgumentString(params, logger));
    }
}
