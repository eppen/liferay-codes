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
 * This class is a wrapper for {@link RoomFacilityMapping}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       RoomFacilityMapping
 * @generated
 */
public class RoomFacilityMappingWrapper implements RoomFacilityMapping,
	ModelWrapper<RoomFacilityMapping> {
	public RoomFacilityMappingWrapper(RoomFacilityMapping roomFacilityMapping) {
		_roomFacilityMapping = roomFacilityMapping;
	}

	public Class<?> getModelClass() {
		return RoomFacilityMapping.class;
	}

	public String getModelClassName() {
		return RoomFacilityMapping.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roomId", getRoomId());
		attributes.put("facilitiesId", getFacilitiesId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long roomId = (Long)attributes.get("roomId");

		if (roomId != null) {
			setRoomId(roomId);
		}

		Long facilitiesId = (Long)attributes.get("facilitiesId");

		if (facilitiesId != null) {
			setFacilitiesId(facilitiesId);
		}
	}

	/**
	* Returns the primary key of this room facility mapping.
	*
	* @return the primary key of this room facility mapping
	*/
	public com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK getPrimaryKey() {
		return _roomFacilityMapping.getPrimaryKey();
	}

	/**
	* Sets the primary key of this room facility mapping.
	*
	* @param primaryKey the primary key of this room facility mapping
	*/
	public void setPrimaryKey(
		com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK primaryKey) {
		_roomFacilityMapping.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the room ID of this room facility mapping.
	*
	* @return the room ID of this room facility mapping
	*/
	public long getRoomId() {
		return _roomFacilityMapping.getRoomId();
	}

	/**
	* Sets the room ID of this room facility mapping.
	*
	* @param roomId the room ID of this room facility mapping
	*/
	public void setRoomId(long roomId) {
		_roomFacilityMapping.setRoomId(roomId);
	}

	/**
	* Returns the facilities ID of this room facility mapping.
	*
	* @return the facilities ID of this room facility mapping
	*/
	public long getFacilitiesId() {
		return _roomFacilityMapping.getFacilitiesId();
	}

	/**
	* Sets the facilities ID of this room facility mapping.
	*
	* @param facilitiesId the facilities ID of this room facility mapping
	*/
	public void setFacilitiesId(long facilitiesId) {
		_roomFacilityMapping.setFacilitiesId(facilitiesId);
	}

	public boolean isNew() {
		return _roomFacilityMapping.isNew();
	}

	public void setNew(boolean n) {
		_roomFacilityMapping.setNew(n);
	}

	public boolean isCachedModel() {
		return _roomFacilityMapping.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_roomFacilityMapping.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _roomFacilityMapping.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _roomFacilityMapping.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_roomFacilityMapping.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _roomFacilityMapping.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_roomFacilityMapping.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RoomFacilityMappingWrapper((RoomFacilityMapping)_roomFacilityMapping.clone());
	}

	public int compareTo(
		com.cignexdatamatics.wrm.model.RoomFacilityMapping roomFacilityMapping) {
		return _roomFacilityMapping.compareTo(roomFacilityMapping);
	}

	@Override
	public int hashCode() {
		return _roomFacilityMapping.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cignexdatamatics.wrm.model.RoomFacilityMapping> toCacheModel() {
		return _roomFacilityMapping.toCacheModel();
	}

	public com.cignexdatamatics.wrm.model.RoomFacilityMapping toEscapedModel() {
		return new RoomFacilityMappingWrapper(_roomFacilityMapping.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _roomFacilityMapping.toString();
	}

	public java.lang.String toXmlString() {
		return _roomFacilityMapping.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_roomFacilityMapping.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public RoomFacilityMapping getWrappedRoomFacilityMapping() {
		return _roomFacilityMapping;
	}

	public RoomFacilityMapping getWrappedModel() {
		return _roomFacilityMapping;
	}

	public void resetOriginalValues() {
		_roomFacilityMapping.resetOriginalValues();
	}

	private RoomFacilityMapping _roomFacilityMapping;
}