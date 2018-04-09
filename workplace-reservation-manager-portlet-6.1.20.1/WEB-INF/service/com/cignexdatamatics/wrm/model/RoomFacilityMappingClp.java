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

import com.cignexdatamatics.wrm.service.RoomFacilityMappingLocalServiceUtil;
import com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK;

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
public class RoomFacilityMappingClp extends BaseModelImpl<RoomFacilityMapping>
	implements RoomFacilityMapping {
	public RoomFacilityMappingClp() {
	}

	public Class<?> getModelClass() {
		return RoomFacilityMapping.class;
	}

	public String getModelClassName() {
		return RoomFacilityMapping.class.getName();
	}

	public RoomFacilityMappingPK getPrimaryKey() {
		return new RoomFacilityMappingPK(_roomId, _facilitiesId);
	}

	public void setPrimaryKey(RoomFacilityMappingPK primaryKey) {
		setRoomId(primaryKey.roomId);
		setFacilitiesId(primaryKey.facilitiesId);
	}

	public Serializable getPrimaryKeyObj() {
		return new RoomFacilityMappingPK(_roomId, _facilitiesId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((RoomFacilityMappingPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roomId", getRoomId());
		attributes.put("facilitiesId", getFacilitiesId());

		return attributes;
	}

	@Override
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

	public long getRoomId() {
		return _roomId;
	}

	public void setRoomId(long roomId) {
		_roomId = roomId;
	}

	public long getFacilitiesId() {
		return _facilitiesId;
	}

	public void setFacilitiesId(long facilitiesId) {
		_facilitiesId = facilitiesId;
	}

	public BaseModel<?> getRoomFacilityMappingRemoteModel() {
		return _roomFacilityMappingRemoteModel;
	}

	public void setRoomFacilityMappingRemoteModel(
		BaseModel<?> roomFacilityMappingRemoteModel) {
		_roomFacilityMappingRemoteModel = roomFacilityMappingRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			RoomFacilityMappingLocalServiceUtil.addRoomFacilityMapping(this);
		}
		else {
			RoomFacilityMappingLocalServiceUtil.updateRoomFacilityMapping(this);
		}
	}

	@Override
	public RoomFacilityMapping toEscapedModel() {
		return (RoomFacilityMapping)Proxy.newProxyInstance(RoomFacilityMapping.class.getClassLoader(),
			new Class[] { RoomFacilityMapping.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RoomFacilityMappingClp clone = new RoomFacilityMappingClp();

		clone.setRoomId(getRoomId());
		clone.setFacilitiesId(getFacilitiesId());

		return clone;
	}

	public int compareTo(RoomFacilityMapping roomFacilityMapping) {
		RoomFacilityMappingPK primaryKey = roomFacilityMapping.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		RoomFacilityMappingClp roomFacilityMapping = null;

		try {
			roomFacilityMapping = (RoomFacilityMappingClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		RoomFacilityMappingPK primaryKey = roomFacilityMapping.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{roomId=");
		sb.append(getRoomId());
		sb.append(", facilitiesId=");
		sb.append(getFacilitiesId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.cignexdatamatics.wrm.model.RoomFacilityMapping");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>roomId</column-name><column-value><![CDATA[");
		sb.append(getRoomId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facilitiesId</column-name><column-value><![CDATA[");
		sb.append(getFacilitiesId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _roomId;
	private long _facilitiesId;
	private BaseModel<?> _roomFacilityMappingRemoteModel;
}