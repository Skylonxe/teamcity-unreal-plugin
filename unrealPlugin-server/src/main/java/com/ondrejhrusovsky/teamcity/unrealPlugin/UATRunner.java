package com.ondrejhrusovsky.teamcity.unrealPlugin;

import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.UATRunnerConstants;
import jetbrains.buildServer.serverSide.InvalidProperty;
import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.serverSide.RunType;
import jetbrains.buildServer.serverSide.RunTypeRegistry;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UATRunner extends RunType {
    private PluginDescriptor descriptor;

    public UATRunner(RunTypeRegistry registry, PluginDescriptor descriptor)
    {
        this.descriptor = descriptor;
        registry.registerRunType(this);
    }

    @NotNull
    @Override
    public String getType() {
        return UATRunnerConstants.RUNNER_TYPE;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return UATRunnerConstants.DISPLAY_NAME;
    }

    @NotNull
    @Override
    public String getDescription() {
        return UATRunnerConstants.DESCRIPTION;
    }

    @Nullable
    @Override
    public PropertiesProcessor getRunnerPropertiesProcessor() {
        return properties -> {
            List<InvalidProperty> list = new ArrayList<>();
            return list;
        };
    }

    @Nullable
    @Override
    public String getEditRunnerParamsJspFilePath() {
        return descriptor.getPluginResourcesPath("editUATRunnerParameters.jsp") ;
    }

    @Nullable
    @Override
    public String getViewRunnerParamsJspFilePath() {
        return descriptor.getPluginResourcesPath("viewUATRunnerParameters.jsp");
    }

    @Nullable
    @Override
    public Map<String, String> getDefaultRunnerProperties() {
        HashMap<String, String> result = new HashMap<>();
        for(CmdArgument arg : UATRunnerConstants.Arguments)
        {
            if(!arg.getDefaultValue().isEmpty())
            {
                result.put(arg.toString(), arg.getDefaultValue());
            }
        }
        for(CmdPreset preset : UATRunnerConstants.PRESETS)
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

    @NotNull
    @Override
    public String describeParameters(@NotNull Map<String, String> parameters) {
        return "THIS IS COOL DESCRIPTION";
    }
}