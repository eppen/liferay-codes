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

import com.cignexdatamatics.wrm.NoSuchLocationMasterException;
import com.cignexdatamatics.wrm.model.LocationMaster;
import com.cignexdatamatics.wrm.model.impl.LocationMasterImpl;
import com.cignexdatamatics.wrm.model.impl.LocationMasterModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the location master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocationMasterPersistence
 * @see LocationMasterUtil
 * @generated
 */
public class LocationMasterPersistenceImpl extends BasePersistenceImpl<LocationMaster>
	implements LocationMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LocationMasterUtil} to access the location master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LocationMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CITYID = new FinderPath(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
			LocationMasterModelImpl.FINDER_CACHE_ENABLED,
			LocationMasterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCityId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID =
		new FinderPath(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
			LocationMasterModelImpl.FINDER_CACHE_ENABLED,
			LocationMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCityId",
			new String[] { Long.class.getName() },
			LocationMasterModelImpl.CITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CITYID = new FinderPath(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
			LocationMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCityId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONNAME =
		new FinderPath(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
			LocationMasterModelImpl.FINDER_CACHE_ENABLED,
			LocationMasterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLocationName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONNAME =
		new FinderPath(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
			LocationMasterModelImpl.FINDER_CACHE_ENABLED,
			LocationMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLocationName",
			new String[] { String.class.getName() },
			LocationMasterModelImpl.LOCATIONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCATIONNAME = new FinderPath(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
			LocationMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocationName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
			LocationMasterModelImpl.FINDER_CACHE_ENABLED,
			LocationMasterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
			LocationMasterModelImpl.FINDER_CACHE_ENABLED,
			LocationMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
			LocationMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the location master in the entity cache if it is enabled.
	 *
	 * @param locationMaster the location master
	 */
	public void cacheResult(LocationMaster locationMaster) {
		EntityCacheUtil.putResult(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
			LocationMasterImpl.class, locationMaster.getPrimaryKey(),
			locationMaster);

		locationMaster.resetOriginalValues();
	}

	/**
	 * Caches the location masters in the entity cache if it is enabled.
	 *
	 * @param locationMasters the location masters
	 */
	public void cacheResult(List<LocationMaster> locationMasters) {
		for (LocationMaster locationMaster : locationMasters) {
			if (EntityCacheUtil.getResult(
						LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
						LocationMasterImpl.class, locationMaster.getPrimaryKey()) == null) {
				cacheResult(locationMaster);
			}
			else {
				locationMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all location masters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LocationMasterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LocationMasterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the location master.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LocationMaster locationMaster) {
		EntityCacheUtil.removeResult(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
			LocationMasterImpl.class, locationMaster.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LocationMaster> locationMasters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LocationMaster locationMaster : locationMasters) {
			EntityCacheUtil.removeResult(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
				LocationMasterImpl.class, locationMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new location master with the primary key. Does not add the location master to the database.
	 *
	 * @param locationId the primary key for the new location master
	 * @return the new location master
	 */
	public LocationMaster create(long locationId) {
		LocationMaster locationMaster = new LocationMasterImpl();

		locationMaster.setNew(true);
		locationMaster.setPrimaryKey(locationId);

		return locationMaster;
	}

	/**
	 * Removes the location master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param locationId the primary key of the location master
	 * @return the location master that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a location master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LocationMaster remove(long locationId)
		throws NoSuchLocationMasterException, SystemException {
		return remove(Long.valueOf(locationId));
	}

	/**
	 * Removes the location master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the location master
	 * @return the location master that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a location master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LocationMaster remove(Serializable primaryKey)
		throws NoSuchLocationMasterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LocationMaster locationMaster = (LocationMaster)session.get(LocationMasterImpl.class,
					primaryKey);

			if (locationMaster == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLocationMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(locationMaster);
		}
		catch (NoSuchLocationMasterException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LocationMaster removeImpl(LocationMaster locationMaster)
		throws SystemException {
		locationMaster = toUnwrappedModel(locationMaster);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, locationMaster);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(locationMaster);

		return locationMaster;
	}

	@Override
	public LocationMaster updateImpl(
		com.cignexdatamatics.wrm.model.LocationMaster locationMaster,
		boolean merge) throws SystemException {
		locationMaster = toUnwrappedModel(locationMaster);

		boolean isNew = locationMaster.isNew();

		LocationMasterModelImpl locationMasterModelImpl = (LocationMasterModelImpl)locationMaster;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, locationMaster, merge);

			locationMaster.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LocationMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((locationMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(locationMasterModelImpl.getOriginalCityId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITYID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID,
					args);

				args = new Object[] {
						Long.valueOf(locationMasterModelImpl.getCityId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITYID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID,
					args);
			}

			if ((locationMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						locationMasterModelImpl.getOriginalLocationName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONNAME,
					args);

				args = new Object[] { locationMasterModelImpl.getLocationName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
			LocationMasterImpl.class, locationMaster.getPrimaryKey(),
			locationMaster);

		return locationMaster;
	}

	protected LocationMaster toUnwrappedModel(LocationMaster locationMaster) {
		if (locationMaster instanceof LocationMasterImpl) {
			return locationMaster;
		}

		LocationMasterImpl locationMasterImpl = new LocationMasterImpl();

		locationMasterImpl.setNew(locationMaster.isNew());
		locationMasterImpl.setPrimaryKey(locationMaster.getPrimaryKey());

		locationMasterImpl.setLocationId(locationMaster.getLocationId());
		locationMasterImpl.setCityId(locationMaster.getCityId());
		locationMasterImpl.setLocationName(locationMaster.getLocationName());

		return locationMasterImpl;
	}

	/**
	 * Returns the location master with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the location master
	 * @return the location master
	 * @throws com.liferay.portal.NoSuchModelException if a location master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LocationMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the location master with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchLocationMasterException} if it could not be found.
	 *
	 * @param locationId the primary key of the location master
	 * @return the location master
	 * @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a location master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LocationMaster findByPrimaryKey(long locationId)
		throws NoSuchLocationMasterException, SystemException {
		LocationMaster locationMaster = fetchByPrimaryKey(locationId);

		if (locationMaster == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + locationId);
			}

			throw new NoSuchLocationMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				locationId);
		}

		return locationMaster;
	}

	/**
	 * Returns the location master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the location master
	 * @return the location master, or <code>null</code> if a location master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LocationMaster fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the location master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param locationId the primary key of the location master
	 * @return the location master, or <code>null</code> if a location master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LocationMaster fetchByPrimaryKey(long locationId)
		throws SystemException {
		LocationMaster locationMaster = (LocationMaster)EntityCacheUtil.getResult(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
				LocationMasterImpl.class, locationId);

		if (locationMaster == _nullLocationMaster) {
			return null;
		}

		if (locationMaster == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				locationMaster = (LocationMaster)session.get(LocationMasterImpl.class,
						Long.valueOf(locationId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (locationMaster != null) {
					cacheResult(locationMaster);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LocationMasterModelImpl.ENTITY_CACHE_ENABLED,
						LocationMasterImpl.class, locationId,
						_nullLocationMaster);
				}

				closeSession(session);
			}
		}

		return locationMaster;
	}

	/**
	 * Returns all the location masters where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the matching location masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<LocationMaster> findByCityId(long cityId)
		throws SystemException {
		return findByCityId(cityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the location masters where cityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param start the lower bound of the range of location masters
	 * @param end the upper bound of the range of location masters (not inclusive)
	 * @return the range of matching location masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<LocationMaster> findByCityId(long cityId, int start, int end)
		throws SystemException {
		return findByCityId(cityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the location masters where cityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param start the lower bound of the range of location masters
	 * @param end the upper bound of the range of location masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching location masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<LocationMaster> findByCityId(long cityId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID;
			finderArgs = new Object[] { cityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CITYID;
			finderArgs = new Object[] { cityId, start, end, orderByComparator };
		}

		List<LocationMaster> list = (List<LocationMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LocationMaster locationMaster : list) {
				if ((cityId != locationMaster.getCityId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOCATIONMASTER_WHERE);

			query.append(_FINDER_COLUMN_CITYID_CITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LocationMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cityId);

				list = (List<LocationMaster>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first location master in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location master
	 * @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a matching location master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LocationMaster findByCityId_First(long cityId,
		OrderByComparator orderByComparator)
		throws NoSuchLocationMasterException, SystemException {
		LocationMaster locationMaster = fetchByCityId_First(cityId,
				orderByComparator);

		if (locationMaster != null) {
			return locationMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityId=");
		msg.append(cityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocationMasterException(msg.toString());
	}

	/**
	 * Returns the first location master in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location master, or <code>null</code> if a matching location master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LocationMaster fetchByCityId_First(long cityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LocationMaster> list = findByCityId(cityId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last location master in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location master
	 * @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a matching location master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LocationMaster findByCityId_Last(long cityId,
		OrderByComparator orderByComparator)
		throws NoSuchLocationMasterException, SystemException {
		LocationMaster locationMaster = fetchByCityId_Last(cityId,
				orderByComparator);

		if (locationMaster != null) {
			return locationMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityId=");
		msg.append(cityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocationMasterException(msg.toString());
	}

	/**
	 * Returns the last location master in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location master, or <code>null</code> if a matching location master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LocationMaster fetchByCityId_Last(long cityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCityId(cityId);

		List<LocationMaster> list = findByCityId(cityId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the location masters before and after the current location master in the ordered set where cityId = &#63;.
	 *
	 * @param locationId the primary key of the current location master
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next location master
	 * @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a location master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LocationMaster[] findByCityId_PrevAndNext(long locationId,
		long cityId, OrderByComparator orderByComparator)
		throws NoSuchLocationMasterException, SystemException {
		LocationMaster locationMaster = findByPrimaryKey(locationId);

		Session session = null;

		try {
			session = openSession();

			LocationMaster[] array = new LocationMasterImpl[3];

			array[0] = getByCityId_PrevAndNext(session, locationMaster, cityId,
					orderByComparator, true);

			array[1] = locationMaster;

			array[2] = getByCityId_PrevAndNext(session, locationMaster, cityId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LocationMaster getByCityId_PrevAndNext(Session session,
		LocationMaster locationMaster, long cityId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOCATIONMASTER_WHERE);

		query.append(_FINDER_COLUMN_CITYID_CITYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(LocationMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(locationMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LocationMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the location masters where locationName = &#63;.
	 *
	 * @param locationName the location name
	 * @return the matching location masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<LocationMaster> findByLocationName(String locationName)
		throws SystemException {
		return findByLocationName(locationName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the location masters where locationName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param locationName the location name
	 * @param start the lower bound of the range of location masters
	 * @param end the upper bound of the range of location masters (not inclusive)
	 * @return the range of matching location masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<LocationMaster> findByLocationName(String locationName,
		int start, int end) throws SystemException {
		return findByLocationName(locationName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the location masters where locationName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param locationName the location name
	 * @param start the lower bound of the range of location masters
	 * @param end the upper bound of the range of location masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching location masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<LocationMaster> findByLocationName(String locationName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONNAME;
			finderArgs = new Object[] { locationName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONNAME;
			finderArgs = new Object[] {
					locationName,
					
					start, end, orderByComparator
				};
		}

		List<LocationMaster> list = (List<LocationMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LocationMaster locationMaster : list) {
				if (!Validator.equals(locationName,
							locationMaster.getLocationName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOCATIONMASTER_WHERE);

			if (locationName == null) {
				query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_1);
			}
			else {
				if (locationName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LocationMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (locationName != null) {
					qPos.add(locationName);
				}

				list = (List<LocationMaster>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first location master in the ordered set where locationName = &#63;.
	 *
	 * @param locationName the location name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location master
	 * @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a matching location master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LocationMaster findByLocationName_First(String locationName,
		OrderByComparator orderByComparator)
		throws NoSuchLocationMasterException, SystemException {
		LocationMaster locationMaster = fetchByLocationName_First(locationName,
				orderByComparator);

		if (locationMaster != null) {
			return locationMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationName=");
		msg.append(locationName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocationMasterException(msg.toString());
	}

	/**
	 * Returns the first location master in the ordered set where locationName = &#63;.
	 *
	 * @param locationName the location name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location master, or <code>null</code> if a matching location master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LocationMaster fetchByLocationName_First(String locationName,
		OrderByComparator orderByComparator) throws SystemException {
		List<LocationMaster> list = findByLocationName(locationName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last location master in the ordered set where locationName = &#63;.
	 *
	 * @param locationName the location name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location master
	 * @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a matching location master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LocationMaster findByLocationName_Last(String locationName,
		OrderByComparator orderByComparator)
		throws NoSuchLocationMasterException, SystemException {
		LocationMaster locationMaster = fetchByLocationName_Last(locationName,
				orderByComparator);

		if (locationMaster != null) {
			return locationMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationName=");
		msg.append(locationName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocationMasterException(msg.toString());
	}

	/**
	 * Returns the last location master in the ordered set where locationName = &#63;.
	 *
	 * @param locationName the location name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location master, or <code>null</code> if a matching location master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LocationMaster fetchByLocationName_Last(String locationName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLocationName(locationName);

		List<LocationMaster> list = findByLocationName(locationName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the location masters before and after the current location master in the ordered set where locationName = &#63;.
	 *
	 * @param locationId the primary key of the current location master
	 * @param locationName the location name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next location master
	 * @throws com.cignexdatamatics.wrm.NoSuchLocationMasterException if a location master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LocationMaster[] findByLocationName_PrevAndNext(long locationId,
		String locationName, OrderByComparator orderByComparator)
		throws NoSuchLocationMasterException, SystemException {
		LocationMaster locationMaster = findByPrimaryKey(locationId);

		Session session = null;

		try {
			session = openSession();

			LocationMaster[] array = new LocationMasterImpl[3];

			array[0] = getByLocationName_PrevAndNext(session, locationMaster,
					locationName, orderByComparator, true);

			array[1] = locationMaster;

			array[2] = getByLocationName_PrevAndNext(session, locationMaster,
					locationName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LocationMaster getByLocationName_PrevAndNext(Session session,
		LocationMaster locationMaster, String locationName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOCATIONMASTER_WHERE);

		if (locationName == null) {
			query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_1);
		}
		else {
			if (locationName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(LocationMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (locationName != null) {
			qPos.add(locationName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(locationMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LocationMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the location masters.
	 *
	 * @return the location masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<LocationMaster> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the location masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of location masters
	 * @param end the upper bound of the range of location masters (not inclusive)
	 * @return the range of location masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<LocationMaster> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the location masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of location masters
	 * @param end the upper bound of the range of location masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of location masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<LocationMaster> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<LocationMaster> list = (List<LocationMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOCATIONMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOCATIONMASTER.concat(LocationMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LocationMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LocationMaster>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the location masters where cityId = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCityId(long cityId) throws SystemException {
		for (LocationMaster locationMaster : findByCityId(cityId)) {
			remove(locationMaster);
		}
	}

	/**
	 * Removes all the location masters where locationName = &#63; from the database.
	 *
	 * @param locationName the location name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLocationName(String locationName)
		throws SystemException {
		for (LocationMaster locationMaster : findByLocationName(locationName)) {
			remove(locationMaster);
		}
	}

	/**
	 * Removes all the location masters from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LocationMaster locationMaster : findAll()) {
			remove(locationMaster);
		}
	}

	/**
	 * Returns the number of location masters where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the number of matching location masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCityId(long cityId) throws SystemException {
		Object[] finderArgs = new Object[] { cityId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CITYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOCATIONMASTER_WHERE);

			query.append(_FINDER_COLUMN_CITYID_CITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cityId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CITYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of location masters where locationName = &#63;.
	 *
	 * @param locationName the location name
	 * @return the number of matching location masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLocationName(String locationName)
		throws SystemException {
		Object[] finderArgs = new Object[] { locationName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOCATIONNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOCATIONMASTER_WHERE);

			if (locationName == null) {
				query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_1);
			}
			else {
				if (locationName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (locationName != null) {
					qPos.add(locationName);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOCATIONNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of location masters.
	 *
	 * @return the number of location masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOCATIONMASTER);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the location master persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cignexdatamatics.wrm.model.LocationMaster")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LocationMaster>> listenersList = new ArrayList<ModelListener<LocationMaster>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LocationMaster>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LocationMasterImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = BookingAttendeesPersistence.class)
	protected BookingAttendeesPersistence bookingAttendeesPersistence;
	@BeanReference(type = BookingFacilityMappingPersistence.class)
	protected BookingFacilityMappingPersistence bookingFacilityMappingPersistence;
	@BeanReference(type = BookingRoomsPersistence.class)
	protected BookingRoomsPersistence bookingRoomsPersistence;
	@BeanReference(type = CityMasterPersistence.class)
	protected CityMasterPersistence cityMasterPersistence;
	@BeanReference(type = FacilityMasterPersistence.class)
	protected FacilityMasterPersistence facilityMasterPersistence;
	@BeanReference(type = FloorMasterPersistence.class)
	protected FloorMasterPersistence floorMasterPersistence;
	@BeanReference(type = LocationMasterPersistence.class)
	protected LocationMasterPersistence locationMasterPersistence;
	@BeanReference(type = NewBookingPersistence.class)
	protected NewBookingPersistence newBookingPersistence;
	@BeanReference(type = RoomFacilityMappingPersistence.class)
	protected RoomFacilityMappingPersistence roomFacilityMappingPersistence;
	@BeanReference(type = RoomMasterPersistence.class)
	protected RoomMasterPersistence roomMasterPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LOCATIONMASTER = "SELECT locationMaster FROM LocationMaster locationMaster";
	private static final String _SQL_SELECT_LOCATIONMASTER_WHERE = "SELECT locationMaster FROM LocationMaster locationMaster WHERE ";
	private static final String _SQL_COUNT_LOCATIONMASTER = "SELECT COUNT(locationMaster) FROM LocationMaster locationMaster";
	private static final String _SQL_COUNT_LOCATIONMASTER_WHERE = "SELECT COUNT(locationMaster) FROM LocationMaster locationMaster WHERE ";
	private static final String _FINDER_COLUMN_CITYID_CITYID_2 = "locationMaster.cityId = ?";
	private static final String _FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_1 = "locationMaster.locationName IS NULL";
	private static final String _FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_2 = "locationMaster.locationName = ?";
	private static final String _FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_3 = "(locationMaster.locationName IS NULL OR locationMaster.locationName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "locationMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LocationMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LocationMaster exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LocationMasterPersistenceImpl.class);
	private static LocationMaster _nullLocationMaster = new LocationMasterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LocationMaster> toCacheModel() {
				return _nullLocationMasterCacheModel;
			}
		};

	private static CacheModel<LocationMaster> _nullLocationMasterCacheModel = new CacheModel<LocationMaster>() {
			public LocationMaster toEntityModel() {
				return _nullLocationMaster;
			}
		};
}