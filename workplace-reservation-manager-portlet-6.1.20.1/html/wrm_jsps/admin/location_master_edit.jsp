<%-- 

Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
This library is free software; you can redistribute it and/or modify it under the terms of the 
GNU Lesser General Public License as published by the Free Software Foundation; either 
version 2.1 of the License, or (at your option) any later version.
This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE. See the GNU Lesser General Public License for more details. 

--%>

<%@include file="/html/wrm_jsps/init.jsp" %>
<jsp:useBean class="java.lang.String" id="editLocationURL" scope="request" />
<jsp:useBean id="location" type="com.cignexdatamatics.wrm.model.LocationMaster" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelLocationURL" scope="request" />
<script type="text/javascript">
function validate()
{
	 var locationName=document.forms['editLocation'].locationName.value;
	 if(locationName=="")
	 {
    	str="Please Enter Location Name!";      
    	document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("locationName").focus();
		return false; 
	 }
	 else if(isAlphaNumeric(locationName)==false)
	 {
    	str="Please Give Location Name As AlphaNumeric Character !";    
    	document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("locationName").focus();
		return false; 
	 }
     else
     {
    	 str="";    
     	 document.getElementById('message').innerHTML =str.fontcolor("red")	
     	 return true;     	 	
     }
}
function isAlphaNumeric(argvalue)
{
      argvalue = argvalue.toString();
      var validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
      for (var n = 0; n < argvalue.length; n++)
      {
 		   if(validChars.indexOf(argvalue.substring(n, n+1)) == -1)
           return false;
      }
      return true;
}
</script>
<form name="editLocation" action="<%=editLocationURL %>" method="POST" onSubmit="return validate();">
<input type="hidden" name="resourcePrimKey" value="<%=location.getPrimaryKey() %>" />
<input type="hidden" name="cityId" value=<%=location.getCityId() %>" />
<input type="hidden" name='locationName1'  value="<%=location.getLocationName() %>" />
<div class="message" id="message"></div>
<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%= true %>">
<liferay-ui:panel collapsible="<%=true%>" defaultState="open" extended="<%=true%>" id="allTasksPanel" persistState="<%= true %>" title=''>
<table border="0" class="wrm-font">
	<tr>
	   	<td style="padding-left: 20px;padding-top: 20px;padding-bottom: 20px;">
		    <liferay-ui:message key="LOCATION" /><p1 style="color:red;">*</p1>
			<input type="text" name="locationName" id="locationName" value="<%=location.getLocationName() %>" onkeyup="return validate();" size="45" />
		</td>		
         <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 20px;">
             <input type="submit" value="Submit">
          </td>
         <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 20px;">
             <input type="button" value="Cancel" onClick="self.location = '<%=cancelLocationURL %>';" />
	     </td>
	</tr>
</table>
</liferay-ui:panel>
</liferay-ui:panel-container> 
</form>