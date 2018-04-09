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

package com.chola.knowledgebites.service.base;

import com.chola.knowledgebites.model.kbusers;
import com.chola.knowledgebites.service.kbusersService;
import com.chola.knowledgebites.service.persistence.kbdetailsFinder;
import com.chola.knowledgebites.service.persistence.kbdetailsPersistence;
import com.chola.knowledgebites.service.persistence.kbpathPersistence;
import com.chola.knowledgebites.service.persistence.kbusersPersistence;

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
 * Provides the base implementation for the kbusers remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.chola.knowledgebites.service.impl.kbusersServiceImpl}.
 * </p>
 *
 * @author cloverliferay01
 * @see com.chola.knowledgebites.service.impl.kbusersServiceImpl
 * @see com.chola.knowledgebites.service.kbusersServiceUtil
 * @generated
 */
public abstract class kbusersServiceBaseImpl extends BaseServiceImpl
	implements kbusersService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.chola.knowledgebites.service.kbusersServiceUtil} to access the kbusers remote service.
	 */

	/**
	 * Returns the kbdetails local service.
	 *
	 * @return the kbdetails local service
	 */
	public com.chola.knowledgebites.service.kbdetailsLocalService getkbdetailsLocalService() {
		return kbdetailsLocalService;
	}

	/**
	 * Sets the kbdetails local service.
	 *
	 * @param kbdetailsLocalService the kbdetails local service
	 */
	public void setkbdetailsLocalService(
		com.chola.knowledgebites.service.kbdetailsLocalService kbdetailsLocalService) {
		this.kbdetailsLocalService = kbdetailsLocalService;
	}

	/**
	 * Returns the kbdetails remote service.
	 *
	 * @return the kbdetails remote service
	 */
	public com.chola.knowledgebites.service.kbdetailsService getkbdetailsService() {
		return kbdetailsService;
	}

	/**
	 * Sets the kbdetails remote service.
	 *
	 * @param kbdetailsService the kbdetails remote service
	 */
	public void setkbdetailsService(
		com.chola.knowledgebites.service.kbdetailsService kbdetailsService) {
		this.kbdetailsService = kbdetailsService;
	}

	/**
	 * Returns the kbdetails persistence.
	 *
	 * @return the kbdetails persistence
	 */
	public kbdetailsPersistence getkbdetailsPersistence() {
		return kbdetailsPersistence;
	}

	/**
	 * Sets the kbdetails persistence.
	 *
	 * @param kbdetailsPersistence the kbdetails persistence
	 */
	public void setkbdetailsPersistence(
		kbdetailsPersistence kbdetailsPersistence) {
		this.kbdetailsPersistence = kbdetailsPersistence;
	}

	/**
	 * Returns the kbdetails finder.
	 *
	 * @return the kbdetails finder
	 */
	public kbdetailsFinder getkbdetailsFinder() {
		return kbdetailsFinder;
	}

	/**
	 * Sets the kbdetails finder.
	 *
	 * @param kbdetailsFinder the kbdetails finder
	 */
	public void setkbdetailsFinder(kbdetailsFinder kbdetailsFinder) {
		this.kbdetailsFinder = kbdetailsFinder;
	}

	/**
	 * Returns the kbpath local service.
	 *
	 * @return the kbpath local service
	 */
	public com.chola.knowledgebites.service.kbpathLocalService getkbpathLocalService() {
		return kbpathLocalService;
	}

	/**
	 * Sets the kbpath local service.
	 *
	 * @param kbpathLocalService the kbpath local service
	 */
	public void setkbpathLocalService(
		com.chola.knowledgebites.service.kbpathLocalService kbpathLocalService) {
		this.kbpathLocalService = kbpathLocalService;
	}

	/**
	 * Returns the kbpath remote service.
	 *
	 * @return the kbpath remote service
	 */
	public com.chola.knowledgebites.service.kbpathService getkbpathService() {
		return kbpathService;
	}

	/**
	 * Sets the kbpath remote service.
	 *
	 * @param kbpathService the kbpath remote service
	 */
	public void setkbpathService(
		com.chola.knowledgebites.service.kbpathService kbpathService) {
		this.kbpathService = kbpathService;
	}

	/**
	 * Returns the kbpath persistence.
	 *
	 * @return the kbpath persistence
	 */
	public kbpathPersistence getkbpathPersistence() {
		return kbpathPersistence;
	}

	/**
	 * Sets the kbpath persistence.
	 *
	 * @param kbpathPersistence the kbpath persistence
	 */
	public void setkbpathPersistence(kbpathPersistence kbpathPersistence) {
		this.kbpathPersistence = kbpathPersistence;
	}

	/**
	 * Returns the kbusers local service.
	 *
	 * @return the kbusers local service
	 */
	public com.chola.knowledgebites.service.kbusersLocalService getkbusersLocalService() {
		return kbusersLocalService;
	}

	/**
	 * Sets the kbusers local service.
	 *
	 * @param kbusersLocalService the kbusers local service
	 */
	public void setkbusersLocalService(
		com.chola.knowledgebites.service.kbusersLocalService kbusersLocalService) {
		this.kbusersLocalService = kbusersLocalService;
	}

	/**
	 * Returns the kbusers remote service.
	 *
	 * @return the kbusers remote service
	 */
	public kbusersService getkbusersService() {
		return kbusersService;
	}

	/**
	 * Sets the kbusers remote service.
	 *
	 * @param kbusersService the kbusers remote service
	 */
	public void setkbusersService(kbusersService kbusersService) {
		this.kbusersService = kbusersService;
	}

	/**
	 * Returns the kbusers persistence.
	 *
	 * @return the kbusers persistence
	 */
	public kbusersPersistence getkbusersPersistence() {
		return kbusersPersistence;
	}

	/**
	 * Sets the kbusers persistence.
	 *
	 * @param kbusersPersistence the kbusers persistence
	 */
	public void setkbusersPersistence(kbusersPersistence kbusersPersistence) {
		this.kbusersPersistence = kbusersPersistence;
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
		return kbusersService.class.getName();
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
		return kbusers.class;
	}

	protected String getModelClassName() {
		return kbusers.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = kbusersPersistence.getDataSource();

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

	@BeanReference(type = com.chola.knowledgebites.service.kbdetailsLocalService.class)
	protected com.chola.knowledgebites.service.kbdetailsLocalService kbdetailsLocalService;
	@BeanReference(type = com.chola.knowledgebites.service.kbdetailsService.class)
	protected com.chola.knowledgebites.service.kbdetailsService kbdetailsService;
	@BeanReference(type = kbdetailsPersistence.class)
	protected kbdetailsPersistence kbdetailsPersistence;
	@BeanReference(type = kbdetailsFinder.class)
	protected kbdetailsFinder kbdetailsFinder;
	@BeanReference(type = com.chola.knowledgebites.service.kbpathLocalService.class)
	protected com.chola.knowledgebites.service.kbpathLocalService kbpathLocalService;
	@BeanReference(type = com.chola.knowledgebites.service.kbpathService.class)
	protected com.chola.knowledgebites.service.kbpathService kbpathService;
	@BeanReference(type = kbpathPersistence.class)
	protected kbpathPersistence kbpathPersistence;
	@BeanReference(type = com.chola.knowledgebites.service.kbusersLocalService.class)
	protected com.chola.knowledgebites.service.kbusersLocalService kbusersLocalService;
	@BeanReference(type = kbusersService.class)
	protected kbusersService kbusersService;
	@BeanReference(type = kbusersPersistence.class)
	protected kbusersPersistence kbusersPersistence;
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
	private kbusersServiceClpInvoker _clpInvoker = new kbusersServiceClpInvoker();
}