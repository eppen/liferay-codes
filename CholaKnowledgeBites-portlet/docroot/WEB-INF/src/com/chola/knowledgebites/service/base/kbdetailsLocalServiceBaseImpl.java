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

import aQute.bnd.annotation.ProviderType;

import com.chola.knowledgebites.model.kbdetails;
import com.chola.knowledgebites.service.kbdetailsLocalService;
import com.chola.knowledgebites.service.persistence.kbdetailsFinder;
import com.chola.knowledgebites.service.persistence.kbdetailsPersistence;
import com.chola.knowledgebites.service.persistence.kbpathPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the kbdetails local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.chola.knowledgebites.service.impl.kbdetailsLocalServiceImpl}.
 * </p>
 *
 * @author cloverliferay01
 * @see com.chola.knowledgebites.service.impl.kbdetailsLocalServiceImpl
 * @see com.chola.knowledgebites.service.kbdetailsLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class kbdetailsLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements kbdetailsLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.chola.knowledgebites.service.kbdetailsLocalServiceUtil} to access the kbdetails local service.
	 */

	/**
	 * Adds the kbdetails to the database. Also notifies the appropriate model listeners.
	 *
	 * @param kbdetails the kbdetails
	 * @return the kbdetails that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public kbdetails addkbdetails(kbdetails kbdetails) {
		kbdetails.setNew(true);

		return kbdetailsPersistence.update(kbdetails);
	}

	/**
	 * Creates a new kbdetails with the primary key. Does not add the kbdetails to the database.
	 *
	 * @param id the primary key for the new kbdetails
	 * @return the new kbdetails
	 */
	@Override
	public kbdetails createkbdetails(long id) {
		return kbdetailsPersistence.create(id);
	}

	/**
	 * Deletes the kbdetails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the kbdetails
	 * @return the kbdetails that was removed
	 * @throws PortalException if a kbdetails with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public kbdetails deletekbdetails(long id) throws PortalException {
		return kbdetailsPersistence.remove(id);
	}

	/**
	 * Deletes the kbdetails from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kbdetails the kbdetails
	 * @return the kbdetails that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public kbdetails deletekbdetails(kbdetails kbdetails) {
		return kbdetailsPersistence.remove(kbdetails);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(kbdetails.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return kbdetailsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.knowledgebites.model.impl.kbdetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return kbdetailsPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.knowledgebites.model.impl.kbdetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return kbdetailsPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return kbdetailsPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return kbdetailsPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public kbdetails fetchkbdetails(long id) {
		return kbdetailsPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the kbdetails with the primary key.
	 *
	 * @param id the primary key of the kbdetails
	 * @return the kbdetails
	 * @throws PortalException if a kbdetails with the primary key could not be found
	 */
	@Override
	public kbdetails getkbdetails(long id) throws PortalException {
		return kbdetailsPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(kbdetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(kbdetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(kbdetailsLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(kbdetails.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(kbdetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(kbdetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return kbdetailsLocalService.deletekbdetails((kbdetails)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return kbdetailsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the kbdetailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.knowledgebites.model.impl.kbdetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kbdetailses
	 * @param end the upper bound of the range of kbdetailses (not inclusive)
	 * @return the range of kbdetailses
	 */
	@Override
	public List<kbdetails> getkbdetailses(int start, int end) {
		return kbdetailsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of kbdetailses.
	 *
	 * @return the number of kbdetailses
	 */
	@Override
	public int getkbdetailsesCount() {
		return kbdetailsPersistence.countAll();
	}

	/**
	 * Updates the kbdetails in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param kbdetails the kbdetails
	 * @return the kbdetails that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public kbdetails updatekbdetails(kbdetails kbdetails) {
		return kbdetailsPersistence.update(kbdetails);
	}

	/**
	 * Returns the kbdetails local service.
	 *
	 * @return the kbdetails local service
	 */
	public kbdetailsLocalService getkbdetailsLocalService() {
		return kbdetailsLocalService;
	}

	/**
	 * Sets the kbdetails local service.
	 *
	 * @param kbdetailsLocalService the kbdetails local service
	 */
	public void setkbdetailsLocalService(
		kbdetailsLocalService kbdetailsLocalService) {
		this.kbdetailsLocalService = kbdetailsLocalService;
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

		PersistedModelLocalServiceRegistryUtil.register("com.chola.knowledgebites.model.kbdetails",
			kbdetailsLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.chola.knowledgebites.model.kbdetails");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return kbdetailsLocalService.class.getName();
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
		return kbdetails.class;
	}

	protected String getModelClassName() {
		return kbdetails.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = kbdetailsPersistence.getDataSource();

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

	@BeanReference(type = kbdetailsLocalService.class)
	protected kbdetailsLocalService kbdetailsLocalService;
	@BeanReference(type = kbdetailsPersistence.class)
	protected kbdetailsPersistence kbdetailsPersistence;
	@BeanReference(type = kbdetailsFinder.class)
	protected kbdetailsFinder kbdetailsFinder;
	@BeanReference(type = com.chola.knowledgebites.service.kbpathLocalService.class)
	protected com.chola.knowledgebites.service.kbpathLocalService kbpathLocalService;
	@BeanReference(type = kbpathPersistence.class)
	protected kbpathPersistence kbpathPersistence;
	@BeanReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private ClassLoader _classLoader;
	private kbdetailsLocalServiceClpInvoker _clpInvoker = new kbdetailsLocalServiceClpInvoker();
}