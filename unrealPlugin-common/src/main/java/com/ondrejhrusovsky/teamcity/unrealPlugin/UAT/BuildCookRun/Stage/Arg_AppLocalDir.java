package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Stage;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_AppLocalDir extends ArgBase_String {
    public Arg_AppLocalDir() {
        allowPickFromVCS = true;
        friendlyName = "App Local Dir";
        description = "???";
        defaultValue = "$(EngineDir)/Binaries/ThirdParty/AppLocalDependencies";
        required = false;
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return "-applocaldirectory";
    }
}
