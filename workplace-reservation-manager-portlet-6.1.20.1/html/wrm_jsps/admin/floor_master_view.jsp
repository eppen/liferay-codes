<%-- 

Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
This library is free software; you can redistribute it and/or modify it under the terms of the 
GNU Lesser General Public License as published by the Free Software Foundation; either 
version 2.1 of the License, or (at your option) any later version.
This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE. See the GNU Lesser General Public License for more details. 

--%>

<%@ include file="/html/wrm_jsps/init.jsp" %>
<liferay-ui:success key="floor-added" message="Floor-Added-Successfully" />
<liferay-ui:success key="floor-updated" message="Floor-Updated-Successfully" />
<liferay-ui:success key="floor-deleted" message="Floor-Deleted-Successfully" />
<liferay-ui:success key="floor-deleteselected" message="Floor-Deleteselected-Successfully" />
<liferay-ui:error key="floor-duplicate" message="Floor-Duplicated"/>
<liferay-ui:error key="floor-notselected" message="Floor-is-not-Selected"/>
<liferay-ui:error key="FloorName-required" message="floorname-required"/>
<jsp:useBean id="addFloorURL" class="java.lang.String" scope="request" />
<jsp:useBean id="deleteselectedFloorURL" class="java.lang.String" scope="request" />

<%
	String ctxPath = request.getContextPath();
	if (ctxPath != null && ctxPath.length() == 1) {
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
	ajaxCall(sURL,"locationId");
}
function validate3()
{
	
	if(validate()==false)
	{
		
		return false;
	}
	else if(validate1()==false)
	{
		return false;
	}
	else if(validate2()==false)
	{
		return false;
	}
	else
	{
		  submitForm(document.<portlet:namespace />fm);	   
	}	
	
	
}
function validate()
{	 
	
     var cityId=document.getElementById("cityId").selectedIndex; 	
 	 if(cityId==0)
     {
 		str="Please Select City!";    
      	document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("cityId").focus();
  		return false; 
     } 
 	 else
     {
 	     
    	 str="";    
     	 document.getElementById('message').innerHTML =str.fontcolor("red")		
     }
}
function validate1()
{	
	
	 validate();
	 var locationId=document.getElementById("locationId").selectedIndex;
 	 if(locationId<=0)
     {
    	str="Please Select Location!";    
       	document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("locationId").focus();
   		return false; 
     }  
     else
     {
    	 str="";    
     	 document.getElementById('message').innerHTML =str.fontcolor("red")		
     }
} 
function validate2()
{	
	
     validate1();
	 var floorName=document.getElementById("floorName").selectedIndex;
     var validate=/^[0-9]+[stndrh][stndrh]$/
 	 if(floorName<=0)
	 {
    	str="Please Select Floor!";    
     	document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("floorName").focus();
 		return false; 
	 }   
   	 else
     {
     	 str="";    
      	 document.getElementById('message').innerHTML =str.fontcolor("red")		
      }
      return true; 
 
}
</script>
<aui:script>
Liferay.provide(
		window,
		'<portlet:namespace />saveEntry',
		function(url) {
			      		document.<portlet:namespace />fm.<portlet:namespace />floorId.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			      		  document.forms['<portlet:namespace/>fm'].action=url;
			      		  document.forms['<portlet:namespace/>fm'].method="POST";
			      		  
			      		  submitForm(document.<portlet:namespace />fm);	      		
			  	},
		['liferay-util-list-fields']
	);
</aui:script>

<aui:form action="<%=addFloorURL%>" method="post" name="fm">
<aui:input type="hidden" name='floorId' id='floorId' value=''/>
<div class="message" id="message"></div>

<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%=true%>">
<table class="wrm-font">
 <tr>
      <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 10px;">
         <liferay-ui:message key="CITY" /><p1 style="color:red;">*</p1>
         <select id="cityId" onchange="findLocation();return validate();">
         <option value='0'>Select City</option>
         <c:forEach items="${allCity}" var="city">
	        <option value="${city.cityId}">${city.cityName}</option>
	     </c:forEach>
        </select>
       </td>
       <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 10px;">
         <liferay-ui:message key="LOCATION" /><p1 style="color:red;">*</p1>
        <select id="locationId" name="locationId" onchange="return validate1();" onclick="return validate();">
         <option value='0'>Select Location</option>
        </select>
        </td>
        <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 10px;">
    	      <liferay-ui:message key="FLOOR" /><p1 style="color:red;">*</p1>
    	      <select name="floorName" id="floorName" onchange="return validate2();">  
    	      <option value="0">Select Floor</option> 
    	      <c:forEach items="${wrmFloors}" var="floor">
			        <option value="${floor}">${floor}</option>
			  </c:forEach>
    	     </select>    	   
        </td>
        <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 10px;">
              <input type="button" value="Add Floor" onclick="return validate3();"/>
       </td>
       <td  class="lfr-label" style="padding-left: 5px;padding-top: 25px;">
           <liferay-ui:icon-help message="Allow you to add new Floor." />
       </td>       
</tr>
</table>
<br/><br/>    
<liferay-ui:panel collapsible="<%=true%>" defaultState="open" extended="<%=true%>" id="allTasksPanel" persistState="<%=true%>" title='Floor'>

<%
	String clicklink=renderResponse.getNamespace()+"saveEntry('"+deleteselectedFloorURL+"')";
%>

    <input type="button" name="deleteSelectedFloor" value="Delete Selected"  onClick="<%=clicklink%>">

<%
	PortletURL floorIteratorURL = renderResponse.createRenderURL();
    floorIteratorURL.setParameter("javax.portlet.action", "addFloor");
    floorIteratorURL.setParameter("floor_add", "flooradd");
    floorIteratorURL.setParameter("tabs1","FloorMaster");
	pageContext.setAttribute("floorIteratorURL", floorIteratorURL);
%>

       <liferay-ui:search-container  iteratorURL="<%=floorIteratorURL%>" rowChecker="<%=new RowChecker(renderResponse)%>" delta="<%=WRMConstants.DELTA%>">
       <liferay-ui:search-container-results>
		<%
		List<FloorMaster> allFloor= (List<FloorMaster>)request.getAttribute("allFloor");
		results = ListUtil.subList(allFloor, searchContainer.getStart(), searchContainer.getEnd());
		total = allFloor.size();
		pageContext.setAttribute("results", results);
		pageContext.setAttribute("total", total);
		%>
        </liferay-ui:search-container-results>

        <liferay-ui:search-container-row
			className="com.cignexdatamatics.wrm.model.FloorMaster"
			keyProperty="floorId"
			modelVar="floor">

	 	 <% long locationId=floor.getLocationId();
            LocationMaster locationMaster = LocationMasterLocalServiceUtil.findLocationbyLocationId(locationId);
            String locationName=locationMaster.getLocationName();
            long cityId=locationMaster.getCityId();
            CityMaster citymaster=CityMasterLocalServiceUtil.findCitybyCityId(cityId);
            String cityName=citymaster.getCityName();
         %>
 		<liferay-ui:search-container-column-text
					name="City"
					value="<%=cityName%>"	 />


	     <liferay-ui:search-container-column-text
					name="Location"
					value="<%=locationName%>" />

		<liferay-ui:search-container-column-text
					name="Floor"
					property="floorName" 	 />

		<liferay-ui:search-container-column-text>
		<liferay-ui:icon-menu cssClass="">

		<!--Edit Action-->
		<portlet:actionURL name="editFloor" var="editFloorURL">
		     <portlet:param name="resourcePrimKey" value="<%=String.valueOf(floor.getPrimaryKey()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon image="edit" url="<%=editFloorURL.toString() %>" />

		<!--Delete Action-->
		<portlet:actionURL name="deleteFloor" var="deleteFloorURL">
              <portlet:param name="resourcePrimKey" value="<%=String.valueOf(floor.getPrimaryKey()) %>" />
        </portlet:actionURL>
        <liferay-ui:icon image="delete" url="<%=deleteFloorURL.toString() %>" />

   		</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
        </liferay-ui:search-container>

</liferay-ui:panel>
</liferay-ui:panel-container>   
</aui:form>
