package com.cignexdatamatics.wrm.portlet.controller;

import com.cignexdatamatics.wrm.NoSuchRoomMasterException;
import com.cignexdatamatics.wrm.model.NewBooking;
import com.cignexdatamatics.wrm.model.RoomFacilityMapping;
import com.cignexdatamatics.wrm.model.RoomMaster;
import com.cignexdatamatics.wrm.model.impl.NewBookingImpl;
import com.cignexdatamatics.wrm.portlet.utils.WRMConstants;
import com.cignexdatamatics.wrm.service.NewBookingLocalServiceUtil;
import com.cignexdatamatics.wrm.service.RoomFacilityMappingLocalServiceUtil;
import com.cignexdatamatics.wrm.service.RoomMasterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;

import javax.activation.MailcapCommandMap;
import javax.activation.MimetypesFileTypeMap;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 */

public final class SearchActionUtil {
	
	private SearchActionUtil()
	{
		
	}

	public static final ResourceBundle WRMRB = ResourceBundle.getBundle("wrm_portlet");
	
	public static long handleNewBookingTable(long hostId,Date sd,Date ed,String floatsthours,String floatenhours,String title,String desc ) 
	{
		long bookingId=I0;
		try
		{
		            NewBookingImpl newbooking = new  NewBookingImpl();
			 		newbooking.setHostId(hostId);
			 		newbooking.setToDate(ed);
			 		newbooking.setFromDate(sd);
			 		newbooking.setStartTime(String.valueOf(floatsthours));
			 		newbooking.setEndTime(String.valueOf(floatenhours));
			 		newbooking.setMeetingTitle(title);
			 		newbooking.setMeetingDesc(desc);
			 		NewBooking nb = NewBookingLocalServiceUtil.addNewBooking(newbooking);
			 		bookingId=nb.getPrimaryKey();
		}catch (Exception e1) { LOGGER.info(e1.getMessage());}
		return bookingId;
	}
	
	
	
	
	public static BodyPart buildHtmlTextPart(final String body)  
	{
			final MimeBodyPart descriptionPart = new MimeBodyPart();
		   try{
			final String content = "<font size=" + "\"2\"" + ">" + body + "</font>";
			descriptionPart.setContent(content, "text/html; charset=utf-8");			
		   }catch(MessagingException e){ LOGGER.info(e.getMessage());}
		   return descriptionPart;
	}
	
	public static boolean checkprioritywiseApproxResults(long roomId,long capacity,Set<String> s2,boolean capacityflag,boolean facilityflag ) 
	{
	  try{
		RoomMaster rm=RoomMasterLocalServiceUtil.findRoomByRoomId(roomId);
		long cp=rm.getCapacity();
		List<RoomFacilityMapping> rfm= RoomFacilityMappingLocalServiceUtil.findAllMappingbyRoomId(roomId);
		Iterator<RoomFacilityMapping> it4= rfm.iterator();
		Set<String> s1=new HashSet<String>();
		while(it4.hasNext())
		{
	       RoomFacilityMapping rfm2=it4.next();
	       long facilityId=rfm2.getFacilitiesId();
	       String facId=String.valueOf(facilityId);
	       s1.add(facId);
		}
		Set<String> intersect = new TreeSet<String>(s1);
        intersect.retainAll(s2);
        int l1=intersect.size();
        int l2=s2.size();
        boolean capacityflg=checkByCapacity(roomId,capacity,capacityflag);
    	if(cp>=capacity && capacityflg)
   		{
				return true;
   		}
    	  else if(facilityflag && l2!=0)
          {
         		double ratio=l1/(double)l2;
         		if( cp>=capacity && capacityflag && ratio>=P50 && facilityflag){
         			return true;
         		}
         		else if(ratio>=P50 && facilityflag){
 					return true;
         		}
          
         }
	   }catch(NoSuchRoomMasterException e){LOGGER.info(e.getMessage());}
	    catch(SystemException e){LOGGER.info(e.getMessage());}
		return false;
    }
	
	public static boolean checkApproxResults(long roomId,long capacity,Set<String> s2)
	{
	 try{
		RoomMaster rm=RoomMasterLocalServiceUtil.findRoomByRoomId(roomId);
		long cp=rm.getCapacity();
		List<RoomFacilityMapping> rfm= RoomFacilityMappingLocalServiceUtil.findAllMappingbyRoomId(roomId);
		Iterator<RoomFacilityMapping> it4= rfm.iterator();
		Set<String> s1=new HashSet<String>();
		while(it4.hasNext())
        {
		       RoomFacilityMapping rfm2=it4.next();
		       long facilityId=rfm2.getFacilitiesId();
		       String facId=String.valueOf(facilityId);
		       s1.add(facId);
        }
        Set<String> intersect = new TreeSet<String>(s1);
        intersect.retainAll(s2);
        int l1=intersect.size();
	    int l2=s2.size();
	    if(l2!=0 && l1/(double)l2>=P40 ){
	    	return true;	    	
	    }
        if(cp>capacity){
        	return true;
        }
	   }catch(NoSuchRoomMasterException e){LOGGER.info(e.getMessage());}
	    catch(SystemException e){LOGGER.info(e.getMessage());}
		return false;
	}
	
	public static boolean checkByFacility(long roomId,Set<String> s2,boolean facalitycheckflag) 
	{
	  try{
		List<RoomFacilityMapping> rfm= RoomFacilityMappingLocalServiceUtil.findAllMappingbyRoomId(roomId);
		Iterator<RoomFacilityMapping> it4= rfm.iterator();
		Set<String> s1=new HashSet<String>();
        while(it4.hasNext())
        {
		       RoomFacilityMapping rfm2=it4.next();
		       long facilityId=rfm2.getFacilitiesId();
		       String facId=String.valueOf(facilityId);
		       s1.add(facId);
        }
        Set<String> intersect = new TreeSet<String>(s1);
        intersect.retainAll(s2);      // now contains the union
        if(facalitycheckflag && intersect.equals(s2) ){
        		return true;
        }
        if(s2.isEmpty()){
        	return true;
        }
        if(!intersect.isEmpty()){
    		     return true;
        }
	  }catch(SystemException e){LOGGER.info(e.getMessage());}
        return false;
	}
	

	
	public static void sendCancelMail(String host ,String emailFromName ,String emailToAddress ,String  mailBody) 
	{ 	
	   try{	
		  InternetAddress from = new InternetAddress(host, emailFromName);
    	  InternetAddress to = new InternetAddress(emailToAddress);
		  MailMessage message = new MailMessage(from, to,WRMRB.getString("meeting-cancel") , mailBody , true);
		  MailServiceUtil.sendEmail(message);
		}catch (AddressException e) { LOGGER.info(e.getMessage());}
	     catch (UnsupportedEncodingException e) { LOGGER.info(e.getMessage());}
		
	}	
	
	public static void sendMeetingRequest( String []recipetList, Date meetingStartTime, Date meetingEndTime, String from ,String title,String body,String loc) 
    {
		try
		{
			final MimetypesFileTypeMap mimetypes = (MimetypesFileTypeMap) MimetypesFileTypeMap.getDefaultFileTypeMap();
			mimetypes.addMimeTypes("text/calendar ics ICS");
			final MailcapCommandMap mailcap = (MailcapCommandMap) MailcapCommandMap.getDefaultCommandMap();
			mailcap.addMailcap("text/calendar;; x-java-content-handler=com.sun.mail.handlers.text_plain");
			final String hostlist = WRMRB.getString("mail.host");
	    	final Properties properties = System.getProperties();
			properties.setProperty("mail.smtp.host", hostlist);
			final Session session = Session.getDefaultInstance(properties);
		    final MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setSubject(title);
		    if(recipetList.length !=0){
		    	final InternetAddress[] receiptaddress = new InternetAddress[recipetList.length-1];
		    	for (int itr = 0; itr < recipetList.length-1; itr++){
				    receiptaddress[itr] = new InternetAddress(recipetList[itr]);
		        }
		    	message.addRecipients(Message.RecipientType.TO, receiptaddress);
		    	final Multipart multipart = new MimeMultipart("alternative");
		    	final BodyPart messageBodyPart = buildHtmlTextPart(body);
		    	multipart.addBodyPart(messageBodyPart);
		    	final BodyPart calendarPart = new MimeBodyPart();
		    	final SimpleDateFormat iCalendarDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmm'00'");
		    	final long uid =System.currentTimeMillis();
		    	String wrmTimeZone = WRMRB.getString("wrm.timezone");
		    	String timeZone = Validator.isNull(wrmTimeZone) ? WRMConstants.TIMEZONE : wrmTimeZone;
		    	iCalendarDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
		    	final String calendarContent = "BEGIN:VCALENDAR\n"
     									+ "METHOD:REQUEST\n"
										+ "PRODID: BCP - Meeting\n"
										+ "VERSION:2.0\n"
										+ "BEGIN:VEVENT\n"
										+ "DTSTAMP:"+ iCalendarDateFormat.format(meetingEndTime) + "\n"
										+ "DTSTART:" + iCalendarDateFormat.format(meetingStartTime) + "\n"
										+ "DTEND:"+ iCalendarDateFormat.format(meetingEndTime) + "\n"
										+ "SUMMARY:test request\n"
										+ "UID:" + uid + "\n"
										+ "ATTENDEE;ROLE=REQ-PARTICIPANT;PARTSTAT=NEEDS-ACTION;RSVP=TRUE:MAILTO:" + Arrays.toString(recipetList) + "\n"
										+ "ORGANIZER:MAILTO:" + from+ "\n"
										+ "LOCATION:" +loc + "\n"
										+ "DESCRIPTION:" + body+ "\n"
										+ "SEQUENCE:0\n" + "PRIORITY:5\n" + "CLASS:PUBLIC\n" + "STATUS:CONFIRMED\n" + "TRANSP:OPAQUE\n" + "BEGIN:VALARM\n"
										+ "ACTION:DISPLAY\n" + "DESCRIPTION:REMINDER\n" + "TRIGGER;RELATED=START:-PT00H15M00S\n" + "END:VALARM\n" + "END:VEVENT\n" + "END:VCALENDAR";
		    	calendarPart.addHeader("Content-Class", "urn:content-classes:calendarmessage");
		    	calendarPart.setContent(calendarContent, "text/calendar;method=CANCEL");
		    	multipart.addBodyPart(calendarPart);
		    	message.setContent(multipart);
		    	Transport.send(message);
		  }
     }
     catch(final MessagingException e){LOGGER.info(e.getMessage()); }

    }	
	
	 public static String setTimeFormat(String temp)
	 { 
		     StringBuffer buff = new StringBuffer();
		     String ampm=StringPool.BLANK;
		     double timeDiff=I0;
		     double dtime =  Double.valueOf(temp.trim()).doubleValue();
		  	 if(dtime >I12){
				 timeDiff = (dtime - I12) ;	
				 ampm=WRMConstants.PM;				 
			 }
			 else if(dtime < I12){
				 timeDiff = dtime ;
				 ampm=WRMConstants.AM;				 
			 }
			 else if(Math.abs(dtime-I12) < DZERO){
				 timeDiff =  dtime ;
				 ampm=WRMConstants.PM;				
			 }		
		  	 int hr=(int)timeDiff;
			 double temptime = timeDiff -hr ;
			 buff.append(Integer.toString(hr));
			 if(Math.abs(temptime)< DZERO){				
				 buff.append(":00 ");buff.append(ampm);					
			 }
			 else if(Math.abs(temptime-P25)<DZERO){				
				 buff.append(":15 ");buff.append(ampm);				
			 }
			 else if(Math.abs(temptime-P50)<DZERO){			
				 buff.append(":30 ");buff.append(ampm);				
			 }
			 else if(Math.abs(temptime-P75)<DZERO){			
				 buff.append(":45 ");buff.append(ampm);				
			 }		
			 return buff.toString();
	    }
	 
	public static boolean compareHours(float floatsthours,float floatsthoursDB,float floatenhours,float floatenhoursDB)
	{	
		boolean timeflag=true;
		if(Math.abs(floatsthours-floatsthoursDB) < DZERO ){
			timeflag=false;
		}
		else if( (floatsthours < floatenhoursDB) && (floatsthours > floatsthoursDB)){
			timeflag=false;
		}
		else if((floatsthoursDB < floatenhours) && (floatsthoursDB > floatsthours)){
			timeflag=false;
    	}
		return timeflag;
	}
	
	 public static float getHour(int min,float floathour,String ampm)
	 {		
		float floathours=floathour;
		switch(min){
		   case I15:   	floathours+=P25;	break;
		   case I30:   	floathours+=P50;	break;
		   case I45:   	floathours+=P75;	break;	
		   default:     floathours=floathour ;      
		 }
		 if(WRMConstants.PM.equalsIgnoreCase(ampm)) { floathours+=I12; }
		 return floathours;
	 }
	 
	public static List<Long> filterByFloorLocCity(long cityId, long locationId,long floorId) {
		  List<Long> al=new ArrayList<Long>();
	    try{
		  List<RoomMaster> allRoom=RoomMasterLocalServiceUtil.findAllRoom();
	      List<RoomMaster> roomResultsByCity = RoomMasterLocalServiceUtil.findAllRoomInCity(cityId);
	      List<RoomMaster> roomResultsByLocandCity = RoomMasterLocalServiceUtil.findAllRoomByLocandCity(cityId,locationId);
	      List<RoomMaster> roomResultsByLocationCityFloor = RoomMasterLocalServiceUtil.findAllRoomByLocationCityFloor(cityId,locationId,floorId);
		
		  Iterator <RoomMaster>it =null;

		  if (cityId<=0)
		  {
			   it =allRoom.iterator();
		  }
		  else if (locationId<=0)
		  {
			   it =roomResultsByCity.iterator();
		  }
		  else if (floorId<=0)
		  {
			   it = roomResultsByLocandCity.iterator();
		  }
		  else
		  {
			  it =roomResultsByLocationCityFloor.iterator();
		  }
		  while (it.hasNext())
		  {
			   RoomMaster roommaster=it.next();
			   al.add(roommaster.getRoomId());
		  }
	    }catch(SystemException e){ LOGGER.info(e.getMessage());}
		return al;
	}
	 
	public static List<Long> filterByLocAndCity(long cityId, long locationId,	long floorId) {
		List<Long> filterbycityloc=new ArrayList<Long>();
		try{
		  List<RoomMaster> roomResultsByLocandCity = RoomMasterLocalServiceUtil.findAllRoomByLocandCity(cityId,locationId);
    	  List<RoomMaster> roomResultsByLocandCityfloor = RoomMasterLocalServiceUtil.findAllRoomByLocationCityFloor(cityId, locationId, floorId);
    	  Iterator <RoomMaster>it=null;
    	  if(floorId<=0)
    	  {
    		  it =roomResultsByLocandCity.iterator();
    	  }
    	  else
    	  {
    		  it =roomResultsByLocandCityfloor.iterator();
    	  }
		  while (it.hasNext())
		  {
			   RoomMaster roommaster=it.next();
			   filterbycityloc.add(roommaster.getRoomId());
		  }
		}catch(SystemException e){LOGGER.info(e.getMessage());}
		return filterbycityloc;
	}
	
	public static String sort(String finalresult)
	{
		 String delemiter=StringPool.AT;
		// String displayresult=StringPool.AT;
		 StringBuffer buffDisplayresult = new StringBuffer();
		 String[] finaldisplay=finalresult.split(delemiter);
		 buffDisplayresult.append(StringPool.AT);
	     for(int d=1;d<finaldisplay.length;d++)
	     {
	    	 int point=0;
	    	 String roomidarray[]=new String[LIMIT];
	   		 Float weightarray[]=new Float[LIMIT];
	         String[] finaldisplay1=finaldisplay[d].split(StringPool.COMMA);

	        // displayresult=displayresult+finaldisplay1[0]+StringPool.COMMA;
	         buffDisplayresult.append(finaldisplay1[0]);
	         buffDisplayresult.append(StringPool.COMMA);
	         for(int e=1;e<finaldisplay1.length;e++)
	    	 {

	    		 String[]finaldisplay2=finaldisplay1[e].split(StringPool.COLON);
	    		 if(finaldisplay2.length!=0)
	    		 {
	    			String tmp=finaldisplay2[0];
	        		roomidarray[point]=tmp;
	        		weightarray[point]=Float.valueOf(finaldisplay2[1]);
	        		point++;
	        		if(point>1)
	        		{

	        		   for(int g=0;g<point;g++)
	        	          {
	        	    	     for(int h=g+1;h<point;h++)
	        	    	       {
	        	    		      if(weightarray[g]<weightarray[h])
	        	    	    	   {
	        	    		         float tempp=weightarray[g];
	        	    			     weightarray[g]=weightarray[h];
	        	    			     weightarray[h]=tempp;

	        	    		    	 String xyz=roomidarray[g];
	        	    			     roomidarray[g]=roomidarray[h];
	        	    		 	     roomidarray[h]=xyz;
	        	    		     }
	        	    	      }
	        	           }
	        	     }
	    		}
	    	 }

	         if(roomidarray!=null)
		     {
	        	 for(int n=0;n<point;n++)
		 		 {
	        		 buffDisplayresult.append(roomidarray[n]);
	        		 buffDisplayresult.append(StringPool.COMMA);
		 		 	 //displayresult=displayresult+roomidarray[n]+StringPool.COMMA;
		 		 }
		     }
	         buffDisplayresult.append(StringPool.AT);
		   //  displayresult=displayresult+StringPool.AT;

	  }
		return buffDisplayresult.toString();
	}
	
	public static double findfacalityweight(long roomId,Set<String> s2)
	{
		try
		{
			List<RoomFacilityMapping> rfm= RoomFacilityMappingLocalServiceUtil.findAllMappingbyRoomId(roomId);
			Iterator<RoomFacilityMapping> it4= rfm.iterator();
			Set<String> s1=new HashSet<String>();
			while(it4.hasNext())
			{
		       RoomFacilityMapping rfm2=it4.next();
		       long facilityId=rfm2.getFacilitiesId();
		       String facId=String.valueOf(facilityId);
		       s1.add(facId);
			}
			Set<String> intersect = new TreeSet<String>(s1);
			intersect.retainAll(s2);
			int intersectsize=intersect.size();
			int userfacalitysize=s2.size();
			return (double)intersectsize/userfacalitysize;
			
		}
		catch(Exception e)
		{			
			return P60;
		}

	}
	
	public static boolean checkByFixResults(long roomId,long capacity,Set<String> s2) 
	{
	   try{
		RoomMaster rm=RoomMasterLocalServiceUtil.findRoomByRoomId(roomId);
		long cp=rm.getCapacity();

		List<RoomFacilityMapping> rfm= RoomFacilityMappingLocalServiceUtil.findAllMappingbyRoomId(roomId);
		Iterator<RoomFacilityMapping> it4= rfm.iterator();
		Set<String> s1=new HashSet<String>();
        while(it4.hasNext())
        {
		       RoomFacilityMapping rfm2=it4.next();
		       long facilityId=rfm2.getFacilitiesId();
		       String facId=String.valueOf(facilityId);
		       s1.add(facId);
        }
        Set<String> intersect = new TreeSet<String>(s1);
        intersect.retainAll(s2);
        if(intersect.equals(s2) && (cp==capacity))
        {
		     return true;
        }
	   }catch(NoSuchRoomMasterException e){LOGGER.info(e.getMessage());}
	    catch(SystemException e){LOGGER.info(e.getMessage());}
		return false;
	}
	
	public static boolean checkbestApproxResults(long roomId,long capacity,Set<String> s2,boolean capacityflag,boolean facilityflag )
	{
	   try{
		RoomMaster rm=RoomMasterLocalServiceUtil.findRoomByRoomId(roomId);
		long cp=rm.getCapacity();

		List<RoomFacilityMapping> rfm= RoomFacilityMappingLocalServiceUtil.findAllMappingbyRoomId(roomId);
		Iterator<RoomFacilityMapping> it4= rfm.iterator();
		Set<String> s1=new HashSet<String>();
		while(it4.hasNext())
		{
	       RoomFacilityMapping rfm2=it4.next();
	       long facilityId=rfm2.getFacilitiesId();
	       String facId=String.valueOf(facilityId);
	       s1.add(facId);
		}
		Set<String> intersect = new TreeSet<String>(s1);
        intersect.retainAll(s2);
        boolean capacityflg=checkByCapacity(roomId,capacity,capacityflag);
    	if(intersect.equals(s2) && facilityflag &&  (cp==capacity) && capacityflg){
				return true;
   		}
    	else if(intersect.equals(s2) && facilityflag && capacityflg){
				return true;
   		}
    	else if( (cp==capacity) && capacityflag){
				return true;
   		}
	   }catch(NoSuchRoomMasterException e){LOGGER.info(e.getMessage());}
	    catch(SystemException e){LOGGER.info(e.getMessage());}
		return false;
    }
	
	public static boolean checkByCapacity(long roomId,long capacity , boolean capacitycheckflag) 
	{
	  try{
		RoomMaster rm=RoomMasterLocalServiceUtil.findRoomByRoomId(roomId);
		long cp=rm.getCapacity();
		int c=(int) capacity;
		int var=(int) (c*P30);
		
		if(capacitycheckflag && cp>=capacity ){			
				return true;			
		}
		if(capacitycheckflag && cp<capacity){
			 return false;
		}
		if(c==0){
			return true;
		}
		if(capacity<=I10 && cp<=I10){
			return true;
		}
		if(capacity>=I8 && capacity<=I16  && cp>=I8 && cp<=I16){
				return true;
		}
		
		/*for(int i=(c-var);i<=(c+var);i++)
		{
			if(i==cp){
					return true;
			}
		}*/
		if(checkByCapacity(c, var, cp))
		{
			return true; 
		}
	   }catch(NoSuchRoomMasterException e){LOGGER.info(e.getMessage());}
	    catch(SystemException e){LOGGER.info(e.getMessage());}
		return false;
	}
	
	public static boolean checkByCapacity(int c,int var,long cp) 
	{
		for(int i=(c-var);i<=(c+var);i++)
		{
			if(i==cp){
					return true;
			}
		}
		return false;
		
	}
	
	 private static final double P30=0.30;
	 private static final double P40=0.40;
	 private static final double P60=0.60;
	 private static final double P25=0.25;
	 private static final double P50=0.50;
	 private static final double P75=0.75;
	 private static final int I0=0;
	 private static final int I8=8;
	 private static final int I12=12;
	 private static final int I10=10;
	 private static final int I15=15;
	 private static final int I16=16;
	 private static final int I30=30;
	 private static final int I45=45;
	 private static final int LIMIT=100000;
	 private static final double DZERO=0.0000001;
	 private static final Log LOGGER = LogFactoryUtil.getLog(SearchActionUtil.class);
}
