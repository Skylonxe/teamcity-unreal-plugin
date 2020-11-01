<%@ page import="com.ondrejhrusovsky.teamcity.unrealPlugin.UATRunnerConstants" %>
<%@ page import="com.ondrejhrusovsky.teamcity.unrealPlugin.UATArgument" %>
<%@ page import="com.ondrejhrusovsky.teamcity.unrealPlugin.Arg_UProjectFile" %>
<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="bs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>

<c:set var="argument_preset" value="<%=UATRunnerConstants.PRESET_KEY%>"/>

<style type="text/css">
    #bool_matrix {
      display: flex;
      flex-wrap: wrap;
      max-width: 400px;
      font-size: 8pt;
    }
</style>

<l:settingsGroup title="UAT Runner Parameters">
    <c:set var="arguments" value="<%=UATRunnerConstants.Arguments%>"/>
    <%@ include file="args.jsp" %>
    <tr>
        <th>
            <label for="${argument_preset}">Preset:</label>
        </th>
        <td>
            <props:selectProperty name="${argument_preset}" onchange="BS.UATRunner.onModeChanged()" enableFilter="true" className="mediumField">
                <c:forEach items="<%=UATRunnerConstants.PRESETS%>" var="preset">
                    <props:option value="${preset}" currValue="${modeSelected}">${preset.getFriendlyName()}</props:option>
                </c:forEach>
            </props:selectProperty>
        </td>
    </tr>
</l:settingsGroup>


<l:settingsGroup title="Preset Parameters">
    <c:forEach items="<%=UATRunnerConstants.PRESETS%>" var="preset">
        <%@ include file="preset.jsp" %>
    </c:forEach>
</l:settingsGroup>


<script type="text/javascript">
  BS.UATRunner = {
    onModeChanged:function () {
      var sel = $('${argument_preset}');
      var selectedValue = sel[sel.selectedIndex].value;

      <c:forEach items="<%=UATRunnerConstants.PRESETS%>" var="preset">
        BS.Util.hide('${preset}');
      </c:forEach>

      BS.Util.show(selectedValue);
      BS.VisibilityHandlers.updateVisibility('mainContent');
    }
  };
  BS.UATRunner.onModeChanged();
</script>