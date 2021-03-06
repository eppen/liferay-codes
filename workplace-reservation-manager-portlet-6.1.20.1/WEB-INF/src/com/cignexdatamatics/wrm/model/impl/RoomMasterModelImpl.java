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

package com.cignexdatamatics.wrm.model.impl;

import com.cignexdatamatics.wrm.model.RoomMaster;
import com.cignexdatamatics.wrm.model.RoomMasterModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the RoomMaster service. Represents a row in the &quot;wrm_RoomMaster&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.cignexdatamatics.wrm.model.RoomMasterModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RoomMasterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomMasterImpl
 * @see com.cignexdatamatics.wrm.model.RoomMaster
 * @see com.cignexdatamatics.wrm.model.RoomMasterModel
 * @generated
 */
public class RoomMasterModelImpl extends BaseModelImpl<RoomMaster>
	implements RoomMasterModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a room master model instance should use the {@link com.cignexdatamatics.wrm.model.RoomMaster} interface instead.
	 */
	public static final String TABLE_NAME = "wrm_RoomMaster";
	public static final Object[][] TABLE_COLUMNS = {
			{ "roomId", Types.BIGINT },
			{ "cityId", Types.BIGINT },
			{ "locationId", Types.BIGINT },
			{ "floorId", Types.BIGINT },
			{ "roomName", Types.VARCHAR },
			{ "capacity", Types.BIGINT },
			{ "extension", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table wrm_RoomMaster (roomId LONG not null primary key,cityId LONG,locationId LONG,floorId LONG,roomName VARCHAR(75) null,capacity LONG,extension LONG)";
	public static final String TABLE_SQL_DROP = "drop table wrm_RoomMaster";
	public static final String ORDER_BY_JPQL = " ORDER BY roomMaster.cityId ASC, roomMaster.locationId ASC, roomMaster.floorId ASC, roomMaster.roomName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY wrm_RoomMaster.cityId ASC, wrm_RoomMaster.locationId ASC, wrm_RoomMaster.floorId ASC, wrm_RoomMaster.roomName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.cignexdatamatics.wrm.model.RoomMaster"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.cignexdatamatics.wrm.model.RoomMaster"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.cignexdatamatics.wrm.model.RoomMaster"),
			true);
	public static long CITYID_COLUMN_BITMASK = 1L;
	public static long FLOORID_COLUMN_BITMASK = 2L;
	public static long LOCATIONID_COLUMN_BITMASK = 4L;
	public static long ROOMNAME_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.cignexdatamatics.wrm.model.RoomMaster"));

	public RoomMasterModelImpl() {
	}

	public long getPrimaryKey() {
		return _roomId;
	}

	public void setPrimaryKey(long primaryKey) {
		setRoomId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_roomId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return RoomMaster.class;
	}

	public String getModelClassName() {
		return RoomMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roomId", getRoomId());
		attributes.put("cityId", getCityId());
		attributes.put("locationId", getLocationId());
		attributes.put("floorId", getFloorId());
		attributes.put("roomName", getRoomName());
		attributes.put("capacity", getCapacity());
		attributes.put("extension", getExtension());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long roomId = (Long)attributes.get("roomId");

		if (roomId != null) {
			setRoomId(roomId);
		}

		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Long floorId = (Long)attributes.get("floorId");

		if (floorId != null) {
			setFloorId(floorId);
		}

		String roomName = (String)attributes.get("roomName");

		if (roomName != null) {
			setRoomName(roomName);
		}

		Long capacity = (Long)attributes.get("capacity");

		if (capacity != null) {
			setCapacity(capacity);
		}

		Long extension = (Long)attributes.get("extension");

		if (extension != null) {
			setExtension(extension);
		}
	}

	public long getRoomId() {
		return _roomId;
	}

	public void setRoomId(long roomId) {
		_roomId = roomId;
	}

	public long getCityId() {
		return _cityId;
	}

	public void setCityId(long cityId) {
		_columnBitmask = -1L;

		if (!_setOriginalCityId) {
			_setOriginalCityId = true;

			_originalCityId = _cityId;
		}

		_cityId = cityId;
	}

	public long getOriginalCityId() {
		return _originalCityId;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_columnBitmask = -1L;

		if (!_setOriginalLocationId) {
			_setOriginalLocationId = true;

			_originalLocationId = _locationId;
		}

		_locationId = locationId;
	}

	public long getOriginalLocationId() {
		return _originalLocationId;
	}

	public long getFloorId() {
		return _floorId;
	}

	public void setFloorId(long floorId) {
		_columnBitmask = -1L;

		if (!_setOriginalFloorId) {
			_setOriginalFloorId = true;

			_originalFloorId = _floorId;
		}

		_floorId = floorId;
	}

	public long getOriginalFloorId() {
		return _originalFloorId;
	}

	public String getRoomName() {
		if (_roomName == null) {
			return StringPool.BLANK;
		}
		else {
			return _roomName;
		}
	}

	public void setRoomName(String roomName) {
		_columnBitmask = -1L;

		if (_originalRoomName == null) {
			_originalRoomName = _roomName;
		}

		_roomName = roomName;
	}

	public String getOriginalRoomName() {
		return GetterUtil.getString(_originalRoomName);
	}

	public long getCapacity() {
		return _capacity;
	}

	public void setCapacity(long capacity) {
		_capacity = capacity;
	}

	public long getExtension() {
		return _extension;
	}

	public void setExtension(long extension) {
		_extension = extension;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			RoomMaster.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RoomMaster toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (RoomMaster)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		RoomMasterImpl roomMasterImpl = new RoomMasterImpl();

		roomMasterImpl.setRoomId(getRoomId());
		roomMasterImpl.setCityId(getCityId());
		roomMasterImpl.setLocationId(getLocationId());
		roomMasterImpl.setFloorId(getFloorId());
		roomMasterImpl.setRoomName(getRoomName());
		roomMasterImpl.setCapacity(getCapacity());
		roomMasterImpl.setExtension(getExtension());

		roomMasterImpl.resetOriginalValues();

		return roomMasterImpl;
	}

	public int compareTo(RoomMaster roomMaster) {
		int value = 0;

		if (getCityId() < roomMaster.getCityId()) {
			value = -1;
		}
		else if (getCityId() > roomMaster.getCityId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getLocationId() < roomMaster.getLocationId()) {
			value = -1;
		}
		else if (getLocationId() > roomMaster.getLocationId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getFloorId() < roomMaster.getFloorId()) {
			value = -1;
		}
		else if (getFloorId() > roomMaster.getFloorId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getRoomName().toLowerCase()
					.compareTo(roomMaster.getRoomName().toLowerCase());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		RoomMaster roomMaster = null;

		try {
			roomMaster = (RoomMaster)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = roomMaster.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		RoomMasterModelImpl roomMasterModelImpl = this;

		roomMasterModelImpl._originalCityId = roomMasterModelImpl._cityId;

		roomMasterModelImpl._setOriginalCityId = false;

		roomMasterModelImpl._originalLocationId = roomMasterModelImpl._locationId;

		roomMasterModelImpl._setOriginalLocationId = false;

		roomMasterModelImpl._originalFloorId = roomMasterModelImpl._floorId;

		roomMasterModelImpl._setOriginalFloorId = false;

		roomMasterModelImpl._originalRoomName = roomMasterModelImpl._roomName;

		roomMasterModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<RoomMaster> toCacheModel() {
		RoomMasterCacheModel roomMasterCacheModel = new RoomMasterCacheModel();

		roomMasterCacheModel.roomId = getRoomId();

		roomMasterCacheModel.cityId = getCityId();

		roomMasterCacheModel.locationId = getLocationId();

		roomMasterCacheModel.floorId = getFloorId();

		roomMasterCacheModel.roomName = getRoomName();

		String roomName = roomMasterCacheModel.roomName;

		if ((roomName != null) && (roomName.length() == 0)) {
			roomMasterCacheModel.roomName = null;
		}

		roomMasterCacheModel.capacity = getCapacity();

		roomMasterCacheModel.extension = getExtension();

		return roomMasterCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{roomId=");
		sb.append(getRoomId());
		sb.append(", cityId=");
		sb.append(getCityId());
		sb.append(", locationId=");
		sb.append(getLocationId());
		sb.append(", floorId=");
		sb.append(getFloorId());
		sb.append(", roomName=");
		sb.append(getRoomName());
		sb.append(", capacity=");
		sb.append(getCapacity());
		sb.append(", extension=");
		sb.append(getExtension());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.cignexdatamatics.wrm.model.RoomMaster");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>roomId</column-name><column-value><![CDATA[");
		sb.append(getRoomId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cityId</column-name><column-value><![CDATA[");
		sb.append(getCityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>floorId</column-name><column-value><![CDATA[");
		sb.append(getFloorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roomName</column-name><column-value><![CDATA[");
		sb.append(getRoomName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capacity</column-name><column-value><![CDATA[");
		sb.append(getCapacity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extension</column-name><column-value><![CDATA[");
		sb.append(getExtension());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = RoomMaster.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			RoomMaster.class
		};
	private long _roomId;
	private long _cityId;
	private long _originalCityId;
	private boolean _setOriginalCityId;
	private long _locationId;
	private long _originalLocationId;
	private boolean _setOriginalLocationId;
	private long _floorId;
	private long _originalFloorId;
	private boolean _setOriginalFloorId;
	private String _roomName;
	private String _originalRoomName;
	private long _capacity;
	private long _extension;
	private long _columnBitmask;
	private RoomMaster _escapedModelProxy;
}