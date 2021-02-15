package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.*;
import jetbrains.buildServer.serverSide.RunTypeRegistry;
import jetbrains.buildServer.web.openapi.PluginDescriptor;

public class UATRunner extends CmdPresetRunner {
    public UATRunner(RunTypeRegistry registry, PluginDescriptor descriptor)
    {
        super(registry, descriptor);
        registry.registerRunType(this);
    }

    @Override
    public CmdRunnerConstants getConstants() {
        return UATConstants.get();
    }
}