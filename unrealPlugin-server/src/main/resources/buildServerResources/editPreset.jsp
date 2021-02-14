
<c:set var="argument_preset" value="${constants.getPresetKey()}"/>

<l:settingsGroup title="Runner Parameters">
    <c:set var="arguments" value="${constants.getGlobalArguments()}"/>
    <%@ include file="args.jsp" %>
    <tr>
        <th>
            <label for="${argument_preset}">Preset:</label>
        </th>
        <td>
            <props:selectProperty name="${argument_preset}" onchange="BS.Runner.onModeChanged()" enableFilter="true" className="mediumField">
                <c:forEach items="${constants.getPresets()}" var="preset">
                    <props:option value="${preset}" currValue="${modeSelected}">${preset.getFriendlyName()}</props:option>
                </c:forEach>
            </props:selectProperty>
        </td>
    </tr>
</l:settingsGroup>


<l:settingsGroup title="<br>Preset Parameters<br><br>">
    <c:forEach items="${constants.getPresets()}" var="preset">
        <%@ include file="preset.jsp" %>
    </c:forEach>
</l:settingsGroup>


<script type="text/javascript">
    BS.Runner = {
        onModeChanged:function () {
            var sel = $('${argument_preset}');
            var selectedValue = sel[sel.selectedIndex].value;

            <c:forEach items="${constants.getPresets()}" var="preset">
            BS.Util.hide('${preset}');
            </c:forEach>

            BS.Util.show(selectedValue);
            BS.VisibilityHandlers.updateVisibility('mainContent');
        }
    };
    BS.Runner.onModeChanged();
</script>