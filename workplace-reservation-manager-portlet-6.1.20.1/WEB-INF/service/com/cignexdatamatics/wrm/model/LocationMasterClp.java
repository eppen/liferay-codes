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

import com.cignexdatamatics.wrm.service.LocationMasterLocalServiceUtil;

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
public class LocationMasterClp extends BaseModelImpl<LocationMaster>
	implements LocationMaster {
	public LocationMasterClp() {
	}

	public Class<?> getModelClass() {
		return LocationMaster.class;
	}

	public String getModelClassName() {
		return LocationMaster.class.getName();
	}

	public long getPrimaryKey() {
		return _locationId;
	}

	public void setPrimaryKey(long primaryKey) {
		setLocationId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_locationId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("locationId", getLocationId());
		attributes.put("cityId", getCityId());
		attributes.put("locationName", getLocationName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
		}

		String locationName = (String)attributes.get("locationName");

		if (locationName != null) {
			setLocationName(locationName);
		}
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public long getCityId() {
		return _cityId;
	}

	public void setCityId(long cityId) {
		_cityId = cityId;
	}

	public String getLocationName() {
		return _locationName;
	}

	public void setLocationName(String locationName) {
		_locationName = locationName;
	}

	public BaseModel<?> getLocationMasterRemoteModel() {
		return _locationMasterRemoteModel;
	}

	public void setLocationMasterRemoteModel(
		BaseModel<?> locationMasterRemoteModel) {
		_locationMasterRemoteModel = locationMasterRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LocationMasterLocalServiceUtil.addLocationMaster(this);
		}
		else {
			LocationMasterLocalServiceUtil.updateLocationMaster(this);
		}
	}

	@Override
	public LocationMaster toEscapedModel() {
		return (LocationMaster)Proxy.newProxyInstance(LocationMaster.class.getClassLoader(),
			new Class[] { LocationMaster.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LocationMasterClp clone = new LocationMasterClp();

		clone.setLocationId(getLocationId());
		clone.setCityId(getCityId());
		clone.setLocationName(getLocationName());

		return clone;
	}

	public int compareTo(LocationMaster locationMaster) {
		int value = 0;

		if (getCityId() < locationMaster.getCityId()) {
			value = -1;
		}
		else if (getCityId() > locationMaster.getCityId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getLocationName().toLowerCase()
					.compareTo(locationMaster.getLocationName().toLowerCase());

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

		LocationMasterClp locationMaster = null;

		try {
			locationMaster = (LocationMasterClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = locationMaster.getPrimaryKey();

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

		sb.append("{locationId=");
		sb.append(getLocationId());
		sb.append(", cityId=");
		sb.append(getCityId());
		sb.append(", locationName=");
		sb.append(getLocationName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.cignexdatamatics.wrm.model.LocationMaster");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>locationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cityId</column-name><column-value><![CDATA[");
		sb.append(getCityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationName</column-name><column-value><![CDATA[");
		sb.append(getLocationName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _locationId;
	private long _cityId;
	private String _locationName;
	private BaseModel<?> _locationMasterRemoteModel;
}