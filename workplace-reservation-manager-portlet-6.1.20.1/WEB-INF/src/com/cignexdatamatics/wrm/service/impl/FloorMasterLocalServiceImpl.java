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

import com.cignexdatamatics.wrm.NoSuchFloorMasterException;
import com.cignexdatamatics.wrm.model.FloorMaster;
import com.cignexdatamatics.wrm.service.persistence.FloorMasterUtil;
import com.cignexdatamatics.wrm.service.base.FloorMasterLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

public class FloorMasterLocalServiceImpl extends FloorMasterLocalServiceBaseImpl {

	public List<FloorMaster> findAllFloor()	throws SystemException
	{
		return (List<FloorMaster>) floorMasterPersistence.findAll();
	}
	public List<FloorMaster> findAllInLocation(long locationId)throws SystemException
	 {
		 return (List<FloorMaster>) FloorMasterUtil.findBylocationId(locationId);	      
	 }
	public FloorMaster findFloorbyFloorId(long floorId) throws NoSuchFloorMasterException, SystemException
	{
		 return	(FloorMaster) floorMasterPersistence.findByPrimaryKey(floorId);
    }

	public FloorMaster addFloor (FloorMaster validfloor) throws SystemException
	 {
	    FloorMaster floor=FloorMasterUtil.create(CounterLocalServiceUtil.increment(FloorMaster.class.getName()));
		floor.setFloorName(validfloor.getFloorName());
		floor.setLocationId(validfloor.getLocationId());
		return FloorMasterUtil.update(floor, false);
	 }
	 public void remove(FloorMaster floor) throws SystemException
	 {
	          try {
				FloorMasterUtil.remove(floor.getFloorId());
			} catch (NoSuchFloorMasterException e) {
				 LOGGER.info(e.getMessage());
			}
	 }
	 private static final Log LOGGER = LogFactoryUtil.getLog(FloorMasterLocalServiceImpl.class);

}