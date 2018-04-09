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
public class RoomMasterSoap implements Serializable {
	public static RoomMasterSoap toSoapModel(RoomMaster model) {
		RoomMasterSoap soapModel = new RoomMasterSoap();

		soapModel.setRoomId(model.getRoomId());
		soapModel.setCityId(model.getCityId());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setFloorId(model.getFloorId());
		soapModel.setRoomName(model.getRoomName());
		soapModel.setCapacity(model.getCapacity());
		soapModel.setExtension(model.getExtension());

		return soapModel;
	}

	public static RoomMasterSoap[] toSoapModels(RoomMaster[] models) {
		RoomMasterSoap[] soapModels = new RoomMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RoomMasterSoap[][] toSoapModels(RoomMaster[][] models) {
		RoomMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RoomMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RoomMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RoomMasterSoap[] toSoapModels(List<RoomMaster> models) {
		List<RoomMasterSoap> soapModels = new ArrayList<RoomMasterSoap>(models.size());

		for (RoomMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RoomMasterSoap[soapModels.size()]);
	}

	public RoomMasterSoap() {
	}

	public long getPrimaryKey() {
		return _roomId;
	}

	public void setPrimaryKey(long pk) {
		setRoomId(pk);
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

	private long _roomId;
	private long _cityId;
	private long _locationId;
	private long _floorId;
	private String _roomName;
	private long _capacity;
	private long _extension;
}