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

import com.cignexdatamatics.wrm.NoSuchNewBookingException;
import com.cignexdatamatics.wrm.model.NewBooking;
import com.cignexdatamatics.wrm.service.persistence.NewBookingUtil;
import com.cignexdatamatics.wrm.service.base.NewBookingLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

public class NewBookingLocalServiceImpl extends NewBookingLocalServiceBaseImpl
{
	 public List<NewBooking> findAllBookedRoomByDateandTime(java.util.Date sd,java.util.Date ed,java.lang.String st,java.lang.String  et) throws SystemException
	 {

		 return (List<NewBooking>) newBookingPersistence.findByBookedRoomByDateandTime(sd,ed,st,et);
		
	 }
	 public NewBooking findAllBookingbyBookingId(long bookingId) throws SystemException, NoSuchNewBookingException
	 {
		 return newBookingPersistence.findByPrimaryKey(bookingId);
		  
	 }

	 public NewBooking addNewBooking(NewBooking validNewBooking) throws SystemException
	 {
		NewBooking newBooking=NewBookingUtil.create(CounterLocalServiceUtil.increment(NewBooking.class.getName()));
		newBooking.setMeetingTitle(validNewBooking.getMeetingTitle());
		newBooking.setMeetingDesc(validNewBooking.getMeetingDesc());
		newBooking.setHostId(validNewBooking.getHostId());
		newBooking.setFromDate(validNewBooking.getFromDate());
		newBooking.setToDate(validNewBooking.getToDate());
		newBooking.setStartTime(validNewBooking.getStartTime());
		newBooking.setEndTime(validNewBooking.getEndTime());
		return NewBookingUtil.update(newBooking, false);
	 }
	 public void remove(NewBooking newBooking) throws SystemException
	 {
		    try {
				NewBookingUtil.remove(newBooking.getBookingId());
			} catch (NoSuchNewBookingException e) {
				 LOGGER.info(e.getMessage());
			}
	 }
	 private static final Log LOGGER = LogFactoryUtil.getLog(NewBookingLocalServiceImpl.class);
}