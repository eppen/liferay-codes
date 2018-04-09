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

import com.cignexdatamatics.wrm.service.FacilityMasterLocalServiceUtil;

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
public class FacilityMasterClp extends BaseModelImpl<FacilityMaster>
	implements FacilityMaster {
	public FacilityMasterClp() {
	}

	public Class<?> getModelClass() {
		return FacilityMaster.class;
	}

	public String getModelClassName() {
		return FacilityMaster.class.getName();
	}

	public long getPrimaryKey() {
		return _facilitiesId;
	}

	public void setPrimaryKey(long primaryKey) {
		setFacilitiesId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_facilitiesId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("facilitiesId", getFacilitiesId());
		attributes.put("facilitiesName", getFacilitiesName());
		attributes.put("facilitiesDesc", getFacilitiesDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long facilitiesId = (Long)attributes.get("facilitiesId");

		if (facilitiesId != null) {
			setFacilitiesId(facilitiesId);
		}

		String facilitiesName = (String)attributes.get("facilitiesName");

		if (facilitiesName != null) {
			setFacilitiesName(facilitiesName);
		}

		String facilitiesDesc = (String)attributes.get("facilitiesDesc");

		if (facilitiesDesc != null) {
			setFacilitiesDesc(facilitiesDesc);
		}
	}

	public long getFacilitiesId() {
		return _facilitiesId;
	}

	public void setFacilitiesId(long facilitiesId) {
		_facilitiesId = facilitiesId;
	}

	public String getFacilitiesName() {
		return _facilitiesName;
	}

	public void setFacilitiesName(String facilitiesName) {
		_facilitiesName = facilitiesName;
	}

	public String getFacilitiesDesc() {
		return _facilitiesDesc;
	}

	public void setFacilitiesDesc(String facilitiesDesc) {
		_facilitiesDesc = facilitiesDesc;
	}

	public BaseModel<?> getFacilityMasterRemoteModel() {
		return _facilityMasterRemoteModel;
	}

	public void setFacilityMasterRemoteModel(
		BaseModel<?> facilityMasterRemoteModel) {
		_facilityMasterRemoteModel = facilityMasterRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			FacilityMasterLocalServiceUtil.addFacilityMaster(this);
		}
		else {
			FacilityMasterLocalServiceUtil.updateFacilityMaster(this);
		}
	}

	@Override
	public FacilityMaster toEscapedModel() {
		return (FacilityMaster)Proxy.newProxyInstance(FacilityMaster.class.getClassLoader(),
			new Class[] { FacilityMaster.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FacilityMasterClp clone = new FacilityMasterClp();

		clone.setFacilitiesId(getFacilitiesId());
		clone.setFacilitiesName(getFacilitiesName());
		clone.setFacilitiesDesc(getFacilitiesDesc());

		return clone;
	}

	public int compareTo(FacilityMaster facilityMaster) {
		int value = 0;

		value = getFacilitiesName().compareTo(facilityMaster.getFacilitiesName());

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

		FacilityMasterClp facilityMaster = null;

		try {
			facilityMaster = (FacilityMasterClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = facilityMaster.getPrimaryKey();

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

		sb.append("{facilitiesId=");
		sb.append(getFacilitiesId());
		sb.append(", facilitiesName=");
		sb.append(getFacilitiesName());
		sb.append(", facilitiesDesc=");
		sb.append(getFacilitiesDesc());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.cignexdatamatics.wrm.model.FacilityMaster");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>facilitiesId</column-name><column-value><![CDATA[");
		sb.append(getFacilitiesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facilitiesName</column-name><column-value><![CDATA[");
		sb.append(getFacilitiesName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facilitiesDesc</column-name><column-value><![CDATA[");
		sb.append(getFacilitiesDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _facilitiesId;
	private String _facilitiesName;
	private String _facilitiesDesc;
	private BaseModel<?> _facilityMasterRemoteModel;
}