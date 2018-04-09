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
import java.util.Date;
import java.util.List;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.cignexdatamatics.wrm.model.BookingRooms;
import com.cignexdatamatics.wrm.service.persistence.BookingRoomsUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;

import com.cignexdatamatics.wrm.NoSuchBookingRoomsException;
import com.cignexdatamatics.wrm.service.base.BookingRoomsLocalServiceBaseImpl;


public class BookingRoomsLocalServiceImpl
	extends BookingRoomsLocalServiceBaseImpl
{
	 public List<BookingRooms> findAllBookingRooms ()throws SystemException,NoSuchBookingRoomsException
	 {
		return (List<BookingRooms>)bookingRoomsPersistence.findAll();
	 }
	 public List<BookingRooms> findBookingRoomsByBookingDate (java.util.Date bookingDate)throws SystemException,NoSuchBookingRoomsException
	 {
		return (List<BookingRooms>)bookingRoomsPersistence.findByBookingDate(bookingDate);
	 }
	
	public List<BookingRooms> findMappingByBookingId(long bookingId) throws SystemException,NoSuchBookingRoomsException
	 {
		return (List<BookingRooms>)bookingRoomsPersistence.findByBookingId(bookingId);
	 }

	 public BookingRooms findBookingById(long brmappingId) throws SystemException,NoSuchBookingRoomsException
	 {
	    return bookingRoomsPersistence.findByPrimaryKey(brmappingId);
	 }

	 public List<BookingRooms> findAllBookingByRoomId(long roomId) throws SystemException,NoSuchBookingRoomsException
	 {
		 return bookingRoomsPersistence.findByRoomId(roomId);
	 }
	 
	 public List<BookingRooms> findAllBookingByRoomIdAndBookingDate(long roomId, Date bookingDate) throws SystemException,NoSuchBookingRoomsException
	 {	  
		return bookingRoomsPersistence.findByRoomIdAndBookingDate(roomId, bookingDate);
	 }
	 
	 public BookingRooms addBookingRooms(BookingRooms validBookingRooms) throws SystemException 
	 {
		BookingRooms bookingRooms=BookingRoomsUtil.create(CounterLocalServiceUtil.increment(BookingRooms.class.getName()));
		bookingRooms.setBookingId(validBookingRooms.getBookingId());
		bookingRooms.setBookingDate(validBookingRooms.getBookingDate());
		bookingRooms.setRoomId(validBookingRooms.getRoomId());
		return BookingRoomsUtil.update(bookingRooms, false);
	 }
	 public void remove(BookingRooms br) throws SystemException
	 {
		try {
			BookingRoomsUtil.remove(br.getBRMappingId());
		} catch (NoSuchBookingRoomsException e) {
			 LOGGER.info(e.getMessage());
		}
	 }
	 private static final Log LOGGER = LogFactoryUtil.getLog(BookingRoomsLocalServiceImpl.class);
	
}