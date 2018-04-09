<%-- 

Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
This library is free software; you can redistribute it and/or modify it under the terms of the 
GNU Lesser General Public License as published by the Free Software Foundation; either 
version 2.1 of the License, or (at your option) any later version.
This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE. See the GNU Lesser General Public License for more details. 

--%>

<%@ include file="../init.jsp" %>

<%
    List<User> UserList=null;		
   	try
   	{    		        
    	ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();
    	DynamicQuery dynamicQuery =null;
    	
    	String serachPattern = request.getParameter("q");
    	serachPattern = serachPattern.replace('*', '%');
 			
		dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class, classLoader)
		.add(PropertyFactoryUtil.forName("emailAddress").like(serachPattern+"%" ))
      	.addOrder(OrderFactoryUtil.asc("firstName"));    
		UserList  = (List)UserLocalServiceUtil.dynamicQuery(dynamicQuery);
	
        
    	String emailid=null;
        for (int i = 0; i < UserList.size(); i++ ) 
        {   
             emailid=UserList.get(i).getEmailAddress();
             out.println(emailid);
        }
    }
    catch(Exception e)
    { }
%>
