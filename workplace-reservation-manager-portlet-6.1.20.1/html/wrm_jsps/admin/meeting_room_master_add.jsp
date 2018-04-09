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
<jsp:useBean id="addRoomURL" class="java.lang.String" scope="request" />
<jsp:useBean id="addRoomCancelURL" class="java.lang.String" scope="request" />
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
function ajaxCall(serverURL,id)
{

	jQuery.ajax({
		url: serverURL,
		async: false,
		success: function(data)
		{
			jQuery('#' +id).html(data);
		}
     });
}
function findLocation()
{
	var cityId=document.getElementById("cityId").selectedIndex;
	var city= document.getElementById("cityId").options[cityId].value;
	var sURL = "<%=ctxPath%>/html/ajaxAction/findLocationActions.jsp?CityID="+city;
	ajaxCall(sURL, "locationId");
}
function findFloor()
{
	var locationId=document.getElementById("locationId").selectedIndex;
	var location= document.getElementById("locationId").options[locationId].value;
	var sURL = "<%=ctxPath%>/html/ajaxAction/findFloorActions.jsp?locationID="+location;
	ajaxCall(sURL, "floorId");
}
function validate1()
{
	var v1=validate();
	var v5=validateRoom();
	var v6=validateLocation();
	var v7=validateFloor();
	var v2=capacitycheck();
	var v3=extensioncheck();
	if(v1==false)
	{
		return false;
	}
	else if(v6==false)
	{
		return false;
	}
	else if(v7==false)
	{
		return false;
	}
	else if(v5==false)
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
	  var timeout=5000;
	  var cityId=document.getElementById("cityId").selectedIndex;
	  if(cityId<1)
	  {
	 		str="Please Select City!";    
	      	document.getElementById('message1').innerHTML =str.fontcolor("red");
	        document.getElementById("cityId").focus();
	  		return false; 
	  }
	  else
	  {
	    	 str="";    
	     	 document.getElementById('message1').innerHTML =str.fontcolor("red")		
	  }	     
      return true;      
}
function validateLocation()
{
	if(validate()==true)
	{
	  var locationId=document.getElementById("locationId").selectedIndex;
	  if(locationId<1)
	  {
	    	str="Please Select Location!";    
	       	document.getElementById('message2').innerHTML =str.fontcolor("red");
	        document.getElementById("locationId").focus();
	   		return false; 
	  }
	  else
	  {
	    	 str="";    
	     	 document.getElementById('message2').innerHTML =str.fontcolor("red")		
	  }
	  return true;
	}
}
function validateFloor()
{
	if(validateLocation()==true)
	{
	 var floorId=document.getElementById("floorId").selectedIndex;
     if(floorId<1)
     {
   	    str="Please Select Floor!";    
	       	document.getElementById('message3').innerHTML =str.fontcolor("red");
	        document.getElementById("floorId").focus();
	   		return false; 
     }
     else
     {
    	 str="";    
     	 document.getElementById('message3').innerHTML =str.fontcolor("red")		
     }
	}
     return true;
}
function validateRoom()
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



<aui:form action="<%=addRoomURL%>" method="post" name="fm" onSubmit='<%="event.preventDefault();" + renderResponse.getNamespace() + "saveSelectBoxes();return validate1();" %>'>
<input type="hidden" name='roomId' id='roomId' value=''/>
<aui:input type="hidden" name="selectedFac"/>


<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%= true %>">
<liferay-ui:panel collapsible="<%=true%>" defaultState="open" extended="<%=true%>" id="allTasksPanel" persistState="<%= true %>" title='Room'>
<br/>
<table  height="300" width="400" cellpadding="2"  style='table-layout:fixed' class="wrm-font">
<tr>
   <td style="padding-left: 15px;">
        <liferay-ui:message key="CITY" /><p1 style="color:red;">*</p1>
   </td>
   <td>       
        <select id="cityId" name="cityId"  onchange="findLocation();return validate();" >
          <option value='0'>Select City</option>
          <c:forEach items="${allCity}" var="city">
	        <option value="${city.cityId}">${city.cityName}</option>
	     </c:forEach>
        </select>
   </td>
      <td><div class="message1" id="message1"></div></td>
  
</tr>

<tr>
     <td style="padding-left: 15px;">
        <liferay-ui:message key="LOCATION" /><p1 style="color:red;">*</p1>
     </td>
     <td>
        <select id="locationId" name="locationId"  onchange="findFloor();return validateLocation();">
        </select>
     </td>
      <td><div class="message2" id="message2"></div></td>
</tr>

<tr>
   <td style="padding-left: 15px;">
        <liferay-ui:message key="FLOOR" /><p1 style="color:red;">*</p1>
   </td>
   <td>   
        <select id="floorId" name="floorId" onchange="return validateFloor();">  </select>
   </td>
   <td><div class="message3" id="message3"></div></td>
<tr>

<tr>
   <td style="padding-left: 15px;">
        <liferay-ui:message key="ROOM" /><p1 style="color:red;">*</p1>
    </td>
    <td>
        <input type="text" name="roomName" id="roomName" value="" size="15" onkeyup="return validateRoom();"/>
   </td>
    <td><div class="message4" id="message4"></div></td>
</tr>
<tr>
   <td style="padding-left: 15px;">
         <liferay-ui:message key="CAPACITY" /><p1 style="color:red;">*</p1>
    </td>
    <td>
         <input type="text" name="capacity" id="capacity" value="0" size="15" onkeyup="return capacitycheck()" />
   </td>
    <td><div class="message5" id="message5"></div></td>
</tr>

<tr>
   <td style="padding-left: 15px;">
         <liferay-ui:message key="EXTENSION" />
   </td>
   <td>  
         <input type="text" name="extension" id="extension" value="0" size="15" onkeyup=" return extensioncheck()"/>
   </td>  
   <td><div class="message6" id="message6"></div></td>
</tr>

</table>
<br/><br/>
<table class="wrm-font">
 <tr>
   <td style="padding-left: 15px;">
     <liferay-ui:search-container>
         <liferay-ui:search-container-results>
         <%
           List<FacilityMaster> allFacility = (List<FacilityMaster>)request.getAttribute("allFacility");
           Iterator it3= allFacility.iterator();

           while(it3.hasNext())
           {
        	   FacilityMaster facility=(FacilityMaster)it3.next();
               kvp = new KeyValuePair();
               kvp.setKey(String.valueOf(facility.getFacilitiesId()));
               kvp.setValue(facility.getFacilitiesName());
               leftList.add(kvp);
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
   <td style="padding-left: 15px;">
         <input type="submit" value="Add Room" >
   </td><td style="padding-left: 15px;">      
          <input type="button" name="Cancel" value="Cancel" onClick="self.location = '<%=addRoomCancelURL %>';">
   </td>  
 </tr>
</table> 
<br/><br/>
</liferay-ui:panel>
</liferay-ui:panel-container>  
</aui:form>
