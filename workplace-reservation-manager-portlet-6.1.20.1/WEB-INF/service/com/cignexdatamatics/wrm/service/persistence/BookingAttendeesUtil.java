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

import com.cignexdatamatics.wrm.model.BookingAttendees;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the booking attendees service. This utility wraps {@link BookingAttendeesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingAttendeesPersistence
 * @see BookingAttendeesPersistenceImpl
 * @generated
 */
public class BookingAttendeesUtil {
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
	public static void clearCache(BookingAttendees bookingAttendees) {
		getPersistence().clearCache(bookingAttendees);
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
	public static List<BookingAttendees> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BookingAttendees> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BookingAttendees> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static BookingAttendees update(BookingAttendees bookingAttendees,
		boolean merge) throws SystemException {
		return getPersistence().update(bookingAttendees, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static BookingAttendees update(BookingAttendees bookingAttendees,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(bookingAttendees, merge, serviceContext);
	}

	/**
	* Caches the booking attendees in the entity cache if it is enabled.
	*
	* @param bookingAttendees the booking attendees
	*/
	public static void cacheResult(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees) {
		getPersistence().cacheResult(bookingAttendees);
	}

	/**
	* Caches the booking attendeeses in the entity cache if it is enabled.
	*
	* @param bookingAttendeeses the booking attendeeses
	*/
	public static void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> bookingAttendeeses) {
		getPersistence().cacheResult(bookingAttendeeses);
	}

	/**
	* Creates a new booking attendees with the primary key. Does not add the booking attendees to the database.
	*
	* @param bookingAttendeesPK the primary key for the new booking attendees
	* @return the new booking attendees
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees create(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK) {
		return getPersistence().create(bookingAttendeesPK);
	}

	/**
	* Removes the booking attendees with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingAttendeesPK the primary key of the booking attendees
	* @return the booking attendees that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a booking attendees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees remove(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(bookingAttendeesPK);
	}

	public static com.cignexdatamatics.wrm.model.BookingAttendees updateImpl(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bookingAttendees, merge);
	}

	/**
	* Returns the booking attendees with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchBookingAttendeesException} if it could not be found.
	*
	* @param bookingAttendeesPK the primary key of the booking attendees
	* @return the booking attendees
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a booking attendees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees findByPrimaryKey(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(bookingAttendeesPK);
	}

	/**
	* Returns the booking attendees with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookingAttendeesPK the primary key of the booking attendees
	* @return the booking attendees, or <code>null</code> if a booking attendees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees fetchByPrimaryKey(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bookingAttendeesPK);
	}

	/**
	* Returns all the booking attendeeses where attendeesId = &#63;.
	*
	* @param attendeesId the attendees ID
	* @return the matching booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findByAttendeesId(
		long attendeesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAttendeesId(attendeesId);
	}

	/**
	* Returns a range of all the booking attendeeses where attendeesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param attendeesId the attendees ID
	* @param start the lower bound of the range of booking attendeeses
	* @param end the upper bound of the range of booking attendeeses (not inclusive)
	* @return the range of matching booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findByAttendeesId(
		long attendeesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAttendeesId(attendeesId, start, end);
	}

	/**
	* Returns an ordered range of all the booking attendeeses where attendeesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param attendeesId the attendees ID
	* @param start the lower bound of the range of booking attendeeses
	* @param end the upper bound of the range of booking attendeeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findByAttendeesId(
		long attendeesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAttendeesId(attendeesId, start, end, orderByComparator);
	}

	/**
	* Returns the first booking attendees in the ordered set where attendeesId = &#63;.
	*
	* @param attendeesId the attendees ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking attendees
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees findByAttendeesId_First(
		long attendeesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAttendeesId_First(attendeesId, orderByComparator);
	}

	/**
	* Returns the first booking attendees in the ordered set where attendeesId = &#63;.
	*
	* @param attendeesId the attendees ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking attendees, or <code>null</code> if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees fetchByAttendeesId_First(
		long attendeesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAttendeesId_First(attendeesId, orderByComparator);
	}

	/**
	* Returns the last booking attendees in the ordered set where attendeesId = &#63;.
	*
	* @param attendeesId the attendees ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking attendees
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees findByAttendeesId_Last(
		long attendeesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAttendeesId_Last(attendeesId, orderByComparator);
	}

	/**
	* Returns the last booking attendees in the ordered set where attendeesId = &#63;.
	*
	* @param attendeesId the attendees ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking attendees, or <code>null</code> if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees fetchByAttendeesId_Last(
		long attendeesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAttendeesId_Last(attendeesId, orderByComparator);
	}

	/**
	* Returns the booking attendeeses before and after the current booking attendees in the ordered set where attendeesId = &#63;.
	*
	* @param bookingAttendeesPK the primary key of the current booking attendees
	* @param attendeesId the attendees ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking attendees
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a booking attendees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees[] findByAttendeesId_PrevAndNext(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK,
		long attendeesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAttendeesId_PrevAndNext(bookingAttendeesPK,
			attendeesId, orderByComparator);
	}

	/**
	* Returns all the booking attendeeses where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @return the matching booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findByBookingId(
		long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBookingId(bookingId);
	}

	/**
	* Returns a range of all the booking attendeeses where bookingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bookingId the booking ID
	* @param start the lower bound of the range of booking attendeeses
	* @param end the upper bound of the range of booking attendeeses (not inclusive)
	* @return the range of matching booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findByBookingId(
		long bookingId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBookingId(bookingId, start, end);
	}

	/**
	* Returns an ordered range of all the booking attendeeses where bookingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bookingId the booking ID
	* @param start the lower bound of the range of booking attendeeses
	* @param end the upper bound of the range of booking attendeeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findByBookingId(
		long bookingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookingId(bookingId, start, end, orderByComparator);
	}

	/**
	* Returns the first booking attendees in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking attendees
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees findByBookingId_First(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookingId_First(bookingId, orderByComparator);
	}

	/**
	* Returns the first booking attendees in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking attendees, or <code>null</code> if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees fetchByBookingId_First(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBookingId_First(bookingId, orderByComparator);
	}

	/**
	* Returns the last booking attendees in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking attendees
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees findByBookingId_Last(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookingId_Last(bookingId, orderByComparator);
	}

	/**
	* Returns the last booking attendees in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking attendees, or <code>null</code> if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees fetchByBookingId_Last(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBookingId_Last(bookingId, orderByComparator);
	}

	/**
	* Returns the booking attendeeses before and after the current booking attendees in the ordered set where bookingId = &#63;.
	*
	* @param bookingAttendeesPK the primary key of the current booking attendees
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking attendees
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a booking attendees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees[] findByBookingId_PrevAndNext(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK,
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookingId_PrevAndNext(bookingAttendeesPK, bookingId,
			orderByComparator);
	}

	/**
	* Returns all the booking attendeeses.
	*
	* @return the booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the booking attendeeses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of booking attendeeses
	* @param end the upper bound of the range of booking attendeeses (not inclusive)
	* @return the range of booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the booking attendeeses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of booking attendeeses
	* @param end the upper bound of the range of booking attendeeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the booking attendeeses where attendeesId = &#63; from the database.
	*
	* @param attendeesId the attendees ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAttendeesId(long attendeesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAttendeesId(attendeesId);
	}

	/**
	* Removes all the booking attendeeses where bookingId = &#63; from the database.
	*
	* @param bookingId the booking ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBookingId(long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBookingId(bookingId);
	}

	/**
	* Removes all the booking attendeeses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of booking attendeeses where attendeesId = &#63;.
	*
	* @param attendeesId the attendees ID
	* @return the number of matching booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAttendeesId(long attendeesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAttendeesId(attendeesId);
	}

	/**
	* Returns the number of booking attendeeses where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @return the number of matching booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBookingId(long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBookingId(bookingId);
	}

	/**
	* Returns the number of booking attendeeses.
	*
	* @return the number of booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BookingAttendeesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BookingAttendeesPersistence)PortletBeanLocatorUtil.locate(com.cignexdatamatics.wrm.service.ClpSerializer.getServletContextName(),
					BookingAttendeesPersistence.class.getName());

			ReferenceRegistry.registerReference(BookingAttendeesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(BookingAttendeesPersistence persistence) {
	}

	private static BookingAttendeesPersistence _persistence;
}