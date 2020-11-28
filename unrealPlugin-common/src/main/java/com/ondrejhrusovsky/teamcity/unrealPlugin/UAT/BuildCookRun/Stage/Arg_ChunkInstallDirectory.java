package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Stage;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;

import java.util.Map;

public class Arg_ChunkInstallDirectory extends ArgBase_String {
    public Arg_ChunkInstallDirectory() {
        allowPickFromVCS = true;
        friendlyName = "Chunk Install Directory";
        description = "???";
        defaultValue = "";
        required = false;
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return "-chunkinstalldirectory";
    }
}
