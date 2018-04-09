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

import com.cignexdatamatics.wrm.model.RoomFacilityMapping;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing RoomFacilityMapping in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RoomFacilityMapping
 * @generated
 */
public class RoomFacilityMappingCacheModel implements CacheModel<RoomFacilityMapping>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{roomId=");
		sb.append(roomId);
		sb.append(", facilitiesId=");
		sb.append(facilitiesId);
		sb.append("}");

		return sb.toString();
	}

	public RoomFacilityMapping toEntityModel() {
		RoomFacilityMappingImpl roomFacilityMappingImpl = new RoomFacilityMappingImpl();

		roomFacilityMappingImpl.setRoomId(roomId);
		roomFacilityMappingImpl.setFacilitiesId(facilitiesId);

		roomFacilityMappingImpl.resetOriginalValues();

		return roomFacilityMappingImpl;
	}

	public long roomId;
	public long facilitiesId;
}