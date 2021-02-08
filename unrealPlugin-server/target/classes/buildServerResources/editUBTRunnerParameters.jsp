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
            <label for="publishManifestFiles">Publish Artifacts:</label>
        </th>
        <td>
            <props:radioButtonProperty name="publishManifestFiles" value="no" checked="${propertiesBean.properties[publishManifestFiles] == 0}" id="pmf_no"/>
            <label for="pmf_no">No</label>
            <props:radioButtonProperty name="publishManifestFiles" value="yes" checked="${propertiesBean.properties[publishManifestFiles] == 0}" id="pmf_yes"/>
            <label for="pmf_yes">Yes</label>
            <props:radioButtonProperty name="publishManifestFiles" value="yes_zip" checked="${propertiesBean.properties[publishManifestFiles] == 0}" id="pmf_yes_zipped"/>
            <label for="pmf_yes_zipped">Yes (zipped)</label>
            <span class="error" id="error_publishManifestFiles"></span>
            <span class="smallNote">Uploads UBT output files (compiled binaries) to the TeamCity server as artifacts. Optionally, it is possible to choose uploading artifacts as single zip archive what significantly lowers storage requirements and upload times but adds additional time for zipping.</span>
        </td>
    </tr>
</l:settingsGroup>