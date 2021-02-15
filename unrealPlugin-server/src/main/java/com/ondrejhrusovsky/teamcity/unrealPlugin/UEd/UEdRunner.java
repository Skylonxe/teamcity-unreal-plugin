package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPresetConstants;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdRunner;
import jetbrains.buildServer.serverSide.RunTypeRegistry;
import jetbrains.buildServer.web.openapi.PluginDescriptor;

public class UEdRunner extends CmdRunner {
    public UEdRunner(RunTypeRegistry registry, PluginDescriptor descriptor) {
        super(registry, descriptor);
        registry.registerRunType(this);
    }

    @Override
    public CmdPresetConstants getConstants() {
        return UEdConstants.get();
    }
}