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
 * This class is a wrapper for {@link BookingFacilityMapping}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       BookingFacilityMapping
 * @generated
 */
public class BookingFacilityMappingWrapper implements BookingFacilityMapping,
	ModelWrapper<BookingFacilityMapping> {
	public BookingFacilityMappingWrapper(
		BookingFacilityMapping bookingFacilityMapping) {
		_bookingFacilityMapping = bookingFacilityMapping;
	}

	public Class<?> getModelClass() {
		return BookingFacilityMapping.class;
	}

	public String getModelClassName() {
		return BookingFacilityMapping.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookingId", getBookingId());
		attributes.put("facilitiesId", getFacilitiesId());

		return attributes;
	}

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

	/**
	* Returns the primary key of this booking facility mapping.
	*
	* @return the primary key of this booking facility mapping
	*/
	public com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK getPrimaryKey() {
		return _bookingFacilityMapping.getPrimaryKey();
	}

	/**
	* Sets the primary key of this booking facility mapping.
	*
	* @param primaryKey the primary key of this booking facility mapping
	*/
	public void setPrimaryKey(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK primaryKey) {
		_bookingFacilityMapping.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the booking ID of this booking facility mapping.
	*
	* @return the booking ID of this booking facility mapping
	*/
	public long getBookingId() {
		return _bookingFacilityMapping.getBookingId();
	}

	/**
	* Sets the booking ID of this booking facility mapping.
	*
	* @param bookingId the booking ID of this booking facility mapping
	*/
	public void setBookingId(long bookingId) {
		_bookingFacilityMapping.setBookingId(bookingId);
	}

	/**
	* Returns the facilities ID of this booking facility mapping.
	*
	* @return the facilities ID of this booking facility mapping
	*/
	public long getFacilitiesId() {
		return _bookingFacilityMapping.getFacilitiesId();
	}

	/**
	* Sets the facilities ID of this booking facility mapping.
	*
	* @param facilitiesId the facilities ID of this booking facility mapping
	*/
	public void setFacilitiesId(long facilitiesId) {
		_bookingFacilityMapping.setFacilitiesId(facilitiesId);
	}

	public boolean isNew() {
		return _bookingFacilityMapping.isNew();
	}

	public void setNew(boolean n) {
		_bookingFacilityMapping.setNew(n);
	}

	public boolean isCachedModel() {
		return _bookingFacilityMapping.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_bookingFacilityMapping.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _bookingFacilityMapping.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _bookingFacilityMapping.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bookingFacilityMapping.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bookingFacilityMapping.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bookingFacilityMapping.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BookingFacilityMappingWrapper((BookingFacilityMapping)_bookingFacilityMapping.clone());
	}

	public int compareTo(
		com.cignexdatamatics.wrm.model.BookingFacilityMapping bookingFacilityMapping) {
		return _bookingFacilityMapping.compareTo(bookingFacilityMapping);
	}

	@Override
	public int hashCode() {
		return _bookingFacilityMapping.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cignexdatamatics.wrm.model.BookingFacilityMapping> toCacheModel() {
		return _bookingFacilityMapping.toCacheModel();
	}

	public com.cignexdatamatics.wrm.model.BookingFacilityMapping toEscapedModel() {
		return new BookingFacilityMappingWrapper(_bookingFacilityMapping.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bookingFacilityMapping.toString();
	}

	public java.lang.String toXmlString() {
		return _bookingFacilityMapping.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bookingFacilityMapping.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public BookingFacilityMapping getWrappedBookingFacilityMapping() {
		return _bookingFacilityMapping;
	}

	public BookingFacilityMapping getWrappedModel() {
		return _bookingFacilityMapping;
	}

	public void resetOriginalValues() {
		_bookingFacilityMapping.resetOriginalValues();
	}

	private BookingFacilityMapping _bookingFacilityMapping;
}