package com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.BuildCookRun.Cook;

import com.ondrejhrusovsky.teamcity.unrealPlugin.ArgBase_String;

import java.util.Map;

public class Arg_CookCultures extends ArgBase_String {
    public Arg_CookCultures()
    {
        friendlyName = "Cultures";
        description = "Localization cultures (e.g. en-US) which should be included. If no cultures are specified, default CulturesToStage defined in Project Settings are used.";
        group = "Localization";
    }

    @Override
    public String makeArgumentString(Map<String, String> params) {
        return IfArgIsPresentAndNonEmpty(params, "-CookCultures=" + params.get(toString()));
    }
}
