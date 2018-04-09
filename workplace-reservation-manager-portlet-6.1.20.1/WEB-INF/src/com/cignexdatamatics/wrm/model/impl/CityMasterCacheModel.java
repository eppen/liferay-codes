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

import com.cignexdatamatics.wrm.model.CityMaster;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing CityMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CityMaster
 * @generated
 */
public class CityMasterCacheModel implements CacheModel<CityMaster>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{cityId=");
		sb.append(cityId);
		sb.append(", cityName=");
		sb.append(cityName);
		sb.append("}");

		return sb.toString();
	}

	public CityMaster toEntityModel() {
		CityMasterImpl cityMasterImpl = new CityMasterImpl();

		cityMasterImpl.setCityId(cityId);

		if (cityName == null) {
			cityMasterImpl.setCityName(StringPool.BLANK);
		}
		else {
			cityMasterImpl.setCityName(cityName);
		}

		cityMasterImpl.resetOriginalValues();

		return cityMasterImpl;
	}

	public long cityId;
	public String cityName;
}