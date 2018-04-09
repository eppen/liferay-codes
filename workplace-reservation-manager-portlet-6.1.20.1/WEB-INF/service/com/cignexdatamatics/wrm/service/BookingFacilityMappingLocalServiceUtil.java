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
 * The utility for the booking facility mapping local service. This utility wraps {@link com.cignexdatamatics.wrm.service.impl.BookingFacilityMappingLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingFacilityMappingLocalService
 * @see com.cignexdatamatics.wrm.service.base.BookingFacilityMappingLocalServiceBaseImpl
 * @see com.cignexdatamatics.wrm.service.impl.BookingFacilityMappingLocalServiceImpl
 * @generated
 */
public class BookingFacilityMappingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cignexdatamatics.wrm.service.impl.BookingFacilityMappingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the booking facility mapping to the database. Also notifies the appropriate model listeners.
	*
	* @param bookingFacilityMapping the booking facility mapping
	* @return the booking facility mapping that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping addBookingFacilityMapping(
		com.cignexdatamatics.wrm.model.BookingFacilityMapping bookingFacilityMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBookingFacilityMapping(bookingFacilityMapping);
	}

	/**
	* Creates a new booking facility mapping with the primary key. Does not add the booking facility mapping to the database.
	*
	* @param bookingFacilityMappingPK the primary key for the new booking facility mapping
	* @return the new booking facility mapping
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping createBookingFacilityMapping(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK) {
		return getService()
				   .createBookingFacilityMapping(bookingFacilityMappingPK);
	}

	/**
	* Deletes the booking facility mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingFacilityMappingPK the primary key of the booking facility mapping
	* @return the booking facility mapping that was removed
	* @throws PortalException if a booking facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping deleteBookingFacilityMapping(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteBookingFacilityMapping(bookingFacilityMappingPK);
	}

	/**
	* Deletes the booking facility mapping from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingFacilityMapping the booking facility mapping
	* @return the booking facility mapping that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping deleteBookingFacilityMapping(
		com.cignexdatamatics.wrm.model.BookingFacilityMapping bookingFacilityMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBookingFacilityMapping(bookingFacilityMapping);
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

	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping fetchBookingFacilityMapping(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBookingFacilityMapping(bookingFacilityMappingPK);
	}

	/**
	* Returns the booking facility mapping with the primary key.
	*
	* @param bookingFacilityMappingPK the primary key of the booking facility mapping
	* @return the booking facility mapping
	* @throws PortalException if a booking facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping getBookingFacilityMapping(
		com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPK bookingFacilityMappingPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBookingFacilityMapping(bookingFacilityMappingPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> getBookingFacilityMappings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBookingFacilityMappings(start, end);
	}

	/**
	* Returns the number of booking facility mappings.
	*
	* @return the number of booking facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public static int getBookingFacilityMappingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBookingFacilityMappingsCount();
	}

	/**
	* Updates the booking facility mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bookingFacilityMapping the booking facility mapping
	* @return the booking facility mapping that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping updateBookingFacilityMapping(
		com.cignexdatamatics.wrm.model.BookingFacilityMapping bookingFacilityMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBookingFacilityMapping(bookingFacilityMapping);
	}

	/**
	* Updates the booking facility mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bookingFacilityMapping the booking facility mapping
	* @param merge whether to merge the booking facility mapping with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the booking facility mapping that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.BookingFacilityMapping updateBookingFacilityMapping(
		com.cignexdatamatics.wrm.model.BookingFacilityMapping bookingFacilityMapping,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBookingFacilityMapping(bookingFacilityMapping, merge);
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

	public static java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findAllMappingbyRoomId(
		long bookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllMappingbyRoomId(bookingId);
	}

	public static java.util.List<com.cignexdatamatics.wrm.model.BookingFacilityMapping> findAllMappingbyFacilitiesId(
		long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllMappingbyFacilitiesId(facilitiesId);
	}

	public static com.cignexdatamatics.wrm.model.RoomFacilityMapping addRoomFacilityMapping(
		com.cignexdatamatics.wrm.model.RoomFacilityMapping validRoomFacilityMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRoomFacilityMapping(validRoomFacilityMapping);
	}

	public static void remove(
		com.cignexdatamatics.wrm.model.BookingFacilityMapping bfm)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().remove(bfm);
	}

	public static void clearService() {
		_service = null;
	}

	public static BookingFacilityMappingLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BookingFacilityMappingLocalService.class.getName());

			if (invokableLocalService instanceof BookingFacilityMappingLocalService) {
				_service = (BookingFacilityMappingLocalService)invokableLocalService;
			}
			else {
				_service = new BookingFacilityMappingLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BookingFacilityMappingLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(BookingFacilityMappingLocalService service) {
	}

	private static BookingFacilityMappingLocalService _service;
}