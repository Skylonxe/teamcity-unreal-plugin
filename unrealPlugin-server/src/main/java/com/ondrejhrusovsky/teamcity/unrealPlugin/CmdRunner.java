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

public abstract class CmdRunner extends RunType {
    private PluginDescriptor descriptor;
    CmdPresetConstants constants;

    public CmdRunner(RunTypeRegistry registry, PluginDescriptor descriptor)
    {
        constants = getConstants();
        this.descriptor = descriptor;
    }

    public abstract CmdPresetConstants getConstants();

    @NotNull
    @Override
    public String getType() {
        return constants.getRunnerType();
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return constants.getDisplayName();
    }

    @NotNull
    @Override
    public String getDescription() {
        return constants.getDescription();
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
        return descriptor.getPluginResourcesPath(constants.getShortName() + "/editRunnerParameters.jsp") ;
    }

    @Nullable
    @Override
    public String getViewRunnerParamsJspFilePath() {
        return descriptor.getPluginResourcesPath(constants.getShortName() + "/viewRunnerParameters.jsp");
    }

    @Nullable
    @Override
    public Map<String, String> getDefaultRunnerProperties() {
        HashMap<String, String> result = new HashMap<>();
        for(CmdArgument arg : constants.getGlobalArguments())
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
        return constants.GetExePath(Paths.get("")) + " " + Util.parametersMapToCmdArgsString(parameters, constants.getGlobalArguments());
    }
}
