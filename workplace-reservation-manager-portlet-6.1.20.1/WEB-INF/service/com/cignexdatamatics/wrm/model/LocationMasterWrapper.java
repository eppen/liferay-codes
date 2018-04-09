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
 * This class is a wrapper for {@link LocationMaster}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LocationMaster
 * @generated
 */
public class LocationMasterWrapper implements LocationMaster,
	ModelWrapper<LocationMaster> {
	public LocationMasterWrapper(LocationMaster locationMaster) {
		_locationMaster = locationMaster;
	}

	public Class<?> getModelClass() {
		return LocationMaster.class;
	}

	public String getModelClassName() {
		return LocationMaster.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("locationId", getLocationId());
		attributes.put("cityId", getCityId());
		attributes.put("locationName", getLocationName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
		}

		String locationName = (String)attributes.get("locationName");

		if (locationName != null) {
			setLocationName(locationName);
		}
	}

	/**
	* Returns the primary key of this location master.
	*
	* @return the primary key of this location master
	*/
	public long getPrimaryKey() {
		return _locationMaster.getPrimaryKey();
	}

	/**
	* Sets the primary key of this location master.
	*
	* @param primaryKey the primary key of this location master
	*/
	public void setPrimaryKey(long primaryKey) {
		_locationMaster.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the location ID of this location master.
	*
	* @return the location ID of this location master
	*/
	public long getLocationId() {
		return _locationMaster.getLocationId();
	}

	/**
	* Sets the location ID of this location master.
	*
	* @param locationId the location ID of this location master
	*/
	public void setLocationId(long locationId) {
		_locationMaster.setLocationId(locationId);
	}

	/**
	* Returns the city ID of this location master.
	*
	* @return the city ID of this location master
	*/
	public long getCityId() {
		return _locationMaster.getCityId();
	}

	/**
	* Sets the city ID of this location master.
	*
	* @param cityId the city ID of this location master
	*/
	public void setCityId(long cityId) {
		_locationMaster.setCityId(cityId);
	}

	/**
	* Returns the location name of this location master.
	*
	* @return the location name of this location master
	*/
	public java.lang.String getLocationName() {
		return _locationMaster.getLocationName();
	}

	/**
	* Sets the location name of this location master.
	*
	* @param locationName the location name of this location master
	*/
	public void setLocationName(java.lang.String locationName) {
		_locationMaster.setLocationName(locationName);
	}

	public boolean isNew() {
		return _locationMaster.isNew();
	}

	public void setNew(boolean n) {
		_locationMaster.setNew(n);
	}

	public boolean isCachedModel() {
		return _locationMaster.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_locationMaster.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _locationMaster.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _locationMaster.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_locationMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _locationMaster.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_locationMaster.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LocationMasterWrapper((LocationMaster)_locationMaster.clone());
	}

	public int compareTo(
		com.cignexdatamatics.wrm.model.LocationMaster locationMaster) {
		return _locationMaster.compareTo(locationMaster);
	}

	@Override
	public int hashCode() {
		return _locationMaster.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cignexdatamatics.wrm.model.LocationMaster> toCacheModel() {
		return _locationMaster.toCacheModel();
	}

	public com.cignexdatamatics.wrm.model.LocationMaster toEscapedModel() {
		return new LocationMasterWrapper(_locationMaster.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _locationMaster.toString();
	}

	public java.lang.String toXmlString() {
		return _locationMaster.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_locationMaster.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LocationMaster getWrappedLocationMaster() {
		return _locationMaster;
	}

	public LocationMaster getWrappedModel() {
		return _locationMaster;
	}

	public void resetOriginalValues() {
		_locationMaster.resetOriginalValues();
	}

	private LocationMaster _locationMaster;
}