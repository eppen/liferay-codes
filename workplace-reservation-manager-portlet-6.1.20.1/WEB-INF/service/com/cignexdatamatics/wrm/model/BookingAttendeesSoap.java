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

import com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class BookingAttendeesSoap implements Serializable {
	public static BookingAttendeesSoap toSoapModel(BookingAttendees model) {
		BookingAttendeesSoap soapModel = new BookingAttendeesSoap();

		soapModel.setAttendeesId(model.getAttendeesId());
		soapModel.setBookingId(model.getBookingId());

		return soapModel;
	}

	public static BookingAttendeesSoap[] toSoapModels(BookingAttendees[] models) {
		BookingAttendeesSoap[] soapModels = new BookingAttendeesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BookingAttendeesSoap[][] toSoapModels(
		BookingAttendees[][] models) {
		BookingAttendeesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BookingAttendeesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BookingAttendeesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BookingAttendeesSoap[] toSoapModels(
		List<BookingAttendees> models) {
		List<BookingAttendeesSoap> soapModels = new ArrayList<BookingAttendeesSoap>(models.size());

		for (BookingAttendees model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BookingAttendeesSoap[soapModels.size()]);
	}

	public BookingAttendeesSoap() {
	}

	public BookingAttendeesPK getPrimaryKey() {
		return new BookingAttendeesPK(_attendeesId, _bookingId);
	}

	public void setPrimaryKey(BookingAttendeesPK pk) {
		setAttendeesId(pk.attendeesId);
		setBookingId(pk.bookingId);
	}

	public long getAttendeesId() {
		return _attendeesId;
	}

	public void setAttendeesId(long attendeesId) {
		_attendeesId = attendeesId;
	}

	public long getBookingId() {
		return _bookingId;
	}

	public void setBookingId(long bookingId) {
		_bookingId = bookingId;
	}

	private long _attendeesId;
	private long _bookingId;
}