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
 * This class is used by SOAP remote services, specifically {@link com.cignexdatamatics.wrm.service.http.NewBookingServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.cignexdatamatics.wrm.service.http.NewBookingServiceSoap
 * @generated
 */
public class NewBookingSoap implements Serializable {
	public static NewBookingSoap toSoapModel(NewBooking model) {
		NewBookingSoap soapModel = new NewBookingSoap();

		soapModel.setBookingId(model.getBookingId());
		soapModel.setMeetingTitle(model.getMeetingTitle());
		soapModel.setMeetingDesc(model.getMeetingDesc());
		soapModel.setHostId(model.getHostId());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());

		return soapModel;
	}

	public static NewBookingSoap[] toSoapModels(NewBooking[] models) {
		NewBookingSoap[] soapModels = new NewBookingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NewBookingSoap[][] toSoapModels(NewBooking[][] models) {
		NewBookingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NewBookingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NewBookingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NewBookingSoap[] toSoapModels(List<NewBooking> models) {
		List<NewBookingSoap> soapModels = new ArrayList<NewBookingSoap>(models.size());

		for (NewBooking model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NewBookingSoap[soapModels.size()]);
	}

	public NewBookingSoap() {
	}

	public long getPrimaryKey() {
		return _bookingId;
	}

	public void setPrimaryKey(long pk) {
		setBookingId(pk);
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

	private long _bookingId;
	private String _meetingTitle;
	private String _meetingDesc;
	private long _hostId;
	private Date _fromDate;
	private Date _toDate;
	private String _startTime;
	private String _endTime;
}