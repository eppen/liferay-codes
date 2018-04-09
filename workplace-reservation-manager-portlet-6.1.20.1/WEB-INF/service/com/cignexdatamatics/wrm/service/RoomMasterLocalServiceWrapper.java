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
 * This class is a wrapper for {@link RoomMasterLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       RoomMasterLocalService
 * @generated
 */
public class RoomMasterLocalServiceWrapper implements RoomMasterLocalService,
	ServiceWrapper<RoomMasterLocalService> {
	public RoomMasterLocalServiceWrapper(
		RoomMasterLocalService roomMasterLocalService) {
		_roomMasterLocalService = roomMasterLocalService;
	}

	/**
	* Adds the room master to the database. Also notifies the appropriate model listeners.
	*
	* @param roomMaster the room master
	* @return the room master that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomMaster addRoomMaster(
		com.cignexdatamatics.wrm.model.RoomMaster roomMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.addRoomMaster(roomMaster);
	}

	/**
	* Creates a new room master with the primary key. Does not add the room master to the database.
	*
	* @param roomId the primary key for the new room master
	* @return the new room master
	*/
	public com.cignexdatamatics.wrm.model.RoomMaster createRoomMaster(
		long roomId) {
		return _roomMasterLocalService.createRoomMaster(roomId);
	}

	/**
	* Deletes the room master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roomId the primary key of the room master
	* @return the room master that was removed
	* @throws PortalException if a room master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomMaster deleteRoomMaster(
		long roomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.deleteRoomMaster(roomId);
	}

	/**
	* Deletes the room master from the database. Also notifies the appropriate model listeners.
	*
	* @param roomMaster the room master
	* @return the room master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomMaster deleteRoomMaster(
		com.cignexdatamatics.wrm.model.RoomMaster roomMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.deleteRoomMaster(roomMaster);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _roomMasterLocalService.dynamicQuery();
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
		return _roomMasterLocalService.dynamicQuery(dynamicQuery);
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
		return _roomMasterLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _roomMasterLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _roomMasterLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cignexdatamatics.wrm.model.RoomMaster fetchRoomMaster(
		long roomId) throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.fetchRoomMaster(roomId);
	}

	/**
	* Returns the room master with the primary key.
	*
	* @param roomId the primary key of the room master
	* @return the room master
	* @throws PortalException if a room master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomMaster getRoomMaster(long roomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.getRoomMaster(roomId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> getRoomMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.getRoomMasters(start, end);
	}

	/**
	* Returns the number of room masters.
	*
	* @return the number of room masters
	* @throws SystemException if a system exception occurred
	*/
	public int getRoomMastersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.getRoomMastersCount();
	}

	/**
	* Updates the room master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param roomMaster the room master
	* @return the room master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomMaster updateRoomMaster(
		com.cignexdatamatics.wrm.model.RoomMaster roomMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.updateRoomMaster(roomMaster);
	}

	/**
	* Updates the room master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param roomMaster the room master
	* @param merge whether to merge the room master with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the room master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomMaster updateRoomMaster(
		com.cignexdatamatics.wrm.model.RoomMaster roomMaster, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.updateRoomMaster(roomMaster, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _roomMasterLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_roomMasterLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _roomMasterLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAllRoom()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.findAllRoom();
	}

	public java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAllInFloor(
		long floorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.findAllInFloor(floorId);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAllInLocation(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.findAllInLocation(locationId);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAllRoomInCity(
		long cityId) throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.findAllRoomInCity(cityId);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAllRoomByLocandCity(
		long cityId, long locId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.findAllRoomByLocandCity(cityId, locId);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.RoomMaster> findAllRoomByLocationCityFloor(
		long cityId, long locationId, long floorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.findAllRoomByLocationCityFloor(cityId,
			locationId, floorId);
	}

	public com.cignexdatamatics.wrm.model.RoomMaster findRoomByRoomId(
		long roomId)
		throws com.cignexdatamatics.wrm.NoSuchRoomMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.findRoomByRoomId(roomId);
	}

	public com.cignexdatamatics.wrm.model.RoomMaster addRoom(
		com.cignexdatamatics.wrm.model.RoomMaster validRoom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomMasterLocalService.addRoom(validRoom);
	}

	public void remove(com.cignexdatamatics.wrm.model.RoomMaster room)
		throws com.liferay.portal.kernel.exception.SystemException {
		_roomMasterLocalService.remove(room);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public RoomMasterLocalService getWrappedRoomMasterLocalService() {
		return _roomMasterLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRoomMasterLocalService(
		RoomMasterLocalService roomMasterLocalService) {
		_roomMasterLocalService = roomMasterLocalService;
	}

	public RoomMasterLocalService getWrappedService() {
		return _roomMasterLocalService;
	}

	public void setWrappedService(RoomMasterLocalService roomMasterLocalService) {
		_roomMasterLocalService = roomMasterLocalService;
	}

	private RoomMasterLocalService _roomMasterLocalService;
}