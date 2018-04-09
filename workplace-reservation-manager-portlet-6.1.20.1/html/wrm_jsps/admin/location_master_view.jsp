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
<liferay-ui:success key="location-added" message="Location-Added-Successfully" />
<liferay-ui:success key="location-updated" message="Location-Updated-Successfully" />
<liferay-ui:success key="location-deleted" message="Location-Deleted-Successfully" />
<liferay-ui:success key="location-deleteselected" message="Location-Deleteselected-Successfully" />
<liferay-ui:error key="location-duplicate" message="Location-Duplicated"></liferay-ui:error>
<liferay-ui:error key="location-notselected" message="Location-is-not-Selected"></liferay-ui:error>
<liferay-ui:error key="LocationName-required" message="locationname-required"></liferay-ui:error>
<jsp:useBean id="addLocationURL" class="java.lang.String" scope="request" />
<jsp:useBean id="deleteselectedLocationURL" class="java.lang.String" scope="request" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function validate2()
{
		
	if(validate()==false)
	{
		return false;
	}
	else if(validate1()==false)
	{
		return false;
	}
	submitForm(document.<portlet:namespace />fm);	 
}
function validate()
{
	 var cityId=document.getElementById("cityId").selectedIndex;
	 if(cityId==0)
     {
  	    str="Please Select City.";    
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
	 var locationName=document.forms['<portlet:namespace/>fm'].locationName.value;
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
<aui:script>
Liferay.provide(
		window,
		'<portlet:namespace />saveEntry',
		function(url) {
			      		document.<portlet:namespace />fm.<portlet:namespace />locationId.value =  Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			      		  document.forms['<portlet:namespace/>fm'].action=url;
			      		  document.forms['<portlet:namespace/>fm'].method="POST";
			      		  
			      		  submitForm(document.<portlet:namespace />fm);	      		
			  	},
		['liferay-util-list-fields']
	);
</aui:script>
<aui:form action="<%=addLocationURL%>" method="post" name="fm">
<aui:input type="hidden" name='locationId' id='locationId' value=''/>
<div class="message" id="message"></div>

<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%=true%>">
<table class="wrm-font">
   <tr>
      <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 10px;">
        <liferay-ui:message key="CITY" /><p1 style="color:red;">*</p1>
        <select name="cityId" id="cityId" onchange="return validate();">
         <option value='0'>Select City</option>
         <c:forEach items="${allCity}" var="city">
	        <option value="${city.cityId}">${city.cityName}</option>
	     </c:forEach>
        </select>
      </td>
      <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 10px;">
         <liferay-ui:message key="LOCATION" /><p1 style="color:red;">*</p1>
    	 <input type="text" name="locationName" id="locationName" value="" size="45" />
      </td >
      <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 10px;">
         <input type="button" value="Add Location" onclick="return validate2();">
      </td>
      <td  class="lfr-label" style="padding-left: 5px;padding-top: 25px;">
        <liferay-ui:icon-help message="Allow you to add new Location." />
    </td>
</table>

<br/><br/>

     
<liferay-ui:panel collapsible="<%=true%>"  defaultState="open" extended="<%=true%>" id="allTasksPanel" persistState="<%=true%>" title='Location'>

<%
	String clicklink=renderResponse.getNamespace()+"saveEntry('"+deleteselectedLocationURL +"')";
%>

   <input type="button" name="deleteSelectedLocation" value="Delete Selected" onClick="<%=clicklink%>">

<%
	PortletURL locationIteratorURL = renderResponse.createRenderURL();
    locationIteratorURL.setParameter("javax.portlet.action", "addLocation");
    locationIteratorURL.setParameter("location_add", "location_add");
    locationIteratorURL.setParameter("tabs1","LocationMaster");
	pageContext.setAttribute("locationIteratorURL", locationIteratorURL);
%>

        <liferay-ui:search-container  iteratorURL="<%=locationIteratorURL%>" rowChecker="<%=new RowChecker(renderResponse)%>" delta="<%=WRMConstants.DELTA%>">
        <liferay-ui:search-container-results>
           <%
		   List<LocationMaster> allLocation = (List<LocationMaster>)request.getAttribute("allLocation");
		   results = ListUtil.subList(allLocation, searchContainer.getStart(), searchContainer.getEnd());
		   total = allLocation.size();
		   pageContext.setAttribute("results", results);
		   pageContext.setAttribute("total", total);
    	   %>
    	 </liferay-ui:search-container-results>
    	 <liferay-ui:search-container-row
		       className="com.cignexdatamatics.wrm.model.LocationMaster"
		       keyProperty="locationId"
		       modelVar="location">

		 <%  long cityId=location.getCityId();
             CityMaster cityMaster = CityMasterLocalServiceUtil.findCitybyCityId(cityId);
             String cityName=cityMaster.getCityName();%>


	     <liferay-ui:search-container-column-text
					name="City"
					value="<%=cityName%>"
		 />

		  <liferay-ui:search-container-column-text
					name="Location"
					value="<%= location.getLocationName() %>"
		 />

		  <liferay-ui:search-container-column-text>
		  <liferay-ui:icon-menu cssClass="">

		  <!--Edit Action-->
		  <portlet:actionURL name="editLocation" var="editLocationURL">
			 <portlet:param name="resourcePrimKey" value="<%=String.valueOf(location.getPrimaryKey()) %>" />
		  </portlet:actionURL>
		  <liferay-ui:icon image="edit" url="<%=editLocationURL.toString() %>" />

		  <!--Delete Action-->
		  <portlet:actionURL name="deleteLocation" var="deleteLocationURL">
			 <portlet:param name="resourcePrimKey" value="<%= String.valueOf(location.getPrimaryKey()) %>" />
		  </portlet:actionURL>
		  <liferay-ui:icon image="delete" url="<%=deleteLocationURL.toString() %>" />

		  </liferay-ui:icon-menu>
		  </liferay-ui:search-container-column-text>
	      </liferay-ui:search-container-row>
		  <liferay-ui:search-iterator />
          </liferay-ui:search-container>

</liferay-ui:panel>
</liferay-ui:panel-container>   
</aui:form>
