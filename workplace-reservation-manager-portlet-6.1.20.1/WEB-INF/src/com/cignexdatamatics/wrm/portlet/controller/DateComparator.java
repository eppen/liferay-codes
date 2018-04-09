/**
 * <a href="DateComparator.java.html">View Source</a>
 *
 * @Project WRM
 * @Author Manali Lalaji
 * @Description This is the controller class DateComparator for WRM-portlet  
 * @ChangeLog:
 * Name | Date | Reason
 * --------------------------------------------------------------------------------------------------------------------------
 *  
 */
package com.cignexdatamatics.wrm.portlet.controller;
import com.cignexdatamatics.wrm.model.impl.BookingRoomsImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 */

public class DateComparator extends OrderByComparator {  
	 /**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
     private boolean asc;  
	 public DateComparator(){  
	   this(false);  
	  }  
	  public DateComparator(boolean ascOrder) {  
	    asc = ascOrder;  
	  }  
		  
	  public int compare(Object obj1, Object obj2) 
	  {
		  int value=0;
		  BookingRoomsImpl book1 = (BookingRoomsImpl) obj1;
		  BookingRoomsImpl book2 = (BookingRoomsImpl) obj2;
		  if(Validator.isNotNull(book1) && Validator.isNotNull(book2)){
			  value = book1.getBookingDate().compareTo(book2.getBookingDate());
		  }
		  if (asc) {
			  return value;
		  } else {
			  return -value;
		  }
	  }
	  
	 public String getOrderBy() {  
	  if (asc) {  
		  return "status ASC";  
	  }   
	  else {  
		  return "status DESC";  
	  	}  
	  }  
	 	
	}  

