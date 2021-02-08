package com.ondrejhrusovsky.teamcity.unrealPlugin;

import com.intellij.execution.configurations.GeneralCommandLine;
import jetbrains.buildServer.SimpleCommandLineProcessRunner;
import jetbrains.buildServer.agent.*;
import jetbrains.buildServer.util.EventDispatcher;
import jetbrains.buildServer.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class PublishUBTArtifactsAgent extends AgentLifeCycleAdapter {
    private BuildProgressLogger log;

    public PublishUBTArtifactsAgent(EventDispatcher<AgentLifeCycleAdapter> eventDispatcher) {
        eventDispatcher.addListener(this);
    }

    @Override
    public void beforeBuildFinish(@NotNull AgentRunningBuild build, @NotNull BuildFinishedStatus buildStatus) {
        log = build.getBuildLogger();
        log.message("##teamcity[blockOpened name='Publish UBT Artifacts']");

        if(buildStatus.isFailed())
        {
            log.message("Skip publishing UBT Artifacts because build failed");
            return;
        }

        Collection<AgentBuildFeature> buildFeatures = build.getBuildFeaturesOfType("PublishUBTArtifacts");

        for(AgentBuildFeature bf : buildFeatures)
        {
            Path manifestPath = Paths.get(bf.getParameters().getOrDefault("manifestPath", ""));
            if(!manifestPath.isAbsolute())
            {
                manifestPath = Paths.get(build.getCheckoutDirectory().toURI().getPath().toString(), manifestPath.toString());
            }
            log.message("From manifest: " + manifestPath);

            Path enginePath = Paths.get(build.getSharedBuildParameters().getEnvironmentVariables().getOrDefault("%env.unreal.engine.dir%", ""));
            if(!enginePath.isAbsolute())
            {
                enginePath = Paths.get(build.getCheckoutDirectory().getAbsolutePath(), enginePath.toString());
            }
            log.message("For engine at:" + enginePath);

            if(!manifestPath.toString().isEmpty() && !enginePath.toString().isEmpty())
            {
              // publishManifestArtifacts(build, enginePath, manifestPath);
            }
            else
            {
                log.error("Could not find manifest or engine path");
            }
        }

        log.message("##teamcity[blockClosed name='Publish UBT Artifacts']");
    }

}
