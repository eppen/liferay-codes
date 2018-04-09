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

import com.cignexdatamatics.wrm.model.FloorMaster;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing FloorMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FloorMaster
 * @generated
 */
public class FloorMasterCacheModel implements CacheModel<FloorMaster>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{floorId=");
		sb.append(floorId);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", floorName=");
		sb.append(floorName);
		sb.append("}");

		return sb.toString();
	}

	public FloorMaster toEntityModel() {
		FloorMasterImpl floorMasterImpl = new FloorMasterImpl();

		floorMasterImpl.setFloorId(floorId);
		floorMasterImpl.setLocationId(locationId);

		if (floorName == null) {
			floorMasterImpl.setFloorName(StringPool.BLANK);
		}
		else {
			floorMasterImpl.setFloorName(floorName);
		}

		floorMasterImpl.resetOriginalValues();

		return floorMasterImpl;
	}

	public long floorId;
	public long locationId;
	public String floorName;
}