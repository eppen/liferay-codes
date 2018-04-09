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
 * This class is a wrapper for {@link FloorMaster}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       FloorMaster
 * @generated
 */
public class FloorMasterWrapper implements FloorMaster,
	ModelWrapper<FloorMaster> {
	public FloorMasterWrapper(FloorMaster floorMaster) {
		_floorMaster = floorMaster;
	}

	public Class<?> getModelClass() {
		return FloorMaster.class;
	}

	public String getModelClassName() {
		return FloorMaster.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("floorId", getFloorId());
		attributes.put("locationId", getLocationId());
		attributes.put("floorName", getFloorName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long floorId = (Long)attributes.get("floorId");

		if (floorId != null) {
			setFloorId(floorId);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String floorName = (String)attributes.get("floorName");

		if (floorName != null) {
			setFloorName(floorName);
		}
	}

	/**
	* Returns the primary key of this floor master.
	*
	* @return the primary key of this floor master
	*/
	public long getPrimaryKey() {
		return _floorMaster.getPrimaryKey();
	}

	/**
	* Sets the primary key of this floor master.
	*
	* @param primaryKey the primary key of this floor master
	*/
	public void setPrimaryKey(long primaryKey) {
		_floorMaster.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the floor ID of this floor master.
	*
	* @return the floor ID of this floor master
	*/
	public long getFloorId() {
		return _floorMaster.getFloorId();
	}

	/**
	* Sets the floor ID of this floor master.
	*
	* @param floorId the floor ID of this floor master
	*/
	public void setFloorId(long floorId) {
		_floorMaster.setFloorId(floorId);
	}

	/**
	* Returns the location ID of this floor master.
	*
	* @return the location ID of this floor master
	*/
	public long getLocationId() {
		return _floorMaster.getLocationId();
	}

	/**
	* Sets the location ID of this floor master.
	*
	* @param locationId the location ID of this floor master
	*/
	public void setLocationId(long locationId) {
		_floorMaster.setLocationId(locationId);
	}

	/**
	* Returns the floor name of this floor master.
	*
	* @return the floor name of this floor master
	*/
	public java.lang.String getFloorName() {
		return _floorMaster.getFloorName();
	}

	/**
	* Sets the floor name of this floor master.
	*
	* @param floorName the floor name of this floor master
	*/
	public void setFloorName(java.lang.String floorName) {
		_floorMaster.setFloorName(floorName);
	}

	public boolean isNew() {
		return _floorMaster.isNew();
	}

	public void setNew(boolean n) {
		_floorMaster.setNew(n);
	}

	public boolean isCachedModel() {
		return _floorMaster.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_floorMaster.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _floorMaster.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _floorMaster.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_floorMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _floorMaster.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_floorMaster.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FloorMasterWrapper((FloorMaster)_floorMaster.clone());
	}

	public int compareTo(com.cignexdatamatics.wrm.model.FloorMaster floorMaster) {
		return _floorMaster.compareTo(floorMaster);
	}

	@Override
	public int hashCode() {
		return _floorMaster.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cignexdatamatics.wrm.model.FloorMaster> toCacheModel() {
		return _floorMaster.toCacheModel();
	}

	public com.cignexdatamatics.wrm.model.FloorMaster toEscapedModel() {
		return new FloorMasterWrapper(_floorMaster.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _floorMaster.toString();
	}

	public java.lang.String toXmlString() {
		return _floorMaster.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_floorMaster.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public FloorMaster getWrappedFloorMaster() {
		return _floorMaster;
	}

	public FloorMaster getWrappedModel() {
		return _floorMaster;
	}

	public void resetOriginalValues() {
		_floorMaster.resetOriginalValues();
	}

	private FloorMaster _floorMaster;
}