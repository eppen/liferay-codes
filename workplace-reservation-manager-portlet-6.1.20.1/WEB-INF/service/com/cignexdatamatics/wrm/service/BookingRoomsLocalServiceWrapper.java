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
 * This class is a wrapper for {@link BookingRoomsLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       BookingRoomsLocalService
 * @generated
 */
public class BookingRoomsLocalServiceWrapper implements BookingRoomsLocalService,
	ServiceWrapper<BookingRoomsLocalService> {
	public BookingRoomsLocalServiceWrapper(
		BookingRoomsLocalService bookingRoomsLocalService) {
		_bookingRoomsLocalService = bookingRoomsLocalService;
	}

	/**
	* Adds the booking rooms to the database. Also notifies the appropriate model listeners.
	*
	* @param bookingRooms the booking rooms
	* @return the booking rooms that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingRooms addBookingRooms(
		com.cignexdatamatics.wrm.model.BookingRooms bookingRooms)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.addBookingRooms(bookingRooms);
	}

	/**
	* Creates a new booking rooms with the primary key. Does not add the booking rooms to the database.
	*
	* @param BRMappingId the primary key for the new booking rooms
	* @return the new booking rooms
	*/
	public com.cignexdatamatics.wrm.model.BookingRooms createBookingRooms(
		long BRMappingId) {
		return _bookingRoomsLocalService.createBookingRooms(BRMappingId);
	}

	/**
	* Deletes the booking rooms with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param BRMappingId the primary key of the booking rooms
	* @return the booking rooms that was removed
	* @throws PortalException if a booking rooms with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingRooms deleteBookingRooms(
		long BRMappingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.deleteBookingRooms(BRMappingId);
	}

	/**
	* Deletes the booking rooms from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingRooms the booking rooms
	* @return the booking rooms that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingRooms deleteBookingRooms(
		com.cignexdatamatics.wrm.model.BookingRooms bookingRooms)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.deleteBookingRooms(bookingRooms);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bookingRoomsLocalService.dynamicQuery();
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
		return _bookingRoomsLocalService.dynamicQuery(dynamicQuery);
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
		return _bookingRoomsLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _bookingRoomsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _bookingRoomsLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cignexdatamatics.wrm.model.BookingRooms fetchBookingRooms(
		long BRMappingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.fetchBookingRooms(BRMappingId);
	}

	/**
	* Returns the booking rooms with the primary key.
	*
	* @param BRMappingId the primary key of the booking rooms
	* @return the booking rooms
	* @throws PortalException if a booking rooms with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingRooms getBookingRooms(
		long BRMappingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.getBookingRooms(BRMappingId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> getBookingRoomses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.getBookingRoomses(start, end);
	}

	/**
	* Returns the number of booking roomses.
	*
	* @return the number of booking roomses
	* @throws SystemException if a system exception occurred
	*/
	public int getBookingRoomsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.getBookingRoomsesCount();
	}

	/**
	* Updates the booking rooms in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bookingRooms the booking rooms
	* @return the booking rooms that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingRooms updateBookingRooms(
		com.cignexdatamatics.wrm.model.BookingRooms bookingRooms)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.updateBookingRooms(bookingRooms);
	}

	/**
	* Updates the booking rooms in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bookingRooms the booking rooms
	* @param merge whether to merge the booking rooms with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the booking rooms that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.BookingRooms updateBookingRooms(
		com.cignexdatamatics.wrm.model.BookingRooms bookingRooms, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.updateBookingRooms(bookingRooms, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _bookingRoomsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bookingRoomsLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bookingRoomsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findAllBookingRooms()
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.findAllBookingRooms();
	}

	public java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findBookingRoomsByBookingDate(
		java.util.Date bookingDate)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.findBookingRoomsByBookingDate(bookingDate);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findMappingByBookingId(
		long bookingId)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.findMappingByBookingId(bookingId);
	}

	public com.cignexdatamatics.wrm.model.BookingRooms findBookingById(
		long brmappingId)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.findBookingById(brmappingId);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findAllBookingByRoomId(
		long roomId)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.findAllBookingByRoomId(roomId);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.BookingRooms> findAllBookingByRoomIdAndBookingDate(
		long roomId, java.util.Date bookingDate)
		throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingRoomsLocalService.findAllBookingByRoomIdAndBookingDate(roomId,
			bookingDate);
	}

	public void remove(com.cignexdatamatics.wrm.model.BookingRooms br)
		throws com.liferay.portal.kernel.exception.SystemException {
		_bookingRoomsLocalService.remove(br);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BookingRoomsLocalService getWrappedBookingRoomsLocalService() {
		return _bookingRoomsLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBookingRoomsLocalService(
		BookingRoomsLocalService bookingRoomsLocalService) {
		_bookingRoomsLocalService = bookingRoomsLocalService;
	}

	public BookingRoomsLocalService getWrappedService() {
		return _bookingRoomsLocalService;
	}

	public void setWrappedService(
		BookingRoomsLocalService bookingRoomsLocalService) {
		_bookingRoomsLocalService = bookingRoomsLocalService;
	}

	private BookingRoomsLocalService _bookingRoomsLocalService;
}