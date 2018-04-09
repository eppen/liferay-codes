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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the booking facility mapping service. This utility wraps {@link BookingFacilityMappingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingFacilityMappingPersistence
 * @see BookingFacilityMappingPersistenceImpl
 * @generated
 */
public class BookingFacilityMappingUtil {
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
	public static void clearCache(BookingFacilityMapping bookingFacilityMapping) {
		getPersistence().clearCache(bookingFacilityMapping);
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
	public static List<BookingFacilityMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BookingFacilityMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BookingFacilityMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static BookingFacilityMapping update(
		BookingFacilityMapping bookingFacilityMapping, boolean merge)
		throws SystemException {
		return getPersistence().update(bookingFacilityMapping, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static BookingFacilityMapping update(
		BookingFacilityMapping bookingFacilityMapping, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(bookingFacilityMapping, merge, serviceContext);
	}

	/**
	* Caches the booking facility mapping in the entity cache if it is enabled.
	*
	* @param bookingFacilityMapping the booking facility mapping
	*/
	public static void cacheResult(
		com.cignexdatamatics.wrm.model.BookingFacilityMapping bookingFacilityMapping) {
		getPersistence().cacheResult(bookingFacilityMapping);
	}

	/**
	* Caches the booking facility mappings in the entity cache if it is enabled.
	*
	* @param bookingFacilityMappings the booking facility mappings
	*/
	public static void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> bookingFacilityMappings) {
		getPersistence().cacheResult(bookingFacilityMappings);
	}

	/**
	* Creates a new booking facility mapping with the primary key. Does not add the booking facility mapping to the database.
	*
	* @param bookingFacilityMappingPK the primary key for the new booking facility mapping
	* @return the new booking facility mapping
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping create(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK) {
		return getPersistence().create(bookingFacilityMappingPK);
	}

	/**
	* Removes the booking facility mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingFacilityMappingPK the primary key of the booking facility mapping
	* @return the booking facility mapping that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a booking facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping remove(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(bookingFacilityMappingPK);
	}

	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping updateImpl(
		com.cignexdatamatics.wrm.model.BookingFacilityMapping bookingFacilityMapping,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bookingFacilityMapping, merge);
	}

	/**
	* Returns the booking facility mapping with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException} if it could not be found.
	*
	* @param bookingFacilityMappingPK the primary key of the booking facility mapping
	* @return the booking facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a booking facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping findByPrimaryKey(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(bookingFacilityMappingPK);
	}

	/**
	* Returns the booking facility mapping with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookingFacilityMappingPK the primary key of the booking facility mapping
	* @return the booking facility mapping, or <code>null</code> if a booking facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping fetchByPrimaryKey(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bookingFacilityMappingPK);
	}

	/**
	* Returns all the booking facility mappings where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @return the matching booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findBybookingId(
		long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybookingId(bookingId);
	}

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
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findBybookingId(
		long bookingId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybookingId(bookingId, start, end);
	}

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
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findBybookingId(
		long bookingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybookingId(bookingId, start, end, orderByComparator);
	}

	/**
	* Returns the first booking facility mapping in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping findBybookingId_First(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybookingId_First(bookingId, orderByComparator);
	}

	/**
	* Returns the first booking facility mapping in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking facility mapping, or <code>null</code> if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping fetchBybookingId_First(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybookingId_First(bookingId, orderByComparator);
	}

	/**
	* Returns the last booking facility mapping in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping findBybookingId_Last(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybookingId_Last(bookingId, orderByComparator);
	}

	/**
	* Returns the last booking facility mapping in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking facility mapping, or <code>null</code> if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping fetchBybookingId_Last(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybookingId_Last(bookingId, orderByComparator);
	}

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
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping[] findBybookingId_PrevAndNext(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK,
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybookingId_PrevAndNext(bookingFacilityMappingPK,
			bookingId, orderByComparator);
	}

	/**
	* Returns all the booking facility mappings where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @return the matching booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findByfacilitiesId(
		long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfacilitiesId(facilitiesId);
	}

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
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findByfacilitiesId(
		long facilitiesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfacilitiesId(facilitiesId, start, end);
	}

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
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findByfacilitiesId(
		long facilitiesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByfacilitiesId(facilitiesId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first booking facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping findByfacilitiesId_First(
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByfacilitiesId_First(facilitiesId, orderByComparator);
	}

	/**
	* Returns the first booking facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking facility mapping, or <code>null</code> if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping fetchByfacilitiesId_First(
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfacilitiesId_First(facilitiesId, orderByComparator);
	}

	/**
	* Returns the last booking facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking facility mapping
	* @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping findByfacilitiesId_Last(
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByfacilitiesId_Last(facilitiesId, orderByComparator);
	}

	/**
	* Returns the last booking facility mapping in the ordered set where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking facility mapping, or <code>null</code> if a matching booking facility mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping fetchByfacilitiesId_Last(
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfacilitiesId_Last(facilitiesId, orderByComparator);
	}

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
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping[] findByfacilitiesId_PrevAndNext(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK,
		long facilitiesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByfacilitiesId_PrevAndNext(bookingFacilityMappingPK,
			facilitiesId, orderByComparator);
	}

	/**
	* Returns all the booking facility mappings.
	*
	* @return the booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the booking facility mappings where bookingId = &#63; from the database.
	*
	* @param bookingId the booking ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybookingId(long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybookingId(bookingId);
	}

	/**
	* Removes all the booking facility mappings where facilitiesId = &#63; from the database.
	*
	* @param facilitiesId the facilities ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByfacilitiesId(long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByfacilitiesId(facilitiesId);
	}

	/**
	* Removes all the booking facility mappings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of booking facility mappings where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @return the number of matching booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybookingId(long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybookingId(bookingId);
	}

	/**
	* Returns the number of booking facility mappings where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @return the number of matching booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfacilitiesId(long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfacilitiesId(facilitiesId);
	}

	/**
	* Returns the number of booking facility mappings.
	*
	* @return the number of booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BookingFacilityMappingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BookingFacilityMappingPersistence)PortletBeanLocatorUtil.locate(com.cignexdatamatics.wrm.service.ClpSerializer.getServletContextName(),
					BookingFacilityMappingPersistence.class.getName());

			ReferenceRegistry.registerReference(BookingFacilityMappingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(BookingFacilityMappingPersistence persistence) {
	}

	private static BookingFacilityMappingPersistence _persistence;
}