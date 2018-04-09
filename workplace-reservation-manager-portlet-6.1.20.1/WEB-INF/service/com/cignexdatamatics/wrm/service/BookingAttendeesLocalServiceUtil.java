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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the booking attendees local service. This utility wraps {@link com.cignexdatamatics.wrm.service.impl.BookingAttendeesLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingAttendeesLocalService
 * @see com.cignexdatamatics.wrm.service.base.BookingAttendeesLocalServiceBaseImpl
 * @see com.cignexdatamatics.wrm.service.impl.BookingAttendeesLocalServiceImpl
 * @generated
 */
public class BookingAttendeesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cignexdatamatics.wrm.service.impl.BookingAttendeesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the booking attendees to the database. Also notifies the appropriate model listeners.
	*
	* @param bookingAttendees the booking attendees
	* @return the booking attendees that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees addBookingAttendees(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBookingAttendees(bookingAttendees);
	}

	/**
	* Creates a new booking attendees with the primary key. Does not add the booking attendees to the database.
	*
	* @param bookingAttendeesPK the primary key for the new booking attendees
	* @return the new booking attendees
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees createBookingAttendees(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK) {
		return getService().createBookingAttendees(bookingAttendeesPK);
	}

	/**
	* Deletes the booking attendees with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingAttendeesPK the primary key of the booking attendees
	* @return the booking attendees that was removed
	* @throws PortalException if a booking attendees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees deleteBookingAttendees(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBookingAttendees(bookingAttendeesPK);
	}

	/**
	* Deletes the booking attendees from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingAttendees the booking attendees
	* @return the booking attendees that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees deleteBookingAttendees(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBookingAttendees(bookingAttendees);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.cignexdatamatics.wrm.model.BookingAttendees fetchBookingAttendees(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBookingAttendees(bookingAttendeesPK);
	}

	/**
	* Returns the booking attendees with the primary key.
	*
	* @param bookingAttendeesPK the primary key of the booking attendees
	* @return the booking attendees
	* @throws PortalException if a booking attendees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees getBookingAttendees(
		com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK bookingAttendeesPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBookingAttendees(bookingAttendeesPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> getBookingAttendeeses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBookingAttendeeses(start, end);
	}

	/**
	* Returns the number of booking attendeeses.
	*
	* @return the number of booking attendeeses
	* @throws SystemException if a system exception occurred
	*/
	public static int getBookingAttendeesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBookingAttendeesesCount();
	}

	/**
	* Updates the booking attendees in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bookingAttendees the booking attendees
	* @return the booking attendees that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees updateBookingAttendees(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBookingAttendees(bookingAttendees);
	}

	/**
	* Updates the booking attendees in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bookingAttendees the booking attendees
	* @param merge whether to merge the booking attendees with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the booking attendees that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingAttendees updateBookingAttendees(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBookingAttendees(bookingAttendees, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findAllbyBookingId(
		long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllbyBookingId(bookingId);
	}

	public static java.util.List<com.cignexdatamatics.wrm.model.BookingAttendees> findAllbyAttendeesId(
		long attendeesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllbyAttendeesId(attendeesId);
	}

	public static void remove(
		com.cignexdatamatics.wrm.model.BookingAttendees ba)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().remove(ba);
	}

	public static void clearService() {
		_service = null;
	}

	public static BookingAttendeesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BookingAttendeesLocalService.class.getName());

			if (invokableLocalService instanceof BookingAttendeesLocalService) {
				_service = (BookingAttendeesLocalService)invokableLocalService;
			}
			else {
				_service = new BookingAttendeesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BookingAttendeesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(BookingAttendeesLocalService service) {
	}

	private static BookingAttendeesLocalService _service;
}