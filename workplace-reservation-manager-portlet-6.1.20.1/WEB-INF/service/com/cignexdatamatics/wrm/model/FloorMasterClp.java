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

import com.cignexdatamatics.wrm.service.FloorMasterLocalServiceUtil;

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
public class FloorMasterClp extends BaseModelImpl<FloorMaster>
	implements FloorMaster {
	public FloorMasterClp() {
	}

	public Class<?> getModelClass() {
		return FloorMaster.class;
	}

	public String getModelClassName() {
		return FloorMaster.class.getName();
	}

	public long getPrimaryKey() {
		return _floorId;
	}

	public void setPrimaryKey(long primaryKey) {
		setFloorId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_floorId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("floorId", getFloorId());
		attributes.put("locationId", getLocationId());
		attributes.put("floorName", getFloorName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long floorId = (Long)attributes.get("floorId");

		if (floorId != null) {
			setFloorId(floorId);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String floorName = (String)attributes.get("floorName");

		if (floorName != null) {
			setFloorName(floorName);
		}
	}

	public long getFloorId() {
		return _floorId;
	}

	public void setFloorId(long floorId) {
		_floorId = floorId;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public String getFloorName() {
		return _floorName;
	}

	public void setFloorName(String floorName) {
		_floorName = floorName;
	}

	public BaseModel<?> getFloorMasterRemoteModel() {
		return _floorMasterRemoteModel;
	}

	public void setFloorMasterRemoteModel(BaseModel<?> floorMasterRemoteModel) {
		_floorMasterRemoteModel = floorMasterRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			FloorMasterLocalServiceUtil.addFloorMaster(this);
		}
		else {
			FloorMasterLocalServiceUtil.updateFloorMaster(this);
		}
	}

	@Override
	public FloorMaster toEscapedModel() {
		return (FloorMaster)Proxy.newProxyInstance(FloorMaster.class.getClassLoader(),
			new Class[] { FloorMaster.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FloorMasterClp clone = new FloorMasterClp();

		clone.setFloorId(getFloorId());
		clone.setLocationId(getLocationId());
		clone.setFloorName(getFloorName());

		return clone;
	}

	public int compareTo(FloorMaster floorMaster) {
		int value = 0;

		value = getFloorName().compareTo(floorMaster.getFloorName());

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

		FloorMasterClp floorMaster = null;

		try {
			floorMaster = (FloorMasterClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = floorMaster.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{floorId=");
		sb.append(getFloorId());
		sb.append(", locationId=");
		sb.append(getLocationId());
		sb.append(", floorName=");
		sb.append(getFloorName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.cignexdatamatics.wrm.model.FloorMaster");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>floorId</column-name><column-value><![CDATA[");
		sb.append(getFloorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>floorName</column-name><column-value><![CDATA[");
		sb.append(getFloorName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _floorId;
	private long _locationId;
	private String _floorName;
	private BaseModel<?> _floorMasterRemoteModel;
}