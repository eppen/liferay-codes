<%-- 

Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
This library is free software; you can redistribute it and/or modify it under the terms of the 
GNU Lesser General Public License as published by the Free Software Foundation; either 
version 2.1 of the License, or (at your option) any later version.
This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE. See the GNU Lesser General Public License for more details. 

--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/html/wrm_jsps/init.jsp" %>
<%
String ctxPath = request.getContextPath();
if (ctxPath != null && ctxPath.length() == 1)
{
	ctxPath = "";
}

long rmid=ParamUtil.getLong(request,"imageId");
String imgname=String.valueOf(rmid);
String path=ctxPath+"/img/"+imgname.trim();
String rspText="<img src='"+path+"' height=100 width=100></img>";
PrintWriter writer = response.getWriter();
response.setContentType("text/plain");
writer.write(rspText);
writer.flush();
%>
