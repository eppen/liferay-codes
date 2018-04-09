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

package com.cignexdatamatics.wrm.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class BookingRoomsSoap implements Serializable {
	public static BookingRoomsSoap toSoapModel(BookingRooms model) {
		BookingRoomsSoap soapModel = new BookingRoomsSoap();

		soapModel.setBRMappingId(model.getBRMappingId());
		soapModel.setBookingId(model.getBookingId());
		soapModel.setRoomId(model.getRoomId());
		soapModel.setBookingDate(model.getBookingDate());

		return soapModel;
	}

	public static BookingRoomsSoap[] toSoapModels(BookingRooms[] models) {
		BookingRoomsSoap[] soapModels = new BookingRoomsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BookingRoomsSoap[][] toSoapModels(BookingRooms[][] models) {
		BookingRoomsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BookingRoomsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BookingRoomsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BookingRoomsSoap[] toSoapModels(List<BookingRooms> models) {
		List<BookingRoomsSoap> soapModels = new ArrayList<BookingRoomsSoap>(models.size());

		for (BookingRooms model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BookingRoomsSoap[soapModels.size()]);
	}

	public BookingRoomsSoap() {
	}

	public long getPrimaryKey() {
		return _BRMappingId;
	}

	public void setPrimaryKey(long pk) {
		setBRMappingId(pk);
	}

	public long getBRMappingId() {
		return _BRMappingId;
	}

	public void setBRMappingId(long BRMappingId) {
		_BRMappingId = BRMappingId;
	}

	public long getBookingId() {
		return _bookingId;
	}

	public void setBookingId(long bookingId) {
		_bookingId = bookingId;
	}

	public long getRoomId() {
		return _roomId;
	}

	public void setRoomId(long roomId) {
		_roomId = roomId;
	}

	public Date getBookingDate() {
		return _bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		_bookingDate = bookingDate;
	}

	private long _BRMappingId;
	private long _bookingId;
	private long _roomId;
	private Date _bookingDate;
}