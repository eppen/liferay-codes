/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 */

package com.cignexdatamatics.wrm.service.impl;

import com.cignexdatamatics.wrm.NoSuchFacilityMasterException;
import com.cignexdatamatics.wrm.model.FacilityMaster;
import com.cignexdatamatics.wrm.service.persistence.FacilityMasterUtil;
import com.cignexdatamatics.wrm.service.base.FacilityMasterLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

public class FacilityMasterLocalServiceImpl
	extends FacilityMasterLocalServiceBaseImpl
	{

	public  List<FacilityMaster> findAllFacility()	throws SystemException
	{
		return (List<FacilityMaster>) facilityMasterPersistence.findAll();
	}
	 public FacilityMaster findbyFacilitiesName(String facilitiesname)throws SystemException,NoSuchFacilityMasterException
	 {
       return (FacilityMaster) facilityMasterPersistence.findByFacilitiesName(facilitiesname);
	 }
	 public FacilityMaster findbyFacilitiesId(long facilitiesId)throws SystemException,NoSuchFacilityMasterException
	 {
	    return (FacilityMaster) facilityMasterPersistence.findByPrimaryKey(facilitiesId);
	 }

	 public FacilityMaster addFacility (FacilityMaster validFacility) throws SystemException
	 {
	    FacilityMaster facility=FacilityMasterUtil.create(CounterLocalServiceUtil.increment(FacilityMaster.class.getName()));
		facility.setFacilitiesName(validFacility.getFacilitiesName());
		facility.setFacilitiesDesc(validFacility.getFacilitiesDesc());
		return FacilityMasterUtil.update(facility, false);
	 }
	 public void remove(FacilityMaster fc) throws SystemException
	 {
	          try {
				FacilityMasterUtil.remove(fc.getFacilitiesId());
			} catch (NoSuchFacilityMasterException e) {
				 LOGGER.info(e.getMessage());
			}
	 }
	 private static final Log LOGGER = LogFactoryUtil.getLog(FacilityMasterLocalServiceImpl.class);
	 
}