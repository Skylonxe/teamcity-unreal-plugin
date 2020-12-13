package com.ondrejhrusovsky.teamcity.unrealPlugin;

import jetbrains.buildServer.serverSide.BuildFeature;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class PublishUBTArtifacts extends BuildFeature {
    private final String editJsp;

    public PublishUBTArtifacts(@NotNull final PluginDescriptor descriptor) {
        editJsp = descriptor.getPluginResourcesPath("publishUBTArtifacts.jsp");
    }

    @Nullable
    @Override
    public Map<String, String> getDefaultParameters() {
        HashMap<String, String> result = new HashMap<>();
        result.put("enginePath", "%env.unreal.engine.dir%");
        return result;
    }

    @NotNull
    @Override
    public String getType() {
        return "PublishUBTArtifacts";
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Publish UBT Artifacts";
    }

    @Nullable
    @Override
    public String getEditParametersUrl() {
        return editJsp;
    }

    @Override
    public boolean isMultipleFeaturesPerBuildTypeAllowed() {
        return true;
    }

    @Override
    public boolean isRequiresAgent() { return true; }
}
