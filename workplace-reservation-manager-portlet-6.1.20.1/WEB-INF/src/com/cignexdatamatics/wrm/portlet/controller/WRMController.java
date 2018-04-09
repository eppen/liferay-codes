/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
/**
* <a href="GenericContentDTO.java.html">View Source</a>
*
* @Project     : WRM
* @Author      : Komal Vadukia
* @Description : This is the Controller class which is created for handling all requests and process them  
* @ChangeLog   :
* Name | Date | Reason
* Mayur Patel | 18-Aug-11 | getting render parameter and setting its value in attribute.
* ------------------------------------------------------------
*
*/

package com.cignexdatamatics.wrm.portlet.controller;
import com.cignexdatamatics.wrm.model.CityMaster;
import com.cignexdatamatics.wrm.model.FacilityMaster;
import com.cignexdatamatics.wrm.model.FloorMaster;
import com.cignexdatamatics.wrm.model.LocationMaster;
import com.cignexdatamatics.wrm.model.RoomMaster;
import com.cignexdatamatics.wrm.service.CityMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.FacilityMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.FloorMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.LocationMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.RoomMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.portlet.utils.WRMConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 */

public class WRMController extends GenericPortlet
{

	public static final ResourceBundle WRMRB = ResourceBundle.getBundle("wrm_portlet");
	
	public void init() throws PortletException
	{
		homeJSP=getInitParameter("home-jsp");
		popupJSP=getInitParameter("popup-jsp");
	}

	public void doDispatch(	RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException
	{
		String jspPage = renderRequest.getParameter("jspPage");
		if (jspPage != null)
		{
			include(jspPage, renderRequest, renderResponse);
		}
		else
		{
			super.doDispatch(renderRequest, renderResponse);
		}
	}

	public void doEdit(	RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException
	{

	}

	public void doHelp(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException
	{

	}
	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException
	{
		setAttributeInRequest(renderRequest, renderResponse);
		setCityLocFloorRoomFacilityAttrInRequest(renderRequest, renderResponse);
		String myBooking=renderRequest.getParameter(MYBOOKING);
		processAndSetCity(renderRequest, renderResponse);
		processAndSetLocation(renderRequest, renderResponse);
		processAndSetFloor(renderRequest, renderResponse);
		processAndSetRoom(renderRequest, renderResponse);
		processAndSetFacility(renderRequest, renderResponse);
		processAndSetSearchCreteria(renderRequest, renderResponse);
		try
		{
		PortletURL editURL = renderResponse.createActionURL();
		String view = (String) renderRequest.getParameter("view");
	    if ("editCity".equalsIgnoreCase(view))
		{
	    	editURL.setParameter(ACTION, "updateCity");
			long cityId = Long.parseLong(renderRequest.getParameter("cityID"));
			CityMaster city = CityMasterLocalServiceUtil.getCityMaster(cityId);
			setEditAttributeInRequest(renderRequest, editURL, "updateCity", "city", city, "editCityURL",  editURL.toString());
		}
		else if("editLocation".equalsIgnoreCase(view))
		{
			editURL.setParameter(ACTION, "updateLocation");
			long locationId = Long.parseLong(renderRequest.getParameter("locationID"));
			LocationMaster location = LocationMasterLocalServiceUtil.getLocationMaster(locationId);
			setEditAttributeInRequest(renderRequest, editURL, "updateLocation", "location", location, "editLocationURL",  editURL.toString());
		}
		else if ("editRoom".equalsIgnoreCase(view))
		{
			editURL.setParameter(ACTION, "updateRoom");
			long roomId = Long.parseLong(renderRequest.getParameter("roomID"));
			RoomMaster room = RoomMasterLocalServiceUtil.getRoomMaster(roomId);
			setEditAttributeInRequest(renderRequest, editURL, "updateRoom", "room", room, "editRoomURL",  editURL.toString());
		}
		else if("editFloor".equalsIgnoreCase(view))
		{

			editURL.setParameter(ACTION, "updateFloor");
			long floorId = Long.parseLong(renderRequest.getParameter("floorID"));
			FloorMaster floor = FloorMasterLocalServiceUtil.getFloorMaster(floorId);
			setEditAttributeInRequest(renderRequest, editURL, "updateFloor", "floor", floor, "editFloorURL",  editURL.toString());
		}
		else if ("editFacility".equalsIgnoreCase(view))
		{
			editURL.setParameter(ACTION, "updateFacility");
			long facilityId = Long.parseLong(renderRequest.getParameter("facilityID"));
			FacilityMaster facility = FacilityMasterLocalServiceUtil.getFacilityMaster(facilityId);
			setEditAttributeInRequest(renderRequest, editURL, "updateFacility", "facility", facility, "editFacilityURL",  editURL.toString());
		}
		if("AttendeesPopup".equalsIgnoreCase(myBooking)){
				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(popupJSP);
				dispatcher.include(renderRequest, renderResponse);
		}else{
			     include(homeJSP, renderRequest, renderResponse);
		}
	  }catch (SystemException e) { LOGGER.info(e.getMessage());} 
	   catch (PortalException e) {LOGGER.info(e.getMessage());}	
  }
	
	public void setEditAttributeInRequest(RenderRequest renderRequest, PortletURL editURL,String actionParameter,String attributeName,Object object,String editURLName,String editURLValue)
			throws IOException, PortletException
	{
		editURL.setParameter(ACTION, actionParameter);
		renderRequest.setAttribute(attributeName, object);
		renderRequest.setAttribute(editURLName,editURLValue);
	}
	
	public void setAttributeInRequest(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException
	{
		String myBooking=renderRequest.getParameter(MYBOOKING);
		renderRequest.setAttribute("mybookingpopup",myBooking);
		renderRequest.setAttribute("bookingIdAttendees",renderRequest.getParameter("bookingId"));
		renderRequest.setAttribute(CANCEL,renderRequest.getParameter(CANCEL));
		renderRequest.setAttribute("newbook",renderRequest.getParameter("newbook"));
		renderRequest.setAttribute(WRMConstants.TABS1, renderRequest.getParameter(TAB));
		renderRequest.setAttribute("prioritywiseapproxfilterbyDateTime",renderRequest.getParameter("prioritywiseapproxfilterbyDateTime"));
		renderRequest.setAttribute("bestapproxfilterbyDateTime",renderRequest.getParameter("bestapproxfilterbyDateTime"));
		renderRequest.setAttribute("approxfilterbyDateTime",renderRequest.getParameter("approxfilterbyDateTime"));
		renderRequest.setAttribute("fixfinalResult",renderRequest.getParameter("fixfinalResult"));
		renderRequest.setAttribute("dateRoomlist",renderRequest.getParameter("dateRoomlist"));
		renderRequest.setAttribute("timeRoom",renderRequest.getParameter("timeRoom"));
		renderRequest.setAttribute("searchbrowse",renderRequest.getParameter("searchbrowse") );
		renderRequest.setAttribute(MYBOOKING,myBooking);
		renderRequest.setAttribute("MyBookingResult",renderRequest.getParameter("MyBookingResult"));
		renderRequest.setAttribute("browseResult", renderRequest.getParameter("browseResult"));
		renderRequest.setAttribute("finalResult",renderRequest.getParameter("finalResult"));
		renderRequest.setAttribute("booking_delete",renderRequest.getParameter("booking_delete") );
		renderRequest.setAttribute("mybooking_delete",renderRequest.getParameter("mybooking_delete"));
		renderRequest.setAttribute("flag", renderRequest.getParameter("flagroom"));
		renderRequest.setAttribute("flag2", renderRequest.getParameter("flag4mybooking"));
		renderRequest.setAttribute("flag3", renderRequest.getParameter("flag4browsing"));
		renderRequest.setAttribute("flag4", renderRequest.getParameter("flag4searching"));
		renderRequest.setAttribute("room_book", renderRequest.getParameter("room_book"));
		StoreResult sr=(StoreResult) renderRequest.getAttribute("tempmybookingResult");
		renderRequest.setAttribute("tempmybookingResult",sr);
		StoreResult sr1=(StoreResult) renderRequest.getAttribute("tempbrowsingResult");
		renderRequest.setAttribute("tempbrowsingResult",sr1);
		BestOptionResult br=(BestOptionResult)renderRequest.getAttribute("tempsearchingResult");
		renderRequest.setAttribute("tempsearchingResult",br);
		String mailTo = WRMRB.getString("wrm.suggestion.question.send.to");
		if(Validator.isNull(mailTo))
		{
			 mailTo= WRMConstants.MAILTO;
		}
		renderRequest.setAttribute("mailTo",mailTo);
	}
	
	public void setCityLocFloorRoomFacilityAttrInRequest(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException
	{
		renderRequest.setAttribute("city_update", renderRequest.getParameter("city_update"));
		renderRequest.setAttribute("city_edit", renderRequest.getParameter("city_edit"));
		renderRequest.setAttribute("city_add", renderRequest.getParameter("city_add"));
		renderRequest.setAttribute("citydelete", renderRequest.getParameter("city_delete"));
		renderRequest.setAttribute("city_deleteselected", renderRequest.getParameter("city_deleteselected"));

		renderRequest.setAttribute("location_update", renderRequest.getParameter("location_update"));
		renderRequest.setAttribute("location_edit", renderRequest.getParameter("location_edit"));
		renderRequest.setAttribute("location_add", renderRequest.getParameter("locationadd"));
		renderRequest.setAttribute("locationdelete", renderRequest.getParameter("location_delete"));
		renderRequest.setAttribute("locationdeleteselected", renderRequest.getParameter("location_deleteselected"));

		renderRequest.setAttribute("floor_update", renderRequest.getParameter("floor_update"));
		renderRequest.setAttribute("floor_edit", renderRequest.getParameter("floor_edit"));
		renderRequest.setAttribute("flooradd", renderRequest.getParameter("floor_add"));
		renderRequest.setAttribute("floordelete", renderRequest.getParameter("floor_delete"));
		renderRequest.setAttribute("floordeleteselected", renderRequest.getParameter("floor_deleteselected"));

		renderRequest.setAttribute("room_update", renderRequest.getParameter("room_update"));
		renderRequest.setAttribute("room_edit", renderRequest.getParameter("room_edit"));
		renderRequest.setAttribute("roomadd", renderRequest.getParameter("room_add"));
		renderRequest.setAttribute("roomdelete", renderRequest.getParameter("room_delete"));
		renderRequest.setAttribute("roomadd2", renderRequest.getParameter("room_add2"));
		renderRequest.setAttribute("roomdeleteselected", renderRequest.getParameter("room_deleteselected"));
		renderRequest.setAttribute(ROOMPARAM, renderRequest.getParameter(ROOMPARAM));
		renderRequest.setAttribute(ROOMADDCANCLE,renderRequest.getParameter(ROOMADDCANCLE));

		renderRequest.setAttribute("facility_update", renderRequest.getParameter("facility_update"));
		renderRequest.setAttribute("facility_edit", renderRequest.getParameter("facility_edit"));
		renderRequest.setAttribute("facilityadd",renderRequest.getParameter("facility_add"));
		renderRequest.setAttribute("facilitydelete", renderRequest.getParameter("facility_delete"));
		renderRequest.setAttribute("facilitydeleteselected", renderRequest.getParameter("facility_deleteselected"));		
	}
	
	public void processAndSetCity(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException
	{
		try
		{
			List<CityMaster> allCity = CityMasterLocalServiceUtil.findAllInCity();
			renderRequest.setAttribute("allCity", allCity);

			PortletURL deleteCityURL = renderResponse.createActionURL();
			deleteCityURL.setParameter(ACTION, "deleteCity");
			renderRequest.setAttribute("deleteCityURL", deleteCityURL.toString());

			PortletURL deleteselectedCityURL = renderResponse.createActionURL();
			deleteselectedCityURL.setParameter(ACTION, "deleteselectedCity");
			renderRequest.setAttribute("deleteselectedCityURL", deleteselectedCityURL.toString());

			PortletURL addCityURL = renderResponse.createActionURL();
			addCityURL.setParameter(ACTION, "addCity");
			renderRequest.setAttribute("addCityURL", addCityURL.toString());		

			PortletURL cancelCityURL = renderResponse.createActionURL();
			cancelCityURL.setParameter(ACTION, "cancelcity");
			renderRequest.setAttribute("cancelCityURL", cancelCityURL.toString());
		}
		catch (SystemException e) {
			LOGGER.info(e.getMessage());
		}
		
	}
	
	public void processAndSetLocation(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException
	{
		List<LocationMaster> allLocation;
		try {
			allLocation = LocationMasterLocalServiceUtil.findAllLocation();
			renderRequest.setAttribute("allLocation", allLocation);

			PortletURL deleteLocationURL = renderResponse.createActionURL();
			deleteLocationURL.setParameter(ACTION, "deleteLocation");
			renderRequest.setAttribute("deleteLocationURL", deleteLocationURL.toString());

			PortletURL addLocationURL = renderResponse.createActionURL();
			addLocationURL.setParameter(ACTION, "addLocation");
			renderRequest.setAttribute("addLocationURL", addLocationURL.toString());

			PortletURL deleteselectedLocationURL = renderResponse.createActionURL();
			deleteselectedLocationURL.setParameter(ACTION, "deleteselectedLocation");
			renderRequest.setAttribute("deleteselectedLocationURL", deleteselectedLocationURL.toString());
		
			PortletURL cancelLocationURL = renderResponse.createActionURL();
			cancelLocationURL.setParameter(ACTION, "cancellocation");
			renderRequest.setAttribute("cancelLocationURL", cancelLocationURL.toString());
		} catch (SystemException e) {
			LOGGER.info(e.getMessage());
		}
		
	}
	
	public void processAndSetFloor(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException
	{
		try {
			List<FloorMaster> allFloor =FloorMasterLocalServiceUtil.findAllFloor();
			renderRequest.setAttribute("allFloor", allFloor);

			PortletURL deleteFloorURL = renderResponse.createActionURL();
			deleteFloorURL.setParameter(ACTION, "deleteFloor");
			renderRequest.setAttribute("deleteFloorURL", deleteFloorURL.toString());

			PortletURL addFloorURL = renderResponse.createActionURL();
			addFloorURL.setParameter(ACTION, "addFloor");
			renderRequest.setAttribute("addFloorURL", addFloorURL.toString());

			PortletURL deleteselectedFloorURL = renderResponse.createActionURL();
			deleteselectedFloorURL.setParameter(ACTION, "deleteselectedFloor");
			renderRequest.setAttribute("deleteselectedFloorURL", deleteselectedFloorURL.toString());
			
			PortletURL cancelFloorURL = renderResponse.createActionURL();
			cancelFloorURL.setParameter(ACTION, "cancelfloor");
			renderRequest.setAttribute("cancelFloorURL", cancelFloorURL.toString());
			
		    String wrmFloors = WRMRB.getString("wrm.floors");
		    if(Validator.isNotNull(wrmFloors))
		    {
		    	String wrmFloorsData[]= wrmFloors.split(StringPool.COMMA);
		    	renderRequest.setAttribute("wrmFloors", wrmFloorsData);
		    }
		   
		}
		catch (SystemException e) {
			LOGGER.info(e.getMessage());
		}
	}
	
	public void processAndSetRoom(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException
	{
		try {
			List<RoomMaster> allRoom = RoomMasterLocalServiceUtil.findAllRoom();
			renderRequest.setAttribute("allRoom", allRoom);

			PortletURL deleteRoomURL = renderResponse.createActionURL();
			deleteRoomURL.setParameter(ACTION, "deleteRoom");
			renderRequest.setAttribute("deleteRoomURL", deleteRoomURL.toString());

			PortletURL addRoomURL = renderResponse.createActionURL();
			addRoomURL.setParameter(ACTION, "addRoom");
			renderRequest.setAttribute("addRoomURL", addRoomURL.toString());

			PortletURL addRoom2URL = renderResponse.createActionURL();
			addRoom2URL.setParameter(ACTION, "addRoom2");
			renderRequest.setAttribute("addRoom2URL", addRoom2URL.toString());

			PortletURL deleteselectedRoomURL = renderResponse.createActionURL();
			deleteselectedRoomURL.setParameter(ACTION, "deleteselectedRoom");
			renderRequest.setAttribute("deleteselectedRoomURL", deleteselectedRoomURL.toString());
			
			PortletURL addRoomCancelURL = renderResponse.createActionURL();
			addRoomCancelURL.setParameter(ACTION, "addRoomCancel");
			renderRequest.setAttribute("addRoomCancelURL", addRoomCancelURL.toString());

			PortletURL editRoomCancelURL = renderResponse.createActionURL();
			editRoomCancelURL.setParameter(ACTION, "addRoomCancel");
			renderRequest.setAttribute("editRoomCancelURL", editRoomCancelURL.toString());
		}
		catch (SystemException e) {
			LOGGER.info(e.getMessage());
		}
	}
	
	public void processAndSetFacility(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException
	{
		try {
			List<FacilityMaster> allFacility = FacilityMasterLocalServiceUtil.findAllFacility();
			renderRequest.setAttribute("allFacility", allFacility);

			PortletURL deleteFacilityURL = renderResponse.createActionURL();
			deleteFacilityURL.setParameter(ACTION, "deleteFacility");
			renderRequest.setAttribute("deleteFacilityURL", deleteFacilityURL.toString());

			PortletURL addFacilityURL = renderResponse.createActionURL();
			addFacilityURL.setParameter(ACTION, "addFacility");
			renderRequest.setAttribute("addFacilityURL", addFacilityURL.toString());

			PortletURL deleteselectedFacilityURL = renderResponse.createActionURL();
			deleteselectedFacilityURL.setParameter(ACTION, "deleteselectedFacility");
			renderRequest.setAttribute("deleteselectedFacilityURL", deleteselectedFacilityURL.toString());
			
			PortletURL cancelFacilityURL = renderResponse.createActionURL();
			cancelFacilityURL.setParameter(ACTION, "cancelfacility");
			renderRequest.setAttribute("cancelFacilityURL", cancelFacilityURL.toString());
		}
		catch (SystemException e) {
			LOGGER.info(e.getMessage());
		}
	}
	
	public void processAndSetSearchCreteria(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException
	{
		PortletURL bookingURL = renderResponse.createActionURL();
		bookingURL.setParameter(ACTION, "booking");
		renderRequest.setAttribute("bookingURL", bookingURL.toString());

		PortletURL browsingURL = renderResponse.createActionURL();
		browsingURL.setParameter(ACTION, "browsing");
		renderRequest.setAttribute("browsingURL", browsingURL.toString());

		PortletURL mybookingURL = renderResponse.createActionURL();
		mybookingURL.setParameter(ACTION, MYBOOKING);
		renderRequest.setAttribute("mybookingURL", mybookingURL.toString());

		PortletURL cancleBookingURL = renderResponse.createActionURL();
		cancleBookingURL.setParameter(ACTION, "cancleBooking");
		renderRequest.setAttribute("cancleBookingURL", cancleBookingURL.toString());

		PortletURL cancleMyBookingURL = renderResponse.createActionURL();
		cancleMyBookingURL.setParameter(ACTION, "cancleMyBooking");
		renderRequest.setAttribute("cancleMyBookingURL", cancleMyBookingURL.toString());
		
		PortletURL bookRoomURL = renderResponse.createActionURL();
		bookRoomURL.setParameter(ACTION, "bookRoom");
		renderRequest.setAttribute("bookRoomURL", bookRoomURL.toString());
		
		PortletURL bookRoomDetailsURL = renderResponse.createActionURL();
		bookRoomDetailsURL.setParameter(ACTION, "bookRoomDetails");
		renderRequest.setAttribute("bookRoomDetailsURL", bookRoomDetailsURL.toString());
		
		PortletURL cancelNewBooking = renderResponse.createActionURL();
		cancelNewBooking.setParameter(ACTION, "cancelNewBooking");
		renderRequest.setAttribute("cancelNewBooking", cancelNewBooking.toString());
	}
	
	

@ProcessAction(name = "addCity")
public void addCity(ActionRequest request, ActionResponse response)
{
	CityAction  ca=new CityAction();
	ca.addCity(request, response);
}

@ProcessAction(name = "addLocation")
public void addLocation(ActionRequest request, ActionResponse response)
{
   LocationAction la=new LocationAction();
   la.addLocation(request, response);
}

@ProcessAction(name = "addFloor")
public void addFloor(ActionRequest request, ActionResponse response)
{
	FloorAction fa=new FloorAction();
	fa.addFloor(request, response);
}

@ProcessAction(name = "addRoom")
public void addRoom(ActionRequest request, ActionResponse response) 
{
   RoomAction ra=new RoomAction();
   ra.addRoom(request, response);
}

@ProcessAction(name = "addRoom2")
public void addRoom2(ActionRequest request, ActionResponse response)
{
response.setRenderParameter("room_add2", "room_add2");
response.setRenderParameter(TAB,"RoomMaster");
response.setRenderParameter(ROOMPARAM,ROOMPARAM);
}

@ProcessAction(name = "addFacility")
public void addFacility(ActionRequest request, ActionResponse response)
{
   FacilityAction fa=new FacilityAction();
   fa.addFacility(request, response);
}

@ProcessAction(name = "editCity")
public void editCity(ActionRequest request, ActionResponse response) 
{
	CityAction  ca=new CityAction();
	ca.editCity(request, response);
}

@ProcessAction(name = "editLocation")
public void editLocation(ActionRequest request, ActionResponse response) 
{
	LocationAction la=new LocationAction();
	la.editLocation(request, response);
}

@ProcessAction(name = "editFloor")
public void editFloor(ActionRequest request, ActionResponse response) 
{
	FloorAction fa=new FloorAction();
	fa.editFloor(request, response);
}

@ProcessAction(name = "editRoom")
public void editRoom(ActionRequest request, ActionResponse response) 
{
	RoomAction ra=new RoomAction();
	ra.editRoom(request, response);
	response.setRenderParameter(ROOMPARAM,ROOMPARAM);
}

@ProcessAction(name = "addRoomCancel")
public void addRoomCancel(ActionRequest request, ActionResponse response)
{
response.setRenderParameter(ROOMADDCANCLE, ROOMADDCANCLE);
response.setRenderParameter(TAB,"RoomMaster");
}

@ProcessAction(name = "editFacility")
public void editFacility(ActionRequest request, ActionResponse response) 
{
	FacilityAction fa=new FacilityAction();
	fa.editFacility(request, response);
}

@ProcessAction(name = "updateCity")
public void updateCity(ActionRequest request, ActionResponse response)	
{
	CityAction  ca=new CityAction();
	ca.updateCity(request, response);
}

@ProcessAction(name = "updateLocation")
public void updateLocation(ActionRequest request, ActionResponse response)	
{
	LocationAction la=new LocationAction();
	la.updateLocation(request, response);
}

@ProcessAction(name = "updateFloor")
public void updateFloor(ActionRequest request, ActionResponse response)	
{
	FloorAction fa=new FloorAction();
	fa.updateFloor(request, response);
}

@ProcessAction(name = "updateRoom")
public void updateRoom(ActionRequest request, ActionResponse response)	
{
	RoomAction ra=new RoomAction();
	ra.updateRoom(request, response);
}

@ProcessAction(name = "updateFacility")
public void updateFacility(ActionRequest request, ActionResponse response)	
{
	FacilityAction fa=new FacilityAction();
	fa.updateFacility(request, response);
}

@ProcessAction(name = "deleteCity")
public void deleteCity(ActionRequest request, ActionResponse response)
{
	CityAction  ca=new CityAction();
	ca.deleteCity(request, response);
}

@ProcessAction(name = "deleteLocation")
public void deleteLocation(ActionRequest request, ActionResponse response)
{
	LocationAction la=new LocationAction();
	la.deleteLocation(request, response);
}

@ProcessAction(name = "deleteFloor")
public void deleteFloor(ActionRequest request, ActionResponse response)
{
	FloorAction fa=new FloorAction();
	fa.deleteFloor(request, response);
}

@ProcessAction(name = "deleteRoom")
public void deleteRoom(ActionRequest request, ActionResponse response)
{
	RoomAction ra=new RoomAction();
	ra.deleteRoom(request, response);
}

@ProcessAction(name = "deleteFacility")
public void deleteFacility(ActionRequest request, ActionResponse response)
{
	FacilityAction fa=new FacilityAction();
	fa.deleteFacility(request, response);
}
@ProcessAction(name = "deleteselectedCity")
public void deleteselectedCity(ActionRequest request, ActionResponse response)
{
	CityAction  ca=new CityAction();
	ca.deleteselectedCity(request,response);
}
@ProcessAction(name = "deleteselectedLocation")
public void deleteselectedLocation(ActionRequest request, ActionResponse response)
{
	LocationAction la=new LocationAction();
	la.deleteselectedLocation(request, response);
}

@ProcessAction(name = "deleteselectedFloor")
public void deleteselectedFloor(ActionRequest request, ActionResponse response)
{
	FloorAction fa=new FloorAction();
	fa.deleteselectedFloor(request, response);
}

@ProcessAction(name = "deleteselectedRoom")
public void deleteselectedRoom(ActionRequest request, ActionResponse response)
{
	RoomAction ra=new RoomAction();
	ra.deleteselectedRoom(request, response);
}

@ProcessAction(name = "deleteselectedFacility")
public void deleteselectedFacility(ActionRequest request, ActionResponse response)
{
	FacilityAction fa=new FacilityAction();
	fa.deleteselectedRoom(request, response);
}

@ProcessAction(name = "booking")
public void booking(ActionRequest request, ActionResponse response)
{
	SearchAction sa=new SearchAction();
	sa.booking(request, response);
}

@ProcessAction(name = "browsing")
public void browsing(ActionRequest request, ActionResponse response)
{
	SearchAction sa=new SearchAction();
	sa.browsing(request, response);
}

@ProcessAction(name = "cancleBooking")
public void cancleBooking(ActionRequest request, ActionResponse response)
{
	SearchAction sa=new SearchAction();
	sa.cancleBooking(request, response);
}

@ProcessAction(name = MYBOOKING)
public void mybooking(ActionRequest request, ActionResponse response)
{
	SearchAction sa=new SearchAction();
	sa.mybooking(request, response);
}

@ProcessAction(name = "cancleMyBooking")
public void cancleMyBooking(ActionRequest request, ActionResponse response)
{
    SearchAction sa=new SearchAction();
	sa.cancleMyBooking(request, response);
}

@ProcessAction(name = "bookRoom")
public void bookRoom(ActionRequest request, ActionResponse response) 
{
	SearchAction sa=new SearchAction();
	sa.bookRoom(request, response);
}

@ProcessAction(name = "bookRoomDetails")
public void  bookRoomDetails(ActionRequest request, ActionResponse response) 
{
	SearchAction sa=new SearchAction();
	sa.bookRoomDetails(request, response);
}

@ProcessAction(name = "cancelcity")
public void cancelcity(ActionRequest request, ActionResponse response)
{
	response.setRenderParameter(CANCEL, CANCEL);
	response.setRenderParameter(TAB,"CityMaster");
}
@ProcessAction(name = "cancellocation")
public void cancellocation(ActionRequest request, ActionResponse response)
{
	response.setRenderParameter(CANCEL, CANCEL);
	response.setRenderParameter(TAB,"LocationMaster");
}
@ProcessAction(name = "cancelfloor")
public void cancelfloor(ActionRequest request, ActionResponse response)
{
	response.setRenderParameter(CANCEL,CANCEL);
	response.setRenderParameter(TAB,"FloorMaster");
}

@ProcessAction(name = "cancelfacility")
public void cancelfacility(ActionRequest request, ActionResponse response)
{
	response.setRenderParameter(CANCEL, CANCEL);
	response.setRenderParameter(TAB,"FacilityMaster");
}

@ProcessAction(name = "cancelNewBooking")
public void cancelNewBooking(ActionRequest request, ActionResponse response)
{
	response.setRenderParameter(CANCEL, CANCEL);
	response.setRenderParameter(TAB,"NewBooking");
}


protected void include(	String path, RenderRequest renderRequest,RenderResponse renderResponse)
		throws IOException, PortletException
{

		PortletRequestDispatcher portletRequestDispatcher =	getPortletContext().getRequestDispatcher(path);
		if (portletRequestDispatcher == null)
		{
			LOGGER.error(path + " is not a valid include");
		}
		else
		{
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
}

    private String homeJSP,popupJSP;
	private static final String TAB="tabs1";
	private static final String ROOMADDCANCLE="room_addcancel";
	private static final String CANCEL="cancel";
	private static final String MYBOOKING="mybooking";
	private static final String ROOMPARAM="roomparam";
	private static final String ACTION="javax.portlet.action";
	private static final Log LOGGER = LogFactoryUtil.getLog(WRMController.class);

}