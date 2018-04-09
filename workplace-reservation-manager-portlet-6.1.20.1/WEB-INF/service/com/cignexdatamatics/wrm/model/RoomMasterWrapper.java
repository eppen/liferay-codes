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
 * This class is a wrapper for {@link RoomMaster}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       RoomMaster
 * @generated
 */
public class RoomMasterWrapper implements RoomMaster, ModelWrapper<RoomMaster> {
	public RoomMasterWrapper(RoomMaster roomMaster) {
		_roomMaster = roomMaster;
	}

	public Class<?> getModelClass() {
		return RoomMaster.class;
	}

	public String getModelClassName() {
		return RoomMaster.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roomId", getRoomId());
		attributes.put("cityId", getCityId());
		attributes.put("locationId", getLocationId());
		attributes.put("floorId", getFloorId());
		attributes.put("roomName", getRoomName());
		attributes.put("capacity", getCapacity());
		attributes.put("extension", getExtension());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long roomId = (Long)attributes.get("roomId");

		if (roomId != null) {
			setRoomId(roomId);
		}

		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Long floorId = (Long)attributes.get("floorId");

		if (floorId != null) {
			setFloorId(floorId);
		}

		String roomName = (String)attributes.get("roomName");

		if (roomName != null) {
			setRoomName(roomName);
		}

		Long capacity = (Long)attributes.get("capacity");

		if (capacity != null) {
			setCapacity(capacity);
		}

		Long extension = (Long)attributes.get("extension");

		if (extension != null) {
			setExtension(extension);
		}
	}

	/**
	* Returns the primary key of this room master.
	*
	* @return the primary key of this room master
	*/
	public long getPrimaryKey() {
		return _roomMaster.getPrimaryKey();
	}

	/**
	* Sets the primary key of this room master.
	*
	* @param primaryKey the primary key of this room master
	*/
	public void setPrimaryKey(long primaryKey) {
		_roomMaster.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the room ID of this room master.
	*
	* @return the room ID of this room master
	*/
	public long getRoomId() {
		return _roomMaster.getRoomId();
	}

	/**
	* Sets the room ID of this room master.
	*
	* @param roomId the room ID of this room master
	*/
	public void setRoomId(long roomId) {
		_roomMaster.setRoomId(roomId);
	}

	/**
	* Returns the city ID of this room master.
	*
	* @return the city ID of this room master
	*/
	public long getCityId() {
		return _roomMaster.getCityId();
	}

	/**
	* Sets the city ID of this room master.
	*
	* @param cityId the city ID of this room master
	*/
	public void setCityId(long cityId) {
		_roomMaster.setCityId(cityId);
	}

	/**
	* Returns the location ID of this room master.
	*
	* @return the location ID of this room master
	*/
	public long getLocationId() {
		return _roomMaster.getLocationId();
	}

	/**
	* Sets the location ID of this room master.
	*
	* @param locationId the location ID of this room master
	*/
	public void setLocationId(long locationId) {
		_roomMaster.setLocationId(locationId);
	}

	/**
	* Returns the floor ID of this room master.
	*
	* @return the floor ID of this room master
	*/
	public long getFloorId() {
		return _roomMaster.getFloorId();
	}

	/**
	* Sets the floor ID of this room master.
	*
	* @param floorId the floor ID of this room master
	*/
	public void setFloorId(long floorId) {
		_roomMaster.setFloorId(floorId);
	}

	/**
	* Returns the room name of this room master.
	*
	* @return the room name of this room master
	*/
	public java.lang.String getRoomName() {
		return _roomMaster.getRoomName();
	}

	/**
	* Sets the room name of this room master.
	*
	* @param roomName the room name of this room master
	*/
	public void setRoomName(java.lang.String roomName) {
		_roomMaster.setRoomName(roomName);
	}

	/**
	* Returns the capacity of this room master.
	*
	* @return the capacity of this room master
	*/
	public long getCapacity() {
		return _roomMaster.getCapacity();
	}

	/**
	* Sets the capacity of this room master.
	*
	* @param capacity the capacity of this room master
	*/
	public void setCapacity(long capacity) {
		_roomMaster.setCapacity(capacity);
	}

	/**
	* Returns the extension of this room master.
	*
	* @return the extension of this room master
	*/
	public long getExtension() {
		return _roomMaster.getExtension();
	}

	/**
	* Sets the extension of this room master.
	*
	* @param extension the extension of this room master
	*/
	public void setExtension(long extension) {
		_roomMaster.setExtension(extension);
	}

	public boolean isNew() {
		return _roomMaster.isNew();
	}

	public void setNew(boolean n) {
		_roomMaster.setNew(n);
	}

	public boolean isCachedModel() {
		return _roomMaster.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_roomMaster.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _roomMaster.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _roomMaster.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_roomMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _roomMaster.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_roomMaster.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RoomMasterWrapper((RoomMaster)_roomMaster.clone());
	}

	public int compareTo(com.cignexdatamatics.wrm.model.RoomMaster roomMaster) {
		return _roomMaster.compareTo(roomMaster);
	}

	@Override
	public int hashCode() {
		return _roomMaster.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cignexdatamatics.wrm.model.RoomMaster> toCacheModel() {
		return _roomMaster.toCacheModel();
	}

	public com.cignexdatamatics.wrm.model.RoomMaster toEscapedModel() {
		return new RoomMasterWrapper(_roomMaster.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _roomMaster.toString();
	}

	public java.lang.String toXmlString() {
		return _roomMaster.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_roomMaster.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public RoomMaster getWrappedRoomMaster() {
		return _roomMaster;
	}

	public RoomMaster getWrappedModel() {
		return _roomMaster;
	}

	public void resetOriginalValues() {
		_roomMaster.resetOriginalValues();
	}

	private RoomMaster _roomMaster;
}