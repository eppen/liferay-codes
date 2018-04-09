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

import com.cignexdatamatics.wrm.model.RoomMaster;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the room master service. This utility wraps {@link RoomMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomMasterPersistence
 * @see RoomMasterPersistenceImpl
 * @generated
 */
public class RoomMasterUtil {
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
	public static void clearCache(RoomMaster roomMaster) {
		getPersistence().clearCache(roomMaster);
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
	public static List<RoomMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RoomMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RoomMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static RoomMaster update(RoomMaster roomMaster, boolean merge)
		throws SystemException {
		return getPersistence().update(roomMaster, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static RoomMaster update(RoomMaster roomMaster, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(roomMaster, merge, serviceContext);
	}

	/**
	* Caches the room master in the entity cache if it is enabled.
	*
	* @param roomMaster the room master
	*/
	public static void cacheResult(
		com.cignexdatamatics.wrm.model.RoomMaster roomMaster) {
		getPersistence().cacheResult(roomMaster);
	}

	/**
	* Caches the room masters in the entity cache if it is enabled.
	*
	* @param roomMasters the room masters
	*/
	public static void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> roomMasters) {
		getPersistence().cacheResult(roomMasters);
	}

	/**
	* Creates a new room master with the primary key. Does not add the room master to the database.
	*
	* @param roomId the primary key for the new room master
	* @return the new room master
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster create(long roomId) {
		return getPersistence().create(roomId);
	}

	/**
	* Removes the room master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roomId the primary key of the room master
	* @return the room master that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster remove(long roomId)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(roomId);
	}

	public static com.cignexdatamatics.wrm.model.RoomMaster updateImpl(
		com.cignexdatamatics.wrm.model.RoomMaster roomMaster, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(roomMaster, merge);
	}

	/**
	* Returns the room master with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchRoomMasterException} if it could not be found.
	*
	* @param roomId the primary key of the room master
	* @return the room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster findByPrimaryKey(
		long roomId)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(roomId);
	}

	/**
	* Returns the room master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param roomId the primary key of the room master
	* @return the room master, or <code>null</code> if a room master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster fetchByPrimaryKey(
		long roomId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(roomId);
	}

	/**
	* Returns all the room masters where cityId = &#63;.
	*
	* @param cityId the city ID
	* @return the matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByCityId(
		long cityId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCityId(cityId);
	}

	/**
	* Returns a range of all the room masters where cityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cityId the city ID
	* @param start the lower bound of the range of room masters
	* @param end the upper bound of the range of room masters (not inclusive)
	* @return the range of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByCityId(
		long cityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCityId(cityId, start, end);
	}

	/**
	* Returns an ordered range of all the room masters where cityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cityId the city ID
	* @param start the lower bound of the range of room masters
	* @param end the upper bound of the range of room masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByCityId(
		long cityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCityId(cityId, start, end, orderByComparator);
	}

	/**
	* Returns the first room master in the ordered set where cityId = &#63;.
	*
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster findByCityId_First(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCityId_First(cityId, orderByComparator);
	}

	/**
	* Returns the first room master in the ordered set where cityId = &#63;.
	*
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room master, or <code>null</code> if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster fetchByCityId_First(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCityId_First(cityId, orderByComparator);
	}

	/**
	* Returns the last room master in the ordered set where cityId = &#63;.
	*
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster findByCityId_Last(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCityId_Last(cityId, orderByComparator);
	}

	/**
	* Returns the last room master in the ordered set where cityId = &#63;.
	*
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room master, or <code>null</code> if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster fetchByCityId_Last(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCityId_Last(cityId, orderByComparator);
	}

	/**
	* Returns the room masters before and after the current room master in the ordered set where cityId = &#63;.
	*
	* @param roomId the primary key of the current room master
	* @param cityId the city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster[] findByCityId_PrevAndNext(
		long roomId, long cityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCityId_PrevAndNext(roomId, cityId, orderByComparator);
	}

	/**
	* Returns all the room masters where locationId = &#63;.
	*
	* @param locationId the location ID
	* @return the matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByLocationId(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocationId(locationId);
	}

	/**
	* Returns a range of all the room masters where locationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param locationId the location ID
	* @param start the lower bound of the range of room masters
	* @param end the upper bound of the range of room masters (not inclusive)
	* @return the range of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByLocationId(
		long locationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocationId(locationId, start, end);
	}

	/**
	* Returns an ordered range of all the room masters where locationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param locationId the location ID
	* @param start the lower bound of the range of room masters
	* @param end the upper bound of the range of room masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByLocationId(
		long locationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocationId(locationId, start, end, orderByComparator);
	}

	/**
	* Returns the first room master in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster findByLocationId_First(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocationId_First(locationId, orderByComparator);
	}

	/**
	* Returns the first room master in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room master, or <code>null</code> if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster fetchByLocationId_First(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocationId_First(locationId, orderByComparator);
	}

	/**
	* Returns the last room master in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster findByLocationId_Last(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocationId_Last(locationId, orderByComparator);
	}

	/**
	* Returns the last room master in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room master, or <code>null</code> if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster fetchByLocationId_Last(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocationId_Last(locationId, orderByComparator);
	}

	/**
	* Returns the room masters before and after the current room master in the ordered set where locationId = &#63;.
	*
	* @param roomId the primary key of the current room master
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster[] findByLocationId_PrevAndNext(
		long roomId, long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocationId_PrevAndNext(roomId, locationId,
			orderByComparator);
	}

	/**
	* Returns all the room masters where floorId = &#63;.
	*
	* @param floorId the floor ID
	* @return the matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByFloorId(
		long floorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFloorId(floorId);
	}

	/**
	* Returns a range of all the room masters where floorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param floorId the floor ID
	* @param start the lower bound of the range of room masters
	* @param end the upper bound of the range of room masters (not inclusive)
	* @return the range of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByFloorId(
		long floorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFloorId(floorId, start, end);
	}

	/**
	* Returns an ordered range of all the room masters where floorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param floorId the floor ID
	* @param start the lower bound of the range of room masters
	* @param end the upper bound of the range of room masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByFloorId(
		long floorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFloorId(floorId, start, end, orderByComparator);
	}

	/**
	* Returns the first room master in the ordered set where floorId = &#63;.
	*
	* @param floorId the floor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster findByFloorId_First(
		long floorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFloorId_First(floorId, orderByComparator);
	}

	/**
	* Returns the first room master in the ordered set where floorId = &#63;.
	*
	* @param floorId the floor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room master, or <code>null</code> if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster fetchByFloorId_First(
		long floorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFloorId_First(floorId, orderByComparator);
	}

	/**
	* Returns the last room master in the ordered set where floorId = &#63;.
	*
	* @param floorId the floor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster findByFloorId_Last(
		long floorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFloorId_Last(floorId, orderByComparator);
	}

	/**
	* Returns the last room master in the ordered set where floorId = &#63;.
	*
	* @param floorId the floor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room master, or <code>null</code> if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster fetchByFloorId_Last(
		long floorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFloorId_Last(floorId, orderByComparator);
	}

	/**
	* Returns the room masters before and after the current room master in the ordered set where floorId = &#63;.
	*
	* @param roomId the primary key of the current room master
	* @param floorId the floor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster[] findByFloorId_PrevAndNext(
		long roomId, long floorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFloorId_PrevAndNext(roomId, floorId, orderByComparator);
	}

	/**
	* Returns all the room masters where cityId = &#63; and locationId = &#63;.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @return the matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByRoomByLocandCity(
		long cityId, long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoomByLocandCity(cityId, locationId);
	}

	/**
	* Returns a range of all the room masters where cityId = &#63; and locationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param start the lower bound of the range of room masters
	* @param end the upper bound of the range of room masters (not inclusive)
	* @return the range of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByRoomByLocandCity(
		long cityId, long locationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomByLocandCity(cityId, locationId, start, end);
	}

	/**
	* Returns an ordered range of all the room masters where cityId = &#63; and locationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param start the lower bound of the range of room masters
	* @param end the upper bound of the range of room masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByRoomByLocandCity(
		long cityId, long locationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomByLocandCity(cityId, locationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first room master in the ordered set where cityId = &#63; and locationId = &#63;.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster findByRoomByLocandCity_First(
		long cityId, long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomByLocandCity_First(cityId, locationId,
			orderByComparator);
	}

	/**
	* Returns the first room master in the ordered set where cityId = &#63; and locationId = &#63;.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room master, or <code>null</code> if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster fetchByRoomByLocandCity_First(
		long cityId, long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoomByLocandCity_First(cityId, locationId,
			orderByComparator);
	}

	/**
	* Returns the last room master in the ordered set where cityId = &#63; and locationId = &#63;.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster findByRoomByLocandCity_Last(
		long cityId, long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomByLocandCity_Last(cityId, locationId,
			orderByComparator);
	}

	/**
	* Returns the last room master in the ordered set where cityId = &#63; and locationId = &#63;.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room master, or <code>null</code> if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster fetchByRoomByLocandCity_Last(
		long cityId, long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoomByLocandCity_Last(cityId, locationId,
			orderByComparator);
	}

	/**
	* Returns the room masters before and after the current room master in the ordered set where cityId = &#63; and locationId = &#63;.
	*
	* @param roomId the primary key of the current room master
	* @param cityId the city ID
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster[] findByRoomByLocandCity_PrevAndNext(
		long roomId, long cityId, long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomByLocandCity_PrevAndNext(roomId, cityId,
			locationId, orderByComparator);
	}

	/**
	* Returns all the room masters where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param floorId the floor ID
	* @return the matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByRoomByLocationCityFloor(
		long cityId, long locationId, long floorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomByLocationCityFloor(cityId, locationId, floorId);
	}

	/**
	* Returns a range of all the room masters where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param floorId the floor ID
	* @param start the lower bound of the range of room masters
	* @param end the upper bound of the range of room masters (not inclusive)
	* @return the range of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByRoomByLocationCityFloor(
		long cityId, long locationId, long floorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomByLocationCityFloor(cityId, locationId, floorId,
			start, end);
	}

	/**
	* Returns an ordered range of all the room masters where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param floorId the floor ID
	* @param start the lower bound of the range of room masters
	* @param end the upper bound of the range of room masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findByRoomByLocationCityFloor(
		long cityId, long locationId, long floorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomByLocationCityFloor(cityId, locationId, floorId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first room master in the ordered set where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param floorId the floor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster findByRoomByLocationCityFloor_First(
		long cityId, long locationId, long floorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomByLocationCityFloor_First(cityId, locationId,
			floorId, orderByComparator);
	}

	/**
	* Returns the first room master in the ordered set where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param floorId the floor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room master, or <code>null</code> if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster fetchByRoomByLocationCityFloor_First(
		long cityId, long locationId, long floorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoomByLocationCityFloor_First(cityId, locationId,
			floorId, orderByComparator);
	}

	/**
	* Returns the last room master in the ordered set where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param floorId the floor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster findByRoomByLocationCityFloor_Last(
		long cityId, long locationId, long floorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomByLocationCityFloor_Last(cityId, locationId,
			floorId, orderByComparator);
	}

	/**
	* Returns the last room master in the ordered set where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param floorId the floor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room master, or <code>null</code> if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster fetchByRoomByLocationCityFloor_Last(
		long cityId, long locationId, long floorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoomByLocationCityFloor_Last(cityId, locationId,
			floorId, orderByComparator);
	}

	/**
	* Returns the room masters before and after the current room master in the ordered set where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	*
	* @param roomId the primary key of the current room master
	* @param cityId the city ID
	* @param locationId the location ID
	* @param floorId the floor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster[] findByRoomByLocationCityFloor_PrevAndNext(
		long roomId, long cityId, long locationId, long floorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomByLocationCityFloor_PrevAndNext(roomId, cityId,
			locationId, floorId, orderByComparator);
	}

	/**
	* Returns the room master where roomName = &#63; or throws a {@link com.cignexdatamatics.wrm.NoSuchRoomMasterException} if it could not be found.
	*
	* @param roomName the room name
	* @return the matching room master
	* @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster findByRoomByRoomName(
		java.lang.String roomName)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoomByRoomName(roomName);
	}

	/**
	* Returns the room master where roomName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param roomName the room name
	* @return the matching room master, or <code>null</code> if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster fetchByRoomByRoomName(
		java.lang.String roomName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRoomByRoomName(roomName);
	}

	/**
	* Returns the room master where roomName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param roomName the room name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching room master, or <code>null</code> if a matching room master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster fetchByRoomByRoomName(
		java.lang.String roomName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoomByRoomName(roomName, retrieveFromCache);
	}

	/**
	* Returns all the room masters.
	*
	* @return the room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the room masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of room masters
	* @param end the upper bound of the range of room masters (not inclusive)
	* @return the range of room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the room masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of room masters
	* @param end the upper bound of the range of room masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the room masters where cityId = &#63; from the database.
	*
	* @param cityId the city ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCityId(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCityId(cityId);
	}

	/**
	* Removes all the room masters where locationId = &#63; from the database.
	*
	* @param locationId the location ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLocationId(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLocationId(locationId);
	}

	/**
	* Removes all the room masters where floorId = &#63; from the database.
	*
	* @param floorId the floor ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFloorId(long floorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFloorId(floorId);
	}

	/**
	* Removes all the room masters where cityId = &#63; and locationId = &#63; from the database.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRoomByLocandCity(long cityId, long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRoomByLocandCity(cityId, locationId);
	}

	/**
	* Removes all the room masters where cityId = &#63; and locationId = &#63; and floorId = &#63; from the database.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param floorId the floor ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRoomByLocationCityFloor(long cityId,
		long locationId, long floorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByRoomByLocationCityFloor(cityId, locationId, floorId);
	}

	/**
	* Removes the room master where roomName = &#63; from the database.
	*
	* @param roomName the room name
	* @return the room master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster removeByRoomByRoomName(
		java.lang.String roomName)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByRoomByRoomName(roomName);
	}

	/**
	* Removes all the room masters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of room masters where cityId = &#63;.
	*
	* @param cityId the city ID
	* @return the number of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCityId(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCityId(cityId);
	}

	/**
	* Returns the number of room masters where locationId = &#63;.
	*
	* @param locationId the location ID
	* @return the number of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLocationId(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLocationId(locationId);
	}

	/**
	* Returns the number of room masters where floorId = &#63;.
	*
	* @param floorId the floor ID
	* @return the number of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFloorId(long floorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFloorId(floorId);
	}

	/**
	* Returns the number of room masters where cityId = &#63; and locationId = &#63;.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @return the number of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRoomByLocandCity(long cityId, long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRoomByLocandCity(cityId, locationId);
	}

	/**
	* Returns the number of room masters where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	*
	* @param cityId the city ID
	* @param locationId the location ID
	* @param floorId the floor ID
	* @return the number of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRoomByLocationCityFloor(long cityId,
		long locationId, long floorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByRoomByLocationCityFloor(cityId, locationId, floorId);
	}

	/**
	* Returns the number of room masters where roomName = &#63;.
	*
	* @param roomName the room name
	* @return the number of matching room masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRoomByRoomName(java.lang.String roomName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRoomByRoomName(roomName);
	}

	/**
	* Returns the number of room masters.
	*
	* @return the number of room masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RoomMasterPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RoomMasterPersistence)PortletBeanLocatorUtil.locate(com.cignexdatamatics.wrm.service.ClpSerializer.getServletContextName(),
					RoomMasterPersistence.class.getName());

			ReferenceRegistry.registerReference(RoomMasterUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(RoomMasterPersistence persistence) {
	}

	private static RoomMasterPersistence _persistence;
}