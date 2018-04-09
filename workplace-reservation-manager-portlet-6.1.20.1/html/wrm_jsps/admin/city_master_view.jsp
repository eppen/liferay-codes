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
<liferay-ui:success key="city-added" message="City-Added-Successfully" />
<liferay-ui:success key="city-updated" message="City-Updated-Successfully" />
<liferay-ui:success key="city-deleted" message="City-Deleted-Successfully" />
<liferay-ui:success key="city-deleteselected" message="City-Deleteselected-Successfully" />
<liferay-ui:error key="city-duplicate" message="City-Duplicated"/>
<liferay-ui:error key="city-notselected" message="City-is-not-Selected"/>
<liferay-ui:error key="cityname-required" message="cityname-required"/>
<jsp:useBean id="addCityURL" class="java.lang.String" scope="request" />
<jsp:useBean id="deleteselectedCityURL" class="java.lang.String" scope="request" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function validate()
{
	 var cityName=document.forms['<portlet:namespace/>fm'].cityName.value;
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
     submitForm(document.<portlet:namespace />fm);	 
}
function isAlpha(argvalue)
{
      argvalue = argvalue.toString();
      var validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
      for (var n = 0; n < argvalue.length; n++)
      {
 		   if(validChars.indexOf(argvalue.substring(n, n+1)) == -1)
           return false;
      }
    
}

</script>
<aui:script>
Liferay.provide(
		window,
		'<portlet:namespace />saveEntry',
		function(url) {
			      		document.<portlet:namespace />fm.<portlet:namespace />cityId.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			      		  document.forms['<portlet:namespace/>fm'].action=url;
			      		  document.forms['<portlet:namespace/>fm'].method="POST";
			      		  
			      		  submitForm(document.<portlet:namespace />fm);	      		
			  	},
		['liferay-util-list-fields']
	);
</aui:script>
<aui:form action="<%=addCityURL%>" method="post" name="fm">
<aui:input type="hidden" name='cityId' id='cityId' value=''/>
<div class="message" id="message"></div>

<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%=true%>">
<table class="wrm-font">
   <tr>
      <td style="padding-left: 20px;padding-top: 20px;padding-bottom: 10px;">
       	 <liferay-ui:message key="CITY" /><p1 style="color:red;" >*</p1>
      </td>
      <td style="padding-left: 10px;padding-top: 20px;padding-bottom: 10px;">
    	 <input type="text" name="cityName" id="cityName" value=""/>
      </td >
      <td style="padding-left: 5px;padding-top: 20px;padding-bottom: 10px;">
          <input type="button" value="Add City" onClick="return validate();">
      </td>
       <td  class="lfr-label" style="padding-left: 5px;padding-top: 25px;">
        <liferay-ui:icon-help message="Allow you to add new city." />
    </td>
</table>
<br/><br/>      
<liferay-ui:panel collapsible="<%=true%>" defaultState="open" extended="<%=true%>" id="allTasksPanel" persistState="<%=true%>" title='City'>

<%
	String clicklink=renderResponse.getNamespace()+"saveEntry('"+deleteselectedCityURL+"')";
%>

   <input type="button" name="deleteSelectedCity" value="Delete Selected" onClick="<%=clicklink%>">

<%
	PortletURL cityIteratorURL = renderResponse.createRenderURL();
    cityIteratorURL.setParameter("javax.portlet.action", "addCity");
    cityIteratorURL.setParameter("city_add", "city_add");
    cityIteratorURL.setParameter("tabs1","CityMaster");
	pageContext.setAttribute("cityIteratorURL", cityIteratorURL);
%>

        <liferay-ui:search-container  iteratorURL="<%=cityIteratorURL%>" rowChecker="<%=new RowChecker(renderResponse)%>" delta="<%=WRMConstants.DELTA%>">
        <liferay-ui:search-container-results>
           <%
		   List<CityMaster> allCity = (List<CityMaster>)request.getAttribute("allCity");
		   results = ListUtil.subList(allCity, searchContainer.getStart(), searchContainer.getEnd());
		   total = allCity.size();
		   pageContext.setAttribute("results", results);
		   pageContext.setAttribute("total", total);
    	   %>
    	 </liferay-ui:search-container-results>
    	 <liferay-ui:search-container-row
		       className="com.cignexdatamatics.wrm.model.CityMaster"
		       keyProperty="cityId"
		       modelVar="city">

	     <liferay-ui:search-container-column-text
					name="City"
					value="<%= city.getCityName() %>"
		 />
		 <liferay-ui:search-container-column-text>
		 <liferay-ui:icon-menu cssClass="">

		  <!--Edit Action-->
		  <portlet:actionURL name="editCity" var="editCityURL">
			 <portlet:param name="resourcePrimKey" value="<%=String.valueOf(city.getPrimaryKey()) %>" />
		  </portlet:actionURL>
		  <liferay-ui:icon image="edit" url="<%=editCityURL.toString() %>" />

		  <!--Delete Action-->
		  <portlet:actionURL name="deleteCity" var="deleteCityURL">
			 <portlet:param name="resourcePrimKey" value="<%= String.valueOf(city.getPrimaryKey()) %>" />
		  </portlet:actionURL>
		  <liferay-ui:icon image="delete" url="<%=deleteCityURL.toString() %>" />

		  </liferay-ui:icon-menu>
		  </liferay-ui:search-container-column-text>

		  </liferay-ui:search-container-row>
		  <liferay-ui:search-iterator />
          </liferay-ui:search-container>

</liferay-ui:panel>
</liferay-ui:panel-container>   
</aui:form>
