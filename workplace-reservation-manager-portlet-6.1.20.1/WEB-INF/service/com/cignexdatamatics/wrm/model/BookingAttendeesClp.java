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

import com.cignexdatamatics.wrm.service.BookingAttendeesLocalServiceUtil;
import com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK;

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
public class BookingAttendeesClp extends BaseModelImpl<BookingAttendees>
	implements BookingAttendees {
	public BookingAttendeesClp() {
	}

	public Class<?> getModelClass() {
		return BookingAttendees.class;
	}

	public String getModelClassName() {
		return BookingAttendees.class.getName();
	}

	public BookingAttendeesPK getPrimaryKey() {
		return new BookingAttendeesPK(_attendeesId, _bookingId);
	}

	public void setPrimaryKey(BookingAttendeesPK primaryKey) {
		setAttendeesId(primaryKey.attendeesId);
		setBookingId(primaryKey.bookingId);
	}

	public Serializable getPrimaryKeyObj() {
		return new BookingAttendeesPK(_attendeesId, _bookingId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((BookingAttendeesPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attendeesId", getAttendeesId());
		attributes.put("bookingId", getBookingId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attendeesId = (Long)attributes.get("attendeesId");

		if (attendeesId != null) {
			setAttendeesId(attendeesId);
		}

		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}
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

	public BaseModel<?> getBookingAttendeesRemoteModel() {
		return _bookingAttendeesRemoteModel;
	}

	public void setBookingAttendeesRemoteModel(
		BaseModel<?> bookingAttendeesRemoteModel) {
		_bookingAttendeesRemoteModel = bookingAttendeesRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			BookingAttendeesLocalServiceUtil.addBookingAttendees(this);
		}
		else {
			BookingAttendeesLocalServiceUtil.updateBookingAttendees(this);
		}
	}

	@Override
	public BookingAttendees toEscapedModel() {
		return (BookingAttendees)Proxy.newProxyInstance(BookingAttendees.class.getClassLoader(),
			new Class[] { BookingAttendees.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BookingAttendeesClp clone = new BookingAttendeesClp();

		clone.setAttendeesId(getAttendeesId());
		clone.setBookingId(getBookingId());

		return clone;
	}

	public int compareTo(BookingAttendees bookingAttendees) {
		BookingAttendeesPK primaryKey = bookingAttendees.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BookingAttendeesClp bookingAttendees = null;

		try {
			bookingAttendees = (BookingAttendeesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		BookingAttendeesPK primaryKey = bookingAttendees.getPrimaryKey();

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

		sb.append("{attendeesId=");
		sb.append(getAttendeesId());
		sb.append(", bookingId=");
		sb.append(getBookingId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.cignexdatamatics.wrm.model.BookingAttendees");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>attendeesId</column-name><column-value><![CDATA[");
		sb.append(getAttendeesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookingId</column-name><column-value><![CDATA[");
		sb.append(getBookingId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _attendeesId;
	private long _bookingId;
	private BaseModel<?> _bookingAttendeesRemoteModel;
}