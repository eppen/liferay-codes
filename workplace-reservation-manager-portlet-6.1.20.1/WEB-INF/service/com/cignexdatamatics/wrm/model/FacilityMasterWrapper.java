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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FacilityMaster}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       FacilityMaster
 * @generated
 */
public class FacilityMasterWrapper implements FacilityMaster,
	ModelWrapper<FacilityMaster> {
	public FacilityMasterWrapper(FacilityMaster facilityMaster) {
		_facilityMaster = facilityMaster;
	}

	public Class<?> getModelClass() {
		return FacilityMaster.class;
	}

	public String getModelClassName() {
		return FacilityMaster.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("facilitiesId", getFacilitiesId());
		attributes.put("facilitiesName", getFacilitiesName());
		attributes.put("facilitiesDesc", getFacilitiesDesc());

		return attributes;
	}

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

	/**
	* Returns the primary key of this facility master.
	*
	* @return the primary key of this facility master
	*/
	public long getPrimaryKey() {
		return _facilityMaster.getPrimaryKey();
	}

	/**
	* Sets the primary key of this facility master.
	*
	* @param primaryKey the primary key of this facility master
	*/
	public void setPrimaryKey(long primaryKey) {
		_facilityMaster.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the facilities ID of this facility master.
	*
	* @return the facilities ID of this facility master
	*/
	public long getFacilitiesId() {
		return _facilityMaster.getFacilitiesId();
	}

	/**
	* Sets the facilities ID of this facility master.
	*
	* @param facilitiesId the facilities ID of this facility master
	*/
	public void setFacilitiesId(long facilitiesId) {
		_facilityMaster.setFacilitiesId(facilitiesId);
	}

	/**
	* Returns the facilities name of this facility master.
	*
	* @return the facilities name of this facility master
	*/
	public java.lang.String getFacilitiesName() {
		return _facilityMaster.getFacilitiesName();
	}

	/**
	* Sets the facilities name of this facility master.
	*
	* @param facilitiesName the facilities name of this facility master
	*/
	public void setFacilitiesName(java.lang.String facilitiesName) {
		_facilityMaster.setFacilitiesName(facilitiesName);
	}

	/**
	* Returns the facilities desc of this facility master.
	*
	* @return the facilities desc of this facility master
	*/
	public java.lang.String getFacilitiesDesc() {
		return _facilityMaster.getFacilitiesDesc();
	}

	/**
	* Sets the facilities desc of this facility master.
	*
	* @param facilitiesDesc the facilities desc of this facility master
	*/
	public void setFacilitiesDesc(java.lang.String facilitiesDesc) {
		_facilityMaster.setFacilitiesDesc(facilitiesDesc);
	}

	public boolean isNew() {
		return _facilityMaster.isNew();
	}

	public void setNew(boolean n) {
		_facilityMaster.setNew(n);
	}

	public boolean isCachedModel() {
		return _facilityMaster.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_facilityMaster.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _facilityMaster.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _facilityMaster.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_facilityMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _facilityMaster.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_facilityMaster.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FacilityMasterWrapper((FacilityMaster)_facilityMaster.clone());
	}

	public int compareTo(
		com.cignexdatamatics.wrm.model.FacilityMaster facilityMaster) {
		return _facilityMaster.compareTo(facilityMaster);
	}

	@Override
	public int hashCode() {
		return _facilityMaster.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cignexdatamatics.wrm.model.FacilityMaster> toCacheModel() {
		return _facilityMaster.toCacheModel();
	}

	public com.cignexdatamatics.wrm.model.FacilityMaster toEscapedModel() {
		return new FacilityMasterWrapper(_facilityMaster.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _facilityMaster.toString();
	}

	public java.lang.String toXmlString() {
		return _facilityMaster.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_facilityMaster.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public FacilityMaster getWrappedFacilityMaster() {
		return _facilityMaster;
	}

	public FacilityMaster getWrappedModel() {
		return _facilityMaster;
	}

	public void resetOriginalValues() {
		_facilityMaster.resetOriginalValues();
	}

	private FacilityMaster _facilityMaster;
}