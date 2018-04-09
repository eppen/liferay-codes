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

<liferay-ui:success key="booking-successful" message="Booking is done Successfully" />
<jsp:useBean class="java.lang.String" id="bookRoomDetailsURL" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelNewBooking" scope="request" />


<%
	String ctxPath = request.getContextPath();
	if (ctxPath != null && ctxPath.length() == 1)
    {
		ctxPath = "";
	}
%>
<script type="text/javascript">
function cnfmBook()
{
	var delete_to= confirm("Do you really want to confirm your Booking?");
	if (delete_to== true)
	{
		
		return true;
	}
	else
	{
		return false;
	}		  
}
function startfocus() {
jQuery("#host").focus();
}

function submitURL() {
var str = document.getElementById("host").value;
return (str.trim() != "");
}

jQuery(document).ready(function()
{

   jQuery("#host").newAutoComplete("<%=ctxPath%>/html/wrm_jsps/common/getdata.jsp");
   jQuery("#attendees").newAutoComplete("<%=ctxPath%>/html/wrm_jsps/common/getdata.jsp", {
    highlightItem: true,
    multiple: true,
    multipleSeparator: ", ",
    scroll: true,
	scrollHeight: 300

});
})
function validate()
{
	var hostName=document.forms['bookRoomDetails'].host.value;
    if(hostName=="")
	{
   		str="Please enter host name !";    
   		document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("host").focus();
		return false; 
	 }
    else
    {
    	str="";    
   		document.getElementById('message').innerHTML =str.fontcolor("red");
    }	 
}	
</script>
<%
 	BestOptionResult br=new BestOptionResult();
     String flag=(String)request.getAttribute("jspflag4");
     if(flag!=null)
     {
           br=(BestOptionResult)request.getAttribute("tempsearchingResult");
     }
 %>
<div class="roombookingFacility">
<form name="bookRoomDetails" action="<%=bookRoomDetailsURL%>" method="POST" onSubmit="return validate();">



   <input type="hidden" name="StartDate" value="<%=br.getSdate() %>" />
   <input type="hidden" name="EndDate" value="<%=br.getEdate() %>" />
   <input type="hidden" name="sthours" value="<%=br.getSthours() %>" />
   <input type="hidden" name="enhours" value="<%=br.getEnhours() %>" />
   <input type="hidden" name="stminutes" value="<%=br.getStminutes()%>" />
   <input type="hidden" name="enminutes" value="<%=br.getEtminutes()%>" />
   <input type="hidden" name="stampm" value="<%=br.getStampm()%>" />
   <input type="hidden" name="enampm" value="<%=br.getEtampm()%>" />  
  <%String roomsiddatewise=(String)renderRequest.getAttribute("dateRoomlist"); %>
  <%String roomstime=(String)renderRequest.getAttribute("timeRoom"); %>
  
  <!--  Defaulting field values of host by getting userId from themedisplay -->
  
  <%long userId=0;
    userId=themeDisplay.getUserId(); 
	User userobj=UserLocalServiceUtil.getUser(userId);
	
	String emailId= "";
	if(Validator.isNotNull(userobj)){
		emailId=userobj.getEmailAddress();
	}
  %>
<input type="hidden" name="dateRoomlist" value="<%=roomsiddatewise%>" />  	
<div class="message" id="message"></div>   
<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%= true %>">
<liferay-ui:panel collapsible="<%=false %>" extended="<%= false %>" id="allTasksPanel" persistState="<%= true %>" title='Meeting Details'>  
<table border="0" cellspacing="0" cellpadding="0" class="wrm-font">
  <tr>
    <td align="left" valign="middle">Meeting Host Email ID<p5 style="color:red;" >*</p5></td>
    <td align="left" valign="middle"><span style="padding-left: 5px;padding-top: 15px;">
      <input type="text" name="host"  style="font weight:bold"  id="host" onkeyup="return validate();" value="<%=emailId%>" />

    </span></td>
    <td align="left" valign="middle"><liferay-ui:icon-help message="Meeting Host will be the person who is going to conduct meeting." /> </td>

    <td align="left" valign="middle">Attendees Email ID</td>
    <td align="left" valign="middle"><input type="text" name="attendees" style="font weight:bold" size="27"  id="attendees"/> 
   <div style="font-size: 0.85em;color:#666666;">
   Enter mail address separated by comma (,)
  </div></td>
    <td align="left" valign="middle"><liferay-ui:icon-help message="Attendees will be the persons who are going to attend meeting." /></td>

  </tr>
  <tr>
    <td align="left" valign="middle">Meeting Title</td>
    <td align="left" valign="middle"><input type="text"  name="meetingTitle" /></td>
    <td align="left" valign="middle">&nbsp;</td>
    <td align="left" valign="middle">Agenda</td>
    <td align="left" valign="middle"><textarea name="meetingDesc" cols="25" rows="3" ></textarea> <br/>
   <div style="font-size: 0.85em;color:#666666;">
   Enter agenda separated by comma (,)
  </div></td>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="6" align="left" valign="middle">
      <input type="submit" value="Book" onclick="return cnfmBook();"/>
      &nbsp;
      <input type="button" value="Cancel"  onClick="self.location = '<%=cancelNewBooking %>';" />

    </td>
  </tr>
</table> 

<br/><br/>
</liferay-ui:panel>  
<br/>    
<liferay-ui:panel collapsible="<%=true%>" defaultState="open" extended="<%=true%>" id="allTasksPanel" persistState="<%= true %>" title='Room Details'>

 <% int i=0;
    String delemiter="@";
    String date[]=new String[100];
    String facilityName=null;
    List<RoomMaster> roomlist=new ArrayList();
    Integer no[]=new Integer[100];
    int j=0;
    String dateRoomlist=roomsiddatewise;
    if(dateRoomlist!=null)
	 {	  
      String []roomDateIds=dateRoomlist.split(delemiter);  
      for(int k=1;k<roomDateIds.length;k++)
       {    	  
          String []dateRoom=roomDateIds[k].split(",");
          long roomId=Long.parseLong(dateRoom[1].trim());
          if(roomId!=0)
          {  
             date[k]=dateRoom[0];
             no[j]=k;j++;
             RoomMaster room=RoomMasterLocalServiceUtil.findRoomByRoomId(roomId);
             roomlist.add(room);
          }
       }
	 }
    int l=0;
  %>    
  <liferay-ui:search-container>   			
            	
    	  <liferay-ui:search-container-results>
           <%
     
           	 results = ListUtil.subList(roomlist, searchContainer.getStart(), searchContainer.getEnd());
		 	 total = results.size();
			 pageContext.setAttribute("results", results);
		 	 pageContext.setAttribute("total", total);
           
    	   %>
    	  
    	</liferay-ui:search-container-results>
    	
    	 
    	 <liferay-ui:search-container-row
		       className="com.cignexdatamatics.wrm.model.RoomMaster"
		       keyProperty="roomId"
		       modelVar="room1">
	
    	 <% int m=no[l].intValue();%>
		 <liferay-ui:search-container-column-text
					name="Date"
					value="<%=date[m]%>"
		 />
		 
	   <!--  Display Time along with Date in preview screen  -->
	   	
		<%
		String[] roomtimings=null;
		String starttime="",endtime="";
		if(Validator.isNotNull(roomstime)){
			roomtimings =roomstime.split(",");
			starttime=roomtimings[0];
			endtime=roomtimings[1];
		}
	    %>	
		
		<liferay-ui:search-container-column-text
					name="Start Time"
					value="<%=starttime%>"
		 />
		 
		 <liferay-ui:search-container-column-text
					name="End Time"
					value="<%=endtime%>"
		 />
		 
	     <liferay-ui:search-container-column-text
					name="Room Name"
					value="<%=room1.getRoomName()%>"
		 />
		 
		  <% long floorId=room1.getFloorId();
		      FloorMaster floorMaster = FloorMasterLocalServiceUtil.findFloorbyFloorId(floorId);
		      String FloorName=floorMaster.getFloorName() +" floor";%>

      
	     <liferay-ui:search-container-column-text
					name="Room Location"
					value="<%=FloorName%>"
		 />	
		   <% long roomId2 = room1.getRoomId();
		     List<RoomFacilityMapping> rfm= RoomFacilityMappingLocalServiceUtil.findAllMappingbyRoomId(roomId2);
		     Iterator<RoomFacilityMapping>it4= rfm.iterator(); 
		     
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
            	   facilityName += ","+facility2.getFacilitiesName();                  
               }
               i++;
             }%>           
             
          <liferay-ui:search-container-column-text
					name="Room Facilities"
					value="<%=facilityName%>"		       />       
		      
		   <%facilityName=null; i=0;l++;%> 
		 
      
		  <liferay-ui:search-container-column-text
					name="Capacity"
					value="<%=String.valueOf(room1.getCapacity()) %>"
		 />
		  <liferay-ui:search-container-column-text
					name="Extension"
					value="<%=String.valueOf(room1.getExtension())%>"
		 />
		 
				 
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
</liferay-ui:search-container> 
</tr>
</table> 

</liferay-ui:panel>    	       
</liferay-ui:panel-container>            
 </form>
</div>   