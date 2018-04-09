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

import com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException;
import com.cignexdatamatics.wrm.model.RoomFacilityMapping;
import com.cignexdatamatics.wrm.model.impl.RoomFacilityMappingImpl;
import com.cignexdatamatics.wrm.model.impl.RoomFacilityMappingModelImpl;

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
 * The persistence implementation for the room facility mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomFacilityMappingPersistence
 * @see RoomFacilityMappingUtil
 * @generated
 */
public class RoomFacilityMappingPersistenceImpl extends BasePersistenceImpl<RoomFacilityMapping>
	implements RoomFacilityMappingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RoomFacilityMappingUtil} to access the room facility mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RoomFacilityMappingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOMID = new FinderPath(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			RoomFacilityMappingModelImpl.FINDER_CACHE_ENABLED,
			RoomFacilityMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByroomId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID =
		new FinderPath(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			RoomFacilityMappingModelImpl.FINDER_CACHE_ENABLED,
			RoomFacilityMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByroomId",
			new String[] { Long.class.getName() },
			RoomFacilityMappingModelImpl.ROOMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOMID = new FinderPath(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			RoomFacilityMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByroomId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FACILITIESID =
		new FinderPath(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			RoomFacilityMappingModelImpl.FINDER_CACHE_ENABLED,
			RoomFacilityMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfacilitiesId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITIESID =
		new FinderPath(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			RoomFacilityMappingModelImpl.FINDER_CACHE_ENABLED,
			RoomFacilityMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfacilitiesId",
			new String[] { Long.class.getName() },
			RoomFacilityMappingModelImpl.FACILITIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FACILITIESID = new FinderPath(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			RoomFacilityMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfacilitiesId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			RoomFacilityMappingModelImpl.FINDER_CACHE_ENABLED,
			RoomFacilityMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			RoomFacilityMappingModelImpl.FINDER_CACHE_ENABLED,
			RoomFacilityMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			RoomFacilityMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the room facility mapping in the entity cache if it is enabled.
	 *
	 * @param roomFacilityMapping the room facility mapping
	 */
	public void cacheResult(RoomFacilityMapping roomFacilityMapping) {
		EntityCacheUtil.putResult(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			RoomFacilityMappingImpl.class, roomFacilityMapping.getPrimaryKey(),
			roomFacilityMapping);

		roomFacilityMapping.resetOriginalValues();
	}

	/**
	 * Caches the room facility mappings in the entity cache if it is enabled.
	 *
	 * @param roomFacilityMappings the room facility mappings
	 */
	public void cacheResult(List<RoomFacilityMapping> roomFacilityMappings) {
		for (RoomFacilityMapping roomFacilityMapping : roomFacilityMappings) {
			if (EntityCacheUtil.getResult(
						RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
						RoomFacilityMappingImpl.class,
						roomFacilityMapping.getPrimaryKey()) == null) {
				cacheResult(roomFacilityMapping);
			}
			else {
				roomFacilityMapping.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all room facility mappings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RoomFacilityMappingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RoomFacilityMappingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the room facility mapping.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RoomFacilityMapping roomFacilityMapping) {
		EntityCacheUtil.removeResult(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			RoomFacilityMappingImpl.class, roomFacilityMapping.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RoomFacilityMapping> roomFacilityMappings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RoomFacilityMapping roomFacilityMapping : roomFacilityMappings) {
			EntityCacheUtil.removeResult(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
				RoomFacilityMappingImpl.class,
				roomFacilityMapping.getPrimaryKey());
		}
	}

	/**
	 * Creates a new room facility mapping with the primary key. Does not add the room facility mapping to the database.
	 *
	 * @param roomFacilityMappingPK the primary key for the new room facility mapping
	 * @return the new room facility mapping
	 */
	public RoomFacilityMapping create(
		RoomFacilityMappingPK roomFacilityMappingPK) {
		RoomFacilityMapping roomFacilityMapping = new RoomFacilityMappingImpl();

		roomFacilityMapping.setNew(true);
		roomFacilityMapping.setPrimaryKey(roomFacilityMappingPK);

		return roomFacilityMapping;
	}

	/**
	 * Removes the room facility mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomFacilityMappingPK the primary key of the room facility mapping
	 * @return the room facility mapping that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a room facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomFacilityMapping remove(
		RoomFacilityMappingPK roomFacilityMappingPK)
		throws NoSuchRoomFacilityMappingException, SystemException {
		return remove((Serializable)roomFacilityMappingPK);
	}

	/**
	 * Removes the room facility mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the room facility mapping
	 * @return the room facility mapping that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a room facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RoomFacilityMapping remove(Serializable primaryKey)
		throws NoSuchRoomFacilityMappingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RoomFacilityMapping roomFacilityMapping = (RoomFacilityMapping)session.get(RoomFacilityMappingImpl.class,
					primaryKey);

			if (roomFacilityMapping == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRoomFacilityMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(roomFacilityMapping);
		}
		catch (NoSuchRoomFacilityMappingException nsee) {
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
	protected RoomFacilityMapping removeImpl(
		RoomFacilityMapping roomFacilityMapping) throws SystemException {
		roomFacilityMapping = toUnwrappedModel(roomFacilityMapping);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, roomFacilityMapping);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(roomFacilityMapping);

		return roomFacilityMapping;
	}

	@Override
	public RoomFacilityMapping updateImpl(
		com.cignexdatamatics.wrm.model.RoomFacilityMapping roomFacilityMapping,
		boolean merge) throws SystemException {
		roomFacilityMapping = toUnwrappedModel(roomFacilityMapping);

		boolean isNew = roomFacilityMapping.isNew();

		RoomFacilityMappingModelImpl roomFacilityMappingModelImpl = (RoomFacilityMappingModelImpl)roomFacilityMapping;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, roomFacilityMapping, merge);

			roomFacilityMapping.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RoomFacilityMappingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((roomFacilityMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(roomFacilityMappingModelImpl.getOriginalRoomId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID,
					args);

				args = new Object[] {
						Long.valueOf(roomFacilityMappingModelImpl.getRoomId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID,
					args);
			}

			if ((roomFacilityMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITIESID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(roomFacilityMappingModelImpl.getOriginalFacilitiesId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITIESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITIESID,
					args);

				args = new Object[] {
						Long.valueOf(roomFacilityMappingModelImpl.getFacilitiesId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITIESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITIESID,
					args);
			}
		}

		EntityCacheUtil.putResult(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			RoomFacilityMappingImpl.class, roomFacilityMapping.getPrimaryKey(),
			roomFacilityMapping);

		return roomFacilityMapping;
	}

	protected RoomFacilityMapping toUnwrappedModel(
		RoomFacilityMapping roomFacilityMapping) {
		if (roomFacilityMapping instanceof RoomFacilityMappingImpl) {
			return roomFacilityMapping;
		}

		RoomFacilityMappingImpl roomFacilityMappingImpl = new RoomFacilityMappingImpl();

		roomFacilityMappingImpl.setNew(roomFacilityMapping.isNew());
		roomFacilityMappingImpl.setPrimaryKey(roomFacilityMapping.getPrimaryKey());

		roomFacilityMappingImpl.setRoomId(roomFacilityMapping.getRoomId());
		roomFacilityMappingImpl.setFacilitiesId(roomFacilityMapping.getFacilitiesId());

		return roomFacilityMappingImpl;
	}

	/**
	 * Returns the room facility mapping with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the room facility mapping
	 * @return the room facility mapping
	 * @throws com.liferay.portal.NoSuchModelException if a room facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RoomFacilityMapping findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((RoomFacilityMappingPK)primaryKey);
	}

	/**
	 * Returns the room facility mapping with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException} if it could not be found.
	 *
	 * @param roomFacilityMappingPK the primary key of the room facility mapping
	 * @return the room facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a room facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomFacilityMapping findByPrimaryKey(
		RoomFacilityMappingPK roomFacilityMappingPK)
		throws NoSuchRoomFacilityMappingException, SystemException {
		RoomFacilityMapping roomFacilityMapping = fetchByPrimaryKey(roomFacilityMappingPK);

		if (roomFacilityMapping == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					roomFacilityMappingPK);
			}

			throw new NoSuchRoomFacilityMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				roomFacilityMappingPK);
		}

		return roomFacilityMapping;
	}

	/**
	 * Returns the room facility mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the room facility mapping
	 * @return the room facility mapping, or <code>null</code> if a room facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RoomFacilityMapping fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((RoomFacilityMappingPK)primaryKey);
	}

	/**
	 * Returns the room facility mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomFacilityMappingPK the primary key of the room facility mapping
	 * @return the room facility mapping, or <code>null</code> if a room facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomFacilityMapping fetchByPrimaryKey(
		RoomFacilityMappingPK roomFacilityMappingPK) throws SystemException {
		RoomFacilityMapping roomFacilityMapping = (RoomFacilityMapping)EntityCacheUtil.getResult(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
				RoomFacilityMappingImpl.class, roomFacilityMappingPK);

		if (roomFacilityMapping == _nullRoomFacilityMapping) {
			return null;
		}

		if (roomFacilityMapping == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				roomFacilityMapping = (RoomFacilityMapping)session.get(RoomFacilityMappingImpl.class,
						roomFacilityMappingPK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (roomFacilityMapping != null) {
					cacheResult(roomFacilityMapping);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(RoomFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
						RoomFacilityMappingImpl.class, roomFacilityMappingPK,
						_nullRoomFacilityMapping);
				}

				closeSession(session);
			}
		}

		return roomFacilityMapping;
	}

	/**
	 * Returns all the room facility mappings where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @return the matching room facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomFacilityMapping> findByroomId(long roomId)
		throws SystemException {
		return findByroomId(roomId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the room facility mappings where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param roomId the room ID
	 * @param start the lower bound of the range of room facility mappings
	 * @param end the upper bound of the range of room facility mappings (not inclusive)
	 * @return the range of matching room facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomFacilityMapping> findByroomId(long roomId, int start,
		int end) throws SystemException {
		return findByroomId(roomId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the room facility mappings where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param roomId the room ID
	 * @param start the lower bound of the range of room facility mappings
	 * @param end the upper bound of the range of room facility mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching room facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomFacilityMapping> findByroomId(long roomId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID;
			finderArgs = new Object[] { roomId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOMID;
			finderArgs = new Object[] { roomId, start, end, orderByComparator };
		}

		List<RoomFacilityMapping> list = (List<RoomFacilityMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RoomFacilityMapping roomFacilityMapping : list) {
				if ((roomId != roomFacilityMapping.getRoomId())) {
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
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ROOMFACILITYMAPPING_WHERE);

			query.append(_FINDER_COLUMN_ROOMID_ROOMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roomId);

				list = (List<RoomFacilityMapping>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first room facility mapping in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a matching room facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomFacilityMapping findByroomId_First(long roomId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomFacilityMappingException, SystemException {
		RoomFacilityMapping roomFacilityMapping = fetchByroomId_First(roomId,
				orderByComparator);

		if (roomFacilityMapping != null) {
			return roomFacilityMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roomId=");
		msg.append(roomId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomFacilityMappingException(msg.toString());
	}

	/**
	 * Returns the first room facility mapping in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room facility mapping, or <code>null</code> if a matching room facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomFacilityMapping fetchByroomId_First(long roomId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RoomFacilityMapping> list = findByroomId(roomId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last room facility mapping in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a matching room facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomFacilityMapping findByroomId_Last(long roomId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomFacilityMappingException, SystemException {
		RoomFacilityMapping roomFacilityMapping = fetchByroomId_Last(roomId,
				orderByComparator);

		if (roomFacilityMapping != null) {
			return roomFacilityMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roomId=");
		msg.append(roomId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomFacilityMappingException(msg.toString());
	}

	/**
	 * Returns the last room facility mapping in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room facility mapping, or <code>null</code> if a matching room facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomFacilityMapping fetchByroomId_Last(long roomId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByroomId(roomId);

		List<RoomFacilityMapping> list = findByroomId(roomId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the room facility mappings before and after the current room facility mapping in the ordered set where roomId = &#63;.
	 *
	 * @param roomFacilityMappingPK the primary key of the current room facility mapping
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a room facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomFacilityMapping[] findByroomId_PrevAndNext(
		RoomFacilityMappingPK roomFacilityMappingPK, long roomId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomFacilityMappingException, SystemException {
		RoomFacilityMapping roomFacilityMapping = findByPrimaryKey(roomFacilityMappingPK);

		Session session = null;

		try {
			session = openSession();

			RoomFacilityMapping[] array = new RoomFacilityMappingImpl[3];

			array[0] = getByroomId_PrevAndNext(session, roomFacilityMapping,
					roomId, orderByComparator, true);

			array[1] = roomFacilityMapping;

			array[2] = getByroomId_PrevAndNext(session, roomFacilityMapping,
					roomId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RoomFacilityMapping getByroomId_PrevAndNext(Session session,
		RoomFacilityMapping roomFacilityMapping, long roomId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ROOMFACILITYMAPPING_WHERE);

		query.append(_FINDER_COLUMN_ROOMID_ROOMID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(roomId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(roomFacilityMapping);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RoomFacilityMapping> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the room facility mappings where facilitiesId = &#63;.
	 *
	 * @param facilitiesId the facilities ID
	 * @return the matching room facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomFacilityMapping> findByfacilitiesId(long facilitiesId)
		throws SystemException {
		return findByfacilitiesId(facilitiesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the room facility mappings where facilitiesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param facilitiesId the facilities ID
	 * @param start the lower bound of the range of room facility mappings
	 * @param end the upper bound of the range of room facility mappings (not inclusive)
	 * @return the range of matching room facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomFacilityMapping> findByfacilitiesId(long facilitiesId,
		int start, int end) throws SystemException {
		return findByfacilitiesId(facilitiesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the room facility mappings where facilitiesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param facilitiesId the facilities ID
	 * @param start the lower bound of the range of room facility mappings
	 * @param end the upper bound of the range of room facility mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching room facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomFacilityMapping> findByfacilitiesId(long facilitiesId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITIESID;
			finderArgs = new Object[] { facilitiesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FACILITIESID;
			finderArgs = new Object[] {
					facilitiesId,
					
					start, end, orderByComparator
				};
		}

		List<RoomFacilityMapping> list = (List<RoomFacilityMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RoomFacilityMapping roomFacilityMapping : list) {
				if ((facilitiesId != roomFacilityMapping.getFacilitiesId())) {
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
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ROOMFACILITYMAPPING_WHERE);

			query.append(_FINDER_COLUMN_FACILITIESID_FACILITIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facilitiesId);

				list = (List<RoomFacilityMapping>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first room facility mapping in the ordered set where facilitiesId = &#63;.
	 *
	 * @param facilitiesId the facilities ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a matching room facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomFacilityMapping findByfacilitiesId_First(long facilitiesId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomFacilityMappingException, SystemException {
		RoomFacilityMapping roomFacilityMapping = fetchByfacilitiesId_First(facilitiesId,
				orderByComparator);

		if (roomFacilityMapping != null) {
			return roomFacilityMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facilitiesId=");
		msg.append(facilitiesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomFacilityMappingException(msg.toString());
	}

	/**
	 * Returns the first room facility mapping in the ordered set where facilitiesId = &#63;.
	 *
	 * @param facilitiesId the facilities ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room facility mapping, or <code>null</code> if a matching room facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomFacilityMapping fetchByfacilitiesId_First(long facilitiesId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RoomFacilityMapping> list = findByfacilitiesId(facilitiesId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last room facility mapping in the ordered set where facilitiesId = &#63;.
	 *
	 * @param facilitiesId the facilities ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a matching room facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomFacilityMapping findByfacilitiesId_Last(long facilitiesId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomFacilityMappingException, SystemException {
		RoomFacilityMapping roomFacilityMapping = fetchByfacilitiesId_Last(facilitiesId,
				orderByComparator);

		if (roomFacilityMapping != null) {
			return roomFacilityMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facilitiesId=");
		msg.append(facilitiesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomFacilityMappingException(msg.toString());
	}

	/**
	 * Returns the last room facility mapping in the ordered set where facilitiesId = &#63;.
	 *
	 * @param facilitiesId the facilities ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room facility mapping, or <code>null</code> if a matching room facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomFacilityMapping fetchByfacilitiesId_Last(long facilitiesId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByfacilitiesId(facilitiesId);

		List<RoomFacilityMapping> list = findByfacilitiesId(facilitiesId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the room facility mappings before and after the current room facility mapping in the ordered set where facilitiesId = &#63;.
	 *
	 * @param roomFacilityMappingPK the primary key of the current room facility mapping
	 * @param facilitiesId the facilities ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomFacilityMappingException if a room facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomFacilityMapping[] findByfacilitiesId_PrevAndNext(
		RoomFacilityMappingPK roomFacilityMappingPK, long facilitiesId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomFacilityMappingException, SystemException {
		RoomFacilityMapping roomFacilityMapping = findByPrimaryKey(roomFacilityMappingPK);

		Session session = null;

		try {
			session = openSession();

			RoomFacilityMapping[] array = new RoomFacilityMappingImpl[3];

			array[0] = getByfacilitiesId_PrevAndNext(session,
					roomFacilityMapping, facilitiesId, orderByComparator, true);

			array[1] = roomFacilityMapping;

			array[2] = getByfacilitiesId_PrevAndNext(session,
					roomFacilityMapping, facilitiesId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RoomFacilityMapping getByfacilitiesId_PrevAndNext(
		Session session, RoomFacilityMapping roomFacilityMapping,
		long facilitiesId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ROOMFACILITYMAPPING_WHERE);

		query.append(_FINDER_COLUMN_FACILITIESID_FACILITIESID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(facilitiesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(roomFacilityMapping);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RoomFacilityMapping> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the room facility mappings.
	 *
	 * @return the room facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomFacilityMapping> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the room facility mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of room facility mappings
	 * @param end the upper bound of the range of room facility mappings (not inclusive)
	 * @return the range of room facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomFacilityMapping> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the room facility mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of room facility mappings
	 * @param end the upper bound of the range of room facility mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of room facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomFacilityMapping> findAll(int start, int end,
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

		List<RoomFacilityMapping> list = (List<RoomFacilityMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ROOMFACILITYMAPPING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ROOMFACILITYMAPPING;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<RoomFacilityMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<RoomFacilityMapping>)QueryUtil.list(q,
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
	 * Removes all the room facility mappings where roomId = &#63; from the database.
	 *
	 * @param roomId the room ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByroomId(long roomId) throws SystemException {
		for (RoomFacilityMapping roomFacilityMapping : findByroomId(roomId)) {
			remove(roomFacilityMapping);
		}
	}

	/**
	 * Removes all the room facility mappings where facilitiesId = &#63; from the database.
	 *
	 * @param facilitiesId the facilities ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByfacilitiesId(long facilitiesId)
		throws SystemException {
		for (RoomFacilityMapping roomFacilityMapping : findByfacilitiesId(
				facilitiesId)) {
			remove(roomFacilityMapping);
		}
	}

	/**
	 * Removes all the room facility mappings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (RoomFacilityMapping roomFacilityMapping : findAll()) {
			remove(roomFacilityMapping);
		}
	}

	/**
	 * Returns the number of room facility mappings where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @return the number of matching room facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public int countByroomId(long roomId) throws SystemException {
		Object[] finderArgs = new Object[] { roomId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROOMID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ROOMFACILITYMAPPING_WHERE);

			query.append(_FINDER_COLUMN_ROOMID_ROOMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roomId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROOMID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of room facility mappings where facilitiesId = &#63;.
	 *
	 * @param facilitiesId the facilities ID
	 * @return the number of matching room facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public int countByfacilitiesId(long facilitiesId) throws SystemException {
		Object[] finderArgs = new Object[] { facilitiesId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FACILITIESID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ROOMFACILITYMAPPING_WHERE);

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
	 * Returns the number of room facility mappings.
	 *
	 * @return the number of room facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ROOMFACILITYMAPPING);

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
	 * Initializes the room facility mapping persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cignexdatamatics.wrm.model.RoomFacilityMapping")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RoomFacilityMapping>> listenersList = new ArrayList<ModelListener<RoomFacilityMapping>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RoomFacilityMapping>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RoomFacilityMappingImpl.class.getName());
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
	private static final String _SQL_SELECT_ROOMFACILITYMAPPING = "SELECT roomFacilityMapping FROM RoomFacilityMapping roomFacilityMapping";
	private static final String _SQL_SELECT_ROOMFACILITYMAPPING_WHERE = "SELECT roomFacilityMapping FROM RoomFacilityMapping roomFacilityMapping WHERE ";
	private static final String _SQL_COUNT_ROOMFACILITYMAPPING = "SELECT COUNT(roomFacilityMapping) FROM RoomFacilityMapping roomFacilityMapping";
	private static final String _SQL_COUNT_ROOMFACILITYMAPPING_WHERE = "SELECT COUNT(roomFacilityMapping) FROM RoomFacilityMapping roomFacilityMapping WHERE ";
	private static final String _FINDER_COLUMN_ROOMID_ROOMID_2 = "roomFacilityMapping.id.roomId = ?";
	private static final String _FINDER_COLUMN_FACILITIESID_FACILITIESID_2 = "roomFacilityMapping.id.facilitiesId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "roomFacilityMapping.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RoomFacilityMapping exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RoomFacilityMapping exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RoomFacilityMappingPersistenceImpl.class);
	private static RoomFacilityMapping _nullRoomFacilityMapping = new RoomFacilityMappingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RoomFacilityMapping> toCacheModel() {
				return _nullRoomFacilityMappingCacheModel;
			}
		};

	private static CacheModel<RoomFacilityMapping> _nullRoomFacilityMappingCacheModel =
		new CacheModel<RoomFacilityMapping>() {
			public RoomFacilityMapping toEntityModel() {
				return _nullRoomFacilityMapping;
			}
		};
}