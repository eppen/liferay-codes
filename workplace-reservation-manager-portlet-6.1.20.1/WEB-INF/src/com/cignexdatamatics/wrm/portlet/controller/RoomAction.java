package com.cignexdatamatics.wrm.portlet.controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.apache.commons.fileupload.FileUpload;
import com.cignexdatamatics.wrm.NoSuchRoomMasterException;
import com.cignexdatamatics.wrm.model.RoomFacilityMapping;
import com.cignexdatamatics.wrm.model.RoomMaster;
import com.cignexdatamatics.wrm.service.RoomFacilityMappingLocalServiceUtil;
import com.cignexdatamatics.wrm.service.RoomMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.model.impl.RoomFacilityMappingImpl;
import com.cignexdatamatics.wrm.model.impl.RoomMasterImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 */

public class RoomAction  extends FileUpload
{
	public void addRoom(ActionRequest request, ActionResponse response)
	{
	   if(!isDuplicate(request,response)){
	    	 try{
	    	   RoomMasterImpl room = new RoomMasterImpl();
	    	   room.setCityId(Long.parseLong(request.getParameter("cityId")));
	    	   room.setLocationId(Long.parseLong(request.getParameter("locationId")));
	    	   room.setFloorId(Long.parseLong(request.getParameter("floorId")));
	    	   room.setCapacity(Long.parseLong(request.getParameter("capacity")));
	    	   room.setExtension(Long.parseLong(request.getParameter("extension")));
	    	   room.setRoomName(request.getParameter("roomName"));
	    	   RoomMaster rm= RoomMasterLocalServiceUtil.addRoom(room);			
	    	   SessionMessages.add(request, "room-added");
	    	   String facilityids= request.getParameter("selectedFac");
	    	   if(!"".equals(facilityids))
	    	   {
	       	   String[] ids = facilityids.split(",");
	           long[] longArray = new long[ids.length];
	           for (int i = 0; i < ids.length; i++){
	        	   try{
	        		 longArray[i] = Long.parseLong(ids[i].trim());
	        		 RoomFacilityMappingImpl rfm= new RoomFacilityMappingImpl();
	        		 rfm.setRoomId(rm.getRoomId());
	        		 rfm.setFacilitiesId(longArray[i]);
	        	     RoomFacilityMappingLocalServiceUtil.addRoomFacilityMapping(rfm);
	        	   }catch (SystemException e1) { LOGGER.info(e1.getMessage());}
	        	}
	    	   }
	         }catch (SystemException e1) { LOGGER.info(e1.getMessage());}
	       }
	  	response.setRenderParameter("room_add", "roomadd");
	   	response.setRenderParameter(TAB,ROOMMASTER);
	}

	public boolean isDuplicate(ActionRequest request, ActionResponse response)	
	{
		 boolean flag=false;
		 try{
			 List<RoomMaster> allRoomInLocation = RoomMasterLocalServiceUtil.findAllInLocation(Long.parseLong(request.getParameter("locationId")));
	         Iterator<RoomMaster> it = allRoomInLocation.iterator();
	   	     while (it.hasNext()){
	   	    	 RoomMaster roommaster = (RoomMaster) it.next();
	   	    	 long ext=Long.parseLong(request.getParameter("extension"));
	    		 if(roommaster.getExtension()==ext && ext!=0){
	    			 flag = true;
	    			 SessionErrors.add(request, "extension-duplicate");
	    		 }
	    		 if(roommaster.getRoomName().equalsIgnoreCase(request.getParameter("roomName"))){
	    			 flag=true;
	    			 SessionErrors.add(request, "room-duplicate");
	    		 }
	         }	
		 }catch (SystemException e1) { LOGGER.info(e1.getMessage());}		 
		 return flag;
	 }

	public void updateRoom(ActionRequest request, ActionResponse response)	
	{	
		boolean flag=true;
	    String  roomName=request.getParameter("roomName");    
        String  roomName2=request.getParameter("roomName2");
	    long extension=Long.parseLong(request.getParameter("extension"));
		long extension2=Long.parseLong(request.getParameter("extension2"));
		long roomId=Long.parseLong(request.getParameter("resourcePrimKey"));
		if(extension!=extension2 || !roomName.equalsIgnoreCase(roomName2)){
			  flag=!(isDuplicate(request,response));
		}		  
		if(flag){
		  try{
		 	 RoomMasterImpl room = new RoomMasterImpl();
		 	 room.setCityId(Long.parseLong(request.getParameter("cityId")));
		 	 room.setLocationId(Long.parseLong(request.getParameter("locationId")));
		 	 room.setFloorId(Long.parseLong(request.getParameter("floorId")));
		 	 room.setCapacity(Long.parseLong(request.getParameter("capacity")));
		 	 room.setExtension(extension);
		 	 room.setRoomName(roomName);
		 	 room.setRoomId(roomId);
		 	 RoomMasterLocalServiceUtil.updateRoomMaster(room);	       		   
	         List<RoomFacilityMapping> rfm= RoomFacilityMappingLocalServiceUtil.findAllMappingbyRoomId(roomId);
	 		 Iterator<RoomFacilityMapping>it4= rfm.iterator();
	 		 while (it4.hasNext()){
	 		      RoomFacilityMapping rfm2=(RoomFacilityMapping)it4.next();
	 		      RoomFacilityMappingLocalServiceUtil.remove(rfm2);
	         }
	 		 String facilityids=request.getParameter("selectedFac");
	 		 String[] ids = facilityids.split(",");
	 		 long[] longArray = new long[ids.length];
	 		 for (int i = 0; i < ids.length; i++){	
	 		  try { 
			    longArray[i] = Long.parseLong(ids[i].trim());
			    RoomFacilityMappingImpl rfm3= new RoomFacilityMappingImpl();
			    rfm3.setRoomId(roomId);
			    rfm3.setFacilitiesId(longArray[i]);
			    RoomFacilityMappingLocalServiceUtil.addRoomFacilityMapping(rfm3);
	 		  }catch (SystemException e1) { LOGGER.info(e1.getMessage());}	
		    }
		  }catch (SystemException e1) { LOGGER.info(e1.getMessage());} 
	     }
		SessionMessages.add(request, "room-updated");      
    	response.setRenderParameter("room_update", "room_update");
    	response.setRenderParameter(TAB,ROOMMASTER);
	}
	
	public void editRoom(ActionRequest request, ActionResponse response) 
	{
		long roomId = ParamUtil.getLong(request, "resourcePrimKey");
		response.setRenderParameter("roomID", Long.toString(roomId));
		response.setRenderParameter("view", "editRoom");
	   	response.setRenderParameter("room_edit", "room_edit");
	   	response.setRenderParameter(TAB,ROOMMASTER);
	}

	public void deleteRoom(ActionRequest request, ActionResponse response)
	{
		try{
			List<RoomMaster> roomlist=new ArrayList<RoomMaster>();
			roomlist.add(RoomMasterLocalServiceUtil.findRoomByRoomId( ParamUtil.getLong(request, "resourcePrimKey")));
			DeleteSelectedItems delteItems=new DeleteSelectedItems();
			delteItems.deleteRooms(request, response, roomlist);
			SessionMessages.add(request, "room-deleted");
		}catch (NoSuchRoomMasterException e){ LOGGER.info(e.getMessage());}
		 catch (SystemException e) { LOGGER.info(e.getMessage());}	
		response.setRenderParameter("room_delete", "roomdelete");
	   	response.setRenderParameter(TAB,ROOMMASTER);
	}

	public void deleteselectedRoom(ActionRequest request, ActionResponse response)
	{
		String temp=request.getParameter("roomId");	
		if("".equals(temp)){
			 SessionErrors.add(request, "room-notselected");
		}else{
		   String[] result=temp.split(",");
		   List<RoomMaster> roomlist=new ArrayList<RoomMaster>();
		   for(String str:result){				
			  try{
				roomlist.add(RoomMasterLocalServiceUtil.findRoomByRoomId(Long.parseLong(str.trim())));
			  }catch (NoSuchRoomMasterException e){ LOGGER.info(e.getMessage());}
			   catch (NumberFormatException e) { LOGGER.info(e.getMessage());}
			   catch (SystemException e) { LOGGER.info(e.getMessage());}			
		   }
		   DeleteSelectedItems delteItems=new DeleteSelectedItems();
		   delteItems.deleteRooms(request, response, roomlist);
		   SessionMessages.add(request, "room-deleteselected");
		}
	   	response.setRenderParameter("room_deleteselected", "roomdeleteselected");
	   	response.setRenderParameter(TAB,ROOMMASTER);
	 }
	private static final String TAB="tabs1";
	private static final String ROOMMASTER="RoomMaster";
	private static final Log LOGGER = LogFactoryUtil.getLog(RoomAction.class);
}
