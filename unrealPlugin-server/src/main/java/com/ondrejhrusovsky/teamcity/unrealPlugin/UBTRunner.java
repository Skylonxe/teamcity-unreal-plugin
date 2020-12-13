package com.ondrejhrusovsky.teamcity.unrealPlugin;

import jetbrains.buildServer.serverSide.InvalidProperty;
import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.serverSide.RunType;
import jetbrains.buildServer.serverSide.RunTypeRegistry;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UBTRunner extends RunType {
    private PluginDescriptor descriptor;

    public UBTRunner(RunTypeRegistry registry, PluginDescriptor descriptor)
    {
        this.descriptor = descriptor;
        registry.registerRunType(this);
    }

    @NotNull
    @Override
    public String getType() {
        return UBTRunnerConstants.RUNNER_TYPE;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return UBTRunnerConstants.DISPLAY_NAME;
    }

    @NotNull
    @Override
    public String getDescription() {
        return UBTRunnerConstants.DESCRIPTION;
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
        return descriptor.getPluginResourcesPath("editUBTRunnerParameters.jsp") ;
    }

    @Nullable
    @Override
    public String getViewRunnerParamsJspFilePath() {
        return descriptor.getPluginResourcesPath("viewUBTRunnerParameters.jsp");
    }

    @Nullable
    @Override
    public Map<String, String> getDefaultRunnerProperties() {
        HashMap<String, String> result = new HashMap<>();
        for(CmdArgument arg : UBTRunnerConstants.Arguments)
        {
            if(!arg.getDefaultValue().isEmpty())
            {
                result.put(arg.toString(), arg.getDefaultValue());
            }
        }
        return result;
    }

    @NotNull
    @Override
    public String describeParameters(@NotNull Map<String, String> parameters) {
        return UBTRunnerConstants.GetUBTExePath(Paths.get("")) + " " + UBTRunnerConstants.parametersMapToCmdArgsString(parameters);
    }
}