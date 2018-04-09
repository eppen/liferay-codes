package com.cignexdatamatics.wrm.portlet.controller;


import com.cignexdatamatics.wrm.model.FacilityMaster;
import com.cignexdatamatics.wrm.model.RoomFacilityMapping;
import com.cignexdatamatics.wrm.service.FacilityMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.RoomFacilityMappingLocalServiceUtil;
import com.cignexdatamatics.wrm.model.impl.FacilityMasterImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
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

public class FacilityAction
{
	public void addFacility(ActionRequest request, ActionResponse response)
	{
		try{
	       if(!isDuplicate(request,response)){
		       FacilityMasterImpl facility = new FacilityMasterImpl();
			   facility.setFacilitiesName(request.getParameter("facilitiesName"));
			   facility.setFacilitiesDesc(request.getParameter("facilitiesDesc"));
			   response.setRenderParameter("facility_view", "");
			   FacilityMasterLocalServiceUtil.addFacility(facility);
			   SessionMessages.add(request, "facility-added");
			}
		 }catch (SystemException e1) { LOGGER.info(e1.getMessage());}		
		 response.setRenderParameter("facility_add", "facilityadd");
		 response.setRenderParameter(TAB,FACILITYMASTER);
	  
	}

	public void editFacility(ActionRequest request, ActionResponse response)
	{
		long facilitiesId = ParamUtil.getLong(request, "resourcePrimKey");
		response.setRenderParameter("facilityID", Long.toString(facilitiesId));
		response.setRenderParameter("view", "editFacility");
	   	response.setRenderParameter("facility_edit", "facility_edit");
	   	response.setRenderParameter(TAB,FACILITYMASTER);
	}

	public void updateFacility(ActionRequest request, ActionResponse response)	
	{
			boolean flag = true;		
			String facilitiesName=request.getParameter("facilitiesName");
			if(!facilitiesName.equalsIgnoreCase(request.getParameter("facilitiesName2"))){
				flag=!(isDuplicate(request,response));
			}
			if(flag)
			{
			  try{
				FacilityMasterImpl facility= new FacilityMasterImpl();
				facility.setFacilitiesName(facilitiesName);
				facility.setFacilitiesDesc(request.getParameter("facilitiesDesc"));
				facility.setPrimaryKey(ParamUtil.getLong(request, "resourcePrimKey"));
				response.setRenderParameter("facility_view", "");
				FacilityMasterLocalServiceUtil.updateFacilityMaster(facility);
				SessionMessages.add(request, "facility-updated");
			  }catch (SystemException e1) { LOGGER.info(e1.getMessage());}	
			}
			response.setRenderParameter("facility_update", "facility_update");
			response.setRenderParameter(TAB,FACILITYMASTER);
	}
	
	public boolean isDuplicate(ActionRequest request, ActionResponse response)	
	{
	  boolean flag=false;
	  try{
		List<FacilityMaster> allFacility = FacilityMasterLocalServiceUtil.findAllFacility();
		Iterator<FacilityMaster> it = allFacility.iterator();
		while (it.hasNext()){
			FacilityMaster facilitymaster=(FacilityMaster) it.next();
			String facilitylist= facilitymaster.getFacilitiesName();
			if (facilitylist.equalsIgnoreCase(request.getParameter("facilitiesName"))){
				flag=true;
				SessionErrors.add(request, "facility-duplicate");
				break;
			}
		}
	  }catch (SystemException e1) { LOGGER.info(e1.getMessage());}
	  return flag;
	}

	public void deleteFacility(ActionRequest request, ActionResponse response)
	{
		deletefacility(request,ParamUtil.getLong(request, "resourcePrimKey"));
		response.setRenderParameter("facility_delete", "facilitydelete");
		response.setRenderParameter(TAB,FACILITYMASTER);		
	}
	
	public void deletefacility(ActionRequest request,long facilityId)
	{
	  try{
		FacilityMasterLocalServiceUtil.deleteFacilityMaster(facilityId);
		List<RoomFacilityMapping> rfm= RoomFacilityMappingLocalServiceUtil.findAllMappingbyFacilitiesId(facilityId);
 		Iterator<RoomFacilityMapping>it4= rfm.iterator();
 		while (it4.hasNext()){
 		    	  RoomFacilityMapping rfm2=(RoomFacilityMapping)it4.next();
 		    	  RoomFacilityMappingLocalServiceUtil.remove(rfm2);
        }
 		SessionMessages.add(request, "facility-deletedselected");	
	  }catch (PortalException e){ LOGGER.info(e.getMessage());} 
	   catch (SystemException e1) { LOGGER.info(e1.getMessage());}	
	}	

	public void deleteselectedRoom(ActionRequest request, ActionResponse response)
	{
		String temp=request.getParameter("facilitiesId");
		if ("".equals(temp)){
			 SessionErrors.add(request, "facility-notselected");
		}else{			
		  String[] result=temp.split(",");
		  for(String str:result){
			   deletefacility(request,Long.parseLong(str.trim()));		 	  	 		
		  }		
		}
	   	response.setRenderParameter("facility_deleteselected", "facilitydeleteselected");
	   	response.setRenderParameter(TAB,FACILITYMASTER);
	}
	private static final String TAB="tabs1";
	private static final String FACILITYMASTER="FacilityMaster";
	private static final Log LOGGER = LogFactoryUtil.getLog(FacilityAction.class);
}