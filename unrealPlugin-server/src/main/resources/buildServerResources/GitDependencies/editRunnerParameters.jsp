
<%@ page import="com.ondrejhrusovsky.teamcity.unrealPlugin.GitDependencies.GitDependenciesConstants" %>
<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="bs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>

<%@ include file="../styles.jsp" %>

<l:settingsGroup title="Git Dependencies Runner Parameters">
    <c:set var="arguments" value="<%=GitDependenciesConstants.get().getGlobalArguments()%>"/>
    <%@ include file="../args.jsp" %>

    <tr>
        <th>
            <label for="run_only_once">Run only once:</label>
        </th>
        <td>
            <props:checkboxProperty name="run_only_once"/>
            <span class="error" id="error_run_only_once"></span>
            <span class="smallNote">If enabled, quickly checks for single dependency file to determine whether depedencies were already installed before. If yes, skips the depedency checking. Useful when actual dependency checking can be too slow (e.g. because of the slow drive). If you migrate to different engine version which requires different dependencies it might be necessary for you to disable this and let dependencies fully update.</span>
        </td>
    </tr>

    <tr>
        <th>
            <label for="ignore_file">Ignore file:</label>
            <bs:help urlPrefix="https://github.com/EpicGames/UnrealEngine/pull/1687" file=""/>
        </th>
        <td>
            <props:multilineProperty expanded="true" name="ignore_file" rows="7" cols="30" linkTitle="" className="longField"/>
            <span class="error" id="error_run_only_once"></span>
            <span class="smallNote">Specify which files you want to skip when downloading git dependencies. Temporary .gitdepsignore file will be created for this task. Supports * (exclude dir/match pattern), ** (recursively exclude dir), ! (include previously excluded), ? single character wildcard. Docs link requires GitHub account linked with Epic Games.</span>
        </td>
    </tr>
</l:settingsGroup>