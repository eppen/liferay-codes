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

import com.cignexdatamatics.wrm.service.RoomMasterLocalServiceUtil;

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
public class RoomMasterClp extends BaseModelImpl<RoomMaster>
	implements RoomMaster {
	public RoomMasterClp() {
	}

	public Class<?> getModelClass() {
		return RoomMaster.class;
	}

	public String getModelClassName() {
		return RoomMaster.class.getName();
	}

	public long getPrimaryKey() {
		return _roomId;
	}

	public void setPrimaryKey(long primaryKey) {
		setRoomId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_roomId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getRoomId() {
		return _roomId;
	}

	public void setRoomId(long roomId) {
		_roomId = roomId;
	}

	public long getCityId() {
		return _cityId;
	}

	public void setCityId(long cityId) {
		_cityId = cityId;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public long getFloorId() {
		return _floorId;
	}

	public void setFloorId(long floorId) {
		_floorId = floorId;
	}

	public String getRoomName() {
		return _roomName;
	}

	public void setRoomName(String roomName) {
		_roomName = roomName;
	}

	public long getCapacity() {
		return _capacity;
	}

	public void setCapacity(long capacity) {
		_capacity = capacity;
	}

	public long getExtension() {
		return _extension;
	}

	public void setExtension(long extension) {
		_extension = extension;
	}

	public BaseModel<?> getRoomMasterRemoteModel() {
		return _roomMasterRemoteModel;
	}

	public void setRoomMasterRemoteModel(BaseModel<?> roomMasterRemoteModel) {
		_roomMasterRemoteModel = roomMasterRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			RoomMasterLocalServiceUtil.addRoomMaster(this);
		}
		else {
			RoomMasterLocalServiceUtil.updateRoomMaster(this);
		}
	}

	@Override
	public RoomMaster toEscapedModel() {
		return (RoomMaster)Proxy.newProxyInstance(RoomMaster.class.getClassLoader(),
			new Class[] { RoomMaster.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RoomMasterClp clone = new RoomMasterClp();

		clone.setRoomId(getRoomId());
		clone.setCityId(getCityId());
		clone.setLocationId(getLocationId());
		clone.setFloorId(getFloorId());
		clone.setRoomName(getRoomName());
		clone.setCapacity(getCapacity());
		clone.setExtension(getExtension());

		return clone;
	}

	public int compareTo(RoomMaster roomMaster) {
		int value = 0;

		if (getCityId() < roomMaster.getCityId()) {
			value = -1;
		}
		else if (getCityId() > roomMaster.getCityId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getLocationId() < roomMaster.getLocationId()) {
			value = -1;
		}
		else if (getLocationId() > roomMaster.getLocationId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getFloorId() < roomMaster.getFloorId()) {
			value = -1;
		}
		else if (getFloorId() > roomMaster.getFloorId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getRoomName().toLowerCase()
					.compareTo(roomMaster.getRoomName().toLowerCase());

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

		RoomMasterClp roomMaster = null;

		try {
			roomMaster = (RoomMasterClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = roomMaster.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{roomId=");
		sb.append(getRoomId());
		sb.append(", cityId=");
		sb.append(getCityId());
		sb.append(", locationId=");
		sb.append(getLocationId());
		sb.append(", floorId=");
		sb.append(getFloorId());
		sb.append(", roomName=");
		sb.append(getRoomName());
		sb.append(", capacity=");
		sb.append(getCapacity());
		sb.append(", extension=");
		sb.append(getExtension());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.cignexdatamatics.wrm.model.RoomMaster");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>roomId</column-name><column-value><![CDATA[");
		sb.append(getRoomId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cityId</column-name><column-value><![CDATA[");
		sb.append(getCityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>floorId</column-name><column-value><![CDATA[");
		sb.append(getFloorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roomName</column-name><column-value><![CDATA[");
		sb.append(getRoomName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capacity</column-name><column-value><![CDATA[");
		sb.append(getCapacity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extension</column-name><column-value><![CDATA[");
		sb.append(getExtension());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _roomId;
	private long _cityId;
	private long _locationId;
	private long _floorId;
	private String _roomName;
	private long _capacity;
	private long _extension;
	private BaseModel<?> _roomMasterRemoteModel;
}