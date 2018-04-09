<%@page import="javax.portlet.PortletURL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>

</head>
<body>
<%
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/view.jsp");
%>

<liferay-ui:header title="Home"
	backLabel="Back" backURL="<%=backURL.toString()%>" />
<portlet:actionURL name="createTask" var="createTask">
</portlet:actionURL>


<form action="${createTask}" method="POST">
<aui:input name="subject"></aui:input>
<aui:input name="body"></aui:input>
<%-- <aui:input name="ownerName"></aui:input> --%>
Start date : <input id="taskStartDate" name="taskStartDate" value="" type="text"><br>
Due Date :   <input id="taskEndDate" name="taskEndDate" value="" type="text">
<input type="submit" value="Create Task">
</form>

</body>
</html>