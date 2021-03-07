package com.ondrejhrusovsky.teamcity.unrealPlugin.PostBadgeStatus;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdRunner;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdRunnerConstants;
import jetbrains.buildServer.serverSide.RunTypeRegistry;
import jetbrains.buildServer.web.openapi.PluginDescriptor;

public class PostBadgeStatusRunner extends CmdRunner {
    public PostBadgeStatusRunner(RunTypeRegistry registry, PluginDescriptor descriptor)
    {
        super(registry, descriptor);
        registry.registerRunType(this);
    }
    
    @Override
    public CmdRunnerConstants getConstants() {
        return PostBadgeStatusConstants.get();
    }
}