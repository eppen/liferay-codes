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
 * This class is a wrapper for {@link CityMaster}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CityMaster
 * @generated
 */
public class CityMasterWrapper implements CityMaster, ModelWrapper<CityMaster> {
	public CityMasterWrapper(CityMaster cityMaster) {
		_cityMaster = cityMaster;
	}

	public Class<?> getModelClass() {
		return CityMaster.class;
	}

	public String getModelClassName() {
		return CityMaster.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cityId", getCityId());
		attributes.put("cityName", getCityName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
		}

		String cityName = (String)attributes.get("cityName");

		if (cityName != null) {
			setCityName(cityName);
		}
	}

	/**
	* Returns the primary key of this city master.
	*
	* @return the primary key of this city master
	*/
	public long getPrimaryKey() {
		return _cityMaster.getPrimaryKey();
	}

	/**
	* Sets the primary key of this city master.
	*
	* @param primaryKey the primary key of this city master
	*/
	public void setPrimaryKey(long primaryKey) {
		_cityMaster.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the city ID of this city master.
	*
	* @return the city ID of this city master
	*/
	public long getCityId() {
		return _cityMaster.getCityId();
	}

	/**
	* Sets the city ID of this city master.
	*
	* @param cityId the city ID of this city master
	*/
	public void setCityId(long cityId) {
		_cityMaster.setCityId(cityId);
	}

	/**
	* Returns the city name of this city master.
	*
	* @return the city name of this city master
	*/
	public java.lang.String getCityName() {
		return _cityMaster.getCityName();
	}

	/**
	* Sets the city name of this city master.
	*
	* @param cityName the city name of this city master
	*/
	public void setCityName(java.lang.String cityName) {
		_cityMaster.setCityName(cityName);
	}

	public boolean isNew() {
		return _cityMaster.isNew();
	}

	public void setNew(boolean n) {
		_cityMaster.setNew(n);
	}

	public boolean isCachedModel() {
		return _cityMaster.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_cityMaster.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _cityMaster.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _cityMaster.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cityMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cityMaster.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cityMaster.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CityMasterWrapper((CityMaster)_cityMaster.clone());
	}

	public int compareTo(com.cignexdatamatics.wrm.model.CityMaster cityMaster) {
		return _cityMaster.compareTo(cityMaster);
	}

	@Override
	public int hashCode() {
		return _cityMaster.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cignexdatamatics.wrm.model.CityMaster> toCacheModel() {
		return _cityMaster.toCacheModel();
	}

	public com.cignexdatamatics.wrm.model.CityMaster toEscapedModel() {
		return new CityMasterWrapper(_cityMaster.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cityMaster.toString();
	}

	public java.lang.String toXmlString() {
		return _cityMaster.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cityMaster.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CityMaster getWrappedCityMaster() {
		return _cityMaster;
	}

	public CityMaster getWrappedModel() {
		return _cityMaster;
	}

	public void resetOriginalValues() {
		_cityMaster.resetOriginalValues();
	}

	private CityMaster _cityMaster;
}