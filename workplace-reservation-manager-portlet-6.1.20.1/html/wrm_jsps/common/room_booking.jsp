<%-- 

Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
This library is free software; you can redistribute it and/or modify it under the terms of the 
GNU Lesser General Public License as published by the Free Software Foundation; either 
version 2.1 of the License, or (at your option) any later version.
This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE. See the GNU Lesser General Public License for more details. 

--%>

<%@include file="/html/wrm_jsps/init.jsp" %>
<liferay-ui:success key="booking-successful" message="booking-successful" />
<liferay-ui:success key="search-complete" message="search-complete" />
<liferay-ui:success key="mail-sent-to-attendees" message="mail-sent-to-attendees" />
<liferay-ui:error key="room-not-selected" message="room-not-selected"/>
<liferay-ui:error key="room-book-meanwhile" message="Sorry, Room just got booked!"/>
<jsp:useBean id="bookingURL" class="java.lang.String" scope="request" />
<%
	BestOptionResult br=new BestOptionResult();
 String ctxPath = request.getContextPath();
	if (ctxPath != null && ctxPath.length() == 1)
	{
		ctxPath = "";
	}
%>
<script type="text/javascript">
function submitFrm(url)
{
	
		document.forms['myform'].action=url; 
		document.forms['myform'].method="POST";
		document.forms['myform'].submit();	
		return true;
}
function ajaxCall(serverURL,id)
{
	jQuery.ajax({
		url: serverURL,
		async: false,
		success: function(data)
		{
			jQuery('#' +id).html(data);
		}
     });
}
function findLocation()
{
	var cityId=document.getElementById("cityId").selectedIndex;
	var city= document.getElementById("cityId").options[cityId].value;
	var sURL = "<%=ctxPath%>/html/ajaxAction/findLocationActions.jsp?CityID="+city;
	ajaxCall(sURL, "locationId");
}
function findFloor()
{
	var locationId=document.getElementById("locationId").selectedIndex;
	var location= document.getElementById("locationId").options[locationId].value;
	var sURL = "<%=ctxPath%>/html/ajaxAction/findFloorActions.jsp?locationID="+location;
	ajaxCall(sURL, "floorId");
}
function findRoom()
{
	var locationId=document.getElementById("locationId").selectedIndex;
	var location= document.getElementById("locationId").options[locationId].value;
	var sURL = "<%=ctxPath%>/html/ajaxAction/findRoomActions.jsp?locationID="+location;
	ajaxCall(sURL, "roomId");
}
function imageLoad()
{
	var imageId=document.getElementById('roomId').value;
	var sURL="<%=ctxPath%>/html/ajaxAction/imageload.jsp?imageId="+imageId;
    ajaxCall(sURL,"imgId");	
	
}
function validate()
{  
	if(validate1()==false)
	{	
		return false;
	}
	else if(validate2()==false)
	{	
		return false;
	}
	else if(validate3()==false)
	{
		
		return false;
	}
	else if(validate4()==false)
	{
	
		return false;
	}
	else if(validate5()==false)
	{
		
		return false;
	}
	else if(validate6()==false)
	{
	
		return false;
	}
	else if(validate7()==false)
	{	
		return false;
	}
	return true;
	
}
function validate1()
{ 
	 var cityId=document.getElementById("cityId").selectedIndex;
	 if(cityId<1)
     {
   	    str="Please Select City.";    
      	document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("cityId").focus();
  		return false; 
     }
	 else
	 {
		 var str="";
	     document.getElementById('message').innerHTML =str.fontcolor("red");
	 }
	 return true;
}
function validate2()
{ 
	if(validate1()==true)
	{
	   var locationId=document.getElementById("locationId").selectedIndex;
	   if(locationId<1)
       {
 	   	str="Please Select Location.";    
       	document.getElementById('message').innerHTML =str.fontcolor("red");
        document.getElementById("locationId").focus();
   		return false; 
       }
 	   else
	   {
		 var str="";
	     document.getElementById('message').innerHTML =str.fontcolor("red");
	   }  
	}
	return true; 
}

function validate3()
{ 
	 var sdate= document.getElementById("datepicker").value;
	 var sd=new Date(sdate);
	 var edate= document.getElementById("datepicker1").value;
	 var ed=new Date(edate);
	 var nDate = new Date(sdate);
     nDate.setDate(nDate.getDate() + 14);
     var dd1=nDate.getDate();
     var mm1=nDate.getMonth()+1;
     var yyyy1=nDate.getFullYear();
     if(dd1<10){dd1='0'+dd1;}
	 if(mm1<10){mm1='0'+mm1;}
     var ndate=mm1+"/"+dd1+"/"+yyyy1;
     var nd=new Date(ndate);
     if(sd>ed)
	 {
		    var str2="Please enter end date greater than start date.";
		 	document.getElementById('message').innerHTML =str2.fontcolor("red");
		    return false;
	 }
     else
	 {
		 var str="";
	     document.getElementById('message').innerHTML =str.fontcolor("red");
	 }
     
     return true;
}

function validate4()
{
	    var today = new Date();
	    var dd = today.getDate();
	    var mm = today.getMonth()+1;   //January is 0!
	    var yyyy = today.getFullYear();
	    if(dd<10){dd='0'+dd;}
	    if(mm<10){mm='0'+mm;}
	    var currentdate=mm+"/"+dd+"/"+yyyy;
	    var cd=new Date(currentdate);
	    var sdate= document.getElementById("datepicker").value;
	    var sd=new Date(sdate);
	    var edate= document.getElementById("datepicker1").value;
	    var ed=new Date(edate);
	    var d = new Date();
        var curHour = d.getHours();
        var curMin = d.getMinutes();       
        var Curampm;
        if(curHour>11)
        {
            curHour=curHour-12;
            Curampm="PM";
        }
        else
        {
            Curampm="AM";           
        }     
       
         var startTimeValue = document.getElementById("startTime").selectedIndex;
         var endTimeValue = document.getElementById("endTime").selectedIndex;
         var startMin = document.getElementById("startMin").selectedIndex;
         var endMin = document.getElementById("endMin").selectedIndex;
         var startampm = document.getElementById("startampm").selectedIndex;
         var endampm = document.getElementById("endampm").selectedIndex;
         var startampm1 = document.getElementById("startampm").value;
         var endampm1 = document.getElementById("endampm").value;
         var startTimeValue1 =startTimeValue+1;
         var startMin1 = document.getElementById("startMin").value;
   
         if(sd>cd)
		 {
        	     var str="";
                 document.getElementById('message').innerHTML =str.fontcolor("red");
		 }
         else
         {
    		
           if(startampm1==Curampm)
           {
                   if( startTimeValue1==curHour)
                    {
                         if(curMin>=startMin1)
                         {                     
                     	   str="Please select start time greater than current time.";
                      	   document.getElementById('message').innerHTML =str.fontcolor("red");
                           document.getElementById("endTime").focus();
                          return false;
                        }
                        else
                        {
                             var str="";
                             document.getElementById('message').innerHTML =str.fontcolor("red");
                        }
                    }
                    else
                    {
                        var str="";
                        document.getElementById('message').innerHTML =str.fontcolor("red");
                    }       
            
         }
         else
         {
             var str="";
             document.getElementById('message').innerHTML =str.fontcolor("red");
         }
         if( startampm1==Curampm)             
         {
             
             if(curHour!=12)
             {
                  if( curHour>startTimeValue1)
                 {
                    str="Please select start time greater than current time.";
                    document.getElementById('message').innerHTML =str.fontcolor("red");
                    document.getElementById("endTime").focus();
                     return false;                     
                  }
                   else
                 {
                     var str="";
                     document.getElementById('message').innerHTML =str.fontcolor("red");
                 }
             }
             else
             {
                 var str="";
                 document.getElementById('message').innerHTML =str.fontcolor("red");
             }
         }
         else
         {
             var str="";
             document.getElementById('message').innerHTML =str.fontcolor("red");
         }   
         if(Curampm=="PM" && startampm1=="AM")
         {
            
                    str="Please select start time greater than current time.";
                    document.getElementById('message').innerHTML =str.fontcolor("red");
                    document.getElementById("endTime").focus();
                     return false;        
         }   
         else
         {
             var str="";
             document.getElementById('message').innerHTML =str.fontcolor("red");
         }       
	  }
       if(startampm1==endampm1)
       {
       
              if( startTimeValue==endTimeValue)
                {
                  if( startMin>=endMin)
                  {
                    str="Please select end time greater than start time.";
                    document.getElementById('message').innerHTML =str.fontcolor("red");
                    document.getElementById("endTime").focus();
                     return false;
                   }
                 else
                 {
                         var str="";
                         document.getElementById('message').innerHTML =str.fontcolor("red");
                 }
                }
              else
             {
                 var str="";
                 document.getElementById('message').innerHTML =str.fontcolor("red");
             }       
        
     }
     else
     {
         var str="";
         document.getElementById('message').innerHTML =str.fontcolor("red");
     }
     if( startampm1==endampm1)
     {
         if(startTimeValue!=11)
         {
              if( startTimeValue >endTimeValue)
             {
                str="Please select end time greater than start time.";
                document.getElementById('message').innerHTML =str.fontcolor("red");
                document.getElementById("endTime").focus();
                 return false;                     
              }
               else
             {
                 var str="";
                 document.getElementById('message').innerHTML =str.fontcolor("red");
             }
         }
         else
         {
             var str="";
             document.getElementById('message').innerHTML =str.fontcolor("red");
         }
     }
     else
     {
         var str="";
         document.getElementById('message').innerHTML =str.fontcolor("red");
     }   
     if( startampm1=="PM" && endampm1=="AM")
     {
        
                str="Please select end time greater than start time.";
                document.getElementById('message').innerHTML =str.fontcolor("red");
                document.getElementById("endTime").focus();
                 return false;        
     }   
     else
     {
         var str="";
         document.getElementById('message').innerHTML =str.fontcolor("red");
     }
     return true;
}
function validate5()
{ 	
	 var fac=document.getElementById("Fac").value;	
	 if(fac=="" && document.myform.box2.checked==true)
	 {
   		 var str3="Facility should be selected if you are selecting Facility for Priority Search";
		 document.getElementById('message').innerHTML =str3.fontcolor("red");
		 document.getElementById("Fac").focus();
		 return false;
	 }
	 else
	 {
		 var str="";
	     document.getElementById('message').innerHTML =str.fontcolor("red");
	 } 
	 return true;
}
function validate6()
{
	 var cap=document.getElementById("Cap").value;
	 if(cap=="" && document.myform.box3.checked==true )
	 {
		
        var str3="Capacity should be entered if you are selecting Capacity as Priority for Search";
    	document.getElementById('message').innerHTML =str3.fontcolor("red");
	    document.getElementById("Cap").focus();
        return false;
	 }	
	 else
	 {
		 var str="";
	     document.getElementById('message').innerHTML =str.fontcolor("red");
	 }
	 if(cap=="")
	 {
		  return true;
	 } 
	 else if(isDigit(cap)==false)
        {
			 str="Please enter capacity as digit!";
			 document.getElementById('message').innerHTML =str.fontcolor("red");
		 	 document.getElementById("Cap").focus();
	 	     return false; 
	 }
	 else
	 {
			 var str="";
		     document.getElementById('message').innerHTML =str.fontcolor("red");
	 }
	 if(cap<1 && document.myform.box3.checked==true )
	 {
        var str3="Capacity should be entered if you are selecting Capacity as Priority for Search";
    	document.getElementById('message').innerHTML =str3.fontcolor("red");
	    document.getElementById("Cap").focus();
        return false;
	 }	 
	 else
	 {
		 var str="";
	     document.getElementById('message').innerHTML =str.fontcolor("red");
	 }
	 return true;
}
function validate7()
{
  if(jQuery("#chk1").attr('checked')) 
  {
	if(validate1()==false)
	{	
		return false;
	}
	else if(validate2()==false)
	{	
		return false;
	}
	else
	{
			 var roomId=document.getElementById("roomId").selectedIndex;
			 if(roomId<1)
		     {
		   	    str="Please Select Room.";    
		      	document.getElementById('message').innerHTML =str.fontcolor("red");
		        document.getElementById("roomId").focus();
		  		return false; 
		     }
			 else
			 {
				 var str="";
			     document.getElementById('message').innerHTML =str.fontcolor("red");
			 }		
	}
  }
    return true;
}

function transfer()
{
	if(jQuery("#chk1").attr('checked')) 
	{
	    jQuery("#p3").show();	
		jQuery("#p2").hide();
	}
	else {
      	jQuery("#p2").show();
        jQuery("#p3").hide();
	}
}

function ClearOptions(id)
{
	document.getElementById(id).selectedIndex=-1;
}
function ClearRadioOptions(id)
{
	if(document.forms['myform'].id.checked==true)
	{
		document.forms['myform'].id.checked=false; 
    }
    else
    {
    	document.forms['myform'].id.checked=false;
    }
}	
function isDigit(argvalue)
{
      argvalue = argvalue.toString();
      var validChars = "1234567890";
      for (var n = 0; n < argvalue.length; n++)
      {
 		   if(validChars.indexOf(argvalue.substring(n, n+1)) == -1)
           return false;
      }
      return true;
}
<%--Code Modified for datepicker to run in IE7 --%>
jQuery(function()
	{
			 var maxDate=new Date(jQuery('#datepicker').val());
             maxDate.setDate(maxDate.getDate()+19);	
		
			 jQuery( "#datepicker" ).datepicker({
			defaultDate: "+1w",
			changeMonth: true,
			numberOfMonths: 1,
			minDate: 0,
            maxDate: '+19d'
			});
			
			 jQuery( "#datepicker1" ).datepicker({
			defaultDate: "+1w",
			changeMonth: true,
			numberOfMonths: 1,
			minDate: new Date(jQuery('#datepicker').val()),
			maxDate: maxDate
			});

			 jQuery('#datepicker').change(function () {
			var maxDate=new Date(jQuery('#datepicker').val());
	        maxDate.setDate(maxDate.getDate()+19);	
				
			jQuery( "#datepicker1" ).datepicker( "destroy" );
			jQuery( "#datepicker1" ).val(jQuery('#datepicker').val());
			jQuery( "#datepicker1" ).datepicker({
			defaultDate: "+1w",
			changeMonth: true,
			numberOfMonths: 1,
			minDate: new Date(jQuery('#datepicker').val()),
			maxDate: maxDate
			});	
			});
	});
	

</script>
<div class="message " id="message"></div>
<form name="myform" action="<%=bookingURL%>" method="POST" onSubmit="return validate();">
<%
	String flag=(String)request.getAttribute("jspflag4");
	if(flag!=null)
	{
	   br=(BestOptionResult)request.getAttribute("tempsearchingResult");
	}
%>
<liferay-ui:panel-container extended="<%=true%>" id="workflowTasksPanelContainer" persistState="<%=false%>">


<div id="basic">
<div class="advancesearch advancesearch-short">
	<span class="selecttype w215">
		<span class="lab"><liferay-ui:message key="CITY" /><sup class="astric-red">*</sup>
		<select name="cityId" id="cityId" onchange="findLocation();return validate1();" class="ddl">
          <option value='0'>Select City</option>
           <% List<CityMaster> allCity = (List<CityMaster>)request.getAttribute("allCity");
		      Iterator it= allCity.iterator();
		      ResourceBundle _wrmRB = ResourceBundle.getBundle("content.Language");  //fetching cityname from wrm.properties
		      long DefaultCityId=0;
              while(it.hasNext())
              {
                   CityMaster city=(CityMaster)it.next();
                   String cityName = _wrmRB.getString("cityname");
                   // Defaulting field values of cityname as selected in combobox
                   
                   if(br.getCityId()==city.getCityId() || city.getCityName().equalsIgnoreCase(cityName))
                   { 
                	   DefaultCityId=city.getCityId();  
                   %>                       	 
                       <option value="<%=city.getCityId()%>" selected="selected"> <%=city.getCityName()%> </option>
                  <%}
                   else
                   {%>
                     <option value="<%=city.getCityId()%>" ><%=city.getCityName() %></option>
                 <%} 
              }%>
         </select>
		</span>
	</span>
	<span class="selecttype w215">
		<span class="lab"><liferay-ui:message key="START_DATE" /><sup class="astric-red">*</sup>
	 <input type="text" class="calendericon" style="width:100px; background:url('<%=ctxPath%>/images/calendar-icon.gif') 80px center no-repeat; " name="StartDate" id="datepicker" value="<%=br.getSdate() %>" size="12" onchange="return validate3();"  readonly="readonly"/>
	</span></span>
	
	<span class="selecttype w215">
		<span class="lab"><liferay-ui:message  key="START_TIME" /><sup class="astric-red">*</sup>
		<span class="time-table-wrapper">
		<table width="80px">
    <tr>
    <td>
        <select name="sthours" id="startTime" onchange="return validate4();">
                                                	<% String hr2 = new String();
								for(int i = 1; i <= 12; i++) 
								{
										String hr = String.valueOf(i);
									    String hr1 = br.getSthours();
									    if(hr.equalsIgnoreCase("12") )
										{
													 hr2 = "0";
										}
										else
										{
													hr2=hr;
										}
										if (hr1.equals(hr2)) 
									    {%>
									    
												<option value="<%=hr2%>" selected="selected"><%=hr %></option>
									  <%}
								         else{%>
												<option value="<%=hr2 %>" ><%=hr %></option>
                                                                            <%}                                        
                                                               }%>												
						
							
						</select>
     </td>
     <td>
	     <select NAME="stminutes" id="startMin" onchange="return validate4();">
	                       <%
					String min =br.getStminutes();
	     			
	     			if(min.equals("00"))
	     			{
	     		%>		
	     				<option value="<%=br.getStminutes() %>" selected="selected"><%=br.getStminutes() %></option>
	     				<option value="15">15</option>
	                    <option value="30">30</option>
	                     <option value="45">45</option>
	     		<%
	     			}
	     			else if(min.equals("15"))
	     			{
	     		%>		
	     				
	     				<option value="00">00</option>
	                    <option value="<%=br.getStminutes() %>" selected="selected"><%=br.getStminutes() %></option>
	                    <option value="30">30</option>
	                     <option value="45">45</option>
	     		<%
	     			}
	     			else if(min.equals("30"))
	     			{
	     		%>		
	     				
	     				<option value="00">00</option>
	                    <option value="15">15</option>
	                    <option value="<%=br.getStminutes() %>" selected="selected"><%=br.getStminutes() %></option>
	                     <option value="45">45</option>
	     		<%
	     			}
	     			else
	     			{
	     		%>
	     				
	     				<option value="00">00</option>
	                	<option value="15">15</option>
	                    <option value="30">30</option>
	                	<option value="<%=br.getStminutes() %>" selected="selected"><%=br.getStminutes() %></option>        
	     		<%	
	     			}
	            %>          
	     </select>
	 </td>
	 
	 <td>
		 <select name="stampm" id="startampm" onchange="return validate4();">
		           <%String ampm =br.getStampm();	     			
	     			if(ampm.equals("AM"))
	     			{%>
	     			         <option value="<%=br.getStampm() %>" selected="selected"><%=br.getStampm() %></option>
		                     <option value="PM">PM</option>
                  <%}
	     			else
	     			{%> 
	      				     <option value="<%=br.getStampm() %>" selected="selected"><%=br.getStampm() %></option>
		                     <option value="AM">AM</option>       
	              <%}%>        
	                        
		 </select>
     </td>
 </tr>
</table>
</span>
</span></span>
	
	
	
	
	<br class="clear-both" />
	<span class="selecttype w215">
		<span class="lab"><liferay-ui:message key="LOCATION" /><sup class="astric-red">*</sup>
		 <select name="locationId" id="locationId"  onchange="findRoom();findFloor();return validate2();" onclick="return validate1();" class="ddl">
       <option value="0">Select Location</option>
       <%
       long cid=br.getCityId();
       List<LocationMaster> selLocation=null;
       if(Validator.isNotNull(DefaultCityId) && DefaultCityId!=0){
    	  selLocation = LocationMasterLocalServiceUtil.findAllInCity(DefaultCityId);
       }else{
    	  selLocation = LocationMasterLocalServiceUtil.findAllInCity(cid);
       }
         
            int count=0;
            Iterator<LocationMaster> it1= selLocation.iterator();
            while(it1.hasNext())
            {
            	      count++;
                      LocationMaster location=(LocationMaster)it1.next();
                      
                   // Defaulting field values of location as selected in combobox
                   
                     if(br.getLocationId()==location.getLocationId() || count==1)
                     {%>                       	 
                        <option value="<%=location.getLocationId()%>" selected="selected"> <%=location.getLocationName()%> </option>
                    <%}
                     else
                     {%> 
                         <option value="<%=location.getLocationId()%>" >  <%=location.getLocationName() %></option>
                     <%}
             }%>      
       </select>
		
		</span></span>
		<span class="selecttype w215">
		<span class="lab"><liferay-ui:message key="END_DATE" /><sup class="astric-red">*</sup>
		<input type="text" class="calendericon" style="width:100px; background:url('<%=ctxPath%>/images/calendar-icon.gif') 80px center no-repeat; " name="EndDate" id="datepicker1" value="<%=br.getEdate() %>"  size="12" onchange="return validate3();" readonly="readonly" />
		</span></span>
		<span class="selecttype w215">
		<span class="lab"><liferay-ui:message key="END_TIME" /><sup class="astric-red">*</sup>
		<span class="time-table-wrapper">
		<table>
 <tr>
      <td >
          <select name="enhours" id="endTime" onchange="return validate4();">
        	                                                 <% String ehr2 = null;
								  for (int i = 1; i <= 12; i++) 
								  {
										String ehr = String.valueOf(i);
									    String ehr1 = br.getEnhours();
										if(ehr.equalsIgnoreCase("12"))
										{
												  ehr2 = "0";
										}
										else
										{
													ehr2=ehr;
										}
										if (ehr1.equals(ehr2)) 
									    {%>
										      <option value="<%=ehr2%>" selected="selected"><%=ehr%></option>
									   <%}
									 else{%>	                          				
                           				                        	<option value="<%=ehr2%>"><%=ehr%></option>
                           			                         <%}
								   }%> 
        </select>
       </td>
       <td>
            <select name="enminutes" id="endMin" onchange="return validate4();" >
                <%
					String emin =br.getEtminutes();
	     			if(emin.equals("00"))
	     			{%>		
	     				<option value="<%=br.getEtminutes() %>" selected="selected"><%=br.getEtminutes() %></option>
	     				<option value="15">15</option>
	                    <option value="30">30</option>
	                    <option value="45">45</option>
	     		<%
	     			}
	     			else if(emin.equals("15"))
	     			{
	     		%>		
	     				<option value="00">00</option>
	     				<option value="<%=br.getEtminutes() %>" selected="selected"><%=br.getEtminutes() %></option>
	     				<option value="30">30</option>
	                    <option value="45">45</option>
	     		<%
	     			}
	     			else if(emin.equals("30"))
	     			{
	     		%>		
	     				<option value="00">00</option>
	                    <option value="15">15</option>
	                    <option value="<%=br.getEtminutes() %>" selected="selected"><%=br.getEtminutes() %></option>
	     			    <option value="45">45</option>
	     		<%
	     			}
	     			else
	     			{
	     		%>
	     				
	     				<option value="00">00</option>
	                	<option value="15">15</option>
	                    <option value="30">30</option>
	                    <option value="<%=br.getEtminutes() %>" selected="selected"><%=br.getEtminutes() %></option>    
	     		<%	
	     			}
	            %>                  
   	        </select>
       </td>
       <td>
             <select name="enampm" id="endampm" onchange="return validate4();" >
                                                                      
			      <%String eampm =br.getEtampm();	     			
	     			if(eampm.equals("AM"))
	     			{%>
	     			         <option value="<%=br.getEtampm() %>" selected="selected"><%=br.getEtampm() %></option>
		                     <option value="PM">PM</option>
                  <%}
	     			else
	     			{%> 
	      				     <option value="<%=br.getEtampm() %>" selected="selected"><%=br.getEtampm() %></option>
		                     <option value="AM">AM</option>       
	              <%}%>        
             </select>
       </td>
</tr>
</table>
		</span></span></span>
	<br class="clear-both">
	<div class="search-btn">
	<input type="submit" value="Search"  />
         <span class="lfr-label"> <liferay-ui:icon-help message="Allows you to search for available rooms for booking according to your criteria." /></span>
       </div>
     
</div>
  
</div>

<br/>    
<liferay-ui:panel collapsible="<%=true%>" defaultState="open" extended="<%=true%>" id="allTasksPanel" persistState="<%=false%>" title='Search Preferences'>

<table class="wrm-font">
	<td><label for='chk1'>Search By Room Name</label></td>
	<td><input type ="checkbox" name="box1"   id="chk1"  value="yes1"  onselect="return validate5();" onclick="transfer();"> </td>
	<td  class="lfr-label">
		<liferay-ui:icon-help message="Select room name as priority." />
    </td>  
</table>

<br/>
<div id="p2">

      <table  class="wrm-font" >
      <tr>
       <td>
       <label for='chk2'>Facility</label> <input type ="checkbox" name="box2"   id="chk2"  value="yes" onclick="return validate5();">  <liferay-ui:icon-help message="Select facility as priority." />
     &nbsp;
      <select name="facilitiesId" id="Fac" multiple="multiple" onchange="return validate5();">
         <% List<FacilityMaster> allFacility = (List<FacilityMaster>)request.getAttribute("allFacility");
     	    Iterator it3= allFacility.iterator();
     		while(it3.hasNext())
       		{
        	   FacilityMaster facility=(FacilityMaster)it3.next(); %>
        	  <option value="<%=facility.getFacilitiesId() %>"> <%=facility.getFacilitiesName() %></option>
          <%} %>
          </select>
           <input  type="button" value="Clear"  onclick="ClearOptions('Fac');">
       </td>
      
      
        <td> 
        <label for='chk3'>Capacity</label> <input type ="checkbox" name="box3"   id="chk3"  value="yes" onclick="return validate6();"> <liferay-ui:icon-help message="Select capacity as priority."/>
         <input type="text" name="Capacity" id="Cap" onkeyup="return validate6();"  value="<%=br.getCapacity()%>" size="3"/>
            
       
           
        </td>
       
       <td>
       <label for='chk2'>Floor Name</label> <liferay-ui:icon-help message="Select floor as priority." />
              <select id="floorId" name="floorId"  onclick="return validate2();">  
              <option value="0">Select Floor</option>
              <%
        	   long lid=br.getLocationId();
          	   List<FloorMaster> allFloor = FloorMasterLocalServiceUtil.findAllInLocation(lid);
          	   Iterator<FloorMaster> it5= allFloor.iterator();
          	   while(it5.hasNext())
          	   {
      	           FloorMaster floor=(FloorMaster)it5.next();
      	           if(br.getFloorId()==floor.getFloorId())
      	           {%>
      	              <option value="<%=floor.getFloorId()%>" selected="selected"> <%=floor.getFloorName() + " floor"%> </option>
      	         <%}
      	           else
      	           {%>
      	               <option value="<%=floor.getFloorId()%>" >  <%=floor.getFloorName() + " floor"%></option>
      	          <%}
               }%>
            </select>
       </td>
      </tr>
    </table>  
  
</div>
<br/>
<div id="p3" style="display: none">
	 <table  class="wrm-font" >
	<tr>
	<td>
	     Room Name: 
	     <select name="roomId" id="roomId" onclick="return validate7();" >  
	     <option value='0'>Select Room</option>
	     <% List<RoomMaster> selRoom = RoomMasterLocalServiceUtil.findAllInLocation(br.getLocationId());
			Iterator<RoomMaster> it8= selRoom.iterator();
			while(it8.hasNext())
			{
				RoomMaster room=(RoomMaster)it8.next();
				if(br.getRoomId()==room.getRoomId())
				{%> 
					<option value="<%=room.getRoomId()%>" selected="selected"> <%=room.getRoomName()%> </option>
				<%}
				else
				{
				%> <option value="<%=room.getRoomId()%>"> <%=room.getRoomName() %></option>
				<%} 
		   }%>
	     
	      </select> 
	</td>
	</tr>
	</table>
</div>
</liferay-ui:panel> 



<liferay-ui:panel collapsible="<%=true%>" defaultState="open" extended="<%=false%>" id="allTasksPanel" persistState="<%=false%>" title='Search Results'>   
 </liferay-ui:panel>
 
 <%
if(flag!=null)
{	
     List<RoomMaster> roomlist=new ArrayList(); 
	 String delemiter="@";
	 String finalResult=(String)renderRequest.getAttribute("finalResult");
	 String[] bookingdateWiseRoomIdArray=finalResult.split(delemiter);
  
    for(int u=1;u<bookingdateWiseRoomIdArray.length;u++)
    {
	  String bookids[]=bookingdateWiseRoomIdArray[u].split(",");
	  String date=bookids[0];
	  renderRequest.setAttribute("date",date);
	  int l=0;
	  %>

	  <liferay-ui:panel collapsible="<%=true%>" defaultState="open" extended="<%=true%>" id="allTasksPanel" persistState="<%=false%>" title='<%=date%>'>
	  <table width="100%" border="0">
      <tr> 
          <%  
          if(bookids.length<=1)
    	  {%>
    	      <td> No Rooms Available.</td>
         <%}     
	      else
		  {
	  		for(int v=1;v<bookids.length;v++)
	  		{
				long disproomid=Long.valueOf(bookids[v]);
		 		RoomMaster roomlistobj=RoomMasterLocalServiceUtil.findRoomByRoomId(disproomid);
		 		if(l<5)
		  		{
		     		roomlist.add(roomlistobj); l++;
		  		}
		 		else
		  		{
			  		break;
		  		}
	  		}

   %>
      <td> 
     <liferay-ui:search-container>   			
            	
    	  <liferay-ui:search-container-results>
           <%     
           	 results = ListUtil.subList(roomlist, searchContainer.getStart(), searchContainer.getEnd());
		 	 total = roomlist.size();
			 pageContext.setAttribute("results", results);
		 	 pageContext.setAttribute("total", total);
           
    	   %>
    	  
    	</liferay-ui:search-container-results>
    	
    	 
    	 <liferay-ui:search-container-row
		       className="com.cignexdatamatics.wrm.model.RoomMaster"
		       keyProperty="roomId"
		       modelVar="room1">
		           
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/wrm_jsps/common/radio_button.jsp"
		/>
		
		
	    <liferay-ui:search-container-column-text
					name="Room Name"
					value="<%=room1.getRoomName()%>"
		 />
		 
		  <% long floorId=room1.getFloorId();
		      FloorMaster floorMaster = FloorMasterLocalServiceUtil.findFloorbyFloorId(floorId);
		      String FloorName=floorMaster.getFloorName() + "   floor";%>

      
	     <liferay-ui:search-container-column-text
					name="Room Location"
					value="<%=FloorName%>"
		 />	
		   <% long roomId2 = room1.getRoomId();
		     List<RoomFacilityMapping> rfm= RoomFacilityMappingLocalServiceUtil.findAllMappingbyRoomId(roomId2);
		     Iterator<RoomFacilityMapping>it4= rfm.iterator(); 
		     String facilityName=new String();
		     int i=0;
		     while(it4.hasNext())
             {            
		       RoomFacilityMapping rfm2=(RoomFacilityMapping)it4.next(); 
               long fid=rfm2.getFacilitiesId();
               FacilityMaster facility2 = FacilityMasterLocalServiceUtil.findbyFacilitiesId(fid);
               if(i==0)
               {
                   	   facilityName =facility2.getFacilitiesName();
                   	   i++;                   	                  	   
               }
               if(i!=1)
               {
            	   facilityName += ","+facility2.getFacilitiesName();                  
               }
               i++;
               
             }%>           
             
          <liferay-ui:search-container-column-text
					name="Room Facilities"
					value="<%=facilityName%>"		      
		 />  
		 <%facilityName=null; i=0; l++;%> 	
      
		  <liferay-ui:search-container-column-text
					name="Capacity"
					value="<%=String.valueOf(room1.getCapacity()) %>"
		 />
		  <liferay-ui:search-container-column-text
					name="Extension"
					value="<%=String.valueOf(room1.getExtension())%>"
		 />
		 
				 
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
<%	
   roomlist.clear();
  }  
%>	
</td>
</tr>
</table>
 </liferay-ui:panel>     
<%}    
    
 }
  if(flag!=null)
  { %>
<table style="float: right; margin: 5px 5px 5px;">
<tr>
    <td>       
    <portlet:actionURL name="bookRoom" var="bookRoomURL">                  
			 <portlet:param name="StartDate" value="<%=br.getSdate()%>" />
			 <portlet:param name="EndDate" value="<%=br.getEdate()%>" />
			 <portlet:param name="sthours1" value="<%=br.getSthours()%>" />
			 <portlet:param name="enhours1" value="<%=br.getEnhours()%>" />
			 <portlet:param name="stminutes1" value="<%=br.getStminutes()%>" />
			 <portlet:param name="enminutes1" value="<%=br.getEtminutes()%>" />
			 <portlet:param name="stampm1" value="<%=br.getStampm()%>" />
			 <portlet:param name="enampm1" value="<%=br.getEtampm()%>" />
			 <portlet:param name="cityId" value="<%= String.valueOf(br.getCityId())%>" />
			 <portlet:param name="locationId" value="<%= String.valueOf(br.getLocationId())%>" />
			 <portlet:param name="roomId" value="<%= String.valueOf(br.getRoomId())%>" />
   </portlet:actionURL>
    <input type="button" name="bookRoom" id="yesno" value="Select" onclick="submitFrm('<%=bookRoomURL%>')" style="margin:0 5px 0 0;">  
      
   </td>  
   <td  class="lfr-label" style="padding-top: 5px;">
        <liferay-ui:icon-help message="Allows you to book rooms after selection of rooms from search result only." />
   </td>  

</tr>
</table>
<br class="clear-both">
<%}%>
</liferay-ui:panel-container> </form>
