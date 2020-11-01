package com.ondrejhrusovsky.teamcity.unrealPlugin;

import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.runner.BuildServiceAdapter;
import jetbrains.buildServer.agent.runner.ProgramCommandLine;
import jetbrains.buildServer.agent.runner.SimpleProgramCommandLine;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UATService extends BuildServiceAdapter {
    @NotNull
    @Override
    public ProgramCommandLine makeProgramCommandLine() throws RunBuildException {
        final String message = getRunnerParameters().get("MSG");
        ArrayList<String> s = new ArrayList<>();
        return new SimpleProgramCommandLine(getRunnerContext(), "echo \"Hello World\"", s);
    }

    @Override
    public void beforeProcessStarted() throws RunBuildException {

        super.beforeProcessStarted();
        // something logic
    }

    @Override
    public void afterProcessFinished() throws RunBuildException {

        super.afterProcessFinished();
    }
}
