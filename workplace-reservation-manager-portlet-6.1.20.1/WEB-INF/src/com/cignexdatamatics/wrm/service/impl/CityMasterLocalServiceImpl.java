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

import com.cignexdatamatics.wrm.NoSuchCityMasterException;
import com.cignexdatamatics.wrm.model.CityMaster;
import com.cignexdatamatics.wrm.service.persistence.CityMasterUtil;
import com.cignexdatamatics.wrm.service.base.CityMasterLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

public class CityMasterLocalServiceImpl extends CityMasterLocalServiceBaseImpl
{

	public List<CityMaster> findAllInCity()	throws SystemException
	{
		return (List<CityMaster>) cityMasterPersistence.findAll();
	}

	public CityMaster findbyCityName(String name) throws NoSuchCityMasterException, SystemException
	{
        return cityMasterPersistence.findByCityName(name);
    }

	public CityMaster findCitybyCityId(long cityId) throws NoSuchCityMasterException, SystemException
	{
        return cityMasterPersistence.findByPrimaryKey(cityId);
    }
	
	public CityMaster addCity (CityMaster validCity) throws SystemException
	{
	    CityMaster city = CityMasterUtil.create(CounterLocalServiceUtil.increment(CityMaster.class.getName()));
	    city.setCityName(validCity.getCityName());
	    return CityMasterUtil.update(city, false);
	}

	public void remove(CityMaster city) throws SystemException {
	    try {
			CityMasterUtil.remove(city.getCityId());
		} catch (NoSuchCityMasterException e) {
			 LOGGER.info(e.getMessage());
		}
	}
	 private static final Log LOGGER = LogFactoryUtil.getLog(CityMasterLocalServiceImpl.class);


}