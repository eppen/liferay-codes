/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 */

package com.cignexdatamatics.wrm.service.impl;

import com.cignexdatamatics.wrm.NoSuchRoomMasterException;
import com.cignexdatamatics.wrm.model.RoomMaster;
import com.cignexdatamatics.wrm.service.persistence.RoomMasterUtil;
import com.cignexdatamatics.wrm.service.base.RoomMasterLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

/**
 * <a href="RoomMasterLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 */
public class RoomMasterLocalServiceImpl extends RoomMasterLocalServiceBaseImpl
{

	public List<RoomMaster> findAllRoom()	throws SystemException
	{
		return (List<RoomMaster>) roomMasterPersistence.findAll();
		
	}
	public List<RoomMaster> findAllInFloor(long floorId) throws SystemException
	{
		 return  (List<RoomMaster>) RoomMasterUtil.findByFloorId(floorId);	          
	}
	public List<RoomMaster> findAllInLocation(long locationId) throws SystemException
	{
	       return (List<RoomMaster>) RoomMasterUtil.findByLocationId(locationId);	        
	}
	public List<RoomMaster> findAllRoomInCity(long cityId) throws SystemException
	{
		return  (List<RoomMaster>) RoomMasterUtil.findByCityId(cityId);	   
	}
	 public List<RoomMaster> findAllRoomByLocandCity(long cityId,long locId) throws SystemException
	 {
		 return  (List<RoomMaster>) roomMasterPersistence.findByRoomByLocandCity(cityId,locId);
     }
	 public List<RoomMaster> findAllRoomByLocationCityFloor(long cityId,long locationId,long floorId) throws SystemException
	 {
		 return roomMasterPersistence.findByRoomByLocationCityFloor(cityId, locationId, floorId);
	 }
	 public RoomMaster findRoomByRoomId(long roomId) throws SystemException, NoSuchRoomMasterException
	 {
	     return roomMasterPersistence.findByPrimaryKey(roomId);
	 }
	 public RoomMaster addRoom (RoomMaster validRoom) throws SystemException
	 {
	    RoomMaster room=RoomMasterUtil.create(CounterLocalServiceUtil.increment(RoomMaster.class.getName()));
		room.setRoomName(validRoom.getRoomName());
		room.setCityId(validRoom.getCityId());
		room.setLocationId(validRoom.getLocationId());
		room.setFloorId(validRoom.getFloorId());
		room.setCapacity(validRoom.getCapacity());
		room.setExtension(validRoom.getExtension());
		return RoomMasterUtil.update(room, false);
	 }
	 public void remove(RoomMaster room) throws SystemException
	 {
	     try {
			RoomMasterUtil.remove(room.getRoomId());
		} catch (NoSuchRoomMasterException e) {
			 LOGGER.info(e.getMessage());
		}
	 }
	 private static final Log LOGGER = LogFactoryUtil.getLog(RoomMasterLocalServiceImpl.class);
}