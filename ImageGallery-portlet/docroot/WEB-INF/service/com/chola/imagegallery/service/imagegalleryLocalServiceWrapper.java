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

package com.chola.imagegallery.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link imagegalleryLocalService}.
 *
 * @author CloverLiferay02
 * @see imagegalleryLocalService
 * @generated
 */
@ProviderType
public class imagegalleryLocalServiceWrapper implements imagegalleryLocalService,
	ServiceWrapper<imagegalleryLocalService> {
	public imagegalleryLocalServiceWrapper(
		imagegalleryLocalService imagegalleryLocalService) {
		_imagegalleryLocalService = imagegalleryLocalService;
	}

	/**
	* Adds the imagegallery to the database. Also notifies the appropriate model listeners.
	*
	* @param imagegallery the imagegallery
	* @return the imagegallery that was added
	*/
	@Override
	public com.chola.imagegallery.model.imagegallery addimagegallery(
		com.chola.imagegallery.model.imagegallery imagegallery) {
		return _imagegalleryLocalService.addimagegallery(imagegallery);
	}

	/**
	* Creates a new imagegallery with the primary key. Does not add the imagegallery to the database.
	*
	* @param id the primary key for the new imagegallery
	* @return the new imagegallery
	*/
	@Override
	public com.chola.imagegallery.model.imagegallery createimagegallery(long id) {
		return _imagegalleryLocalService.createimagegallery(id);
	}

	/**
	* Deletes the imagegallery from the database. Also notifies the appropriate model listeners.
	*
	* @param imagegallery the imagegallery
	* @return the imagegallery that was removed
	*/
	@Override
	public com.chola.imagegallery.model.imagegallery deleteimagegallery(
		com.chola.imagegallery.model.imagegallery imagegallery) {
		return _imagegalleryLocalService.deleteimagegallery(imagegallery);
	}

	/**
	* Deletes the imagegallery with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the imagegallery
	* @return the imagegallery that was removed
	* @throws PortalException if a imagegallery with the primary key could not be found
	*/
	@Override
	public com.chola.imagegallery.model.imagegallery deleteimagegallery(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _imagegalleryLocalService.deleteimagegallery(id);
	}

	@Override
	public com.chola.imagegallery.model.imagegallery fetchimagegallery(long id) {
		return _imagegalleryLocalService.fetchimagegallery(id);
	}

	/**
	* Returns the imagegallery with the primary key.
	*
	* @param id the primary key of the imagegallery
	* @return the imagegallery
	* @throws PortalException if a imagegallery with the primary key could not be found
	*/
	@Override
	public com.chola.imagegallery.model.imagegallery getimagegallery(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _imagegalleryLocalService.getimagegallery(id);
	}

	/**
	* Updates the imagegallery in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param imagegallery the imagegallery
	* @return the imagegallery that was updated
	*/
	@Override
	public com.chola.imagegallery.model.imagegallery updateimagegallery(
		com.chola.imagegallery.model.imagegallery imagegallery) {
		return _imagegalleryLocalService.updateimagegallery(imagegallery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _imagegalleryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _imagegalleryLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _imagegalleryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _imagegalleryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _imagegalleryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of imagegalleries.
	*
	* @return the number of imagegalleries
	*/
	@Override
	public int getimagegalleriesCount() {
		return _imagegalleryLocalService.getimagegalleriesCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _imagegalleryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _imagegalleryLocalService.getOSGiServiceIdentifier();
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
		return _imagegalleryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.imagegallery.model.impl.imagegalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _imagegalleryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.imagegallery.model.impl.imagegalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _imagegalleryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the imagegalleries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.imagegallery.model.impl.imagegalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of imagegalleries
	* @param end the upper bound of the range of imagegalleries (not inclusive)
	* @return the range of imagegalleries
	*/
	@Override
	public java.util.List<com.chola.imagegallery.model.imagegallery> getimagegalleries(
		int start, int end) {
		return _imagegalleryLocalService.getimagegalleries(start, end);
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
		return _imagegalleryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _imagegalleryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public imagegalleryLocalService getWrappedService() {
		return _imagegalleryLocalService;
	}

	@Override
	public void setWrappedService(
		imagegalleryLocalService imagegalleryLocalService) {
		_imagegalleryLocalService = imagegalleryLocalService;
	}

	private imagegalleryLocalService _imagegalleryLocalService;
}