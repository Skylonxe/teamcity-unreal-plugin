<%@ page import="com.ondrejhrusovsky.teamcity.unrealPlugin.UBTRunnerConstants" %>
<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="bs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>

<style type="text/css">
    #bool_matrix {
        display: flex;
        flex-wrap: wrap;
        max-width: 400px;
        font-size: 8pt;
    }
</style>

<l:settingsGroup title="UBT Runner Parameters">
    <c:set var="arguments" value="<%=UBTRunnerConstants.Arguments%>"/>
    <%@ include file="args.jsp" %>

    <tr>
        <th>
            <label for="publishManifestFiles">&#11169;&nbsp;&nbsp;&nbsp;&nbsp;Publish Manifest Files as Artifacts:</label>
        </th>
        <td>
            <props:checkboxProperty name="publishManifestFiles"/>
            <span class="error" id="error_publishManifestFiles"></span>
            <span class="smallNote">"Uploads files listed in the manifest to the teamcity server as artifacts."</span>
        </td>
    </tr>
</l:settingsGroup>