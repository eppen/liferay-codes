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
<jsp:useBean class="java.lang.String" id="editFacilityURL" scope="request" />
<jsp:useBean id="facility" type="com.cignexdatamatics.wrm.model.FacilityMaster" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelFacilityURL" scope="request" />
<script type="text/javascript">
function validate()
{
   
	var facilitiesName=document.forms['editFacility'].facilitiesName.value;
	if(facilitiesName=="")
	{
   		str="Please Enter Facility!";    
   		document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("facilitiesName").focus();
		return false; 
	}
	else if(isAlpha(facilitiesName)==false)
	{
   		str="Please Give Facility Name As AlphaCharacter!";    
   		document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("facilitiesName").focus();
		return false; 
	}
    else
    {
   	 	 str="";    
    	 document.getElementById('message').innerHTML =str.fontcolor("red");
    }
    return true;         
}
function isAlpha(argvalue)
{
     argvalue = argvalue.toString();
     var validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
     for (var n = 0; n < argvalue.length; n++)
     {
           if (validChars.indexOf(argvalue.substring(n, n+1)) == -1)
          return false;
     }
     return true;
}
</script>
<form name="editFacility" action="<%=editFacilityURL %>" method="POST" onSubmit="return validate();">
<input type="hidden" name="resourcePrimKey" value="<%=facility.getPrimaryKey() %>" />
<input type="hidden" name="facilitiesName2" value="<%=facility.getFacilitiesName() %>" />
<div class="message" id="message"></div>
<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%= true %>">
<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>" id="allTasksPanel" persistState="<%= true %>" title=''>
<table border="0" class="wrm-font">
	<tr>
	   	<td style="padding-left: 20px;padding-top: 20px;padding-bottom: 20px;">
			<liferay-ui:message key="FACILITY" /><p1 style="color:red;">*</p1> </td> 
		<td style="padding-left: 20px;padding-top: 20px;padding-bottom: 20px;">
			<input type="text" name="facilitiesName" id="facilitiesName" value="<%=facility.getFacilitiesName() %>" onkeyup="return validate();" size="45" />
		</td>
	</tr>
	<tr>
		<td style="padding-left: 20px;padding-bottom: 20px;">
		    <liferay-ui:message key="DESC" /> </td> 
		 <td style="padding-left: 20px;padding-bottom: 20px;">
			<input type="text" name="facilitiesDesc" value="<%=facility.getFacilitiesDesc() %>" size="45" />
		</td>
	</tr>
	<tr>
		<td style="padding-left: 20px;padding-bottom: 20px;">
		      <input type="submit" value="Submit">
		      <input type="button" value="Cancel" onClick="self.location = '<%=cancelFacilityURL %>';" />
		</td>
		<td style="padding-left: 20px;padding-bottom: 20px;">			
		</td>
	</tr>
	
</table><br/><br/><br/><br/>
</liferay-ui:panel>
</liferay-ui:panel-container>   
</form>