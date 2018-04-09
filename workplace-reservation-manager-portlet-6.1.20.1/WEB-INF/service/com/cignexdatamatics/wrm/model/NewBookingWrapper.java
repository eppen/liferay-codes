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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NewBooking}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       NewBooking
 * @generated
 */
public class NewBookingWrapper implements NewBooking, ModelWrapper<NewBooking> {
	public NewBookingWrapper(NewBooking newBooking) {
		_newBooking = newBooking;
	}

	public Class<?> getModelClass() {
		return NewBooking.class;
	}

	public String getModelClassName() {
		return NewBooking.class.getName();
	}

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

	/**
	* Returns the primary key of this new booking.
	*
	* @return the primary key of this new booking
	*/
	public long getPrimaryKey() {
		return _newBooking.getPrimaryKey();
	}

	/**
	* Sets the primary key of this new booking.
	*
	* @param primaryKey the primary key of this new booking
	*/
	public void setPrimaryKey(long primaryKey) {
		_newBooking.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the booking ID of this new booking.
	*
	* @return the booking ID of this new booking
	*/
	public long getBookingId() {
		return _newBooking.getBookingId();
	}

	/**
	* Sets the booking ID of this new booking.
	*
	* @param bookingId the booking ID of this new booking
	*/
	public void setBookingId(long bookingId) {
		_newBooking.setBookingId(bookingId);
	}

	/**
	* Returns the meeting title of this new booking.
	*
	* @return the meeting title of this new booking
	*/
	public java.lang.String getMeetingTitle() {
		return _newBooking.getMeetingTitle();
	}

	/**
	* Sets the meeting title of this new booking.
	*
	* @param meetingTitle the meeting title of this new booking
	*/
	public void setMeetingTitle(java.lang.String meetingTitle) {
		_newBooking.setMeetingTitle(meetingTitle);
	}

	/**
	* Returns the meeting desc of this new booking.
	*
	* @return the meeting desc of this new booking
	*/
	public java.lang.String getMeetingDesc() {
		return _newBooking.getMeetingDesc();
	}

	/**
	* Sets the meeting desc of this new booking.
	*
	* @param meetingDesc the meeting desc of this new booking
	*/
	public void setMeetingDesc(java.lang.String meetingDesc) {
		_newBooking.setMeetingDesc(meetingDesc);
	}

	/**
	* Returns the host ID of this new booking.
	*
	* @return the host ID of this new booking
	*/
	public long getHostId() {
		return _newBooking.getHostId();
	}

	/**
	* Sets the host ID of this new booking.
	*
	* @param hostId the host ID of this new booking
	*/
	public void setHostId(long hostId) {
		_newBooking.setHostId(hostId);
	}

	/**
	* Returns the from date of this new booking.
	*
	* @return the from date of this new booking
	*/
	public java.util.Date getFromDate() {
		return _newBooking.getFromDate();
	}

	/**
	* Sets the from date of this new booking.
	*
	* @param fromDate the from date of this new booking
	*/
	public void setFromDate(java.util.Date fromDate) {
		_newBooking.setFromDate(fromDate);
	}

	/**
	* Returns the to date of this new booking.
	*
	* @return the to date of this new booking
	*/
	public java.util.Date getToDate() {
		return _newBooking.getToDate();
	}

	/**
	* Sets the to date of this new booking.
	*
	* @param toDate the to date of this new booking
	*/
	public void setToDate(java.util.Date toDate) {
		_newBooking.setToDate(toDate);
	}

	/**
	* Returns the start time of this new booking.
	*
	* @return the start time of this new booking
	*/
	public java.lang.String getStartTime() {
		return _newBooking.getStartTime();
	}

	/**
	* Sets the start time of this new booking.
	*
	* @param startTime the start time of this new booking
	*/
	public void setStartTime(java.lang.String startTime) {
		_newBooking.setStartTime(startTime);
	}

	/**
	* Returns the end time of this new booking.
	*
	* @return the end time of this new booking
	*/
	public java.lang.String getEndTime() {
		return _newBooking.getEndTime();
	}

	/**
	* Sets the end time of this new booking.
	*
	* @param endTime the end time of this new booking
	*/
	public void setEndTime(java.lang.String endTime) {
		_newBooking.setEndTime(endTime);
	}

	public boolean isNew() {
		return _newBooking.isNew();
	}

	public void setNew(boolean n) {
		_newBooking.setNew(n);
	}

	public boolean isCachedModel() {
		return _newBooking.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_newBooking.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _newBooking.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _newBooking.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_newBooking.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _newBooking.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_newBooking.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NewBookingWrapper((NewBooking)_newBooking.clone());
	}

	public int compareTo(com.cignexdatamatics.wrm.model.NewBooking newBooking) {
		return _newBooking.compareTo(newBooking);
	}

	@Override
	public int hashCode() {
		return _newBooking.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cignexdatamatics.wrm.model.NewBooking> toCacheModel() {
		return _newBooking.toCacheModel();
	}

	public com.cignexdatamatics.wrm.model.NewBooking toEscapedModel() {
		return new NewBookingWrapper(_newBooking.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _newBooking.toString();
	}

	public java.lang.String toXmlString() {
		return _newBooking.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_newBooking.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public NewBooking getWrappedNewBooking() {
		return _newBooking;
	}

	public NewBooking getWrappedModel() {
		return _newBooking;
	}

	public void resetOriginalValues() {
		_newBooking.resetOriginalValues();
	}

	private NewBooking _newBooking;
}