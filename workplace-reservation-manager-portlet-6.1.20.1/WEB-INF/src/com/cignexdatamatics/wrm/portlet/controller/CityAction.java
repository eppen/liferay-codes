package com.cignexdatamatics.wrm.portlet.controller;

import com.cignexdatamatics.wrm.model.CityMaster;
import com.cignexdatamatics.wrm.service.CityMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.model.impl.CityMasterImpl;
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

public class CityAction
{

	public void addCity(ActionRequest request, ActionResponse response)
	{
		try{
		  if(!isDuplicate(request,response)){
			  CityMasterImpl city = new CityMasterImpl();
			  city.setCityName(request.getParameter("cityName"));
			  response.setRenderParameter("city_view", "");
			  CityMasterLocalServiceUtil.addCity(city);
			  SessionMessages.add(request, "city-added");					
		 }
		}catch (SystemException e1) { LOGGER.info(e1.getMessage());}	
		response.setRenderParameter("city_add", "city_add");
		response.setRenderParameter( TAB,CITYMASTER);
	}


	public boolean isDuplicate(ActionRequest request, ActionResponse response)	
	{
		boolean flag=false;
		try{		  
		    List<CityMaster> allCity = CityMasterLocalServiceUtil.findAllInCity();
			Iterator<CityMaster>it = allCity.iterator();				
			while (it.hasNext()){
				CityMaster citymaster=(CityMaster) it.next();
				String citylist= citymaster.getCityName();
				if (citylist.equalsIgnoreCase(request.getParameter("cityName"))){
					flag=true;
					SessionErrors.add(request, "city-duplicate");
					break;
	   			}
			}
	    }catch (SystemException e1) { LOGGER.info(e1.getMessage());}	
	    return flag;
	}

	public void updateCity(ActionRequest request, ActionResponse response)	
	{
	  try{
		   boolean flag = true;		 
		   String cityname=request.getParameter("cityName");
		   if(!cityname.equalsIgnoreCase(request.getParameter("cityName1"))){
			  flag=!(isDuplicate(request,response));
		   }
		   if(flag){
			    CityMasterImpl city= new CityMasterImpl();
				city.setCityName(cityname);
				city.setPrimaryKey(ParamUtil.getLong(request, "resourcePrimKey"));
				response.setRenderParameter("city_view", "");
				CityMasterLocalServiceUtil.updateCityMaster(city);
				SessionMessages.add(request, "city-updated");			  
		    }		
		}catch (SystemException e1) { LOGGER.info(e1.getMessage());}
		response.setRenderParameter("city_update", "city_update");
		response.setRenderParameter( TAB,CITYMASTER);

	}

	public void editCity(ActionRequest request, ActionResponse response) 
	{
		long cityId = ParamUtil.getLong(request, "resourcePrimKey");
		response.setRenderParameter("cityID", Long.toString(cityId));
		response.setRenderParameter("view", "editCity");
		response.setRenderParameter("city_edit", "city_edit");
		response.setRenderParameter( TAB,CITYMASTER);
	}
	
	public void deleteCity(ActionRequest request, ActionResponse response)
	{	
	    DeleteSelectedItems delteItems=new DeleteSelectedItems();
		long cityId = ParamUtil.getLong(request, "resourcePrimKey");
		if(delteItems.deleteCity(request,response,cityId)){
		  SessionMessages.add(request, "city-deleteselected");
		}
		response.setRenderParameter("city_delete", "citydelete");
	    response.setRenderParameter( TAB,CITYMASTER);
	}

	public void deleteselectedCity(ActionRequest request, ActionResponse response)
	{			
		String temp=request.getParameter("cityId");
		if (temp.equals("")){ 
			SessionErrors.add(request, "city-notselected"); 
		}else{
		    String[] result=temp.split(",");
		    DeleteSelectedItems delteItems=new DeleteSelectedItems();
			for(int i=0;i<result.length; i++){			
				long cityId = Long.parseLong(result[i].trim());
				delteItems.deleteCity(request,response,cityId);
				SessionMessages.add(request, "city-deleteselected");
	        }
		}
		response.setRenderParameter("city_deleteselected", "citydeleteselected");
	   	response.setRenderParameter( TAB,CITYMASTER);
	 }
	private static final String TAB="tabs1";
	private static final String CITYMASTER="CityMaster";
	private static final Log LOGGER = LogFactoryUtil.getLog(CityAction.class);
}