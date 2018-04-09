package com.chola.news.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;


public class AroundtheworldAction extends MVCPortlet{
	private static Log logger = LogFactoryUtil.getLog(AroundtheworldAction.class);
	
	public void addComment(ActionRequest actionRequest, ActionResponse actionResponse) {
		logger.info("Comment=======");

		try {
			invokeTaglibDiscussion(actionRequest, actionResponse);
			logger.info("Comment Successfull");
		} catch (Exception e) {
			logger.error("Error",e);
		}
	}
}
