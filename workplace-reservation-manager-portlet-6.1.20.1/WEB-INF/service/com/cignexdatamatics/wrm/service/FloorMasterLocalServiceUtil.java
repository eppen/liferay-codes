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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the floor master local service. This utility wraps {@link com.cignexdatamatics.wrm.service.impl.FloorMasterLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FloorMasterLocalService
 * @see com.cignexdatamatics.wrm.service.base.FloorMasterLocalServiceBaseImpl
 * @see com.cignexdatamatics.wrm.service.impl.FloorMasterLocalServiceImpl
 * @generated
 */
public class FloorMasterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cignexdatamatics.wrm.service.impl.FloorMasterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the floor master to the database. Also notifies the appropriate model listeners.
	*
	* @param floorMaster the floor master
	* @return the floor master that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster addFloorMaster(
		com.cignexdatamatics.wrm.model.FloorMaster floorMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFloorMaster(floorMaster);
	}

	/**
	* Creates a new floor master with the primary key. Does not add the floor master to the database.
	*
	* @param floorId the primary key for the new floor master
	* @return the new floor master
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster createFloorMaster(
		long floorId) {
		return getService().createFloorMaster(floorId);
	}

	/**
	* Deletes the floor master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param floorId the primary key of the floor master
	* @return the floor master that was removed
	* @throws PortalException if a floor master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster deleteFloorMaster(
		long floorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFloorMaster(floorId);
	}

	/**
	* Deletes the floor master from the database. Also notifies the appropriate model listeners.
	*
	* @param floorMaster the floor master
	* @return the floor master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster deleteFloorMaster(
		com.cignexdatamatics.wrm.model.FloorMaster floorMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFloorMaster(floorMaster);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.cignexdatamatics.wrm.model.FloorMaster fetchFloorMaster(
		long floorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFloorMaster(floorId);
	}

	/**
	* Returns the floor master with the primary key.
	*
	* @param floorId the primary key of the floor master
	* @return the floor master
	* @throws PortalException if a floor master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster getFloorMaster(
		long floorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFloorMaster(floorId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> getFloorMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFloorMasters(start, end);
	}

	/**
	* Returns the number of floor masters.
	*
	* @return the number of floor masters
	* @throws SystemException if a system exception occurred
	*/
	public static int getFloorMastersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFloorMastersCount();
	}

	/**
	* Updates the floor master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param floorMaster the floor master
	* @return the floor master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster updateFloorMaster(
		com.cignexdatamatics.wrm.model.FloorMaster floorMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFloorMaster(floorMaster);
	}

	/**
	* Updates the floor master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param floorMaster the floor master
	* @param merge whether to merge the floor master with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the floor master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster updateFloorMaster(
		com.cignexdatamatics.wrm.model.FloorMaster floorMaster, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFloorMaster(floorMaster, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findAllFloor()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllFloor();
	}

	public static java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findAllInLocation(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInLocation(locationId);
	}

	public static com.cignexdatamatics.wrm.model.FloorMaster findFloorbyFloorId(
		long floorId)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findFloorbyFloorId(floorId);
	}

	public static com.cignexdatamatics.wrm.model.FloorMaster addFloor(
		com.cignexdatamatics.wrm.model.FloorMaster validfloor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFloor(validfloor);
	}

	public static void remove(com.cignexdatamatics.wrm.model.FloorMaster floor)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().remove(floor);
	}

	public static void clearService() {
		_service = null;
	}

	public static FloorMasterLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FloorMasterLocalService.class.getName());

			if (invokableLocalService instanceof FloorMasterLocalService) {
				_service = (FloorMasterLocalService)invokableLocalService;
			}
			else {
				_service = new FloorMasterLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FloorMasterLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(FloorMasterLocalService service) {
	}

	private static FloorMasterLocalService _service;
}