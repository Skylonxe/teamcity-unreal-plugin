package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_Bool;

import java.util.Map;

public class Arg_Client extends ArgBase_Bool {
    public Arg_Client() {
        friendlyName = "Client";
        description = "If enabled, data necessary for a Client application instead of standalone Game application will be produced.\n" +
                "Client is almost same as standalone Game but it has server code stripped.\n" +
                "Networked games which require external server and cannot host game locally are clients.";
        advanced = false;
        group = "Client";
        helpLinks.add("https://docs.unrealengine.com/en-US/Programming/UnrealBuildSystem/TargetFiles/index.html");
    }

    @Override
    public String makeArgumentStringFromCmdLine(Map<String, String> params, String currentCmd) {
        String noClient = "";

        String currentCmdLower = currentCmd.toLowerCase() + " ";
        if(currentCmdLower.contains("-server ") || currentCmdLower.contains("-cookonthefly ") || currentCmdLower.contains("-dedicatedserver "))
        {
            noClient = "-noclient";
        }

        return IfArgIsTrueVsFalse(params, "-client", noClient);
    }
}
