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

package com.chola.topsearch.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TopSearchLocalService}.
 *
 * @author adms.java1
 * @see TopSearchLocalService
 * @generated
 */
@ProviderType
public class TopSearchLocalServiceWrapper implements TopSearchLocalService,
	ServiceWrapper<TopSearchLocalService> {
	public TopSearchLocalServiceWrapper(
		TopSearchLocalService topSearchLocalService) {
		_topSearchLocalService = topSearchLocalService;
	}

	/**
	* Adds the top search to the database. Also notifies the appropriate model listeners.
	*
	* @param topSearch the top search
	* @return the top search that was added
	*/
	@Override
	public com.chola.topsearch.model.TopSearch addTopSearch(
		com.chola.topsearch.model.TopSearch topSearch) {
		return _topSearchLocalService.addTopSearch(topSearch);
	}

	/**
	* Creates a new top search with the primary key. Does not add the top search to the database.
	*
	* @param srchId the primary key for the new top search
	* @return the new top search
	*/
	@Override
	public com.chola.topsearch.model.TopSearch createTopSearch(long srchId) {
		return _topSearchLocalService.createTopSearch(srchId);
	}

	/**
	* Deletes the top search from the database. Also notifies the appropriate model listeners.
	*
	* @param topSearch the top search
	* @return the top search that was removed
	*/
	@Override
	public com.chola.topsearch.model.TopSearch deleteTopSearch(
		com.chola.topsearch.model.TopSearch topSearch) {
		return _topSearchLocalService.deleteTopSearch(topSearch);
	}

	/**
	* Deletes the top search with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param srchId the primary key of the top search
	* @return the top search that was removed
	* @throws PortalException if a top search with the primary key could not be found
	*/
	@Override
	public com.chola.topsearch.model.TopSearch deleteTopSearch(long srchId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topSearchLocalService.deleteTopSearch(srchId);
	}

	@Override
	public com.chola.topsearch.model.TopSearch fetchTopSearch(long srchId) {
		return _topSearchLocalService.fetchTopSearch(srchId);
	}

	/**
	* Returns the top search with the primary key.
	*
	* @param srchId the primary key of the top search
	* @return the top search
	* @throws PortalException if a top search with the primary key could not be found
	*/
	@Override
	public com.chola.topsearch.model.TopSearch getTopSearch(long srchId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topSearchLocalService.getTopSearch(srchId);
	}

	/**
	* Updates the top search in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param topSearch the top search
	* @return the top search that was updated
	*/
	@Override
	public com.chola.topsearch.model.TopSearch updateTopSearch(
		com.chola.topsearch.model.TopSearch topSearch) {
		return _topSearchLocalService.updateTopSearch(topSearch);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _topSearchLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _topSearchLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _topSearchLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topSearchLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topSearchLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of top searchs.
	*
	* @return the number of top searchs
	*/
	@Override
	public int getTopSearchsCount() {
		return _topSearchLocalService.getTopSearchsCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _topSearchLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _topSearchLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _topSearchLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.topsearch.model.impl.TopSearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _topSearchLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.topsearch.model.impl.TopSearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _topSearchLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the top searchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.topsearch.model.impl.TopSearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of top searchs
	* @param end the upper bound of the range of top searchs (not inclusive)
	* @return the range of top searchs
	*/
	@Override
	public java.util.List<com.chola.topsearch.model.TopSearch> getTopSearchs(
		int start, int end) {
		return _topSearchLocalService.getTopSearchs(start, end);
	}

	@Override
	public java.util.List<java.lang.Object[]> gettoplinks() {
		return _topSearchLocalService.gettoplinks();
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _topSearchLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _topSearchLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public TopSearchLocalService getWrappedService() {
		return _topSearchLocalService;
	}

	@Override
	public void setWrappedService(TopSearchLocalService topSearchLocalService) {
		_topSearchLocalService = topSearchLocalService;
	}

	private TopSearchLocalService _topSearchLocalService;
}