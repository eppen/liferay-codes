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

import com.cignexdatamatics.wrm.NoSuchLocationMasterException;
import com.cignexdatamatics.wrm.model.LocationMaster;
import com.cignexdatamatics.wrm.service.persistence.LocationMasterUtil;
import com.cignexdatamatics.wrm.service.base.LocationMasterLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

public class LocationMasterLocalServiceImpl
	extends LocationMasterLocalServiceBaseImpl
{
	 public List<LocationMaster> findAllInCity(long cityId)throws SystemException
	 {
	   return (List<LocationMaster>) LocationMasterUtil.findByCityId(cityId);
	 }
	 public List<LocationMaster> findAllbyLocationName(long cityId)throws SystemException
	 {
       return (List<LocationMaster>) LocationMasterUtil.findByCityId(cityId);
	 }
	 public LocationMaster findAllbyLocationName(String locationname)throws SystemException,NoSuchLocationMasterException
	 {
	   return (LocationMaster) locationMasterPersistence.findByLocationName(locationname);
	 }

	public List<LocationMaster> findAllLocation()	throws SystemException
	{
	   return (List<LocationMaster>) locationMasterPersistence.findAll();
	}
	public LocationMaster findLocationbyLocationId(long locationId) throws NoSuchLocationMasterException, SystemException
	{
		return locationMasterPersistence.findByPrimaryKey(locationId);
    }

	 public LocationMaster addLocation (LocationMaster validLocation) throws SystemException
	 {
	    LocationMaster location=LocationMasterUtil.create(CounterLocalServiceUtil.increment(LocationMaster.class.getName()));
		location.setLocationName(validLocation.getLocationName());
		location.setCityId(validLocation.getCityId());
		return LocationMasterUtil.update(location, false);
	 }
	 public void remove(LocationMaster location) throws SystemException
	 {
	     try {
			LocationMasterUtil.remove(location.getLocationId());
		} catch (NoSuchLocationMasterException e) {
			 LOGGER.info(e.getMessage());
		}
	 }
	 private static final Log LOGGER = LogFactoryUtil.getLog(LocationMasterLocalServiceImpl.class);

}