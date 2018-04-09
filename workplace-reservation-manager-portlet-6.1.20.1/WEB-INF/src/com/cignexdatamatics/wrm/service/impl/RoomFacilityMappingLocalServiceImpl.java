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

import com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException;
import com.cignexdatamatics.wrm.model.RoomFacilityMapping;
import com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK;
import com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingUtil;
import com.cignexdatamatics.wrm.service.base.RoomFacilityMappingLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

public class RoomFacilityMappingLocalServiceImpl
	extends RoomFacilityMappingLocalServiceBaseImpl
{

	public List<RoomFacilityMapping> findAllMappingbyRoomId(long roomId)throws SystemException
	 {
	        return (List<RoomFacilityMapping>) roomFacilityMappingPersistence.findByroomId(roomId);
	      
	 }
	public List<RoomFacilityMapping> findAllMappingbyFacilitiesId(long facilitiesId)throws SystemException
	 {
	        return  (List<RoomFacilityMapping>) roomFacilityMappingPersistence.findByfacilitiesId(facilitiesId);
	         
	 }
	 public RoomFacilityMapping addRoomFacilityMapping (RoomFacilityMapping validRoomFacilityMapping) throws SystemException
	 {
		 RoomFacilityMapping roomFacilityMapping=RoomFacilityMappingUtil.create(new RoomFacilityMappingPK(validRoomFacilityMapping.getRoomId(),validRoomFacilityMapping.getFacilitiesId()));
		 return RoomFacilityMappingUtil.update(roomFacilityMapping, false);
	 }

	 public void remove(RoomFacilityMapping rfm) throws SystemException
	 { 
		 RoomFacilityMappingPK roomFacilityMappingPK = new RoomFacilityMappingPK();
		 roomFacilityMappingPK.setFacilitiesId(rfm.getFacilitiesId());
		 roomFacilityMappingPK.setRoomId(rfm.getRoomId());
		  try {
			RoomFacilityMappingUtil.remove(roomFacilityMappingPK);
		} catch (NoSuchRoomFacilityMappingException e) {
			 LOGGER.info(e.getMessage());
		}
	 }
	 private static final Log LOGGER = LogFactoryUtil.getLog(RoomFacilityMappingLocalServiceImpl.class);
}