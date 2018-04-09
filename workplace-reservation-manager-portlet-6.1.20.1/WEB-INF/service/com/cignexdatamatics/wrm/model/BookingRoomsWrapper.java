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
 * This class is a wrapper for {@link BookingRooms}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       BookingRooms
 * @generated
 */
public class BookingRoomsWrapper implements BookingRooms,
	ModelWrapper<BookingRooms> {
	public BookingRoomsWrapper(BookingRooms bookingRooms) {
		_bookingRooms = bookingRooms;
	}

	public Class<?> getModelClass() {
		return BookingRooms.class;
	}

	public String getModelClassName() {
		return BookingRooms.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("BRMappingId", getBRMappingId());
		attributes.put("bookingId", getBookingId());
		attributes.put("roomId", getRoomId());
		attributes.put("bookingDate", getBookingDate());

		return attributes;
	}

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

	/**
	* Returns the primary key of this booking rooms.
	*
	* @return the primary key of this booking rooms
	*/
	public long getPrimaryKey() {
		return _bookingRooms.getPrimaryKey();
	}

	/**
	* Sets the primary key of this booking rooms.
	*
	* @param primaryKey the primary key of this booking rooms
	*/
	public void setPrimaryKey(long primaryKey) {
		_bookingRooms.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the b r mapping ID of this booking rooms.
	*
	* @return the b r mapping ID of this booking rooms
	*/
	public long getBRMappingId() {
		return _bookingRooms.getBRMappingId();
	}

	/**
	* Sets the b r mapping ID of this booking rooms.
	*
	* @param BRMappingId the b r mapping ID of this booking rooms
	*/
	public void setBRMappingId(long BRMappingId) {
		_bookingRooms.setBRMappingId(BRMappingId);
	}

	/**
	* Returns the booking ID of this booking rooms.
	*
	* @return the booking ID of this booking rooms
	*/
	public long getBookingId() {
		return _bookingRooms.getBookingId();
	}

	/**
	* Sets the booking ID of this booking rooms.
	*
	* @param bookingId the booking ID of this booking rooms
	*/
	public void setBookingId(long bookingId) {
		_bookingRooms.setBookingId(bookingId);
	}

	/**
	* Returns the room ID of this booking rooms.
	*
	* @return the room ID of this booking rooms
	*/
	public long getRoomId() {
		return _bookingRooms.getRoomId();
	}

	/**
	* Sets the room ID of this booking rooms.
	*
	* @param roomId the room ID of this booking rooms
	*/
	public void setRoomId(long roomId) {
		_bookingRooms.setRoomId(roomId);
	}

	/**
	* Returns the booking date of this booking rooms.
	*
	* @return the booking date of this booking rooms
	*/
	public java.util.Date getBookingDate() {
		return _bookingRooms.getBookingDate();
	}

	/**
	* Sets the booking date of this booking rooms.
	*
	* @param bookingDate the booking date of this booking rooms
	*/
	public void setBookingDate(java.util.Date bookingDate) {
		_bookingRooms.setBookingDate(bookingDate);
	}

	public boolean isNew() {
		return _bookingRooms.isNew();
	}

	public void setNew(boolean n) {
		_bookingRooms.setNew(n);
	}

	public boolean isCachedModel() {
		return _bookingRooms.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_bookingRooms.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _bookingRooms.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _bookingRooms.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bookingRooms.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bookingRooms.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bookingRooms.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BookingRoomsWrapper((BookingRooms)_bookingRooms.clone());
	}

	public int compareTo(
		com.cignexdatamatics.wrm.model.BookingRooms bookingRooms) {
		return _bookingRooms.compareTo(bookingRooms);
	}

	@Override
	public int hashCode() {
		return _bookingRooms.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cignexdatamatics.wrm.model.BookingRooms> toCacheModel() {
		return _bookingRooms.toCacheModel();
	}

	public com.cignexdatamatics.wrm.model.BookingRooms toEscapedModel() {
		return new BookingRoomsWrapper(_bookingRooms.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bookingRooms.toString();
	}

	public java.lang.String toXmlString() {
		return _bookingRooms.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bookingRooms.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public BookingRooms getWrappedBookingRooms() {
		return _bookingRooms;
	}

	public BookingRooms getWrappedModel() {
		return _bookingRooms;
	}

	public void resetOriginalValues() {
		_bookingRooms.resetOriginalValues();
	}

	private BookingRooms _bookingRooms;
}