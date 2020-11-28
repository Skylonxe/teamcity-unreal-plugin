package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Stage;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;

import java.util.Map;

public class Arg_ChunkInstallVersion extends ArgBase_String {
    public Arg_ChunkInstallVersion() {
        allowPickFromVCS = false;
        friendlyName = "Chunk Install Version";
        description = "???";
        defaultValue = "";
        required = false;
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return "-chunkinstallversion";
    }
}
