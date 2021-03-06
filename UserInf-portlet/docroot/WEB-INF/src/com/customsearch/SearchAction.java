package com.customsearch;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.json.simple.JSONObject;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.usertheme.model.themecolor;
import com.usertheme.service.themecolorLocalServiceUtil;

public class SearchAction extends MVCPortlet{

	private static final Log logger = LogFactoryUtil.getLog(SearchAction.class);
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		try {
			logger.info("Ajax ID " + resourceRequest.getResourceID());

			if ("getTheme".equalsIgnoreCase(resourceRequest.getResourceID())) {
				logger.info("Inside getTheme");
				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				List<themecolor> lt = themecolorLocalServiceUtil.themeFinder(String.valueOf(themeDisplay.getUser().getUserId()));
				PrintWriter writer = resourceResponse.getWriter();
				JSONObject obj = new JSONObject();
				for(themecolor themeData : lt)
				{
					obj.put("THEME", themeData.getColor());
				}
				logger.info("DATA  : "+obj);
				writer.print(obj);
			}
			if ("changeTheme".equalsIgnoreCase(resourceRequest.getResourceID())) {
				logger.info("Inside changeTheme");
				String themed = resourceRequest.getParameter("themename");
				logger.info("Theme Color : "+themed);
				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				JSONObject obj = new JSONObject();
				PrintWriter writer = resourceResponse.getWriter();
				List<themecolor> lt = themecolorLocalServiceUtil.themeFinder(String.valueOf(themeDisplay.getUser().getUserId()));
				if(!lt.isEmpty())
				{
				for(themecolor themeData : lt)
				{
				themecolor themeColor = themecolorLocalServiceUtil.fetchthemecolor(themeData.getId());
				themeColor.setColor(themed);
				themeColor.setUpdatedDate(new Date());
				themeColor.setUser_id(String.valueOf(themeDisplay.getUser().getUserId()));
				themecolorLocalServiceUtil.updatethemecolor(themeColor);
				if(themeColor.getColor()!="")
				{
				obj.put("RESPONSE", "SUCCESS");
				}
				}
				}else
				{
				themecolor themedata = themecolorLocalServiceUtil.createthemecolor(CounterLocalServiceUtil.increment());
				themedata.setColor(themed);
				themedata.setUpdatedDate(new Date());
				themedata.setUser_id(String.valueOf(themeDisplay.getUser().getUserId()));
				themecolorLocalServiceUtil.updatethemecolor(themedata);
				if(themedata.getColor()!="")
				{
				obj.put("RESPONSE", "SUCCESS");
				}
				}
				writer.print(obj);
			}
			} 
			catch(Exception e)
			{
				logger.error("Error",e);
			}
		}
		
	public void updatePageLayout(ActionRequest request, ActionResponse response)throws PortletException, IOException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String value = request.getParameter("searchBox");
		logger.info("Value : "+URLEncoder.encode(value));
		
		String optionValue = request.getParameter("optradio");
		logger.info("optionValue : "+(optionValue));
		
		String url = themeDisplay.getURLPortal();
		logger.info("URL and PORT : "+(url));
		/*PortletSession portletSession = request.getPortletSession();
		portletSession.setAttribute("LIFERAY_SHARED_mySpecialVar",value,PortletSession.APPLICATION_SCOPE);
		*/
		/*String pageName="/demo"; 
		String portletName = "CustomSearch"; 
		long plid = 0L; 
		try 
		{
			plid = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, pageName).getPlid(); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}*/
		/*String portletName ="CustomSearch";
		PortletURL successPageURL = PortletURLFactoryUtil.create(
                request, portletName+ "_WAR_" + portletName + "portlet", 
                themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);*/

		//PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request),portletName,plid, PortletRequest.RENDER_PHASE); 
		//redirectURL.setParameter("data", URLEncoder.encode(value)); 
		/*HttpServletRequest request1 = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest originalHttpServletRequest = (HttpServletRequest)PortalUtil.getOriginalServletRequest(request1);
		HttpSession httpSession = originalHttpServletRequest.getSession();
		httpSession.setAttribute("currentSiteName", "hello");*/
		response.sendRedirect(url+"/group/cholamandalam-investment-and-finance/search?key="+URLEncoder.encode(value)+"&opt="+optionValue);
		//response.sendRedirect(redirectURL.toString());
	} 
}
