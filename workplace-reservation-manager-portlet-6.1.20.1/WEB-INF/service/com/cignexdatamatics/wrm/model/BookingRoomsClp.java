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

import com.cignexdatamatics.wrm.service.BookingRoomsLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class BookingRoomsClp extends BaseModelImpl<BookingRooms>
	implements BookingRooms {
	public BookingRoomsClp() {
	}

	public Class<?> getModelClass() {
		return BookingRooms.class;
	}

	public String getModelClassName() {
		return BookingRooms.class.getName();
	}

	public long getPrimaryKey() {
		return _BRMappingId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBRMappingId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_BRMappingId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("BRMappingId", getBRMappingId());
		attributes.put("bookingId", getBookingId());
		attributes.put("roomId", getRoomId());
		attributes.put("bookingDate", getBookingDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long BRMappingId = (Long)attributes.get("BRMappingId");

		if (BRMappingId != null) {
			setBRMappingId(BRMappingId);
		}

		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}

		Long roomId = (Long)attributes.get("roomId");

		if (roomId != null) {
			setRoomId(roomId);
		}

		Date bookingDate = (Date)attributes.get("bookingDate");

		if (bookingDate != null) {
			setBookingDate(bookingDate);
		}
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

	public BaseModel<?> getBookingRoomsRemoteModel() {
		return _bookingRoomsRemoteModel;
	}

	public void setBookingRoomsRemoteModel(BaseModel<?> bookingRoomsRemoteModel) {
		_bookingRoomsRemoteModel = bookingRoomsRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			BookingRoomsLocalServiceUtil.addBookingRooms(this);
		}
		else {
			BookingRoomsLocalServiceUtil.updateBookingRooms(this);
		}
	}

	@Override
	public BookingRooms toEscapedModel() {
		return (BookingRooms)Proxy.newProxyInstance(BookingRooms.class.getClassLoader(),
			new Class[] { BookingRooms.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BookingRoomsClp clone = new BookingRoomsClp();

		clone.setBRMappingId(getBRMappingId());
		clone.setBookingId(getBookingId());
		clone.setRoomId(getRoomId());
		clone.setBookingDate(getBookingDate());

		return clone;
	}

	public int compareTo(BookingRooms bookingRooms) {
		int value = 0;

		value = DateUtil.compareTo(getBookingDate(),
				bookingRooms.getBookingDate());

		if (value != 0) {
			return value;
		}

		if (getBookingId() < bookingRooms.getBookingId()) {
			value = -1;
		}
		else if (getBookingId() > bookingRooms.getBookingId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BookingRoomsClp bookingRooms = null;

		try {
			bookingRooms = (BookingRoomsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = bookingRooms.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{BRMappingId=");
		sb.append(getBRMappingId());
		sb.append(", bookingId=");
		sb.append(getBookingId());
		sb.append(", roomId=");
		sb.append(getRoomId());
		sb.append(", bookingDate=");
		sb.append(getBookingDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.cignexdatamatics.wrm.model.BookingRooms");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>BRMappingId</column-name><column-value><![CDATA[");
		sb.append(getBRMappingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookingId</column-name><column-value><![CDATA[");
		sb.append(getBookingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roomId</column-name><column-value><![CDATA[");
		sb.append(getRoomId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookingDate</column-name><column-value><![CDATA[");
		sb.append(getBookingDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _BRMappingId;
	private long _bookingId;
	private long _roomId;
	private Date _bookingDate;
	private BaseModel<?> _bookingRoomsRemoteModel;
}