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
<div class="wrm-padd">
<%
	String tabs1 = ParamUtil.getString(request, WRMConstants.TABS1, WRMConstants.DEFAULT_TABS);
if(renderRequest.getAttribute(WRMConstants.TABS1) != null)
{
	tabs1 = String.valueOf(renderRequest.getAttribute(WRMConstants.TABS1));
}
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("tabs1", tabs1);
if(request.getAttribute("roomparam") != null)
{
%>
<jsp:include page="/html/wrm_jsps/admin/tabs2.jsp" />
<%
	}
else if(request.getAttribute("newbook") != null)
{
%> 
<jsp:include page="/html/wrm_jsps/admin/tabs3.jsp" />
<%
	}
else{
%>
	<jsp:include page="/html/wrm_jsps/admin/tabs1.jsp" />
<%
	}
%>
<c:if test='<%=tabs1.equals(WRMConstants.DEFAULT_TABS)%>'>
<%
	String jspflag4=(String)request.getAttribute("flag4");
request.setAttribute("jspflag4",jspflag4);
if(request.getAttribute("room_book") == null)
{
%>
<jsp:include page="/html/wrm_jsps/common/room_booking.jsp" />
<%
	}
else{
%>
<jsp:include page="/html/wrm_jsps/common/room_booking_meeting_detail.jsp" />
<%
	}
%>
</c:if>


<c:if test='<%=tabs1.equals(WRMConstants.TABS2)%>'>
<%
	String jspflag2=(String)request.getAttribute("flag2");
request.setAttribute("jspflag2",jspflag2);
%>
<jsp:include page="/html/wrm_jsps/common/my_booking.jsp" />
</c:if>



<c:if test='<%=tabs1.equals(WRMConstants.TABS3)%>'>
<%
	String jspflag3=(String)request.getAttribute("flag3");
request.setAttribute("jspflag3",jspflag3);
%>
<jsp:include page="/html/wrm_jsps/common/booking_browse.jsp" />
</c:if>



<c:if test='<%=tabs1.equals(WRMConstants.TABS4)%>'>
<%
	if(request.getAttribute("city_edit") != null)
{
%>
<jsp:include page="/html/wrm_jsps/admin/city_master_edit.jsp" />
<%
	}else
{
%>
<jsp:include page="/html/wrm_jsps/admin/city_master_view.jsp" />
<%
	}
%>
</c:if>


<c:if test='<%=tabs1.equals(WRMConstants.TABS5)%>'>
<%
	if(request.getAttribute("location_edit") != null)
{
%>
<jsp:include page="/html/wrm_jsps/admin/location_master_edit.jsp" />
<%
	} else
{
%>
<jsp:include page="/html/wrm_jsps/admin/location_master_view.jsp" />
<%
	}
%>
</c:if>


<c:if test='<%=tabs1.equals(WRMConstants.TABS6)%>'>
<%
	if(request.getAttribute("floor_edit") != null)
{
%>
<jsp:include page="/html/wrm_jsps/admin/floor_master_edit.jsp" />
<%
	} else
{
%>
<jsp:include page="/html/wrm_jsps/admin/floor_master_view.jsp" />
<%
	}
%>
</c:if>


<c:if test='<%=tabs1.equals(WRMConstants.TABS7)%>'>
<%
	if(request.getAttribute("facility_edit") != null)
{
%>
<jsp:include page="/html/wrm_jsps/admin/facility_master_edit.jsp" />
<%
	} else
{
%>
<jsp:include page="/html/wrm_jsps/admin/facility_master_view.jsp" />
<%
	}
%>
</c:if>



<c:if test='<%=tabs1.equals(WRMConstants.TABS8)%>'>
<%
if(request.getAttribute("roomadd2") != null)
{%>
<jsp:include page="/html/wrm_jsps/admin/meeting_room_master_add.jsp" />
<%}
else if(request.getAttribute("room_edit") != null)
{%>
<jsp:include page="/html/wrm_jsps/admin/meeting_room_master_edit.jsp" />
<%}
else
{%>
<jsp:include page="/html/wrm_jsps/admin/meeting_room_master_view.jsp" />
<%}%>
</c:if>
<jsp:include page="/html/wrm_jsps/admin/footer.jsp" />
</div>