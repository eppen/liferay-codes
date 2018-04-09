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
<liferay-ui:success key="booking-cancled" message="booking-cancled" />
<jsp:useBean id="mybookingURL" class="java.lang.String" scope="request" />
<%
	StoreResult sr=new StoreResult();
    String ctxPath = request.getContextPath();
 	if (ctxPath != null && ctxPath.length() == 1)
 	{
 		ctxPath = "";
 	}
%>
<script type="text/javascript">
 
function openPopup(bookroomId) 
{	
	var url = '<liferay-portlet:renderURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>" ><portlet:param name="mybooking" value="AttendeesPopup" /></liferay-portlet:renderURL>';
	
	 AUI().use('aui-dialog', 'aui-io', 'event-custom', 'io-form', function(A) {   
         var dialog = new A.Dialog({
            centered: true,
			destroyOnClose: true,
			draggable: true,
			modal: true,
			stack: true,
			title: 'Attendees',
			width: 500,
			height: 300,                             
          
         }).plug(A.Plugin.IO, {data:{  bookingId: bookroomId  },uri:url }).render();      
         dialog.show();
     });
}
function submitFrm(url)
{
	var delete_to= confirm("Do you really want to cancel your Booking?");
	if (delete_to== true)
	{
		document.forms['<portlet:namespace/>fm'].action=url; 
		document.forms['<portlet:namespace/>fm'].method="POST";
		document.forms['<portlet:namespace/>fm'].submit();	
		return true;
	}
	else
	{
		return false;
	}		  
}
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
    findFloor()
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
		 var str="";
	     document.getElementById('message').innerHTML =str.fontcolor("red");
	 }
	 return true;
}
function validate2()
{ 
	if(validate1()==true)
	{
	   var locationId=document.getElementById("locationId").selectedIndex;
	   if(locationId<=0)
       {
 	   	str="Please Select Location.";    
       	document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("locationId").focus();
   		return false; 
       }
 	   else
	   {
		 var str="";
	     document.getElementById('message').innerHTML =str.fontcolor("red");
	   }  
	}
	 return true; 
}

function validate()
{
	  var today = new Date();
	  var dd = today.getDate();
	  var mm = today.getMonth()+1;   //January is 0!
	  var yyyy = today.getFullYear();
	  if(dd<10){dd='0'+dd;}
	  if(mm<10){mm='0'+mm;}
	  var currentdate=mm+"/"+dd+"/"+yyyy;
	  var cd=new Date(currentdate);
	  var sdate= document.getElementById("datepicker").value;
	  var sd=new Date(sdate);
	  var edate= document.getElementById("datepicker1").value;
	  var ed=new Date(edate);
	     if(cd>sd)
		 {
			 str="Plese enter start date greater than today's date.";    
	     	 document.getElementById('message').innerHTML =str.fontcolor("red");
	       	 return false;
		 }
	     else if(sd>ed)
		 {
			    var str2="Please enter end date greater than start date.";
			 	document.getElementById('message').innerHTML =str2.fontcolor("red");
			    return false;
		 }
	     else
		 {
			 var str=""
		     document.getElementById('message').innerHTML =str.fontcolor("red");
		 }
		 return true;
}
/*jQuery(function()
    {
		jQuery("#datepicker").datepicker({ minDate: 0 });
		jQuery("#anim").change(function() { jQuery('#datepicker').datepicker('option', {showAnim: $(this).val()}); });
		jQuery("#datepicker1").datepicker({ minDate: 0 });
		jQuery("#anim1").change(function() { jQuery('#datepicker1').datepicker('option', {showAnim: $(this).val()}); });
	});*/
<%--Code Modified for datepicker to run in IE7 --%>	

jQuery(function()
			{		
					jQuery( "#datepicker" ).datepicker({
					defaultDate: "+1w",
					changeMonth: true,
					numberOfMonths: 1,
					minDate: 0
					});
					jQuery( "#datepicker1" ).datepicker({
					defaultDate: "+1w",
					changeMonth: true,
					numberOfMonths: 1,
					minDate: new Date(jQuery('#datepicker').val())			
					});
					jQuery('#datepicker').change(function () {
					jQuery( "#datepicker1" ).datepicker( "destroy" );
					jQuery( "#datepicker1" ).val(jQuery('#datepicker').val());
					jQuery( "#datepicker1" ).datepicker({
					defaultDate: "+1w",
					changeMonth: true,
					numberOfMonths: 1,
					minDate: new Date(jQuery('#datepicker').val())				
					});	
					});
			});	

</script>


<form name="<portlet:namespace/>fm" action="<%=mybookingURL%>" method="POST" onSubmit="return validate();">
<div id="basic">
<div class="advancesearch advancesearch-short">
<%
	String flag=(String)request.getAttribute("jspflag2");
  if(flag!=null)
  {
	   sr=(StoreResult)request.getAttribute("tempmybookingResult");
  }
  long cid=sr.getCityId();
  List<LocationMaster> selLocation = LocationMasterLocalServiceUtil.findAllInCity(cid);
  long lid=sr.getLocationId();
  List<FloorMaster> allFloor = FloorMasterLocalServiceUtil.findAllInLocation(lid);
  
%>

<c:set var="selectedCity" value="<%=sr.getCityId()%>"/>
<c:set var="selectedLocationId" value="<%=sr.getLocationId()%>"/>
<c:set var="selectedFloorId" value="<%=sr.getFloorId()%>"/>
<c:set var="locationList" value="<%=selLocation%>"/>
<c:set var="floorList" value="<%=allFloor%>"/>

<div class="message" id="message"></div>
   <span class="selecttype w215">
   <span class="lab">
   <liferay-ui:message key="CITY" />
    <select name="cityId" id="cityId"  onchange="findLocation()">
         <option >Select City</option>
	     <c:forEach items="${allCity}" var="city">
	        <option value="${city.cityId}" ${city.cityId == selectedCity ? 'selected' : ''}>${city.cityName}</option>
	     </c:forEach>
    </select>
    
   
	
    
   </span>
   </span>
      <span class="selecttype w215">
         <span class="lab">
               <liferay-ui:message key="LOCATION" />
                <select name="locationId" id="locationId"  onchange="findFloor()" onclick="return validate1();">
         <option value="0">Select Location</option>
          <c:forEach items="${locationList}" var="location">
	        	<option value="${location.locationId}" ${location.locationId == selectedLocationId ? 'selected' : ''}>${location.locationName}</option>
	     </c:forEach>
         </select>
        </span>
      </span>
       <span class="selecttype w215">
         <span class="lab">
         <liferay-ui:message key="FLOOR" />
          <select name="floorId"  id="floorId" onclick="return validate2();">
          <option value="0">Select Floor</option>
      	 <c:forEach items="${floorList}" var="floor">
	        	<option value="${floor.floorId}" ${floor.floorId == selectedFloorId ? 'selected' : ''}>${floor.floorName}</option>
	     </c:forEach>
	     
         </select>
         </span>
       </span>  
       <br class="clear-both" />
       <span class="selecttype w215">
         <span class="lab">
         <liferay-ui:message key="START_DATE" />
          <input type="text" class="calendericon" style="width:100px; background:url('<%=ctxPath%>/images/calendar-icon.gif') 80px center no-repeat; " name="StartDate" id="datepicker" value="<%=sr.getSdate()%>" size="12" onchange="return validate();" readonly="readonly"/>
         </span>
         </span>
        <span class="selecttype w215">
         <span class="lab">
         <liferay-ui:message key="END_DATE" />
          <input type="text" class="calendericon" style="width:100px; background:url('<%=ctxPath%>/images/calendar-icon.gif') 80px center no-repeat; "  name="EndDate" id="datepicker1" value="<%=sr.getEdate()%>"  size="12" onchange="return validate();" readonly="readonly"/>
         </span>
         </span>
        <span class="selecttype w215">
         <span class="lab">  </span>
         </span>
         <br class="clear-both" />
         <div class="mybooking-tab-search-btn-wrapper">
         <div class="search-btn">
             <input type="submit" value="Search" />
         </div>   
         </div>
</div>
</div>
<br/><br/>
<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%=false%>">       
<liferay-ui:panel collapsible="<%=true%>" defaultState="open" extended="<%=true%>" id="allTasksPanel" persistState="<%=false%>" title='Search Results'>

<%
	try
{

	List<BookingRooms> bookingRooms=new ArrayList();
	long bookRoomId=0L;
	String roomName=null;
	String address=null;
	String date=null;
	String email=null;
	User current_user = themeDisplay.getUser();
	long userId = current_user.getUserId();
	String temp=new String();
	if(flag==null || flag=="flag4mydelete")
    {
		Date today = Calendar.getInstance().getTime();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	String currentdate= formatter.format(today);
      	Date BookingDate =(Date)formatter.parse(currentdate+" 00:00:00");
       	 
      	List<BookingRooms> bookingroomobj2=BookingRoomsLocalServiceUtil.findAllBookingRooms();
  		Iterator<BookingRooms> bookingroomit2 = bookingroomobj2.iterator();
  		while (bookingroomit2.hasNext())
  		{
  			BookingRooms bookingroommaster=(BookingRooms) bookingroomit2.next();
  			long bookingRoomMappingId= bookingroommaster.getBRMappingId();
  			long bookingId=bookingroommaster.getBookingId();
  			Date bookingDate=bookingroommaster.getBookingDate();
  			if(bookingDate.before(BookingDate))
  			{
  			 
  		  	  List<BookingRooms> roombyBookingId= (List<BookingRooms>) BookingRoomsLocalServiceUtil.findMappingByBookingId(bookingId);
  			  Iterator<BookingRooms> it7=roombyBookingId.iterator();
  			  int i=0;
  			  while (it7.hasNext())
  			  {
  				i++;
  				it7.next();				
  		      }
  			 if (i==1)
  			 {
  				NewBookingLocalServiceUtil.deleteNewBooking(bookingId);
  				List<BookingAttendees> ba=BookingAttendeesLocalServiceUtil.findAllbyBookingId(bookingId);
  				Iterator <BookingAttendees>it8=ba.iterator();
  				while(it8.hasNext())
  				{
  					BookingAttendees bookingAttendeesobj=it8.next();
  					BookingAttendeesLocalServiceUtil.remove(bookingAttendeesobj);			
  				}					
  			}
   			
  			BookingRoomsLocalServiceUtil.deleteBookingRooms(bookingRoomMappingId);
  			}
  			else
  			{
  					    temp+=String.valueOf(bookingRoomMappingId)+",";
  		  		
  			}
  		}
    }
    else
	{	
         temp=(String)request.getAttribute("MyBookingResult");
	}
	if(temp!=null || "".equals(temp))
	{
  		String[] result=temp.split(",");
		for(int i=0;i<result.length; i++)
		{
	 		  long bookingRoomMappingId = Long.parseLong(result[i].trim());
	  		  BookingRooms booking= BookingRoomsLocalServiceUtil.findBookingById(bookingRoomMappingId);
	 		  long bookingId=booking.getBookingId();
	  		  NewBooking newbooking1=NewBookingLocalServiceUtil.findAllBookingbyBookingId(bookingId);
              if(newbooking1.getHostId()==userId)
	  		  {
	               bookingRooms.add(booking);
	          }
		}
	}	
   	if(bookingRooms.size()==0)
	{
%>
   		 No Result Found.   
   <%
	}
   	else
   	{
	    PortletURL mybookingIteratorURL = renderResponse.createActionURL();
		mybookingIteratorURL.setParameter("javax.portlet.action", "mybooking");
		mybookingIteratorURL.setParameter("mybooking", "mybooking");
		mybookingIteratorURL.setParameter("cityId",String.valueOf(sr.getCityId()));
		mybookingIteratorURL.setParameter("locationId",String.valueOf(sr.getLocationId()));
		mybookingIteratorURL.setParameter("floorId",String.valueOf(sr.getFloorId()));
		mybookingIteratorURL.setParameter("StartDate",sr.getSdate());
		mybookingIteratorURL.setParameter("EndDate",sr.getEdate());
		mybookingIteratorURL.setParameter("tabs1","MyBooking");
	    pageContext.setAttribute("mybookingIteratorURL", mybookingIteratorURL);
	    
	    PortletURL mybookingIterator2URL = renderResponse.createRenderURL();
		mybookingIterator2URL.setParameter("javax.portlet.action", "mybooking");
		mybookingIterator2URL.setParameter("mybooking", "mybooking");
		mybookingIterator2URL.setParameter("tabs1","MyBooking");
	    pageContext.setAttribute("mybookingIterator2URL", mybookingIterator2URL);
	    
	    PortletURL finalIterator2URL=null;
	    if(flag==null)
	    {
	        finalIterator2URL=mybookingIterator2URL;
	    }
	    else
	    {
	    	 finalIterator2URL=mybookingIteratorURL;
	    }
%>

        <liferay-ui:search-container  iteratorURL="<%=finalIterator2URL%>" delta="<%=WRMConstants.DELTA%>">
        <liferay-ui:search-container-results>
           <%
          
		  	results = ListUtil.subList(bookingRooms, searchContainer.getStart(), searchContainer.getEnd());
		    total =  bookingRooms.size();
		    pageContext.setAttribute("results", results);
		    pageContext.setAttribute("total", total);
          %>
    	 </liferay-ui:search-container-results>
    	 <liferay-ui:search-container-row
		       className="com.cignexdatamatics.wrm.model.BookingRooms"
		       keyProperty="BRMappingId"
		       modelVar="bookingRoom">
		 <%
		     //to convert date 2 string
		     DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); // change dateformat time to MM/dd/yyyy fromm MM/dd/yy
		     date = df.format(bookingRoom.getBookingDate());

		     //for meetingTitle
		     long bookingId=bookingRoom.getBookingId();
		     NewBooking newbooking=NewBookingLocalServiceUtil.findAllBookingbyBookingId(bookingId);
		     String title=newbooking.getMeetingTitle();
		     
		    
		     //start time
		     String stime=newbooking.getStartTime();
		     String s_t= null ;
		     Float f_stime = new Float(stime);
		     double d_stime = f_stime.doubleValue();
			 if(d_stime >= 13.0)
			 {
				 d_stime = d_stime - 12.0;
				 int i1 = (int) d_stime ;
				 double temp_stime = d_stime - i1 ;
				 String t_stime = Integer.toString(i1);
				 if(temp_stime == 0.0)
				 {				
					  s_t = t_stime + ":" + "00" + " PM" ;
				 }
				 else if(temp_stime == 0.25)
				 {					
					  s_t = t_stime + ":" + "15" + " PM" ;					
				 }
				 else if(temp_stime == 0.5)
				 {
					  s_t = t_stime + ":" + "30" + " PM" ;
				 }
				 else if(temp_stime == 0.75)
				 {
					  s_t = t_stime + ":" + "45" + " PM" ;
				 }
			 }
			 
			 else if(d_stime >=0.0 && d_stime<1.0)
			 {
				 d_stime = d_stime + 12.0;
				 int i1 = (int) d_stime ;
				 double temp_stime = d_stime - i1 ;
				 String t_stime = Integer.toString(i1);
				 if(temp_stime == 0.0)
				 {
					  s_t = t_stime + ":" + "00" + " AM" ;
				 }
				 else if(temp_stime == 0.25)
				 {
					  s_t = t_stime + ":" + "15" + " AM" ;
				 }
				 else if(temp_stime == 0.5)
				 {
					  s_t = t_stime + ":" + "30" + " AM" ;
				 }
				 else if(temp_stime == 0.75)
				 {
					  s_t = t_stime + ":" + "45" + " AM" ;
				 }
			 }
			
			 else if(d_stime < 12.0)
			 {
				 int i1 = (int) d_stime ;
				 double temp_stime = d_stime - i1 ;
				 String t_stime = Integer.toString(i1);
				 if(temp_stime == 0.0)
				 {
					  s_t = t_stime + ":" + "00" + " AM" ;
				 }
				 else if(temp_stime == 0.25)
				 {
					  s_t = t_stime + ":" + "15" + " AM" ;
				 }
				 else if(temp_stime == 0.5)
				 {
					  s_t = t_stime + ":" + "30" + " AM" ;
				 }
				 else if(temp_stime == 0.75)
				 {
					  s_t = t_stime + ":" + "45" + " AM" ;
				 }
			 }
			
			 
			 else
			 {
				 int i1 = (int) d_stime ;
				 double temp_stime = d_stime - i1 ;
				 String t_stime = Integer.toString(i1);
				 if(temp_stime == 0.0)
				 {
					  s_t = t_stime + ":" + "00" + " PM" ;
				 }
				 else if(temp_stime == 0.25)
				 {
					  s_t = t_stime + ":" + "15" + " PM" ;
				 }
				 else if(temp_stime == 0.5)
				 {
					  s_t = t_stime + ":" + "30" + " PM" ;
				 }
				 else if(temp_stime == 0.75)
				 {
					  s_t = t_stime + ":" + "45" + " PM" ;
				 }
			 }
			
			 
				
		     //end time
		     String etime=newbooking.getEndTime();
		     String e_t= null ;
		     Float f_etime1 = new Float(etime);
		  
		     double d_etime = f_etime1.doubleValue();
			 if(d_etime > 12.0)
			 {
				 d_etime = d_etime - 12.0;
				 int i2 = (int) d_etime ;
				 String t_etime = Integer.toString(i2);
				 double temp_etime = d_etime - i2 ;
				 if(temp_etime == 0.0)
				 {
					  e_t = t_etime + ":" + "00" + " PM" ;
				 }
				 else if(temp_etime == 0.25)
				 {
					 e_t = t_etime + ":" + "15" + " PM" ;
				 }
				 else if(temp_etime == 0.50)
				 {					
					  e_t = t_etime + ":" + "30" + " PM" ;
				 }
				 else if(temp_etime == 0.75)
				 {
					  e_t = t_etime + ":" + "45" + " PM" ;
				 }
			 }
			 else if(d_etime >= 0.0 && d_etime<1.0)
			 {
				 d_etime = d_etime + 12.0;
				 int i2 = (int) d_etime ;
				 double temp_etime = d_etime - i2 ;
				 String t_etime = Integer.toString(i2);
				 if(temp_etime == 0.0)
				 {					
					  e_t = t_etime + ":" + "00" + " AM" ;					 
				 }
				 else if(temp_etime == 0.25)
				 {					
					  e_t = t_etime + ":" + "15" + " AM" ;
				 }
				 else if(temp_etime == 0.50)
				 {
					  e_t = t_etime + ":" + "30" + " AM" ;
				 }
				 else if(temp_etime == 0.75)
				 {
					 e_t = t_etime + ":" + "45" + " AM" ;
				 }
			 }
						 
			 
			 else if(d_etime < 12.0)
			 {
				 int i2 = (int) d_etime ;
				 double temp_etime = d_etime - i2 ;
				 String t_etime = Integer.toString(i2);
				 if(temp_etime == 0.0)
				 {					
					  e_t = t_etime + ":" + "00" + " AM" ;					 
				 }
				 else if(temp_etime == 0.25)
				 {					
					  e_t = t_etime + ":" + "15" + " AM" ;
				 }
				 else if(temp_etime == 0.50)
				 {
					  e_t = t_etime + ":" + "30" + " AM" ;
				 }
				 else if(temp_etime == 0.75)
				 {
					 e_t = t_etime + ":" + "45" + " AM" ;
				 }
			 }
			 else
			 {
			 int i2 = (int) d_etime ;
			 double temp_etime = d_etime - i2 ;
			 String t_etime = Integer.toString(i2);
			 if(temp_etime == 0.0)
			 {					
				  e_t = t_etime + ":" + "00" + " PM" ;					 
			 }
			 else if(temp_etime == 0.25)
			 {					
				  e_t = t_etime + ":" + "15" + " PM" ;
			 }
			 else if(temp_etime == 0.50)
			 {
				  e_t = t_etime + ":" + "30" + " PM" ;
			 }
			 else if(temp_etime == 0.75)
			 {
				 e_t = t_etime + ":" + "45" + " PM" ;
			 }

			 }
		     //for roomName
		     long roomId=bookingRoom.getRoomId();
		     RoomMaster room =RoomMasterLocalServiceUtil.findRoomByRoomId(roomId);
		     roomName=room.getRoomName();

		     //for location
		     long cityId=room.getCityId();
		     long locationId=room.getLocationId();
		     long floorId=room.getFloorId();
			 CityMaster city = CityMasterLocalServiceUtil.findCitybyCityId(cityId);
		 	 LocationMaster location = LocationMasterLocalServiceUtil.findLocationbyLocationId(locationId);
			 FloorMaster floor = FloorMasterLocalServiceUtil.findFloorbyFloorId(floorId);
			 String cityName=city.getCityName();
			 String locationName=location.getLocationName();
			 String floorName=floor.getFloorName();
			 address=cityName+", "+locationName+", "+floorName+" Floor";


		 %>

		 <liferay-ui:search-container-column-text
					name="Date"
					value="<%=date%>"
		 />

		 <liferay-ui:search-container-column-text
					name="Start Time"
					value="<%=s_t %>"
		 />

		  <liferay-ui:search-container-column-text
					name="End Time"
					value="<%=e_t %>"
		 />

	     <liferay-ui:search-container-column-text
					name="Room Name"
					value="<%=roomName %>"
		 />
		 
		  <liferay-ui:search-container-column-text
					name="Meeting Title"
					value="<%=title %>"
		 />

		  <liferay-ui:search-container-column-text
					name="Room Location"
					value="<%=address %>"
		  />
		  
		  <!-- Added Column of Attendees for showing popup after clicking on View All button  -->
		  
		  <input type="hidden" name="bookingId" value="<%=String.valueOf(bookingRoom.getPrimaryKey())%>">
	 	  <liferay-ui:search-container-column-text name="Attendees">
			 <liferay-ui:icon-menu cssClass="">
			 <input type="button" name="MyBookingPopup"  value="View All" onClick="javascript:openPopup('<%=String.valueOf(bookingRoom.getBookingId())%>');">
			   
			  </liferay-ui:icon-menu>
		  </liferay-ui:search-container-column-text>
		  
		 <liferay-ui:search-container-column-text>
		 <liferay-ui:icon-menu cssClass="">

		  <!--Delete Action-->
		  <portlet:actionURL name="cancleMyBooking" var="cancleMyBookingURL">
			  <portlet:param name="resourcePrimKey" value="<%= String.valueOf(bookingRoom.getPrimaryKey()) %>" />
			  <portlet:param name="StartDate" value="<%=sr.getSdate()%>" />
			  <portlet:param name="EndDate" value="<%=sr.getEdate()%>" />
			  <portlet:param name="cityId" value="<%= String.valueOf(sr.getCityId())%>" />
			  <portlet:param name="locationId" value="<%= String.valueOf(sr.getLocationId())%>" />
			  <portlet:param name="floorId" value="<%= String.valueOf(sr.getFloorId())%>" />
			  <portlet:param name="flag" value="<%=flag%>" />
		 </portlet:actionURL>
		 	<input type="button" name="cancleMyBooking"  value="Cancel" onclick="submitFrm('<%=cancleMyBookingURL%>')" >  
		  </liferay-ui:icon-menu>
		  </liferay-ui:search-container-column-text>

    	 </liferay-ui:search-container-row>
		 <liferay-ui:search-iterator />
         </liferay-ui:search-container>
         <%
     }

}
catch(Exception e)
{}%>

</liferay-ui:panel>
</liferay-ui:panel-container>   
</form>

