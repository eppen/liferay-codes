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

import com.cignexdatamatics.wrm.NoSuchFacilityMasterException;
import com.cignexdatamatics.wrm.model.FacilityMaster;
import com.cignexdatamatics.wrm.model.impl.FacilityMasterImpl;
import com.cignexdatamatics.wrm.model.impl.FacilityMasterModelImpl;

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
 * The persistence implementation for the facility master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacilityMasterPersistence
 * @see FacilityMasterUtil
 * @generated
 */
public class FacilityMasterPersistenceImpl extends BasePersistenceImpl<FacilityMaster>
	implements FacilityMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FacilityMasterUtil} to access the facility master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FacilityMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_FACILITIESNAME = new FinderPath(FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
			FacilityMasterModelImpl.FINDER_CACHE_ENABLED,
			FacilityMasterImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByFacilitiesName", new String[] { String.class.getName() },
			FacilityMasterModelImpl.FACILITIESNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FACILITIESNAME = new FinderPath(FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
			FacilityMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFacilitiesName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_FACILITIESID = new FinderPath(FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
			FacilityMasterModelImpl.FINDER_CACHE_ENABLED,
			FacilityMasterImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByFacilitiesId", new String[] { Long.class.getName() },
			FacilityMasterModelImpl.FACILITIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FACILITIESID = new FinderPath(FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
			FacilityMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFacilitiesId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
			FacilityMasterModelImpl.FINDER_CACHE_ENABLED,
			FacilityMasterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
			FacilityMasterModelImpl.FINDER_CACHE_ENABLED,
			FacilityMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
			FacilityMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the facility master in the entity cache if it is enabled.
	 *
	 * @param facilityMaster the facility master
	 */
	public void cacheResult(FacilityMaster facilityMaster) {
		EntityCacheUtil.putResult(FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
			FacilityMasterImpl.class, facilityMaster.getPrimaryKey(),
			facilityMaster);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITIESNAME,
			new Object[] { facilityMaster.getFacilitiesName() }, facilityMaster);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITIESID,
			new Object[] { Long.valueOf(facilityMaster.getFacilitiesId()) },
			facilityMaster);

		facilityMaster.resetOriginalValues();
	}

	/**
	 * Caches the facility masters in the entity cache if it is enabled.
	 *
	 * @param facilityMasters the facility masters
	 */
	public void cacheResult(List<FacilityMaster> facilityMasters) {
		for (FacilityMaster facilityMaster : facilityMasters) {
			if (EntityCacheUtil.getResult(
						FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
						FacilityMasterImpl.class, facilityMaster.getPrimaryKey()) == null) {
				cacheResult(facilityMaster);
			}
			else {
				facilityMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all facility masters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FacilityMasterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FacilityMasterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the facility master.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FacilityMaster facilityMaster) {
		EntityCacheUtil.removeResult(FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
			FacilityMasterImpl.class, facilityMaster.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(facilityMaster);
	}

	@Override
	public void clearCache(List<FacilityMaster> facilityMasters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FacilityMaster facilityMaster : facilityMasters) {
			EntityCacheUtil.removeResult(FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
				FacilityMasterImpl.class, facilityMaster.getPrimaryKey());

			clearUniqueFindersCache(facilityMaster);
		}
	}

	protected void clearUniqueFindersCache(FacilityMaster facilityMaster) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FACILITIESNAME,
			new Object[] { facilityMaster.getFacilitiesName() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FACILITIESID,
			new Object[] { Long.valueOf(facilityMaster.getFacilitiesId()) });
	}

	/**
	 * Creates a new facility master with the primary key. Does not add the facility master to the database.
	 *
	 * @param facilitiesId the primary key for the new facility master
	 * @return the new facility master
	 */
	public FacilityMaster create(long facilitiesId) {
		FacilityMaster facilityMaster = new FacilityMasterImpl();

		facilityMaster.setNew(true);
		facilityMaster.setPrimaryKey(facilitiesId);

		return facilityMaster;
	}

	/**
	 * Removes the facility master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facilitiesId the primary key of the facility master
	 * @return the facility master that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException if a facility master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FacilityMaster remove(long facilitiesId)
		throws NoSuchFacilityMasterException, SystemException {
		return remove(Long.valueOf(facilitiesId));
	}

	/**
	 * Removes the facility master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the facility master
	 * @return the facility master that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException if a facility master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FacilityMaster remove(Serializable primaryKey)
		throws NoSuchFacilityMasterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FacilityMaster facilityMaster = (FacilityMaster)session.get(FacilityMasterImpl.class,
					primaryKey);

			if (facilityMaster == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacilityMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(facilityMaster);
		}
		catch (NoSuchFacilityMasterException nsee) {
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
	protected FacilityMaster removeImpl(FacilityMaster facilityMaster)
		throws SystemException {
		facilityMaster = toUnwrappedModel(facilityMaster);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, facilityMaster);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(facilityMaster);

		return facilityMaster;
	}

	@Override
	public FacilityMaster updateImpl(
		com.cignexdatamatics.wrm.model.FacilityMaster facilityMaster,
		boolean merge) throws SystemException {
		facilityMaster = toUnwrappedModel(facilityMaster);

		boolean isNew = facilityMaster.isNew();

		FacilityMasterModelImpl facilityMasterModelImpl = (FacilityMasterModelImpl)facilityMaster;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, facilityMaster, merge);

			facilityMaster.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FacilityMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
			FacilityMasterImpl.class, facilityMaster.getPrimaryKey(),
			facilityMaster);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITIESNAME,
				new Object[] { facilityMaster.getFacilitiesName() },
				facilityMaster);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITIESID,
				new Object[] { Long.valueOf(facilityMaster.getFacilitiesId()) },
				facilityMaster);
		}
		else {
			if ((facilityMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FACILITIESNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						facilityMasterModelImpl.getOriginalFacilitiesName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITIESNAME,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FACILITIESNAME,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITIESNAME,
					new Object[] { facilityMaster.getFacilitiesName() },
					facilityMaster);
			}

			if ((facilityMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FACILITIESID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(facilityMasterModelImpl.getOriginalFacilitiesId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITIESID,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FACILITIESID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITIESID,
					new Object[] { Long.valueOf(
							facilityMaster.getFacilitiesId()) }, facilityMaster);
			}
		}

		return facilityMaster;
	}

	protected FacilityMaster toUnwrappedModel(FacilityMaster facilityMaster) {
		if (facilityMaster instanceof FacilityMasterImpl) {
			return facilityMaster;
		}

		FacilityMasterImpl facilityMasterImpl = new FacilityMasterImpl();

		facilityMasterImpl.setNew(facilityMaster.isNew());
		facilityMasterImpl.setPrimaryKey(facilityMaster.getPrimaryKey());

		facilityMasterImpl.setFacilitiesId(facilityMaster.getFacilitiesId());
		facilityMasterImpl.setFacilitiesName(facilityMaster.getFacilitiesName());
		facilityMasterImpl.setFacilitiesDesc(facilityMaster.getFacilitiesDesc());

		return facilityMasterImpl;
	}

	/**
	 * Returns the facility master with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the facility master
	 * @return the facility master
	 * @throws com.liferay.portal.NoSuchModelException if a facility master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FacilityMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the facility master with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchFacilityMasterException} if it could not be found.
	 *
	 * @param facilitiesId the primary key of the facility master
	 * @return the facility master
	 * @throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException if a facility master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FacilityMaster findByPrimaryKey(long facilitiesId)
		throws NoSuchFacilityMasterException, SystemException {
		FacilityMaster facilityMaster = fetchByPrimaryKey(facilitiesId);

		if (facilityMaster == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + facilitiesId);
			}

			throw new NoSuchFacilityMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				facilitiesId);
		}

		return facilityMaster;
	}

	/**
	 * Returns the facility master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the facility master
	 * @return the facility master, or <code>null</code> if a facility master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FacilityMaster fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the facility master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facilitiesId the primary key of the facility master
	 * @return the facility master, or <code>null</code> if a facility master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FacilityMaster fetchByPrimaryKey(long facilitiesId)
		throws SystemException {
		FacilityMaster facilityMaster = (FacilityMaster)EntityCacheUtil.getResult(FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
				FacilityMasterImpl.class, facilitiesId);

		if (facilityMaster == _nullFacilityMaster) {
			return null;
		}

		if (facilityMaster == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				facilityMaster = (FacilityMaster)session.get(FacilityMasterImpl.class,
						Long.valueOf(facilitiesId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (facilityMaster != null) {
					cacheResult(facilityMaster);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FacilityMasterModelImpl.ENTITY_CACHE_ENABLED,
						FacilityMasterImpl.class, facilitiesId,
						_nullFacilityMaster);
				}

				closeSession(session);
			}
		}

		return facilityMaster;
	}

	/**
	 * Returns the facility master where facilitiesName = &#63; or throws a {@link com.cignexdatamatics.wrm.NoSuchFacilityMasterException} if it could not be found.
	 *
	 * @param facilitiesName the facilities name
	 * @return the matching facility master
	 * @throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException if a matching facility master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FacilityMaster findByFacilitiesName(String facilitiesName)
		throws NoSuchFacilityMasterException, SystemException {
		FacilityMaster facilityMaster = fetchByFacilitiesName(facilitiesName);

		if (facilityMaster == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("facilitiesName=");
			msg.append(facilitiesName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFacilityMasterException(msg.toString());
		}

		return facilityMaster;
	}

	/**
	 * Returns the facility master where facilitiesName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param facilitiesName the facilities name
	 * @return the matching facility master, or <code>null</code> if a matching facility master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FacilityMaster fetchByFacilitiesName(String facilitiesName)
		throws SystemException {
		return fetchByFacilitiesName(facilitiesName, true);
	}

	/**
	 * Returns the facility master where facilitiesName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param facilitiesName the facilities name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching facility master, or <code>null</code> if a matching facility master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FacilityMaster fetchByFacilitiesName(String facilitiesName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { facilitiesName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FACILITIESNAME,
					finderArgs, this);
		}

		if (result instanceof FacilityMaster) {
			FacilityMaster facilityMaster = (FacilityMaster)result;

			if (!Validator.equals(facilitiesName,
						facilityMaster.getFacilitiesName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FACILITYMASTER_WHERE);

			if (facilitiesName == null) {
				query.append(_FINDER_COLUMN_FACILITIESNAME_FACILITIESNAME_1);
			}
			else {
				if (facilitiesName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_FACILITIESNAME_FACILITIESNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_FACILITIESNAME_FACILITIESNAME_2);
				}
			}

			query.append(FacilityMasterModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (facilitiesName != null) {
					qPos.add(facilitiesName);
				}

				List<FacilityMaster> list = q.list();

				result = list;

				FacilityMaster facilityMaster = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITIESNAME,
						finderArgs, list);
				}
				else {
					facilityMaster = list.get(0);

					cacheResult(facilityMaster);

					if ((facilityMaster.getFacilitiesName() == null) ||
							!facilityMaster.getFacilitiesName()
											   .equals(facilitiesName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITIESNAME,
							finderArgs, facilityMaster);
					}
				}

				return facilityMaster;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FACILITIESNAME,
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
				return (FacilityMaster)result;
			}
		}
	}

	/**
	 * Returns the facility master where facilitiesId = &#63; or throws a {@link com.cignexdatamatics.wrm.NoSuchFacilityMasterException} if it could not be found.
	 *
	 * @param facilitiesId the facilities ID
	 * @return the matching facility master
	 * @throws com.cignexdatamatics.wrm.NoSuchFacilityMasterException if a matching facility master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FacilityMaster findByFacilitiesId(long facilitiesId)
		throws NoSuchFacilityMasterException, SystemException {
		FacilityMaster facilityMaster = fetchByFacilitiesId(facilitiesId);

		if (facilityMaster == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("facilitiesId=");
			msg.append(facilitiesId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFacilityMasterException(msg.toString());
		}

		return facilityMaster;
	}

	/**
	 * Returns the facility master where facilitiesId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param facilitiesId the facilities ID
	 * @return the matching facility master, or <code>null</code> if a matching facility master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FacilityMaster fetchByFacilitiesId(long facilitiesId)
		throws SystemException {
		return fetchByFacilitiesId(facilitiesId, true);
	}

	/**
	 * Returns the facility master where facilitiesId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param facilitiesId the facilities ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching facility master, or <code>null</code> if a matching facility master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FacilityMaster fetchByFacilitiesId(long facilitiesId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { facilitiesId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FACILITIESID,
					finderArgs, this);
		}

		if (result instanceof FacilityMaster) {
			FacilityMaster facilityMaster = (FacilityMaster)result;

			if ((facilitiesId != facilityMaster.getFacilitiesId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FACILITYMASTER_WHERE);

			query.append(_FINDER_COLUMN_FACILITIESID_FACILITIESID_2);

			query.append(FacilityMasterModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facilitiesId);

				List<FacilityMaster> list = q.list();

				result = list;

				FacilityMaster facilityMaster = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITIESID,
						finderArgs, list);
				}
				else {
					facilityMaster = list.get(0);

					cacheResult(facilityMaster);

					if ((facilityMaster.getFacilitiesId() != facilitiesId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITIESID,
							finderArgs, facilityMaster);
					}
				}

				return facilityMaster;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FACILITIESID,
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
				return (FacilityMaster)result;
			}
		}
	}

	/**
	 * Returns all the facility masters.
	 *
	 * @return the facility masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<FacilityMaster> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<FacilityMaster> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<FacilityMaster> findAll(int start, int end,
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

		List<FacilityMaster> list = (List<FacilityMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACILITYMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACILITYMASTER.concat(FacilityMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<FacilityMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<FacilityMaster>)QueryUtil.list(q,
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
	 * Removes the facility master where facilitiesName = &#63; from the database.
	 *
	 * @param facilitiesName the facilities name
	 * @return the facility master that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public FacilityMaster removeByFacilitiesName(String facilitiesName)
		throws NoSuchFacilityMasterException, SystemException {
		FacilityMaster facilityMaster = findByFacilitiesName(facilitiesName);

		return remove(facilityMaster);
	}

	/**
	 * Removes the facility master where facilitiesId = &#63; from the database.
	 *
	 * @param facilitiesId the facilities ID
	 * @return the facility master that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public FacilityMaster removeByFacilitiesId(long facilitiesId)
		throws NoSuchFacilityMasterException, SystemException {
		FacilityMaster facilityMaster = findByFacilitiesId(facilitiesId);

		return remove(facilityMaster);
	}

	/**
	 * Removes all the facility masters from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (FacilityMaster facilityMaster : findAll()) {
			remove(facilityMaster);
		}
	}

	/**
	 * Returns the number of facility masters where facilitiesName = &#63;.
	 *
	 * @param facilitiesName the facilities name
	 * @return the number of matching facility masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countByFacilitiesName(String facilitiesName)
		throws SystemException {
		Object[] finderArgs = new Object[] { facilitiesName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FACILITIESNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACILITYMASTER_WHERE);

			if (facilitiesName == null) {
				query.append(_FINDER_COLUMN_FACILITIESNAME_FACILITIESNAME_1);
			}
			else {
				if (facilitiesName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_FACILITIESNAME_FACILITIESNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_FACILITIESNAME_FACILITIESNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (facilitiesName != null) {
					qPos.add(facilitiesName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FACILITIESNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of facility masters where facilitiesId = &#63;.
	 *
	 * @param facilitiesId the facilities ID
	 * @return the number of matching facility masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countByFacilitiesId(long facilitiesId) throws SystemException {
		Object[] finderArgs = new Object[] { facilitiesId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FACILITIESID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACILITYMASTER_WHERE);

			query.append(_FINDER_COLUMN_FACILITIESID_FACILITIESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facilitiesId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FACILITIESID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of facility masters.
	 *
	 * @return the number of facility masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FACILITYMASTER);

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
	 * Initializes the facility master persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cignexdatamatics.wrm.model.FacilityMaster")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FacilityMaster>> listenersList = new ArrayList<ModelListener<FacilityMaster>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FacilityMaster>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FacilityMasterImpl.class.getName());
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
	private static final String _SQL_SELECT_FACILITYMASTER = "SELECT facilityMaster FROM FacilityMaster facilityMaster";
	private static final String _SQL_SELECT_FACILITYMASTER_WHERE = "SELECT facilityMaster FROM FacilityMaster facilityMaster WHERE ";
	private static final String _SQL_COUNT_FACILITYMASTER = "SELECT COUNT(facilityMaster) FROM FacilityMaster facilityMaster";
	private static final String _SQL_COUNT_FACILITYMASTER_WHERE = "SELECT COUNT(facilityMaster) FROM FacilityMaster facilityMaster WHERE ";
	private static final String _FINDER_COLUMN_FACILITIESNAME_FACILITIESNAME_1 = "facilityMaster.facilitiesName IS NULL";
	private static final String _FINDER_COLUMN_FACILITIESNAME_FACILITIESNAME_2 = "facilityMaster.facilitiesName = ?";
	private static final String _FINDER_COLUMN_FACILITIESNAME_FACILITIESNAME_3 = "(facilityMaster.facilitiesName IS NULL OR facilityMaster.facilitiesName = ?)";
	private static final String _FINDER_COLUMN_FACILITIESID_FACILITIESID_2 = "facilityMaster.facilitiesId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "facilityMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FacilityMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FacilityMaster exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FacilityMasterPersistenceImpl.class);
	private static FacilityMaster _nullFacilityMaster = new FacilityMasterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FacilityMaster> toCacheModel() {
				return _nullFacilityMasterCacheModel;
			}
		};

	private static CacheModel<FacilityMaster> _nullFacilityMasterCacheModel = new CacheModel<FacilityMaster>() {
			public FacilityMaster toEntityModel() {
				return _nullFacilityMaster;
			}
		};
}