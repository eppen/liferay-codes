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

import aQute.bnd.annotation.ProviderType;

import com.branchdetails.model.state;

import com.branchdetails.service.persistence.branchdetailsPersistence;
import com.branchdetails.service.persistence.cityPersistence;
import com.branchdetails.service.persistence.mappingPersistence;
import com.branchdetails.service.persistence.productFinder;
import com.branchdetails.service.persistence.productPersistence;
import com.branchdetails.service.persistence.statePersistence;
import com.branchdetails.service.stateLocalService;

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
 * Provides the base implementation for the state local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.branchdetails.service.impl.stateLocalServiceImpl}.
 * </p>
 *
 * @author adms.java1
 * @see com.branchdetails.service.impl.stateLocalServiceImpl
 * @see com.branchdetails.service.stateLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class stateLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements stateLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.branchdetails.service.stateLocalServiceUtil} to access the state local service.
	 */

	/**
	 * Adds the state to the database. Also notifies the appropriate model listeners.
	 *
	 * @param state the state
	 * @return the state that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public state addstate(state state) {
		state.setNew(true);

		return statePersistence.update(state);
	}

	/**
	 * Creates a new state with the primary key. Does not add the state to the database.
	 *
	 * @param state_id the primary key for the new state
	 * @return the new state
	 */
	@Override
	public state createstate(long state_id) {
		return statePersistence.create(state_id);
	}

	/**
	 * Deletes the state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param state_id the primary key of the state
	 * @return the state that was removed
	 * @throws PortalException if a state with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public state deletestate(long state_id) throws PortalException {
		return statePersistence.remove(state_id);
	}

	/**
	 * Deletes the state from the database. Also notifies the appropriate model listeners.
	 *
	 * @param state the state
	 * @return the state that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public state deletestate(state state) {
		return statePersistence.remove(state);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(state.class,
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
		return statePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.branchdetails.model.impl.stateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return statePersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.branchdetails.model.impl.stateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return statePersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return statePersistence.countWithDynamicQuery(dynamicQuery);
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
		return statePersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public state fetchstate(long state_id) {
		return statePersistence.fetchByPrimaryKey(state_id);
	}

	/**
	 * Returns the state with the primary key.
	 *
	 * @param state_id the primary key of the state
	 * @return the state
	 * @throws PortalException if a state with the primary key could not be found
	 */
	@Override
	public state getstate(long state_id) throws PortalException {
		return statePersistence.findByPrimaryKey(state_id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(stateLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(state.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("state_id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(stateLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(state.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("state_id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(stateLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(state.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("state_id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return stateLocalService.deletestate((state)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return statePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.branchdetails.model.impl.stateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @return the range of states
	 */
	@Override
	public List<state> getstates(int start, int end) {
		return statePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of states.
	 *
	 * @return the number of states
	 */
	@Override
	public int getstatesCount() {
		return statePersistence.countAll();
	}

	/**
	 * Updates the state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param state the state
	 * @return the state that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public state updatestate(state state) {
		return statePersistence.update(state);
	}

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
	public stateLocalService getstateLocalService() {
		return stateLocalService;
	}

	/**
	 * Sets the state local service.
	 *
	 * @param stateLocalService the state local service
	 */
	public void setstateLocalService(stateLocalService stateLocalService) {
		this.stateLocalService = stateLocalService;
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

		PersistedModelLocalServiceRegistryUtil.register("com.branchdetails.model.state",
			stateLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.branchdetails.model.state");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return stateLocalService.class.getName();
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
		return state.class;
	}

	protected String getModelClassName() {
		return state.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = statePersistence.getDataSource();

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
	@BeanReference(type = branchdetailsPersistence.class)
	protected branchdetailsPersistence branchdetailsPersistence;
	@BeanReference(type = com.branchdetails.service.cityLocalService.class)
	protected com.branchdetails.service.cityLocalService cityLocalService;
	@BeanReference(type = cityPersistence.class)
	protected cityPersistence cityPersistence;
	@BeanReference(type = com.branchdetails.service.mappingLocalService.class)
	protected com.branchdetails.service.mappingLocalService mappingLocalService;
	@BeanReference(type = mappingPersistence.class)
	protected mappingPersistence mappingPersistence;
	@BeanReference(type = com.branchdetails.service.productLocalService.class)
	protected com.branchdetails.service.productLocalService productLocalService;
	@BeanReference(type = productPersistence.class)
	protected productPersistence productPersistence;
	@BeanReference(type = productFinder.class)
	protected productFinder productFinder;
	@BeanReference(type = stateLocalService.class)
	protected stateLocalService stateLocalService;
	@BeanReference(type = statePersistence.class)
	protected statePersistence statePersistence;
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
	private stateLocalServiceClpInvoker _clpInvoker = new stateLocalServiceClpInvoker();
}