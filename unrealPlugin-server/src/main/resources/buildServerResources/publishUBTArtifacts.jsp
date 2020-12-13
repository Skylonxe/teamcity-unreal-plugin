<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>

<tr>
    <th><label for="manifestPath">Manifest file:</label></th>
    <td><props:textProperty name="manifestPath" className="longField"/>
        <span class="smallNote">Path to the manifest file which should be read and files listed in it stored as artifacts.</span>
    </td>
</tr>
<tr>
    <th><label for="enginePath">Engine Root Folder:</label></th>
    <td><props:textProperty name="enginePath" className="longField"/>
        <span class="smallNote">Path to the main folder where the engine is installed (e.g. C:/Unreal/LauncherEngines/UE_4.25).</span>
    </td>
</tr>