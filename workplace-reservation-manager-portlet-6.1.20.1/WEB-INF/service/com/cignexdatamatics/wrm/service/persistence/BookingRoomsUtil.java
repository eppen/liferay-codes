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

import com.cignexdatamatics.wrm.model.BookingRooms;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the booking rooms service. This utility wraps {@link BookingRoomsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingRoomsPersistence
 * @see BookingRoomsPersistenceImpl
 * @generated
 */
public class BookingRoomsUtil {
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
	public static void clearCache(BookingRooms bookingRooms) {
		getPersistence().clearCache(bookingRooms);
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
	public static List<BookingRooms> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BookingRooms> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BookingRooms> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static BookingRooms update(BookingRooms bookingRooms, boolean merge)
		throws SystemException {
		return getPersistence().update(bookingRooms, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static BookingRooms update(BookingRooms bookingRooms, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(bookingRooms, merge, serviceContext);
	}

	/**
	* Caches the booking rooms in the entity cache if it is enabled.
	*
	* @param bookingRooms the booking rooms
	*/
	public static void cacheResult(
		com.cignexdatamatics.wrm.model.BookingRooms bookingRooms) {
		getPersistence().cacheResult(bookingRooms);
	}

	/**
	* Caches the booking roomses in the entity cache if it is enabled.
	*
	* @param bookingRoomses the booking roomses
	*/
	public static void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> bookingRoomses) {
		getPersistence().cacheResult(bookingRoomses);
	}

	/**
	* Creates a new booking rooms with the primary key. Does not add the booking rooms to the database.
	*
	* @param BRMappingId the primary key for the new booking rooms
	* @return the new booking rooms
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms create(
		long BRMappingId) {
		return getPersistence().create(BRMappingId);
	}

	/**
	* Removes the booking rooms with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param BRMappingId the primary key of the booking rooms
	* @return the booking rooms that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a booking rooms with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms remove(
		long BRMappingId)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(BRMappingId);
	}

	public static com.cignexdatamatics.wrm.model.BookingRooms updateImpl(
		com.cignexdatamatics.wrm.model.BookingRooms bookingRooms, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bookingRooms, merge);
	}

	/**
	* Returns the booking rooms with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchBookingRoomsException} if it could not be found.
	*
	* @param BRMappingId the primary key of the booking rooms
	* @return the booking rooms
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a booking rooms with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms findByPrimaryKey(
		long BRMappingId)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(BRMappingId);
	}

	/**
	* Returns the booking rooms with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param BRMappingId the primary key of the booking rooms
	* @return the booking rooms, or <code>null</code> if a booking rooms with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms fetchByPrimaryKey(
		long BRMappingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(BRMappingId);
	}

	/**
	* Returns all the booking roomses where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @return the matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findByBookingId(
		long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBookingId(bookingId);
	}

	/**
	* Returns a range of all the booking roomses where bookingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bookingId the booking ID
	* @param start the lower bound of the range of booking roomses
	* @param end the upper bound of the range of booking roomses (not inclusive)
	* @return the range of matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findByBookingId(
		long bookingId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBookingId(bookingId, start, end);
	}

	/**
	* Returns an ordered range of all the booking roomses where bookingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bookingId the booking ID
	* @param start the lower bound of the range of booking roomses
	* @param end the upper bound of the range of booking roomses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findByBookingId(
		long bookingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookingId(bookingId, start, end, orderByComparator);
	}

	/**
	* Returns the first booking rooms in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking rooms
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms findByBookingId_First(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookingId_First(bookingId, orderByComparator);
	}

	/**
	* Returns the first booking rooms in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms fetchByBookingId_First(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBookingId_First(bookingId, orderByComparator);
	}

	/**
	* Returns the last booking rooms in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking rooms
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms findByBookingId_Last(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookingId_Last(bookingId, orderByComparator);
	}

	/**
	* Returns the last booking rooms in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms fetchByBookingId_Last(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBookingId_Last(bookingId, orderByComparator);
	}

	/**
	* Returns the booking roomses before and after the current booking rooms in the ordered set where bookingId = &#63;.
	*
	* @param BRMappingId the primary key of the current booking rooms
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking rooms
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a booking rooms with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms[] findByBookingId_PrevAndNext(
		long BRMappingId, long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookingId_PrevAndNext(BRMappingId, bookingId,
			orderByComparator);
	}

	/**
	* Returns all the booking roomses where roomId = &#63;.
	*
	* @param roomId the room ID
	* @return the matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findByRoomId(
		long roomId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoomId(roomId);
	}

	/**
	* Returns a range of all the booking roomses where roomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roomId the room ID
	* @param start the lower bound of the range of booking roomses
	* @param end the upper bound of the range of booking roomses (not inclusive)
	* @return the range of matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findByRoomId(
		long roomId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoomId(roomId, start, end);
	}

	/**
	* Returns an ordered range of all the booking roomses where roomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roomId the room ID
	* @param start the lower bound of the range of booking roomses
	* @param end the upper bound of the range of booking roomses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findByRoomId(
		long roomId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomId(roomId, start, end, orderByComparator);
	}

	/**
	* Returns the first booking rooms in the ordered set where roomId = &#63;.
	*
	* @param roomId the room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking rooms
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms findByRoomId_First(
		long roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoomId_First(roomId, orderByComparator);
	}

	/**
	* Returns the first booking rooms in the ordered set where roomId = &#63;.
	*
	* @param roomId the room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms fetchByRoomId_First(
		long roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRoomId_First(roomId, orderByComparator);
	}

	/**
	* Returns the last booking rooms in the ordered set where roomId = &#63;.
	*
	* @param roomId the room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking rooms
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms findByRoomId_Last(
		long roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoomId_Last(roomId, orderByComparator);
	}

	/**
	* Returns the last booking rooms in the ordered set where roomId = &#63;.
	*
	* @param roomId the room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms fetchByRoomId_Last(
		long roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRoomId_Last(roomId, orderByComparator);
	}

	/**
	* Returns the booking roomses before and after the current booking rooms in the ordered set where roomId = &#63;.
	*
	* @param BRMappingId the primary key of the current booking rooms
	* @param roomId the room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking rooms
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a booking rooms with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms[] findByRoomId_PrevAndNext(
		long BRMappingId, long roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomId_PrevAndNext(BRMappingId, roomId,
			orderByComparator);
	}

	/**
	* Returns all the booking roomses where bookingDate = &#63;.
	*
	* @param bookingDate the booking date
	* @return the matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findByBookingDate(
		java.util.Date bookingDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBookingDate(bookingDate);
	}

	/**
	* Returns a range of all the booking roomses where bookingDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bookingDate the booking date
	* @param start the lower bound of the range of booking roomses
	* @param end the upper bound of the range of booking roomses (not inclusive)
	* @return the range of matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findByBookingDate(
		java.util.Date bookingDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBookingDate(bookingDate, start, end);
	}

	/**
	* Returns an ordered range of all the booking roomses where bookingDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bookingDate the booking date
	* @param start the lower bound of the range of booking roomses
	* @param end the upper bound of the range of booking roomses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findByBookingDate(
		java.util.Date bookingDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookingDate(bookingDate, start, end, orderByComparator);
	}

	/**
	* Returns the first booking rooms in the ordered set where bookingDate = &#63;.
	*
	* @param bookingDate the booking date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking rooms
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms findByBookingDate_First(
		java.util.Date bookingDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookingDate_First(bookingDate, orderByComparator);
	}

	/**
	* Returns the first booking rooms in the ordered set where bookingDate = &#63;.
	*
	* @param bookingDate the booking date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms fetchByBookingDate_First(
		java.util.Date bookingDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBookingDate_First(bookingDate, orderByComparator);
	}

	/**
	* Returns the last booking rooms in the ordered set where bookingDate = &#63;.
	*
	* @param bookingDate the booking date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking rooms
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms findByBookingDate_Last(
		java.util.Date bookingDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookingDate_Last(bookingDate, orderByComparator);
	}

	/**
	* Returns the last booking rooms in the ordered set where bookingDate = &#63;.
	*
	* @param bookingDate the booking date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms fetchByBookingDate_Last(
		java.util.Date bookingDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBookingDate_Last(bookingDate, orderByComparator);
	}

	/**
	* Returns the booking roomses before and after the current booking rooms in the ordered set where bookingDate = &#63;.
	*
	* @param BRMappingId the primary key of the current booking rooms
	* @param bookingDate the booking date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking rooms
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a booking rooms with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms[] findByBookingDate_PrevAndNext(
		long BRMappingId, java.util.Date bookingDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookingDate_PrevAndNext(BRMappingId, bookingDate,
			orderByComparator);
	}

	/**
	* Returns all the booking roomses where roomId = &#63; and bookingDate = &#63;.
	*
	* @param roomId the room ID
	* @param bookingDate the booking date
	* @return the matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findByRoomIdAndBookingDate(
		long roomId, java.util.Date bookingDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoomIdAndBookingDate(roomId, bookingDate);
	}

	/**
	* Returns a range of all the booking roomses where roomId = &#63; and bookingDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roomId the room ID
	* @param bookingDate the booking date
	* @param start the lower bound of the range of booking roomses
	* @param end the upper bound of the range of booking roomses (not inclusive)
	* @return the range of matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findByRoomIdAndBookingDate(
		long roomId, java.util.Date bookingDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomIdAndBookingDate(roomId, bookingDate, start, end);
	}

	/**
	* Returns an ordered range of all the booking roomses where roomId = &#63; and bookingDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roomId the room ID
	* @param bookingDate the booking date
	* @param start the lower bound of the range of booking roomses
	* @param end the upper bound of the range of booking roomses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findByRoomIdAndBookingDate(
		long roomId, java.util.Date bookingDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomIdAndBookingDate(roomId, bookingDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first booking rooms in the ordered set where roomId = &#63; and bookingDate = &#63;.
	*
	* @param roomId the room ID
	* @param bookingDate the booking date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking rooms
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms findByRoomIdAndBookingDate_First(
		long roomId, java.util.Date bookingDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomIdAndBookingDate_First(roomId, bookingDate,
			orderByComparator);
	}

	/**
	* Returns the first booking rooms in the ordered set where roomId = &#63; and bookingDate = &#63;.
	*
	* @param roomId the room ID
	* @param bookingDate the booking date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms fetchByRoomIdAndBookingDate_First(
		long roomId, java.util.Date bookingDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoomIdAndBookingDate_First(roomId, bookingDate,
			orderByComparator);
	}

	/**
	* Returns the last booking rooms in the ordered set where roomId = &#63; and bookingDate = &#63;.
	*
	* @param roomId the room ID
	* @param bookingDate the booking date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking rooms
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms findByRoomIdAndBookingDate_Last(
		long roomId, java.util.Date bookingDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomIdAndBookingDate_Last(roomId, bookingDate,
			orderByComparator);
	}

	/**
	* Returns the last booking rooms in the ordered set where roomId = &#63; and bookingDate = &#63;.
	*
	* @param roomId the room ID
	* @param bookingDate the booking date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms fetchByRoomIdAndBookingDate_Last(
		long roomId, java.util.Date bookingDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoomIdAndBookingDate_Last(roomId, bookingDate,
			orderByComparator);
	}

	/**
	* Returns the booking roomses before and after the current booking rooms in the ordered set where roomId = &#63; and bookingDate = &#63;.
	*
	* @param BRMappingId the primary key of the current booking rooms
	* @param roomId the room ID
	* @param bookingDate the booking date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking rooms
	* @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a booking rooms with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingRooms[] findByRoomIdAndBookingDate_PrevAndNext(
		long BRMappingId, long roomId, java.util.Date bookingDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomIdAndBookingDate_PrevAndNext(BRMappingId, roomId,
			bookingDate, orderByComparator);
	}

	/**
	* Returns all the booking roomses.
	*
	* @return the booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the booking roomses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of booking roomses
	* @param end the upper bound of the range of booking roomses (not inclusive)
	* @return the range of booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the booking roomses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of booking roomses
	* @param end the upper bound of the range of booking roomses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the booking roomses where bookingId = &#63; from the database.
	*
	* @param bookingId the booking ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBookingId(long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBookingId(bookingId);
	}

	/**
	* Removes all the booking roomses where roomId = &#63; from the database.
	*
	* @param roomId the room ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRoomId(long roomId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRoomId(roomId);
	}

	/**
	* Removes all the booking roomses where bookingDate = &#63; from the database.
	*
	* @param bookingDate the booking date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBookingDate(java.util.Date bookingDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBookingDate(bookingDate);
	}

	/**
	* Removes all the booking roomses where roomId = &#63; and bookingDate = &#63; from the database.
	*
	* @param roomId the room ID
	* @param bookingDate the booking date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRoomIdAndBookingDate(long roomId,
		java.util.Date bookingDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRoomIdAndBookingDate(roomId, bookingDate);
	}

	/**
	* Removes all the booking roomses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of booking roomses where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @return the number of matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBookingId(long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBookingId(bookingId);
	}

	/**
	* Returns the number of booking roomses where roomId = &#63;.
	*
	* @param roomId the room ID
	* @return the number of matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRoomId(long roomId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRoomId(roomId);
	}

	/**
	* Returns the number of booking roomses where bookingDate = &#63;.
	*
	* @param bookingDate the booking date
	* @return the number of matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBookingDate(java.util.Date bookingDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBookingDate(bookingDate);
	}

	/**
	* Returns the number of booking roomses where roomId = &#63; and bookingDate = &#63;.
	*
	* @param roomId the room ID
	* @param bookingDate the booking date
	* @return the number of matching booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRoomIdAndBookingDate(long roomId,
		java.util.Date bookingDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRoomIdAndBookingDate(roomId, bookingDate);
	}

	/**
	* Returns the number of booking roomses.
	*
	* @return the number of booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BookingRoomsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BookingRoomsPersistence)PortletBeanLocatorUtil.locate(com.cignexdatamatics.wrm.service.ClpSerializer.getServletContextName(),
					BookingRoomsPersistence.class.getName());

			ReferenceRegistry.registerReference(BookingRoomsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(BookingRoomsPersistence persistence) {
	}

	private static BookingRoomsPersistence _persistence;
}