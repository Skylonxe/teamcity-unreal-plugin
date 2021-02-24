package com.ondrejhrusovsky.teamcity.unrealPlugin.GitDependencies;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdRunner;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdRunnerConstants;
import jetbrains.buildServer.serverSide.RunTypeRegistry;
import jetbrains.buildServer.web.openapi.PluginDescriptor;

public class GitDependenciesRunner extends CmdRunner {
    public GitDependenciesRunner(RunTypeRegistry registry, PluginDescriptor descriptor)
    {
        super(registry, descriptor);
        registry.registerRunType(this);
    }

    @Override
    public CmdRunnerConstants getConstants() {
        return GitDependenciesConstants.get();
    }
}