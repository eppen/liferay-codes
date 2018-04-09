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
   String rspText="<option value='0'>Select Floor</option>";
   long lid=ParamUtil.getLong(request, "locationID");
   List<FloorMaster> allFloor = FloorMasterLocalServiceUtil.findAllInLocation(lid);
   Iterator<FloorMaster> it1= allFloor.iterator();
   while(it1.hasNext())
   {
	    FloorMaster floor=(FloorMaster)it1.next();
        long id=floor.getFloorId();
        String name=floor.getFloorName();
        rspText +="<option value='"+id+"'>"+name+"</option>";
   }
   PrintWriter writer = response.getWriter();
   response.setContentType("text/plain");
   writer.write(rspText);
   writer.flush();
%>
