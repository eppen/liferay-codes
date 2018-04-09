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

import com.cignexdatamatics.wrm.service.BookingFacilityMappingLocalServiceUtil;
import com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class BookingFacilityMappingClp extends BaseModelImpl<BookingFacilityMapping>
	implements BookingFacilityMapping {
	public BookingFacilityMappingClp() {
	}

	public Class<?> getModelClass() {
		return BookingFacilityMapping.class;
	}

	public String getModelClassName() {
		return BookingFacilityMapping.class.getName();
	}

	public BookingFacilityMappingPK getPrimaryKey() {
		return new BookingFacilityMappingPK(_bookingId, _facilitiesId);
	}

	public void setPrimaryKey(BookingFacilityMappingPK primaryKey) {
		setBookingId(primaryKey.bookingId);
		setFacilitiesId(primaryKey.facilitiesId);
	}

	public Serializable getPrimaryKeyObj() {
		return new BookingFacilityMappingPK(_bookingId, _facilitiesId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((BookingFacilityMappingPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookingId", getBookingId());
		attributes.put("facilitiesId", getFacilitiesId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}

		Long facilitiesId = (Long)attributes.get("facilitiesId");

		if (facilitiesId != null) {
			setFacilitiesId(facilitiesId);
		}
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

	public BaseModel<?> getBookingFacilityMappingRemoteModel() {
		return _bookingFacilityMappingRemoteModel;
	}

	public void setBookingFacilityMappingRemoteModel(
		BaseModel<?> bookingFacilityMappingRemoteModel) {
		_bookingFacilityMappingRemoteModel = bookingFacilityMappingRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			BookingFacilityMappingLocalServiceUtil.addBookingFacilityMapping(this);
		}
		else {
			BookingFacilityMappingLocalServiceUtil.updateBookingFacilityMapping(this);
		}
	}

	@Override
	public BookingFacilityMapping toEscapedModel() {
		return (BookingFacilityMapping)Proxy.newProxyInstance(BookingFacilityMapping.class.getClassLoader(),
			new Class[] { BookingFacilityMapping.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BookingFacilityMappingClp clone = new BookingFacilityMappingClp();

		clone.setBookingId(getBookingId());
		clone.setFacilitiesId(getFacilitiesId());

		return clone;
	}

	public int compareTo(BookingFacilityMapping bookingFacilityMapping) {
		BookingFacilityMappingPK primaryKey = bookingFacilityMapping.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BookingFacilityMappingClp bookingFacilityMapping = null;

		try {
			bookingFacilityMapping = (BookingFacilityMappingClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		BookingFacilityMappingPK primaryKey = bookingFacilityMapping.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{bookingId=");
		sb.append(getBookingId());
		sb.append(", facilitiesId=");
		sb.append(getFacilitiesId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.cignexdatamatics.wrm.model.BookingFacilityMapping");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bookingId</column-name><column-value><![CDATA[");
		sb.append(getBookingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facilitiesId</column-name><column-value><![CDATA[");
		sb.append(getFacilitiesId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bookingId;
	private long _facilitiesId;
	private BaseModel<?> _bookingFacilityMappingRemoteModel;
}