package com.ondrejhrusovsky.teamcity.unrealPlugin;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class UAT {
    public static Path GetRunUATPath(Path BaseEngine)
    {
        return Paths.get(BaseEngine.toString(),"\\Engine\\Build\\BatchFiles\\RunUAT.bat");
    }
}
