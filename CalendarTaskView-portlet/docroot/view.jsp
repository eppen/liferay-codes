<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/monthly.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/monthly.css">

	<!-- <style type="text/css">
body {
	font-family: Calibri;
	background-color: #f0f0f0;
	padding: 0em 1em;
}

#mycalendar {
	width: 100%;
	margin: 2em auto 0 auto;
	max-width: 80em;
	border: 1px solid #666;
}
</style> -->
<style type="text/css">

#mycalendar {
	width: 96%;

}
.event_gradient{background:#ebedec url(/theme/images/custom/gradient.gif) repeat-x;}
</style>
<script>
$(document).ready(function(){

	//alert("Calendar View Task Fetch")
	var sampleEvents;
 	$.ajax({
		url : "<portlet:resourceURL id='taskCalendarData'/>",
		type : 'POST',
		dataType : 'json',
		success : function(data) {
			//alert("Task Data : "+JSON.stringify(data))
			sampleEvents=data;	
			//alert("Sample Events : "+JSON.stringify(sampleEvents));
			$("#mycalendar").monthly({
				mode : 'event',
				dataType : 'json',
				events : sampleEvents
		
			});
		},
		error : function() {
			console.log("There was an error. Try again please!");
		}
	});
});
	</script>
	
	<portlet:renderURL var="createTaskJspURL">
	<portlet:param name="jspPage" value="/html/CreateTask.jsp"/>
	</portlet:renderURL>
	
	<%-- <aui:button
type="submit"
value="Create Task"
onClick="<%= createTaskJspURL.toString() %>"
/> --%>
	
	
	<div class="col-md-12" style="padding:0px;">
   <div class="col-md-6" style="padding:0px;">
<div class="monthly" id="mycalendar"></div>
</div>
    
            <div class="col-md-6" style="padding:0px;    margin-left: -3px;">
                <div class="col-md-12" style="height: 237px;overflow: auto;">
                 <div class="row" style="background:#9e9e9e; padding-left:10px; margin-bottom:5px;">
                	
                    <div class="col-md-12 event_gradient" style="padding:0px 0px 0px 5px;">
                    
                    <div class="col-md-12" style="padding: 12px 0px 12px 5px;font-size: 11px;">
  
  <span style="font-weight:bold;font-size: 14px;">Today</span>
  <br>
  This task list or appointment list should be fetched from Microsoft exchange server. <span style="background: rgb(30, 89, 119) none repeat scroll 0% 0%; color: rgb(255, 255, 255); padding: 2px; font-size: 8px; float:right; margin-right:10px;">More +</span></div>
                    
                    
                    </div>
                    
                </div>
                 </div>
                
                <div class="col-md-12">
                
                <div class="row text_style" style="text-align:right;"><a href="#">View All</a></div>
                </div>
            
            </div>
         
		 
</div>
<div id="sidebar"></div>