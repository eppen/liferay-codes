/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.chola.calendar.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link dataLocalService}.
 *
 * @author adms.java1
 * @see dataLocalService
 * @generated
 */
@ProviderType
public class dataLocalServiceWrapper implements dataLocalService,
	ServiceWrapper<dataLocalService> {
	public dataLocalServiceWrapper(dataLocalService dataLocalService) {
		_dataLocalService = dataLocalService;
	}

	/**
	* Adds the data to the database. Also notifies the appropriate model listeners.
	*
	* @param data the data
	* @return the data that was added
	*/
	@Override
	public com.chola.calendar.model.data adddata(
		com.chola.calendar.model.data data) {
		return _dataLocalService.adddata(data);
	}

	/**
	* Creates a new data with the primary key. Does not add the data to the database.
	*
	* @param eventid the primary key for the new data
	* @return the new data
	*/
	@Override
	public com.chola.calendar.model.data createdata(long eventid) {
		return _dataLocalService.createdata(eventid);
	}

	/**
	* Deletes the data from the database. Also notifies the appropriate model listeners.
	*
	* @param data the data
	* @return the data that was removed
	*/
	@Override
	public com.chola.calendar.model.data deletedata(
		com.chola.calendar.model.data data) {
		return _dataLocalService.deletedata(data);
	}

	/**
	* Deletes the data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventid the primary key of the data
	* @return the data that was removed
	* @throws PortalException if a data with the primary key could not be found
	*/
	@Override
	public com.chola.calendar.model.data deletedata(long eventid)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dataLocalService.deletedata(eventid);
	}

	@Override
	public com.chola.calendar.model.data fetchdata(long eventid) {
		return _dataLocalService.fetchdata(eventid);
	}

	/**
	* Returns the data with the primary key.
	*
	* @param eventid the primary key of the data
	* @return the data
	* @throws PortalException if a data with the primary key could not be found
	*/
	@Override
	public com.chola.calendar.model.data getdata(long eventid)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dataLocalService.getdata(eventid);
	}

	/**
	* Updates the data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param data the data
	* @return the data that was updated
	*/
	@Override
	public com.chola.calendar.model.data updatedata(
		com.chola.calendar.model.data data) {
		return _dataLocalService.updatedata(data);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _dataLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _dataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of datas.
	*
	* @return the number of datas
	*/
	@Override
	public int getdatasCount() {
		return _dataLocalService.getdatasCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dataLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _dataLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _dataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.calendar.model.impl.dataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _dataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.calendar.model.impl.dataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _dataLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<java.lang.String> getCompany() {
		return _dataLocalService.getCompany();
	}

	@Override
	public java.util.List<java.lang.String> getDepart(
		java.lang.String businessId) {
		return _dataLocalService.getDepart(businessId);
	}

	@Override
	public java.util.List<java.lang.String> getFunction(
		java.lang.String businessId) {
		return _dataLocalService.getFunction(businessId);
	}

	@Override
	public java.util.List<java.lang.String> getIntendedUser(
		java.lang.String businessId, java.lang.String[] values,
		java.lang.String gender, java.lang.String age, java.lang.String option) {
		return _dataLocalService.getIntendedUser(businessId, values, gender,
			age, option);
	}

	@Override
	public java.util.List<java.lang.String> getUnit(java.lang.String businessId) {
		return _dataLocalService.getUnit(businessId);
	}

	/**
	* Returns a range of all the datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.calendar.model.impl.dataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of datas
	* @param end the upper bound of the range of datas (not inclusive)
	* @return the range of datas
	*/
	@Override
	public java.util.List<com.chola.calendar.model.data> getdatas(int start,
		int end) {
		return _dataLocalService.getdatas(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _dataLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _dataLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public dataLocalService getWrappedService() {
		return _dataLocalService;
	}

	@Override
	public void setWrappedService(dataLocalService dataLocalService) {
		_dataLocalService = dataLocalService;
	}

	private dataLocalService _dataLocalService;
}