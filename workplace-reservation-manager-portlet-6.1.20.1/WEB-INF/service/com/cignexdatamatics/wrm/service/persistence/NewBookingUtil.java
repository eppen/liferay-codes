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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the new booking service. This utility wraps {@link NewBookingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewBookingPersistence
 * @see NewBookingPersistenceImpl
 * @generated
 */
public class NewBookingUtil {
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
	public static void clearCache(NewBooking newBooking) {
		getPersistence().clearCache(newBooking);
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
	public static List<NewBooking> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NewBooking> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NewBooking> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static NewBooking update(NewBooking newBooking, boolean merge)
		throws SystemException {
		return getPersistence().update(newBooking, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static NewBooking update(NewBooking newBooking, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(newBooking, merge, serviceContext);
	}

	/**
	* Caches the new booking in the entity cache if it is enabled.
	*
	* @param newBooking the new booking
	*/
	public static void cacheResult(
		com.cignexdatamatics.wrm.model.NewBooking newBooking) {
		getPersistence().cacheResult(newBooking);
	}

	/**
	* Caches the new bookings in the entity cache if it is enabled.
	*
	* @param newBookings the new bookings
	*/
	public static void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.NewBooking> newBookings) {
		getPersistence().cacheResult(newBookings);
	}

	/**
	* Creates a new new booking with the primary key. Does not add the new booking to the database.
	*
	* @param bookingId the primary key for the new new booking
	* @return the new new booking
	*/
	public static com.cignexdatamatics.wrm.model.NewBooking create(
		long bookingId) {
		return getPersistence().create(bookingId);
	}

	/**
	* Removes the new booking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingId the primary key of the new booking
	* @return the new booking that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchNewBookingException if a new booking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.NewBooking remove(
		long bookingId)
		throws com.cignexdatamatics.wrm.NoSuchNewBookingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(bookingId);
	}

	public static com.cignexdatamatics.wrm.model.NewBooking updateImpl(
		com.cignexdatamatics.wrm.model.NewBooking newBooking, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(newBooking, merge);
	}

	/**
	* Returns the new booking with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchNewBookingException} if it could not be found.
	*
	* @param bookingId the primary key of the new booking
	* @return the new booking
	* @throws com.cignexdatamatics.wrm.NoSuchNewBookingException if a new booking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.NewBooking findByPrimaryKey(
		long bookingId)
		throws com.cignexdatamatics.wrm.NoSuchNewBookingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(bookingId);
	}

	/**
	* Returns the new booking with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookingId the primary key of the new booking
	* @return the new booking, or <code>null</code> if a new booking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.NewBooking fetchByPrimaryKey(
		long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bookingId);
	}

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
	public static java.util.List<com.cignexdatamatics.wrm.model.NewBooking> findByBookedRoomByDateandTime(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookedRoomByDateandTime(fromDate, toDate, startTime,
			endTime);
	}

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
	public static java.util.List<com.cignexdatamatics.wrm.model.NewBooking> findByBookedRoomByDateandTime(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookedRoomByDateandTime(fromDate, toDate, startTime,
			endTime, start, end);
	}

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
	public static java.util.List<com.cignexdatamatics.wrm.model.NewBooking> findByBookedRoomByDateandTime(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookedRoomByDateandTime(fromDate, toDate, startTime,
			endTime, start, end, orderByComparator);
	}

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
	public static com.cignexdatamatics.wrm.model.NewBooking findByBookedRoomByDateandTime_First(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchNewBookingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookedRoomByDateandTime_First(fromDate, toDate,
			startTime, endTime, orderByComparator);
	}

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
	public static com.cignexdatamatics.wrm.model.NewBooking fetchByBookedRoomByDateandTime_First(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBookedRoomByDateandTime_First(fromDate, toDate,
			startTime, endTime, orderByComparator);
	}

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
	public static com.cignexdatamatics.wrm.model.NewBooking findByBookedRoomByDateandTime_Last(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchNewBookingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookedRoomByDateandTime_Last(fromDate, toDate,
			startTime, endTime, orderByComparator);
	}

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
	public static com.cignexdatamatics.wrm.model.NewBooking fetchByBookedRoomByDateandTime_Last(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBookedRoomByDateandTime_Last(fromDate, toDate,
			startTime, endTime, orderByComparator);
	}

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
	public static com.cignexdatamatics.wrm.model.NewBooking[] findByBookedRoomByDateandTime_PrevAndNext(
		long bookingId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cignexdatamatics.wrm.NoSuchNewBookingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookedRoomByDateandTime_PrevAndNext(bookingId,
			fromDate, toDate, startTime, endTime, orderByComparator);
	}

	/**
	* Returns all the new bookings.
	*
	* @return the new bookings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.NewBooking> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.cignexdatamatics.wrm.model.NewBooking> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.cignexdatamatics.wrm.model.NewBooking> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the new bookings where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63; from the database.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param startTime the start time
	* @param endTime the end time
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBookedRoomByDateandTime(
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String startTime, java.lang.String endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByBookedRoomByDateandTime(fromDate, toDate, startTime,
			endTime);
	}

	/**
	* Removes all the new bookings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

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
	public static int countByBookedRoomByDateandTime(java.util.Date fromDate,
		java.util.Date toDate, java.lang.String startTime,
		java.lang.String endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByBookedRoomByDateandTime(fromDate, toDate, startTime,
			endTime);
	}

	/**
	* Returns the number of new bookings.
	*
	* @return the number of new bookings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NewBookingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NewBookingPersistence)PortletBeanLocatorUtil.locate(com.cignexdatamatics.wrm.service.ClpSerializer.getServletContextName(),
					NewBookingPersistence.class.getName());

			ReferenceRegistry.registerReference(NewBookingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(NewBookingPersistence persistence) {
	}

	private static NewBookingPersistence _persistence;
}