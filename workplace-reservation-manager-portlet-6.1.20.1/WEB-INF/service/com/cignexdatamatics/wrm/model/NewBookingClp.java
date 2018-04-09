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

import com.cignexdatamatics.wrm.service.NewBookingLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
public class NewBookingClp extends BaseModelImpl<NewBooking>
	implements NewBooking {
	public NewBookingClp() {
	}

	public Class<?> getModelClass() {
		return NewBooking.class;
	}

	public String getModelClassName() {
		return NewBooking.class.getName();
	}

	public long getPrimaryKey() {
		return _bookingId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBookingId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_bookingId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookingId", getBookingId());
		attributes.put("meetingTitle", getMeetingTitle());
		attributes.put("meetingDesc", getMeetingDesc());
		attributes.put("hostId", getHostId());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}

		String meetingTitle = (String)attributes.get("meetingTitle");

		if (meetingTitle != null) {
			setMeetingTitle(meetingTitle);
		}

		String meetingDesc = (String)attributes.get("meetingDesc");

		if (meetingDesc != null) {
			setMeetingDesc(meetingDesc);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		String startTime = (String)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		String endTime = (String)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}
	}

	public long getBookingId() {
		return _bookingId;
	}

	public void setBookingId(long bookingId) {
		_bookingId = bookingId;
	}

	public String getMeetingTitle() {
		return _meetingTitle;
	}

	public void setMeetingTitle(String meetingTitle) {
		_meetingTitle = meetingTitle;
	}

	public String getMeetingDesc() {
		return _meetingDesc;
	}

	public void setMeetingDesc(String meetingDesc) {
		_meetingDesc = meetingDesc;
	}

	public long getHostId() {
		return _hostId;
	}

	public void setHostId(long hostId) {
		_hostId = hostId;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public String getStartTime() {
		return _startTime;
	}

	public void setStartTime(String startTime) {
		_startTime = startTime;
	}

	public String getEndTime() {
		return _endTime;
	}

	public void setEndTime(String endTime) {
		_endTime = endTime;
	}

	public BaseModel<?> getNewBookingRemoteModel() {
		return _newBookingRemoteModel;
	}

	public void setNewBookingRemoteModel(BaseModel<?> newBookingRemoteModel) {
		_newBookingRemoteModel = newBookingRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			NewBookingLocalServiceUtil.addNewBooking(this);
		}
		else {
			NewBookingLocalServiceUtil.updateNewBooking(this);
		}
	}

	@Override
	public NewBooking toEscapedModel() {
		return (NewBooking)Proxy.newProxyInstance(NewBooking.class.getClassLoader(),
			new Class[] { NewBooking.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NewBookingClp clone = new NewBookingClp();

		clone.setBookingId(getBookingId());
		clone.setMeetingTitle(getMeetingTitle());
		clone.setMeetingDesc(getMeetingDesc());
		clone.setHostId(getHostId());
		clone.setFromDate(getFromDate());
		clone.setToDate(getToDate());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());

		return clone;
	}

	public int compareTo(NewBooking newBooking) {
		long primaryKey = newBooking.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		NewBookingClp newBooking = null;

		try {
			newBooking = (NewBookingClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = newBooking.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{bookingId=");
		sb.append(getBookingId());
		sb.append(", meetingTitle=");
		sb.append(getMeetingTitle());
		sb.append(", meetingDesc=");
		sb.append(getMeetingDesc());
		sb.append(", hostId=");
		sb.append(getHostId());
		sb.append(", fromDate=");
		sb.append(getFromDate());
		sb.append(", toDate=");
		sb.append(getToDate());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.cignexdatamatics.wrm.model.NewBooking");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bookingId</column-name><column-value><![CDATA[");
		sb.append(getBookingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>meetingTitle</column-name><column-value><![CDATA[");
		sb.append(getMeetingTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>meetingDesc</column-name><column-value><![CDATA[");
		sb.append(getMeetingDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hostId</column-name><column-value><![CDATA[");
		sb.append(getHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromDate</column-name><column-value><![CDATA[");
		sb.append(getFromDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toDate</column-name><column-value><![CDATA[");
		sb.append(getToDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bookingId;
	private String _meetingTitle;
	private String _meetingDesc;
	private long _hostId;
	private Date _fromDate;
	private Date _toDate;
	private String _startTime;
	private String _endTime;
	private BaseModel<?> _newBookingRemoteModel;
}