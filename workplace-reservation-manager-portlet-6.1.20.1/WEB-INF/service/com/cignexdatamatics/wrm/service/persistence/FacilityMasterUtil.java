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

import com.cignexdatamatics.wrm.model.FacilityMaster;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the facility master service. This utility wraps {@link FacilityMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacilityMasterPersistence
 * @see FacilityMasterPersistenceImpl
 * @generated
 */
public class FacilityMasterUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(FacilityMaster facilityMaster) {
		getPersistence().clearCache(facilityMaster);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FacilityMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FacilityMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FacilityMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static FacilityMaster update(FacilityMaster facilityMaster,
		boolean merge) throws SystemException {
		return getPersistence().update(facilityMaster, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static FacilityMaster update(FacilityMaster facilityMaster,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(facilityMaster, merge, serviceContext);
	}

	/**
	* Caches the facility master in the entity cache if it is enabled.
	*
	* @param facilityMaster the facility master
	*/
	public static void cacheResult(
		com.cignexdatamatics.wrm.model.FacilityMaster facilityMaster) {
		getPersistence().cacheResult(facilityMaster);
	}

	/**
	* Caches the facility masters in the entity cache if it is enabled.
	*
	* @param facilityMasters the facility masters
	*/
	public static void cacheResult(
		java.util.List<com.cignexdatamatics.wrm.model.FacilityMaster> facilityMasters) {
		getPersistence().cacheResult(facilityMasters);
	}

	/**
	* Creates a new facility master with the primary key. Does not add the facility master to the database.
	*
	* @param facilitiesId the primary key for the new facility master
	* @return the new facility master
	*/
	public static com.cignexdatamatics.wrm.model.FacilityMaster create(
		long facilitiesId) {
		return getPersistence().create(facilitiesId);
	}

	/**
	* Removes the facility master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param facilitiesId the primary key of the facility master
	* @return the facility master that was removed
	* @throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException if a facility master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FacilityMaster remove(
		long facilitiesId)
		throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(facilitiesId);
	}

	public static com.cignexdatamatics.wrm.model.FacilityMaster updateImpl(
		com.cignexdatamatics.wrm.model.FacilityMaster facilityMaster,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(facilityMaster, merge);
	}

	/**
	* Returns the facility master with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchFacilityMasterException} if it could not be found.
	*
	* @param facilitiesId the primary key of the facility master
	* @return the facility master
	* @throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException if a facility master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FacilityMaster findByPrimaryKey(
		long facilitiesId)
		throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(facilitiesId);
	}

	/**
	* Returns the facility master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param facilitiesId the primary key of the facility master
	* @return the facility master, or <code>null</code> if a facility master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FacilityMaster fetchByPrimaryKey(
		long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(facilitiesId);
	}

	/**
	* Returns the facility master where facilitiesName = &#63; or throws a {@link com.cignexdatamatics.wrm.NoSuchFacilityMasterException} if it could not be found.
	*
	* @param facilitiesName the facilities name
	* @return the matching facility master
	* @throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException if a matching facility master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FacilityMaster findByFacilitiesName(
		java.lang.String facilitiesName)
		throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFacilitiesName(facilitiesName);
	}

	/**
	* Returns the facility master where facilitiesName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param facilitiesName the facilities name
	* @return the matching facility master, or <code>null</code> if a matching facility master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FacilityMaster fetchByFacilitiesName(
		java.lang.String facilitiesName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFacilitiesName(facilitiesName);
	}

	/**
	* Returns the facility master where facilitiesName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param facilitiesName the facilities name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching facility master, or <code>null</code> if a matching facility master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FacilityMaster fetchByFacilitiesName(
		java.lang.String facilitiesName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFacilitiesName(facilitiesName, retrieveFromCache);
	}

	/**
	* Returns the facility master where facilitiesId = &#63; or throws a {@link com.cignexdatamatics.wrm.NoSuchFacilityMasterException} if it could not be found.
	*
	* @param facilitiesId the facilities ID
	* @return the matching facility master
	* @throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException if a matching facility master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FacilityMaster findByFacilitiesId(
		long facilitiesId)
		throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFacilitiesId(facilitiesId);
	}

	/**
	* Returns the facility master where facilitiesId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param facilitiesId the facilities ID
	* @return the matching facility master, or <code>null</code> if a matching facility master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FacilityMaster fetchByFacilitiesId(
		long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFacilitiesId(facilitiesId);
	}

	/**
	* Returns the facility master where facilitiesId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param facilitiesId the facilities ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching facility master, or <code>null</code> if a matching facility master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FacilityMaster fetchByFacilitiesId(
		long facilitiesId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFacilitiesId(facilitiesId, retrieveFromCache);
	}

	/**
	* Returns all the facility masters.
	*
	* @return the facility masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.FacilityMaster> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the facility masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of facility masters
	* @param end the upper bound of the range of facility masters (not inclusive)
	* @return the range of facility masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.FacilityMaster> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the facility masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of facility masters
	* @param end the upper bound of the range of facility masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of facility masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cignexdatamatics.wrm.model.FacilityMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the facility master where facilitiesName = &#63; from the database.
	*
	* @param facilitiesName the facilities name
	* @return the facility master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FacilityMaster removeByFacilitiesName(
		java.lang.String facilitiesName)
		throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByFacilitiesName(facilitiesName);
	}

	/**
	* Removes the facility master where facilitiesId = &#63; from the database.
	*
	* @param facilitiesId the facilities ID
	* @return the facility master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cignexdatamatics.wrm.model.FacilityMaster removeByFacilitiesId(
		long facilitiesId)
		throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByFacilitiesId(facilitiesId);
	}

	/**
	* Removes all the facility masters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of facility masters where facilitiesName = &#63;.
	*
	* @param facilitiesName the facilities name
	* @return the number of matching facility masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFacilitiesName(java.lang.String facilitiesName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFacilitiesName(facilitiesName);
	}

	/**
	* Returns the number of facility masters where facilitiesId = &#63;.
	*
	* @param facilitiesId the facilities ID
	* @return the number of matching facility masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFacilitiesId(long facilitiesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFacilitiesId(facilitiesId);
	}

	/**
	* Returns the number of facility masters.
	*
	* @return the number of facility masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FacilityMasterPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FacilityMasterPersistence)PortletBeanLocatorUtil.locate(com.cignexdatamatics.wrm.service.ClpSerializer.getServletContextName(),
					FacilityMasterPersistence.class.getName());

			ReferenceRegistry.registerReference(FacilityMasterUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(FacilityMasterPersistence persistence) {
	}

	private static FacilityMasterPersistence _persistence;
}