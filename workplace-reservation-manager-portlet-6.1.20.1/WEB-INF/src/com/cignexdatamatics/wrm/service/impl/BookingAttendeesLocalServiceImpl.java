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

import java.util.List;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.cignexdatamatics.wrm.NoSuchBookingAttendeesException;
import com.cignexdatamatics.wrm.model.BookingAttendees;
import com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK;
import com.cignexdatamatics.wrm.service.persistence.BookingAttendeesUtil;
import com.cignexdatamatics.wrm.service.base.BookingAttendeesLocalServiceBaseImpl;


public class BookingAttendeesLocalServiceImpl
	extends BookingAttendeesLocalServiceBaseImpl 
{
	

	 public  List<BookingAttendees> findAllbyBookingId(long bookingId) throws SystemException
	 {
		return BookingAttendeesUtil.findByBookingId(bookingId);
	 }
	 public  List<BookingAttendees> findAllbyAttendeesId(long attendeesId) throws SystemException
	 {
		 return BookingAttendeesUtil.findByAttendeesId(attendeesId);
	 }
	
	 public BookingAttendees addBookingAttendees(BookingAttendees validBookingAttendees) throws SystemException
	 {
		 BookingAttendees bookingAttendees=BookingAttendeesUtil.create(new BookingAttendeesPK(validBookingAttendees.getAttendeesId(), validBookingAttendees.getBookingId()));
		 return BookingAttendeesUtil.update(bookingAttendees, false);
	 }
	 public void remove(BookingAttendees ba) throws SystemException
	 {
		 BookingAttendeesPK bookingAttendeesPK = new BookingAttendeesPK();
		 bookingAttendeesPK.setAttendeesId(ba.getAttendeesId());
		 bookingAttendeesPK.setBookingId(ba.getBookingId());
		 try {
			BookingAttendeesUtil.remove(bookingAttendeesPK);
		} catch (NoSuchBookingAttendeesException e) {
			 LOGGER.info(e.getMessage());
		}
	 }
	 private static final Log LOGGER = LogFactoryUtil.getLog(BookingAttendeesLocalServiceImpl.class);
}