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

package com.cignexdatamatics.wrm.service.base;

import com.cignexdatamatics.wrm.model.BookingAttendees;
import com.cignexdatamatics.wrm.service.BookingAttendeesLocalService;
import com.cignexdatamatics.wrm.service.BookingFacilityMappingLocalService;
import com.cignexdatamatics.wrm.service.BookingRoomsLocalService;
import com.cignexdatamatics.wrm.service.CityMasterLocalService;
import com.cignexdatamatics.wrm.service.FacilityMasterLocalService;
import com.cignexdatamatics.wrm.service.FloorMasterLocalService;
import com.cignexdatamatics.wrm.service.LocationMasterLocalService;
import com.cignexdatamatics.wrm.service.NewBookingLocalService;
import com.cignexdatamatics.wrm.service.NewBookingService;
import com.cignexdatamatics.wrm.service.RoomFacilityMappingLocalService;
import com.cignexdatamatics.wrm.service.RoomMasterLocalService;
import com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPK;
import com.cignexdatamatics.wrm.service.persistence.BookingAttendeesPersistence;
import com.cignexdatamatics.wrm.service.persistence.BookingFacilityMappingPersistence;
import com.cignexdatamatics.wrm.service.persistence.BookingRoomsPersistence;
import com.cignexdatamatics.wrm.service.persistence.CityMasterPersistence;
import com.cignexdatamatics.wrm.service.persistence.FacilityMasterPersistence;
import com.cignexdatamatics.wrm.service.persistence.FloorMasterPersistence;
import com.cignexdatamatics.wrm.service.persistence.LocationMasterPersistence;
import com.cignexdatamatics.wrm.service.persistence.NewBookingPersistence;
import com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPersistence;
import com.cignexdatamatics.wrm.service.persistence.RoomMasterPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the booking attendees local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.cignexdatamatics.wrm.service.impl.BookingAttendeesLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.cignexdatamatics.wrm.service.impl.BookingAttendeesLocalServiceImpl
 * @see com.cignexdatamatics.wrm.service.BookingAttendeesLocalServiceUtil
 * @generated
 */
public abstract class BookingAttendeesLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements BookingAttendeesLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.cignexdatamatics.wrm.service.BookingAttendeesLocalServiceUtil} to access the booking attendees local service.
	 */

	/**
	 * Adds the booking attendees to the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingAttendees the booking attendees
	 * @return the booking attendees that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public BookingAttendees addBookingAttendees(
		BookingAttendees bookingAttendees) throws SystemException {
		bookingAttendees.setNew(true);

		return bookingAttendeesPersistence.update(bookingAttendees, false);
	}

	/**
	 * Creates a new booking attendees with the primary key. Does not add the booking attendees to the database.
	 *
	 * @param bookingAttendeesPK the primary key for the new booking attendees
	 * @return the new booking attendees
	 */
	public BookingAttendees createBookingAttendees(
		BookingAttendeesPK bookingAttendeesPK) {
		return bookingAttendeesPersistence.create(bookingAttendeesPK);
	}

	/**
	 * Deletes the booking attendees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingAttendeesPK the primary key of the booking attendees
	 * @return the booking attendees that was removed
	 * @throws PortalException if a booking attendees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public BookingAttendees deleteBookingAttendees(
		BookingAttendeesPK bookingAttendeesPK)
		throws PortalException, SystemException {
		return bookingAttendeesPersistence.remove(bookingAttendeesPK);
	}

	/**
	 * Deletes the booking attendees from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingAttendees the booking attendees
	 * @return the booking attendees that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public BookingAttendees deleteBookingAttendees(
		BookingAttendees bookingAttendees) throws SystemException {
		return bookingAttendeesPersistence.remove(bookingAttendees);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(BookingAttendees.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return bookingAttendeesPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return bookingAttendeesPersistence.findWithDynamicQuery(dynamicQuery,
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return bookingAttendeesPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return bookingAttendeesPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public BookingAttendees fetchBookingAttendees(
		BookingAttendeesPK bookingAttendeesPK) throws SystemException {
		return bookingAttendeesPersistence.fetchByPrimaryKey(bookingAttendeesPK);
	}

	/**
	 * Returns the booking attendees with the primary key.
	 *
	 * @param bookingAttendeesPK the primary key of the booking attendees
	 * @return the booking attendees
	 * @throws PortalException if a booking attendees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees getBookingAttendees(
		BookingAttendeesPK bookingAttendeesPK)
		throws PortalException, SystemException {
		return bookingAttendeesPersistence.findByPrimaryKey(bookingAttendeesPK);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return bookingAttendeesPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<BookingAttendees> getBookingAttendeeses(int start, int end)
		throws SystemException {
		return bookingAttendeesPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of booking attendeeses.
	 *
	 * @return the number of booking attendeeses
	 * @throws SystemException if a system exception occurred
	 */
	public int getBookingAttendeesesCount() throws SystemException {
		return bookingAttendeesPersistence.countAll();
	}

	/**
	 * Updates the booking attendees in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param bookingAttendees the booking attendees
	 * @return the booking attendees that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public BookingAttendees updateBookingAttendees(
		BookingAttendees bookingAttendees) throws SystemException {
		return updateBookingAttendees(bookingAttendees, true);
	}

	/**
	 * Updates the booking attendees in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param bookingAttendees the booking attendees
	 * @param merge whether to merge the booking attendees with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the booking attendees that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public BookingAttendees updateBookingAttendees(
		BookingAttendees bookingAttendees, boolean merge)
		throws SystemException {
		bookingAttendees.setNew(false);

		return bookingAttendeesPersistence.update(bookingAttendees, merge);
	}

	/**
	 * Returns the booking attendees local service.
	 *
	 * @return the booking attendees local service
	 */
	public BookingAttendeesLocalService getBookingAttendeesLocalService() {
		return bookingAttendeesLocalService;
	}

	/**
	 * Sets the booking attendees local service.
	 *
	 * @param bookingAttendeesLocalService the booking attendees local service
	 */
	public void setBookingAttendeesLocalService(
		BookingAttendeesLocalService bookingAttendeesLocalService) {
		this.bookingAttendeesLocalService = bookingAttendeesLocalService;
	}

	/**
	 * Returns the booking attendees persistence.
	 *
	 * @return the booking attendees persistence
	 */
	public BookingAttendeesPersistence getBookingAttendeesPersistence() {
		return bookingAttendeesPersistence;
	}

	/**
	 * Sets the booking attendees persistence.
	 *
	 * @param bookingAttendeesPersistence the booking attendees persistence
	 */
	public void setBookingAttendeesPersistence(
		BookingAttendeesPersistence bookingAttendeesPersistence) {
		this.bookingAttendeesPersistence = bookingAttendeesPersistence;
	}

	/**
	 * Returns the booking facility mapping local service.
	 *
	 * @return the booking facility mapping local service
	 */
	public BookingFacilityMappingLocalService getBookingFacilityMappingLocalService() {
		return bookingFacilityMappingLocalService;
	}

	/**
	 * Sets the booking facility mapping local service.
	 *
	 * @param bookingFacilityMappingLocalService the booking facility mapping local service
	 */
	public void setBookingFacilityMappingLocalService(
		BookingFacilityMappingLocalService bookingFacilityMappingLocalService) {
		this.bookingFacilityMappingLocalService = bookingFacilityMappingLocalService;
	}

	/**
	 * Returns the booking facility mapping persistence.
	 *
	 * @return the booking facility mapping persistence
	 */
	public BookingFacilityMappingPersistence getBookingFacilityMappingPersistence() {
		return bookingFacilityMappingPersistence;
	}

	/**
	 * Sets the booking facility mapping persistence.
	 *
	 * @param bookingFacilityMappingPersistence the booking facility mapping persistence
	 */
	public void setBookingFacilityMappingPersistence(
		BookingFacilityMappingPersistence bookingFacilityMappingPersistence) {
		this.bookingFacilityMappingPersistence = bookingFacilityMappingPersistence;
	}

	/**
	 * Returns the booking rooms local service.
	 *
	 * @return the booking rooms local service
	 */
	public BookingRoomsLocalService getBookingRoomsLocalService() {
		return bookingRoomsLocalService;
	}

	/**
	 * Sets the booking rooms local service.
	 *
	 * @param bookingRoomsLocalService the booking rooms local service
	 */
	public void setBookingRoomsLocalService(
		BookingRoomsLocalService bookingRoomsLocalService) {
		this.bookingRoomsLocalService = bookingRoomsLocalService;
	}

	/**
	 * Returns the booking rooms persistence.
	 *
	 * @return the booking rooms persistence
	 */
	public BookingRoomsPersistence getBookingRoomsPersistence() {
		return bookingRoomsPersistence;
	}

	/**
	 * Sets the booking rooms persistence.
	 *
	 * @param bookingRoomsPersistence the booking rooms persistence
	 */
	public void setBookingRoomsPersistence(
		BookingRoomsPersistence bookingRoomsPersistence) {
		this.bookingRoomsPersistence = bookingRoomsPersistence;
	}

	/**
	 * Returns the city master local service.
	 *
	 * @return the city master local service
	 */
	public CityMasterLocalService getCityMasterLocalService() {
		return cityMasterLocalService;
	}

	/**
	 * Sets the city master local service.
	 *
	 * @param cityMasterLocalService the city master local service
	 */
	public void setCityMasterLocalService(
		CityMasterLocalService cityMasterLocalService) {
		this.cityMasterLocalService = cityMasterLocalService;
	}

	/**
	 * Returns the city master persistence.
	 *
	 * @return the city master persistence
	 */
	public CityMasterPersistence getCityMasterPersistence() {
		return cityMasterPersistence;
	}

	/**
	 * Sets the city master persistence.
	 *
	 * @param cityMasterPersistence the city master persistence
	 */
	public void setCityMasterPersistence(
		CityMasterPersistence cityMasterPersistence) {
		this.cityMasterPersistence = cityMasterPersistence;
	}

	/**
	 * Returns the facility master local service.
	 *
	 * @return the facility master local service
	 */
	public FacilityMasterLocalService getFacilityMasterLocalService() {
		return facilityMasterLocalService;
	}

	/**
	 * Sets the facility master local service.
	 *
	 * @param facilityMasterLocalService the facility master local service
	 */
	public void setFacilityMasterLocalService(
		FacilityMasterLocalService facilityMasterLocalService) {
		this.facilityMasterLocalService = facilityMasterLocalService;
	}

	/**
	 * Returns the facility master persistence.
	 *
	 * @return the facility master persistence
	 */
	public FacilityMasterPersistence getFacilityMasterPersistence() {
		return facilityMasterPersistence;
	}

	/**
	 * Sets the facility master persistence.
	 *
	 * @param facilityMasterPersistence the facility master persistence
	 */
	public void setFacilityMasterPersistence(
		FacilityMasterPersistence facilityMasterPersistence) {
		this.facilityMasterPersistence = facilityMasterPersistence;
	}

	/**
	 * Returns the floor master local service.
	 *
	 * @return the floor master local service
	 */
	public FloorMasterLocalService getFloorMasterLocalService() {
		return floorMasterLocalService;
	}

	/**
	 * Sets the floor master local service.
	 *
	 * @param floorMasterLocalService the floor master local service
	 */
	public void setFloorMasterLocalService(
		FloorMasterLocalService floorMasterLocalService) {
		this.floorMasterLocalService = floorMasterLocalService;
	}

	/**
	 * Returns the floor master persistence.
	 *
	 * @return the floor master persistence
	 */
	public FloorMasterPersistence getFloorMasterPersistence() {
		return floorMasterPersistence;
	}

	/**
	 * Sets the floor master persistence.
	 *
	 * @param floorMasterPersistence the floor master persistence
	 */
	public void setFloorMasterPersistence(
		FloorMasterPersistence floorMasterPersistence) {
		this.floorMasterPersistence = floorMasterPersistence;
	}

	/**
	 * Returns the location master local service.
	 *
	 * @return the location master local service
	 */
	public LocationMasterLocalService getLocationMasterLocalService() {
		return locationMasterLocalService;
	}

	/**
	 * Sets the location master local service.
	 *
	 * @param locationMasterLocalService the location master local service
	 */
	public void setLocationMasterLocalService(
		LocationMasterLocalService locationMasterLocalService) {
		this.locationMasterLocalService = locationMasterLocalService;
	}

	/**
	 * Returns the location master persistence.
	 *
	 * @return the location master persistence
	 */
	public LocationMasterPersistence getLocationMasterPersistence() {
		return locationMasterPersistence;
	}

	/**
	 * Sets the location master persistence.
	 *
	 * @param locationMasterPersistence the location master persistence
	 */
	public void setLocationMasterPersistence(
		LocationMasterPersistence locationMasterPersistence) {
		this.locationMasterPersistence = locationMasterPersistence;
	}

	/**
	 * Returns the new booking local service.
	 *
	 * @return the new booking local service
	 */
	public NewBookingLocalService getNewBookingLocalService() {
		return newBookingLocalService;
	}

	/**
	 * Sets the new booking local service.
	 *
	 * @param newBookingLocalService the new booking local service
	 */
	public void setNewBookingLocalService(
		NewBookingLocalService newBookingLocalService) {
		this.newBookingLocalService = newBookingLocalService;
	}

	/**
	 * Returns the new booking remote service.
	 *
	 * @return the new booking remote service
	 */
	public NewBookingService getNewBookingService() {
		return newBookingService;
	}

	/**
	 * Sets the new booking remote service.
	 *
	 * @param newBookingService the new booking remote service
	 */
	public void setNewBookingService(NewBookingService newBookingService) {
		this.newBookingService = newBookingService;
	}

	/**
	 * Returns the new booking persistence.
	 *
	 * @return the new booking persistence
	 */
	public NewBookingPersistence getNewBookingPersistence() {
		return newBookingPersistence;
	}

	/**
	 * Sets the new booking persistence.
	 *
	 * @param newBookingPersistence the new booking persistence
	 */
	public void setNewBookingPersistence(
		NewBookingPersistence newBookingPersistence) {
		this.newBookingPersistence = newBookingPersistence;
	}

	/**
	 * Returns the room facility mapping local service.
	 *
	 * @return the room facility mapping local service
	 */
	public RoomFacilityMappingLocalService getRoomFacilityMappingLocalService() {
		return roomFacilityMappingLocalService;
	}

	/**
	 * Sets the room facility mapping local service.
	 *
	 * @param roomFacilityMappingLocalService the room facility mapping local service
	 */
	public void setRoomFacilityMappingLocalService(
		RoomFacilityMappingLocalService roomFacilityMappingLocalService) {
		this.roomFacilityMappingLocalService = roomFacilityMappingLocalService;
	}

	/**
	 * Returns the room facility mapping persistence.
	 *
	 * @return the room facility mapping persistence
	 */
	public RoomFacilityMappingPersistence getRoomFacilityMappingPersistence() {
		return roomFacilityMappingPersistence;
	}

	/**
	 * Sets the room facility mapping persistence.
	 *
	 * @param roomFacilityMappingPersistence the room facility mapping persistence
	 */
	public void setRoomFacilityMappingPersistence(
		RoomFacilityMappingPersistence roomFacilityMappingPersistence) {
		this.roomFacilityMappingPersistence = roomFacilityMappingPersistence;
	}

	/**
	 * Returns the room master local service.
	 *
	 * @return the room master local service
	 */
	public RoomMasterLocalService getRoomMasterLocalService() {
		return roomMasterLocalService;
	}

	/**
	 * Sets the room master local service.
	 *
	 * @param roomMasterLocalService the room master local service
	 */
	public void setRoomMasterLocalService(
		RoomMasterLocalService roomMasterLocalService) {
		this.roomMasterLocalService = roomMasterLocalService;
	}

	/**
	 * Returns the room master persistence.
	 *
	 * @return the room master persistence
	 */
	public RoomMasterPersistence getRoomMasterPersistence() {
		return roomMasterPersistence;
	}

	/**
	 * Sets the room master persistence.
	 *
	 * @param roomMasterPersistence the room master persistence
	 */
	public void setRoomMasterPersistence(
		RoomMasterPersistence roomMasterPersistence) {
		this.roomMasterPersistence = roomMasterPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.cignexdatamatics.wrm.model.BookingAttendees",
			bookingAttendeesLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.cignexdatamatics.wrm.model.BookingAttendees");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return BookingAttendees.class;
	}

	protected String getModelClassName() {
		return BookingAttendees.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = bookingAttendeesPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = BookingAttendeesLocalService.class)
	protected BookingAttendeesLocalService bookingAttendeesLocalService;
	@BeanReference(type = BookingAttendeesPersistence.class)
	protected BookingAttendeesPersistence bookingAttendeesPersistence;
	@BeanReference(type = BookingFacilityMappingLocalService.class)
	protected BookingFacilityMappingLocalService bookingFacilityMappingLocalService;
	@BeanReference(type = BookingFacilityMappingPersistence.class)
	protected BookingFacilityMappingPersistence bookingFacilityMappingPersistence;
	@BeanReference(type = BookingRoomsLocalService.class)
	protected BookingRoomsLocalService bookingRoomsLocalService;
	@BeanReference(type = BookingRoomsPersistence.class)
	protected BookingRoomsPersistence bookingRoomsPersistence;
	@BeanReference(type = CityMasterLocalService.class)
	protected CityMasterLocalService cityMasterLocalService;
	@BeanReference(type = CityMasterPersistence.class)
	protected CityMasterPersistence cityMasterPersistence;
	@BeanReference(type = FacilityMasterLocalService.class)
	protected FacilityMasterLocalService facilityMasterLocalService;
	@BeanReference(type = FacilityMasterPersistence.class)
	protected FacilityMasterPersistence facilityMasterPersistence;
	@BeanReference(type = FloorMasterLocalService.class)
	protected FloorMasterLocalService floorMasterLocalService;
	@BeanReference(type = FloorMasterPersistence.class)
	protected FloorMasterPersistence floorMasterPersistence;
	@BeanReference(type = LocationMasterLocalService.class)
	protected LocationMasterLocalService locationMasterLocalService;
	@BeanReference(type = LocationMasterPersistence.class)
	protected LocationMasterPersistence locationMasterPersistence;
	@BeanReference(type = NewBookingLocalService.class)
	protected NewBookingLocalService newBookingLocalService;
	@BeanReference(type = NewBookingService.class)
	protected NewBookingService newBookingService;
	@BeanReference(type = NewBookingPersistence.class)
	protected NewBookingPersistence newBookingPersistence;
	@BeanReference(type = RoomFacilityMappingLocalService.class)
	protected RoomFacilityMappingLocalService roomFacilityMappingLocalService;
	@BeanReference(type = RoomFacilityMappingPersistence.class)
	protected RoomFacilityMappingPersistence roomFacilityMappingPersistence;
	@BeanReference(type = RoomMasterLocalService.class)
	protected RoomMasterLocalService roomMasterLocalService;
	@BeanReference(type = RoomMasterPersistence.class)
	protected RoomMasterPersistence roomMasterPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private BookingAttendeesLocalServiceClpInvoker _clpInvoker = new BookingAttendeesLocalServiceClpInvoker();
}