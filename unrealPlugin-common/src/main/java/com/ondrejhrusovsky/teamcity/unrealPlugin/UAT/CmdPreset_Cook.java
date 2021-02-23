package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.*;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook.*;
import com.ondrejhrusovsky.teamcity.unrealPlugin.Util;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Arrays;
import java.util.Map;

public class CmdPreset_Cook extends CmdPreset_BuildCookRun {
    CmdPreset_Cook()
    {
        super();
        friendlyName = "Cook (assets)";
        description = "Prepares and optimizes your asset files to be used in standalone application on specified platforms.\n" +
                "Output is usually stored in Project/Saved/Cooked";

        /*
        // MANAGE BY CODE
        // ScriptsForProject
        // -project
        //
        -nop4
        -installed
        -ue4exe
        -utf8output
        unattended

         */

        arguments.addAll(Arrays.asList(
                new Arg_Clean(),

                new Arg_Client(),
                new Arg_ClientTargetPlatform(),
                new Arg_CookFlavor(),

                new Arg_DedicatedServer(),
                new Arg_ServerTargetPlatform(),

                new Arg_IgnoreCookErrors(),
                new Arg_IterativeCooking(),
                new Arg_FastCook(),

                new Arg_CookAll(),
                new Arg_CookMapsOnly(),
                new Arg_CookCultures(),
                new Arg_CookPartialGC(),
                new Arg_DirectoriesToCook(),
                new Arg_IterateSharedCookedBuild(),
                new Arg_MapIniSection(),
                new Arg_MapsToCook(),
                new Arg_NumCookersToSpawn(),
                new Arg_SkipCookingEditorContent(),
                new Arg_UnversionedCookedContent(),

                new Arg_CookOutputDir(),
                new Arg_AdditionalCookerOptions(),
                new Arg_Compressed()

                /*
                -dlcname=
                -cookonthefly
                -noclient

                iterate blocks clean

                directoriestocook
                internationalizationpreset

                buildmachine

                manifests
                iteratesahredcookedbuild


                createreleaseversion=



                basedonreleaseversion

                configoverride

                diffcookedcontentpath
                 */
        ));

        sortArguments(arguments);
    }

    @Override
    public String makeArgumentsString(Map<String, String> params, BuildProgressLogger logger) {
        StringBuilder result = new StringBuilder(super.makeArgumentsString(params, logger));
        Util.AppendArgToStringBuilder(result, "-cook -skipstage");
        return result.toString();
    }
}
