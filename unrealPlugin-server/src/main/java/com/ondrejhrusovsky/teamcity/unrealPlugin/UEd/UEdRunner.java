package com.ondrejhrusovsky.teamcity.unrealPlugin.UEd;

import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdArgument;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdPresetConstants;
import com.ondrejhrusovsky.teamcity.unrealPlugin.CmdRunner;
import com.ondrejhrusovsky.teamcity.unrealPlugin.UEd.UEdConstants;
import com.ondrejhrusovsky.teamcity.unrealPlugin.Util;
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