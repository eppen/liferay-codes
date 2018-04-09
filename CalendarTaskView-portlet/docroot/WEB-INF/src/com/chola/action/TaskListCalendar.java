package com.chola.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.chola.msexchange.FetchTask;
import com.independentsoft.exchange.Task;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

public class TaskListCalendar extends MVCPortlet {
	public static HttpServletRequest request=null;
	
	public void createTask(ActionRequest actionRequest, ActionResponse actionResponse) throws ParseException {
	System.out.println("In create task method");
	String taskSubject=ParamUtil.getString(actionRequest, "subject");
	String taskBody=ParamUtil.getString(actionRequest, "body");
	String taskStartDate=ParamUtil.getString(actionRequest, "taskStartDate");
	String taskDueDate=ParamUtil.getString(actionRequest, "taskEndDate");
	
	System.out.println("Subject : "+taskSubject);
	System.out.println("Body : "+taskBody);
	System.out.println("Start Date : "+taskStartDate);
	System.out.println("Due Date : "+taskDueDate);
	
	boolean createTaskSuccess=FetchTask.createTask(taskSubject, taskBody, taskStartDate, taskDueDate,actionRequest);
	
	System.out.println("Is Task Created : "+createTaskSuccess);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		if (resourceRequest.getResourceID().equalsIgnoreCase("taskCalendarData")) {
			try {
				ThemeDisplay themeDisplay=(ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				HttpServletRequest request = PortalUtil.getHttpServletRequest(
						resourceRequest);

				String password = com.liferay.util.CookieUtil.get(request, "pwd");
				
				System.out.println("Cookie Value :  "+password);
	
				String domain="@cholamandalam.com";
				
				User particularUser=UserLocalServiceUtil.getUser(themeDisplay.getUserId());
				String userScreenName=particularUser.getScreenName();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
				System.out.println("In Task List Fetch Method");
				String serviceURL="https://mail.murugappa.com/ews/Exchange.asmx";
				String userName="v481"+domain;
				String pass="welcome*123456";
				List<Task> lt = FetchTask.fetchTaskList(serviceURL,userName, pass);
			
				PrintWriter writer = resourceResponse.getWriter();
				JSONArray finalOb = new JSONArray();
				JSONObject objF = new JSONObject();
				
				 DateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
				 DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				  
				for(Task task:lt){
					JSONObject obj = new JSONObject();
					obj.put("id", "demo");
					obj.put("name", task.getSubject().toString());
					
					 Date dateStart = inputFormat.parse(task.getStartDate().toString());
					 String outputStart = outputFormat.format(dateStart);
					 
					 Date dateDue = inputFormat.parse(task.getDueDate().toString());
					 String outputDue = outputFormat.format(dateDue);
					obj.put("startdate", outputStart);
					//obj.put("enddate", ((task.getDueDate() == null || task.getDueDate().toString().equalsIgnoreCase(""))) ? ""
					//		: sdf.format(sdf.parse(task.getDueDate().toString())));*/
					obj.put("enddate", outputDue);
					obj.put("color", "blue");
					finalOb.add(obj);
				}
				
				objF.put("monthly", finalOb);
				System.out.println(objF);
				writer.print(objF);
			} catch (Exception e) {
e.printStackTrace();
			}
		}
	}
	
}
