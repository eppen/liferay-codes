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

package com.chola.popularlinks.service.base;

import com.chola.popularlinks.model.popularlinks;
import com.chola.popularlinks.service.persistence.externallinksPersistence;
import com.chola.popularlinks.service.persistence.popularlinksFinder;
import com.chola.popularlinks.service.persistence.popularlinksPersistence;
import com.chola.popularlinks.service.popularlinksService;

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
 * Provides the base implementation for the popularlinks remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.chola.popularlinks.service.impl.popularlinksServiceImpl}.
 * </p>
 *
 * @author adms.java1
 * @see com.chola.popularlinks.service.impl.popularlinksServiceImpl
 * @see com.chola.popularlinks.service.popularlinksServiceUtil
 * @generated
 */
public abstract class popularlinksServiceBaseImpl extends BaseServiceImpl
	implements popularlinksService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.chola.popularlinks.service.popularlinksServiceUtil} to access the popularlinks remote service.
	 */

	/**
	 * Returns the externallinks local service.
	 *
	 * @return the externallinks local service
	 */
	public com.chola.popularlinks.service.externallinksLocalService getexternallinksLocalService() {
		return externallinksLocalService;
	}

	/**
	 * Sets the externallinks local service.
	 *
	 * @param externallinksLocalService the externallinks local service
	 */
	public void setexternallinksLocalService(
		com.chola.popularlinks.service.externallinksLocalService externallinksLocalService) {
		this.externallinksLocalService = externallinksLocalService;
	}

	/**
	 * Returns the externallinks remote service.
	 *
	 * @return the externallinks remote service
	 */
	public com.chola.popularlinks.service.externallinksService getexternallinksService() {
		return externallinksService;
	}

	/**
	 * Sets the externallinks remote service.
	 *
	 * @param externallinksService the externallinks remote service
	 */
	public void setexternallinksService(
		com.chola.popularlinks.service.externallinksService externallinksService) {
		this.externallinksService = externallinksService;
	}

	/**
	 * Returns the externallinks persistence.
	 *
	 * @return the externallinks persistence
	 */
	public externallinksPersistence getexternallinksPersistence() {
		return externallinksPersistence;
	}

	/**
	 * Sets the externallinks persistence.
	 *
	 * @param externallinksPersistence the externallinks persistence
	 */
	public void setexternallinksPersistence(
		externallinksPersistence externallinksPersistence) {
		this.externallinksPersistence = externallinksPersistence;
	}

	/**
	 * Returns the popularlinks local service.
	 *
	 * @return the popularlinks local service
	 */
	public com.chola.popularlinks.service.popularlinksLocalService getpopularlinksLocalService() {
		return popularlinksLocalService;
	}

	/**
	 * Sets the popularlinks local service.
	 *
	 * @param popularlinksLocalService the popularlinks local service
	 */
	public void setpopularlinksLocalService(
		com.chola.popularlinks.service.popularlinksLocalService popularlinksLocalService) {
		this.popularlinksLocalService = popularlinksLocalService;
	}

	/**
	 * Returns the popularlinks remote service.
	 *
	 * @return the popularlinks remote service
	 */
	public popularlinksService getpopularlinksService() {
		return popularlinksService;
	}

	/**
	 * Sets the popularlinks remote service.
	 *
	 * @param popularlinksService the popularlinks remote service
	 */
	public void setpopularlinksService(popularlinksService popularlinksService) {
		this.popularlinksService = popularlinksService;
	}

	/**
	 * Returns the popularlinks persistence.
	 *
	 * @return the popularlinks persistence
	 */
	public popularlinksPersistence getpopularlinksPersistence() {
		return popularlinksPersistence;
	}

	/**
	 * Sets the popularlinks persistence.
	 *
	 * @param popularlinksPersistence the popularlinks persistence
	 */
	public void setpopularlinksPersistence(
		popularlinksPersistence popularlinksPersistence) {
		this.popularlinksPersistence = popularlinksPersistence;
	}

	/**
	 * Returns the popularlinks finder.
	 *
	 * @return the popularlinks finder
	 */
	public popularlinksFinder getpopularlinksFinder() {
		return popularlinksFinder;
	}

	/**
	 * Sets the popularlinks finder.
	 *
	 * @param popularlinksFinder the popularlinks finder
	 */
	public void setpopularlinksFinder(popularlinksFinder popularlinksFinder) {
		this.popularlinksFinder = popularlinksFinder;
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
		return popularlinksService.class.getName();
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
		return popularlinks.class;
	}

	protected String getModelClassName() {
		return popularlinks.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = popularlinksPersistence.getDataSource();

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

	@BeanReference(type = com.chola.popularlinks.service.externallinksLocalService.class)
	protected com.chola.popularlinks.service.externallinksLocalService externallinksLocalService;
	@BeanReference(type = com.chola.popularlinks.service.externallinksService.class)
	protected com.chola.popularlinks.service.externallinksService externallinksService;
	@BeanReference(type = externallinksPersistence.class)
	protected externallinksPersistence externallinksPersistence;
	@BeanReference(type = com.chola.popularlinks.service.popularlinksLocalService.class)
	protected com.chola.popularlinks.service.popularlinksLocalService popularlinksLocalService;
	@BeanReference(type = popularlinksService.class)
	protected popularlinksService popularlinksService;
	@BeanReference(type = popularlinksPersistence.class)
	protected popularlinksPersistence popularlinksPersistence;
	@BeanReference(type = popularlinksFinder.class)
	protected popularlinksFinder popularlinksFinder;
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
	private popularlinksServiceClpInvoker _clpInvoker = new popularlinksServiceClpInvoker();
}