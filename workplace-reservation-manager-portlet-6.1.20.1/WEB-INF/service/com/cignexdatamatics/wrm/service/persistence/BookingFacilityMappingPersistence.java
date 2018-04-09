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

import com.cignexdatamatics.wrm.model.BookingFacilityMapping;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the booking facility mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingFacilityMappingPersistenceImpl
 * @see BookingFacilityMappingUtil
 * @generated
 */
public interface BookingFacilityMappingPersistence extends BasePersistence<BookingFacilityMapping> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookingFacilityMappingUtil} to access the booking facility mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the booking facility mapping in the entity cache if it is enabled.
	*
	* @param bookingFacilityMapping the booking facility mapping
	*/
	public void cacheResult(
		com.cignexdatamatics.wrm.model.BookingFacilityMapping bookingFacilityMapping);

	/**
	* Caches the booking facility mappings in the entity cache if it is enabled.
	*
	* @param bookingFacilityMappings the booking facility mappings
	*/
	public void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> bookingFacilityMappings);

	/**
	* Creates a new booking facility mapping with the primary key. Does not add the booking facility mapping to the database.
	*
	* @param bookingFacilityMappingPK the primary key for the new booking facility mapping
	* @return the new booking facility mapping
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping create(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK);

	/**
	* Removes the booking facility mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingFacilityMappingPK the primary key of the booking facility mapping
	* @return the booking facility mapping that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a booking facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping remove(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cignexdatamatics.wrm.model.BookingFacilityMapping updateImpl(
		com.cignexdatamatics.wrm.model.BookingFacilityMapping bookingFacilityMapping,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the booking facility mapping with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException} if it could not be found.
	*
	* @param bookingFacilityMappingPK the primary key of the booking facility mapping
	* @return the booking facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a booking facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping findByPrimaryKey(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the booking facility mapping with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookingFacilityMappingPK the primary key of the booking facility mapping
	* @return the booking facility mapping, or <code>null</code> if a booking facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping fetchByPrimaryKey(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the booking facility mappings where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @return the matching booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findBybookingId(
		long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the booking facility mappings where bookingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bookingId the booking ID
	* @param start the lower bound of the range of booking facility mappings
	* @param end the upper bound of the range of booking facility mappings (not inclusive)
	* @return the range of matching booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findBybookingId(
		long bookingId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the booking facility mappings where bookingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bookingId the booking ID
	* @param start the lower bound of the range of booking facility mappings
	* @param end the upper bound of the range of booking facility mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findBybookingId(
		long bookingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first booking facility mapping in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping findBybookingId_First(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first booking facility mapping in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking facility mapping, or <code>null</code> if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping fetchBybookingId_First(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last booking facility mapping in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping findBybookingId_Last(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last booking facility mapping in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking facility mapping, or <code>null</code> if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping fetchBybookingId_Last(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the booking facility mappings before and after the current booking facility mapping in the ordered set where bookingId = &#63;.
	*
	* @param bookingFacilityMappingPK the primary key of the current booking facility mapping
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a booking facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping[] findBybookingId_PrevAndNext(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK,
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the booking facility mappings where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @return the matching booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findByfacilitiesId(
		long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the booking facility mappings where facilitiesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param facilitiesId the facilities ID
	* @param start the lower bound of the range of booking facility mappings
	* @param end the upper bound of the range of booking facility mappings (not inclusive)
	* @return the range of matching booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findByfacilitiesId(
		long facilitiesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the booking facility mappings where facilitiesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param facilitiesId the facilities ID
	* @param start the lower bound of the range of booking facility mappings
	* @param end the upper bound of the range of booking facility mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findByfacilitiesId(
		long facilitiesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first booking facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping findByfacilitiesId_First(
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first booking facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking facility mapping, or <code>null</code> if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping fetchByfacilitiesId_First(
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last booking facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping findByfacilitiesId_Last(
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last booking facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking facility mapping, or <code>null</code> if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping fetchByfacilitiesId_Last(
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the booking facility mappings before and after the current booking facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param bookingFacilityMappingPK the primary key of the current booking facility mapping
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a booking facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingFacilityMapping[] findByfacilitiesId_PrevAndNext(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK,
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the booking facility mappings.
	*
	* @return the booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the booking facility mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of booking facility mappings
	* @param end the upper bound of the range of booking facility mappings (not inclusive)
	* @return the range of booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the booking facility mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of booking facility mappings
	* @param end the upper bound of the range of booking facility mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the booking facility mappings where bookingId = &#63; from the database.
	*
	* @param bookingId the booking ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybookingId(long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the booking facility mappings where facilitiesId = &#63; from the database.
	*
	* @param facilitiesId the facilities ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByfacilitiesId(long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the booking facility mappings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of booking facility mappings where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @return the number of matching booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countBybookingId(long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of booking facility mappings where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @return the number of matching booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countByfacilitiesId(long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of booking facility mappings.
	*
	* @return the number of booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}