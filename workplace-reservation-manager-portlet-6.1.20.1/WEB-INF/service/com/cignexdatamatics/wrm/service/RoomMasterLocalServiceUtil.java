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
 * The utility for the room master local service. This utility wraps {@link com.cignexdatamatics.wrm.service.impl.RoomMasterLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomMasterLocalService
 * @see com.cignexdatamatics.wrm.service.base.RoomMasterLocalServiceBaseImpl
 * @see com.cignexdatamatics.wrm.service.impl.RoomMasterLocalServiceImpl
 * @generated
 */
public class RoomMasterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cignexdatamatics.wrm.service.impl.RoomMasterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the room master to the database. Also notifies the appropriate model listeners.
	*
	* @param roomMaster the room master
	* @return the room master that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster addRoomMaster(
		com.cignexdatamatics.wrm.model.RoomMaster roomMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRoomMaster(roomMaster);
	}

	/**
	* Creates a new room master with the primary key. Does not add the room master to the database.
	*
	* @param roomId the primary key for the new room master
	* @return the new room master
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster createRoomMaster(
		long roomId) {
		return getService().createRoomMaster(roomId);
	}

	/**
	* Deletes the room master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roomId the primary key of the room master
	* @return the room master that was removed
	* @throws PortalException if a room master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster deleteRoomMaster(
		long roomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRoomMaster(roomId);
	}

	/**
	* Deletes the room master from the database. Also notifies the appropriate model listeners.
	*
	* @param roomMaster the room master
	* @return the room master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster deleteRoomMaster(
		com.cignexdatamatics.wrm.model.RoomMaster roomMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRoomMaster(roomMaster);
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

	public static com.cignexdatamatics.wrm.model.RoomMaster fetchRoomMaster(
		long roomId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRoomMaster(roomId);
	}

	/**
	* Returns the room master with the primary key.
	*
	* @param roomId the primary key of the room master
	* @return the room master
	* @throws PortalException if a room master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster getRoomMaster(
		long roomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRoomMaster(roomId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the room masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of room masters
	* @param end the upper bound of the range of room masters (not inclusive)
	* @return the range of room masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> getRoomMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRoomMasters(start, end);
	}

	/**
	* Returns the number of room masters.
	*
	* @return the number of room masters
	* @throws SystemException if a system exception occurred
	*/
	public static int getRoomMastersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRoomMastersCount();
	}

	/**
	* Updates the room master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param roomMaster the room master
	* @return the room master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster updateRoomMaster(
		com.cignexdatamatics.wrm.model.RoomMaster roomMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRoomMaster(roomMaster);
	}

	/**
	* Updates the room master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param roomMaster the room master
	* @param merge whether to merge the room master with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the room master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.RoomMaster updateRoomMaster(
		com.cignexdatamatics.wrm.model.RoomMaster roomMaster, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRoomMaster(roomMaster, merge);
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

	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAllRoom()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllRoom();
	}

	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAllInFloor(
		long floorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInFloor(floorId);
	}

	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAllInLocation(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInLocation(locationId);
	}

	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAllRoomInCity(
		long cityId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllRoomInCity(cityId);
	}

	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAllRoomByLocandCity(
		long cityId, long locId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllRoomByLocandCity(cityId, locId);
	}

	public static java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAllRoomByLocationCityFloor(
		long cityId, long locationId, long floorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findAllRoomByLocationCityFloor(cityId, locationId, floorId);
	}

	public static com.cignexdatamatics.wrm.model.RoomMaster findRoomByRoomId(
		long roomId)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findRoomByRoomId(roomId);
	}

	public static com.cignexdatamatics.wrm.model.RoomMaster addRoom(
		com.cignexdatamatics.wrm.model.RoomMaster validRoom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRoom(validRoom);
	}

	public static void remove(com.cignexdatamatics.wrm.model.RoomMaster room)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().remove(room);
	}

	public static void clearService() {
		_service = null;
	}

	public static RoomMasterLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RoomMasterLocalService.class.getName());

			if (invokableLocalService instanceof RoomMasterLocalService) {
				_service = (RoomMasterLocalService)invokableLocalService;
			}
			else {
				_service = new RoomMasterLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RoomMasterLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(RoomMasterLocalService service) {
	}

	private static RoomMasterLocalService _service;
}