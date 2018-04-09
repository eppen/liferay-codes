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
<jsp:useBean id="deleteselectedRoomURL" class="java.lang.String" scope="request" />
<jsp:useBean id="addRoom2URL" class="java.lang.String" scope="request" />
<liferay-ui:success key="room-added" message="room-added-successfully" />
<liferay-ui:success key="room-updated" message="room-updated-successfully" />
<liferay-ui:success key="room-deleted" message="room-deleted-successfully" />
<liferay-ui:success key="room-deleteselected" message="room-deleteselected-successfully" />
<liferay-ui:error key="room-duplicate" message="room-duplicated"/>
<liferay-ui:error key="room-notselected" message="room-notselected"/>
<liferay-ui:error key="extension-duplicate" message="extension-duplicate"/>
<liferay-ui:error key="RoomName-required" message="roomname-required"/>
<script type="text/javascript">
function submitFrm(url)
{

		  document.forms['<portlet:namespace/>fm'].action=url;
		  document.forms['<portlet:namespace/>fm'].method="POST";
		  document.forms['<portlet:namespace/>fm'].submit();
}
</script>
<aui:script>
Liferay.provide(
		window,
		'<portlet:namespace />saveEntry',
		function(url) {
			      		document.<portlet:namespace />fm.<portlet:namespace />roomId.value =  Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			      		  document.forms['<portlet:namespace/>fm'].action=url;
			      		  document.forms['<portlet:namespace/>fm'].method="POST";
			      		  
			      		  submitForm(document.<portlet:namespace />fm);	      		
			  	},
		['liferay-util-list-fields']
	);
</aui:script>
<div class="roomFacility">
<aui:form name="fm">
<aui:input type="hidden" name='roomId' id='roomId'/>
<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%=true%>">
<table> 
    <td  class="lfr-label" style="padding-left: 10px;padding-top: 15px;">
          <input type="button" name="addRoom" value="Add Room" onClick="self.location='<%=addRoom2URL%>';">
    </td> 
    <td  class="lfr-label" style="padding-left: 5px;padding-top: 20px;">
        <liferay-ui:icon-help message="Allow you to add new Room." />
    </td>
 </tr>
</table>
<br/><br/>     
<liferay-ui:panel collapsible="<%=true%>" defaultState="open" extended="<%=true%>" id="allTasksPanel" persistState="<%=true%>" title='Room'>

                                                             
<%
                                                             	String clicklink=renderResponse.getNamespace()+"saveEntry('"+deleteselectedRoomURL+"')";
                                                             %>
   <input type="button" name="deleteSelectedRoom" value="Delete Selected" onClick="<%=clicklink%>" >

<%
	PortletURL roomIteratorURL = renderResponse.createRenderURL();
    roomIteratorURL.setParameter("javax.portlet.action", "addRoom");
	roomIteratorURL.setParameter("room_add", "room_add");
	roomIteratorURL.setParameter("tabs1","RoomMaster");
	pageContext.setAttribute("roomIteratorURL", roomIteratorURL);
%>
    
      <liferay-ui:search-container   iteratorURL="<%=roomIteratorURL%>" rowChecker="<%=new RowChecker(renderResponse)%>" delta="<%=WRMConstants.DELTA%>">
        <liferay-ui:search-container-results>
           <%
		   List<RoomMaster> allRoom = (List<RoomMaster>)request.getAttribute("allRoom");
		   results = ListUtil.subList(allRoom, searchContainer.getStart(), searchContainer.getEnd());
		   total = allRoom.size();
		   pageContext.setAttribute("results", results);
		   pageContext.setAttribute("total", total);
    	   %>
    	</liferay-ui:search-container-results>
    	 <liferay-ui:search-container-row
		       className="com.cignexdatamatics.wrm.model.RoomMaster"
		       keyProperty="roomId"
		       modelVar="room">

		  <% long cityId=room.getCityId();
             CityMaster cityMaster = CityMasterLocalServiceUtil.findCitybyCityId(cityId);
             String CityName=cityMaster.getCityName();%>


	     <liferay-ui:search-container-column-text
					name="City"
					value="<%=CityName%>"
		 />

		   <% long locationId=room.getLocationId();
              LocationMaster locationMaster = LocationMasterLocalServiceUtil.findLocationbyLocationId(locationId);
              String  LocationName=locationMaster.getLocationName();%>


	     <liferay-ui:search-container-column-text
					name="Location"
					value="<%=LocationName%>"
		 />
		   <% long floorId=room.getFloorId();
		      FloorMaster floorMaster = FloorMasterLocalServiceUtil.findFloorbyFloorId(floorId);
		      String FloorName=floorMaster.getFloorName();%>


	     <liferay-ui:search-container-column-text
					name="Floor"
					value="<%=FloorName%>"
		 />
		 
		 <liferay-ui:search-container-column-text
					name="Room"
					value="<%=room.getRoomName() %>"		
		 />

		 <liferay-ui:search-container-column-text
					name="Capacity"
					value="<%=String.valueOf(room.getCapacity())%>"
		 />		
	     <liferay-ui:search-container-column-text
					name="Extension"
					value="<%=String.valueOf(room.getExtension())%>"
		 />
		  <% long roomId2 = room.getRoomId();
		     List<RoomFacilityMapping> rfm= RoomFacilityMappingLocalServiceUtil.findAllMappingbyRoomId(roomId2);
		     Iterator it4= rfm.iterator();
             String facilityName=new String();
             int i=0;
		     while(it4.hasNext())
             {
		       RoomFacilityMapping rfm2=(RoomFacilityMapping)it4.next();
               long fid=rfm2.getFacilitiesId();
               FacilityMaster facility2 = FacilityMasterLocalServiceUtil.findbyFacilitiesId(fid);
               if(i==0)
               {
                   	   facilityName =facility2.getFacilitiesName();
                   	   i++;                   	                  	   
               }
               if(i!=1)
               {
            	   facilityName += ", "+facility2.getFacilitiesName();
            	   
               }
               i++;
              
             }%>
                
                  <liferay-ui:search-container-column-text 
					name="Facility"
					value="<%=facilityName%>"	
				/> 
                 		       
						       

		  <%facilityName=null; i=0;%> 


		  <liferay-ui:search-container-column-text>
		  <liferay-ui:icon-menu cssClass="">

		  <!--Edit Action-->
		  <portlet:actionURL name="editRoom" var="editRoomURL">
			    <portlet:param name="resourcePrimKey" value="<%=String.valueOf(room.getPrimaryKey()) %>" />
		  </portlet:actionURL>
		  <liferay-ui:icon image="edit" url="<%=editRoomURL.toString() %>" />

		  <!--Delete Action-->
		  <portlet:actionURL name="deleteRoom" var="deleteRoomURL">
			    <portlet:param name="resourcePrimKey" value="<%= String.valueOf(room.getPrimaryKey()) %>" />
		  </portlet:actionURL>
		  <liferay-ui:icon image="delete" url="<%=deleteRoomURL.toString() %>" />

		  </liferay-ui:icon-menu>
		  </liferay-ui:search-container-column-text>
		  </liferay-ui:search-container-row>
		  <liferay-ui:search-iterator />
		   
          </liferay-ui:search-container>
        

</liferay-ui:panel>
</liferay-ui:panel-container>   
</aui:form>
</div>
