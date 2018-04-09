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

package com.chola.videogallery.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.chola.videogallery.model.videogallery;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the videogallery service. This utility wraps {@link com.chola.videogallery.service.persistence.impl.videogalleryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CloverLiferay02
 * @see videogalleryPersistence
 * @see com.chola.videogallery.service.persistence.impl.videogalleryPersistenceImpl
 * @generated
 */
@ProviderType
public class videogalleryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(videogallery videogallery) {
		getPersistence().clearCache(videogallery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<videogallery> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<videogallery> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<videogallery> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<videogallery> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static videogallery update(videogallery videogallery) {
		return getPersistence().update(videogallery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static videogallery update(videogallery videogallery,
		ServiceContext serviceContext) {
		return getPersistence().update(videogallery, serviceContext);
	}

	/**
	* Caches the videogallery in the entity cache if it is enabled.
	*
	* @param videogallery the videogallery
	*/
	public static void cacheResult(videogallery videogallery) {
		getPersistence().cacheResult(videogallery);
	}

	/**
	* Caches the videogalleries in the entity cache if it is enabled.
	*
	* @param videogalleries the videogalleries
	*/
	public static void cacheResult(List<videogallery> videogalleries) {
		getPersistence().cacheResult(videogalleries);
	}

	/**
	* Creates a new videogallery with the primary key. Does not add the videogallery to the database.
	*
	* @param id the primary key for the new videogallery
	* @return the new videogallery
	*/
	public static videogallery create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the videogallery with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the videogallery
	* @return the videogallery that was removed
	* @throws NoSuchvideogalleryException if a videogallery with the primary key could not be found
	*/
	public static videogallery remove(long id)
		throws com.chola.videogallery.exception.NoSuchvideogalleryException {
		return getPersistence().remove(id);
	}

	public static videogallery updateImpl(videogallery videogallery) {
		return getPersistence().updateImpl(videogallery);
	}

	/**
	* Returns the videogallery with the primary key or throws a {@link NoSuchvideogalleryException} if it could not be found.
	*
	* @param id the primary key of the videogallery
	* @return the videogallery
	* @throws NoSuchvideogalleryException if a videogallery with the primary key could not be found
	*/
	public static videogallery findByPrimaryKey(long id)
		throws com.chola.videogallery.exception.NoSuchvideogalleryException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the videogallery with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the videogallery
	* @return the videogallery, or <code>null</code> if a videogallery with the primary key could not be found
	*/
	public static videogallery fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, videogallery> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the videogalleries.
	*
	* @return the videogalleries
	*/
	public static List<videogallery> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the videogalleries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link videogalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videogalleries
	* @param end the upper bound of the range of videogalleries (not inclusive)
	* @return the range of videogalleries
	*/
	public static List<videogallery> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the videogalleries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link videogalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videogalleries
	* @param end the upper bound of the range of videogalleries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of videogalleries
	*/
	public static List<videogallery> findAll(int start, int end,
		OrderByComparator<videogallery> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the videogalleries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link videogalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videogalleries
	* @param end the upper bound of the range of videogalleries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of videogalleries
	*/
	public static List<videogallery> findAll(int start, int end,
		OrderByComparator<videogallery> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the videogalleries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of videogalleries.
	*
	* @return the number of videogalleries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static videogalleryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (videogalleryPersistence)PortletBeanLocatorUtil.locate(com.chola.videogallery.service.ClpSerializer.getServletContextName(),
					videogalleryPersistence.class.getName());

			ReferenceRegistry.registerReference(videogalleryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static videogalleryPersistence _persistence;
}