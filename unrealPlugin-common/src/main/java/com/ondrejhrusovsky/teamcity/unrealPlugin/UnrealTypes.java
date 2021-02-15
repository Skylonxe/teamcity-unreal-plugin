package com.ondrejhrusovsky.teamcity.unrealPlugin;

public interface UnrealTypes {
    enum UETargetPlatform {
        Android,
        HTML5,
        HoloLens,
        IOS,
        Linux,
        Lumin,
        MPX,
        Mac,
        PS4,
        PS5,
        Quail,
        Switch,
        TvOS,
        UWP32,
        UWP64,
        Win32,
        Win64,
        WinAnvil,
        XboxOne,
        XboxOneAnvil
    }

    enum UECookTargetPlatform {
        Android,
        IOS,
        PS4,
        LinuxServer,
        WindowsServer,
        WindowsNoEditor,
        XboxOne
    }

    enum UECookFlavors {
        DXT,
        ASTC,
        ETC2
    }

    enum UEBuildConfiguration {
        Debug,
        DebugGame,
        Development,
        Shipping,
        Test
    }
}
