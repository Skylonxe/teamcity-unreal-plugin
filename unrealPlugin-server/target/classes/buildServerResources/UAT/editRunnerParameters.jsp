<%@ page import="com.ondrejhrusovsky.teamcity.unrealPlugin.UAT.UATConstants" %>
<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="bs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>

<%@ include file="../styles.jsp" %>

<c:set var="constants" value="<%= UATConstants.get() %>"/>
<%@ include file="../editPreset.jsp" %>
