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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the floor master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FloorMasterPersistenceImpl
 * @see FloorMasterUtil
 * @generated
 */
public interface FloorMasterPersistence extends BasePersistence<FloorMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FloorMasterUtil} to access the floor master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the floor master in the entity cache if it is enabled.
	*
	* @param floorMaster the floor master
	*/
	public void cacheResult(
		com.cignexdatamatics.wrm.model.FloorMaster floorMaster);

	/**
	* Caches the floor masters in the entity cache if it is enabled.
	*
	* @param floorMasters the floor masters
	*/
	public void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> floorMasters);

	/**
	* Creates a new floor master with the primary key. Does not add the floor master to the database.
	*
	* @param floorId the primary key for the new floor master
	* @return the new floor master
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster create(long floorId);

	/**
	* Removes the floor master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param floorId the primary key of the floor master
	* @return the floor master that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a floor master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster remove(long floorId)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cignexdatamatics.wrm.model.FloorMaster updateImpl(
		com.cignexdatamatics.wrm.model.FloorMaster floorMaster, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the floor master with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchFloorMasterException} if it could not be found.
	*
	* @param floorId the primary key of the floor master
	* @return the floor master
	* @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a floor master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster findByPrimaryKey(
		long floorId)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the floor master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param floorId the primary key of the floor master
	* @return the floor master, or <code>null</code> if a floor master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster fetchByPrimaryKey(
		long floorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the floor masters where locationId = &#63;.
	*
	* @param locationId the location ID
	* @return the matching floor masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findBylocationId(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findBylocationId(
		long locationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findBylocationId(
		long locationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first floor master in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching floor master
	* @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster findBylocationId_First(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first floor master in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching floor master, or <code>null</code> if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster fetchBylocationId_First(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last floor master in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching floor master
	* @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster findBylocationId_Last(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last floor master in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching floor master, or <code>null</code> if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster fetchBylocationId_Last(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cignexdatamatics.wrm.model.FloorMaster[] findBylocationId_PrevAndNext(
		long floorId, long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the floor master where floorName = &#63; or throws a {@link com.cignexdatamatics.wrm.NoSuchFloorMasterException} if it could not be found.
	*
	* @param floorName the floor name
	* @return the matching floor master
	* @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster findByFloorName(
		java.lang.String floorName)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the floor master where floorName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param floorName the floor name
	* @return the matching floor master, or <code>null</code> if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster fetchByFloorName(
		java.lang.String floorName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the floor master where floorName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param floorName the floor name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching floor master, or <code>null</code> if a matching floor master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster fetchByFloorName(
		java.lang.String floorName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the floor masters.
	*
	* @return the floor masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.FloorMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the floor masters where locationId = &#63; from the database.
	*
	* @param locationId the location ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBylocationId(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the floor master where floorName = &#63; from the database.
	*
	* @param floorName the floor name
	* @return the floor master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.FloorMaster removeByFloorName(
		java.lang.String floorName)
		throws com.cignexdatamatics.wrm.NoSuchFloorMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the floor masters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of floor masters where locationId = &#63;.
	*
	* @param locationId the location ID
	* @return the number of matching floor masters
	* @throws SystemException if a system exception occurred
	*/
	public int countBylocationId(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of floor masters where floorName = &#63;.
	*
	* @param floorName the floor name
	* @return the number of matching floor masters
	* @throws SystemException if a system exception occurred
	*/
	public int countByFloorName(java.lang.String floorName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of floor masters.
	*
	* @return the number of floor masters
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}