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
public class FloorMasterSoap implements Serializable {
	public static FloorMasterSoap toSoapModel(FloorMaster model) {
		FloorMasterSoap soapModel = new FloorMasterSoap();

		soapModel.setFloorId(model.getFloorId());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setFloorName(model.getFloorName());

		return soapModel;
	}

	public static FloorMasterSoap[] toSoapModels(FloorMaster[] models) {
		FloorMasterSoap[] soapModels = new FloorMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FloorMasterSoap[][] toSoapModels(FloorMaster[][] models) {
		FloorMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FloorMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FloorMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FloorMasterSoap[] toSoapModels(List<FloorMaster> models) {
		List<FloorMasterSoap> soapModels = new ArrayList<FloorMasterSoap>(models.size());

		for (FloorMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FloorMasterSoap[soapModels.size()]);
	}

	public FloorMasterSoap() {
	}

	public long getPrimaryKey() {
		return _floorId;
	}

	public void setPrimaryKey(long pk) {
		setFloorId(pk);
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

	private long _floorId;
	private long _locationId;
	private String _floorName;
}