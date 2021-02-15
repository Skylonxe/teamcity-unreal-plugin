package com.ondrejhrusovsky.teamcity.unrealPlugin;

import jetbrains.buildServer.serverSide.RunTypeRegistry;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public abstract class CmdPresetRunner extends CmdRunner {
    CmdPresetConstants presetConstants;

    public CmdPresetRunner(RunTypeRegistry registry, PluginDescriptor descriptor) {
        super(registry, descriptor);
        presetConstants = (CmdPresetConstants) getConstants();
    }

    @Nullable
    @Override
    public Map<String, String> getDefaultRunnerProperties() {
        HashMap<String, String> result = new HashMap<>();
        for(CmdArgument arg : presetConstants.getGlobalArguments())
        {
            if(!arg.getDefaultValue().isEmpty())
            {
                result.put(arg.toString(), arg.getDefaultValue());
            }
        }
        for(CmdPreset preset : presetConstants.getPresets())
        {
            for(CmdArgument arg : preset.getArguments())
            {
                if(!arg.getDefaultValue().isEmpty())
                {
                    result.put(arg.toString(), arg.getDefaultValue());
                }
            }
        }
        return result;
    }
}
