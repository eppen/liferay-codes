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

import com.cignexdatamatics.wrm.model.FloorMaster;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the floor master service. This utility wraps {@link FloorMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FloorMasterPersistence
 * @see FloorMasterPersistenceImpl
 * @generated
 */
public class FloorMasterUtil {
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
	public static void clearCache(FloorMaster floorMaster) {
		getPersistence().clearCache(floorMaster);
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
	public static List<FloorMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FloorMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FloorMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static FloorMaster update(FloorMaster floorMaster, boolean merge)
		throws SystemException {
		return getPersistence().update(floorMaster, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static FloorMaster update(FloorMaster floorMaster, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(floorMaster, merge, serviceContext);
	}

	/**
	* Caches the floor master in the entity cache if it is enabled.
	*
	* @param floorMaster the floor master
	*/
	public static void cacheResult(
		com.cignexdatamatics.wrm.model.FloorMaster floorMaster) {
		getPersistence().cacheResult(floorMaster);
	}

	/**
	* Caches the floor masters in the entity cache if it is enabled.
	*
	* @param floorMasters the floor masters
	*/
	public static void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> floorMasters) {
		getPersistence().cacheResult(floorMasters);
	}

	/**
	* Creates a new floor master with the primary key. Does not add the floor master to the database.
	*
	* @param floorId the primary key for the new floor master
	* @return the new floor master
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster create(
		long floorId) {
		return getPersistence().create(floorId);
	}

	/**
	* Removes the floor master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param floorId the primary key of the floor master
	* @return the floor master that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a floor master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster remove(
		long floorId)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(floorId);
	}

	public static com.cignexdatamatics.wrm.model.FloorMaster updateImpl(
		com.cignexdatamatics.wrm.model.FloorMaster floorMaster, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(floorMaster, merge);
	}

	/**
	* Returns the floor master with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchFloorMasterException} if it could not be found.
	*
	* @param floorId the primary key of the floor master
	* @return the floor master
	* @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a floor master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster findByPrimaryKey(
		long floorId)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(floorId);
	}

	/**
	* Returns the floor master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param floorId the primary key of the floor master
	* @return the floor master, or <code>null</code> if a floor master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster fetchByPrimaryKey(
		long floorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(floorId);
	}

	/**
	* Returns all the floor masters where locationId = &#63;.
	*
	* @param locationId the location ID
	* @return the matching floor masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findBylocationId(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylocationId(locationId);
	}

	/**
	* Returns a range of all the floor masters where locationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param locationId the location ID
	* @param start the lower bound of the range of floor masters
	* @param end the upper bound of the range of floor masters (not inclusive)
	* @return the range of matching floor masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findBylocationId(
		long locationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylocationId(locationId, start, end);
	}

	/**
	* Returns an ordered range of all the floor masters where locationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param locationId the location ID
	* @param start the lower bound of the range of floor masters
	* @param end the upper bound of the range of floor masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching floor masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findBylocationId(
		long locationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBylocationId(locationId, start, end, orderByComparator);
	}

	/**
	* Returns the first floor master in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching floor master
	* @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster findBylocationId_First(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBylocationId_First(locationId, orderByComparator);
	}

	/**
	* Returns the first floor master in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching floor master, or <code>null</code> if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster fetchBylocationId_First(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylocationId_First(locationId, orderByComparator);
	}

	/**
	* Returns the last floor master in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching floor master
	* @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster findBylocationId_Last(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBylocationId_Last(locationId, orderByComparator);
	}

	/**
	* Returns the last floor master in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching floor master, or <code>null</code> if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster fetchBylocationId_Last(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylocationId_Last(locationId, orderByComparator);
	}

	/**
	* Returns the floor masters before and after the current floor master in the ordered set where locationId = &#63;.
	*
	* @param floorId the primary key of the current floor master
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next floor master
	* @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a floor master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster[] findBylocationId_PrevAndNext(
		long floorId, long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBylocationId_PrevAndNext(floorId, locationId,
			orderByComparator);
	}

	/**
	* Returns the floor master where floorName = &#63; or throws a {@link com.cignexdatamatics.wrm.NoSuchFloorMasterException} if it could not be found.
	*
	* @param floorName the floor name
	* @return the matching floor master
	* @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster findByFloorName(
		java.lang.String floorName)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFloorName(floorName);
	}

	/**
	* Returns the floor master where floorName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param floorName the floor name
	* @return the matching floor master, or <code>null</code> if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster fetchByFloorName(
		java.lang.String floorName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFloorName(floorName);
	}

	/**
	* Returns the floor master where floorName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param floorName the floor name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching floor master, or <code>null</code> if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster fetchByFloorName(
		java.lang.String floorName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFloorName(floorName, retrieveFromCache);
	}

	/**
	* Returns all the floor masters.
	*
	* @return the floor masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the floor masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of floor masters
	* @param end the upper bound of the range of floor masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of floor masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the floor masters where locationId = &#63; from the database.
	*
	* @param locationId the location ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBylocationId(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBylocationId(locationId);
	}

	/**
	* Removes the floor master where floorName = &#63; from the database.
	*
	* @param floorName the floor name
	* @return the floor master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FloorMaster removeByFloorName(
		java.lang.String floorName)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByFloorName(floorName);
	}

	/**
	* Removes all the floor masters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of floor masters where locationId = &#63;.
	*
	* @param locationId the location ID
	* @return the number of matching floor masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countBylocationId(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBylocationId(locationId);
	}

	/**
	* Returns the number of floor masters where floorName = &#63;.
	*
	* @param floorName the floor name
	* @return the number of matching floor masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFloorName(java.lang.String floorName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFloorName(floorName);
	}

	/**
	* Returns the number of floor masters.
	*
	* @return the number of floor masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FloorMasterPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FloorMasterPersistence)PortletBeanLocatorUtil.locate(com.cignexdatamatics.wrm.service.ClpSerializer.getServletContextName(),
					FloorMasterPersistence.class.getName());

			ReferenceRegistry.registerReference(FloorMasterUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(FloorMasterPersistence persistence) {
	}

	private static FloorMasterPersistence _persistence;
}