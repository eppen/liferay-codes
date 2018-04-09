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
 * The utility for the location master local service. This utility wraps {@link com.cignexdatamatics.wrm.service.impl.LocationMasterLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocationMasterLocalService
 * @see com.cignexdatamatics.wrm.service.base.LocationMasterLocalServiceBaseImpl
 * @see com.cignexdatamatics.wrm.service.impl.LocationMasterLocalServiceImpl
 * @generated
 */
public class LocationMasterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cignexdatamatics.wrm.service.impl.LocationMasterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the location master to the database. Also notifies the appropriate model listeners.
	*
	* @param locationMaster the location master
	* @return the location master that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster addLocationMaster(
		com.cignexdatamatics.wrm.model.LocationMaster locationMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLocationMaster(locationMaster);
	}

	/**
	* Creates a new location master with the primary key. Does not add the location master to the database.
	*
	* @param locationId the primary key for the new location master
	* @return the new location master
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster createLocationMaster(
		long locationId) {
		return getService().createLocationMaster(locationId);
	}

	/**
	* Deletes the location master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the location master
	* @return the location master that was removed
	* @throws PortalException if a location master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster deleteLocationMaster(
		long locationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLocationMaster(locationId);
	}

	/**
	* Deletes the location master from the database. Also notifies the appropriate model listeners.
	*
	* @param locationMaster the location master
	* @return the location master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster deleteLocationMaster(
		com.cignexdatamatics.wrm.model.LocationMaster locationMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLocationMaster(locationMaster);
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

	public static com.cignexdatamatics.wrm.model.LocationMaster fetchLocationMaster(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLocationMaster(locationId);
	}

	/**
	* Returns the location master with the primary key.
	*
	* @param locationId the primary key of the location master
	* @return the location master
	* @throws PortalException if a location master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster getLocationMaster(
		long locationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocationMaster(locationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the location masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of location masters
	* @param end the upper bound of the range of location masters (not inclusive)
	* @return the range of location masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> getLocationMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocationMasters(start, end);
	}

	/**
	* Returns the number of location masters.
	*
	* @return the number of location masters
	* @throws SystemException if a system exception occurred
	*/
	public static int getLocationMastersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocationMastersCount();
	}

	/**
	* Updates the location master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param locationMaster the location master
	* @return the location master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster updateLocationMaster(
		com.cignexdatamatics.wrm.model.LocationMaster locationMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLocationMaster(locationMaster);
	}

	/**
	* Updates the location master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param locationMaster the location master
	* @param merge whether to merge the location master with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the location master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster updateLocationMaster(
		com.cignexdatamatics.wrm.model.LocationMaster locationMaster,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLocationMaster(locationMaster, merge);
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

	public static java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findAllInCity(
		long cityId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInCity(cityId);
	}

	public static java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findAllbyLocationName(
		long cityId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllbyLocationName(cityId);
	}

	public static com.cignexdatamatics.wrm.model.LocationMaster findAllbyLocationName(
		java.lang.String locationname)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllbyLocationName(locationname);
	}

	public static java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findAllLocation()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllLocation();
	}

	public static com.cignexdatamatics.wrm.model.LocationMaster findLocationbyLocationId(
		long locationId)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findLocationbyLocationId(locationId);
	}

	public static com.cignexdatamatics.wrm.model.LocationMaster addLocation(
		com.cignexdatamatics.wrm.model.LocationMaster validLocation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLocation(validLocation);
	}

	public static void remove(
		com.cignexdatamatics.wrm.model.LocationMaster location)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().remove(location);
	}

	public static void clearService() {
		_service = null;
	}

	public static LocationMasterLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LocationMasterLocalService.class.getName());

			if (invokableLocalService instanceof LocationMasterLocalService) {
				_service = (LocationMasterLocalService)invokableLocalService;
			}
			else {
				_service = new LocationMasterLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LocationMasterLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(LocationMasterLocalService service) {
	}

	private static LocationMasterLocalService _service;
}