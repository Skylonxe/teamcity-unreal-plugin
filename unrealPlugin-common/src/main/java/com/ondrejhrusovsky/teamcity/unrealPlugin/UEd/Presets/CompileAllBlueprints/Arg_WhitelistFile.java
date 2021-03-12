package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.Presets.CompileAllBlueprints;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_WhitelistFile extends ArgBase_String {
    public Arg_WhitelistFile()
    {
        allowPickFromVCS = true;
        friendlyName = "Whitelist File";
        description = "Path to file which contains list of files per line. Only files listed in the whitelist file will be checked. Leave empty for no restriction.";
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsPresentAndNonEmpty(params, "-WhitelistFile=" + super.makeArgumentString(params, logger));
    }
}
