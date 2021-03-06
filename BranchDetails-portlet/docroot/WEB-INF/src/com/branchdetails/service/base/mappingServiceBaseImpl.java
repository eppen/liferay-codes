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

package com.branchdetails.service.base;

import com.branchdetails.model.mapping;

import com.branchdetails.service.mappingService;
import com.branchdetails.service.persistence.branchdetailsPersistence;
import com.branchdetails.service.persistence.cityPersistence;
import com.branchdetails.service.persistence.mappingPersistence;
import com.branchdetails.service.persistence.productFinder;
import com.branchdetails.service.persistence.productPersistence;
import com.branchdetails.service.persistence.statePersistence;

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
 * Provides the base implementation for the mapping remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.branchdetails.service.impl.mappingServiceImpl}.
 * </p>
 *
 * @author adms.java1
 * @see com.branchdetails.service.impl.mappingServiceImpl
 * @see com.branchdetails.service.mappingServiceUtil
 * @generated
 */
public abstract class mappingServiceBaseImpl extends BaseServiceImpl
	implements mappingService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.branchdetails.service.mappingServiceUtil} to access the mapping remote service.
	 */

	/**
	 * Returns the branchdetails local service.
	 *
	 * @return the branchdetails local service
	 */
	public com.branchdetails.service.branchdetailsLocalService getbranchdetailsLocalService() {
		return branchdetailsLocalService;
	}

	/**
	 * Sets the branchdetails local service.
	 *
	 * @param branchdetailsLocalService the branchdetails local service
	 */
	public void setbranchdetailsLocalService(
		com.branchdetails.service.branchdetailsLocalService branchdetailsLocalService) {
		this.branchdetailsLocalService = branchdetailsLocalService;
	}

	/**
	 * Returns the branchdetails remote service.
	 *
	 * @return the branchdetails remote service
	 */
	public com.branchdetails.service.branchdetailsService getbranchdetailsService() {
		return branchdetailsService;
	}

	/**
	 * Sets the branchdetails remote service.
	 *
	 * @param branchdetailsService the branchdetails remote service
	 */
	public void setbranchdetailsService(
		com.branchdetails.service.branchdetailsService branchdetailsService) {
		this.branchdetailsService = branchdetailsService;
	}

	/**
	 * Returns the branchdetails persistence.
	 *
	 * @return the branchdetails persistence
	 */
	public branchdetailsPersistence getbranchdetailsPersistence() {
		return branchdetailsPersistence;
	}

	/**
	 * Sets the branchdetails persistence.
	 *
	 * @param branchdetailsPersistence the branchdetails persistence
	 */
	public void setbranchdetailsPersistence(
		branchdetailsPersistence branchdetailsPersistence) {
		this.branchdetailsPersistence = branchdetailsPersistence;
	}

	/**
	 * Returns the city local service.
	 *
	 * @return the city local service
	 */
	public com.branchdetails.service.cityLocalService getcityLocalService() {
		return cityLocalService;
	}

	/**
	 * Sets the city local service.
	 *
	 * @param cityLocalService the city local service
	 */
	public void setcityLocalService(
		com.branchdetails.service.cityLocalService cityLocalService) {
		this.cityLocalService = cityLocalService;
	}

	/**
	 * Returns the city remote service.
	 *
	 * @return the city remote service
	 */
	public com.branchdetails.service.cityService getcityService() {
		return cityService;
	}

	/**
	 * Sets the city remote service.
	 *
	 * @param cityService the city remote service
	 */
	public void setcityService(
		com.branchdetails.service.cityService cityService) {
		this.cityService = cityService;
	}

	/**
	 * Returns the city persistence.
	 *
	 * @return the city persistence
	 */
	public cityPersistence getcityPersistence() {
		return cityPersistence;
	}

	/**
	 * Sets the city persistence.
	 *
	 * @param cityPersistence the city persistence
	 */
	public void setcityPersistence(cityPersistence cityPersistence) {
		this.cityPersistence = cityPersistence;
	}

	/**
	 * Returns the mapping local service.
	 *
	 * @return the mapping local service
	 */
	public com.branchdetails.service.mappingLocalService getmappingLocalService() {
		return mappingLocalService;
	}

	/**
	 * Sets the mapping local service.
	 *
	 * @param mappingLocalService the mapping local service
	 */
	public void setmappingLocalService(
		com.branchdetails.service.mappingLocalService mappingLocalService) {
		this.mappingLocalService = mappingLocalService;
	}

	/**
	 * Returns the mapping remote service.
	 *
	 * @return the mapping remote service
	 */
	public mappingService getmappingService() {
		return mappingService;
	}

	/**
	 * Sets the mapping remote service.
	 *
	 * @param mappingService the mapping remote service
	 */
	public void setmappingService(mappingService mappingService) {
		this.mappingService = mappingService;
	}

	/**
	 * Returns the mapping persistence.
	 *
	 * @return the mapping persistence
	 */
	public mappingPersistence getmappingPersistence() {
		return mappingPersistence;
	}

	/**
	 * Sets the mapping persistence.
	 *
	 * @param mappingPersistence the mapping persistence
	 */
	public void setmappingPersistence(mappingPersistence mappingPersistence) {
		this.mappingPersistence = mappingPersistence;
	}

	/**
	 * Returns the product local service.
	 *
	 * @return the product local service
	 */
	public com.branchdetails.service.productLocalService getproductLocalService() {
		return productLocalService;
	}

	/**
	 * Sets the product local service.
	 *
	 * @param productLocalService the product local service
	 */
	public void setproductLocalService(
		com.branchdetails.service.productLocalService productLocalService) {
		this.productLocalService = productLocalService;
	}

	/**
	 * Returns the product remote service.
	 *
	 * @return the product remote service
	 */
	public com.branchdetails.service.productService getproductService() {
		return productService;
	}

	/**
	 * Sets the product remote service.
	 *
	 * @param productService the product remote service
	 */
	public void setproductService(
		com.branchdetails.service.productService productService) {
		this.productService = productService;
	}

	/**
	 * Returns the product persistence.
	 *
	 * @return the product persistence
	 */
	public productPersistence getproductPersistence() {
		return productPersistence;
	}

	/**
	 * Sets the product persistence.
	 *
	 * @param productPersistence the product persistence
	 */
	public void setproductPersistence(productPersistence productPersistence) {
		this.productPersistence = productPersistence;
	}

	/**
	 * Returns the product finder.
	 *
	 * @return the product finder
	 */
	public productFinder getproductFinder() {
		return productFinder;
	}

	/**
	 * Sets the product finder.
	 *
	 * @param productFinder the product finder
	 */
	public void setproductFinder(productFinder productFinder) {
		this.productFinder = productFinder;
	}

	/**
	 * Returns the state local service.
	 *
	 * @return the state local service
	 */
	public com.branchdetails.service.stateLocalService getstateLocalService() {
		return stateLocalService;
	}

	/**
	 * Sets the state local service.
	 *
	 * @param stateLocalService the state local service
	 */
	public void setstateLocalService(
		com.branchdetails.service.stateLocalService stateLocalService) {
		this.stateLocalService = stateLocalService;
	}

	/**
	 * Returns the state remote service.
	 *
	 * @return the state remote service
	 */
	public com.branchdetails.service.stateService getstateService() {
		return stateService;
	}

	/**
	 * Sets the state remote service.
	 *
	 * @param stateService the state remote service
	 */
	public void setstateService(
		com.branchdetails.service.stateService stateService) {
		this.stateService = stateService;
	}

	/**
	 * Returns the state persistence.
	 *
	 * @return the state persistence
	 */
	public statePersistence getstatePersistence() {
		return statePersistence;
	}

	/**
	 * Sets the state persistence.
	 *
	 * @param statePersistence the state persistence
	 */
	public void setstatePersistence(statePersistence statePersistence) {
		this.statePersistence = statePersistence;
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
		return mappingService.class.getName();
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
		return mapping.class;
	}

	protected String getModelClassName() {
		return mapping.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = mappingPersistence.getDataSource();

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

	@BeanReference(type = com.branchdetails.service.branchdetailsLocalService.class)
	protected com.branchdetails.service.branchdetailsLocalService branchdetailsLocalService;
	@BeanReference(type = com.branchdetails.service.branchdetailsService.class)
	protected com.branchdetails.service.branchdetailsService branchdetailsService;
	@BeanReference(type = branchdetailsPersistence.class)
	protected branchdetailsPersistence branchdetailsPersistence;
	@BeanReference(type = com.branchdetails.service.cityLocalService.class)
	protected com.branchdetails.service.cityLocalService cityLocalService;
	@BeanReference(type = com.branchdetails.service.cityService.class)
	protected com.branchdetails.service.cityService cityService;
	@BeanReference(type = cityPersistence.class)
	protected cityPersistence cityPersistence;
	@BeanReference(type = com.branchdetails.service.mappingLocalService.class)
	protected com.branchdetails.service.mappingLocalService mappingLocalService;
	@BeanReference(type = mappingService.class)
	protected mappingService mappingService;
	@BeanReference(type = mappingPersistence.class)
	protected mappingPersistence mappingPersistence;
	@BeanReference(type = com.branchdetails.service.productLocalService.class)
	protected com.branchdetails.service.productLocalService productLocalService;
	@BeanReference(type = com.branchdetails.service.productService.class)
	protected com.branchdetails.service.productService productService;
	@BeanReference(type = productPersistence.class)
	protected productPersistence productPersistence;
	@BeanReference(type = productFinder.class)
	protected productFinder productFinder;
	@BeanReference(type = com.branchdetails.service.stateLocalService.class)
	protected com.branchdetails.service.stateLocalService stateLocalService;
	@BeanReference(type = com.branchdetails.service.stateService.class)
	protected com.branchdetails.service.stateService stateService;
	@BeanReference(type = statePersistence.class)
	protected statePersistence statePersistence;
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
	private mappingServiceClpInvoker _clpInvoker = new mappingServiceClpInvoker();
}