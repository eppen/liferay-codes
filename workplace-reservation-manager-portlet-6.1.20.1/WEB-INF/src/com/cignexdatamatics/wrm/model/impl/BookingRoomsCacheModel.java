/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.cignexdatamatics.wrm.model.impl;

import com.cignexdatamatics.wrm.model.BookingRooms;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing BookingRooms in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BookingRooms
 * @generated
 */
public class BookingRoomsCacheModel implements CacheModel<BookingRooms>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{BRMappingId=");
		sb.append(BRMappingId);
		sb.append(", bookingId=");
		sb.append(bookingId);
		sb.append(", roomId=");
		sb.append(roomId);
		sb.append(", bookingDate=");
		sb.append(bookingDate);
		sb.append("}");

		return sb.toString();
	}

	public BookingRooms toEntityModel() {
		BookingRoomsImpl bookingRoomsImpl = new BookingRoomsImpl();

		bookingRoomsImpl.setBRMappingId(BRMappingId);
		bookingRoomsImpl.setBookingId(bookingId);
		bookingRoomsImpl.setRoomId(roomId);

		if (bookingDate == Long.MIN_VALUE) {
			bookingRoomsImpl.setBookingDate(null);
		}
		else {
			bookingRoomsImpl.setBookingDate(new Date(bookingDate));
		}

		bookingRoomsImpl.resetOriginalValues();

		return bookingRoomsImpl;
	}

	public long BRMappingId;
	public long bookingId;
	public long roomId;
	public long bookingDate;
}