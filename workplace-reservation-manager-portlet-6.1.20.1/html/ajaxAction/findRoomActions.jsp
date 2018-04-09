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

<%
   String rspText="<option value='0'>Select Room</option>";
   long lid=ParamUtil.getLong(request, "locationID");
   List<RoomMaster> selRoom = RoomMasterLocalServiceUtil.findAllInLocation(lid);
   Iterator<RoomMaster> it1= selRoom.iterator();
   while(it1.hasNext())
   {
        RoomMaster room=(RoomMaster)it1.next();
        long id=room.getRoomId();
        String name=room.getRoomName();
        rspText +="<option value='"+id+"'>"+name+"</option>";
   }
   PrintWriter writer = response.getWriter();
   response.setContentType("text/plain");
   writer.write(rspText);
   writer.flush();
 %>
