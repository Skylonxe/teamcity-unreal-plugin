package com.ondrejhrusovsky.teamcity.unrealPlugin;

import jetbrains.buildServer.serverSide.BuildFeature;
import jetbrains.buildServer.serverSide.BuildServerAdapter;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class PostBadgeStatusFeature extends BuildFeature {
    private final String editJsp;

    public PostBadgeStatusFeature(@NotNull final PluginDescriptor descriptor) {
        editJsp = descriptor.getPluginResourcesPath("postBadgeStatusFeature.jsp");
    }

    @Nullable
    @Override
    public Map<String, String> getDefaultParameters() {
        HashMap<String, String> result = new HashMap<>();
        result.put("postBadgeStatusPath", "%env.unreal.postBadgeStatus.exe%");
        return result;
    }

    @NotNull
    @Override
    public String getType() {
        return "PostBadgeStatusFeature";
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Unreal Game Sync (Post Badge Status)";
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
