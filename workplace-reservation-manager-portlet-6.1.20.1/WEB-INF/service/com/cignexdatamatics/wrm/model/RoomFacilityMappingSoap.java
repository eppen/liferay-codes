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

import com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class RoomFacilityMappingSoap implements Serializable {
	public static RoomFacilityMappingSoap toSoapModel(RoomFacilityMapping model) {
		RoomFacilityMappingSoap soapModel = new RoomFacilityMappingSoap();

		soapModel.setRoomId(model.getRoomId());
		soapModel.setFacilitiesId(model.getFacilitiesId());

		return soapModel;
	}

	public static RoomFacilityMappingSoap[] toSoapModels(
		RoomFacilityMapping[] models) {
		RoomFacilityMappingSoap[] soapModels = new RoomFacilityMappingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RoomFacilityMappingSoap[][] toSoapModels(
		RoomFacilityMapping[][] models) {
		RoomFacilityMappingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RoomFacilityMappingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RoomFacilityMappingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RoomFacilityMappingSoap[] toSoapModels(
		List<RoomFacilityMapping> models) {
		List<RoomFacilityMappingSoap> soapModels = new ArrayList<RoomFacilityMappingSoap>(models.size());

		for (RoomFacilityMapping model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RoomFacilityMappingSoap[soapModels.size()]);
	}

	public RoomFacilityMappingSoap() {
	}

	public RoomFacilityMappingPK getPrimaryKey() {
		return new RoomFacilityMappingPK(_roomId, _facilitiesId);
	}

	public void setPrimaryKey(RoomFacilityMappingPK pk) {
		setRoomId(pk.roomId);
		setFacilitiesId(pk.facilitiesId);
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

	private long _roomId;
	private long _facilitiesId;
}