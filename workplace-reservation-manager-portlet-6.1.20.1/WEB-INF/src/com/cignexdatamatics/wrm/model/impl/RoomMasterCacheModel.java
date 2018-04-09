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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing RoomMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RoomMaster
 * @generated
 */
public class RoomMasterCacheModel implements CacheModel<RoomMaster>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{roomId=");
		sb.append(roomId);
		sb.append(", cityId=");
		sb.append(cityId);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", floorId=");
		sb.append(floorId);
		sb.append(", roomName=");
		sb.append(roomName);
		sb.append(", capacity=");
		sb.append(capacity);
		sb.append(", extension=");
		sb.append(extension);
		sb.append("}");

		return sb.toString();
	}

	public RoomMaster toEntityModel() {
		RoomMasterImpl roomMasterImpl = new RoomMasterImpl();

		roomMasterImpl.setRoomId(roomId);
		roomMasterImpl.setCityId(cityId);
		roomMasterImpl.setLocationId(locationId);
		roomMasterImpl.setFloorId(floorId);

		if (roomName == null) {
			roomMasterImpl.setRoomName(StringPool.BLANK);
		}
		else {
			roomMasterImpl.setRoomName(roomName);
		}

		roomMasterImpl.setCapacity(capacity);
		roomMasterImpl.setExtension(extension);

		roomMasterImpl.resetOriginalValues();

		return roomMasterImpl;
	}

	public long roomId;
	public long cityId;
	public long locationId;
	public long floorId;
	public String roomName;
	public long capacity;
	public long extension;
}