<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="bs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>

<c:set var="currentGroup" value=""/>

<c:forEach items="${arguments}" var="arg">
    <c:choose>
        <c:when test="${prefix != null}">
            <c:set var="argName" value="${prefix}.${arg}"/>
        </c:when>
        <c:otherwise>
            <c:set var="argName" value="${arg}"/>
        </c:otherwise>
    </c:choose>

    <c:if test="${currentGroup != arg.getGroup()}">
        <tr class="groupingTitle">
            <td colspan="2">${arg.getGroup()}</td>
        </tr>
    </c:if>
    <c:set var="currentGroup" value="${arg.getGroup()}"/>

    <tr <c:if test="${arg.getAdvanced() == true}">class="advancedSetting"</c:if>>
        <th>
            <label for="${argName}"><c:if test="${arg.getHasParent() == true}">&#11169;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>${arg.getFriendlyName()}:<c:if test="${arg.getRequired() == true}"><l:star/></c:if></label>
            <c:forEach items="${arg.getHelpLinks()}" var="helpLink">
                <bs:help urlPrefix="${helpLink}" file=""/>
            </c:forEach>
        </th>
        <td>
            <c:choose>
                <c:when test="${arg.getType() == 'String'}">
                    <props:textProperty name="${argName}" size="${arg.getFieldSize()}" maxlength="${arg.getMaxLength()}">
                        <jsp:attribute name="afterTextField">
                        <c:if test="${arg.getAllowPickFromVCS() == true}">
                           <bs:vcsTree fieldId="${argName}"/>
                        </c:if>
                        </jsp:attribute>
                    </props:textProperty>
                </c:when>
                <c:when test="${arg.getType() == 'MultilineString'}">
                    <props:multilineProperty expanded="true" name="${argName}" rows="${arg.getRowsNum()}" cols="${arg.getColsNum()}" linkTitle="${arg.getLinkTitle()}" className="longField"/>
                </c:when>
                <c:when test="${arg.getType() == 'Bool'}">
                    <props:checkboxProperty name="${argName}"/>
                </c:when>
                <c:when test="${arg.getType() == 'Select'}">
                    <c:set var="modeSelected" value="${propertiesBean.properties[argName]}"/>
                    <props:selectProperty name="${argName}" className="mediumField">
                        <c:forEach items="${arg.getOptions()}" var="option">
                            <props:option value="${option}" currValue="${modeSelected}">${option}</props:option>
                        </c:forEach>
                    </props:selectProperty>
                </c:when>
                <c:when test="${arg.getType() == 'BoolMatrix'}">
                    <div id="bool_matrix">
                        <c:forEach items="${arg.getBools()}" var="bool">
                            <table style="border: 1px solid grey">
                                <tr style="line-height: 1.0em;">
                                    <th style="min-width:${arg.getMinWidth()}px;padding-right:0px">
                                        <label for="${argName}.${bool}">${bool}</label>
                                    </th>
                                    <td style="padding:0px">
                                        <props:checkboxProperty name="${argName}.${bool}"/>
                                    </td>
                                </tr>
                            </table>
                        </c:forEach>
                    </div>
                </c:when>
                <c:otherwise>Error: Argument of type ${argName} does not have field defined</c:otherwise>
            </c:choose>

            <span class="error" id="error_${argName}"></span>
            <c:if test="${not empty arg.getDescription()}">
                <span class="smallNote">${arg.getDescription()}</span>
            </c:if>
        </td>
    </tr>
</c:forEach>