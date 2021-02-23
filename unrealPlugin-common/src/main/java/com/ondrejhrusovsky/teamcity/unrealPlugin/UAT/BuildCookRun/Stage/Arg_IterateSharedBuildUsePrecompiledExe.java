package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Stage;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;
import jetbrains.buildServer.agent.BuildProgressLogger;

import java.util.Map;

public class Arg_IterateSharedBuildUsePrecompiledExe extends ArgBase_Bool {
    public Arg_IterateSharedBuildUsePrecompiledExe() {
        friendlyName = "Iterate Shared Build Use Precompiled Exe";
        description = "If enabled, binaries (output of Build) (including project & plugin binaries) won't be copied to staging output directory.";
        // From code it seems binaries processing is just ignored but no additional work is done to copy binaries from shared build
    }

    @Override
    public String makeArgumentString(Map<String, String> params, BuildProgressLogger logger) {
        return IfArgIsTrue(params, "-IterateSharedBuildUsePrecompiledExe");
    }
}
