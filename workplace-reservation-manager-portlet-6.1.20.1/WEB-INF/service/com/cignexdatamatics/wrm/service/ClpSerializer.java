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

import com.cignexdatamatics.wrm.model.BookingAttendeesClp;
import com.cignexdatamatics.wrm.model.BookingFacilityMappingClp;
import com.cignexdatamatics.wrm.model.BookingRoomsClp;
import com.cignexdatamatics.wrm.model.CityMasterClp;
import com.cignexdatamatics.wrm.model.FacilityMasterClp;
import com.cignexdatamatics.wrm.model.FloorMasterClp;
import com.cignexdatamatics.wrm.model.LocationMasterClp;
import com.cignexdatamatics.wrm.model.NewBookingClp;
import com.cignexdatamatics.wrm.model.RoomFacilityMappingClp;
import com.cignexdatamatics.wrm.model.RoomMasterClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"workplace-reservation-manager-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"workplace-reservation-manager-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "workplace-reservation-manager-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(BookingAttendeesClp.class.getName())) {
			return translateInputBookingAttendees(oldModel);
		}

		if (oldModelClassName.equals(BookingFacilityMappingClp.class.getName())) {
			return translateInputBookingFacilityMapping(oldModel);
		}

		if (oldModelClassName.equals(BookingRoomsClp.class.getName())) {
			return translateInputBookingRooms(oldModel);
		}

		if (oldModelClassName.equals(CityMasterClp.class.getName())) {
			return translateInputCityMaster(oldModel);
		}

		if (oldModelClassName.equals(FacilityMasterClp.class.getName())) {
			return translateInputFacilityMaster(oldModel);
		}

		if (oldModelClassName.equals(FloorMasterClp.class.getName())) {
			return translateInputFloorMaster(oldModel);
		}

		if (oldModelClassName.equals(LocationMasterClp.class.getName())) {
			return translateInputLocationMaster(oldModel);
		}

		if (oldModelClassName.equals(NewBookingClp.class.getName())) {
			return translateInputNewBooking(oldModel);
		}

		if (oldModelClassName.equals(RoomFacilityMappingClp.class.getName())) {
			return translateInputRoomFacilityMapping(oldModel);
		}

		if (oldModelClassName.equals(RoomMasterClp.class.getName())) {
			return translateInputRoomMaster(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputBookingAttendees(BaseModel<?> oldModel) {
		BookingAttendeesClp oldClpModel = (BookingAttendeesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBookingAttendeesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBookingFacilityMapping(
		BaseModel<?> oldModel) {
		BookingFacilityMappingClp oldClpModel = (BookingFacilityMappingClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBookingFacilityMappingRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBookingRooms(BaseModel<?> oldModel) {
		BookingRoomsClp oldClpModel = (BookingRoomsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBookingRoomsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCityMaster(BaseModel<?> oldModel) {
		CityMasterClp oldClpModel = (CityMasterClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCityMasterRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFacilityMaster(BaseModel<?> oldModel) {
		FacilityMasterClp oldClpModel = (FacilityMasterClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFacilityMasterRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFloorMaster(BaseModel<?> oldModel) {
		FloorMasterClp oldClpModel = (FloorMasterClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFloorMasterRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLocationMaster(BaseModel<?> oldModel) {
		LocationMasterClp oldClpModel = (LocationMasterClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLocationMasterRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputNewBooking(BaseModel<?> oldModel) {
		NewBookingClp oldClpModel = (NewBookingClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getNewBookingRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRoomFacilityMapping(
		BaseModel<?> oldModel) {
		RoomFacilityMappingClp oldClpModel = (RoomFacilityMappingClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRoomFacilityMappingRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRoomMaster(BaseModel<?> oldModel) {
		RoomMasterClp oldClpModel = (RoomMasterClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRoomMasterRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.cignexdatamatics.wrm.model.impl.BookingAttendeesImpl")) {
			return translateOutputBookingAttendees(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cignexdatamatics.wrm.model.impl.BookingFacilityMappingImpl")) {
			return translateOutputBookingFacilityMapping(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cignexdatamatics.wrm.model.impl.BookingRoomsImpl")) {
			return translateOutputBookingRooms(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cignexdatamatics.wrm.model.impl.CityMasterImpl")) {
			return translateOutputCityMaster(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cignexdatamatics.wrm.model.impl.FacilityMasterImpl")) {
			return translateOutputFacilityMaster(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cignexdatamatics.wrm.model.impl.FloorMasterImpl")) {
			return translateOutputFloorMaster(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cignexdatamatics.wrm.model.impl.LocationMasterImpl")) {
			return translateOutputLocationMaster(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cignexdatamatics.wrm.model.impl.NewBookingImpl")) {
			return translateOutputNewBooking(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cignexdatamatics.wrm.model.impl.RoomFacilityMappingImpl")) {
			return translateOutputRoomFacilityMapping(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cignexdatamatics.wrm.model.impl.RoomMasterImpl")) {
			return translateOutputRoomMaster(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.cignexdatamatics.wrm.NoSuchBookingAttendeesException")) {
			return new com.cignexdatamatics.wrm.NoSuchBookingAttendeesException();
		}

		if (className.equals(
					"com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException")) {
			return new com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException();
		}

		if (className.equals(
					"com.cignexdatamatics.wrm.NoSuchBookingRoomsException")) {
			return new com.cignexdatamatics.wrm.NoSuchBookingRoomsException();
		}

		if (className.equals(
					"com.cignexdatamatics.wrm.NoSuchCityMasterException")) {
			return new com.cignexdatamatics.wrm.NoSuchCityMasterException();
		}

		if (className.equals(
					"com.cignexdatamatics.wrm.NoSuchFacilityMasterException")) {
			return new com.cignexdatamatics.wrm.NoSuchFacilityMasterException();
		}

		if (className.equals(
					"com.cignexdatamatics.wrm.NoSuchFloorMasterException")) {
			return new com.cignexdatamatics.wrm.NoSuchFloorMasterException();
		}

		if (className.equals(
					"com.cignexdatamatics.wrm.NoSuchLocationMasterException")) {
			return new com.cignexdatamatics.wrm.NoSuchLocationMasterException();
		}

		if (className.equals(
					"com.cignexdatamatics.wrm.NoSuchNewBookingException")) {
			return new com.cignexdatamatics.wrm.NoSuchNewBookingException();
		}

		if (className.equals(
					"com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException")) {
			return new com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException();
		}

		if (className.equals(
					"com.cignexdatamatics.wrm.NoSuchRoomMasterException")) {
			return new com.cignexdatamatics.wrm.NoSuchRoomMasterException();
		}

		return throwable;
	}

	public static Object translateOutputBookingAttendees(BaseModel<?> oldModel) {
		BookingAttendeesClp newModel = new BookingAttendeesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBookingAttendeesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBookingFacilityMapping(
		BaseModel<?> oldModel) {
		BookingFacilityMappingClp newModel = new BookingFacilityMappingClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBookingFacilityMappingRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBookingRooms(BaseModel<?> oldModel) {
		BookingRoomsClp newModel = new BookingRoomsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBookingRoomsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCityMaster(BaseModel<?> oldModel) {
		CityMasterClp newModel = new CityMasterClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCityMasterRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFacilityMaster(BaseModel<?> oldModel) {
		FacilityMasterClp newModel = new FacilityMasterClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFacilityMasterRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFloorMaster(BaseModel<?> oldModel) {
		FloorMasterClp newModel = new FloorMasterClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFloorMasterRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLocationMaster(BaseModel<?> oldModel) {
		LocationMasterClp newModel = new LocationMasterClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLocationMasterRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputNewBooking(BaseModel<?> oldModel) {
		NewBookingClp newModel = new NewBookingClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setNewBookingRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRoomFacilityMapping(
		BaseModel<?> oldModel) {
		RoomFacilityMappingClp newModel = new RoomFacilityMappingClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRoomFacilityMappingRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRoomMaster(BaseModel<?> oldModel) {
		RoomMasterClp newModel = new RoomMasterClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRoomMasterRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}