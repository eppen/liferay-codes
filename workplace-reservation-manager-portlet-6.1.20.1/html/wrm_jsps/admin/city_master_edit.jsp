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
<jsp:useBean class="java.lang.String" id="editCityURL" scope="request" />
<jsp:useBean id="city" type="com.cignexdatamatics.wrm.model.CityMaster" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelCityURL" scope="request" />
<liferay-ui:error key="city-duplicate" message="City-Duplicated"/>

<script type="text/javascript">
function validate()
{
	var cityName=document.forms['editCity'].cityName.value;
    if(cityName=="")
	{
    	str="Please Enter City Name!";   
   		document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("cityName").focus();
		return false; 
	}
    else if(isAlpha(cityName)==false)
	{
   	    str="Please Give City Name As Alphacharacter !";     
     	document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("cityName").focus();
		return false; 
	 }
    else
    {
   	     str="";    
    	 document.getElementById('message').innerHTML =str.fontcolor("red")		
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

<form name="editCity" action="<%=editCityURL%>" method="POST" onSubmit="return validate();">
<input type="hidden" name="resourcePrimKey" value="<%=city.getPrimaryKey() %>">
<input type="hidden" name="cityName1" value="<%=city.getCityName() %>">
<div class="message" id="message"></div>
<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%= true %>">
<liferay-ui:panel collapsible="<%=true%>" defaultState="open" extended="<%=true%>" id="allTasksPanel" persistState="<%= true %>" title=''>
<table border="0" class="wrm-font">
	<tr>
		<td style="padding-left: 20px;padding-top: 20px;padding-bottom: 20px;">
	    	<liferay-ui:message key="CITY" /><p1 style="color:red;">*</p1>
	    </td>
	    <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 20px;">
			<input type="text" name="cityName" id="cityName" value="<%=city.getCityName() %>" size="45" onkeyup="return validate();"/>
		</td>
		<td style="padding-left: 20px;padding-top: 20px;padding-bottom: 20px;"><input type="submit" value="Submit"></td>
        <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 20px;"><input type="button" value="Cancel"  onClick="self.location = '<%=cancelCityURL %>';"/>
        </td>
	</tr>
</table>
</liferay-ui:panel>
</liferay-ui:panel-container>   
</form>