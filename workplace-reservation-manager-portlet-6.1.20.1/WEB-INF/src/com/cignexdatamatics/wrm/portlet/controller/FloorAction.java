package com.cignexdatamatics.wrm.portlet.controller;


import com.cignexdatamatics.wrm.NoSuchFloorMasterException;
import com.cignexdatamatics.wrm.model.FloorMaster;
import com.cignexdatamatics.wrm.service.FloorMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.model.impl.FloorMasterImpl;
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

public class FloorAction
{
	public void addFloor(ActionRequest request, ActionResponse response)
	{
	   try{
	     if(!isDuplicate(request,response)){
			FloorMasterImpl floor = new FloorMasterImpl();
			floor.setLocationId(ParamUtil.getLong(request, "locationId"));
			floor.setFloorName(request.getParameter("floorName"));
		    FloorMasterLocalServiceUtil.addFloor(floor);
			SessionMessages.add(request, "floor-added");
	    }
	   }catch (SystemException e1) { LOGGER.info(e1.getMessage());}		
	    response.setRenderParameter("floor_add", "flooradd");
		response.setRenderParameter( TAB,FLOORMASTER);
	}

	public boolean isDuplicate(ActionRequest request, ActionResponse response)	
	{
	   boolean flag=false;
	   try{
		 List<FloorMaster> allFloor = FloorMasterLocalServiceUtil.findAllInLocation(ParamUtil.getLong(request, "locationId"));
		 Iterator<FloorMaster> it = allFloor.iterator();
		 while (it.hasNext()){
			FloorMaster floormaster=(FloorMaster) it.next();
			String floorlist= floormaster.getFloorName();
			if (floorlist.equalsIgnoreCase(request.getParameter("floorName"))){
				flag=true;
				SessionErrors.add(request, "floor-duplicate");
				break;
			}			
		 }
	   }catch (SystemException e1) { LOGGER.info(e1.getMessage());}
	   return flag;
	}

	public void updateFloor(ActionRequest request, ActionResponse response)	
	{
		boolean flag = true;		
		String floorName=request.getParameter("floorName");
		if(!floorName.equalsIgnoreCase(request.getParameter("floorName1"))){
			flag=!(isDuplicate(request,response));
		}	
	    if(flag){
	    	try{
	    	 FloorMasterImpl floor= new FloorMasterImpl();
	    	 floor.setFloorName(floorName);
	         floor.setLocationId(ParamUtil.getLong(request, "locationId"));
	       	 floor.setPrimaryKey(ParamUtil.getLong(request, "resourcePrimKey"));
	         FloorMasterLocalServiceUtil.updateFloorMaster(floor);
	         SessionMessages.add(request, "floor-updated");	
	    	}catch (SystemException e) { LOGGER.info(e.getMessage());}	
	    }
	   	response.setRenderParameter("floor_update", "floor_update");
	 	response.setRenderParameter( TAB,FLOORMASTER);
	}	

	public void editFloor(ActionRequest request, ActionResponse response)
	{
		long floorId = ParamUtil.getLong(request, "resourcePrimKey");
		response.setRenderParameter("floorID", Long.toString(floorId));
		response.setRenderParameter("view", "editFloor");
		response.setRenderParameter("floor_edit", "floor_edit");
		response.setRenderParameter( TAB,FLOORMASTER);
	}

	public void deleteFloor(ActionRequest request, ActionResponse response)
	{ 
	    try{
	    	List<FloorMaster> floorlist=new ArrayList<FloorMaster>();
	    	floorlist.add(FloorMasterLocalServiceUtil.findFloorbyFloorId(ParamUtil.getLong(request, "resourcePrimKey")));
	    	DeleteSelectedItems delteItems=new DeleteSelectedItems();
			delteItems.deleteFloors(request, response, floorlist);
	    	SessionMessages.add(request, "floor-deleted");				
	    }catch (NoSuchFloorMasterException e) { LOGGER.info(e.getMessage());}
		 catch (SystemException e) { LOGGER.info(e.getMessage());}	
		response.setRenderParameter("floor_delete", "floordelete");
		response.setRenderParameter( TAB,FLOORMASTER);
	}

	public void deleteselectedFloor(ActionRequest request, ActionResponse response)
	{
		String temp=request.getParameter("floorId");
		if ("".equals(temp)){
			 SessionErrors.add(request, "floor-notselected");
		}else{
			String[] result=temp.split(",");
			List<FloorMaster> floorlist=new ArrayList<FloorMaster>();
			for(String str:result){			
				try{
				  floorlist.add(FloorMasterLocalServiceUtil.findFloorbyFloorId(Long.parseLong(str.trim())));
				}catch (NoSuchFloorMasterException e) { LOGGER.info(e.getMessage());}
				 catch (NumberFormatException e) { LOGGER.info(e.getMessage());}
				 catch (SystemException e) { LOGGER.info(e.getMessage());}				
			}
			DeleteSelectedItems delteItems=new DeleteSelectedItems();
			delteItems.deleteFloors(request, response, floorlist);
			SessionMessages.add(request, "floor-deleteselected");
		}
	   	response.setRenderParameter("floor_deleteselected", "floordeleteselected");
	   	response.setRenderParameter( TAB,FLOORMASTER);
	  }
	private static final String TAB="tabs1";
	private static final String FLOORMASTER="FloorMaster";
	private static final Log LOGGER = LogFactoryUtil.getLog(FloorAction.class);
}