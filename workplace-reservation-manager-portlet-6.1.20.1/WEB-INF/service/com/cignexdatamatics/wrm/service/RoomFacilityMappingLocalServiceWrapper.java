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
 * This class is a wrapper for {@link RoomFacilityMappingLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       RoomFacilityMappingLocalService
 * @generated
 */
public class RoomFacilityMappingLocalServiceWrapper
	implements RoomFacilityMappingLocalService,
		ServiceWrapper<RoomFacilityMappingLocalService> {
	public RoomFacilityMappingLocalServiceWrapper(
		RoomFacilityMappingLocalService roomFacilityMappingLocalService) {
		_roomFacilityMappingLocalService = roomFacilityMappingLocalService;
	}

	/**
	* Adds the room facility mapping to the database. Also notifies the appropriate model listeners.
	*
	* @param roomFacilityMapping the room facility mapping
	* @return the room facility mapping that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping addRoomFacilityMapping(
		com.cignexdatamatics.wrm.model.RoomFacilityMapping roomFacilityMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomFacilityMappingLocalService.addRoomFacilityMapping(roomFacilityMapping);
	}

	/**
	* Creates a new room facility mapping with the primary key. Does not add the room facility mapping to the database.
	*
	* @param roomFacilityMappingPK the primary key for the new room facility mapping
	* @return the new room facility mapping
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping createRoomFacilityMapping(
		com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK roomFacilityMappingPK) {
		return _roomFacilityMappingLocalService.createRoomFacilityMapping(roomFacilityMappingPK);
	}

	/**
	* Deletes the room facility mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roomFacilityMappingPK the primary key of the room facility mapping
	* @return the room facility mapping that was removed
	* @throws PortalException if a room facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping deleteRoomFacilityMapping(
		com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK roomFacilityMappingPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roomFacilityMappingLocalService.deleteRoomFacilityMapping(roomFacilityMappingPK);
	}

	/**
	* Deletes the room facility mapping from the database. Also notifies the appropriate model listeners.
	*
	* @param roomFacilityMapping the room facility mapping
	* @return the room facility mapping that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping deleteRoomFacilityMapping(
		com.cignexdatamatics.wrm.model.RoomFacilityMapping roomFacilityMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomFacilityMappingLocalService.deleteRoomFacilityMapping(roomFacilityMapping);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _roomFacilityMappingLocalService.dynamicQuery();
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
		return _roomFacilityMappingLocalService.dynamicQuery(dynamicQuery);
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
		return _roomFacilityMappingLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _roomFacilityMappingLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _roomFacilityMappingLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cignexdatamatics.wrm.model.RoomFacilityMapping fetchRoomFacilityMapping(
		com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK roomFacilityMappingPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomFacilityMappingLocalService.fetchRoomFacilityMapping(roomFacilityMappingPK);
	}

	/**
	* Returns the room facility mapping with the primary key.
	*
	* @param roomFacilityMappingPK the primary key of the room facility mapping
	* @return the room facility mapping
	* @throws PortalException if a room facility mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping getRoomFacilityMapping(
		com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK roomFacilityMappingPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roomFacilityMappingLocalService.getRoomFacilityMapping(roomFacilityMappingPK);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roomFacilityMappingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the room facility mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of room facility mappings
	* @param end the upper bound of the range of room facility mappings (not inclusive)
	* @return the range of room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.RoomFacilityMapping> getRoomFacilityMappings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomFacilityMappingLocalService.getRoomFacilityMappings(start,
			end);
	}

	/**
	* Returns the number of room facility mappings.
	*
	* @return the number of room facility mappings
	* @throws SystemException if a system exception occurred
	*/
	public int getRoomFacilityMappingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomFacilityMappingLocalService.getRoomFacilityMappingsCount();
	}

	/**
	* Updates the room facility mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param roomFacilityMapping the room facility mapping
	* @return the room facility mapping that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping updateRoomFacilityMapping(
		com.cignexdatamatics.wrm.model.RoomFacilityMapping roomFacilityMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomFacilityMappingLocalService.updateRoomFacilityMapping(roomFacilityMapping);
	}

	/**
	* Updates the room facility mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param roomFacilityMapping the room facility mapping
	* @param merge whether to merge the room facility mapping with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the room facility mapping that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.RoomFacilityMapping updateRoomFacilityMapping(
		com.cignexdatamatics.wrm.model.RoomFacilityMapping roomFacilityMapping,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomFacilityMappingLocalService.updateRoomFacilityMapping(roomFacilityMapping,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _roomFacilityMappingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_roomFacilityMappingLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _roomFacilityMappingLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.RoomFacilityMapping> findAllMappingbyRoomId(
		long roomId) throws com.liferay.portal.kernel.exception.SystemException {
		return _roomFacilityMappingLocalService.findAllMappingbyRoomId(roomId);
	}

	public java.util.List<com.cignexdatamatics.wrm.model.RoomFacilityMapping> findAllMappingbyFacilitiesId(
		long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomFacilityMappingLocalService.findAllMappingbyFacilitiesId(facilitiesId);
	}

	public void remove(com.cignexdatamatics.wrm.model.RoomFacilityMapping rfm)
		throws com.liferay.portal.kernel.exception.SystemException {
		_roomFacilityMappingLocalService.remove(rfm);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public RoomFacilityMappingLocalService getWrappedRoomFacilityMappingLocalService() {
		return _roomFacilityMappingLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRoomFacilityMappingLocalService(
		RoomFacilityMappingLocalService roomFacilityMappingLocalService) {
		_roomFacilityMappingLocalService = roomFacilityMappingLocalService;
	}

	public RoomFacilityMappingLocalService getWrappedService() {
		return _roomFacilityMappingLocalService;
	}

	public void setWrappedService(
		RoomFacilityMappingLocalService roomFacilityMappingLocalService) {
		_roomFacilityMappingLocalService = roomFacilityMappingLocalService;
	}

	private RoomFacilityMappingLocalService _roomFacilityMappingLocalService;
}