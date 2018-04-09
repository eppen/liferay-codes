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

package com.cignexdatamatics.wrm.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class RoomFacilityMappingPK implements Comparable<RoomFacilityMappingPK>,
	Serializable {
	public long roomId;
	public long facilitiesId;

	public RoomFacilityMappingPK() {
	}

	public RoomFacilityMappingPK(long roomId, long facilitiesId) {
		this.roomId = roomId;
		this.facilitiesId = facilitiesId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public long getFacilitiesId() {
		return facilitiesId;
	}

	public void setFacilitiesId(long facilitiesId) {
		this.facilitiesId = facilitiesId;
	}

	public int compareTo(RoomFacilityMappingPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (roomId < pk.roomId) {
			value = -1;
		}
		else if (roomId > pk.roomId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (facilitiesId < pk.facilitiesId) {
			value = -1;
		}
		else if (facilitiesId > pk.facilitiesId) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		RoomFacilityMappingPK pk = null;

		try {
			pk = (RoomFacilityMappingPK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((roomId == pk.roomId) && (facilitiesId == pk.facilitiesId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(roomId) + String.valueOf(facilitiesId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("roomId");
		sb.append(StringPool.EQUAL);
		sb.append(roomId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("facilitiesId");
		sb.append(StringPool.EQUAL);
		sb.append(facilitiesId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}