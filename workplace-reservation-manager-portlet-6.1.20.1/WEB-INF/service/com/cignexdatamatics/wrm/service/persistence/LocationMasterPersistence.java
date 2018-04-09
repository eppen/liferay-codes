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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the location master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocationMasterPersistenceImpl
 * @see LocationMasterUtil
 * @generated
 */
public interface LocationMasterPersistence extends BasePersistence<LocationMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LocationMasterUtil} to access the location master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the location master in the entity cache if it is enabled.
	*
	* @param locationMaster the location master
	*/
	public void cacheResult(
		com.cignexdatamatics.wrm.model.LocationMaster locationMaster);

	/**
	* Caches the location masters in the entity cache if it is enabled.
	*
	* @param locationMasters the location masters
	*/
	public void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> locationMasters);

	/**
	* Creates a new location master with the primary key. Does not add the location master to the database.
	*
	* @param locationId the primary key for the new location master
	* @return the new location master
	*/
	public com.cignexdatamatics.wrm.model.LocationMaster create(long locationId);

	/**
	* Removes the location master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the location master
	* @return the location master that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a location master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.LocationMaster remove(long locationId)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cignexdatamatics.wrm.model.LocationMaster updateImpl(
		com.cignexdatamatics.wrm.model.LocationMaster locationMaster,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the location master with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchLocationMasterException} if it could not be found.
	*
	* @param locationId the primary key of the location master
	* @return the location master
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a location master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.LocationMaster findByPrimaryKey(
		long locationId)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the location master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param locationId the primary key of the location master
	* @return the location master, or <code>null</code> if a location master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.LocationMaster fetchByPrimaryKey(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the location masters where cityId = &#63;.
	*
	* @param cityId the city ID
	* @return the matching location masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findByCityId(
		long cityId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findByCityId(
		long cityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findByCityId(
		long cityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first location master in the ordered set where cityId = &#63;.
	*
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location master
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.LocationMaster findByCityId_First(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first location master in the ordered set where cityId = &#63;.
	*
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location master, or <code>null</code> if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.LocationMaster fetchByCityId_First(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last location master in the ordered set where cityId = &#63;.
	*
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location master
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.LocationMaster findByCityId_Last(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last location master in the ordered set where cityId = &#63;.
	*
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location master, or <code>null</code> if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.LocationMaster fetchByCityId_Last(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cignexdatamatics.wrm.model.LocationMaster[] findByCityId_PrevAndNext(
		long locationId, long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the location masters where locationName = &#63;.
	*
	* @param locationName the location name
	* @return the matching location masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findByLocationName(
		java.lang.String locationName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findByLocationName(
		java.lang.String locationName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findByLocationName(
		java.lang.String locationName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first location master in the ordered set where locationName = &#63;.
	*
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location master
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.LocationMaster findByLocationName_First(
		java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first location master in the ordered set where locationName = &#63;.
	*
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location master, or <code>null</code> if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.LocationMaster fetchByLocationName_First(
		java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last location master in the ordered set where locationName = &#63;.
	*
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location master
	* @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.LocationMaster findByLocationName_Last(
		java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last location master in the ordered set where locationName = &#63;.
	*
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location master, or <code>null</code> if a matching location master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.LocationMaster fetchByLocationName_Last(
		java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cignexdatamatics.wrm.model.LocationMaster[] findByLocationName_PrevAndNext(
		long locationId, java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchLocationMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the location masters.
	*
	* @return the location masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.LocationMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the location masters where cityId = &#63; from the database.
	*
	* @param cityId the city ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCityId(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the location masters where locationName = &#63; from the database.
	*
	* @param locationName the location name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLocationName(java.lang.String locationName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the location masters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of location masters where cityId = &#63;.
	*
	* @param cityId the city ID
	* @return the number of matching location masters
	* @throws SystemException if a system exception occurred
	*/
	public int countByCityId(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of location masters where locationName = &#63;.
	*
	* @param locationName the location name
	* @return the number of matching location masters
	* @throws SystemException if a system exception occurred
	*/
	public int countByLocationName(java.lang.String locationName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of location masters.
	*
	* @return the number of location masters
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}