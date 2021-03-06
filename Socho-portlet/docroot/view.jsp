<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />
<html>
<head>

</head>
<body>
<portlet:renderURL var="addTopic">
   <portlet:param name="jspPage" value="/jsp/addTopic.jsp" />
</portlet:renderURL>
<portlet:renderURL var="viewIdea">
   <portlet:param name="jspPage" value="/jsp/viewIdea.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editTopic">
   <portlet:param name="jspPage" value="/jsp/viewTopic.jsp" />
</portlet:renderURL>

<%
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

if(themeDisplay.isSignedIn())
{
if(request.isUserInRole("Administrator")||request.isUserInRole("L&D Admin"))
{
%>
<a href="<%=addTopic%>">Add a Topic</a><br>
<a href="<%=editTopic%>">Update or Delete a Topic</a><br>
<a href="<%=viewIdea%>">View Ideas</a><br><br>
<%
}
%>
<portlet:renderURL var="shareIdea">
   <portlet:param name="jspPage" value="/jsp/idea.jsp" />
</portlet:renderURL>
<a href="<%=shareIdea%>">Select a Topic and Share your Idea</a><br><br>
OR <br><br>
<liferay-ui:error key="topic-already-there" message="Topic already there" />
	<portlet:actionURL name="save" var="saveURL" />
	<aui:form action="<%=saveURL %>" method="post" name="fm" enctype="multipart/form-data">
		<aui:input type="text" name="topic" label="Enter a Topic">
          <aui:validator name="max">200</aui:validator>
          <aui:validator name="required"></aui:validator>     
         </aui:input>
		
		<aui:input type="textarea" label="Share Your Idea"
                rows="5" cols="30" name="idea" >
          <aui:validator name="max">5000</aui:validator>
          <aui:validator name="required"></aui:validator>     
         </aui:input>
		
		<aui:input type="file" name="uploadedFile" label="Select a file to upload">
		</aui:input>
		
       <aui:button-row>
          <aui:button type="submit" value="Submit"/>
         <aui:button type="reset" value="Reset" last="true"/>
      </aui:button-row>
 	
	</aui:form>
	<%
}else{
%>
Please Login to Post or View!!
<%
}
%>
</body>
</html>
