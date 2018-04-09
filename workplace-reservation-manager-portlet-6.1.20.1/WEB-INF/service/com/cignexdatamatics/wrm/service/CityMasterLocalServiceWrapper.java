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

package com.cignexdatamatics.wrm.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CityMasterLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CityMasterLocalService
 * @generated
 */
public class CityMasterLocalServiceWrapper implements CityMasterLocalService,
	ServiceWrapper<CityMasterLocalService> {
	public CityMasterLocalServiceWrapper(
		CityMasterLocalService cityMasterLocalService) {
		_cityMasterLocalService = cityMasterLocalService;
	}

	/**
	* Adds the city master to the database. Also notifies the appropriate model listeners.
	*
	* @param cityMaster the city master
	* @return the city master that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.CityMaster addCityMaster(
		com.cignexdatamatics.wrm.model.CityMaster cityMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.addCityMaster(cityMaster);
	}

	/**
	* Creates a new city master with the primary key. Does not add the city master to the database.
	*
	* @param cityId the primary key for the new city master
	* @return the new city master
	*/
	public com.cignexdatamatics.wrm.model.CityMaster createCityMaster(
		long cityId) {
		return _cityMasterLocalService.createCityMaster(cityId);
	}

	/**
	* Deletes the city master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cityId the primary key of the city master
	* @return the city master that was removed
	* @throws PortalException if a city master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.CityMaster deleteCityMaster(
		long cityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.deleteCityMaster(cityId);
	}

	/**
	* Deletes the city master from the database. Also notifies the appropriate model listeners.
	*
	* @param cityMaster the city master
	* @return the city master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.CityMaster deleteCityMaster(
		com.cignexdatamatics.wrm.model.CityMaster cityMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.deleteCityMaster(cityMaster);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cityMasterLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cignexdatamatics.wrm.model.CityMaster fetchCityMaster(
		long cityId) throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.fetchCityMaster(cityId);
	}

	/**
	* Returns the city master with the primary key.
	*
	* @param cityId the primary key of the city master
	* @return the city master
	* @throws PortalException if a city master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.CityMaster getCityMaster(long cityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.getCityMaster(cityId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the city masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of city masters
	* @param end the upper bound of the range of city masters (not inclusive)
	* @return the range of city masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.CityMaster> getCityMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.getCityMasters(start, end);
	}

	/**
	* Returns the number of city masters.
	*
	* @return the number of city masters
	* @throws SystemException if a system exception occurred
	*/
	public int getCityMastersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.getCityMastersCount();
	}

	/**
	* Updates the city master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cityMaster the city master
	* @return the city master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.CityMaster updateCityMaster(
		com.cignexdatamatics.wrm.model.CityMaster cityMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.updateCityMaster(cityMaster);
	}

	/**
	* Updates the city master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cityMaster the city master
	* @param merge whether to merge the city master with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the city master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.CityMaster updateCityMaster(
		com.cignexdatamatics.wrm.model.CityMaster cityMaster, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.updateCityMaster(cityMaster, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _cityMasterLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cityMasterLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cityMasterLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.CityMaster> findAllInCity()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.findAllInCity();
	}

	public com.cignexdatamatics.wrm.model.CityMaster findbyCityName(
		java.lang.String name)
		throws com.cignexdatamatics.wrm.NoSuchCityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.findbyCityName(name);
	}

	public com.cignexdatamatics.wrm.model.CityMaster findCitybyCityId(
		long cityId)
		throws com.cignexdatamatics.wrm.NoSuchCityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.findCitybyCityId(cityId);
	}

	public com.cignexdatamatics.wrm.model.CityMaster addCity(
		com.cignexdatamatics.wrm.model.CityMaster validCity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMasterLocalService.addCity(validCity);
	}

	public void remove(com.cignexdatamatics.wrm.model.CityMaster city)
		throws com.liferay.portal.kernel.exception.SystemException {
		_cityMasterLocalService.remove(city);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CityMasterLocalService getWrappedCityMasterLocalService() {
		return _cityMasterLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCityMasterLocalService(
		CityMasterLocalService cityMasterLocalService) {
		_cityMasterLocalService = cityMasterLocalService;
	}

	public CityMasterLocalService getWrappedService() {
		return _cityMasterLocalService;
	}

	public void setWrappedService(CityMasterLocalService cityMasterLocalService) {
		_cityMasterLocalService = cityMasterLocalService;
	}

	private CityMasterLocalService _cityMasterLocalService;
}