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
<%
	String bookingId=(String)renderRequest.getAttribute("bookingIdAttendees"); 
	List<BookingAttendees> attendeesIds = BookingAttendeesLocalServiceUtil.findAllbyBookingId(Long.parseLong(bookingId));
	Iterator<BookingAttendees> it= attendeesIds.iterator();
	
	NewBooking newbookingobj=null;
	
	try{
		newbookingobj=NewBookingLocalServiceUtil.findAllBookingbyBookingId(Long.parseLong(bookingId));
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	User hostuserobj=null;
	if(Validator.isNotNull(newbookingobj)){
		hostuserobj =UserLocalServiceUtil.getUser(newbookingobj.getHostId());
	}
	
%>
<form name="<portlet:namespace/>fm" method="POST">
<table style="font-size: 12px;" >
<%
	if(Validator.isNotNull(hostuserobj)){
		out.println("<tr><td>"+hostuserobj.getEmailAddress()+"&nbsp;&nbsp;&nbsp;(Host)</td></tr>");
	}

	while(it.hasNext())
	{
	   User userobj=null;
	   BookingAttendees bookings=(BookingAttendees)it.next();
	   userobj=UserLocalServiceUtil.getUser(bookings.getAttendeesId());
	   out.println("<tr><td>"+userobj.getEmailAddress()+"</td></tr>");
	}
%>
</table>
</form>
