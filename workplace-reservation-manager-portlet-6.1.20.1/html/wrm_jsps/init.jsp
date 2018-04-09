<%-- 

Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
This library is free software; you can redistribute it and/or modify it under the terms of the 
GNU Lesser General Public License as published by the Free Software Foundation; either 
version 2.1 of the License, or (at your option) any later version.
This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE. See the GNU Lesser General Public License for more details. 

--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.util.DateUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.*" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.util.KeyValuePair" %>
<%@ page import="com.liferay.portal.model.Group" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.taglib.util.IncludeTag" %>
<%@page import="com.cignexdatamatics.wrm.portlet.controller.BestOptionResult"%>
<%@ page import="java.io.PrintWriter" %>


<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.ActionRequest" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletSession" %>

<%@ page import="com.cignexdatamatics.wrm.model.CityMaster" %>
<%@ page import="com.cignexdatamatics.wrm.service.CityMasterLocalServiceUtil" %>
<%@ page import="com.cignexdatamatics.wrm.model.LocationMaster" %>
<%@ page import="com.cignexdatamatics.wrm.service.LocationMasterLocalServiceUtil" %>
<%@ page import="com.cignexdatamatics.wrm.model.RoomMaster" %>
<%@ page import="com.cignexdatamatics.wrm.service.RoomMasterLocalServiceUtil" %>
<%@ page import="com.cignexdatamatics.wrm.model.FloorMaster" %>
<%@ page import="com.cignexdatamatics.wrm.service.FloorMasterLocalServiceUtil" %>
<%@ page import="com.cignexdatamatics.wrm.model.FacilityMaster" %>
<%@ page import="com.cignexdatamatics.wrm.service.FacilityMasterLocalServiceUtil" %>
<%@ page import="com.cignexdatamatics.wrm.model.RoomFacilityMapping" %>
<%@ page import="com.cignexdatamatics.wrm.service.RoomFacilityMappingLocalServiceUtil" %>
<%@ page import="com.cignexdatamatics.wrm.model.NewBooking" %>
<%@ page import="com.cignexdatamatics.wrm.service.NewBookingLocalServiceUtil" %>
<%@ page import="com.cignexdatamatics.wrm.model.BookingRooms" %>
<%@ page import="com.cignexdatamatics.wrm.service.BookingRoomsLocalServiceUtil" %>
<%@ page import="com.cignexdatamatics.wrm.model.BookingFacilityMapping" %>
<%@ page import="com.cignexdatamatics.wrm.service.BookingFacilityMappingLocalServiceUtil" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="javax.portlet.RenderResponse" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.cignexdatamatics.wrm.model.BookingAttendees" %>
<%@ page import="com.cignexdatamatics.wrm.service.BookingAttendeesLocalServiceUtil" %>
<%@ page import="com.cignexdatamatics.wrm.portlet.utils.WRMConstants" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "java.util.Collections" %>
<%@ page  import="com.cignexdatamatics.wrm.portlet.controller.StoreResult"%>
<%@ page import="com.cignexdatamatics.wrm.portlet.utils.WRMConstants" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.cignexdatamatics.wrm.portlet.utils.CustomComparatorUtil" %>
<%@ page import="com.liferay.portlet.PortalPreferences"%>

<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<liferay-theme:defineObjects />
<portlet:defineObjects />