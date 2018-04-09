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
public class CityMasterSoap implements Serializable {
	public static CityMasterSoap toSoapModel(CityMaster model) {
		CityMasterSoap soapModel = new CityMasterSoap();

		soapModel.setCityId(model.getCityId());
		soapModel.setCityName(model.getCityName());

		return soapModel;
	}

	public static CityMasterSoap[] toSoapModels(CityMaster[] models) {
		CityMasterSoap[] soapModels = new CityMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CityMasterSoap[][] toSoapModels(CityMaster[][] models) {
		CityMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CityMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CityMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CityMasterSoap[] toSoapModels(List<CityMaster> models) {
		List<CityMasterSoap> soapModels = new ArrayList<CityMasterSoap>(models.size());

		for (CityMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CityMasterSoap[soapModels.size()]);
	}

	public CityMasterSoap() {
	}

	public long getPrimaryKey() {
		return _cityId;
	}

	public void setPrimaryKey(long pk) {
		setCityId(pk);
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

	private long _cityId;
	private String _cityName;
}