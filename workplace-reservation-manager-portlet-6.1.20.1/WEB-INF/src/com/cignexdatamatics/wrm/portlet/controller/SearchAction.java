/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
/**
* <a href="GenericContentDTO.java.html">View Source</a>
*
* @Project     : WRM
* @Author      : Komal Vadukia
* @Description : This is the Action class which Process the action called from controller  
* @ChangeLog   :
* Name | Date | Reason
* Mayur Patel | 18-Aug-11 | Passing starttime and endtime for displaying in second screen
* ------------------------------------------------------------
*
*/
package com.cignexdatamatics.wrm.portlet.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.cignexdatamatics.wrm.NoSuchBookingRoomsException;
import com.cignexdatamatics.wrm.NoSuchNewBookingException;
import com.cignexdatamatics.wrm.NoSuchRoomMasterException;
import com.cignexdatamatics.wrm.model.BookingAttendees;
import com.cignexdatamatics.wrm.model.BookingRooms;
import com.cignexdatamatics.wrm.model.CityMaster;
import com.cignexdatamatics.wrm.model.FloorMaster;
import com.cignexdatamatics.wrm.model.LocationMaster;
import com.cignexdatamatics.wrm.model.NewBooking;
import com.cignexdatamatics.wrm.model.RoomMaster;
import com.cignexdatamatics.wrm.model.impl.BookingAttendeesImpl;
import com.cignexdatamatics.wrm.model.impl.BookingRoomsImpl;
import com.cignexdatamatics.wrm.portlet.utils.WRMConstants;
import com.cignexdatamatics.wrm.service.BookingAttendeesLocalServiceUtil;
import com.cignexdatamatics.wrm.service.BookingRoomsLocalServiceUtil;
import com.cignexdatamatics.wrm.service.CityMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.FloorMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.LocationMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.NewBookingLocalServiceUtil;
import com.cignexdatamatics.wrm.service.RoomMasterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 */

public class SearchAction
{

	public static final ResourceBundle WRMRB = ResourceBundle.getBundle("wrm_portlet");
	private static final String BR2 = "<br/>";

	private BestOptionResult br=new BestOptionResult();
	private StoreResult sr=new StoreResult();
	
	public void booking(ActionRequest request, ActionResponse response)
	{
		try{
			
		  long cityId=ParamUtil.getLong(request, CITYID);
	      long locationId=ParamUtil.getLong(request, LOCATIONID);
	      long floorId=ParamUtil.getLong(request, "floorId");
	      long jspRoomId=ParamUtil.getLong(request, "roomId");

	      String startdate=request.getParameter(SDATE);
	      String enddate=request.getParameter(EDATE);
	      String[] facilities=request.getParameterValues("facilitiesId");
	      Set facilitySet=getFacilityInSet(request);
	      String capacityVal=request.getParameter("Capacity");
	      int capacity=0;
	      if(capacityVal!=null && !StringPool.BLANK.equals(capacityVal))
	      {
	         capacity=Integer.parseInt(capacityVal);
	      }
	      String capacitychk=request.getParameter("box3");
	      String facalitychk=request.getParameter("box2");
	      String roomchk=request.getParameter("box1");
	      boolean capacityCheckFlag=false;
	      boolean facalityCheckFlag=false;
	      boolean roomCheckFlag=false;

	     if(capacitychk!=null)
	     {
	    	capacityCheckFlag=true;
	     }
	     if(facalitychk!=null)
	     {
	    	 facalityCheckFlag=true;
	     }
	     if(roomchk!=null)
	     {
	    	 roomCheckFlag=true;
	     }

	      SimpleDateFormat dtfrmt,formatter;
		  Date stdate,endate,sd,ed;

		   //temporary
		  dtfrmt=new SimpleDateFormat(FORMAT1);
		  stdate=dtfrmt.parse(startdate);
		  endate=dtfrmt.parse(enddate);

		   //final format
 	      formatter = new SimpleDateFormat(FORMAT2);
 	      String startDate= formatter.format(stdate);
		  String endDate= formatter.format(endate);

		  Calendar c = Calendar.getInstance();
		  Calendar c1 = Calendar.getInstance();
		  c.setTime(formatter.parse(startDate));
		  sd=formatter.parse(formatter.format(c.getTime()));
		  c.setTime(formatter.parse(endDate));
		  c.add(Calendar.DATE, 1);                 
  	      ed = formatter.parse(formatter.format(c.getTime()));

		   String sthours=request.getParameter("sthours");
	       String enhours=request.getParameter("enhours");

	       float floatsthours=Float.valueOf(sthours.trim()).floatValue();
	       float floatenhours=Float.valueOf(enhours.trim()).floatValue();

	       String stminutes=request.getParameter("stminutes");
	       String enminutes=request.getParameter("enminutes");

	       int intstminutes=Integer.parseInt(stminutes);
	       int intenminutes=Integer.parseInt(enminutes);

	       String stampm=request.getParameter("stampm");
	       String enampm=request.getParameter("enampm");

	       br=new BestOptionResult(cityId,locationId,floorId,jspRoomId,startdate,enddate,sthours,enhours,stminutes,enminutes,stampm,enampm,capacity,facilities);
	       floatsthours=SearchActionUtil.getHour(intstminutes,floatsthours,stampm);
           floatenhours=SearchActionUtil.getHour(intenminutes, floatenhours,enampm);
	       List<Long> filterbycityloc = SearchActionUtil.filterByLocAndCity(cityId, locationId, floorId);

		   //filtering by time n date

		   String filterbyDateTime=StringPool.BLANK;
		   String fixfilterbyDateTime=StringPool.BLANK;
		   String approxfilterbyDateTime=StringPool.BLANK;
		   String prioritywiseapproxfilterbyDateTime=StringPool.BLANK;
		   String bestapproxfilterbyDateTime=StringPool.BLANK;
		   String nextdate=startDate;
		   String nxt=startdate;
		   Date nd=sd;

		   while (!nd.equals(ed))
	       {
			   filterbyDateTime+=StringPool.AT+nxt;
			   fixfilterbyDateTime+=StringPool.AT+nxt;
			   bestapproxfilterbyDateTime+=StringPool.AT+nxt;
			   approxfilterbyDateTime+=StringPool.AT+nxt;
			   prioritywiseapproxfilterbyDateTime+=StringPool.AT+nxt;
			   //find all room available 4 one date 4m gape 4 given time

			   for(int i=0;i<filterbycityloc.size();i++)
	    	   {
				  try{
				  boolean timeflag=true;
	    		  long roomId=filterbycityloc.get(i);
	    		  List<BookingRooms> bookingroomobj=BookingRoomsLocalServiceUtil.findAllBookingByRoomIdAndBookingDate(roomId,nd);
	    		  Iterator<BookingRooms> bookingroomit = bookingroomobj.iterator();
		    	  boolean capacityflag=true;
		    	  boolean facilityflag=true;
		    	  while (bookingroomit.hasNext())
		    	  {
		    		  try{
		    			BookingRooms bookingroommaster=bookingroomit.next();
		    			long bookingId=bookingroommaster.getBookingId();
		    			NewBooking newbooking=NewBookingLocalServiceUtil.findAllBookingbyBookingId(bookingId);
		    			String startTimeofNewBooking=newbooking.getStartTime();
						String endTimeofNewBooking=newbooking.getEndTime();
						float floatsthoursDB=Float.valueOf(startTimeofNewBooking.trim()).floatValue();
						float floatenhoursDB=Float.valueOf(endTimeofNewBooking.trim()).floatValue();
						timeflag=SearchActionUtil.compareHours(floatsthours,floatsthoursDB,floatenhours,floatenhoursDB);
						if(!timeflag){break;}	
		    		  }catch(NoSuchNewBookingException e){ LOGGER.info(e.getMessage());}
		    	   }
		    	   if(timeflag)
		    	   {
                      try{
		    	  		RoomMaster room=RoomMasterLocalServiceUtil.findRoomByRoomId(roomId);
		    	  		long roomcapacity=room.getCapacity();
		    	  		double roomcapacityratio=0.0;
		    	  		double finalweight=0.0;
		    	  		double roomfacalityratio=0.0;
		    	  		if(capacity<roomcapacity)
		    	  		{
		    	  	    	roomcapacityratio=(double)capacity/roomcapacity;
		    	  		}
		    	  		else
		    	  		{
		    	  			roomcapacityratio=(double)roomcapacity/capacity;
		    	  		}
		    	  		roomfacalityratio=SearchActionUtil.findfacalityweight(roomId,(HashSet) facilitySet);
		    	  		if(facilitySet.isEmpty())
			    	  	{
			    	  			finalweight=roomcapacityratio;
			    	  	}
			    	  	else if(capacity<1)
			    	  	{
			    	  			finalweight=roomfacalityratio;
			    	  	}
			    	  	else
			    	  	{
		    	  			    finalweight=(roomcapacityratio*P50 + roomfacalityratio*P50);
			    	  	}
		    	  		String finalwght=String.valueOf(finalweight);
		    	  		if(!roomCheckFlag)
		    	  		{

		    	  			boolean checkfix=SearchActionUtil.checkByFixResults(roomId,capacity,(HashSet) facilitySet);
		    	  			boolean checkbestApprox=SearchActionUtil.checkbestApproxResults(roomId,capacity,(HashSet) facilitySet,capacityCheckFlag,facalityCheckFlag);
		    	  			boolean checkprioritywiseApprox=SearchActionUtil.checkprioritywiseApproxResults(roomId,capacity,(HashSet) facilitySet,capacityCheckFlag,facalityCheckFlag);
		    	  			boolean checkApprox=SearchActionUtil.checkApproxResults(roomId,capacity,(HashSet) facilitySet);
		    	  			if(checkfix)
		    	  			{
		    	  				fixfilterbyDateTime+=StringPool.COMMA+roomId;
		    	  			}
		    	  			else if(checkbestApprox)
		    	  			{
		    	  				bestapproxfilterbyDateTime+=StringPool.COMMA+roomId+StringPool.COLON+finalwght;
		    	  			}
		    	  			else if(checkprioritywiseApprox)
		    	  			{
		    	  				prioritywiseapproxfilterbyDateTime+=StringPool.COMMA+roomId+StringPool.COLON+finalwght;
		    	  			}
		    	  			else if(checkApprox)
		    	  			{
		    	  				capacityflag=SearchActionUtil.checkByCapacity(roomId,capacity,capacityCheckFlag);
		    	  				if(capacityflag)
		    	  				{
		    	  				   approxfilterbyDateTime+=StringPool.COMMA+roomId+StringPool.COLON+finalwght;
		    	  				}
		    	  			}
		    	  			else
		    	  			{
		    	  				capacityflag=SearchActionUtil.checkByCapacity(roomId,capacity,capacityCheckFlag);
		    	  				facilityflag=SearchActionUtil.checkByFacility(roomId,(HashSet) facilitySet,facalityCheckFlag);

		    	  				if(capacityflag)
		    	  				{
		    	  					filterbyDateTime+=StringPool.COMMA+roomId+StringPool.COLON+finalwght;

		    	  				}
		    	  				if(facalityCheckFlag && facilityflag)
		    	  				{
		    	  					filterbyDateTime+=StringPool.COMMA+roomId+StringPool.COLON+finalwght;
		    	  				}
		    		        }
		    	  		}
		    	  		else if(jspRoomId==roomId && roomCheckFlag)
		    	  		{
		    	  		     fixfilterbyDateTime+=StringPool.COMMA+roomId;
		    	  		}
                      }catch(NoSuchRoomMasterException e){LOGGER.info(e.getMessage());}
		    	     }
                      
				   }catch(NoSuchBookingRoomsException e){ LOGGER.info(e.getMessage());}
	    	      }	//CHECKED FOR ALL ROOM FOR ONE DATE

		         //NOW INCREMENT IN DATE

			    c.setTime(formatter.parse(nextdate));    //for same format as database
				c.add(Calendar.DATE, 1);                 // number of days to add
				nextdate =formatter.format(c.getTime());
				nd = formatter.parse(nextdate);

				c1.setTime(dtfrmt.parse(nxt));
				c1.add(Calendar.DATE, 1);                 //for proper format to display
				nxt =dtfrmt.format(c1.getTime());
	       }

	        //sorting of result according to weight

		   String approxfilterbyDateTime1=SearchActionUtil.sort(approxfilterbyDateTime);
		   String prioritywiseapproxfilterbyDateTime1=SearchActionUtil.sort(prioritywiseapproxfilterbyDateTime);
		   String bestapproxfilterbyDateTime1=SearchActionUtil.sort(bestapproxfilterbyDateTime);
		   String filterbyDateTime1=SearchActionUtil.sort(filterbyDateTime);


		   //merging of all 5 result based on priority
		   mergeResult(request, response, fixfilterbyDateTime,
				approxfilterbyDateTime1, prioritywiseapproxfilterbyDateTime1,
				bestapproxfilterbyDateTime1, filterbyDateTime1);
		}catch(ParseException e){ LOGGER.info(e.getMessage());}
		catch (SystemException e1) { LOGGER.info(e1.getMessage());}

		request.setAttribute("tempsearchingResult",br);
		response.setRenderParameter(SEARCHFLAG,SEARCHFLAG);
	}
	
	public Set getFacilityInSet(ActionRequest request)
	{
		 String[] facilities=request.getParameterValues("facilitiesId");
	     Set facilitySet=new HashSet();
	      if(facilities!=null)
	      {
	    	      for(int i=0;i<facilities.length;i++)
	    	      {
	    	    	  facilitySet.add(facilities[i]);
	    	      }
	      }
	      return facilitySet;
	}
	
	public void bookRoomDetails(ActionRequest request, ActionResponse response) 
	{
		   try
		   {
			   String loc=StringPool.BLANK;
			   String datelist=StringPool.BLANK;
			   String body=StringPool.BLANK;
			  boolean availability=true;
			  String startdate=request.getParameter(SDATE);
		      String enddate=request.getParameter(EDATE);

		      SimpleDateFormat dtfrmt,formatter,f1;
			  Date stdate,endate,sd,ed,sd1,ed1;

			   //temporary
			  dtfrmt=new SimpleDateFormat(FORMAT1);
			  stdate=dtfrmt.parse(startdate);
			  endate=dtfrmt.parse(enddate);

			   //final format
	   	      formatter = new SimpleDateFormat(FORMAT2);

	   	      String startDate= formatter.format(stdate);
			  String endDate= formatter.format(endate);


			  sd=formatter.parse(startDate);
			  ed = formatter.parse(endDate);



		      String sthours=request.getParameter("sthours");
		      String enhours=request.getParameter("enhours");


		      String stminutes=request.getParameter("stminutes");
		      String enminutes=request.getParameter("enminutes");

		      String stampm=request.getParameter("stampm");
		      String enampm=request.getParameter("enampm");

		      float floatsthours=Float.valueOf(sthours.trim()).floatValue();
		      float floatenhours=Float.valueOf(enhours.trim()).floatValue();

		      int intstminutes=Integer.parseInt(stminutes);
		      int intenminutes=Integer.parseInt(enminutes);

		      int sh=(int)floatsthours;
			   int eh=(int)floatenhours;
			   
			   if(WRMConstants.PM.equals(stampm)) {  sh=sh+WRMConstants.TWELVE;   }
			   if(WRMConstants.PM.equals(enampm)) {  eh=eh+WRMConstants.TWELVE;   }
			   String shr=String.valueOf(sh);
			   String ehr=String.valueOf(eh);
              

			   floatsthours=SearchActionUtil.getHour(intstminutes,floatsthours,stampm);
	           floatenhours=SearchActionUtil.getHour(intenminutes, floatenhours,enampm);

			 
		     String host=request.getParameter("host");
		     String meetingTitle=request.getParameter("meetingTitle");
		     String meetingDesc=request.getParameter("meetingDesc");
		     String attendees=request.getParameter("attendees");
		     String eTime= SearchActionUtil.setTimeFormat(String.valueOf(floatenhours));
		 	 String sTime= SearchActionUtil.setTimeFormat(String.valueOf(floatsthours));
		     
		 	    ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();
			     DynamicQuery dynamicQuery =DynamicQueryFactoryUtil.forClass(User.class, classLoader)
					.add(PropertyFactoryUtil.forName("emailAddress").like(request.getParameter("host").trim()));
			     List<User> userList=(List<User>)UserLocalServiceUtil.dynamicQuery(dynamicQuery);
				 Iterator <User>it=userList.iterator();
				 User user=(User) it.next();
				 String hostname = user.getFullName();
				 long hostId=user.getUserId();
		     
            long bookingId=SearchActionUtil.handleNewBookingTable(hostId,sd,ed,String.valueOf(floatsthours),String.valueOf(floatenhours),meetingTitle,meetingDesc );
            if(bookingId>0)
            {
			 //maintain bookinRooms table
			 int l=0;
	    	 String delemiter=StringPool.AT;
	    	 List<String>dateList=new ArrayList<String>();
	      	 String dateRoomlist=request.getParameter("dateRoomlist");
			 if(dateRoomlist!=null)
		 	 {
		          String []roomDateIds=dateRoomlist.split(delemiter);
		          for(int i=1;i<roomDateIds.length;i++)
		          {

		             String []dateRoom=roomDateIds[i].split(StringPool.COMMA);
	                 long roomId=Long.parseLong(dateRoom[1].trim());
	                 if(roomId!=0)
	                 {      	 
	                	 
	                  String date=dateRoom[0];
	                  Date d1=dtfrmt.parse(date);
		              String d2= formatter.format(d1);
		              Date bookingDate=formatter.parse(d2);
		              boolean timeflag=true;
	               	  List<BookingRooms> bookingroomobj=BookingRoomsLocalServiceUtil.findAllBookingByRoomIdAndBookingDate(roomId,bookingDate);
		    		  Iterator<BookingRooms> bookingroomit = bookingroomobj.iterator();
			    	  while (bookingroomit.hasNext())
			    	  {
			    			BookingRooms bookingroommaster=bookingroomit.next();
			    			long bookingId2=bookingroommaster.getBookingId();
			    			NewBooking newbooking2=NewBookingLocalServiceUtil.findAllBookingbyBookingId(bookingId2);
			    			String startTimeofNewBooking=newbooking2.getStartTime();
							String endTimeofNewBooking=newbooking2.getEndTime();
							float floatsthoursDB=Float.valueOf(startTimeofNewBooking.trim()).floatValue();
							float floatenhoursDB=Float.valueOf(endTimeofNewBooking.trim()).floatValue();
							timeflag=SearchActionUtil.compareHours(floatsthours,floatsthoursDB,floatenhours,floatenhoursDB);
						    if(!timeflag){break;}
			    	   }	 
	                   if(!timeflag)
	                   {
	                        availability=false;
	                        break;
	                   }
	                   else
	                   { 
	                	 dateList.add(date);
		                 RoomMaster roomMasterobj = RoomMasterLocalServiceUtil.findRoomByRoomId(roomId);
			             FloorMaster floorMasterobj = FloorMasterLocalServiceUtil.findFloorbyFloorId(roomMasterobj.getFloorId());
			             LocationMaster locationMasterobj = LocationMasterLocalServiceUtil.findLocationbyLocationId(roomMasterobj.getLocationId());
			             CityMaster cityMasterobj = CityMasterLocalServiceUtil.findCitybyCityId( roomMasterobj.getCityId());
			             String cityName = cityMasterobj.getCityName();
			             String locationName = locationMasterobj.getLocationName();
		                 datelist += date + " Location:" + " " + cityName + ", " +locationName + ", " + floorMasterobj.getFloorName()+" floor, " + roomMasterobj.getRoomName() + BR2 ;
		    			 loc=cityName + ", " +locationName ;
		                 BookingRoomsImpl bookingRoom=new BookingRoomsImpl();
		                 bookingRoom.setBookingId(bookingId);
		                 bookingRoom.setRoomId(roomId);
		                 bookingRoom.setBookingDate(bookingDate);
		                 BookingRoomsLocalServiceUtil.addBookingRooms(bookingRoom);
		                 l++;
	                    }
		              }
		           }
		 	 }
	         if(availability)
	         {
	         String []allAttendees=attendees.split(StringPool.COMMA);
	         String []host1=new String[2];	 
	         List<String> attendessName =maintainAttendeesTable(attendees,classLoader, bookingId);
		     l--;

		     stdate=dtfrmt.parse(dateList.get(I0));
			 endate=dtfrmt.parse(dateList.get(l));

		     f1 = new SimpleDateFormat("yyyy-MM-dd");
			 String s1=f1.format(stdate);
			 String e1=f1.format(endate);

		     sd1=formatter.parse(s1+" "+shr+StringPool.COLON+stminutes+":00");
			 ed1=formatter.parse(e1+" "+ehr+StringPool.COLON +enminutes+":00");
	    
	         String entemp[]=eTime.split(StringPool.COLON);
		     if(entemp[0].equalsIgnoreCase("0"))
		     {
		    	 eTime="12"+StringPool.COLON+entemp[1];
		     }

		     String sttemp[]=sTime.split(StringPool.COLON);
		     if(sttemp[0].equalsIgnoreCase("0"))
		     {
		    	 sTime="12"+StringPool.COLON+sttemp[1];
		     }
		   
		     body = getAllAttendeesInvitesMessageBody(hostname, meetingDesc, datelist, sTime, eTime);	         
			 if(!attendessName.isEmpty()){				
		    	 SearchActionUtil.sendMeetingRequest( allAttendees ,sd1, ed1 ,host, meetingTitle,body,loc);
		    	 SessionMessages.add(request,"mail-sent-to-attendees");
		     }
		     host1[0]=host;
		     ThemeDisplay themeDisplay=(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	         User currentUser = themeDisplay.getUser();
		     String userAddress=currentUser.getEmailAddress();
		     String userName=currentUser.getFullName();
		     String msg=StringPool.BLANK;
		     if(!userAddress.equalsIgnoreCase(host)){		    	
		         msg=" has booked meeting room on your behalf <br/><br/><b>";
		     }else{		    	
		    	 msg=", your booking is confirmed. <br/><br/><b>";
		     } 
		     body = getBookingConfirmationMessageBody(userName, meetingDesc, datelist, sTime, eTime, msg);				
			 SearchActionUtil.sendMeetingRequest( host1 ,sd1, ed1 ,userAddress,meetingTitle,body,loc);
		     SessionMessages.add(request,"booking-successful");
	         }
	         else{	 SessionErrors.add(request, "room-book-meanwhile"); }
            }
		   }
		   catch (ParseException e) 
		   {
			   LOGGER.info(e.getMessage());
		   }
		   catch (PortalException e) 
		   {
			   LOGGER.info(e.getMessage());
		   }
		   catch (SystemException e) 
		   {
			   LOGGER.info(e.getMessage());
		   }
		   response.setRenderParameter(TAB,"NewBooking");
	}
	
	public List<String> maintainAttendeesTable(String attendees,ClassLoader classLoader,long bookingId) throws SystemException
	{
		 String []allAttendees=attendees.split(StringPool.COMMA);
	     List<String> attendessName = new ArrayList<String>();
	     DynamicQuery dynamicQuery1;
	     for(int j=0;j<allAttendees.length;j++)
		 {
	    	 dynamicQuery1 =DynamicQueryFactoryUtil.forClass(User.class, classLoader)
			.add(PropertyFactoryUtil.forName("emailAddress").like(allAttendees[j].trim()));
	    	 List<User> userList=(List<User>)UserLocalServiceUtil.dynamicQuery(dynamicQuery1);
	    	 Iterator<User> it2=userList.iterator();
	    	 while(it2.hasNext())
	    	 {
	    		 	User user1=(User) it2.next();
	    		 	long attendeesId=user1.getUserId();
	    		 	BookingAttendeesImpl bookingAttendees=new BookingAttendeesImpl();
	    		  	String attendeesName= user1.getFirstName();
	    		 	attendessName.add(attendeesName);
	    		 	bookingAttendees.setBookingId(bookingId);
	    		 	bookingAttendees.setAttendeesId(attendeesId);
	    		 	BookingAttendeesLocalServiceUtil.addBookingAttendees(bookingAttendees);
	    	 }
		 }
	     return attendessName;
	}
	
	public String getBookingConfirmationMessageBody(String userName,String meetingDesc,String datelist,String sTime,String eTime,String msg)
	{
		String body  = StringPool.BLANK;
		try 
		{
			String temeplate = StringUtil.read(getClass().getClassLoader(), "com/cignexdatamatics/wrm/mailtemplate/bookingConfirmation.tmpl", false);
			body = StringUtil.replace(temeplate, new String[] {"[$USER_NAME$]","[$MEETING_DESC$]","[$DATE_LIST$]","[$START_TIME$]","[$END_TIME$]","[$MESSAGE$]"}, 
					new String[] {userName,meetingDesc,	datelist,sTime,eTime,msg});
		} catch (Exception e) {
			 LOGGER.info(e.getMessage());
		}
		return body;
	}
	
	public String getAllAttendeesInvitesMessageBody(String hostname,String meetingDesc,String datelist,String sTime,String eTime)
	{
		String body  = StringPool.BLANK;
		try 
		{
			String temeplate = StringUtil.read(getClass().getClassLoader(), "com/cignexdatamatics/wrm/mailtemplate/allAttendeesInvites.tmpl", false);
			body = StringUtil.replace(temeplate, new String[] {"[$HOST_NAME$]","[$MEETING_DESC$]","[$DATE_LIST$]","[$START_TIME$]","[$END_TIME$]"}, 
					new String[] {hostname,meetingDesc,	datelist,sTime,eTime});
		} catch (Exception e) {
			 LOGGER.info(e.getMessage());
		}
		return body;
	}
	
	public String cancleInternalBookingDetails(ActionRequest request)
    {
	   String flag=request.getParameter("flag");
       try{
		int i=0;
		long brmappingId = ParamUtil.getLong(request, "resourcePrimKey");
		BookingRooms roomMapping=BookingRoomsLocalServiceUtil.findBookingById(brmappingId);
		long bookingId=roomMapping.getBookingId();
		long roomId=roomMapping.getRoomId();
		Date bookingDate = roomMapping.getBookingDate();
		SimpleDateFormat format1;
		format1  = new SimpleDateFormat("MM-dd-yyyy");
		String bDate= format1.format(bookingDate);
		List<String> attendeesIds = new ArrayList<String>();
		List<String> attendeesEmail = new ArrayList<String>();
		List<BookingAttendees> attendees = BookingAttendeesLocalServiceUtil.findAllbyBookingId(bookingId);
		Iterator<BookingAttendees> it2 = attendees.iterator();
		while(it2.hasNext()){
			try{
				BookingAttendees bookingattendees = it2.next();
				long attendeesId1 = bookingattendees.getAttendeesId();
				User userobj1=UserLocalServiceUtil.getUser(attendeesId1);
				String attendeesName1 = userobj1.getFirstName();
				attendeesIds.add(attendeesName1);
				String attendeesEmail1 = userobj1.getEmailAddress();
				attendeesEmail.add(attendeesEmail1);
			 }catch (SystemException e1) { LOGGER.info(e1.getMessage());}
		     catch (PortalException e){ LOGGER.info(e.getMessage());}
		}
		
		sendCancelMail(bookingId, roomId, bDate, attendeesIds, attendeesEmail);
		List<BookingRooms> roombyBookingId= BookingRoomsLocalServiceUtil.findMappingByBookingId(bookingId);
		Iterator<BookingRooms> it=roombyBookingId.iterator();
		while (it.hasNext()){
				i++; it.next();
		}
		if(i==1){
				NewBookingLocalServiceUtil.deleteNewBooking(bookingId);
				List<BookingAttendees> ba=BookingAttendeesLocalServiceUtil.findAllbyBookingId(bookingId);
				Iterator <BookingAttendees>it1=ba.iterator();
				while(it1.hasNext()){
					BookingAttendees bookingAttendeesobj=it1.next();
					BookingAttendeesLocalServiceUtil.remove(bookingAttendeesobj);
				}
		}
		BookingRoomsLocalServiceUtil.deleteBookingRooms(brmappingId);
		SessionMessages.add(request, "booking-cancled");
       }catch (SystemException e1) { LOGGER.info(e1.getMessage());}
        catch (PortalException e){ LOGGER.info(e.getMessage());}
		return flag;
	}
	
	public void sendCancelMail(long bookingId,long roomId,String bDate,List<String> attendeesIds,List<String> attendeesEmail) throws  SystemException,PortalException
	{
		NewBooking newbookingList = NewBookingLocalServiceUtil.findAllBookingbyBookingId(bookingId);
		long hostId = newbookingList.getHostId();
		String desc = newbookingList.getMeetingDesc();
		String startTimeOfCancel = newbookingList.getStartTime();
		String endTimeOfCancel = newbookingList.getEndTime();
		String cancelStartTime =  SearchActionUtil.setTimeFormat(startTimeOfCancel);
		String cancelEndTime = SearchActionUtil.setTimeFormat(endTimeOfCancel);
		User userobj=UserLocalServiceUtil.getUser(hostId);
		String hostname=userobj.getFullName();
		RoomMaster roomMasterobj = RoomMasterLocalServiceUtil.findRoomByRoomId(roomId);
		FloorMaster floorMasterobj = FloorMasterLocalServiceUtil.findFloorbyFloorId(roomMasterobj.getFloorId());
		LocationMaster locationMasterobj = LocationMasterLocalServiceUtil.findLocationbyLocationId(roomMasterobj.getLocationId());
		CityMaster cityMasterobj = CityMasterLocalServiceUtil.findCitybyCityId(roomMasterobj.getCityId());
		String dateAndLocation = bDate + " " + WRMRB.getString("location")+ StringPool.COLON + " " +cityMasterobj.getCityName() + ", " +locationMasterobj.getLocationName() + ", " + floorMasterobj.getFloorName()+" floor," + roomMasterobj.getRoomName() + BR2 ;
		String mailBody="Hello,<br/><br/>This is a system generated message, please contact meeting host for any question,<br/> <br/>    " + hostname + " has cancelled this meeting.<br/><br/>";
		if(desc!=null && !StringPool.BLANK.equals(desc)){
		    mailBody += "<b>Agenda:</b><p>    " + desc + "</p>";			
		}
		mailBody += "<br/><b>Date & Location (mm/dd/yyyy):</b><p>     "	+dateAndLocation+ "</p><b>Time (IST - GMT + 5:30):</b><p>From " +cancelStartTime + " To " + cancelEndTime + "</p><br/>Thank You<br/>" + hostname;
			        
		for(int k=0;k<attendeesIds.size();k++){
			SearchActionUtil.sendCancelMail(userobj.getEmailAddress(), hostname , attendeesEmail.get(k) ,mailBody);
		}
	}

	private void mergeResult(ActionRequest request, ActionResponse response,
			String fixfilterbyDateTime, String approxfilterbyDateTime1,
			String prioritywiseapproxfilterbyDateTime1,
			String bestapproxfilterbyDateTime1, String filterbyDateTime1) {
		   String delemiter=StringPool.AT;
		   String[] med;
		   String[] med1;
		   String[] med2;
		   String finalresult1=StringPool.BLANK;
		   String finalresult2=StringPool.BLANK;
		   String finalresult3=StringPool.BLANK;
		   String finalresult=StringPool.BLANK;
		   String[] fixResult=fixfilterbyDateTime.split(delemiter);
		  StringBuffer buffFinalresult2=new StringBuffer();
		  finalresult2= getBuffFinalResult2(fixResult, bestapproxfilterbyDateTime1, buffFinalresult2);
		  med2=finalresult2.split(delemiter);
	
		  StringBuffer buffFinalresult3=new StringBuffer();
		  finalresult3= getBuffFinalResult3(med2, prioritywiseapproxfilterbyDateTime1, buffFinalresult3);
		  med1=finalresult3.split(delemiter);
		
		  StringBuffer buffFinalresult1=new StringBuffer();
	      finalresult1= getBuffFinalResult4(med1, approxfilterbyDateTime1, buffFinalresult1);
		  med=finalresult1.split(delemiter);
		  StringBuffer buffFinalresult=new StringBuffer();
		  finalresult= getBuffFinalResult(med, filterbyDateTime1, buffFinalresult);

	      response.setRenderParameter("finalResult",finalresult);
		  SessionMessages.add(request, "search-complete");
	}

	public String getBuffFinalResult2(String[] fixResult,String bestapproxfilterbyDateTime1,StringBuffer buff)
	{
		 String delemiter=StringPool.AT;
		 StringBuffer buffFinalresult2=new StringBuffer();
		   for(int t=0;t<fixResult.length;t++)
		   {
		   		  String[] bestapproxResult=bestapproxfilterbyDateTime1.split(delemiter);
		 		  String bookids1[]=bestapproxResult[t].split(StringPool.COMMA);
		 		  for(int y=1;y<bookids1.length;y++)
		 	 	  {
		 			 buff.append(StringPool.COMMA);
		 			 buff.append(bookids1[y]);		 			
		 	  	  }
		 		 fixResult[t]=fixResult[t]+buff.toString();	
		 		 buff.delete(0,buff.length());
		    }
		    for(int t=1;t<fixResult.length;t++)
		    {
		    	 buffFinalresult2.append(StringPool.AT);
		    	 buffFinalresult2.append(fixResult[t]);
		   	}
		    return buffFinalresult2.toString();
	}
	
	public String getBuffFinalResult3(String[] med2,String prioritywiseapproxfilterbyDateTime1,StringBuffer buff)
	{
		 String delemiter=StringPool.AT;
		StringBuffer buffFinalresult3=new StringBuffer();
	     for(int t=0;t<med2.length;t++)
	     {
	     	  String[] priapproxResult=prioritywiseapproxfilterbyDateTime1.split(delemiter);
	 		  String bookids3[]=priapproxResult[t].split(StringPool.COMMA);
	 		  for(int y=1;y<bookids3.length;y++)
	 	 	  {
	 			 buff.append(StringPool.COMMA);
	 			 buff.append(bookids3[y]);		 			  
	 	  	  }
	 	     med2[t]=med2[t]+buff.toString();
	 	     buff.delete(0,buff.length());
	      }
	      for(int t=1;t<med2.length;t++)
	      {
	    	  buffFinalresult3.append(StringPool.AT);
	    	  buffFinalresult3.append( med2[t]);
	   	  }
	      return buffFinalresult3.toString();
	}
	
	public String getBuffFinalResult4(String[] med1,String approxfilterbyDateTime1,StringBuffer buff)
	{
		 String delemiter=StringPool.AT;
		 StringBuffer buffFinalresult1=new StringBuffer();
	     for(int t=0;t<med1.length;t++)
	   	 {
	   		  String[] approxResult=approxfilterbyDateTime1.split(delemiter);
	 		  String bookids2[]=approxResult[t].split(StringPool.COMMA);
	 		  for(int y=1;y<bookids2.length;y++)
	 	 	  {
	 			 buff.append(StringPool.COMMA);
	 			 buff.append(bookids2[y]);			 			
	 	  	  }
	 	     med1[t]=med1[t]+buff.toString();
	 	     buff.delete(0,buff.length());		 	    
	      }
	      for(int t=1;t<med1.length;t++)
	      {
	    	  buffFinalresult1.append(StringPool.AT);
	    	  buffFinalresult1.append(med1[t]);
	   	  }
	      return buffFinalresult1.toString();
	}
	
	public String getBuffFinalResult(String[] med,String filterbyDateTime1,StringBuffer buff)
	{
		  String delemiter=StringPool.AT;
		  StringBuffer buffFinalresult=new StringBuffer();
	      for(int t=0;t<med.length;t++)
	   	  {
	     	  String[] remainingResult=filterbyDateTime1.split(delemiter);
	 		  String bookids[]=remainingResult[t].split(StringPool.COMMA);
	 		  for(int y=1;y<bookids.length;y++)
	 	 	  {
	 			 buff.append(StringPool.COMMA);
	 			 buff.append(bookids[y]);		 			 
	 	  	  }
	 	      med[t]=med[t]+buff.toString();
	 	      buff.delete(0,buff.length());
	      }
	      for(int t=1;t<med.length;t++)
	      {
	    	  buffFinalresult.append(StringPool.AT);
	    	  buffFinalresult.append(med[t]);
	   	  }
	      return buffFinalresult.toString();
	}

	public void mybooking(ActionRequest request, ActionResponse response)
	{
		try
		{
		  long cityId=ParamUtil.getLong(request, CITYID);
		  long locationId=ParamUtil.getLong(request, LOCATIONID);
	      long floorId=ParamUtil.getLong(request, "floorId");

	      String startdate=request.getParameter(SDATE);
	      String enddate=request.getParameter(EDATE);

	      SimpleDateFormat dtfrmt,formatter;
		  Date stdate,endate,sd,ed;

		  dtfrmt=new SimpleDateFormat(FORMAT1);
		  stdate=dtfrmt.parse(startdate);
		  endate=dtfrmt.parse(enddate);

		   //final format
   	      formatter = new SimpleDateFormat(FORMAT2);
   	      String startDate= formatter.format(stdate);
		  String endDate= formatter.format(endate);

		  Calendar c = Calendar.getInstance();
		  sd=formatter.parse(startDate);

		  c.setTime(formatter.parse(endDate));
		  c.add(Calendar.DATE, 1);                 // number of days to add
  	      ed = formatter.parse(formatter.format(c.getTime()));
          sr=new StoreResult(cityId,locationId,floorId,startdate,enddate);
	      List<Long> al = SearchActionUtil.filterByFloorLocCity(cityId, locationId, floorId);

		  // check is room booked 4 given date
		   int j=0;
		   String bookingal=null;
		   for(int i=0;i<al.size();i++)
		   {
			   try{
			    long roomId= al.get(i);
			    String nextdate=startDate;
			    Date nd=sd;
		   		while (!nd.equals(ed))
			    {
		   			String data[] = checkAndSetBooking(roomId, nd, bookingal, j);
		   			bookingal = data[0];
		   			j = Integer.parseInt(data[1]);
			    	c.setTime(formatter.parse(nextdate));
	    			c.add(Calendar.DATE, 1);  // number of days to add
	    			nextdate =formatter.format(c.getTime());
	    			nd = formatter.parse(nextdate);
				 }
			   }catch(ParseException e){ LOGGER.info(e.getMessage());}
			}
			response.setRenderParameter("MyBookingResult", bookingal);

		}catch(ParseException e){ LOGGER.info(e.getMessage());}
		catch (SystemException e1) { LOGGER.info(e1.getMessage());}
		catch (Exception e1) { LOGGER.info(e1.getMessage());}
		setMybookingAttr(request, response);
	}
	
	public void setMybookingAttr(ActionRequest request, ActionResponse response)
	{
		request.setAttribute("tempmybookingResult",sr);
		response.setRenderParameter(BOOKINGFLAG,BOOKINGFLAG);
		response.setRenderParameter("mybooking", "mybooking");
	  	response.setRenderParameter(TAB,"MyBooking");
		response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, ParamUtil.getString (request,SearchContainer.DEFAULT_DELTA_PARAM));
	  	response.setRenderParameter(SearchContainer.DEFAULT_CUR_PARAM, ParamUtil.getString (request,SearchContainer.DEFAULT_CUR_PARAM, String.valueOf(SearchContainer.DEFAULT_CUR)));
	}
	
	public String[] checkAndSetBooking(long roomId, Date nd, String bookingal,int j) throws SystemException
	{
		String data[] = new String[2];
		String newBookingal = bookingal;
		int count = j;
		try{
		    List<BookingRooms> bookingroomobj2=BookingRoomsLocalServiceUtil.findAllBookingByRoomIdAndBookingDate(roomId,nd);
    		Iterator<BookingRooms> bookingroomit2 = bookingroomobj2.iterator();
    		while (bookingroomit2.hasNext()){
    			BookingRooms bookingroommaster=bookingroomit2.next();
    			long bookingRoomMappingId= bookingroommaster.getBRMappingId();
    			if (j==0){
    				newBookingal=String.valueOf(bookingRoomMappingId);
    				count++;
    			}else{
    				newBookingal+=StringPool.COMMA+bookingRoomMappingId;
    			}
    		}
		}
		catch (NoSuchBookingRoomsException e){ LOGGER.info(e.getMessage());}
		data[0] = newBookingal;
		data[1] = count+"";
		return data;
	}

	public void browsing(ActionRequest request, ActionResponse response)
	{
		try
		{

		  long cityId=ParamUtil.getLong(request, CITYID);
	      long locationId=ParamUtil.getLong(request, LOCATIONID);
	      long floorId=ParamUtil.getLong(request, "floorId");

	      String startdate=request.getParameter(SDATE);
	      String enddate=request.getParameter(EDATE);

	      SimpleDateFormat dtfrmt,formatter;
		  Date stdate,endate,sd,ed;

		   //temporary
		  dtfrmt=new SimpleDateFormat("MM/dd/yy");
		  stdate=dtfrmt.parse(startdate);
		  endate=dtfrmt.parse(enddate);

		   //final format
   	      formatter = new SimpleDateFormat(FORMAT2);
   	      String startDate= formatter.format(stdate);
		  String endDate= formatter.format(endate);

		  Calendar c = Calendar.getInstance();
		  sd=formatter.parse(startDate);

		  c.setTime(formatter.parse(endDate));
		  c.add(Calendar.DATE, 1);                 // number of days to add
  	      ed = formatter.parse(formatter.format(c.getTime()));
  	      
		  sr=new StoreResult(cityId,locationId,floorId,startdate,enddate);
	      List<Long> al = SearchActionUtil.filterByFloorLocCity(cityId, locationId, floorId);
		  // check is room booked 4 given date
		   int j=0;
		   String bookingal=null;
		   for(int i=0;i<al.size();i++){
			   try{
			    long roomId= al.get(i);
			    String nextdate=startDate;
			    Date nd=sd;
			 	while (!nd.equals(ed)){
			 		String data[] = checkAndSetBooking(roomId, nd, bookingal, j);
		   			bookingal = data[0];
		   			j = Integer.parseInt(data[1]);
			    	 c.setTime(formatter.parse(nextdate));
	    			 c.add(Calendar.DATE, 1);  // number of days to add
	    			 nextdate =formatter.format(c.getTime());
	    			 nd = formatter.parse(nextdate);
			      }
			   }catch(ParseException e){ LOGGER.info(e.getMessage());}
			 }
			response.setRenderParameter("browseResult", bookingal);

		}catch(ParseException e){ LOGGER.info(e.getMessage());}
		catch (SystemException e1) { LOGGER.info(e1.getMessage());}
		catch (Exception e1) { LOGGER.info(e1.getMessage());}
		setBrowsingAtt(request, response);
		
	}
	
	public void setBrowsingAtt(ActionRequest request, ActionResponse response)
	{
		request.setAttribute("tempbrowsingResult",sr);
		response.setRenderParameter(BROWSEFLAG,BROWSEFLAG);
		response.setRenderParameter("searchbrowse", "searchbrowse");
	  	response.setRenderParameter(TAB,"BookingBrowser");

	  	response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, ParamUtil.getString (request,SearchContainer.DEFAULT_DELTA_PARAM));
	  	response.setRenderParameter(SearchContainer.DEFAULT_CUR_PARAM, ParamUtil.getString (request,SearchContainer.DEFAULT_CUR_PARAM, String.valueOf(SearchContainer.DEFAULT_CUR)));
	}
	
	public String[] checkAndSetBrowsing(long roomId, Date nd, String bookingal,int j) throws SystemException
	{
		String data[] = new String[2];
		String newBookingal = bookingal;
		int count = j;
		try{
			List<BookingRooms> bookingroomobj2=BookingRoomsLocalServiceUtil.findAllBookingByRoomIdAndBookingDate(roomId,nd);
    		Iterator<BookingRooms> bookingroomit2 = bookingroomobj2.iterator();
    		while (bookingroomit2.hasNext()){
    			BookingRooms bookingroommaster=bookingroomit2.next();
    			long bookingRoomMappingId= bookingroommaster.getBRMappingId();
    			if (j==0){
    				newBookingal=String.valueOf(bookingRoomMappingId);
    				count++;
    			}else{
    				newBookingal+=StringPool.COMMA+bookingRoomMappingId;
    			}
    		}
 		 }catch (NoSuchBookingRoomsException e){ LOGGER.info(e.getMessage());}
		data[0] = newBookingal;
		data[1] = count+"";
		return data;
	}

	public void bookRoom(ActionRequest request, ActionResponse response) 
	{

        try{
		 long cityId=ParamUtil.getLong(request, CITYID);
	     long locationId=ParamUtil.getLong(request, LOCATIONID);
	     long jspRoomId=ParamUtil.getLong(request, "roomId");


	      String startdate=request.getParameter(SDATE);
	      String enddate=request.getParameter(EDATE);

	      String sthours=request.getParameter("sthours1");
	      String enhours=request.getParameter("enhours1");

	      String stminutes=request.getParameter("stminutes1");
	      String enminutes=request.getParameter("enminutes1");

	      String stampm=request.getParameter("stampm1");
	      String enampm=request.getParameter("enampm1");

	      String starttime=sthours+StringPool.COLON+stminutes+" "+stampm;
	      String endtime=enhours+StringPool.COLON+enminutes+" "+enampm;
	      
	      String timeRoom=starttime+StringPool.COMMA+endtime;
	      
	      br=new BestOptionResult(cityId,locationId,0,jspRoomId,startdate,enddate,sthours,enhours,stminutes,enminutes,stampm,enampm,0L,null);

	      // String dateRoomlist=StringPool.BLANK;
	       StringBuffer buffDateRoomlist = new StringBuffer();
	       Calendar c = Calendar.getInstance();
	       SimpleDateFormat formatter=new SimpleDateFormat(FORMAT1);
	       Date sd=formatter.parse(startdate);
	       c.setTime(formatter.parse(enddate));
	       c.add(Calendar.DATE, 1);                 // number of days to add
	       Date ed = formatter.parse(formatter.format(c.getTime()));
	       Date nd=sd;
	       int[] nullcheck=new int[LIMIT];
	       int k=0;
	     //  boolean flag=false;
	       String nextdate =startdate;
	       while (!nd.equals(ed))
	       {
	    	//   dateRoomlist+=StringPool.AT+nextdate;
	    	   buffDateRoomlist.append(StringPool.AT);
	    	   buffDateRoomlist.append(nextdate);
	    	   long roomId=ParamUtil.getLong(request,nextdate);
	    	   if(roomId>=1)
	    	   {
	    		   nullcheck[k]=1;
	    	   }
	    	   else
	    	   {
	    		   nullcheck[k]=I0;
	    	   }
	    	   k++;
	    	  // dateRoomlist+=StringPool.COMMA+roomId;
	    	   buffDateRoomlist.append(StringPool.COMMA);
	    	   buffDateRoomlist.append(roomId);
	           c.setTime(formatter.parse(nextdate));
	           c.add(Calendar.DATE, 1);  // number of days to add
	           nextdate =formatter.format(c.getTime());
	           nd = formatter.parse(nextdate);
	      }
	       checkAndSetAttforBookRoom(request, response, nullcheck, k, buffDateRoomlist.toString(), timeRoom);
	 }catch(ParseException e){LOGGER.info(e.getMessage());}
    	  response.setRenderParameter(SEARCHFLAG,SEARCHFLAG);
    	  response.setRenderParameter(TAB,"NewBooking");
	}
	
	public void checkAndSetAttforBookRoom(ActionRequest request, ActionResponse response,int[] nullcheck,int k,String buffDateRoomlist,String timeRoom) 
	{
		 boolean flag=false;
		 for(int i=0;i<k;i++)
	      {
	    	  if(nullcheck[i]==1)
	    	  {
	    		  flag=true;
	    	 	  break;
	    	  }
	      }
	      if(flag)
	      {
	    	  response.setRenderParameter("room_book", "room_book");
	    	  response.setRenderParameter("newbook","newbook");
	      }
	      else
	      {
	    	  SessionErrors.add(request,"room-not-selected" );
	    	  booking(request,response);
	      }
	      response.setRenderParameter("dateRoomlist", buffDateRoomlist);
	      request.setAttribute("tempsearchingResult",br);
	      response.setRenderParameter("timeRoom",timeRoom);
	}
	
	public void cancleBooking(ActionRequest request, ActionResponse response)
	{
		String flag = cancleInternalBookingDetails(request);
		browsing(request,response);
		if(!BROWSEFLAG.equals(flag)){
				 response.setRenderParameter(BROWSEFLAG,"flag4alldelete");
		}
		response.setRenderParameter("booking_delete", "bookingdelete");
		response.setRenderParameter(TAB,"BookingBrowser");
		response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, ParamUtil.getString (request,SearchContainer.DEFAULT_DELTA_PARAM));
	  	response.setRenderParameter(SearchContainer.DEFAULT_CUR_PARAM, ParamUtil.getString (request,SearchContainer.DEFAULT_CUR_PARAM, String.valueOf(SearchContainer.DEFAULT_CUR)));
	}

	public void cancleMyBooking(ActionRequest request, ActionResponse response)
	{
	 	String flag = cancleInternalBookingDetails(request);
	    mybooking(request,response);
		if(!BOOKINGFLAG.equals(flag)){
			   response.setRenderParameter(BOOKINGFLAG,"flag4mydelete");
		}	
		response.setRenderParameter("mybooking_delete", "bookingdelete");
	   	response.setRenderParameter(TAB,"MyBooking");
		response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, ParamUtil.getString (request,SearchContainer.DEFAULT_DELTA_PARAM));
	  	response.setRenderParameter(SearchContainer.DEFAULT_CUR_PARAM, ParamUtil.getString (request,SearchContainer.DEFAULT_CUR_PARAM, String.valueOf(SearchContainer.DEFAULT_CUR)));
	}

	 private static final double P50=0.50;
	 private static final int I0=0;
	 private static final int LIMIT=100000;
	 private static final String BROWSEFLAG="flag4browsing";
	 private static final String BOOKINGFLAG="flag4mybooking";
	 private static final String SEARCHFLAG="flag4searching";
	 private static final String FORMAT1="MM/dd/yyyy";
	 private static final String FORMAT2="yyyy-MM-dd HH:mm:ss";
	 private static final String SDATE="StartDate";
	 private static final String EDATE="EndDate";
	 private static final String TAB="tabs1";
	 private static final String CITYID="cityId";
	 private static final String LOCATIONID="locationId";
	 private static final Log LOGGER = LogFactoryUtil.getLog(SearchAction.class);

}