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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class LocationMasterSoap implements Serializable {
	public static LocationMasterSoap toSoapModel(LocationMaster model) {
		LocationMasterSoap soapModel = new LocationMasterSoap();

		soapModel.setLocationId(model.getLocationId());
		soapModel.setCityId(model.getCityId());
		soapModel.setLocationName(model.getLocationName());

		return soapModel;
	}

	public static LocationMasterSoap[] toSoapModels(LocationMaster[] models) {
		LocationMasterSoap[] soapModels = new LocationMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LocationMasterSoap[][] toSoapModels(LocationMaster[][] models) {
		LocationMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LocationMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LocationMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LocationMasterSoap[] toSoapModels(List<LocationMaster> models) {
		List<LocationMasterSoap> soapModels = new ArrayList<LocationMasterSoap>(models.size());

		for (LocationMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LocationMasterSoap[soapModels.size()]);
	}

	public LocationMasterSoap() {
	}

	public long getPrimaryKey() {
		return _locationId;
	}

	public void setPrimaryKey(long pk) {
		setLocationId(pk);
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

	private long _locationId;
	private long _cityId;
	private String _locationName;
}