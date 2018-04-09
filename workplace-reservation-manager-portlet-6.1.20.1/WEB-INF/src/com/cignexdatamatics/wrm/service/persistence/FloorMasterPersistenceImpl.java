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

import com.cignexdatamatics.wrm.NoSuchFloorMasterException;
import com.cignexdatamatics.wrm.model.FloorMaster;
import com.cignexdatamatics.wrm.model.impl.FloorMasterImpl;
import com.cignexdatamatics.wrm.model.impl.FloorMasterModelImpl;

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
 * The persistence implementation for the floor master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FloorMasterPersistence
 * @see FloorMasterUtil
 * @generated
 */
public class FloorMasterPersistenceImpl extends BasePersistenceImpl<FloorMaster>
	implements FloorMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FloorMasterUtil} to access the floor master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FloorMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONID =
		new FinderPath(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
			FloorMasterModelImpl.FINDER_CACHE_ENABLED, FloorMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylocationId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONID =
		new FinderPath(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
			FloorMasterModelImpl.FINDER_CACHE_ENABLED, FloorMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylocationId",
			new String[] { Long.class.getName() },
			FloorMasterModelImpl.LOCATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCATIONID = new FinderPath(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
			FloorMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylocationId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_FLOORNAME = new FinderPath(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
			FloorMasterModelImpl.FINDER_CACHE_ENABLED, FloorMasterImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByFloorName",
			new String[] { String.class.getName() },
			FloorMasterModelImpl.FLOORNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FLOORNAME = new FinderPath(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
			FloorMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFloorName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
			FloorMasterModelImpl.FINDER_CACHE_ENABLED, FloorMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
			FloorMasterModelImpl.FINDER_CACHE_ENABLED, FloorMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
			FloorMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the floor master in the entity cache if it is enabled.
	 *
	 * @param floorMaster the floor master
	 */
	public void cacheResult(FloorMaster floorMaster) {
		EntityCacheUtil.putResult(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
			FloorMasterImpl.class, floorMaster.getPrimaryKey(), floorMaster);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FLOORNAME,
			new Object[] { floorMaster.getFloorName() }, floorMaster);

		floorMaster.resetOriginalValues();
	}

	/**
	 * Caches the floor masters in the entity cache if it is enabled.
	 *
	 * @param floorMasters the floor masters
	 */
	public void cacheResult(List<FloorMaster> floorMasters) {
		for (FloorMaster floorMaster : floorMasters) {
			if (EntityCacheUtil.getResult(
						FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
						FloorMasterImpl.class, floorMaster.getPrimaryKey()) == null) {
				cacheResult(floorMaster);
			}
			else {
				floorMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all floor masters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FloorMasterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FloorMasterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the floor master.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FloorMaster floorMaster) {
		EntityCacheUtil.removeResult(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
			FloorMasterImpl.class, floorMaster.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(floorMaster);
	}

	@Override
	public void clearCache(List<FloorMaster> floorMasters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FloorMaster floorMaster : floorMasters) {
			EntityCacheUtil.removeResult(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
				FloorMasterImpl.class, floorMaster.getPrimaryKey());

			clearUniqueFindersCache(floorMaster);
		}
	}

	protected void clearUniqueFindersCache(FloorMaster floorMaster) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FLOORNAME,
			new Object[] { floorMaster.getFloorName() });
	}

	/**
	 * Creates a new floor master with the primary key. Does not add the floor master to the database.
	 *
	 * @param floorId the primary key for the new floor master
	 * @return the new floor master
	 */
	public FloorMaster create(long floorId) {
		FloorMaster floorMaster = new FloorMasterImpl();

		floorMaster.setNew(true);
		floorMaster.setPrimaryKey(floorId);

		return floorMaster;
	}

	/**
	 * Removes the floor master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param floorId the primary key of the floor master
	 * @return the floor master that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a floor master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FloorMaster remove(long floorId)
		throws NoSuchFloorMasterException, SystemException {
		return remove(Long.valueOf(floorId));
	}

	/**
	 * Removes the floor master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the floor master
	 * @return the floor master that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a floor master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FloorMaster remove(Serializable primaryKey)
		throws NoSuchFloorMasterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FloorMaster floorMaster = (FloorMaster)session.get(FloorMasterImpl.class,
					primaryKey);

			if (floorMaster == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFloorMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(floorMaster);
		}
		catch (NoSuchFloorMasterException nsee) {
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
	protected FloorMaster removeImpl(FloorMaster floorMaster)
		throws SystemException {
		floorMaster = toUnwrappedModel(floorMaster);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, floorMaster);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(floorMaster);

		return floorMaster;
	}

	@Override
	public FloorMaster updateImpl(
		com.cignexdatamatics.wrm.model.FloorMaster floorMaster, boolean merge)
		throws SystemException {
		floorMaster = toUnwrappedModel(floorMaster);

		boolean isNew = floorMaster.isNew();

		FloorMasterModelImpl floorMasterModelImpl = (FloorMasterModelImpl)floorMaster;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, floorMaster, merge);

			floorMaster.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FloorMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((floorMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(floorMasterModelImpl.getOriginalLocationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONID,
					args);

				args = new Object[] {
						Long.valueOf(floorMasterModelImpl.getLocationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
			FloorMasterImpl.class, floorMaster.getPrimaryKey(), floorMaster);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FLOORNAME,
				new Object[] { floorMaster.getFloorName() }, floorMaster);
		}
		else {
			if ((floorMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FLOORNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						floorMasterModelImpl.getOriginalFloorName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FLOORNAME,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FLOORNAME,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FLOORNAME,
					new Object[] { floorMaster.getFloorName() }, floorMaster);
			}
		}

		return floorMaster;
	}

	protected FloorMaster toUnwrappedModel(FloorMaster floorMaster) {
		if (floorMaster instanceof FloorMasterImpl) {
			return floorMaster;
		}

		FloorMasterImpl floorMasterImpl = new FloorMasterImpl();

		floorMasterImpl.setNew(floorMaster.isNew());
		floorMasterImpl.setPrimaryKey(floorMaster.getPrimaryKey());

		floorMasterImpl.setFloorId(floorMaster.getFloorId());
		floorMasterImpl.setLocationId(floorMaster.getLocationId());
		floorMasterImpl.setFloorName(floorMaster.getFloorName());

		return floorMasterImpl;
	}

	/**
	 * Returns the floor master with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the floor master
	 * @return the floor master
	 * @throws com.liferay.portal.NoSuchModelException if a floor master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FloorMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the floor master with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchFloorMasterException} if it could not be found.
	 *
	 * @param floorId the primary key of the floor master
	 * @return the floor master
	 * @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a floor master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FloorMaster findByPrimaryKey(long floorId)
		throws NoSuchFloorMasterException, SystemException {
		FloorMaster floorMaster = fetchByPrimaryKey(floorId);

		if (floorMaster == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + floorId);
			}

			throw new NoSuchFloorMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				floorId);
		}

		return floorMaster;
	}

	/**
	 * Returns the floor master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the floor master
	 * @return the floor master, or <code>null</code> if a floor master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FloorMaster fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the floor master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param floorId the primary key of the floor master
	 * @return the floor master, or <code>null</code> if a floor master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FloorMaster fetchByPrimaryKey(long floorId)
		throws SystemException {
		FloorMaster floorMaster = (FloorMaster)EntityCacheUtil.getResult(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
				FloorMasterImpl.class, floorId);

		if (floorMaster == _nullFloorMaster) {
			return null;
		}

		if (floorMaster == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				floorMaster = (FloorMaster)session.get(FloorMasterImpl.class,
						Long.valueOf(floorId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (floorMaster != null) {
					cacheResult(floorMaster);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FloorMasterModelImpl.ENTITY_CACHE_ENABLED,
						FloorMasterImpl.class, floorId, _nullFloorMaster);
				}

				closeSession(session);
			}
		}

		return floorMaster;
	}

	/**
	 * Returns all the floor masters where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the matching floor masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<FloorMaster> findBylocationId(long locationId)
		throws SystemException {
		return findBylocationId(locationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the floor masters where locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param locationId the location ID
	 * @param start the lower bound of the range of floor masters
	 * @param end the upper bound of the range of floor masters (not inclusive)
	 * @return the range of matching floor masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<FloorMaster> findBylocationId(long locationId, int start,
		int end) throws SystemException {
		return findBylocationId(locationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the floor masters where locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param locationId the location ID
	 * @param start the lower bound of the range of floor masters
	 * @param end the upper bound of the range of floor masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching floor masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<FloorMaster> findBylocationId(long locationId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONID;
			finderArgs = new Object[] { locationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONID;
			finderArgs = new Object[] { locationId, start, end, orderByComparator };
		}

		List<FloorMaster> list = (List<FloorMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FloorMaster floorMaster : list) {
				if ((locationId != floorMaster.getLocationId())) {
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

			query.append(_SQL_SELECT_FLOORMASTER_WHERE);

			query.append(_FINDER_COLUMN_LOCATIONID_LOCATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FloorMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(locationId);

				list = (List<FloorMaster>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first floor master in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching floor master
	 * @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a matching floor master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FloorMaster findBylocationId_First(long locationId,
		OrderByComparator orderByComparator)
		throws NoSuchFloorMasterException, SystemException {
		FloorMaster floorMaster = fetchBylocationId_First(locationId,
				orderByComparator);

		if (floorMaster != null) {
			return floorMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationId=");
		msg.append(locationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFloorMasterException(msg.toString());
	}

	/**
	 * Returns the first floor master in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching floor master, or <code>null</code> if a matching floor master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FloorMaster fetchBylocationId_First(long locationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FloorMaster> list = findBylocationId(locationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last floor master in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching floor master
	 * @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a matching floor master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FloorMaster findBylocationId_Last(long locationId,
		OrderByComparator orderByComparator)
		throws NoSuchFloorMasterException, SystemException {
		FloorMaster floorMaster = fetchBylocationId_Last(locationId,
				orderByComparator);

		if (floorMaster != null) {
			return floorMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationId=");
		msg.append(locationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFloorMasterException(msg.toString());
	}

	/**
	 * Returns the last floor master in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching floor master, or <code>null</code> if a matching floor master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FloorMaster fetchBylocationId_Last(long locationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBylocationId(locationId);

		List<FloorMaster> list = findBylocationId(locationId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the floor masters before and after the current floor master in the ordered set where locationId = &#63;.
	 *
	 * @param floorId the primary key of the current floor master
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next floor master
	 * @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a floor master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FloorMaster[] findBylocationId_PrevAndNext(long floorId,
		long locationId, OrderByComparator orderByComparator)
		throws NoSuchFloorMasterException, SystemException {
		FloorMaster floorMaster = findByPrimaryKey(floorId);

		Session session = null;

		try {
			session = openSession();

			FloorMaster[] array = new FloorMasterImpl[3];

			array[0] = getBylocationId_PrevAndNext(session, floorMaster,
					locationId, orderByComparator, true);

			array[1] = floorMaster;

			array[2] = getBylocationId_PrevAndNext(session, floorMaster,
					locationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FloorMaster getBylocationId_PrevAndNext(Session session,
		FloorMaster floorMaster, long locationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLOORMASTER_WHERE);

		query.append(_FINDER_COLUMN_LOCATIONID_LOCATIONID_2);

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
			query.append(FloorMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(locationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(floorMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FloorMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the floor master where floorName = &#63; or throws a {@link com.cignexdatamatics.wrm.NoSuchFloorMasterException} if it could not be found.
	 *
	 * @param floorName the floor name
	 * @return the matching floor master
	 * @throws com.cignexdatamatics.wrm.NoSuchFloorMasterException if a matching floor master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FloorMaster findByFloorName(String floorName)
		throws NoSuchFloorMasterException, SystemException {
		FloorMaster floorMaster = fetchByFloorName(floorName);

		if (floorMaster == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("floorName=");
			msg.append(floorName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFloorMasterException(msg.toString());
		}

		return floorMaster;
	}

	/**
	 * Returns the floor master where floorName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param floorName the floor name
	 * @return the matching floor master, or <code>null</code> if a matching floor master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FloorMaster fetchByFloorName(String floorName)
		throws SystemException {
		return fetchByFloorName(floorName, true);
	}

	/**
	 * Returns the floor master where floorName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param floorName the floor name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching floor master, or <code>null</code> if a matching floor master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FloorMaster fetchByFloorName(String floorName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { floorName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FLOORNAME,
					finderArgs, this);
		}

		if (result instanceof FloorMaster) {
			FloorMaster floorMaster = (FloorMaster)result;

			if (!Validator.equals(floorName, floorMaster.getFloorName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FLOORMASTER_WHERE);

			if (floorName == null) {
				query.append(_FINDER_COLUMN_FLOORNAME_FLOORNAME_1);
			}
			else {
				if (floorName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_FLOORNAME_FLOORNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_FLOORNAME_FLOORNAME_2);
				}
			}

			query.append(FloorMasterModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (floorName != null) {
					qPos.add(floorName);
				}

				List<FloorMaster> list = q.list();

				result = list;

				FloorMaster floorMaster = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FLOORNAME,
						finderArgs, list);
				}
				else {
					floorMaster = list.get(0);

					cacheResult(floorMaster);

					if ((floorMaster.getFloorName() == null) ||
							!floorMaster.getFloorName().equals(floorName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FLOORNAME,
							finderArgs, floorMaster);
					}
				}

				return floorMaster;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FLOORNAME,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (FloorMaster)result;
			}
		}
	}

	/**
	 * Returns all the floor masters.
	 *
	 * @return the floor masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<FloorMaster> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the floor masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of floor masters
	 * @param end the upper bound of the range of floor masters (not inclusive)
	 * @return the range of floor masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<FloorMaster> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the floor masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of floor masters
	 * @param end the upper bound of the range of floor masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of floor masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<FloorMaster> findAll(int start, int end,
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

		List<FloorMaster> list = (List<FloorMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FLOORMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLOORMASTER.concat(FloorMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<FloorMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<FloorMaster>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the floor masters where locationId = &#63; from the database.
	 *
	 * @param locationId the location ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBylocationId(long locationId) throws SystemException {
		for (FloorMaster floorMaster : findBylocationId(locationId)) {
			remove(floorMaster);
		}
	}

	/**
	 * Removes the floor master where floorName = &#63; from the database.
	 *
	 * @param floorName the floor name
	 * @return the floor master that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public FloorMaster removeByFloorName(String floorName)
		throws NoSuchFloorMasterException, SystemException {
		FloorMaster floorMaster = findByFloorName(floorName);

		return remove(floorMaster);
	}

	/**
	 * Removes all the floor masters from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (FloorMaster floorMaster : findAll()) {
			remove(floorMaster);
		}
	}

	/**
	 * Returns the number of floor masters where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the number of matching floor masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countBylocationId(long locationId) throws SystemException {
		Object[] finderArgs = new Object[] { locationId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOCATIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLOORMASTER_WHERE);

			query.append(_FINDER_COLUMN_LOCATIONID_LOCATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(locationId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOCATIONID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of floor masters where floorName = &#63;.
	 *
	 * @param floorName the floor name
	 * @return the number of matching floor masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countByFloorName(String floorName) throws SystemException {
		Object[] finderArgs = new Object[] { floorName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FLOORNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLOORMASTER_WHERE);

			if (floorName == null) {
				query.append(_FINDER_COLUMN_FLOORNAME_FLOORNAME_1);
			}
			else {
				if (floorName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_FLOORNAME_FLOORNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_FLOORNAME_FLOORNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (floorName != null) {
					qPos.add(floorName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FLOORNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of floor masters.
	 *
	 * @return the number of floor masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FLOORMASTER);

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
	 * Initializes the floor master persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cignexdatamatics.wrm.model.FloorMaster")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FloorMaster>> listenersList = new ArrayList<ModelListener<FloorMaster>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FloorMaster>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FloorMasterImpl.class.getName());
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
	private static final String _SQL_SELECT_FLOORMASTER = "SELECT floorMaster FROM FloorMaster floorMaster";
	private static final String _SQL_SELECT_FLOORMASTER_WHERE = "SELECT floorMaster FROM FloorMaster floorMaster WHERE ";
	private static final String _SQL_COUNT_FLOORMASTER = "SELECT COUNT(floorMaster) FROM FloorMaster floorMaster";
	private static final String _SQL_COUNT_FLOORMASTER_WHERE = "SELECT COUNT(floorMaster) FROM FloorMaster floorMaster WHERE ";
	private static final String _FINDER_COLUMN_LOCATIONID_LOCATIONID_2 = "floorMaster.locationId = ?";
	private static final String _FINDER_COLUMN_FLOORNAME_FLOORNAME_1 = "floorMaster.floorName IS NULL";
	private static final String _FINDER_COLUMN_FLOORNAME_FLOORNAME_2 = "floorMaster.floorName = ?";
	private static final String _FINDER_COLUMN_FLOORNAME_FLOORNAME_3 = "(floorMaster.floorName IS NULL OR floorMaster.floorName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "floorMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FloorMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FloorMaster exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FloorMasterPersistenceImpl.class);
	private static FloorMaster _nullFloorMaster = new FloorMasterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FloorMaster> toCacheModel() {
				return _nullFloorMasterCacheModel;
			}
		};

	private static CacheModel<FloorMaster> _nullFloorMasterCacheModel = new CacheModel<FloorMaster>() {
			public FloorMaster toEntityModel() {
				return _nullFloorMaster;
			}
		};
}