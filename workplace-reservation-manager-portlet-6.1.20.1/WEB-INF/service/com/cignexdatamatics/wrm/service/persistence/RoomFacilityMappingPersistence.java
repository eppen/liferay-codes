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

import com.cignexdatamatics.wrm.model.RoomFacilityMapping;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the room facility mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomFacilityMappingPersistenceImpl
 * @see RoomFacilityMappingUtil
 * @generated
 */
public interface RoomFacilityMappingPersistence extends BasePersistence<RoomFacilityMapping> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RoomFacilityMappingUtil} to access the room facility mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the room facility mapping in the entity cache if it is enabled.
	*
	* @param roomFacilityMapping the room facility mapping
	*/
	public void cacheResult(
		com.cignexdatamatics.wrm.model.RoomFacilityMapping roomFacilityMapping);

	/**
	* Caches the room facility mappings in the entity cache if it is enabled.
	*
	* @param roomFacilityMappings the room facility mappings
	*/
	public void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.RoomFacilityMapping> roomFacilityMappings);

	/**
	* Creates a new room facility mapping with the primary key. Does not add the room facility mapping to the database.
	*
	* @param roomFacilityMappingPK the primary key for the new room facility mapping
	* @return the new room facility mapping
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping create(
		com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK roomFacilityMappingPK);

	/**
	* Removes the room facility mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roomFacilityMappingPK the primary key of the room facility mapping
	* @return the room facility mapping that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a room facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping remove(
		com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK roomFacilityMappingPK)
		throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cignexdatamatics.wrm.model.RoomFacilityMapping updateImpl(
		com.cignexdatamatics.wrm.model.RoomFacilityMapping roomFacilityMapping,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the room facility mapping with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException} if it could not be found.
	*
	* @param roomFacilityMappingPK the primary key of the room facility mapping
	* @return the room facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a room facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping findByPrimaryKey(
		com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK roomFacilityMappingPK)
		throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the room facility mapping with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param roomFacilityMappingPK the primary key of the room facility mapping
	* @return the room facility mapping, or <code>null</code> if a room facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping fetchByPrimaryKey(
		com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK roomFacilityMappingPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the room facility mappings where roomId = &#63;.
	*
	* @param roomId the room ID
	* @return the matching room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.RoomFacilityMapping> findByroomId(
		long roomId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the room facility mappings where roomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roomId the room ID
	* @param start the lower bound of the range of room facility mappings
	* @param end the upper bound of the range of room facility mappings (not inclusive)
	* @return the range of matching room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.RoomFacilityMapping> findByroomId(
		long roomId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the room facility mappings where roomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roomId the room ID
	* @param start the lower bound of the range of room facility mappings
	* @param end the upper bound of the range of room facility mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.RoomFacilityMapping> findByroomId(
		long roomId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first room facility mapping in the ordered set where roomId = &#63;.
	*
	* @param roomId the room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a matching room facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping findByroomId_First(
		long roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first room facility mapping in the ordered set where roomId = &#63;.
	*
	* @param roomId the room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room facility mapping, or <code>null</code> if a matching room facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping fetchByroomId_First(
		long roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last room facility mapping in the ordered set where roomId = &#63;.
	*
	* @param roomId the room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a matching room facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping findByroomId_Last(
		long roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last room facility mapping in the ordered set where roomId = &#63;.
	*
	* @param roomId the room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room facility mapping, or <code>null</code> if a matching room facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping fetchByroomId_Last(
		long roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the room facility mappings before and after the current room facility mapping in the ordered set where roomId = &#63;.
	*
	* @param roomFacilityMappingPK the primary key of the current room facility mapping
	* @param roomId the room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next room facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a room facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping[] findByroomId_PrevAndNext(
		com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK roomFacilityMappingPK,
		long roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the room facility mappings where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @return the matching room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.RoomFacilityMapping> findByfacilitiesId(
		long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the room facility mappings where facilitiesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param facilitiesId the facilities ID
	* @param start the lower bound of the range of room facility mappings
	* @param end the upper bound of the range of room facility mappings (not inclusive)
	* @return the range of matching room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.RoomFacilityMapping> findByfacilitiesId(
		long facilitiesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the room facility mappings where facilitiesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param facilitiesId the facilities ID
	* @param start the lower bound of the range of room facility mappings
	* @param end the upper bound of the range of room facility mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.RoomFacilityMapping> findByfacilitiesId(
		long facilitiesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first room facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a matching room facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping findByfacilitiesId_First(
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first room facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching room facility mapping, or <code>null</code> if a matching room facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping fetchByfacilitiesId_First(
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last room facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a matching room facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping findByfacilitiesId_Last(
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last room facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching room facility mapping, or <code>null</code> if a matching room facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping fetchByfacilitiesId_Last(
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the room facility mappings before and after the current room facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param roomFacilityMappingPK the primary key of the current room facility mapping
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next room facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a room facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping[] findByfacilitiesId_PrevAndNext(
		com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK roomFacilityMappingPK,
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the room facility mappings.
	*
	* @return the room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.RoomFacilityMapping> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the room facility mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of room facility mappings
	* @param end the upper bound of the range of room facility mappings (not inclusive)
	* @return the range of room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.RoomFacilityMapping> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the room facility mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of room facility mappings
	* @param end the upper bound of the range of room facility mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.RoomFacilityMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the room facility mappings where roomId = &#63; from the database.
	*
	* @param roomId the room ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByroomId(long roomId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the room facility mappings where facilitiesId = &#63; from the database.
	*
	* @param facilitiesId the facilities ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByfacilitiesId(long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the room facility mappings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of room facility mappings where roomId = &#63;.
	*
	* @param roomId the room ID
	* @return the number of matching room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countByroomId(long roomId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of room facility mappings where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @return the number of matching room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countByfacilitiesId(long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of room facility mappings.
	*
	* @return the number of room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}