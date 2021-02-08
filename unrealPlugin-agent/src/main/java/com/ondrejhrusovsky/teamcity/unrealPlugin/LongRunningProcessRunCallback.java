package com.ondrejhrusovsky.teamcity.unrealPlugin;

import jetbrains.buildServer.SimpleCommandLineProcessRunner;
import jetbrains.buildServer.serverSide.TeamCityProperties;

public class LongRunningProcessRunCallback implements SimpleCommandLineProcessRunner.ProcessRunCallback {

    private static final int DEFAULT_TIMEOUT_SECONDS = 60 * 60 * 24;

    @Override
    public Integer getMaxAcceptedOutputSize() {
        return null;
    }

    @Override
    public void onProcessStarted(Process process) {

    }

    @Override
    public void onProcessFinished(Process process) {

    }

    @Override
    public Integer getOutputIdleSecondsTimeout() {
        return TeamCityProperties.getInteger("teamcity.execution.timeout", DEFAULT_TIMEOUT_SECONDS);
    }
}