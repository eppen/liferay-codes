/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.chola.imagegallery.service.base;

import com.chola.imagegallery.model.imagegallery;
import com.chola.imagegallery.service.imagegalleryService;
import com.chola.imagegallery.service.persistence.imagegalleryPersistence;
import com.chola.imagegallery.service.persistence.imagegallerypathPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the imagegallery remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.chola.imagegallery.service.impl.imagegalleryServiceImpl}.
 * </p>
 *
 * @author CloverLiferay02
 * @see com.chola.imagegallery.service.impl.imagegalleryServiceImpl
 * @see com.chola.imagegallery.service.imagegalleryServiceUtil
 * @generated
 */
public abstract class imagegalleryServiceBaseImpl extends BaseServiceImpl
	implements imagegalleryService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.chola.imagegallery.service.imagegalleryServiceUtil} to access the imagegallery remote service.
	 */

	/**
	 * Returns the imagegallery local service.
	 *
	 * @return the imagegallery local service
	 */
	public com.chola.imagegallery.service.imagegalleryLocalService getimagegalleryLocalService() {
		return imagegalleryLocalService;
	}

	/**
	 * Sets the imagegallery local service.
	 *
	 * @param imagegalleryLocalService the imagegallery local service
	 */
	public void setimagegalleryLocalService(
		com.chola.imagegallery.service.imagegalleryLocalService imagegalleryLocalService) {
		this.imagegalleryLocalService = imagegalleryLocalService;
	}

	/**
	 * Returns the imagegallery remote service.
	 *
	 * @return the imagegallery remote service
	 */
	public imagegalleryService getimagegalleryService() {
		return imagegalleryService;
	}

	/**
	 * Sets the imagegallery remote service.
	 *
	 * @param imagegalleryService the imagegallery remote service
	 */
	public void setimagegalleryService(imagegalleryService imagegalleryService) {
		this.imagegalleryService = imagegalleryService;
	}

	/**
	 * Returns the imagegallery persistence.
	 *
	 * @return the imagegallery persistence
	 */
	public imagegalleryPersistence getimagegalleryPersistence() {
		return imagegalleryPersistence;
	}

	/**
	 * Sets the imagegallery persistence.
	 *
	 * @param imagegalleryPersistence the imagegallery persistence
	 */
	public void setimagegalleryPersistence(
		imagegalleryPersistence imagegalleryPersistence) {
		this.imagegalleryPersistence = imagegalleryPersistence;
	}

	/**
	 * Returns the imagegallerypath local service.
	 *
	 * @return the imagegallerypath local service
	 */
	public com.chola.imagegallery.service.imagegallerypathLocalService getimagegallerypathLocalService() {
		return imagegallerypathLocalService;
	}

	/**
	 * Sets the imagegallerypath local service.
	 *
	 * @param imagegallerypathLocalService the imagegallerypath local service
	 */
	public void setimagegallerypathLocalService(
		com.chola.imagegallery.service.imagegallerypathLocalService imagegallerypathLocalService) {
		this.imagegallerypathLocalService = imagegallerypathLocalService;
	}

	/**
	 * Returns the imagegallerypath remote service.
	 *
	 * @return the imagegallerypath remote service
	 */
	public com.chola.imagegallery.service.imagegallerypathService getimagegallerypathService() {
		return imagegallerypathService;
	}

	/**
	 * Sets the imagegallerypath remote service.
	 *
	 * @param imagegallerypathService the imagegallerypath remote service
	 */
	public void setimagegallerypathService(
		com.chola.imagegallery.service.imagegallerypathService imagegallerypathService) {
		this.imagegallerypathService = imagegallerypathService;
	}

	/**
	 * Returns the imagegallerypath persistence.
	 *
	 * @return the imagegallerypath persistence
	 */
	public imagegallerypathPersistence getimagegallerypathPersistence() {
		return imagegallerypathPersistence;
	}

	/**
	 * Sets the imagegallerypath persistence.
	 *
	 * @param imagegallerypathPersistence the imagegallerypath persistence
	 */
	public void setimagegallerypathPersistence(
		imagegallerypathPersistence imagegallerypathPersistence) {
		this.imagegallerypathPersistence = imagegallerypathPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return imagegalleryService.class.getName();
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return imagegallery.class;
	}

	protected String getModelClassName() {
		return imagegallery.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = imagegalleryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.chola.imagegallery.service.imagegalleryLocalService.class)
	protected com.chola.imagegallery.service.imagegalleryLocalService imagegalleryLocalService;
	@BeanReference(type = imagegalleryService.class)
	protected imagegalleryService imagegalleryService;
	@BeanReference(type = imagegalleryPersistence.class)
	protected imagegalleryPersistence imagegalleryPersistence;
	@BeanReference(type = com.chola.imagegallery.service.imagegallerypathLocalService.class)
	protected com.chola.imagegallery.service.imagegallerypathLocalService imagegallerypathLocalService;
	@BeanReference(type = com.chola.imagegallery.service.imagegallerypathService.class)
	protected com.chola.imagegallery.service.imagegallerypathService imagegallerypathService;
	@BeanReference(type = imagegallerypathPersistence.class)
	protected imagegallerypathPersistence imagegallerypathPersistence;
	@BeanReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private ClassLoader _classLoader;
	private imagegalleryServiceClpInvoker _clpInvoker = new imagegalleryServiceClpInvoker();
}