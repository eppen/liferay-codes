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

import com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException;
import com.cignexdatamatics.wrm.model.BookingFacilityMapping;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.cignexdatamatics.wrm.model.RoomFacilityMapping;
import com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK;
import com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingUtil;
import com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK;
import com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingUtil;
import com.cignexdatamatics.wrm.service.base.BookingFacilityMappingLocalServiceBaseImpl;



import java.util.List;

public class BookingFacilityMappingLocalServiceImpl
	extends BookingFacilityMappingLocalServiceBaseImpl
{
	public List<BookingFacilityMapping> findAllMappingbyRoomId(long bookingId)throws SystemException
	 {
	     return (List<BookingFacilityMapping>) bookingFacilityMappingPersistence.findBybookingId(bookingId);
	 }
	 public List<BookingFacilityMapping> findAllMappingbyFacilitiesId(long facilitiesId)throws SystemException
	 {
	     return (List<BookingFacilityMapping>) bookingFacilityMappingPersistence.findByfacilitiesId(facilitiesId);
	 }
	 public RoomFacilityMapping addRoomFacilityMapping (RoomFacilityMapping validRoomFacilityMapping) throws SystemException
	 {
		 RoomFacilityMapping roomFacilityMapping=RoomFacilityMappingUtil.create(new RoomFacilityMappingPK(validRoomFacilityMapping.getRoomId(), validRoomFacilityMapping.getFacilitiesId()));
		 return RoomFacilityMappingUtil.update(roomFacilityMapping, false);
	 }

	 public void remove(BookingFacilityMapping bfm) throws SystemException
	 {
		 BookingFacilityMappingPK bookingFacilityMappingPK = new BookingFacilityMappingPK();
		 bookingFacilityMappingPK.setBookingId(bfm.getBookingId());
		 bookingFacilityMappingPK.setFacilitiesId(bfm.getFacilitiesId());
		 try {
			BookingFacilityMappingUtil.remove(bookingFacilityMappingPK);
		} catch (NoSuchBookingFacilityMappingException e) {
			 LOGGER.info(e.getMessage());
		}
	 }
	 private static final Log LOGGER = LogFactoryUtil.getLog(BookingFacilityMappingLocalServiceImpl.class);
}