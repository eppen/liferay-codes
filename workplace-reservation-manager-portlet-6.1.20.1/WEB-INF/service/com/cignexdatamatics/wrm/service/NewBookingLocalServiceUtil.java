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
 * The utility for the new booking local service. This utility wraps {@link com.cignexdatamatics.wrm.service.impl.NewBookingLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewBookingLocalService
 * @see com.cignexdatamatics.wrm.service.base.NewBookingLocalServiceBaseImpl
 * @see com.cignexdatamatics.wrm.service.impl.NewBookingLocalServiceImpl
 * @generated
 */
public class NewBookingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cignexdatamatics.wrm.service.impl.NewBookingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the new booking to the database. Also notifies the appropriate model listeners.
	*
	* @param newBooking the new booking
	* @return the new booking that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.NewBooking addNewBooking(
		com.cignexdatamatics.wrm.model.NewBooking newBooking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addNewBooking(newBooking);
	}

	/**
	* Creates a new new booking with the primary key. Does not add the new booking to the database.
	*
	* @param bookingId the primary key for the new new booking
	* @return the new new booking
	*/
	public static com.cignexdatamatics.wrm.model.NewBooking createNewBooking(
		long bookingId) {
		return getService().createNewBooking(bookingId);
	}

	/**
	* Deletes the new booking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingId the primary key of the new booking
	* @return the new booking that was removed
	* @throws PortalException if a new booking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.NewBooking deleteNewBooking(
		long bookingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteNewBooking(bookingId);
	}

	/**
	* Deletes the new booking from the database. Also notifies the appropriate model listeners.
	*
	* @param newBooking the new booking
	* @return the new booking that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.NewBooking deleteNewBooking(
		com.cignexdatamatics.wrm.model.NewBooking newBooking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteNewBooking(newBooking);
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

	public static com.cignexdatamatics.wrm.model.NewBooking fetchNewBooking(
		long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchNewBooking(bookingId);
	}

	/**
	* Returns the new booking with the primary key.
	*
	* @param bookingId the primary key of the new booking
	* @return the new booking
	* @throws PortalException if a new booking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.NewBooking getNewBooking(
		long bookingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewBooking(bookingId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.cignexdatamatics.wrm.model.NewBooking> getNewBookings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewBookings(start, end);
	}

	/**
	* Returns the number of new bookings.
	*
	* @return the number of new bookings
	* @throws SystemException if a system exception occurred
	*/
	public static int getNewBookingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewBookingsCount();
	}

	/**
	* Updates the new booking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param newBooking the new booking
	* @return the new booking that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.NewBooking updateNewBooking(
		com.cignexdatamatics.wrm.model.NewBooking newBooking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNewBooking(newBooking);
	}

	/**
	* Updates the new booking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param newBooking the new booking
	* @param merge whether to merge the new booking with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the new booking that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.NewBooking updateNewBooking(
		com.cignexdatamatics.wrm.model.NewBooking newBooking, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNewBooking(newBooking, merge);
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

	public static java.util.List<com.cignexdatamatics.wrm.model.NewBooking> findAllBookedRoomByDateandTime(
		java.util.Date sd, java.util.Date ed, java.lang.String st,
		java.lang.String et)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllBookedRoomByDateandTime(sd, ed, st, et);
	}

	public static com.cignexdatamatics.wrm.model.NewBooking findAllBookingbyBookingId(
		long bookingId)
		throws com.cignexdatamatics.wrm.NoSuchNewBookingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllBookingbyBookingId(bookingId);
	}

	public static void remove(
		com.cignexdatamatics.wrm.model.NewBooking newBooking)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().remove(newBooking);
	}

	public static void clearService() {
		_service = null;
	}

	public static NewBookingLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					NewBookingLocalService.class.getName());

			if (invokableLocalService instanceof NewBookingLocalService) {
				_service = (NewBookingLocalService)invokableLocalService;
			}
			else {
				_service = new NewBookingLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(NewBookingLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(NewBookingLocalService service) {
	}

	private static NewBookingLocalService _service;
}