package com.chola.msexchange;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.servlet.http.HttpServletRequest;

import com.independentsoft.exchange.Body;
import com.independentsoft.exchange.FindItemResponse;
import com.independentsoft.exchange.IsEqualTo;
import com.independentsoft.exchange.ItemId;
import com.independentsoft.exchange.Service;
import com.independentsoft.exchange.ServiceException;
import com.independentsoft.exchange.StandardFolder;
import com.independentsoft.exchange.Task;
import com.independentsoft.exchange.TaskPropertyPath;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

public class FetchTask {

		public static void main(String[] args) throws Exception {
		    String input = "Thu Apr 20 04:30:00 GMT 2017";
		    DateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		    Date date = inputFormat.parse(input);

		    DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		   

		    String output = outputFormat.format(date);
		    System.out.println(output);
		  }
	
public static List<Task> fetchTaskList(String serviceURL,String userName,String pass){

	  try
      {
         // Service service = new Service("https://myserver/ews/Exchange.asmx", "username", "password");
          //https://mail.murugappa.com/ews
      
          Service service = new Service(serviceURL, userName , pass);
        // IsEqualTo restriction = new IsEqualTo(TaskPropertyPath, true);
         // System.out.println(restriction);
          
         // IsEqualTo restriction = new IsEqualTo(TaskPropertyPath.IS_COMPLETE, true);

          //FindItemResponse response = service.findItem(StandardFolder.TASKS, TaskPropertyPath.getAllPropertyPaths(), restriction);

        FindItemResponse response = service.findItem(StandardFolder.TASKS, TaskPropertyPath.getAllPropertyPaths());

System.out.println(response.getItems().size());

List<Task> tl=new ArrayList<Task>();
          for (int i = 0; i < response.getItems().size(); i++)
          {
       
              if (response.getItems().get(i) instanceof Task)
              {

                  Task task = (Task) response.getItems().get(i);
                  tl.add(task);
                  System.out.println("Subject = " + task.getSubject());
                  System.out.println("StartDate = " + task.getStartDate());
                  System.out.println("DueDate = " + task.getDueDate());
                  System.out.println("Owner = " + task.getOwner());
                  System.out.println("Body Preview = " + task.getBodyPlainText());
                  System.out.println("----------------------------------------------------------------");
              }
          }
          
          return tl;
      }
      catch (Exception e)
      {
    	  e.printStackTrace();
         }

return null;
	}

public static boolean createTask(String subject,String body,String startDate,String endDate,ActionRequest actionRequest) throws ParseException{
	boolean isCreated=false;
	
	 try
     {
		 ThemeDisplay themeDisplay=(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			HttpServletRequest request = PortalUtil.getHttpServletRequest(
					actionRequest);

			String password = com.liferay.util.CookieUtil.get(request, "pwd");
			
			System.out.println("Cookie Value :  "+password);

			String domain="@cholamandalam.com";
			
			User particularUser=UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			String userScreenName=particularUser.getScreenName();
		 
		 
		  Service service = new Service("https://mail.murugappa.com/ews/Exchange.asmx", "v481@cholamandalam.com" , "welcome*123456");

         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Date startTime = dateFormat.parse(startDate);
         Date endTime = dateFormat.parse(endDate);

         Task task = new Task();
         task.setSubject(subject);
         task.setBody(new Body(body));
         task.setOwner("Dummy");
         task.setStartDate(startTime);
         task.setDueDate(endTime);
         task.setReminderIsSet(true);
         task.setReminderDueBy(startTime);
         

         ItemId itemId = service.createItem(task);
         
         System.out.println("Hello World" +itemId.getId().toString());
         
         if(itemId.getId()!=null){
        	 isCreated=true;
         }
     return isCreated;
     }
     catch (Exception e)
     {
         e.printStackTrace();
     return isCreated;
     }
}

}
