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

import com.cignexdatamatics.wrm.model.LocationMaster;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the location master service. This utility wraps {@link LocationMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocationMasterPersistence
 * @see LocationMasterPersistenceImpl
 * @generated
 */
public class LocationMasterUtil {
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
	public static void clearCache(LocationMaster locationMaster) {
		getPersistence().clearCache(locationMaster);
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
	public static List<LocationMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LocationMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LocationMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LocationMaster update(LocationMaster locationMaster,
		boolean merge) throws SystemException {
		return getPersistence().update(locationMaster, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LocationMaster update(LocationMaster locationMaster,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(locationMaster, merge, serviceContext);
	}

	/**
	* Caches the location master in the entity cache if it is enabled.
	*
	* @param locationMaster the location master
	*/
	public static void cacheResult(
		com.cignexdatamatics.wrm.model.LocationMaster locationMaster) {
		getPersistence().cacheResult(locationMaster);
	}

	/**
	* Caches the location masters in the entity cache if it is enabled.
	*
	* @param locationMasters the location masters
	*/
	public static void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> locationMasters) {
		getPersistence().cacheResult(locationMasters);
	}

	/**
	* Creates a new location master with the primary key. Does not add the location master to the database.
	*
	* @param locationId the primary key for the new location master
	* @return the new location master
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster create(
		long locationId) {
		return getPersistence().create(locationId);
	}

	/**
	* Removes the location master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the location master
	* @return the location master that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a location master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster remove(
		long locationId)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(locationId);
	}

	public static com.cignexdatamatics.wrm.model.LocationMaster updateImpl(
		com.cignexdatamatics.wrm.model.LocationMaster locationMaster,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(locationMaster, merge);
	}

	/**
	* Returns the location master with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchLocationMasterException} if it could not be found.
	*
	* @param locationId the primary key of the location master
	* @return the location master
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a location master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster findByPrimaryKey(
		long locationId)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(locationId);
	}

	/**
	* Returns the location master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param locationId the primary key of the location master
	* @return the location master, or <code>null</code> if a location master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster fetchByPrimaryKey(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(locationId);
	}

	/**
	* Returns all the location masters where cityId = &#63;.
	*
	* @param cityId the city ID
	* @return the matching location masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findByCityId(
		long cityId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCityId(cityId);
	}

	/**
	* Returns a range of all the location masters where cityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cityId the city ID
	* @param start the lower bound of the range of location masters
	* @param end the upper bound of the range of location masters (not inclusive)
	* @return the range of matching location masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findByCityId(
		long cityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCityId(cityId, start, end);
	}

	/**
	* Returns an ordered range of all the location masters where cityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cityId the city ID
	* @param start the lower bound of the range of location masters
	* @param end the upper bound of the range of location masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching location masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findByCityId(
		long cityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCityId(cityId, start, end, orderByComparator);
	}

	/**
	* Returns the first location master in the ordered set where cityId = &#63;.
	*
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location master
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster findByCityId_First(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCityId_First(cityId, orderByComparator);
	}

	/**
	* Returns the first location master in the ordered set where cityId = &#63;.
	*
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location master, or <code>null</code> if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster fetchByCityId_First(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCityId_First(cityId, orderByComparator);
	}

	/**
	* Returns the last location master in the ordered set where cityId = &#63;.
	*
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location master
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster findByCityId_Last(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCityId_Last(cityId, orderByComparator);
	}

	/**
	* Returns the last location master in the ordered set where cityId = &#63;.
	*
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location master, or <code>null</code> if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster fetchByCityId_Last(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCityId_Last(cityId, orderByComparator);
	}

	/**
	* Returns the location masters before and after the current location master in the ordered set where cityId = &#63;.
	*
	* @param locationId the primary key of the current location master
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next location master
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a location master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster[] findByCityId_PrevAndNext(
		long locationId, long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCityId_PrevAndNext(locationId, cityId,
			orderByComparator);
	}

	/**
	* Returns all the location masters where locationName = &#63;.
	*
	* @param locationName the location name
	* @return the matching location masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findByLocationName(
		java.lang.String locationName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocationName(locationName);
	}

	/**
	* Returns a range of all the location masters where locationName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param locationName the location name
	* @param start the lower bound of the range of location masters
	* @param end the upper bound of the range of location masters (not inclusive)
	* @return the range of matching location masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findByLocationName(
		java.lang.String locationName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocationName(locationName, start, end);
	}

	/**
	* Returns an ordered range of all the location masters where locationName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param locationName the location name
	* @param start the lower bound of the range of location masters
	* @param end the upper bound of the range of location masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching location masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findByLocationName(
		java.lang.String locationName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocationName(locationName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first location master in the ordered set where locationName = &#63;.
	*
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location master
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster findByLocationName_First(
		java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocationName_First(locationName, orderByComparator);
	}

	/**
	* Returns the first location master in the ordered set where locationName = &#63;.
	*
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location master, or <code>null</code> if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster fetchByLocationName_First(
		java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocationName_First(locationName, orderByComparator);
	}

	/**
	* Returns the last location master in the ordered set where locationName = &#63;.
	*
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location master
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster findByLocationName_Last(
		java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocationName_Last(locationName, orderByComparator);
	}

	/**
	* Returns the last location master in the ordered set where locationName = &#63;.
	*
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location master, or <code>null</code> if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster fetchByLocationName_Last(
		java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocationName_Last(locationName, orderByComparator);
	}

	/**
	* Returns the location masters before and after the current location master in the ordered set where locationName = &#63;.
	*
	* @param locationId the primary key of the current location master
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next location master
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a location master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.LocationMaster[] findByLocationName_PrevAndNext(
		long locationId, java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocationName_PrevAndNext(locationId, locationName,
			orderByComparator);
	}

	/**
	* Returns all the location masters.
	*
	* @return the location masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the location masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of location masters
	* @param end the upper bound of the range of location masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of location masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the location masters where cityId = &#63; from the database.
	*
	* @param cityId the city ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCityId(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCityId(cityId);
	}

	/**
	* Removes all the location masters where locationName = &#63; from the database.
	*
	* @param locationName the location name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLocationName(java.lang.String locationName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLocationName(locationName);
	}

	/**
	* Removes all the location masters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of location masters where cityId = &#63;.
	*
	* @param cityId the city ID
	* @return the number of matching location masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCityId(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCityId(cityId);
	}

	/**
	* Returns the number of location masters where locationName = &#63;.
	*
	* @param locationName the location name
	* @return the number of matching location masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLocationName(java.lang.String locationName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLocationName(locationName);
	}

	/**
	* Returns the number of location masters.
	*
	* @return the number of location masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LocationMasterPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LocationMasterPersistence)PortletBeanLocatorUtil.locate(com.cignexdatamatics.wrm.service.ClpSerializer.getServletContextName(),
					LocationMasterPersistence.class.getName());

			ReferenceRegistry.registerReference(LocationMasterUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(LocationMasterPersistence persistence) {
	}

	private static LocationMasterPersistence _persistence;
}