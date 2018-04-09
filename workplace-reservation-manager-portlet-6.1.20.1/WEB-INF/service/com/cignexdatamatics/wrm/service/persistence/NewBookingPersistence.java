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

import com.cignexdatamatics.wrm.model.NewBooking;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the new booking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewBookingPersistenceImpl
 * @see NewBookingUtil
 * @generated
 */
public interface NewBookingPersistence extends BasePersistence<NewBooking> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NewBookingUtil} to access the new booking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the new booking in the entity cache if it is enabled.
	*
	* @param newBooking the new booking
	*/
	public void cacheResult(
		com.cignexdatamatics.wrm.model.NewBooking newBooking);

	/**
	* Caches the new bookings in the entity cache if it is enabled.
	*
	* @param newBookings the new bookings
	*/
	public void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.NewBooking> newBookings);

	/**
	* Creates a new new booking with the primary key. Does not add the new booking to the database.
	*
	* @param bookingId the primary key for the new new booking
	* @return the new new booking
	*/
	public com.cignexdatamatics.wrm.model.NewBooking create(long bookingId);

	/**
	* Removes the new booking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingId the primary key of the new booking
	* @return the new booking that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchNewBookingException if a new booking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.NewBooking remove(long bookingId)
		throws com.cignexdatamatics.wrm.NoSuchNewBookingException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cignexdatamatics.wrm.model.NewBooking updateImpl(
		com.cignexdatamatics.wrm.model.NewBooking newBooking, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the new booking with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchNewBookingException} if it could not be found.
	*
	* @param bookingId the primary key of the new booking
	* @return the new booking
	* @throws com.cignexdatamatics.wrm.NoSuchNewBookingException if a new booking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.NewBooking findByPrimaryKey(
		long bookingId)
		throws com.cignexdatamatics.wrm.NoSuchNewBookingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the new booking with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookingId the primary key of the new booking
	* @return the new booking, or <code>null</code> if a new booking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.NewBooking fetchByPrimaryKey(
		long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the new bookings where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param startTime the start time
	* @param endTime the end time
	* @return the matching new bookings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.NewBooking> findByBookedRoomByDateandTime(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the new bookings where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param startTime the start time
	* @param endTime the end time
	* @param start the lower bound of the range of new bookings
	* @param end the upper bound of the range of new bookings (not inclusive)
	* @return the range of matching new bookings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.NewBooking> findByBookedRoomByDateandTime(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the new bookings where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param startTime the start time
	* @param endTime the end time
	* @param start the lower bound of the range of new bookings
	* @param end the upper bound of the range of new bookings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching new bookings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.NewBooking> findByBookedRoomByDateandTime(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first new booking in the ordered set where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param startTime the start time
	* @param endTime the end time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching new booking
	* @throws com.cignexdatamatics.wrm.NoSuchNewBookingException if a matching new booking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.NewBooking findByBookedRoomByDateandTime_First(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchNewBookingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first new booking in the ordered set where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param startTime the start time
	* @param endTime the end time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching new booking, or <code>null</code> if a matching new booking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.NewBooking fetchByBookedRoomByDateandTime_First(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last new booking in the ordered set where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param startTime the start time
	* @param endTime the end time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching new booking
	* @throws com.cignexdatamatics.wrm.NoSuchNewBookingException if a matching new booking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.NewBooking findByBookedRoomByDateandTime_Last(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchNewBookingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last new booking in the ordered set where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param startTime the start time
	* @param endTime the end time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching new booking, or <code>null</code> if a matching new booking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.NewBooking fetchByBookedRoomByDateandTime_Last(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the new bookings before and after the current new booking in the ordered set where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	*
	* @param bookingId the primary key of the current new booking
	* @param fromDate the from date
	* @param toDate the to date
	* @param startTime the start time
	* @param endTime the end time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next new booking
	* @throws com.cignexdatamatics.wrm.NoSuchNewBookingException if a new booking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.NewBooking[] findByBookedRoomByDateandTime_PrevAndNext(
		long bookingId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchNewBookingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the new bookings.
	*
	* @return the new bookings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.NewBooking> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the new bookings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of new bookings
	* @param end the upper bound of the range of new bookings (not inclusive)
	* @return the range of new bookings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.NewBooking> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the new bookings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of new bookings
	* @param end the upper bound of the range of new bookings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of new bookings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.NewBooking> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the new bookings where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63; from the database.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param startTime the start time
	* @param endTime the end time
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBookedRoomByDateandTime(java.util.Date fromDate,
		java.util.Date toDate, java.lang.String startTime,
		java.lang.String endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the new bookings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of new bookings where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param startTime the start time
	* @param endTime the end time
	* @return the number of matching new bookings
	* @throws SystemException if a system exception occurred
	*/
	public int countByBookedRoomByDateandTime(java.util.Date fromDate,
		java.util.Date toDate, java.lang.String startTime,
		java.lang.String endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of new bookings.
	*
	* @return the number of new bookings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}