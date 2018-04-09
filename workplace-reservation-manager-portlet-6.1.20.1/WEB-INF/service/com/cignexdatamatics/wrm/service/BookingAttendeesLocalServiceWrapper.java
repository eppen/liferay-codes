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

package com.cignexdatamatics.wrm.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link BookingAttendeesLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       BookingAttendeesLocalService
 * @generated
 */
public class BookingAttendeesLocalServiceWrapper
	implements BookingAttendeesLocalService,
		ServiceWrapper<BookingAttendeesLocalService> {
	public BookingAttendeesLocalServiceWrapper(
		BookingAttendeesLocalService bookingAttendeesLocalService) {
		_bookingAttendeesLocalService = bookingAttendeesLocalService;
	}

	/**
	* Adds the booking attendees to the database. Also notifies the appropriate model listeners.
	*
	* @param bookingAttendees the booking attendees
	* @return the booking attendees that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees addBookingAttendees(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.addBookingAttendees(bookingAttendees);
	}

	/**
	* Creates a new booking attendees with the primary key. Does not add the booking attendees to the database.
	*
	* @param bookingAttendeesPK the primary key for the new booking attendees
	* @return the new booking attendees
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees createBookingAttendees(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK) {
		return _bookingAttendeesLocalService.createBookingAttendees(bookingAttendeesPK);
	}

	/**
	* Deletes the booking attendees with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingAttendeesPK the primary key of the booking attendees
	* @return the booking attendees that was removed
	* @throws PortalException if a booking attendees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees deleteBookingAttendees(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.deleteBookingAttendees(bookingAttendeesPK);
	}

	/**
	* Deletes the booking attendees from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingAttendees the booking attendees
	* @return the booking attendees that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees deleteBookingAttendees(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.deleteBookingAttendees(bookingAttendees);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bookingAttendeesLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cignexdatamatics.wrm.model.BookingAttendees fetchBookingAttendees(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.fetchBookingAttendees(bookingAttendeesPK);
	}

	/**
	* Returns the booking attendees with the primary key.
	*
	* @param bookingAttendeesPK the primary key of the booking attendees
	* @return the booking attendees
	* @throws PortalException if a booking attendees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees getBookingAttendees(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.getBookingAttendees(bookingAttendeesPK);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> getBookingAttendeeses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.getBookingAttendeeses(start, end);
	}

	/**
	* Returns the number of booking attendeeses.
	*
	* @return the number of booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public int getBookingAttendeesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.getBookingAttendeesesCount();
	}

	/**
	* Updates the booking attendees in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bookingAttendees the booking attendees
	* @return the booking attendees that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees updateBookingAttendees(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.updateBookingAttendees(bookingAttendees);
	}

	/**
	* Updates the booking attendees in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bookingAttendees the booking attendees
	* @param merge whether to merge the booking attendees with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the booking attendees that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingAttendees updateBookingAttendees(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.updateBookingAttendees(bookingAttendees,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _bookingAttendeesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bookingAttendeesLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bookingAttendeesLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findAllbyBookingId(
		long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.findAllbyBookingId(bookingId);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findAllbyAttendeesId(
		long attendeesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingAttendeesLocalService.findAllbyAttendeesId(attendeesId);
	}

	public void remove(com.cignexdatamatics.wrm.model.BookingAttendees ba)
		throws com.liferay.portal.kernel.exception.SystemException {
		_bookingAttendeesLocalService.remove(ba);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BookingAttendeesLocalService getWrappedBookingAttendeesLocalService() {
		return _bookingAttendeesLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBookingAttendeesLocalService(
		BookingAttendeesLocalService bookingAttendeesLocalService) {
		_bookingAttendeesLocalService = bookingAttendeesLocalService;
	}

	public BookingAttendeesLocalService getWrappedService() {
		return _bookingAttendeesLocalService;
	}

	public void setWrappedService(
		BookingAttendeesLocalService bookingAttendeesLocalService) {
		_bookingAttendeesLocalService = bookingAttendeesLocalService;
	}

	private BookingAttendeesLocalService _bookingAttendeesLocalService;
}