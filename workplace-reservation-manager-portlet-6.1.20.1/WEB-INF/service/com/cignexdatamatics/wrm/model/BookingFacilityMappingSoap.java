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

import com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class BookingFacilityMappingSoap implements Serializable {
	public static BookingFacilityMappingSoap toSoapModel(
		BookingFacilityMapping model) {
		BookingFacilityMappingSoap soapModel = new BookingFacilityMappingSoap();

		soapModel.setBookingId(model.getBookingId());
		soapModel.setFacilitiesId(model.getFacilitiesId());

		return soapModel;
	}

	public static BookingFacilityMappingSoap[] toSoapModels(
		BookingFacilityMapping[] models) {
		BookingFacilityMappingSoap[] soapModels = new BookingFacilityMappingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BookingFacilityMappingSoap[][] toSoapModels(
		BookingFacilityMapping[][] models) {
		BookingFacilityMappingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BookingFacilityMappingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BookingFacilityMappingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BookingFacilityMappingSoap[] toSoapModels(
		List<BookingFacilityMapping> models) {
		List<BookingFacilityMappingSoap> soapModels = new ArrayList<BookingFacilityMappingSoap>(models.size());

		for (BookingFacilityMapping model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BookingFacilityMappingSoap[soapModels.size()]);
	}

	public BookingFacilityMappingSoap() {
	}

	public BookingFacilityMappingPK getPrimaryKey() {
		return new BookingFacilityMappingPK(_bookingId, _facilitiesId);
	}

	public void setPrimaryKey(BookingFacilityMappingPK pk) {
		setBookingId(pk.bookingId);
		setFacilitiesId(pk.facilitiesId);
	}

	public long getBookingId() {
		return _bookingId;
	}

	public void setBookingId(long bookingId) {
		_bookingId = bookingId;
	}

	public long getFacilitiesId() {
		return _facilitiesId;
	}

	public void setFacilitiesId(long facilitiesId) {
		_facilitiesId = facilitiesId;
	}

	private long _bookingId;
	private long _facilitiesId;
}