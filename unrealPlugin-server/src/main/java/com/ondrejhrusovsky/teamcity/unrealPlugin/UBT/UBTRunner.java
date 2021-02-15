package com.ondrejhrusovsky.teamcity.unrealPlugin.UBT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.*;
import jetbrains.buildServer.serverSide.RunTypeRegistry;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import org.jetbrains.annotations.Nullable;
import java.util.Map;

public class UBTRunner extends CmdRunner {
    public UBTRunner(RunTypeRegistry registry, PluginDescriptor descriptor)
    {
        super(registry, descriptor);
        registry.registerRunType(this);
    }

    @Override
    public CmdRunnerConstants getConstants() {
        return UBTConstants.get();
    }

    @Nullable
    @Override
    public Map<String, String> getDefaultRunnerProperties() {
        Map<String, String> result = super.getDefaultRunnerProperties();
        result.put("publishManifestFiles", "no");
        return result;
    }
}