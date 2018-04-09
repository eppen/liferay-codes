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

package com.chola.business.service.base;

import com.chola.business.model.businesssopusers;
import com.chola.business.service.businesssopusersService;
import com.chola.business.service.persistence.businesssopDetailsFinder;
import com.chola.business.service.persistence.businesssopDetailsPersistence;
import com.chola.business.service.persistence.businesssoppathPersistence;
import com.chola.business.service.persistence.businesssopusersPersistence;

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
 * Provides the base implementation for the businesssopusers remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.chola.business.service.impl.businesssopusersServiceImpl}.
 * </p>
 *
 * @author adms.java1
 * @see com.chola.business.service.impl.businesssopusersServiceImpl
 * @see com.chola.business.service.businesssopusersServiceUtil
 * @generated
 */
public abstract class businesssopusersServiceBaseImpl extends BaseServiceImpl
	implements businesssopusersService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.chola.business.service.businesssopusersServiceUtil} to access the businesssopusers remote service.
	 */

	/**
	 * Returns the businesssop details local service.
	 *
	 * @return the businesssop details local service
	 */
	public com.chola.business.service.businesssopDetailsLocalService getbusinesssopDetailsLocalService() {
		return businesssopDetailsLocalService;
	}

	/**
	 * Sets the businesssop details local service.
	 *
	 * @param businesssopDetailsLocalService the businesssop details local service
	 */
	public void setbusinesssopDetailsLocalService(
		com.chola.business.service.businesssopDetailsLocalService businesssopDetailsLocalService) {
		this.businesssopDetailsLocalService = businesssopDetailsLocalService;
	}

	/**
	 * Returns the businesssop details remote service.
	 *
	 * @return the businesssop details remote service
	 */
	public com.chola.business.service.businesssopDetailsService getbusinesssopDetailsService() {
		return businesssopDetailsService;
	}

	/**
	 * Sets the businesssop details remote service.
	 *
	 * @param businesssopDetailsService the businesssop details remote service
	 */
	public void setbusinesssopDetailsService(
		com.chola.business.service.businesssopDetailsService businesssopDetailsService) {
		this.businesssopDetailsService = businesssopDetailsService;
	}

	/**
	 * Returns the businesssop details persistence.
	 *
	 * @return the businesssop details persistence
	 */
	public businesssopDetailsPersistence getbusinesssopDetailsPersistence() {
		return businesssopDetailsPersistence;
	}

	/**
	 * Sets the businesssop details persistence.
	 *
	 * @param businesssopDetailsPersistence the businesssop details persistence
	 */
	public void setbusinesssopDetailsPersistence(
		businesssopDetailsPersistence businesssopDetailsPersistence) {
		this.businesssopDetailsPersistence = businesssopDetailsPersistence;
	}

	/**
	 * Returns the businesssop details finder.
	 *
	 * @return the businesssop details finder
	 */
	public businesssopDetailsFinder getbusinesssopDetailsFinder() {
		return businesssopDetailsFinder;
	}

	/**
	 * Sets the businesssop details finder.
	 *
	 * @param businesssopDetailsFinder the businesssop details finder
	 */
	public void setbusinesssopDetailsFinder(
		businesssopDetailsFinder businesssopDetailsFinder) {
		this.businesssopDetailsFinder = businesssopDetailsFinder;
	}

	/**
	 * Returns the businesssoppath local service.
	 *
	 * @return the businesssoppath local service
	 */
	public com.chola.business.service.businesssoppathLocalService getbusinesssoppathLocalService() {
		return businesssoppathLocalService;
	}

	/**
	 * Sets the businesssoppath local service.
	 *
	 * @param businesssoppathLocalService the businesssoppath local service
	 */
	public void setbusinesssoppathLocalService(
		com.chola.business.service.businesssoppathLocalService businesssoppathLocalService) {
		this.businesssoppathLocalService = businesssoppathLocalService;
	}

	/**
	 * Returns the businesssoppath remote service.
	 *
	 * @return the businesssoppath remote service
	 */
	public com.chola.business.service.businesssoppathService getbusinesssoppathService() {
		return businesssoppathService;
	}

	/**
	 * Sets the businesssoppath remote service.
	 *
	 * @param businesssoppathService the businesssoppath remote service
	 */
	public void setbusinesssoppathService(
		com.chola.business.service.businesssoppathService businesssoppathService) {
		this.businesssoppathService = businesssoppathService;
	}

	/**
	 * Returns the businesssoppath persistence.
	 *
	 * @return the businesssoppath persistence
	 */
	public businesssoppathPersistence getbusinesssoppathPersistence() {
		return businesssoppathPersistence;
	}

	/**
	 * Sets the businesssoppath persistence.
	 *
	 * @param businesssoppathPersistence the businesssoppath persistence
	 */
	public void setbusinesssoppathPersistence(
		businesssoppathPersistence businesssoppathPersistence) {
		this.businesssoppathPersistence = businesssoppathPersistence;
	}

	/**
	 * Returns the businesssopusers local service.
	 *
	 * @return the businesssopusers local service
	 */
	public com.chola.business.service.businesssopusersLocalService getbusinesssopusersLocalService() {
		return businesssopusersLocalService;
	}

	/**
	 * Sets the businesssopusers local service.
	 *
	 * @param businesssopusersLocalService the businesssopusers local service
	 */
	public void setbusinesssopusersLocalService(
		com.chola.business.service.businesssopusersLocalService businesssopusersLocalService) {
		this.businesssopusersLocalService = businesssopusersLocalService;
	}

	/**
	 * Returns the businesssopusers remote service.
	 *
	 * @return the businesssopusers remote service
	 */
	public businesssopusersService getbusinesssopusersService() {
		return businesssopusersService;
	}

	/**
	 * Sets the businesssopusers remote service.
	 *
	 * @param businesssopusersService the businesssopusers remote service
	 */
	public void setbusinesssopusersService(
		businesssopusersService businesssopusersService) {
		this.businesssopusersService = businesssopusersService;
	}

	/**
	 * Returns the businesssopusers persistence.
	 *
	 * @return the businesssopusers persistence
	 */
	public businesssopusersPersistence getbusinesssopusersPersistence() {
		return businesssopusersPersistence;
	}

	/**
	 * Sets the businesssopusers persistence.
	 *
	 * @param businesssopusersPersistence the businesssopusers persistence
	 */
	public void setbusinesssopusersPersistence(
		businesssopusersPersistence businesssopusersPersistence) {
		this.businesssopusersPersistence = businesssopusersPersistence;
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
		return businesssopusersService.class.getName();
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
		return businesssopusers.class;
	}

	protected String getModelClassName() {
		return businesssopusers.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = businesssopusersPersistence.getDataSource();

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

	@BeanReference(type = com.chola.business.service.businesssopDetailsLocalService.class)
	protected com.chola.business.service.businesssopDetailsLocalService businesssopDetailsLocalService;
	@BeanReference(type = com.chola.business.service.businesssopDetailsService.class)
	protected com.chola.business.service.businesssopDetailsService businesssopDetailsService;
	@BeanReference(type = businesssopDetailsPersistence.class)
	protected businesssopDetailsPersistence businesssopDetailsPersistence;
	@BeanReference(type = businesssopDetailsFinder.class)
	protected businesssopDetailsFinder businesssopDetailsFinder;
	@BeanReference(type = com.chola.business.service.businesssoppathLocalService.class)
	protected com.chola.business.service.businesssoppathLocalService businesssoppathLocalService;
	@BeanReference(type = com.chola.business.service.businesssoppathService.class)
	protected com.chola.business.service.businesssoppathService businesssoppathService;
	@BeanReference(type = businesssoppathPersistence.class)
	protected businesssoppathPersistence businesssoppathPersistence;
	@BeanReference(type = com.chola.business.service.businesssopusersLocalService.class)
	protected com.chola.business.service.businesssopusersLocalService businesssopusersLocalService;
	@BeanReference(type = businesssopusersService.class)
	protected businesssopusersService businesssopusersService;
	@BeanReference(type = businesssopusersPersistence.class)
	protected businesssopusersPersistence businesssopusersPersistence;
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
	private businesssopusersServiceClpInvoker _clpInvoker = new businesssopusersServiceClpInvoker();
}