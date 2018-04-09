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
<jsp:useBean class="java.lang.String" id="editRoomURL" scope="request" />
<jsp:useBean id="room" type="com.cignexdatamatics.wrm.model.RoomMaster" scope="request" />
<jsp:useBean id="editRoomCancelURL" class="java.lang.String" scope="request" />
<%
List leftList = new ArrayList();
List rightList = new ArrayList();
KeyValuePair kvp = null;
String ctxPath = request.getContextPath();
if (ctxPath != null && ctxPath.length() == 1)
{
	ctxPath = "";
}
%>
<script type="text/javascript">
function validate1()
{	 
	var v1=validate();
	var v2=capacitycheck();
	var v3=extensioncheck();
	if(v1==false)
	{
		return false;
	}
	else if(v2==false)
	{
		return false;
	}
	else if(v3==false)
	{
		return false;
	}
	else
	{	
		setTimeout("submitForm(document.<portlet:namespace />fm);",1000);
	}
		
}
function validate()
{
	  
      var roomName=document.forms['<portlet:namespace/>fm'].roomName.value;
      if(roomName=="")
	  {
    	    str="Please Enter Room Name!";    
	       	document.getElementById('message4').innerHTML =str.fontcolor("red");
	     	return false; 
	  }
      else
      {
     	 str="";    
      	 document.getElementById('message4').innerHTML =str.fontcolor("red")		
      }
      if(isAlphaNumeric(roomName)==false)
	  {
    	    str="Please Give Room Name As AlphaNumeric Character !";    
	       	document.getElementById('message4').innerHTML =str.fontcolor("red");
	       	return false; 
	  }
      else
      {
     	 str="";    
      	 document.getElementById('message4').innerHTML =str.fontcolor("red")		
      }
      return true;
      
}
function capacitycheck()
{
      var capacity=document.forms['<portlet:namespace/>fm'].capacity.value;
      if(capacity<=0)
	  {
    	    str="Please Enter Capacity As Digit!";    
	       	document.getElementById('message5').innerHTML =str.fontcolor("red");
	      	return false; 
	  }
      else if(isDigit(capacity)==false)
	  {
    	    str="Please Enter Capacity As Digit!";    
	       	document.getElementById('message5').innerHTML =str.fontcolor("red");
	        return false; 
	  }
      else
      {
     	 str="";    
      	 document.getElementById('message5').innerHTML =str.fontcolor("red")		
      }   
      
      return true; 
}
function extensioncheck()
{
	
	 var extension=document.forms['<portlet:namespace/>fm'].extension.value;
	
	 var reg= /^[0-9][0-9][0-9][0-9]$/;
	 var reg1=/^[0-9][0-9][0-9]$/;
	 var reg2=/^[0-9][0-9]$/;
	 var reg3=/^[0-9]$/;
	 if(extension=="")
	 {
		 str="";
		 document.getElementById('message6').innerHTML =str.fontcolor("red");
    	 return true;	
	 } 
	 else if(extension.search(reg)!=-1)
     {
    	 str="";
		 document.getElementById('message6').innerHTML =str.fontcolor("red");
    	 return true;	
	 }
     else if(extension.search(reg1)!=-1)
     {
    	 str="";
		 document.getElementById('message6').innerHTML =str.fontcolor("red");
         return true;
     }
     else if(extension.search(reg2)!=-1)
     {
    	 str="";
		 document.getElementById('message6').innerHTML =str.fontcolor("red");
         return true;
     }
     else if(extension.search(reg3)!=-1)
     {
    	 str="";
		 document.getElementById('message6').innerHTML =str.fontcolor("red");
         return true;
     }    
	 else 
     {
    	 str="Please Enter Extension As upto 4 Digit!";
		 document.getElementById('message6').innerHTML =str.fontcolor("red");
         return false;  	    	
     }
 }
function isDigit(argvalue)
{
      argvalue = argvalue.toString();
      var validChars = "1234567890";
      for (var n = 0; n < argvalue.length; n++)
      {
 		   if(validChars.indexOf(argvalue.substring(n, n+1)) == -1)
           return false;
      }
      return true;    
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
<aui:script>
Liferay.provide(
		window,
		'<portlet:namespace />saveSelectBoxes',
		function() {
			          		document.<portlet:namespace />fm.<portlet:namespace />selectedFac.value = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />selectedFac1);
					   		
      	},
		['liferay-util-list-fields']
	);
</aui:script>
<aui:form action="<%=editRoomURL %>" method="post" name="fm" onSubmit='<%="event.preventDefault();" + renderResponse.getNamespace() + "saveSelectBoxes();return validate1()" %>'>
<input type="hidden" name="resourcePrimKey" value="<%=room.getPrimaryKey() %>" />
<input type="hidden" name="cityId" value="<%=room.getCityId() %>" />
<input type="hidden" name="locationId" value="<%=room.getLocationId() %>" />
<input type="hidden" name="floorId" value="<%=room.getFloorId() %>" />
<input type="hidden" name="roomName2" value="<%=room.getRoomName() %>" />
<input type="hidden" name="extension2"  value="<%=room.getExtension() %>" />
<aui:input type="hidden" name="selectedFac" value=""/>
<div class="message" id="message"></div>
<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%= true %>">
<liferay-ui:panel collapsible="<%=true%>" defaultState="open" extended="<%=true%>" id="allTasksPanel" persistState="<%= true %>" title='Room'>
<table border="0" height="200" width="800" cellpadding="2" style='table-layout:fixed' class="wrm-font">
<tr><td>
  <table border="0" height="200" width="500" cellpadding="2" style='table-layout:fixed'>
	<tr>
	   	<td style="padding-left: 15px;">
		    <liferay-ui:message key="ROOM" /><p1 style="color:red;">*</p1>
		 </td>
		 <td >
			<input type="text" name="roomName"  id="roomName" value="<%=room.getRoomName() %>" size="20"  onkeyup="return validate();"/>
		</td>
		 <td><div class="message4" id="message4"></div></td>
	 </tr>
 
	 <tr>
		 <td style="padding-left: 15px;">
			<liferay-ui:message key="CAPACITY" /><p1 style="color:red;">*</p1>
		 </td>
		 <td>
			<input type="text" name="capacity" id="capacity" value="<%=room.getCapacity() %>" size="20" onkeyup="return capacitycheck();" />
		</td>
		 <td><div class="message5" id="message5"></div></td>
	 </tr>

	 <tr>
		<td style="padding-left: 15px;">
			<liferay-ui:message key="EXTENSION" />
		</td>
		<td>
			<input type="text" name="extension" id="extension" value="<%=room.getExtension() %>" size="20" onkeyup="return extensioncheck();" />
		</td>
					
		 <td><div class="message6" id="message6"></div></td>
    </tr>

 </table>
 </td>
</tr>
</table>
<br/><br/>
<table>
    <tr>
     <td style="padding-left: 15px;">
      <liferay-ui:search-container>
         <liferay-ui:search-container-results>
         <%
           List<FacilityMaster> allFacility = (List<FacilityMaster>)request.getAttribute("allFacility");
           Iterator allfacility= allFacility.iterator();

           List<RoomFacilityMapping> rfm= RoomFacilityMappingLocalServiceUtil.findAllMappingbyRoomId(room.getPrimaryKey());
		   Iterator selectedfacility= rfm.iterator();

		   List<String>fcIds=new ArrayList();
		   kvp = new KeyValuePair();

		   while(selectedfacility.hasNext())
           {
			 RoomFacilityMapping rfm2=(RoomFacilityMapping)selectedfacility.next();
			 FacilityMaster facility2 = FacilityMasterLocalServiceUtil.findbyFacilitiesId(rfm2.getFacilitiesId());
             fcIds.add(facility2.getFacilitiesName());
           }
           while(allfacility.hasNext())
           {
        	   FacilityMaster facility=(FacilityMaster)allfacility.next();
               kvp = new KeyValuePair();
               kvp.setKey(String.valueOf(facility.getFacilitiesId()));
               kvp.setValue(facility.getFacilitiesName());
               if(fcIds.contains(String.valueOf(facility.getFacilitiesName())))
               {
                   rightList.add(kvp);
               }
               else
               {
                   leftList.add(kvp);
               }
           }
    	 %>
    	 </liferay-ui:search-container-results>
       <liferay-ui:input-move-boxes   leftTitle="Available Facilities"   rightTitle="Selected Facilities"
    	   leftBoxName="FacilitiesList"   rightBoxName="selectedFac1"   leftList="<%= leftList %>"    rightList="<%= rightList %>" />
       </liferay-ui:search-container>
       </td>
    </tr>
</table>
<br/><br/>
<table>
    <tr>
         <td style="padding-left: 15px;"><input type="submit" value="Submit">
        </td>
         <td style="padding-left: 15px;"> 
              <input type="button" name="Cancel" value="Cancel" onClick="self.location = '<%=editRoomCancelURL %>';">
        </td> 
    </tr>
</table>
<br/><br/>
</liferay-ui:panel>
</liferay-ui:panel-container>  
 </aui:form>
