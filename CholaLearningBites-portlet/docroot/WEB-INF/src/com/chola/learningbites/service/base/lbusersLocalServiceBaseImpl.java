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

package com.chola.learningbites.service.base;

import aQute.bnd.annotation.ProviderType;

import com.chola.learningbites.model.lbusers;
import com.chola.learningbites.service.lbusersLocalService;
import com.chola.learningbites.service.persistence.lbdetailsFinder;
import com.chola.learningbites.service.persistence.lbdetailsPersistence;
import com.chola.learningbites.service.persistence.lbusersPersistence;

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
 * Provides the base implementation for the lbusers local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.chola.learningbites.service.impl.lbusersLocalServiceImpl}.
 * </p>
 *
 * @author cloverliferay01
 * @see com.chola.learningbites.service.impl.lbusersLocalServiceImpl
 * @see com.chola.learningbites.service.lbusersLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class lbusersLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements lbusersLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.chola.learningbites.service.lbusersLocalServiceUtil} to access the lbusers local service.
	 */

	/**
	 * Adds the lbusers to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lbusers the lbusers
	 * @return the lbusers that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public lbusers addlbusers(lbusers lbusers) {
		lbusers.setNew(true);

		return lbusersPersistence.update(lbusers);
	}

	/**
	 * Creates a new lbusers with the primary key. Does not add the lbusers to the database.
	 *
	 * @param id the primary key for the new lbusers
	 * @return the new lbusers
	 */
	@Override
	public lbusers createlbusers(long id) {
		return lbusersPersistence.create(id);
	}

	/**
	 * Deletes the lbusers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the lbusers
	 * @return the lbusers that was removed
	 * @throws PortalException if a lbusers with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public lbusers deletelbusers(long id) throws PortalException {
		return lbusersPersistence.remove(id);
	}

	/**
	 * Deletes the lbusers from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lbusers the lbusers
	 * @return the lbusers that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public lbusers deletelbusers(lbusers lbusers) {
		return lbusersPersistence.remove(lbusers);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(lbusers.class,
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
		return lbusersPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.learningbites.model.impl.lbusersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return lbusersPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.learningbites.model.impl.lbusersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return lbusersPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return lbusersPersistence.countWithDynamicQuery(dynamicQuery);
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
		return lbusersPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public lbusers fetchlbusers(long id) {
		return lbusersPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the lbusers with the primary key.
	 *
	 * @param id the primary key of the lbusers
	 * @return the lbusers
	 * @throws PortalException if a lbusers with the primary key could not be found
	 */
	@Override
	public lbusers getlbusers(long id) throws PortalException {
		return lbusersPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(lbusersLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(lbusers.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(lbusersLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(lbusers.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(lbusersLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(lbusers.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return lbusersLocalService.deletelbusers((lbusers)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return lbusersPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the lbuserses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.learningbites.model.impl.lbusersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lbuserses
	 * @param end the upper bound of the range of lbuserses (not inclusive)
	 * @return the range of lbuserses
	 */
	@Override
	public List<lbusers> getlbuserses(int start, int end) {
		return lbusersPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of lbuserses.
	 *
	 * @return the number of lbuserses
	 */
	@Override
	public int getlbusersesCount() {
		return lbusersPersistence.countAll();
	}

	/**
	 * Updates the lbusers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lbusers the lbusers
	 * @return the lbusers that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public lbusers updatelbusers(lbusers lbusers) {
		return lbusersPersistence.update(lbusers);
	}

	/**
	 * Returns the lbdetails local service.
	 *
	 * @return the lbdetails local service
	 */
	public com.chola.learningbites.service.lbdetailsLocalService getlbdetailsLocalService() {
		return lbdetailsLocalService;
	}

	/**
	 * Sets the lbdetails local service.
	 *
	 * @param lbdetailsLocalService the lbdetails local service
	 */
	public void setlbdetailsLocalService(
		com.chola.learningbites.service.lbdetailsLocalService lbdetailsLocalService) {
		this.lbdetailsLocalService = lbdetailsLocalService;
	}

	/**
	 * Returns the lbdetails persistence.
	 *
	 * @return the lbdetails persistence
	 */
	public lbdetailsPersistence getlbdetailsPersistence() {
		return lbdetailsPersistence;
	}

	/**
	 * Sets the lbdetails persistence.
	 *
	 * @param lbdetailsPersistence the lbdetails persistence
	 */
	public void setlbdetailsPersistence(
		lbdetailsPersistence lbdetailsPersistence) {
		this.lbdetailsPersistence = lbdetailsPersistence;
	}

	/**
	 * Returns the lbdetails finder.
	 *
	 * @return the lbdetails finder
	 */
	public lbdetailsFinder getlbdetailsFinder() {
		return lbdetailsFinder;
	}

	/**
	 * Sets the lbdetails finder.
	 *
	 * @param lbdetailsFinder the lbdetails finder
	 */
	public void setlbdetailsFinder(lbdetailsFinder lbdetailsFinder) {
		this.lbdetailsFinder = lbdetailsFinder;
	}

	/**
	 * Returns the lbusers local service.
	 *
	 * @return the lbusers local service
	 */
	public lbusersLocalService getlbusersLocalService() {
		return lbusersLocalService;
	}

	/**
	 * Sets the lbusers local service.
	 *
	 * @param lbusersLocalService the lbusers local service
	 */
	public void setlbusersLocalService(lbusersLocalService lbusersLocalService) {
		this.lbusersLocalService = lbusersLocalService;
	}

	/**
	 * Returns the lbusers persistence.
	 *
	 * @return the lbusers persistence
	 */
	public lbusersPersistence getlbusersPersistence() {
		return lbusersPersistence;
	}

	/**
	 * Sets the lbusers persistence.
	 *
	 * @param lbusersPersistence the lbusers persistence
	 */
	public void setlbusersPersistence(lbusersPersistence lbusersPersistence) {
		this.lbusersPersistence = lbusersPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.chola.learningbites.model.lbusers",
			lbusersLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.chola.learningbites.model.lbusers");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return lbusersLocalService.class.getName();
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
		return lbusers.class;
	}

	protected String getModelClassName() {
		return lbusers.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = lbusersPersistence.getDataSource();

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

	@BeanReference(type = com.chola.learningbites.service.lbdetailsLocalService.class)
	protected com.chola.learningbites.service.lbdetailsLocalService lbdetailsLocalService;
	@BeanReference(type = lbdetailsPersistence.class)
	protected lbdetailsPersistence lbdetailsPersistence;
	@BeanReference(type = lbdetailsFinder.class)
	protected lbdetailsFinder lbdetailsFinder;
	@BeanReference(type = lbusersLocalService.class)
	protected lbusersLocalService lbusersLocalService;
	@BeanReference(type = lbusersPersistence.class)
	protected lbusersPersistence lbusersPersistence;
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
	private lbusersLocalServiceClpInvoker _clpInvoker = new lbusersLocalServiceClpInvoker();
}