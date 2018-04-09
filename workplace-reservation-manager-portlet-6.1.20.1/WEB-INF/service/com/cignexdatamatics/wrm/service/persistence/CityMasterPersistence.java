/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.cignexdatamatics.wrm.service.persistence;

import com.cignexdatamatics.wrm.model.CityMaster;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the city master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CityMasterPersistenceImpl
 * @see CityMasterUtil
 * @generated
 */
public interface CityMasterPersistence extends BasePersistence<CityMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CityMasterUtil} to access the city master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the city master in the entity cache if it is enabled.
	*
	* @param cityMaster the city master
	*/
	public void cacheResult(
		com.cignexdatamatics.wrm.model.CityMaster cityMaster);

	/**
	* Caches the city masters in the entity cache if it is enabled.
	*
	* @param cityMasters the city masters
	*/
	public void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.CityMaster> cityMasters);

	/**
	* Creates a new city master with the primary key. Does not add the city master to the database.
	*
	* @param cityId the primary key for the new city master
	* @return the new city master
	*/
	public com.cignexdatamatics.wrm.model.CityMaster create(long cityId);

	/**
	* Removes the city master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cityId the primary key of the city master
	* @return the city master that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchCityMasterException if a city master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.CityMaster remove(long cityId)
		throws com.cignexdatamatics.wrm.NoSuchCityMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cignexdatamatics.wrm.model.CityMaster updateImpl(
		com.cignexdatamatics.wrm.model.CityMaster cityMaster, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the city master with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchCityMasterException} if it could not be found.
	*
	* @param cityId the primary key of the city master
	* @return the city master
	* @throws com.cignexdatamatics.wrm.NoSuchCityMasterException if a city master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.CityMaster findByPrimaryKey(
		long cityId)
		throws com.cignexdatamatics.wrm.NoSuchCityMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the city master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cityId the primary key of the city master
	* @return the city master, or <code>null</code> if a city master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.CityMaster fetchByPrimaryKey(
		long cityId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the city master where cityName = &#63; or throws a {@link com.cignexdatamatics.wrm.NoSuchCityMasterException} if it could not be found.
	*
	* @param cityName the city name
	* @return the matching city master
	* @throws com.cignexdatamatics.wrm.NoSuchCityMasterException if a matching city master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.CityMaster findByCityName(
		java.lang.String cityName)
		throws com.cignexdatamatics.wrm.NoSuchCityMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the city master where cityName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cityName the city name
	* @return the matching city master, or <code>null</code> if a matching city master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.CityMaster fetchByCityName(
		java.lang.String cityName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the city master where cityName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cityName the city name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching city master, or <code>null</code> if a matching city master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.CityMaster fetchByCityName(
		java.lang.String cityName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the city masters.
	*
	* @return the city masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.CityMaster> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the city masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of city masters
	* @param end the upper bound of the range of city masters (not inclusive)
	* @return the range of city masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.CityMaster> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the city masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of city masters
	* @param end the upper bound of the range of city masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of city masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cignexdatamatics.wrm.model.CityMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the city master where cityName = &#63; from the database.
	*
	* @param cityName the city name
	* @return the city master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cignexdatamatics.wrm.model.CityMaster removeByCityName(
		java.lang.String cityName)
		throws com.cignexdatamatics.wrm.NoSuchCityMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the city masters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of city masters where cityName = &#63;.
	*
	* @param cityName the city name
	* @return the number of matching city masters
	* @throws SystemException if a system exception occurred
	*/
	public int countByCityName(java.lang.String cityName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of city masters.
	*
	* @return the number of city masters
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}