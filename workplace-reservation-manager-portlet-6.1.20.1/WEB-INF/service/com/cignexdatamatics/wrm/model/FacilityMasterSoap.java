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
public class FacilityMasterSoap implements Serializable {
	public static FacilityMasterSoap toSoapModel(FacilityMaster model) {
		FacilityMasterSoap soapModel = new FacilityMasterSoap();

		soapModel.setFacilitiesId(model.getFacilitiesId());
		soapModel.setFacilitiesName(model.getFacilitiesName());
		soapModel.setFacilitiesDesc(model.getFacilitiesDesc());

		return soapModel;
	}

	public static FacilityMasterSoap[] toSoapModels(FacilityMaster[] models) {
		FacilityMasterSoap[] soapModels = new FacilityMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FacilityMasterSoap[][] toSoapModels(FacilityMaster[][] models) {
		FacilityMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FacilityMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FacilityMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FacilityMasterSoap[] toSoapModels(List<FacilityMaster> models) {
		List<FacilityMasterSoap> soapModels = new ArrayList<FacilityMasterSoap>(models.size());

		for (FacilityMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FacilityMasterSoap[soapModels.size()]);
	}

	public FacilityMasterSoap() {
	}

	public long getPrimaryKey() {
		return _facilitiesId;
	}

	public void setPrimaryKey(long pk) {
		setFacilitiesId(pk);
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

	private long _facilitiesId;
	private String _facilitiesName;
	private String _facilitiesDesc;
}