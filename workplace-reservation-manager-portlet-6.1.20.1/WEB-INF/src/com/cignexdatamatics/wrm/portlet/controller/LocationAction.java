package com.cignexdatamatics.wrm.portlet.controller;

import com.cignexdatamatics.wrm.NoSuchLocationMasterException;
import com.cignexdatamatics.wrm.model.LocationMaster;
import com.cignexdatamatics.wrm.service.LocationMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.model.impl.LocationMasterImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 */

public class LocationAction
{
	public void addLocation(ActionRequest request, ActionResponse response)
	{
	    try{
	      if(!isDuplicate(request,response))
		  {
			 LocationMasterImpl location = new LocationMasterImpl();
	    	 location.setCityId(ParamUtil.getLong(request, "cityId"));
	    	 location.setLocationName(request.getParameter("locationName"));
	         LocationMasterLocalServiceUtil.addLocation(location);
	    	 SessionMessages.add(request, "location-added");		   	
		  }
	    }catch (SystemException e1) { LOGGER.info(e1.getMessage());}
		response.setRenderParameter("location_add", "location_add");
		response.setRenderParameter(TAB,LOCATIONMASTER);
	 
	}
	public boolean isDuplicate(ActionRequest request, ActionResponse response)	
	{
	  boolean flag=false;
	  try{
		List<LocationMaster> tempResults = LocationMasterLocalServiceUtil.findAllInCity(ParamUtil.getLong(request, "cityId"));
		Iterator <LocationMaster> it = tempResults.iterator();
		while (it.hasNext()){
			LocationMaster locationmaster=(LocationMaster) it.next();
			String locationName= locationmaster.getLocationName();
			if (locationName.equalsIgnoreCase(request.getParameter("locationName"))){
				flag=true;
				SessionErrors.add(request, "location-duplicate");
				break;
			}
		}
	  }catch (SystemException e1) { LOGGER.info(e1.getMessage());}
	  return flag;	
	}

	public void updateLocation(ActionRequest request, ActionResponse response)
	{
		boolean flag = true;
		String locationName=request.getParameter("locationName");		
		if (!locationName.equalsIgnoreCase(request.getParameter("locationName1"))){
			 flag=!(isDuplicate(request,response));
		}
	    if(flag)
		{
	     try{
	    	LocationMasterImpl location= new LocationMasterImpl();
	    	location.setCityId(ParamUtil.getLong(request, "cityId"));
	    	location.setLocationName(locationName);
	    	location.setPrimaryKey(ParamUtil.getLong(request, "resourcePrimKey"));
	    	LocationMasterLocalServiceUtil.updateLocationMaster(location);
	    	SessionMessages.add(request, "location-updated");
	     }catch (SystemException e1) { LOGGER.info(e1.getMessage());}
	    }	   
	   	response.setRenderParameter("location_update", "location_update");
		response.setRenderParameter(TAB,LOCATIONMASTER);
	}
	
	public void editLocation(ActionRequest request, ActionResponse response) 
	{
		long locationId = ParamUtil.getLong(request, "resourcePrimKey");
		response.setRenderParameter("locationID", Long.toString(locationId));
		response.setRenderParameter("view", "editLocation");
		response.setRenderParameter("location_edit", "location_edit");
		response.setRenderParameter(TAB,LOCATIONMASTER);
	}

	public void deleteLocation(ActionRequest request, ActionResponse response)
	{
		try{
			long locationId = ParamUtil.getLong(request, "resourcePrimKey");
			List<LocationMaster> locationlist=new ArrayList<LocationMaster>();
			locationlist.add(LocationMasterLocalServiceUtil.findLocationbyLocationId(locationId));
			DeleteSelectedItems delteItems=new DeleteSelectedItems();
			delteItems.deleteLocations(request, response, locationlist);
			SessionMessages.add(request, "location-deleted");			
		}catch(NoSuchLocationMasterException e){ LOGGER.info(e.getMessage());} 
		 catch (SystemException e) { LOGGER.info(e.getMessage());}	
		response.setRenderParameter("location_delete", "locationdelete");
    	response.setRenderParameter(TAB,LOCATIONMASTER);
	}

	public void deleteselectedLocation(ActionRequest request, ActionResponse response)
	{  
		String temp=request.getParameter("locationId");
		if (temp.equals("")){
			 SessionErrors.add(request, "location-notselected");
		}else{
			String[] result=temp.split(",");
			List<LocationMaster> locationlist=new ArrayList<LocationMaster>();
			for(String str:result)
		    {
				try{				
					locationlist.add(LocationMasterLocalServiceUtil.findLocationbyLocationId(Long.parseLong(str.trim())));
				}catch(NoSuchLocationMasterException e){ LOGGER.info(e.getMessage());}
				 catch (NumberFormatException e) { LOGGER.info(e.getMessage());}
				 catch (SystemException e) { LOGGER.info(e.getMessage());}		        
		    }
			DeleteSelectedItems delteItems=new DeleteSelectedItems();
			delteItems.deleteLocations(request, response, locationlist);
			SessionMessages.add(request, "location-deleteselected");			
		}	
     	response.setRenderParameter("location_deleteselected", "locationdeleteselected");
	   	response.setRenderParameter(TAB,LOCATIONMASTER);
	}
	private static final String TAB="tabs1";
	private static final String LOCATIONMASTER="LocationMaster";
	private static final Log LOGGER = LogFactoryUtil.getLog(LocationAction.class);
}