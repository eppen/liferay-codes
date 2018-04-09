package com.cignexdatamatics.wrm.portlet.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 */

public class StoreResult 
{
	private long locationId=0L;
	private long cityId=0L;
	private long floorId=0L;	
	private DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	private String sdate=dateFormat.format( new Date());
	private String edate=dateFormat.format( new Date());
	
    public StoreResult(){}

	public StoreResult(long cityID,long locId,long flrId,String sDate,String eDate)
	{
		locationId=locId;
		cityId=cityID;		
		floorId=flrId;
		sdate=sDate;
		edate=eDate;	
	}

	
    public long getLocationId() {
		return locationId;
	}
	public void setLocationId(long locationID) {
		locationId = locationID;
	}
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityID) {
		cityId = cityID;
	}
	public long getFloorId() {
		return floorId;
	}
	public void setFloorId(long floorID) {
		floorId = floorID;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sDate) {
		sdate = sDate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String eDate) {
		edate = eDate;
	}


	
}
