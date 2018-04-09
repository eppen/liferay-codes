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

import com.cignexdatamatics.wrm.NoSuchCityMasterException;
import com.cignexdatamatics.wrm.model.CityMaster;
import com.cignexdatamatics.wrm.model.impl.CityMasterImpl;
import com.cignexdatamatics.wrm.model.impl.CityMasterModelImpl;

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
 * The persistence implementation for the city master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CityMasterPersistence
 * @see CityMasterUtil
 * @generated
 */
public class CityMasterPersistenceImpl extends BasePersistenceImpl<CityMaster>
	implements CityMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CityMasterUtil} to access the city master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CityMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_CITYNAME = new FinderPath(CityMasterModelImpl.ENTITY_CACHE_ENABLED,
			CityMasterModelImpl.FINDER_CACHE_ENABLED, CityMasterImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCityName",
			new String[] { String.class.getName() },
			CityMasterModelImpl.CITYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CITYNAME = new FinderPath(CityMasterModelImpl.ENTITY_CACHE_ENABLED,
			CityMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCityName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CityMasterModelImpl.ENTITY_CACHE_ENABLED,
			CityMasterModelImpl.FINDER_CACHE_ENABLED, CityMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CityMasterModelImpl.ENTITY_CACHE_ENABLED,
			CityMasterModelImpl.FINDER_CACHE_ENABLED, CityMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CityMasterModelImpl.ENTITY_CACHE_ENABLED,
			CityMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the city master in the entity cache if it is enabled.
	 *
	 * @param cityMaster the city master
	 */
	public void cacheResult(CityMaster cityMaster) {
		EntityCacheUtil.putResult(CityMasterModelImpl.ENTITY_CACHE_ENABLED,
			CityMasterImpl.class, cityMaster.getPrimaryKey(), cityMaster);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CITYNAME,
			new Object[] { cityMaster.getCityName() }, cityMaster);

		cityMaster.resetOriginalValues();
	}

	/**
	 * Caches the city masters in the entity cache if it is enabled.
	 *
	 * @param cityMasters the city masters
	 */
	public void cacheResult(List<CityMaster> cityMasters) {
		for (CityMaster cityMaster : cityMasters) {
			if (EntityCacheUtil.getResult(
						CityMasterModelImpl.ENTITY_CACHE_ENABLED,
						CityMasterImpl.class, cityMaster.getPrimaryKey()) == null) {
				cacheResult(cityMaster);
			}
			else {
				cityMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all city masters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CityMasterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CityMasterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the city master.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CityMaster cityMaster) {
		EntityCacheUtil.removeResult(CityMasterModelImpl.ENTITY_CACHE_ENABLED,
			CityMasterImpl.class, cityMaster.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(cityMaster);
	}

	@Override
	public void clearCache(List<CityMaster> cityMasters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CityMaster cityMaster : cityMasters) {
			EntityCacheUtil.removeResult(CityMasterModelImpl.ENTITY_CACHE_ENABLED,
				CityMasterImpl.class, cityMaster.getPrimaryKey());

			clearUniqueFindersCache(cityMaster);
		}
	}

	protected void clearUniqueFindersCache(CityMaster cityMaster) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CITYNAME,
			new Object[] { cityMaster.getCityName() });
	}

	/**
	 * Creates a new city master with the primary key. Does not add the city master to the database.
	 *
	 * @param cityId the primary key for the new city master
	 * @return the new city master
	 */
	public CityMaster create(long cityId) {
		CityMaster cityMaster = new CityMasterImpl();

		cityMaster.setNew(true);
		cityMaster.setPrimaryKey(cityId);

		return cityMaster;
	}

	/**
	 * Removes the city master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cityId the primary key of the city master
	 * @return the city master that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchCityMasterException if a city master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMaster remove(long cityId)
		throws NoSuchCityMasterException, SystemException {
		return remove(Long.valueOf(cityId));
	}

	/**
	 * Removes the city master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the city master
	 * @return the city master that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchCityMasterException if a city master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CityMaster remove(Serializable primaryKey)
		throws NoSuchCityMasterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CityMaster cityMaster = (CityMaster)session.get(CityMasterImpl.class,
					primaryKey);

			if (cityMaster == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCityMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cityMaster);
		}
		catch (NoSuchCityMasterException nsee) {
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
	protected CityMaster removeImpl(CityMaster cityMaster)
		throws SystemException {
		cityMaster = toUnwrappedModel(cityMaster);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, cityMaster);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(cityMaster);

		return cityMaster;
	}

	@Override
	public CityMaster updateImpl(
		com.cignexdatamatics.wrm.model.CityMaster cityMaster, boolean merge)
		throws SystemException {
		cityMaster = toUnwrappedModel(cityMaster);

		boolean isNew = cityMaster.isNew();

		CityMasterModelImpl cityMasterModelImpl = (CityMasterModelImpl)cityMaster;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cityMaster, merge);

			cityMaster.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CityMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CityMasterModelImpl.ENTITY_CACHE_ENABLED,
			CityMasterImpl.class, cityMaster.getPrimaryKey(), cityMaster);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CITYNAME,
				new Object[] { cityMaster.getCityName() }, cityMaster);
		}
		else {
			if ((cityMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CITYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cityMasterModelImpl.getOriginalCityName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITYNAME, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CITYNAME, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CITYNAME,
					new Object[] { cityMaster.getCityName() }, cityMaster);
			}
		}

		return cityMaster;
	}

	protected CityMaster toUnwrappedModel(CityMaster cityMaster) {
		if (cityMaster instanceof CityMasterImpl) {
			return cityMaster;
		}

		CityMasterImpl cityMasterImpl = new CityMasterImpl();

		cityMasterImpl.setNew(cityMaster.isNew());
		cityMasterImpl.setPrimaryKey(cityMaster.getPrimaryKey());

		cityMasterImpl.setCityId(cityMaster.getCityId());
		cityMasterImpl.setCityName(cityMaster.getCityName());

		return cityMasterImpl;
	}

	/**
	 * Returns the city master with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the city master
	 * @return the city master
	 * @throws com.liferay.portal.NoSuchModelException if a city master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CityMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the city master with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchCityMasterException} if it could not be found.
	 *
	 * @param cityId the primary key of the city master
	 * @return the city master
	 * @throws com.cignexdatamatics.wrm.NoSuchCityMasterException if a city master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMaster findByPrimaryKey(long cityId)
		throws NoSuchCityMasterException, SystemException {
		CityMaster cityMaster = fetchByPrimaryKey(cityId);

		if (cityMaster == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + cityId);
			}

			throw new NoSuchCityMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				cityId);
		}

		return cityMaster;
	}

	/**
	 * Returns the city master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the city master
	 * @return the city master, or <code>null</code> if a city master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CityMaster fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the city master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cityId the primary key of the city master
	 * @return the city master, or <code>null</code> if a city master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMaster fetchByPrimaryKey(long cityId) throws SystemException {
		CityMaster cityMaster = (CityMaster)EntityCacheUtil.getResult(CityMasterModelImpl.ENTITY_CACHE_ENABLED,
				CityMasterImpl.class, cityId);

		if (cityMaster == _nullCityMaster) {
			return null;
		}

		if (cityMaster == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				cityMaster = (CityMaster)session.get(CityMasterImpl.class,
						Long.valueOf(cityId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (cityMaster != null) {
					cacheResult(cityMaster);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CityMasterModelImpl.ENTITY_CACHE_ENABLED,
						CityMasterImpl.class, cityId, _nullCityMaster);
				}

				closeSession(session);
			}
		}

		return cityMaster;
	}

	/**
	 * Returns the city master where cityName = &#63; or throws a {@link com.cignexdatamatics.wrm.NoSuchCityMasterException} if it could not be found.
	 *
	 * @param cityName the city name
	 * @return the matching city master
	 * @throws com.cignexdatamatics.wrm.NoSuchCityMasterException if a matching city master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMaster findByCityName(String cityName)
		throws NoSuchCityMasterException, SystemException {
		CityMaster cityMaster = fetchByCityName(cityName);

		if (cityMaster == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cityName=");
			msg.append(cityName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCityMasterException(msg.toString());
		}

		return cityMaster;
	}

	/**
	 * Returns the city master where cityName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cityName the city name
	 * @return the matching city master, or <code>null</code> if a matching city master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMaster fetchByCityName(String cityName)
		throws SystemException {
		return fetchByCityName(cityName, true);
	}

	/**
	 * Returns the city master where cityName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cityName the city name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching city master, or <code>null</code> if a matching city master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMaster fetchByCityName(String cityName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { cityName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CITYNAME,
					finderArgs, this);
		}

		if (result instanceof CityMaster) {
			CityMaster cityMaster = (CityMaster)result;

			if (!Validator.equals(cityName, cityMaster.getCityName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CITYMASTER_WHERE);

			if (cityName == null) {
				query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_1);
			}
			else {
				if (cityName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_2);
				}
			}

			query.append(CityMasterModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (cityName != null) {
					qPos.add(cityName);
				}

				List<CityMaster> list = q.list();

				result = list;

				CityMaster cityMaster = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CITYNAME,
						finderArgs, list);
				}
				else {
					cityMaster = list.get(0);

					cacheResult(cityMaster);

					if ((cityMaster.getCityName() == null) ||
							!cityMaster.getCityName().equals(cityName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CITYNAME,
							finderArgs, cityMaster);
					}
				}

				return cityMaster;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CITYNAME,
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
				return (CityMaster)result;
			}
		}
	}

	/**
	 * Returns all the city masters.
	 *
	 * @return the city masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMaster> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<CityMaster> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<CityMaster> findAll(int start, int end,
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

		List<CityMaster> list = (List<CityMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CITYMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CITYMASTER.concat(CityMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CityMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CityMaster>)QueryUtil.list(q, getDialect(),
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
	 * Removes the city master where cityName = &#63; from the database.
	 *
	 * @param cityName the city name
	 * @return the city master that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public CityMaster removeByCityName(String cityName)
		throws NoSuchCityMasterException, SystemException {
		CityMaster cityMaster = findByCityName(cityName);

		return remove(cityMaster);
	}

	/**
	 * Removes all the city masters from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CityMaster cityMaster : findAll()) {
			remove(cityMaster);
		}
	}

	/**
	 * Returns the number of city masters where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @return the number of matching city masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCityName(String cityName) throws SystemException {
		Object[] finderArgs = new Object[] { cityName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CITYNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITYMASTER_WHERE);

			if (cityName == null) {
				query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_1);
			}
			else {
				if (cityName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (cityName != null) {
					qPos.add(cityName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CITYNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of city masters.
	 *
	 * @return the number of city masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CITYMASTER);

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
	 * Initializes the city master persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cignexdatamatics.wrm.model.CityMaster")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CityMaster>> listenersList = new ArrayList<ModelListener<CityMaster>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CityMaster>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CityMasterImpl.class.getName());
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
	private static final String _SQL_SELECT_CITYMASTER = "SELECT cityMaster FROM CityMaster cityMaster";
	private static final String _SQL_SELECT_CITYMASTER_WHERE = "SELECT cityMaster FROM CityMaster cityMaster WHERE ";
	private static final String _SQL_COUNT_CITYMASTER = "SELECT COUNT(cityMaster) FROM CityMaster cityMaster";
	private static final String _SQL_COUNT_CITYMASTER_WHERE = "SELECT COUNT(cityMaster) FROM CityMaster cityMaster WHERE ";
	private static final String _FINDER_COLUMN_CITYNAME_CITYNAME_1 = "cityMaster.cityName IS NULL";
	private static final String _FINDER_COLUMN_CITYNAME_CITYNAME_2 = "cityMaster.cityName = ?";
	private static final String _FINDER_COLUMN_CITYNAME_CITYNAME_3 = "(cityMaster.cityName IS NULL OR cityMaster.cityName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cityMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CityMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CityMaster exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CityMasterPersistenceImpl.class);
	private static CityMaster _nullCityMaster = new CityMasterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CityMaster> toCacheModel() {
				return _nullCityMasterCacheModel;
			}
		};

	private static CacheModel<CityMaster> _nullCityMasterCacheModel = new CacheModel<CityMaster>() {
			public CityMaster toEntityModel() {
				return _nullCityMaster;
			}
		};
}