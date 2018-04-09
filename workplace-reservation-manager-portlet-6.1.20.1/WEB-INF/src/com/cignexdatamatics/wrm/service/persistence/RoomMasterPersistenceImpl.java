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

import com.cignexdatamatics.wrm.NoSuchRoomMasterException;
import com.cignexdatamatics.wrm.model.RoomMaster;
import com.cignexdatamatics.wrm.model.impl.RoomMasterImpl;
import com.cignexdatamatics.wrm.model.impl.RoomMasterModelImpl;

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
 * The persistence implementation for the room master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomMasterPersistence
 * @see RoomMasterUtil
 * @generated
 */
public class RoomMasterPersistenceImpl extends BasePersistenceImpl<RoomMaster>
	implements RoomMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RoomMasterUtil} to access the room master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RoomMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CITYID = new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, RoomMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCityId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID =
		new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, RoomMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCityId",
			new String[] { Long.class.getName() },
			RoomMasterModelImpl.CITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CITYID = new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCityId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONID =
		new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, RoomMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLocationId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONID =
		new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, RoomMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLocationId",
			new String[] { Long.class.getName() },
			RoomMasterModelImpl.LOCATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCATIONID = new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocationId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FLOORID = new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, RoomMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFloorId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FLOORID =
		new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, RoomMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFloorId",
			new String[] { Long.class.getName() },
			RoomMasterModelImpl.FLOORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FLOORID = new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFloorId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOMBYLOCANDCITY =
		new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, RoomMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoomByLocandCity",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMBYLOCANDCITY =
		new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, RoomMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRoomByLocandCity",
			new String[] { Long.class.getName(), Long.class.getName() },
			RoomMasterModelImpl.CITYID_COLUMN_BITMASK |
			RoomMasterModelImpl.LOCATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOMBYLOCANDCITY = new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRoomByLocandCity",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOMBYLOCATIONCITYFLOOR =
		new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, RoomMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRoomByLocationCityFloor",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMBYLOCATIONCITYFLOOR =
		new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, RoomMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRoomByLocationCityFloor",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			RoomMasterModelImpl.CITYID_COLUMN_BITMASK |
			RoomMasterModelImpl.LOCATIONID_COLUMN_BITMASK |
			RoomMasterModelImpl.FLOORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOMBYLOCATIONCITYFLOOR = new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRoomByLocationCityFloor",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_FETCH_BY_ROOMBYROOMNAME = new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, RoomMasterImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRoomByRoomName",
			new String[] { String.class.getName() },
			RoomMasterModelImpl.ROOMNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOMBYROOMNAME = new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoomByRoomName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, RoomMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, RoomMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the room master in the entity cache if it is enabled.
	 *
	 * @param roomMaster the room master
	 */
	public void cacheResult(RoomMaster roomMaster) {
		EntityCacheUtil.putResult(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterImpl.class, roomMaster.getPrimaryKey(), roomMaster);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROOMBYROOMNAME,
			new Object[] { roomMaster.getRoomName() }, roomMaster);

		roomMaster.resetOriginalValues();
	}

	/**
	 * Caches the room masters in the entity cache if it is enabled.
	 *
	 * @param roomMasters the room masters
	 */
	public void cacheResult(List<RoomMaster> roomMasters) {
		for (RoomMaster roomMaster : roomMasters) {
			if (EntityCacheUtil.getResult(
						RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
						RoomMasterImpl.class, roomMaster.getPrimaryKey()) == null) {
				cacheResult(roomMaster);
			}
			else {
				roomMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all room masters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RoomMasterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RoomMasterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the room master.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RoomMaster roomMaster) {
		EntityCacheUtil.removeResult(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterImpl.class, roomMaster.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(roomMaster);
	}

	@Override
	public void clearCache(List<RoomMaster> roomMasters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RoomMaster roomMaster : roomMasters) {
			EntityCacheUtil.removeResult(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
				RoomMasterImpl.class, roomMaster.getPrimaryKey());

			clearUniqueFindersCache(roomMaster);
		}
	}

	protected void clearUniqueFindersCache(RoomMaster roomMaster) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ROOMBYROOMNAME,
			new Object[] { roomMaster.getRoomName() });
	}

	/**
	 * Creates a new room master with the primary key. Does not add the room master to the database.
	 *
	 * @param roomId the primary key for the new room master
	 * @return the new room master
	 */
	public RoomMaster create(long roomId) {
		RoomMaster roomMaster = new RoomMasterImpl();

		roomMaster.setNew(true);
		roomMaster.setPrimaryKey(roomId);

		return roomMaster;
	}

	/**
	 * Removes the room master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomId the primary key of the room master
	 * @return the room master that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster remove(long roomId)
		throws NoSuchRoomMasterException, SystemException {
		return remove(Long.valueOf(roomId));
	}

	/**
	 * Removes the room master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the room master
	 * @return the room master that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RoomMaster remove(Serializable primaryKey)
		throws NoSuchRoomMasterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RoomMaster roomMaster = (RoomMaster)session.get(RoomMasterImpl.class,
					primaryKey);

			if (roomMaster == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRoomMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(roomMaster);
		}
		catch (NoSuchRoomMasterException nsee) {
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
	protected RoomMaster removeImpl(RoomMaster roomMaster)
		throws SystemException {
		roomMaster = toUnwrappedModel(roomMaster);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, roomMaster);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(roomMaster);

		return roomMaster;
	}

	@Override
	public RoomMaster updateImpl(
		com.cignexdatamatics.wrm.model.RoomMaster roomMaster, boolean merge)
		throws SystemException {
		roomMaster = toUnwrappedModel(roomMaster);

		boolean isNew = roomMaster.isNew();

		RoomMasterModelImpl roomMasterModelImpl = (RoomMasterModelImpl)roomMaster;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, roomMaster, merge);

			roomMaster.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RoomMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((roomMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(roomMasterModelImpl.getOriginalCityId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITYID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID,
					args);

				args = new Object[] {
						Long.valueOf(roomMasterModelImpl.getCityId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITYID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID,
					args);
			}

			if ((roomMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(roomMasterModelImpl.getOriginalLocationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONID,
					args);

				args = new Object[] {
						Long.valueOf(roomMasterModelImpl.getLocationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONID,
					args);
			}

			if ((roomMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FLOORID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(roomMasterModelImpl.getOriginalFloorId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FLOORID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FLOORID,
					args);

				args = new Object[] {
						Long.valueOf(roomMasterModelImpl.getFloorId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FLOORID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FLOORID,
					args);
			}

			if ((roomMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMBYLOCANDCITY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(roomMasterModelImpl.getOriginalCityId()),
						Long.valueOf(roomMasterModelImpl.getOriginalLocationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMBYLOCANDCITY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMBYLOCANDCITY,
					args);

				args = new Object[] {
						Long.valueOf(roomMasterModelImpl.getCityId()),
						Long.valueOf(roomMasterModelImpl.getLocationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMBYLOCANDCITY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMBYLOCANDCITY,
					args);
			}

			if ((roomMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMBYLOCATIONCITYFLOOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(roomMasterModelImpl.getOriginalCityId()),
						Long.valueOf(roomMasterModelImpl.getOriginalLocationId()),
						Long.valueOf(roomMasterModelImpl.getOriginalFloorId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMBYLOCATIONCITYFLOOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMBYLOCATIONCITYFLOOR,
					args);

				args = new Object[] {
						Long.valueOf(roomMasterModelImpl.getCityId()),
						Long.valueOf(roomMasterModelImpl.getLocationId()),
						Long.valueOf(roomMasterModelImpl.getFloorId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMBYLOCATIONCITYFLOOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMBYLOCATIONCITYFLOOR,
					args);
			}
		}

		EntityCacheUtil.putResult(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
			RoomMasterImpl.class, roomMaster.getPrimaryKey(), roomMaster);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROOMBYROOMNAME,
				new Object[] { roomMaster.getRoomName() }, roomMaster);
		}
		else {
			if ((roomMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ROOMBYROOMNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						roomMasterModelImpl.getOriginalRoomName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMBYROOMNAME,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ROOMBYROOMNAME,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROOMBYROOMNAME,
					new Object[] { roomMaster.getRoomName() }, roomMaster);
			}
		}

		return roomMaster;
	}

	protected RoomMaster toUnwrappedModel(RoomMaster roomMaster) {
		if (roomMaster instanceof RoomMasterImpl) {
			return roomMaster;
		}

		RoomMasterImpl roomMasterImpl = new RoomMasterImpl();

		roomMasterImpl.setNew(roomMaster.isNew());
		roomMasterImpl.setPrimaryKey(roomMaster.getPrimaryKey());

		roomMasterImpl.setRoomId(roomMaster.getRoomId());
		roomMasterImpl.setCityId(roomMaster.getCityId());
		roomMasterImpl.setLocationId(roomMaster.getLocationId());
		roomMasterImpl.setFloorId(roomMaster.getFloorId());
		roomMasterImpl.setRoomName(roomMaster.getRoomName());
		roomMasterImpl.setCapacity(roomMaster.getCapacity());
		roomMasterImpl.setExtension(roomMaster.getExtension());

		return roomMasterImpl;
	}

	/**
	 * Returns the room master with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the room master
	 * @return the room master
	 * @throws com.liferay.portal.NoSuchModelException if a room master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RoomMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the room master with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchRoomMasterException} if it could not be found.
	 *
	 * @param roomId the primary key of the room master
	 * @return the room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster findByPrimaryKey(long roomId)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = fetchByPrimaryKey(roomId);

		if (roomMaster == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + roomId);
			}

			throw new NoSuchRoomMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				roomId);
		}

		return roomMaster;
	}

	/**
	 * Returns the room master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the room master
	 * @return the room master, or <code>null</code> if a room master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RoomMaster fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the room master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomId the primary key of the room master
	 * @return the room master, or <code>null</code> if a room master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster fetchByPrimaryKey(long roomId) throws SystemException {
		RoomMaster roomMaster = (RoomMaster)EntityCacheUtil.getResult(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
				RoomMasterImpl.class, roomId);

		if (roomMaster == _nullRoomMaster) {
			return null;
		}

		if (roomMaster == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				roomMaster = (RoomMaster)session.get(RoomMasterImpl.class,
						Long.valueOf(roomId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (roomMaster != null) {
					cacheResult(roomMaster);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(RoomMasterModelImpl.ENTITY_CACHE_ENABLED,
						RoomMasterImpl.class, roomId, _nullRoomMaster);
				}

				closeSession(session);
			}
		}

		return roomMaster;
	}

	/**
	 * Returns all the room masters where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByCityId(long cityId) throws SystemException {
		return findByCityId(cityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the room masters where cityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param start the lower bound of the range of room masters
	 * @param end the upper bound of the range of room masters (not inclusive)
	 * @return the range of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByCityId(long cityId, int start, int end)
		throws SystemException {
		return findByCityId(cityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the room masters where cityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param start the lower bound of the range of room masters
	 * @param end the upper bound of the range of room masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByCityId(long cityId, int start, int end,
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

		List<RoomMaster> list = (List<RoomMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RoomMaster roomMaster : list) {
				if ((cityId != roomMaster.getCityId())) {
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

			query.append(_SQL_SELECT_ROOMMASTER_WHERE);

			query.append(_FINDER_COLUMN_CITYID_CITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(RoomMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cityId);

				list = (List<RoomMaster>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first room master in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster findByCityId_First(long cityId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = fetchByCityId_First(cityId, orderByComparator);

		if (roomMaster != null) {
			return roomMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityId=");
		msg.append(cityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomMasterException(msg.toString());
	}

	/**
	 * Returns the first room master in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room master, or <code>null</code> if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster fetchByCityId_First(long cityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RoomMaster> list = findByCityId(cityId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last room master in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster findByCityId_Last(long cityId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = fetchByCityId_Last(cityId, orderByComparator);

		if (roomMaster != null) {
			return roomMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityId=");
		msg.append(cityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomMasterException(msg.toString());
	}

	/**
	 * Returns the last room master in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room master, or <code>null</code> if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster fetchByCityId_Last(long cityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCityId(cityId);

		List<RoomMaster> list = findByCityId(cityId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the room masters before and after the current room master in the ordered set where cityId = &#63;.
	 *
	 * @param roomId the primary key of the current room master
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster[] findByCityId_PrevAndNext(long roomId, long cityId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			RoomMaster[] array = new RoomMasterImpl[3];

			array[0] = getByCityId_PrevAndNext(session, roomMaster, cityId,
					orderByComparator, true);

			array[1] = roomMaster;

			array[2] = getByCityId_PrevAndNext(session, roomMaster, cityId,
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

	protected RoomMaster getByCityId_PrevAndNext(Session session,
		RoomMaster roomMaster, long cityId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ROOMMASTER_WHERE);

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
			query.append(RoomMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(roomMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RoomMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the room masters where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByLocationId(long locationId)
		throws SystemException {
		return findByLocationId(locationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the room masters where locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param locationId the location ID
	 * @param start the lower bound of the range of room masters
	 * @param end the upper bound of the range of room masters (not inclusive)
	 * @return the range of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByLocationId(long locationId, int start, int end)
		throws SystemException {
		return findByLocationId(locationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the room masters where locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param locationId the location ID
	 * @param start the lower bound of the range of room masters
	 * @param end the upper bound of the range of room masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByLocationId(long locationId, int start,
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

		List<RoomMaster> list = (List<RoomMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RoomMaster roomMaster : list) {
				if ((locationId != roomMaster.getLocationId())) {
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

			query.append(_SQL_SELECT_ROOMMASTER_WHERE);

			query.append(_FINDER_COLUMN_LOCATIONID_LOCATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(RoomMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(locationId);

				list = (List<RoomMaster>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first room master in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster findByLocationId_First(long locationId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = fetchByLocationId_First(locationId,
				orderByComparator);

		if (roomMaster != null) {
			return roomMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationId=");
		msg.append(locationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomMasterException(msg.toString());
	}

	/**
	 * Returns the first room master in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room master, or <code>null</code> if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster fetchByLocationId_First(long locationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RoomMaster> list = findByLocationId(locationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last room master in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster findByLocationId_Last(long locationId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = fetchByLocationId_Last(locationId,
				orderByComparator);

		if (roomMaster != null) {
			return roomMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationId=");
		msg.append(locationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomMasterException(msg.toString());
	}

	/**
	 * Returns the last room master in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room master, or <code>null</code> if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster fetchByLocationId_Last(long locationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLocationId(locationId);

		List<RoomMaster> list = findByLocationId(locationId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the room masters before and after the current room master in the ordered set where locationId = &#63;.
	 *
	 * @param roomId the primary key of the current room master
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster[] findByLocationId_PrevAndNext(long roomId,
		long locationId, OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			RoomMaster[] array = new RoomMasterImpl[3];

			array[0] = getByLocationId_PrevAndNext(session, roomMaster,
					locationId, orderByComparator, true);

			array[1] = roomMaster;

			array[2] = getByLocationId_PrevAndNext(session, roomMaster,
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

	protected RoomMaster getByLocationId_PrevAndNext(Session session,
		RoomMaster roomMaster, long locationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ROOMMASTER_WHERE);

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
			query.append(RoomMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(locationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(roomMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RoomMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the room masters where floorId = &#63;.
	 *
	 * @param floorId the floor ID
	 * @return the matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByFloorId(long floorId)
		throws SystemException {
		return findByFloorId(floorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the room masters where floorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param floorId the floor ID
	 * @param start the lower bound of the range of room masters
	 * @param end the upper bound of the range of room masters (not inclusive)
	 * @return the range of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByFloorId(long floorId, int start, int end)
		throws SystemException {
		return findByFloorId(floorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the room masters where floorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param floorId the floor ID
	 * @param start the lower bound of the range of room masters
	 * @param end the upper bound of the range of room masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByFloorId(long floorId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FLOORID;
			finderArgs = new Object[] { floorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FLOORID;
			finderArgs = new Object[] { floorId, start, end, orderByComparator };
		}

		List<RoomMaster> list = (List<RoomMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RoomMaster roomMaster : list) {
				if ((floorId != roomMaster.getFloorId())) {
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

			query.append(_SQL_SELECT_ROOMMASTER_WHERE);

			query.append(_FINDER_COLUMN_FLOORID_FLOORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(RoomMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(floorId);

				list = (List<RoomMaster>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first room master in the ordered set where floorId = &#63;.
	 *
	 * @param floorId the floor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster findByFloorId_First(long floorId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = fetchByFloorId_First(floorId, orderByComparator);

		if (roomMaster != null) {
			return roomMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("floorId=");
		msg.append(floorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomMasterException(msg.toString());
	}

	/**
	 * Returns the first room master in the ordered set where floorId = &#63;.
	 *
	 * @param floorId the floor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room master, or <code>null</code> if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster fetchByFloorId_First(long floorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RoomMaster> list = findByFloorId(floorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last room master in the ordered set where floorId = &#63;.
	 *
	 * @param floorId the floor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster findByFloorId_Last(long floorId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = fetchByFloorId_Last(floorId, orderByComparator);

		if (roomMaster != null) {
			return roomMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("floorId=");
		msg.append(floorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomMasterException(msg.toString());
	}

	/**
	 * Returns the last room master in the ordered set where floorId = &#63;.
	 *
	 * @param floorId the floor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room master, or <code>null</code> if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster fetchByFloorId_Last(long floorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFloorId(floorId);

		List<RoomMaster> list = findByFloorId(floorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the room masters before and after the current room master in the ordered set where floorId = &#63;.
	 *
	 * @param roomId the primary key of the current room master
	 * @param floorId the floor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster[] findByFloorId_PrevAndNext(long roomId, long floorId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			RoomMaster[] array = new RoomMasterImpl[3];

			array[0] = getByFloorId_PrevAndNext(session, roomMaster, floorId,
					orderByComparator, true);

			array[1] = roomMaster;

			array[2] = getByFloorId_PrevAndNext(session, roomMaster, floorId,
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

	protected RoomMaster getByFloorId_PrevAndNext(Session session,
		RoomMaster roomMaster, long floorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ROOMMASTER_WHERE);

		query.append(_FINDER_COLUMN_FLOORID_FLOORID_2);

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
			query.append(RoomMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(floorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(roomMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RoomMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the room masters where cityId = &#63; and locationId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @return the matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByRoomByLocandCity(long cityId, long locationId)
		throws SystemException {
		return findByRoomByLocandCity(cityId, locationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the room masters where cityId = &#63; and locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param start the lower bound of the range of room masters
	 * @param end the upper bound of the range of room masters (not inclusive)
	 * @return the range of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByRoomByLocandCity(long cityId,
		long locationId, int start, int end) throws SystemException {
		return findByRoomByLocandCity(cityId, locationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the room masters where cityId = &#63; and locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param start the lower bound of the range of room masters
	 * @param end the upper bound of the range of room masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByRoomByLocandCity(long cityId,
		long locationId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMBYLOCANDCITY;
			finderArgs = new Object[] { cityId, locationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOMBYLOCANDCITY;
			finderArgs = new Object[] {
					cityId, locationId,
					
					start, end, orderByComparator
				};
		}

		List<RoomMaster> list = (List<RoomMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RoomMaster roomMaster : list) {
				if ((cityId != roomMaster.getCityId()) ||
						(locationId != roomMaster.getLocationId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ROOMMASTER_WHERE);

			query.append(_FINDER_COLUMN_ROOMBYLOCANDCITY_CITYID_2);

			query.append(_FINDER_COLUMN_ROOMBYLOCANDCITY_LOCATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(RoomMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cityId);

				qPos.add(locationId);

				list = (List<RoomMaster>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first room master in the ordered set where cityId = &#63; and locationId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster findByRoomByLocandCity_First(long cityId,
		long locationId, OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = fetchByRoomByLocandCity_First(cityId,
				locationId, orderByComparator);

		if (roomMaster != null) {
			return roomMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityId=");
		msg.append(cityId);

		msg.append(", locationId=");
		msg.append(locationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomMasterException(msg.toString());
	}

	/**
	 * Returns the first room master in the ordered set where cityId = &#63; and locationId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room master, or <code>null</code> if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster fetchByRoomByLocandCity_First(long cityId,
		long locationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<RoomMaster> list = findByRoomByLocandCity(cityId, locationId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last room master in the ordered set where cityId = &#63; and locationId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster findByRoomByLocandCity_Last(long cityId, long locationId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = fetchByRoomByLocandCity_Last(cityId,
				locationId, orderByComparator);

		if (roomMaster != null) {
			return roomMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityId=");
		msg.append(cityId);

		msg.append(", locationId=");
		msg.append(locationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomMasterException(msg.toString());
	}

	/**
	 * Returns the last room master in the ordered set where cityId = &#63; and locationId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room master, or <code>null</code> if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster fetchByRoomByLocandCity_Last(long cityId,
		long locationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByRoomByLocandCity(cityId, locationId);

		List<RoomMaster> list = findByRoomByLocandCity(cityId, locationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the room masters before and after the current room master in the ordered set where cityId = &#63; and locationId = &#63;.
	 *
	 * @param roomId the primary key of the current room master
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster[] findByRoomByLocandCity_PrevAndNext(long roomId,
		long cityId, long locationId, OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			RoomMaster[] array = new RoomMasterImpl[3];

			array[0] = getByRoomByLocandCity_PrevAndNext(session, roomMaster,
					cityId, locationId, orderByComparator, true);

			array[1] = roomMaster;

			array[2] = getByRoomByLocandCity_PrevAndNext(session, roomMaster,
					cityId, locationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RoomMaster getByRoomByLocandCity_PrevAndNext(Session session,
		RoomMaster roomMaster, long cityId, long locationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ROOMMASTER_WHERE);

		query.append(_FINDER_COLUMN_ROOMBYLOCANDCITY_CITYID_2);

		query.append(_FINDER_COLUMN_ROOMBYLOCANDCITY_LOCATIONID_2);

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
			query.append(RoomMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cityId);

		qPos.add(locationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(roomMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RoomMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the room masters where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param floorId the floor ID
	 * @return the matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByRoomByLocationCityFloor(long cityId,
		long locationId, long floorId) throws SystemException {
		return findByRoomByLocationCityFloor(cityId, locationId, floorId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the room masters where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param floorId the floor ID
	 * @param start the lower bound of the range of room masters
	 * @param end the upper bound of the range of room masters (not inclusive)
	 * @return the range of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByRoomByLocationCityFloor(long cityId,
		long locationId, long floorId, int start, int end)
		throws SystemException {
		return findByRoomByLocationCityFloor(cityId, locationId, floorId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the room masters where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param floorId the floor ID
	 * @param start the lower bound of the range of room masters
	 * @param end the upper bound of the range of room masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findByRoomByLocationCityFloor(long cityId,
		long locationId, long floorId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMBYLOCATIONCITYFLOOR;
			finderArgs = new Object[] { cityId, locationId, floorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOMBYLOCATIONCITYFLOOR;
			finderArgs = new Object[] {
					cityId, locationId, floorId,
					
					start, end, orderByComparator
				};
		}

		List<RoomMaster> list = (List<RoomMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RoomMaster roomMaster : list) {
				if ((cityId != roomMaster.getCityId()) ||
						(locationId != roomMaster.getLocationId()) ||
						(floorId != roomMaster.getFloorId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ROOMMASTER_WHERE);

			query.append(_FINDER_COLUMN_ROOMBYLOCATIONCITYFLOOR_CITYID_2);

			query.append(_FINDER_COLUMN_ROOMBYLOCATIONCITYFLOOR_LOCATIONID_2);

			query.append(_FINDER_COLUMN_ROOMBYLOCATIONCITYFLOOR_FLOORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(RoomMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cityId);

				qPos.add(locationId);

				qPos.add(floorId);

				list = (List<RoomMaster>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first room master in the ordered set where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param floorId the floor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster findByRoomByLocationCityFloor_First(long cityId,
		long locationId, long floorId, OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = fetchByRoomByLocationCityFloor_First(cityId,
				locationId, floorId, orderByComparator);

		if (roomMaster != null) {
			return roomMaster;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityId=");
		msg.append(cityId);

		msg.append(", locationId=");
		msg.append(locationId);

		msg.append(", floorId=");
		msg.append(floorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomMasterException(msg.toString());
	}

	/**
	 * Returns the first room master in the ordered set where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param floorId the floor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room master, or <code>null</code> if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster fetchByRoomByLocationCityFloor_First(long cityId,
		long locationId, long floorId, OrderByComparator orderByComparator)
		throws SystemException {
		List<RoomMaster> list = findByRoomByLocationCityFloor(cityId,
				locationId, floorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last room master in the ordered set where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param floorId the floor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster findByRoomByLocationCityFloor_Last(long cityId,
		long locationId, long floorId, OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = fetchByRoomByLocationCityFloor_Last(cityId,
				locationId, floorId, orderByComparator);

		if (roomMaster != null) {
			return roomMaster;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityId=");
		msg.append(cityId);

		msg.append(", locationId=");
		msg.append(locationId);

		msg.append(", floorId=");
		msg.append(floorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRoomMasterException(msg.toString());
	}

	/**
	 * Returns the last room master in the ordered set where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param floorId the floor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room master, or <code>null</code> if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster fetchByRoomByLocationCityFloor_Last(long cityId,
		long locationId, long floorId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByRoomByLocationCityFloor(cityId, locationId, floorId);

		List<RoomMaster> list = findByRoomByLocationCityFloor(cityId,
				locationId, floorId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the room masters before and after the current room master in the ordered set where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	 *
	 * @param roomId the primary key of the current room master
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param floorId the floor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a room master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster[] findByRoomByLocationCityFloor_PrevAndNext(long roomId,
		long cityId, long locationId, long floorId,
		OrderByComparator orderByComparator)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			RoomMaster[] array = new RoomMasterImpl[3];

			array[0] = getByRoomByLocationCityFloor_PrevAndNext(session,
					roomMaster, cityId, locationId, floorId, orderByComparator,
					true);

			array[1] = roomMaster;

			array[2] = getByRoomByLocationCityFloor_PrevAndNext(session,
					roomMaster, cityId, locationId, floorId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RoomMaster getByRoomByLocationCityFloor_PrevAndNext(
		Session session, RoomMaster roomMaster, long cityId, long locationId,
		long floorId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ROOMMASTER_WHERE);

		query.append(_FINDER_COLUMN_ROOMBYLOCATIONCITYFLOOR_CITYID_2);

		query.append(_FINDER_COLUMN_ROOMBYLOCATIONCITYFLOOR_LOCATIONID_2);

		query.append(_FINDER_COLUMN_ROOMBYLOCATIONCITYFLOOR_FLOORID_2);

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
			query.append(RoomMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cityId);

		qPos.add(locationId);

		qPos.add(floorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(roomMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RoomMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the room master where roomName = &#63; or throws a {@link com.cignexdatamatics.wrm.NoSuchRoomMasterException} if it could not be found.
	 *
	 * @param roomName the room name
	 * @return the matching room master
	 * @throws com.cignexdatamatics.wrm.NoSuchRoomMasterException if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster findByRoomByRoomName(String roomName)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = fetchByRoomByRoomName(roomName);

		if (roomMaster == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("roomName=");
			msg.append(roomName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRoomMasterException(msg.toString());
		}

		return roomMaster;
	}

	/**
	 * Returns the room master where roomName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param roomName the room name
	 * @return the matching room master, or <code>null</code> if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster fetchByRoomByRoomName(String roomName)
		throws SystemException {
		return fetchByRoomByRoomName(roomName, true);
	}

	/**
	 * Returns the room master where roomName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param roomName the room name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching room master, or <code>null</code> if a matching room master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster fetchByRoomByRoomName(String roomName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { roomName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ROOMBYROOMNAME,
					finderArgs, this);
		}

		if (result instanceof RoomMaster) {
			RoomMaster roomMaster = (RoomMaster)result;

			if (!Validator.equals(roomName, roomMaster.getRoomName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ROOMMASTER_WHERE);

			if (roomName == null) {
				query.append(_FINDER_COLUMN_ROOMBYROOMNAME_ROOMNAME_1);
			}
			else {
				if (roomName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROOMBYROOMNAME_ROOMNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROOMBYROOMNAME_ROOMNAME_2);
				}
			}

			query.append(RoomMasterModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (roomName != null) {
					qPos.add(roomName);
				}

				List<RoomMaster> list = q.list();

				result = list;

				RoomMaster roomMaster = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROOMBYROOMNAME,
						finderArgs, list);
				}
				else {
					roomMaster = list.get(0);

					cacheResult(roomMaster);

					if ((roomMaster.getRoomName() == null) ||
							!roomMaster.getRoomName().equals(roomName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROOMBYROOMNAME,
							finderArgs, roomMaster);
					}
				}

				return roomMaster;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ROOMBYROOMNAME,
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
				return (RoomMaster)result;
			}
		}
	}

	/**
	 * Returns all the room masters.
	 *
	 * @return the room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the room masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of room masters
	 * @param end the upper bound of the range of room masters (not inclusive)
	 * @return the range of room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the room masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of room masters
	 * @param end the upper bound of the range of room masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of room masters
	 * @throws SystemException if a system exception occurred
	 */
	public List<RoomMaster> findAll(int start, int end,
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

		List<RoomMaster> list = (List<RoomMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ROOMMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ROOMMASTER.concat(RoomMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<RoomMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<RoomMaster>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the room masters where cityId = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCityId(long cityId) throws SystemException {
		for (RoomMaster roomMaster : findByCityId(cityId)) {
			remove(roomMaster);
		}
	}

	/**
	 * Removes all the room masters where locationId = &#63; from the database.
	 *
	 * @param locationId the location ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLocationId(long locationId) throws SystemException {
		for (RoomMaster roomMaster : findByLocationId(locationId)) {
			remove(roomMaster);
		}
	}

	/**
	 * Removes all the room masters where floorId = &#63; from the database.
	 *
	 * @param floorId the floor ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByFloorId(long floorId) throws SystemException {
		for (RoomMaster roomMaster : findByFloorId(floorId)) {
			remove(roomMaster);
		}
	}

	/**
	 * Removes all the room masters where cityId = &#63; and locationId = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByRoomByLocandCity(long cityId, long locationId)
		throws SystemException {
		for (RoomMaster roomMaster : findByRoomByLocandCity(cityId, locationId)) {
			remove(roomMaster);
		}
	}

	/**
	 * Removes all the room masters where cityId = &#63; and locationId = &#63; and floorId = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param floorId the floor ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByRoomByLocationCityFloor(long cityId, long locationId,
		long floorId) throws SystemException {
		for (RoomMaster roomMaster : findByRoomByLocationCityFloor(cityId,
				locationId, floorId)) {
			remove(roomMaster);
		}
	}

	/**
	 * Removes the room master where roomName = &#63; from the database.
	 *
	 * @param roomName the room name
	 * @return the room master that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public RoomMaster removeByRoomByRoomName(String roomName)
		throws NoSuchRoomMasterException, SystemException {
		RoomMaster roomMaster = findByRoomByRoomName(roomName);

		return remove(roomMaster);
	}

	/**
	 * Removes all the room masters from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (RoomMaster roomMaster : findAll()) {
			remove(roomMaster);
		}
	}

	/**
	 * Returns the number of room masters where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the number of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCityId(long cityId) throws SystemException {
		Object[] finderArgs = new Object[] { cityId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CITYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ROOMMASTER_WHERE);

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
	 * Returns the number of room masters where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the number of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLocationId(long locationId) throws SystemException {
		Object[] finderArgs = new Object[] { locationId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOCATIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ROOMMASTER_WHERE);

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
	 * Returns the number of room masters where floorId = &#63;.
	 *
	 * @param floorId the floor ID
	 * @return the number of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countByFloorId(long floorId) throws SystemException {
		Object[] finderArgs = new Object[] { floorId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FLOORID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ROOMMASTER_WHERE);

			query.append(_FINDER_COLUMN_FLOORID_FLOORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(floorId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FLOORID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of room masters where cityId = &#63; and locationId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @return the number of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countByRoomByLocandCity(long cityId, long locationId)
		throws SystemException {
		Object[] finderArgs = new Object[] { cityId, locationId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROOMBYLOCANDCITY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ROOMMASTER_WHERE);

			query.append(_FINDER_COLUMN_ROOMBYLOCANDCITY_CITYID_2);

			query.append(_FINDER_COLUMN_ROOMBYLOCANDCITY_LOCATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cityId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROOMBYLOCANDCITY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of room masters where cityId = &#63; and locationId = &#63; and floorId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param locationId the location ID
	 * @param floorId the floor ID
	 * @return the number of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countByRoomByLocationCityFloor(long cityId, long locationId,
		long floorId) throws SystemException {
		Object[] finderArgs = new Object[] { cityId, locationId, floorId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROOMBYLOCATIONCITYFLOOR,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ROOMMASTER_WHERE);

			query.append(_FINDER_COLUMN_ROOMBYLOCATIONCITYFLOOR_CITYID_2);

			query.append(_FINDER_COLUMN_ROOMBYLOCATIONCITYFLOOR_LOCATIONID_2);

			query.append(_FINDER_COLUMN_ROOMBYLOCATIONCITYFLOOR_FLOORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cityId);

				qPos.add(locationId);

				qPos.add(floorId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROOMBYLOCATIONCITYFLOOR,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of room masters where roomName = &#63;.
	 *
	 * @param roomName the room name
	 * @return the number of matching room masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countByRoomByRoomName(String roomName) throws SystemException {
		Object[] finderArgs = new Object[] { roomName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROOMBYROOMNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ROOMMASTER_WHERE);

			if (roomName == null) {
				query.append(_FINDER_COLUMN_ROOMBYROOMNAME_ROOMNAME_1);
			}
			else {
				if (roomName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROOMBYROOMNAME_ROOMNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROOMBYROOMNAME_ROOMNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (roomName != null) {
					qPos.add(roomName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROOMBYROOMNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of room masters.
	 *
	 * @return the number of room masters
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ROOMMASTER);

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
	 * Initializes the room master persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cignexdatamatics.wrm.model.RoomMaster")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RoomMaster>> listenersList = new ArrayList<ModelListener<RoomMaster>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RoomMaster>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RoomMasterImpl.class.getName());
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
	private static final String _SQL_SELECT_ROOMMASTER = "SELECT roomMaster FROM RoomMaster roomMaster";
	private static final String _SQL_SELECT_ROOMMASTER_WHERE = "SELECT roomMaster FROM RoomMaster roomMaster WHERE ";
	private static final String _SQL_COUNT_ROOMMASTER = "SELECT COUNT(roomMaster) FROM RoomMaster roomMaster";
	private static final String _SQL_COUNT_ROOMMASTER_WHERE = "SELECT COUNT(roomMaster) FROM RoomMaster roomMaster WHERE ";
	private static final String _FINDER_COLUMN_CITYID_CITYID_2 = "roomMaster.cityId = ?";
	private static final String _FINDER_COLUMN_LOCATIONID_LOCATIONID_2 = "roomMaster.locationId = ?";
	private static final String _FINDER_COLUMN_FLOORID_FLOORID_2 = "roomMaster.floorId = ?";
	private static final String _FINDER_COLUMN_ROOMBYLOCANDCITY_CITYID_2 = "roomMaster.cityId = ? AND ";
	private static final String _FINDER_COLUMN_ROOMBYLOCANDCITY_LOCATIONID_2 = "roomMaster.locationId = ?";
	private static final String _FINDER_COLUMN_ROOMBYLOCATIONCITYFLOOR_CITYID_2 = "roomMaster.cityId = ? AND ";
	private static final String _FINDER_COLUMN_ROOMBYLOCATIONCITYFLOOR_LOCATIONID_2 =
		"roomMaster.locationId = ? AND ";
	private static final String _FINDER_COLUMN_ROOMBYLOCATIONCITYFLOOR_FLOORID_2 =
		"roomMaster.floorId = ?";
	private static final String _FINDER_COLUMN_ROOMBYROOMNAME_ROOMNAME_1 = "roomMaster.roomName IS NULL";
	private static final String _FINDER_COLUMN_ROOMBYROOMNAME_ROOMNAME_2 = "roomMaster.roomName = ?";
	private static final String _FINDER_COLUMN_ROOMBYROOMNAME_ROOMNAME_3 = "(roomMaster.roomName IS NULL OR roomMaster.roomName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "roomMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RoomMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RoomMaster exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RoomMasterPersistenceImpl.class);
	private static RoomMaster _nullRoomMaster = new RoomMasterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RoomMaster> toCacheModel() {
				return _nullRoomMasterCacheModel;
			}
		};

	private static CacheModel<RoomMaster> _nullRoomMasterCacheModel = new CacheModel<RoomMaster>() {
			public RoomMaster toEntityModel() {
				return _nullRoomMaster;
			}
		};
}