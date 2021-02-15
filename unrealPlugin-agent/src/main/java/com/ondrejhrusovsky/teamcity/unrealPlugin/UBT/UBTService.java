package com.ondrejhrusovsky.teamcity.unrealPlugin.UBT;

import com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.Arg_EnginePath;
import com.ondrejhrusovsky.teamcity.unrealPlugin.Util;
import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.runner.BuildServiceAdapter;
import jetbrains.buildServer.agent.runner.ProgramCommandLine;
import jetbrains.buildServer.agent.runner.SimpleProgramCommandLine;
import jetbrains.buildServer.util.FileUtil;
import jetbrains.buildServer.util.TCStreamUtil;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

enum ArtifactsFormat
{
    RAW,
    ARCHIVE_ZIP,
    ARCHIVE_7Z
}

public class UBTService extends BuildServiceAdapter {

    private final Set<File> myFilesToDelete = new HashSet<File>();

    @NotNull
    @Override
    public ProgramCommandLine makeProgramCommandLine() throws RunBuildException {
        getLogger().message("Input runner parameters: " + getRunnerParameters().toString());

        final Path engineBaseDir = Paths.get(getRunnerParameters().get(Arg_EnginePath.class.getSimpleName()));
        final Path UBTExe = UBTConstants.get().GetExePath(engineBaseDir);
        final String cmdArgs = Util.parametersMapToCmdArgsString(getRunnerParameters(), UBTConstants.get().getGlobalArguments());

        StringBuilder scriptContent = new StringBuilder(UBTExe.toString());

        if(cmdArgs.length() > 0)
        {
            scriptContent.append(' ');
            scriptContent.append(cmdArgs);
        }

        AppendManifestIfRequired(scriptContent);

        getLogger().message("ScriptContent: " + scriptContent);

        final String script = getCustomScript(scriptContent.toString());
        setExecutableAttribute(script);
        return new SimpleProgramCommandLine(getRunnerContext(), script, Collections.<String>emptyList());
    }

    String getCustomScript(String scriptContent) throws RunBuildException {
        try {
            final File scriptFile = File.createTempFile("custom_script", ".bat", getAgentTempDirectory());
            FileUtil.writeFileAndReportErrors(scriptFile, scriptContent);
            myFilesToDelete.add(scriptFile);
            return scriptFile.getAbsolutePath();
        } catch (IOException e) {
            RunBuildException exception = new RunBuildException("Failed to create temporary custom script file in directory" + getAgentTempDirectory().toString(), e);
            exception.setLogStacktrace(false);
            throw exception;
        }
    }

    private void AppendManifestIfRequired(StringBuilder scriptContent)
    {
        final String publishManifestFiles = getRunnerParameters().getOrDefault("publishManifestFiles", "");
        final String manifest = getRunnerParameters().getOrDefault(Arg_Manifest.class.getSimpleName(), "");

        if(publishManifestFiles.contains("yes") && manifest.isEmpty())
        {
            scriptContent.append(" -manifest=\"" + getDefaultManifestPath() + "\"");
        }
    }

    private Path getDefaultManifestPath()
    {
        final String stepIndexStr = getEnvironmentVariables().getOrDefault("unreal.UBT.stepIndex", "0");
        return Paths.get(getBuildTempDirectory().getAbsolutePath(),"UBT_Manifest_" + getBuild().getBuildNumber() + "_" + stepIndexStr + ".xml");
    }

    private void setExecutableAttribute(@NotNull final String script) throws RunBuildException {
        try {
            TCStreamUtil.setFileMode(new File(script), "a+x");
        } catch(Throwable t) {
            throw new RunBuildException("Failed to set executable attribute for custom script '" + script + "'", t);
        }
    }

    @Override
    public void beforeProcessStarted() throws RunBuildException {

        super.beforeProcessStarted();
        // something logic
    }

    @Override
    public void afterProcessFinished() throws RunBuildException {
        super.afterProcessFinished();
        for(File file : myFilesToDelete) {
            FileUtil.delete(file);
        }
        myFilesToDelete.clear();
    }

    @Override
    public void afterProcessSuccessfullyFinished() throws RunBuildException {
        super.afterProcessSuccessfullyFinished();

        if(getRunnerParameters().getOrDefault("publishManifestFiles", "").contains("yes"))
        {
            publishArtifactsForThisStep();
        }
    }

    public void publishArtifactsForThisStep()
    {
        final Path enginePath = Paths.get(getWorkingDirectory().getAbsolutePath() ,getRunnerParameters().get(Arg_EnginePath.class.getSimpleName()));
        final Path manifestPath = Paths.get(getRunnerParameters().getOrDefault(Arg_Manifest.class.getSimpleName(), getDefaultManifestPath().toString()));
        final String publishManifestFiles = getRunnerParameters().getOrDefault("publishManifestFiles", "");

        ArtifactsFormat artifactsFormat = ArtifactsFormat.RAW;

        if(publishManifestFiles.contains("zip"))
        {
            artifactsFormat = ArtifactsFormat.ARCHIVE_ZIP;
        }
        else if(publishManifestFiles.contains("7z"))
        {
            artifactsFormat = ArtifactsFormat.ARCHIVE_7Z;
        }

        getLogger().message("Collecting files for publishing from manifest " + manifestPath);
        publishManifestArtifacts(enginePath, manifestPath, artifactsFormat);
    }

    public void publishManifestArtifacts(Path enginePath, Path manifestPath, ArtifactsFormat format)
    {
        final File xml = new File(manifestPath.toString());
        final List<Path> artifacts = parseArtifactsFromXML(xml);

        getLogger().message("Staging UBT output files symlinks in temp folder, so it can be easily published");
        final String outputDirName = "UBTOutput";
        final Path UBTOutputDir = Paths.get(getBuildTempDirectory().getAbsolutePath(), outputDirName);

        for(Path artifact : artifacts)
        {
            final File artifactFile = new File(artifact.toString());
            final File newDest = Paths.get(UBTOutputDir.toString(), enginePath.relativize(artifact).toString()).toFile();

            newDest.getParentFile().mkdirs();

            try {
                Files.createSymbolicLink(newDest.toPath(), artifact);
            } catch (IOException e) {
                getLogger().exception(e);
            }
        }

        if(format == ArtifactsFormat.ARCHIVE_ZIP || format == ArtifactsFormat.ARCHIVE_7Z)
        {
            final String stepIndexStr = getEnvironmentVariables().getOrDefault("unreal.UBT.stepIndex", "0");
            int stepIndex = Integer.parseInt(stepIndexStr);

            final String archiveFormat = format == ArtifactsFormat.ARCHIVE_ZIP ? "zip" : "7z";
            final String archiveFileName = "UBT_" + getBuild().getBuildNumber() + "_" + stepIndex + "." + archiveFormat;

            stepIndex++;
            getLogger().message("##teamcity[setParameter name='env.unreal.UBT.stepIndex' value='" + stepIndex +"']");
            getLogger().message("##teamcity[publishArtifacts '" + UBTOutputDir.toAbsolutePath().toString() + "/** => " + archiveFileName +"']");
        }
        else
        {
            getLogger().message("##teamcity[publishArtifacts '" + UBTOutputDir.toAbsolutePath().toString() + "/**']");
        }
    }

    public List<Path> parseArtifactsFromXML(File xml)
    {
        List<Path> result = new ArrayList<>();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xml);
            doc.getDocumentElement().normalize();

            NodeList buildProducts = doc.getElementsByTagName("BuildProducts");

            for (int i = 0; i < buildProducts.getLength(); i++) {
                Node buildProduct = buildProducts.item(i);

                NodeList stringTags = buildProduct.getChildNodes();

                for (int j = 0; j < stringTags.getLength(); j++) {
                    Node stringTag = stringTags.item(j);

                    if(stringTag.getNodeName() == "string") {
                        final Path artifactPath = Paths.get(stringTag.getTextContent());
                        result.add(artifactPath);
                    }
                }
            }
        }
        catch (Exception e)
        {
            getLogger().exception(e);
        }

        return result;
    }
}
