package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Build;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Select;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.UATRunnerConstants;

import java.util.Map;

public class Arg_ServerConfig extends ArgBase_Select {
    public Arg_ServerConfig() {
        friendlyName = "Server Configuration";
        description = "See Unreal Engine docs (Build Configurations Reference) for details.";

        for (UATRunnerConstants.UEBuildConfiguration v : UATRunnerConstants.UEBuildConfiguration.values()) {
            options.add(v.name());
        }
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsPresent(params, "-serverconfig=" + params.get(toString()));
    }

    // -server -skipserver(?) -dedicatedserver
}