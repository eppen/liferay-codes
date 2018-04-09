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

public class BestOptionResult 
{
	
	private long cityId=0L;
	private long locationId=0L;
	private long floorId=0L;
	private long roomId=0L;
	
	private DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	private String sdate=dateFormat.format(new Date());
	private String edate=dateFormat.format(new Date());
	private String sthours="01";
	private String enhours="01";
	private String stminutes="00";
	private String etminutes="15";
	private String stampm="PM";
	private String etampm="PM";
	private long   capacity=0L;
	private String[] facility=null;
	
	public BestOptionResult(){}
	
	public BestOptionResult(long cityID, long locationID,long floorID, long roomID, String sDate, String eDate,
			String stHours, String enHours, String stMinutes, String etMinutes,
			String stAmpm, String etAmpm, long capacities, String[] facilities)
    {
		super();
		cityId = cityID;
		locationId = locationID;
		floorId=floorID;
		roomId = roomID;
		sdate = sDate;
		edate = eDate;
		sthours = stHours;
		enhours = enHours;
		stminutes = stMinutes;
		etminutes = etMinutes;
		stampm = stAmpm;
		etampm = etAmpm;
		capacity = capacities;
		if(facilities==null){ facility =new String[0];}
		else{facility = facilities.clone();}	
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
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomID) {
		roomId = roomID;
	}
	public DateFormat getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(DateFormat dateformat) {
		dateFormat = dateformat;
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
	public String getSthours() {
		return sthours;
	}
	public void setSthours(String stHours) {
		sthours = stHours;
	}
	public String getEnhours() {
		return enhours;
	}
	public void setEnhours(String enHours) {
		enhours = enHours;
	}
	public String getStminutes() {
		return stminutes;
	}
	public void setStminutes(String stMinutes) {
	    stminutes = stMinutes;
	}
	public String getEtminutes() {
		return etminutes;
	}
	public void setEtminutes(String etMinutes) {
		etminutes = etMinutes;
	}
	public String getStampm() {
		return stampm;
	}
	public void setStampm(String stAmpm) {
		stampm = stAmpm;
	}
	public String getEtampm() {
		return etampm;
	}
	public void setEtampm(String etAmpm) {
		etampm = etAmpm;
	}
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacities) {
		capacity = capacities;
	}
	public String[] getFacility() {
		return facility;
	}
	public void setFacility(String[] facilities) {
		if(facilities==null){ facility =new String[0];}
		else{facility = facilities.clone();}	
	}

	
}
