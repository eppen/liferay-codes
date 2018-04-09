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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the booking attendees service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingAttendeesPersistenceImpl
 * @see BookingAttendeesUtil
 * @generated
 */
public interface BookingAttendeesPersistence extends BasePersistence<BookingAttendees> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookingAttendeesUtil} to access the booking attendees persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the booking attendees in the entity cache if it is enabled.
	*
	* @param bookingAttendees the booking attendees
	*/
	public void cacheResult(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees);

	/**
	* Caches the booking attendeeses in the entity cache if it is enabled.
	*
	* @param bookingAttendeeses the booking attendeeses
	*/
	public void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> bookingAttendeeses);

	/**
	* Creates a new booking attendees with the primary key. Does not add the booking attendees to the database.
	*
	* @param bookingAttendeesPK the primary key for the new booking attendees
	* @return the new booking attendees
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees create(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK);

	/**
	* Removes the booking attendees with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingAttendeesPK the primary key of the booking attendees
	* @return the booking attendees that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a booking attendees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees remove(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cignexdatamatics.wrm.model.BookingAttendees updateImpl(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the booking attendees with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchBookingAttendeesException} if it could not be found.
	*
	* @param bookingAttendeesPK the primary key of the booking attendees
	* @return the booking attendees
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a booking attendees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees findByPrimaryKey(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the booking attendees with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookingAttendeesPK the primary key of the booking attendees
	* @return the booking attendees, or <code>null</code> if a booking attendees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees fetchByPrimaryKey(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the booking attendeeses where attendeesId = &#63;.
	*
	* @param attendeesId the attendees ID
	* @return the matching booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findByAttendeesId(
		long attendeesId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findByAttendeesId(
		long attendeesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findByAttendeesId(
		long attendeesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first booking attendees in the ordered set where attendeesId = &#63;.
	*
	* @param attendeesId the attendees ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking attendees
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees findByAttendeesId_First(
		long attendeesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first booking attendees in the ordered set where attendeesId = &#63;.
	*
	* @param attendeesId the attendees ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking attendees, or <code>null</code> if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees fetchByAttendeesId_First(
		long attendeesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last booking attendees in the ordered set where attendeesId = &#63;.
	*
	* @param attendeesId the attendees ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking attendees
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees findByAttendeesId_Last(
		long attendeesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last booking attendees in the ordered set where attendeesId = &#63;.
	*
	* @param attendeesId the attendees ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking attendees, or <code>null</code> if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees fetchByAttendeesId_Last(
		long attendeesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cignexdatamatics.wrm.model.BookingAttendees[] findByAttendeesId_PrevAndNext(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK,
		long attendeesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the booking attendeeses where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @return the matching booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findByBookingId(
		long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findByBookingId(
		long bookingId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findByBookingId(
		long bookingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first booking attendees in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking attendees
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees findByBookingId_First(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first booking attendees in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking attendees, or <code>null</code> if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees fetchByBookingId_First(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last booking attendees in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking attendees
	* @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees findByBookingId_Last(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last booking attendees in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking attendees, or <code>null</code> if a matching booking attendees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees fetchByBookingId_Last(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cignexdatamatics.wrm.model.BookingAttendees[] findByBookingId_PrevAndNext(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK,
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the booking attendeeses.
	*
	* @return the booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the booking attendeeses where attendeesId = &#63; from the database.
	*
	* @param attendeesId the attendees ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAttendeesId(long attendeesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the booking attendeeses where bookingId = &#63; from the database.
	*
	* @param bookingId the booking ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBookingId(long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the booking attendeeses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of booking attendeeses where attendeesId = &#63;.
	*
	* @param attendeesId the attendees ID
	* @return the number of matching booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public int countByAttendeesId(long attendeesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of booking attendeeses where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @return the number of matching booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public int countByBookingId(long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of booking attendeeses.
	*
	* @return the number of booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}