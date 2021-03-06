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

package com.cignexdatamatics.wrm.service.persistence;

import com.cignexdatamatics.wrm.model.CityMaster;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the city master service. This utility wraps {@link CityMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CityMasterPersistence
 * @see CityMasterPersistenceImpl
 * @generated
 */
public class CityMasterUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(CityMaster cityMaster) {
		getPersistence().clearCache(cityMaster);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CityMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CityMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CityMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CityMaster update(CityMaster cityMaster, boolean merge)
		throws SystemException {
		return getPersistence().update(cityMaster, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CityMaster update(CityMaster cityMaster, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(cityMaster, merge, serviceContext);
	}

	/**
	* Caches the city master in the entity cache if it is enabled.
	*
	* @param cityMaster the city master
	*/
	public static void cacheResult(
		com.cignexdatamatics.wrm.model.CityMaster cityMaster) {
		getPersistence().cacheResult(cityMaster);
	}

	/**
	* Caches the city masters in the entity cache if it is enabled.
	*
	* @param cityMasters the city masters
	*/
	public static void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.CityMaster> cityMasters) {
		getPersistence().cacheResult(cityMasters);
	}

	/**
	* Creates a new city master with the primary key. Does not add the city master to the database.
	*
	* @param cityId the primary key for the new city master
	* @return the new city master
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster create(long cityId) {
		return getPersistence().create(cityId);
	}

	/**
	* Removes the city master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cityId the primary key of the city master
	* @return the city master that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchCityMasterException if a city master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster remove(long cityId)
		throws com.cignexdatamatics.wrm.NoSuchCityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(cityId);
	}

	public static com.cignexdatamatics.wrm.model.CityMaster updateImpl(
		com.cignexdatamatics.wrm.model.CityMaster cityMaster, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cityMaster, merge);
	}

	/**
	* Returns the city master with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchCityMasterException} if it could not be found.
	*
	* @param cityId the primary key of the city master
	* @return the city master
	* @throws com.cignexdatamatics.wrm.NoSuchCityMasterException if a city master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster findByPrimaryKey(
		long cityId)
		throws com.cignexdatamatics.wrm.NoSuchCityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(cityId);
	}

	/**
	* Returns the city master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cityId the primary key of the city master
	* @return the city master, or <code>null</code> if a city master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster fetchByPrimaryKey(
		long cityId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(cityId);
	}

	/**
	* Returns the city master where cityName = &#63; or throws a {@link com.cignexdatamatics.wrm.NoSuchCityMasterException} if it could not be found.
	*
	* @param cityName the city name
	* @return the matching city master
	* @throws com.cignexdatamatics.wrm.NoSuchCityMasterException if a matching city master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster findByCityName(
		java.lang.String cityName)
		throws com.cignexdatamatics.wrm.NoSuchCityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCityName(cityName);
	}

	/**
	* Returns the city master where cityName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cityName the city name
	* @return the matching city master, or <code>null</code> if a matching city master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster fetchByCityName(
		java.lang.String cityName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCityName(cityName);
	}

	/**
	* Returns the city master where cityName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cityName the city name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching city master, or <code>null</code> if a matching city master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster fetchByCityName(
		java.lang.String cityName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCityName(cityName, retrieveFromCache);
	}

	/**
	* Returns all the city masters.
	*
	* @return the city masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.CityMaster> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.cignexdatamatics.wrm.model.CityMaster> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the city masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of city masters
	* @param end the upper bound of the range of city masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of city masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.CityMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the city master where cityName = &#63; from the database.
	*
	* @param cityName the city name
	* @return the city master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.CityMaster removeByCityName(
		java.lang.String cityName)
		throws com.cignexdatamatics.wrm.NoSuchCityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCityName(cityName);
	}

	/**
	* Removes all the city masters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of city masters where cityName = &#63;.
	*
	* @param cityName the city name
	* @return the number of matching city masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCityName(java.lang.String cityName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCityName(cityName);
	}

	/**
	* Returns the number of city masters.
	*
	* @return the number of city masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CityMasterPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CityMasterPersistence)PortletBeanLocatorUtil.locate(com.cignexdatamatics.wrm.service.ClpSerializer.getServletContextName(),
					CityMasterPersistence.class.getName());

			ReferenceRegistry.registerReference(CityMasterUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CityMasterPersistence persistence) {
	}

	private static CityMasterPersistence _persistence;
}