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
<jsp:useBean class="java.lang.String" id="editFloorURL" scope="request" />
<jsp:useBean id="floor" type="com.cignexdatamatics.wrm.model.FloorMaster" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelFloorURL" scope="request" />
<script type="text/javascript">
function validate()
{
	 var floorName=document.forms['editFloor'].floorName.value;
	 var validate=/^[0-9]+[stndrh][stndrh]$/
	 if(floorName=="")
	 {
    	str="Please Enter Floor Name!";    
     	document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("floorName").focus();
 		return false; 
	 }
	 else if(floorName!="Ground")
	 {
	 	 if(floorName.search(validate)==-1)
     	{
    		str="Please use Ground,1st,2nd,3rd.... format"
     		document.getElementById('message').innerHTML =str.fontcolor("red");
       		document.getElementById("floorName").focus();
 			return false; 
     	}
	 }
  	 else
     {
     	 str="";    
      	 document.getElementById('message').innerHTML =str.fontcolor("red")		
      }
      return true; 
}
</script>
<form name="editFloor" action="<%=editFloorURL %>" method="POST" onSubmit="return validate();">
<input type="hidden" name="resourcePrimKey" value="<%=floor.getPrimaryKey() %>" />
<input type="hidden" name="floorName1" value="<%=floor.getFloorName() %>" />
<input type="hidden" name="locationId" value=<%=floor.getLocationId() %>" />
<div class="message" id="message"></div>
<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%= true %>">
<liferay-ui:panel collapsible="<%=true%>" defaultState="open" extended="<%=true %>" id="allTasksPanel" persistState="<%= true %>" title=''>
<table border="0" class="wrm-font">
	<tr>
	   	<td style="padding-left: 20px;padding-top: 20px;padding-bottom: 20px;">
            <liferay-ui:message key="FLOOR"/>[format:Ground,1st,2nd.3rd..]<p1 style="color:red;">*</p1>		
            	
			<input type="text" name="floorName" id="floorName" value="<%=floor.getFloorName() %>" size="45" onkeyup="return validate();" />
		</td>
	    <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 20px;"><input type="submit" value="Submit"></td>
        <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 20px;"><input type="button" value="Cancel" onClick="self.location = '<%=cancelFloorURL %>';" />
        </td>
     </tr>

</table>
</liferay-ui:panel>
</liferay-ui:panel-container>   
</form>