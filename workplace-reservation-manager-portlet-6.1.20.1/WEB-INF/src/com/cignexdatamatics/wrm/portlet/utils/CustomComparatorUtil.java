/**
 * <a href="CustomComparatorUtil.java.html">View Source</a>
 *
 * @Project WRM
 * @Author Manali Lalaji
 * @Description This is the util class CustomComparatorUtil for WRM-portlet  
 * @ChangeLog:
 * Name | Date | Reason
 * --------------------------------------------------------------------------------------------------------------------------
 *  
 */
package com.cignexdatamatics.wrm.portlet.utils;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.cignexdatamatics.wrm.portlet.controller.DateComparator;
import com.cignexdatamatics.wrm.portlet.controller.RoomNameComparator;

/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 */

public final class CustomComparatorUtil { 
	  private CustomComparatorUtil(){}
      public static OrderByComparator getUserOrderByComparator(String orderByCol, String orderByType) {
       boolean orderByAsc = false;  
       if (orderByType.equals("asc")){  
    	   orderByAsc = true;  
       }  
       OrderByComparator orderByComparator = null;  
       if (orderByCol.equalsIgnoreCase("Room Name")) {  
    	  orderByComparator = new RoomNameComparator(orderByAsc); 
       }   
       else if (orderByCol.equalsIgnoreCase("Date")) {  
        orderByComparator = new DateComparator(orderByAsc);
       }  
       return orderByComparator;  
       }  
    }  