<%-- 

Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
This library is free software; you can redistribute it and/or modify it under the terms of the 
GNU Lesser General Public License as published by the Free Software Foundation; either 
version 2.1 of the License, or (at your option) any later version.
This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE. See the GNU Lesser General Public License for more details. 

--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/html/wrm_jsps/init.jsp" %>
<liferay-ui:success key="facility-added" message="Facility-Added-Successfully" />
<liferay-ui:success key="facility-updated" message="Facility-Updated-Successfully" />
<liferay-ui:error key="facility-duplicate" message="Facility-Duplicated"/>
<liferay-ui:success key="facility-deleted" message="Facility-Deleted-Successfully" />
<liferay-ui:success key="facility-deletedselected" message="Facility-Deleteselected-Successfully" />
<liferay-ui:error key="facility-notselected" message="Facility-is-not-Selected"/>
<liferay-ui:error key="FacilitiesName-required" message="faclityname-required"/>
<jsp:useBean id="addFacilityURL" class="java.lang.String" scope="request" />
<jsp:useBean id="deleteselectedFacilityURL" class="java.lang.String" scope="request" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function validate()
{
	var facilitiesName=document.forms['<portlet:namespace/>fm'].facilitiesName.value;
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
	submitForm(document.<portlet:namespace />fm);	       
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
<aui:script>
Liferay.provide(
		window,
		'<portlet:namespace />saveEntry',
		function(url) {
			      		document.<portlet:namespace />fm.<portlet:namespace />facilitiesId.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			      		  document.forms['<portlet:namespace/>fm'].action=url;
			      		  document.forms['<portlet:namespace/>fm'].method="POST";
			      		  
			      		  submitForm(document.<portlet:namespace />fm);	      		
			  	},
		['liferay-util-list-fields']
	);
</aui:script>
<aui:form action="<%=addFacilityURL%>" method="post" name="fm">
<aui:input type="hidden" name='facilitiesId' id='facilitiesId' value=''/>
<div class="message" id="message"></div>
<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%=true%>">
<table class="wrm-font">
 <tr>
      <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 10px;">
         <liferay-ui:message key="FACILITY" /><p1 style="color:red;">*</p1>
    	 <input type="text" name="facilitiesName" id="facilitiesName" value="" size="15"/>
      </td>
      <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 10px;">
         <liferay-ui:message key="DESC" />
    	 <input type="text" name="facilitiesDesc" value="" size="25" />
      </td>
      <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 10px;">
         <input type="button" value="Add Facility" onclick="return validate()">
      </td>
       <td  class="lfr-label" style="padding-left: 5px;padding-top: 25px;">
        <liferay-ui:icon-help message="Allow you to add new Facility." />
    </td>
    </tr>
</table>
<br/><br/>

      
<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>" id="allTasksPanel" persistState="<%=true%>" title='Facilities'>

<%
	String clicklink=renderResponse.getNamespace()+"saveEntry('"+deleteselectedFacilityURL+"')";
%>

   <input type="button" name="deleteSelectedFacility" value="Delete Selected" onClick="<%=clicklink%>">

<%
	PortletURL facilityIteratorURL = renderResponse.createRenderURL();
    facilityIteratorURL.setParameter("javax.portlet.action", "addFacility");
    facilityIteratorURL.setParameter("facility_add", "facilityadd");
    facilityIteratorURL.setParameter("tabs1","FacilityMaster");
	pageContext.setAttribute("facilityIteratorURL", facilityIteratorURL);
%>

      <liferay-ui:search-container iteratorURL="<%=facilityIteratorURL%>" rowChecker="<%=new RowChecker(renderResponse)%>" delta="<%=WRMConstants.DELTA%>">
      <liferay-ui:search-container-results>
           <%
		   List<FacilityMaster> allFacility = (List<FacilityMaster>)request.getAttribute("allFacility");
		   results = ListUtil.subList(allFacility, searchContainer.getStart(), searchContainer.getEnd());
		   total = allFacility.size();
		   pageContext.setAttribute("results", results);
		   pageContext.setAttribute("total", total);
    	   %>
    	</liferay-ui:search-container-results>
    	 <liferay-ui:search-container-row
		       className="com.cignexdatamatics.wrm.model.FacilityMaster"
		       keyProperty="facilitiesId"
		       modelVar="facility">


		  <liferay-ui:search-container-column-text
					name="Facility Name"
					value="<%= facility.getFacilitiesName() %>"
		 />
		 <liferay-ui:search-container-column-text
					name="Description"
					value="<%= facility.getFacilitiesDesc() %>"
		 />

		 <liferay-ui:search-container-column-text>
		 <liferay-ui:icon-menu cssClass="">

		 <!--Edit Action-->
		 <portlet:actionURL name="editFacility" var="editFacilityURL">
			 <portlet:param name="resourcePrimKey" value="<%=String.valueOf(facility.getPrimaryKey()) %>" />
		 </portlet:actionURL>
		 <liferay-ui:icon image="edit" url="<%=editFacilityURL.toString() %>" />

		 <!--Delete Action-->
		 <portlet:actionURL name="deleteFacility" var="deleteFacilityURL">
			 <portlet:param name="resourcePrimKey" value="<%= String.valueOf(facility.getPrimaryKey()) %>" />
		 </portlet:actionURL>
		 <liferay-ui:icon image="delete" url="<%=deleteFacilityURL.toString() %>" />
		 </liferay-ui:icon-menu>
		 </liferay-ui:search-container-column-text>
		 </liferay-ui:search-container-row>
		 <liferay-ui:search-iterator />
         </liferay-ui:search-container>

</liferay-ui:panel>
</liferay-ui:panel-container>   
</aui:form>
