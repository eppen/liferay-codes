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
 * The utility for the city master local service. This utility wraps {@link com.cignexdatamatics.wrm.service.impl.CityMasterLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CityMasterLocalService
 * @see com.cignexdatamatics.wrm.service.base.CityMasterLocalServiceBaseImpl
 * @see com.cignexdatamatics.wrm.service.impl.CityMasterLocalServiceImpl
 * @generated
 */
public class CityMasterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cignexdatamatics.wrm.service.impl.CityMasterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the city master to the database. Also notifies the appropriate model listeners.
	*
	* @param cityMaster the city master
	* @return the city master that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster addCityMaster(
		com.cignexdatamatics.wrm.model.CityMaster cityMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCityMaster(cityMaster);
	}

	/**
	* Creates a new city master with the primary key. Does not add the city master to the database.
	*
	* @param cityId the primary key for the new city master
	* @return the new city master
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster createCityMaster(
		long cityId) {
		return getService().createCityMaster(cityId);
	}

	/**
	* Deletes the city master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cityId the primary key of the city master
	* @return the city master that was removed
	* @throws PortalException if a city master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster deleteCityMaster(
		long cityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCityMaster(cityId);
	}

	/**
	* Deletes the city master from the database. Also notifies the appropriate model listeners.
	*
	* @param cityMaster the city master
	* @return the city master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster deleteCityMaster(
		com.cignexdatamatics.wrm.model.CityMaster cityMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCityMaster(cityMaster);
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

	public static com.cignexdatamatics.wrm.model.CityMaster fetchCityMaster(
		long cityId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCityMaster(cityId);
	}

	/**
	* Returns the city master with the primary key.
	*
	* @param cityId the primary key of the city master
	* @return the city master
	* @throws PortalException if a city master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster getCityMaster(
		long cityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCityMaster(cityId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.cignexdatamatics.wrm.model.CityMaster> getCityMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCityMasters(start, end);
	}

	/**
	* Returns the number of city masters.
	*
	* @return the number of city masters
	* @throws SystemException if a system exception occurred
	*/
	public static int getCityMastersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCityMastersCount();
	}

	/**
	* Updates the city master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cityMaster the city master
	* @return the city master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster updateCityMaster(
		com.cignexdatamatics.wrm.model.CityMaster cityMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCityMaster(cityMaster);
	}

	/**
	* Updates the city master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cityMaster the city master
	* @param merge whether to merge the city master with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the city master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster updateCityMaster(
		com.cignexdatamatics.wrm.model.CityMaster cityMaster, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCityMaster(cityMaster, merge);
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

	public static java.util.List<com.cignexdatamatics.wrm.model.CityMaster> findAllInCity()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInCity();
	}

	public static com.cignexdatamatics.wrm.model.CityMaster findbyCityName(
		java.lang.String name)
		throws com.cignexdatamatics.wrm.NoSuchCityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findbyCityName(name);
	}

	public static com.cignexdatamatics.wrm.model.CityMaster findCitybyCityId(
		long cityId)
		throws com.cignexdatamatics.wrm.NoSuchCityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findCitybyCityId(cityId);
	}

	public static com.cignexdatamatics.wrm.model.CityMaster addCity(
		com.cignexdatamatics.wrm.model.CityMaster validCity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCity(validCity);
	}

	public static void remove(com.cignexdatamatics.wrm.model.CityMaster city)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().remove(city);
	}

	public static void clearService() {
		_service = null;
	}

	public static CityMasterLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CityMasterLocalService.class.getName());

			if (invokableLocalService instanceof CityMasterLocalService) {
				_service = (CityMasterLocalService)invokableLocalService;
			}
			else {
				_service = new CityMasterLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CityMasterLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CityMasterLocalService service) {
	}

	private static CityMasterLocalService _service;
}