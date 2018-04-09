/**
 * <a href="RoomNameComparator.java.html">View Source</a>
 *
 * @Project WRM
 * @Author Manali Lalaji
 * @Description This is the controller class RoomNameComparator for sorting on RoomName   
 * @ChangeLog:
 * Name | Date | Reason
 * --------------------------------------------------------------------------------------------------------------------------
 *  
 */
package com.cignexdatamatics.wrm.portlet.controller;
import com.cignexdatamatics.wrm.NoSuchRoomMasterException;
import com.cignexdatamatics.wrm.model.RoomMaster;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.cignexdatamatics.wrm.service.RoomMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.model.impl.BookingRoomsImpl;

import org.apache.log4j.Logger;

/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 */

public class RoomNameComparator extends OrderByComparator {  
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(DateComparator.class);
    private boolean asc;  
 
	 public RoomNameComparator(){ this(false);}  
	 public RoomNameComparator(boolean ascOrder) { asc = ascOrder;}  
	
	  
	 public int compare(Object obj1, Object obj2) 
	 {
	     int value=0;
	     try{
		  BookingRoomsImpl instance1 = (BookingRoomsImpl) obj1;  
		  BookingRoomsImpl instance2 = (BookingRoomsImpl) obj2; 
		  RoomMaster room1 = RoomMasterLocalServiceUtil.findRoomByRoomId(instance1.getRoomId());
		  RoomMaster room2 =RoomMasterLocalServiceUtil.findRoomByRoomId(instance2.getRoomId());
    	  value = room1.getRoomName().toLowerCase().compareTo(room2.getRoomName().toLowerCase());
	     }
	     catch(NoSuchRoomMasterException e){ log.warn(e.getMessage()); }	
         catch(SystemException e){ log.warn(e.getMessage()); }	
	     if(asc){  
	    	 return value;  
	     }
	     else{  
	    	 return -value;  
	     }       
	  }  
	 
	 public String getOrderBy()
	 {  
	    if(asc){ return"status ASC"; }   
	    else{ return "status DESC"; }  
	  }  
	 	
	}  
