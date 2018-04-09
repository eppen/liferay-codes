package com.cignexdatamatics.wrm.portlet.controller;

import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.cignexdatamatics.wrm.NoSuchBookingRoomsException;
import com.cignexdatamatics.wrm.model.BookingAttendees;
import com.cignexdatamatics.wrm.model.BookingRooms;
import com.cignexdatamatics.wrm.model.FloorMaster;
import com.cignexdatamatics.wrm.model.LocationMaster;
import com.cignexdatamatics.wrm.model.RoomFacilityMapping;
import com.cignexdatamatics.wrm.model.RoomMaster;
import com.cignexdatamatics.wrm.service.BookingAttendeesLocalServiceUtil;
import com.cignexdatamatics.wrm.service.BookingRoomsLocalServiceUtil;
import com.cignexdatamatics.wrm.service.CityMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.FloorMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.LocationMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.NewBookingLocalServiceUtil;
import com.cignexdatamatics.wrm.service.RoomFacilityMappingLocalServiceUtil;
import com.cignexdatamatics.wrm.service.RoomMasterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 */

public class DeleteSelectedItems {
	
	    public void deleteBookings(ActionRequest request, ActionResponse response,List<BookingRooms>bookingRoomlist )
	    {	
		     int j=0;
		     Iterator<BookingRooms>it3=bookingRoomlist.iterator();
		     while(it3.hasNext())
		     {
		    	BookingRooms roomMapping=it3.next();
		    	long bookingId=roomMapping.getBookingId();
				try	{
					List<BookingRooms> roombyBookingId = (List<BookingRooms>) BookingRoomsLocalServiceUtil.findMappingByBookingId(bookingId);
					Iterator<BookingRooms> it5=roombyBookingId.iterator();
				    while(it5.hasNext()) 
				    { j++; it5.next();}  		 		     
					if(j==1){
					   NewBookingLocalServiceUtil.deleteNewBooking(bookingId);
					   List<BookingAttendees>	ba = BookingAttendeesLocalServiceUtil.findAllbyBookingId(bookingId);
					   Iterator <BookingAttendees>it6=ba.iterator();
					   while(it6.hasNext()){
							BookingAttendees bookingAttendeesobj=it6.next();
							BookingAttendeesLocalServiceUtil.remove(bookingAttendeesobj);
					   }					
				    }
				    BookingRoomsLocalServiceUtil.remove(roomMapping);					
				}
				catch (NoSuchBookingRoomsException e1){LOGGER.info("not able to find booking");} 
		        catch (PortalException e){ LOGGER.info(e.getMessage());}
		        catch (SystemException e1) { LOGGER.info(e1.getMessage());}			   
		     }
	     }
	    
	    public void deleteRooms(ActionRequest request, ActionResponse response,List <RoomMaster> roomlist )
	    {
	    	Iterator<RoomMaster> it1 = roomlist.iterator();
			while (it1.hasNext()){
				RoomMaster roommaster=(RoomMaster) it1.next();
				long roomId = roommaster.getRoomId();
				try{
					RoomMasterLocalServiceUtil.deleteRoomMaster(roomId);
					List<RoomFacilityMapping> rfm = RoomFacilityMappingLocalServiceUtil.findAllMappingbyRoomId(roomId);
					Iterator<RoomFacilityMapping> it4= rfm.iterator();
					while (it4.hasNext()){
						RoomFacilityMapping rfm2=(RoomFacilityMapping)it4.next();
						RoomFacilityMappingLocalServiceUtil.remove(rfm2);
					}
					List<BookingRooms> bookingRoomlist = BookingRoomsLocalServiceUtil.findAllBookingByRoomId(roomId);
					deleteBookings(request,response,bookingRoomlist);
				}catch (PortalException e){ LOGGER.info(e.getMessage());}
		        catch (SystemException e1) { LOGGER.info(e1.getMessage());}		
			}
			
	    }
	    
	    public void deleteFloors(ActionRequest request, ActionResponse response,List <FloorMaster> floorlist )
	    {
	    	Iterator <FloorMaster>it2 = floorlist.iterator();
			while (it2.hasNext()){
				FloorMaster floormaster=(FloorMaster) it2.next();
				long floorId = floormaster.getFloorId();
				try{
					List<RoomMaster> roomlist = RoomMasterLocalServiceUtil.findAllInFloor(floorId);
					deleteRooms(request,response,roomlist);
					FloorMasterLocalServiceUtil.deleteFloorMaster(floorId);				
				}catch (PortalException e){ LOGGER.info(e.getMessage());}
		        catch (SystemException e1) { LOGGER.info(e1.getMessage());}			
			
			}
	    }
	    
	    public void deleteLocations(ActionRequest request, ActionResponse response,List <LocationMaster> locationlist )
	    {
	    	Iterator<LocationMaster>it = locationlist.iterator();
			while (it.hasNext()){
				LocationMaster locationmaster=(LocationMaster) it.next();
				long locationId = locationmaster.getLocationId();
				try {
					List<FloorMaster> floorlist = FloorMasterLocalServiceUtil.findAllInLocation(locationId);
					deleteFloors(request,response,floorlist);
					LocationMasterLocalServiceUtil.deleteLocationMaster(locationId);
				}catch (PortalException e){ LOGGER.info(e.getMessage());}
		        catch (SystemException e1) { LOGGER.info(e1.getMessage());}				
			}
	    }	
	    
	    
	    public boolean deleteCity(ActionRequest request, ActionResponse response,long cityId )
	    {
	    	boolean flag=false;
	    	if (Validator.isNotNull(cityId)){
				try{
					List<LocationMaster> locationlist = LocationMasterLocalServiceUtil.findAllInCity(cityId);
					deleteLocations(request,response,locationlist);
					CityMasterLocalServiceUtil.deleteCityMaster(cityId);	
					flag=true;
				} catch (PortalException e){ LOGGER.info(e.getMessage());}
		        catch (SystemException e1) { LOGGER.info(e1.getMessage());}					
			} 
	    	return flag;
	    }
	    
	    private static final Log LOGGER = LogFactoryUtil.getLog(DeleteSelectedItems.class);

}
