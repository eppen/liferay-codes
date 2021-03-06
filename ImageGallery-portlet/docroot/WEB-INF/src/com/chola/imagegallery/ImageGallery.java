package com.chola.imagegallery;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.chola.imagegallery.model.imagegallery;
import com.chola.imagegallery.model.imagegallerypath;
import com.chola.imagegallery.service.imagegalleryLocalServiceUtil;
import com.chola.imagegallery.service.imagegallerypathLocalServiceUtil;
import com.chola.ppcontent.service.contentupdateLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;


public class ImageGallery extends MVCPortlet {
	private static Log logger = LogFactoryUtil.getLog(ImageGallery.class);

	public void updateDetails(ActionRequest request, ActionResponse response)
			throws NumberFormatException, PortalException {
		logger.info("Inside Update Method");

		String id = request.getParameter("id");
		logger.info("ID : " + id);

		String albumName = request.getParameter("albumName");
		logger.info("albumName : " + albumName);

		String albumDesc = request.getParameter("albumDesc");
		logger.info("albumDesc : " + albumDesc);

		imagegallery img = imagegalleryLocalServiceUtil.fetchimagegallery(Long.parseLong(id));
		img.setAlbumName(albumName);
		img.setAlbumDesc(albumDesc);
		img = imagegalleryLocalServiceUtil.updateimagegallery(img);

		logger.info("Updated ID : " + img.getId());
		
		long flag=2;
		String notificationText="Image Album has been Updated";
		long content_id=img.getContent_id();
		boolean updatedeleteSucces=contentupdateLocalServiceUtil.changeContentFlagForUpdateDelete(flag,notificationText, content_id);
		
		logger.info("update status "+updatedeleteSucces);

	}

	public void removeAlbum(ActionRequest request, ActionResponse response) {
		logger.info("Inside Remove Method");

		String albumSelect = request.getParameter("albumSelect");
		logger.info("albumSelect : " + albumSelect);

		imagegallery imageGal = imagegalleryLocalServiceUtil.fetchimagegallery(Long.parseLong(albumSelect));
		imageGal.setFlag("2");
		imageGal = imagegalleryLocalServiceUtil.updateimagegallery(imageGal);

		logger.info("Removed Successfully : " + imageGal.getId());
		
		long flag=0;
		String notificationText="Image Album has been Deleted";
		long content_id=imageGal.getContent_id();
		
		boolean updatedeleteSucces=contentupdateLocalServiceUtil.changeContentFlagForUpdateDelete(flag,notificationText, content_id);
		
		logger.info("delete status : "+updatedeleteSucces);
		
	}

	public String fileUpload(ActionRequest request, ActionResponse response, UploadPortletRequest uploadRequest,
			String fileName, File sourceFile) throws IOException {

		String str = "ImageGalleryUpload";

		String role="admin";
		java.util.Properties properties = PortalUtil.getPortalProperties();
		logger.info("my properties is...." + properties);
		File contestfolder = new File(properties.getProperty("liferay.home") + "/tomcat-8.0.32/webapps/" + str);
		File destinationFile = new File(
				properties.getProperty("liferay.home") + "/tomcat-8.0.32/webapps/" + str + "/" + role);

		if (!contestfolder.exists()) {
			destinationFile.mkdirs();
		}

		if (!destinationFile.exists()) {
			destinationFile.mkdirs();
			logger.info("type directory exists");
		}
		logger.info("my directory is : " + destinationFile);


		if (fileName != null) {
			/**************** SAVE THE DOC ********************************/
			if (destinationFile.exists()) {
				String fileNa = fileName.substring(0, fileName.lastIndexOf("."));
				logger.info("fileName : " + fileNa);
				String fileExtension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
				logger.info("fileExtension : " + fileExtension);
				fileName = fileNa;
				SimpleDateFormat df2 = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
				Date date = new Date();
				String testDateString = df2.format(date);
				fileName = fileName + "_" + testDateString + fileExtension;

				destinationFile = new File(properties.getProperty("liferay.home") + "/tomcat-8.0.32/webapps/" + str
						+ "/" + role + "/" + fileName);

				logger.info("destinationFile : " + destinationFile);

			}
			logger.info("File : " + fileName);
			FileUtil.copyFile(sourceFile, destinationFile);

			String FilePath = destinationFile.toString();
			logger.info("Successfully Saved the Document");
			/*************** ENDED THE SAVING ******************/
			logger.info(FilePath);
		}
		return fileName;
	}

	public void uploadData(ActionRequest request, ActionResponse response) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		String albumName = request.getParameter("albumName");
		logger.info("albumName : " + albumName);

		String albumDesc = request.getParameter("albumDesc");
		logger.info("albumDesc : " + albumDesc);
		
		SimpleDateFormat df2 = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date date = new Date();
		String albumId = df2.format(date);

		
		SimpleDateFormat df3 = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
		long uniqueContentId = Long.parseLong(df3.format(date));
		
		String currentPageUrl=themeDisplay.getURLCurrent();
		if(currentPageUrl.contains("?"))
		{
			currentPageUrl = currentPageUrl.substring(0, currentPageUrl.indexOf("?"));
		}
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		String[] sourceFileName = uploadRequest.getFileNames("uploadedFile");
		File[] sourceFile = uploadRequest.getFiles("uploadedFile");
		
		imagegallerypath path = null;
		
		for(int i=0;i<sourceFileName.length;i++)
		{
			logger.info("File Name : "+sourceFileName[i]);
		
		String fileName=null;
		if(!"".equalsIgnoreCase(sourceFileName[i]))
		{
			logger.info("File selected by user");
			fileName = fileUpload(request,response,uploadRequest,sourceFileName[i],sourceFile[i]);
		}
		else
		{
			logger.info("File not selected by user");
		}

		    path = imagegallerypathLocalServiceUtil.createimagegallerypath(CounterLocalServiceUtil.increment());
			path.setAlbumImagePath("/ImageGalleryUpload/admin/"+fileName);
			path.setCreatedBy(String.valueOf(themeDisplay.getUserId()));
			path.setCreatedDate(date);
			//path.setCreatedDate(new Date());
	        path.setFlag("1");
			path.setAlbumId(albumId);
			path.setContent_id(uniqueContentId);
			path = imagegallerypathLocalServiceUtil.addimagegallerypath(path);

		}
		if(path!=null)
		{
		imagegallery imgGallery = imagegalleryLocalServiceUtil.createimagegallery(CounterLocalServiceUtil.increment());
		imgGallery.setAlbumName(albumName);
		imgGallery.setAlbumDesc(albumDesc);
		imgGallery.setAlbumId(path.getAlbumId());
		imgGallery.setCreatedBy(String.valueOf(themeDisplay.getUserId()));
		imgGallery.setCreatedDate(date);
		imgGallery.setFlag("1");
		imgGallery.setContent_id(uniqueContentId);

		imgGallery = imagegalleryLocalServiceUtil.addimagegallery(imgGallery);

	    List<String> lt=com.chola.ppcontent.service.contentupdateLocalServiceUtil.getCompany();
		Iterator it = lt.iterator();
		 Object[] notificationDetails={imgGallery.getContent_id(),1,1,"Image Gallery","New Album has been added",currentPageUrl};
		
		boolean insert1=com.chola.ppcontent.service.contentupdateLocalServiceUtil.insertIntoContentUniqueInfo(notificationDetails);
		
		while (it.hasNext()) {
			Object[] object = (Object[]) it.next();
			String businessId=object[0].toString();
			
			if(insert1){
				boolean insert2=com.chola.ppcontent.service.contentupdateLocalServiceUtil.insertIntoPPContentStore(businessId, null, "ALL", "all", "All User", imgGallery.getContent_id(), null, null, null, 0);
			}
		}
		}
	}

	public void addComment(ActionRequest actionRequest, ActionResponse actionResponse) {
		logger.info("Comment=======");

		try {
			invokeTaglibDiscussion(actionRequest, actionResponse);
			logger.info("Comment is successfully added........");
		} catch (Exception e) {
			logger.error("Error",e);
		}
	}
}
