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
        MacNoEditor,
        MacServer,
        MacClient,
        PS4,
        PS5,
        PS5Client,
        XboxOne,
        Android,
        AndroidClient,
        Android_DXT,
        Android_DXTClient,
        Android_ETC2,
        Android_ETC2Client,
        Android_ASTC,
        Android_ASTCClient,
        Android_Multi,
        Android_MultiClient,
        IOS,
        IOSClient,
        LinuxNoEditor,
        LinuxServer,
        LinuxClient,
        LinuxAArch64NoEditor,
        LinuxAArch64Client,
        LinuxAArch64Server,
        Lumin,
        LuminClient,
        WindowsNoEditor,
        WindowsServer,
        WindowsClient,
        TVOS,

        /*HoloLens,
        HTML5,
        MPX,
        Quail,
        Switch,*/
    }

    /*enum UECookTargetPlatform {
        Mac,
        PS4,
        PS5,
        XboxOne,
        Android,
        IOS,
        Linux,
        Lumin,
        Windows,
        TVOS,
    }

    public static String getCookPlatform(UECookTargetPlatform platform, boolean dedicatedSever, boolean clientOnly, String flavour)
    {
        if(platform == UECookTargetPlatform.Mac) {
            if (dedicatedSever) return "MacServer";
            if (clientOnly) return "MacClient";
            return "MacNoEditor";
        }
        if(platform == UECookTargetPlatform.PS4) {
            return "PS4";
        }
        if(platform == UECookTargetPlatform.PS5) {
            if(clientOnly) return "PS5Client";
            return "PS5";
        }
        // XboxCommonGDK?
        if(platform == UECookTargetPlatform.XboxOne) {
            return "XboxOne";
        }
        if(platform == UECookTargetPlatform.Android) {
            if(!flavour.isEmpty()) flavour = "_" + flavour;
            if(clientOnly) return "Android" + flavour + "Client";
            return "Android" + flavour;
        }
        // Hololens
        if(platform == UECookTargetPlatform.IOS) {
            if(clientOnly) return "IOSClient";
            return "IOS";
        }
        if(platform == UECookTargetPlatform.Linux) {
            if(dedicatedSever) return "Linux" + flavour + "Server";
            if(clientOnly) return "Linux" + flavour + "Client";
            return "Linux" + flavour + "NoEditor";
        }
        if(platform == UECookTargetPlatform.Lumin) {
            if(clientOnly) return "LuminClient";
            return "Lumin";
        }
        if(platform == UECookTargetPlatform.Windows) {
            if(dedicatedSever) return "WindowsServer";
            if(clientOnly) return "WindowsClient";
            return "WindowsNoEditor";
        }
        if(platform == UECookTargetPlatform.TVOS) {
            return "TVOS";
        }

        return "<invalid platform>";
    }*/

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
