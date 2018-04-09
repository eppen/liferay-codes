<%-- 

Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
This library is free software; you can redistribute it and/or modify it under the terms of the 
GNU Lesser General Public License as published by the Free Software Foundation; either 
version 2.1 of the License, or (at your option) any later version.
This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE. See the GNU Lesser General Public License for more details. 

--%>

<%@ include file="../init.jsp" %>

<%
PortletURL tabs1URL = renderResponse.createRenderURL();
String tabNamesAdmin = "NewBooking,MyBooking,BookingBrowser,CityMaster,LocationMaster,FloorMaster,FacilityMaster,RoomMaster";
String tabNamesUser = "NewBooking,MyBooking,BookingBrowser";
%>
<%
  if(permissionChecker.isOmniadmin()== true)
{%>
<liferay-ui:tabs names="<%= tabNamesAdmin %>" url="<%= tabs1URL.toString() %>" />
<%}else
{%>
<liferay-ui:tabs names="<%= tabNamesUser %>" url="<%= tabs1URL.toString() %>" />
<%}%>