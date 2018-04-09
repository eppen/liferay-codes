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

import com.cignexdatamatics.wrm.model.FacilityMaster;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing FacilityMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FacilityMaster
 * @generated
 */
public class FacilityMasterCacheModel implements CacheModel<FacilityMaster>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{facilitiesId=");
		sb.append(facilitiesId);
		sb.append(", facilitiesName=");
		sb.append(facilitiesName);
		sb.append(", facilitiesDesc=");
		sb.append(facilitiesDesc);
		sb.append("}");

		return sb.toString();
	}

	public FacilityMaster toEntityModel() {
		FacilityMasterImpl facilityMasterImpl = new FacilityMasterImpl();

		facilityMasterImpl.setFacilitiesId(facilitiesId);

		if (facilitiesName == null) {
			facilityMasterImpl.setFacilitiesName(StringPool.BLANK);
		}
		else {
			facilityMasterImpl.setFacilitiesName(facilitiesName);
		}

		if (facilitiesDesc == null) {
			facilityMasterImpl.setFacilitiesDesc(StringPool.BLANK);
		}
		else {
			facilityMasterImpl.setFacilitiesDesc(facilitiesDesc);
		}

		facilityMasterImpl.resetOriginalValues();

		return facilityMasterImpl;
	}

	public long facilitiesId;
	public String facilitiesName;
	public String facilitiesDesc;
}