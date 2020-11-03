<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="bs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>

<c:forEach items="${arguments}" var="arg">
    <tr>
        <th>
            <label for="${arg}">${arg.getFriendlyName()}:<c:if test="${arg.getRequired() == true}"><l:star/></c:if></label>
        </th>
        <td>
            <c:choose>
                <c:when test="${arg.getType() == 'String'}">
                    <props:textProperty name="${arg}" size="${arg.getFieldSize()}" maxlength="${arg.getMaxLength()}">
                        <jsp:attribute name="afterTextField">
                        <c:if test="${arg.getAllowPickFromVCS() == true}">
                           <bs:vcsTree fieldId="${arg}"/>
                        </c:if>
                        </jsp:attribute>
                    </props:textProperty>
                </c:when>
                <c:when test="${arg.getType() == 'Bool'}">
                    <props:checkboxProperty name="${arg}"/>
                </c:when>
                <c:when test="${arg.getType() == 'Select'}">
                    <c:set var="modeSelected" value="${propertiesBean.properties[arg]}"/>
                    <props:selectProperty name="${arg}" className="mediumField">
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
                                        <label for="${arg}.${bool}">${bool}</label>
                                    </th>
                                    <td style="padding:0px">
                                        <props:checkboxProperty name="${arg}.${bool}"/>
                                    </td>
                                </tr>
                            </table>
                        </c:forEach>
                    </div>
                </c:when>
                <c:otherwise>Error: Argument of type ${arg} does not have field defined</c:otherwise>
            </c:choose>

            <span class="error" id="error_${arg}"></span>
            <c:if test="${not empty arg.getDescription()}">
                <span class="smallNote">${arg.getDescription()}</span>
            </c:if>
        </td>
    </tr>
</c:forEach>