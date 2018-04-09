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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BookingAttendees}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       BookingAttendees
 * @generated
 */
public class BookingAttendeesWrapper implements BookingAttendees,
	ModelWrapper<BookingAttendees> {
	public BookingAttendeesWrapper(BookingAttendees bookingAttendees) {
		_bookingAttendees = bookingAttendees;
	}

	public Class<?> getModelClass() {
		return BookingAttendees.class;
	}

	public String getModelClassName() {
		return BookingAttendees.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attendeesId", getAttendeesId());
		attributes.put("bookingId", getBookingId());

		return attributes;
	}

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

	/**
	* Returns the primary key of this booking attendees.
	*
	* @return the primary key of this booking attendees
	*/
	public com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK getPrimaryKey() {
		return _bookingAttendees.getPrimaryKey();
	}

	/**
	* Sets the primary key of this booking attendees.
	*
	* @param primaryKey the primary key of this booking attendees
	*/
	public void setPrimaryKey(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK primaryKey) {
		_bookingAttendees.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the attendees ID of this booking attendees.
	*
	* @return the attendees ID of this booking attendees
	*/
	public long getAttendeesId() {
		return _bookingAttendees.getAttendeesId();
	}

	/**
	* Sets the attendees ID of this booking attendees.
	*
	* @param attendeesId the attendees ID of this booking attendees
	*/
	public void setAttendeesId(long attendeesId) {
		_bookingAttendees.setAttendeesId(attendeesId);
	}

	/**
	* Returns the booking ID of this booking attendees.
	*
	* @return the booking ID of this booking attendees
	*/
	public long getBookingId() {
		return _bookingAttendees.getBookingId();
	}

	/**
	* Sets the booking ID of this booking attendees.
	*
	* @param bookingId the booking ID of this booking attendees
	*/
	public void setBookingId(long bookingId) {
		_bookingAttendees.setBookingId(bookingId);
	}

	public boolean isNew() {
		return _bookingAttendees.isNew();
	}

	public void setNew(boolean n) {
		_bookingAttendees.setNew(n);
	}

	public boolean isCachedModel() {
		return _bookingAttendees.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_bookingAttendees.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _bookingAttendees.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _bookingAttendees.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bookingAttendees.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bookingAttendees.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bookingAttendees.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BookingAttendeesWrapper((BookingAttendees)_bookingAttendees.clone());
	}

	public int compareTo(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees) {
		return _bookingAttendees.compareTo(bookingAttendees);
	}

	@Override
	public int hashCode() {
		return _bookingAttendees.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cignexdatamatics.wrm.model.BookingAttendees> toCacheModel() {
		return _bookingAttendees.toCacheModel();
	}

	public com.cignexdatamatics.wrm.model.BookingAttendees toEscapedModel() {
		return new BookingAttendeesWrapper(_bookingAttendees.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bookingAttendees.toString();
	}

	public java.lang.String toXmlString() {
		return _bookingAttendees.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bookingAttendees.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public BookingAttendees getWrappedBookingAttendees() {
		return _bookingAttendees;
	}

	public BookingAttendees getWrappedModel() {
		return _bookingAttendees;
	}

	public void resetOriginalValues() {
		_bookingAttendees.resetOriginalValues();
	}

	private BookingAttendees _bookingAttendees;
}