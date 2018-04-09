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

import com.cignexdatamatics.wrm.service.CityMasterLocalServiceUtil;

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
public class CityMasterClp extends BaseModelImpl<CityMaster>
	implements CityMaster {
	public CityMasterClp() {
	}

	public Class<?> getModelClass() {
		return CityMaster.class;
	}

	public String getModelClassName() {
		return CityMaster.class.getName();
	}

	public long getPrimaryKey() {
		return _cityId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCityId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_cityId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cityId", getCityId());
		attributes.put("cityName", getCityName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
		}

		String cityName = (String)attributes.get("cityName");

		if (cityName != null) {
			setCityName(cityName);
		}
	}

	public long getCityId() {
		return _cityId;
	}

	public void setCityId(long cityId) {
		_cityId = cityId;
	}

	public String getCityName() {
		return _cityName;
	}

	public void setCityName(String cityName) {
		_cityName = cityName;
	}

	public BaseModel<?> getCityMasterRemoteModel() {
		return _cityMasterRemoteModel;
	}

	public void setCityMasterRemoteModel(BaseModel<?> cityMasterRemoteModel) {
		_cityMasterRemoteModel = cityMasterRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CityMasterLocalServiceUtil.addCityMaster(this);
		}
		else {
			CityMasterLocalServiceUtil.updateCityMaster(this);
		}
	}

	@Override
	public CityMaster toEscapedModel() {
		return (CityMaster)Proxy.newProxyInstance(CityMaster.class.getClassLoader(),
			new Class[] { CityMaster.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CityMasterClp clone = new CityMasterClp();

		clone.setCityId(getCityId());
		clone.setCityName(getCityName());

		return clone;
	}

	public int compareTo(CityMaster cityMaster) {
		int value = 0;

		value = getCityName().compareTo(cityMaster.getCityName());

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

		CityMasterClp cityMaster = null;

		try {
			cityMaster = (CityMasterClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = cityMaster.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{cityId=");
		sb.append(getCityId());
		sb.append(", cityName=");
		sb.append(getCityName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.cignexdatamatics.wrm.model.CityMaster");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cityId</column-name><column-value><![CDATA[");
		sb.append(getCityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cityName</column-name><column-value><![CDATA[");
		sb.append(getCityName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _cityId;
	private String _cityName;
	private BaseModel<?> _cityMasterRemoteModel;
}