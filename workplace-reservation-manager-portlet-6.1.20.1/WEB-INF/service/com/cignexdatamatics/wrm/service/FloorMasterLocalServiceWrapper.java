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
 * This class is a wrapper for {@link FloorMasterLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       FloorMasterLocalService
 * @generated
 */
public class FloorMasterLocalServiceWrapper implements FloorMasterLocalService,
	ServiceWrapper<FloorMasterLocalService> {
	public FloorMasterLocalServiceWrapper(
		FloorMasterLocalService floorMasterLocalService) {
		_floorMasterLocalService = floorMasterLocalService;
	}

	/**
	* Adds the floor master to the database. Also notifies the appropriate model listeners.
	*
	* @param floorMaster the floor master
	* @return the floor master that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster addFloorMaster(
		com.cignexdatamatics.wrm.model.FloorMaster floorMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.addFloorMaster(floorMaster);
	}

	/**
	* Creates a new floor master with the primary key. Does not add the floor master to the database.
	*
	* @param floorId the primary key for the new floor master
	* @return the new floor master
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster createFloorMaster(
		long floorId) {
		return _floorMasterLocalService.createFloorMaster(floorId);
	}

	/**
	* Deletes the floor master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param floorId the primary key of the floor master
	* @return the floor master that was removed
	* @throws PortalException if a floor master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster deleteFloorMaster(
		long floorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.deleteFloorMaster(floorId);
	}

	/**
	* Deletes the floor master from the database. Also notifies the appropriate model listeners.
	*
	* @param floorMaster the floor master
	* @return the floor master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster deleteFloorMaster(
		com.cignexdatamatics.wrm.model.FloorMaster floorMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.deleteFloorMaster(floorMaster);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _floorMasterLocalService.dynamicQuery();
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
		return _floorMasterLocalService.dynamicQuery(dynamicQuery);
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
		return _floorMasterLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _floorMasterLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _floorMasterLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cignexdatamatics.wrm.model.FloorMaster fetchFloorMaster(
		long floorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.fetchFloorMaster(floorId);
	}

	/**
	* Returns the floor master with the primary key.
	*
	* @param floorId the primary key of the floor master
	* @return the floor master
	* @throws PortalException if a floor master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster getFloorMaster(
		long floorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.getFloorMaster(floorId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the floor masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of floor masters
	* @param end the upper bound of the range of floor masters (not inclusive)
	* @return the range of floor masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> getFloorMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.getFloorMasters(start, end);
	}

	/**
	* Returns the number of floor masters.
	*
	* @return the number of floor masters
	* @throws SystemException if a system exception occurred
	*/
	public int getFloorMastersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.getFloorMastersCount();
	}

	/**
	* Updates the floor master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param floorMaster the floor master
	* @return the floor master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster updateFloorMaster(
		com.cignexdatamatics.wrm.model.FloorMaster floorMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.updateFloorMaster(floorMaster);
	}

	/**
	* Updates the floor master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param floorMaster the floor master
	* @param merge whether to merge the floor master with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the floor master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster updateFloorMaster(
		com.cignexdatamatics.wrm.model.FloorMaster floorMaster, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.updateFloorMaster(floorMaster, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _floorMasterLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_floorMasterLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _floorMasterLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findAllFloor()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.findAllFloor();
	}

	public java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findAllInLocation(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.findAllInLocation(locationId);
	}

	public com.cignexdatamatics.wrm.model.FloorMaster findFloorbyFloorId(
		long floorId)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.findFloorbyFloorId(floorId);
	}

	public com.cignexdatamatics.wrm.model.FloorMaster addFloor(
		com.cignexdatamatics.wrm.model.FloorMaster validfloor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _floorMasterLocalService.addFloor(validfloor);
	}

	public void remove(com.cignexdatamatics.wrm.model.FloorMaster floor)
		throws com.liferay.portal.kernel.exception.SystemException {
		_floorMasterLocalService.remove(floor);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public FloorMasterLocalService getWrappedFloorMasterLocalService() {
		return _floorMasterLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedFloorMasterLocalService(
		FloorMasterLocalService floorMasterLocalService) {
		_floorMasterLocalService = floorMasterLocalService;
	}

	public FloorMasterLocalService getWrappedService() {
		return _floorMasterLocalService;
	}

	public void setWrappedService(
		FloorMasterLocalService floorMasterLocalService) {
		_floorMasterLocalService = floorMasterLocalService;
	}

	private FloorMasterLocalService _floorMasterLocalService;
}