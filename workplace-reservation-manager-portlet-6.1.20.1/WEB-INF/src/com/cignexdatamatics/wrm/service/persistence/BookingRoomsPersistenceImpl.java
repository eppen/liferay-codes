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

import com.cignexdatamatics.wrm.NoSuchBookingRoomsException;
import com.cignexdatamatics.wrm.model.BookingRooms;
import com.cignexdatamatics.wrm.model.impl.BookingRoomsImpl;
import com.cignexdatamatics.wrm.model.impl.BookingRoomsModelImpl;

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
import com.liferay.portal.kernel.util.CalendarUtil;
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
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the booking rooms service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingRoomsPersistence
 * @see BookingRoomsUtil
 * @generated
 */
public class BookingRoomsPersistenceImpl extends BasePersistenceImpl<BookingRooms>
	implements BookingRoomsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BookingRoomsUtil} to access the booking rooms persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BookingRoomsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKINGID =
		new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, BookingRoomsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBookingId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID =
		new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, BookingRoomsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBookingId",
			new String[] { Long.class.getName() },
			BookingRoomsModelImpl.BOOKINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKINGID = new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBookingId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOMID = new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, BookingRoomsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoomId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID =
		new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, BookingRoomsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoomId",
			new String[] { Long.class.getName() },
			BookingRoomsModelImpl.ROOMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOMID = new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoomId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKINGDATE =
		new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, BookingRoomsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBookingDate",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGDATE =
		new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, BookingRoomsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBookingDate",
			new String[] { Date.class.getName() },
			BookingRoomsModelImpl.BOOKINGDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKINGDATE = new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBookingDate",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOMIDANDBOOKINGDATE =
		new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, BookingRoomsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRoomIdAndBookingDate",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMIDANDBOOKINGDATE =
		new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, BookingRoomsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRoomIdAndBookingDate",
			new String[] { Long.class.getName(), Date.class.getName() },
			BookingRoomsModelImpl.ROOMID_COLUMN_BITMASK |
			BookingRoomsModelImpl.BOOKINGDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOMIDANDBOOKINGDATE = new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRoomIdAndBookingDate",
			new String[] { Long.class.getName(), Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, BookingRoomsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, BookingRoomsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the booking rooms in the entity cache if it is enabled.
	 *
	 * @param bookingRooms the booking rooms
	 */
	public void cacheResult(BookingRooms bookingRooms) {
		EntityCacheUtil.putResult(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsImpl.class, bookingRooms.getPrimaryKey(), bookingRooms);

		bookingRooms.resetOriginalValues();
	}

	/**
	 * Caches the booking roomses in the entity cache if it is enabled.
	 *
	 * @param bookingRoomses the booking roomses
	 */
	public void cacheResult(List<BookingRooms> bookingRoomses) {
		for (BookingRooms bookingRooms : bookingRoomses) {
			if (EntityCacheUtil.getResult(
						BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
						BookingRoomsImpl.class, bookingRooms.getPrimaryKey()) == null) {
				cacheResult(bookingRooms);
			}
			else {
				bookingRooms.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all booking roomses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BookingRoomsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BookingRoomsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the booking rooms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BookingRooms bookingRooms) {
		EntityCacheUtil.removeResult(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsImpl.class, bookingRooms.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BookingRooms> bookingRoomses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BookingRooms bookingRooms : bookingRoomses) {
			EntityCacheUtil.removeResult(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
				BookingRoomsImpl.class, bookingRooms.getPrimaryKey());
		}
	}

	/**
	 * Creates a new booking rooms with the primary key. Does not add the booking rooms to the database.
	 *
	 * @param BRMappingId the primary key for the new booking rooms
	 * @return the new booking rooms
	 */
	public BookingRooms create(long BRMappingId) {
		BookingRooms bookingRooms = new BookingRoomsImpl();

		bookingRooms.setNew(true);
		bookingRooms.setPrimaryKey(BRMappingId);

		return bookingRooms;
	}

	/**
	 * Removes the booking rooms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param BRMappingId the primary key of the booking rooms
	 * @return the booking rooms that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a booking rooms with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms remove(long BRMappingId)
		throws NoSuchBookingRoomsException, SystemException {
		return remove(Long.valueOf(BRMappingId));
	}

	/**
	 * Removes the booking rooms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the booking rooms
	 * @return the booking rooms that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a booking rooms with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingRooms remove(Serializable primaryKey)
		throws NoSuchBookingRoomsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BookingRooms bookingRooms = (BookingRooms)session.get(BookingRoomsImpl.class,
					primaryKey);

			if (bookingRooms == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookingRoomsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bookingRooms);
		}
		catch (NoSuchBookingRoomsException nsee) {
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
	protected BookingRooms removeImpl(BookingRooms bookingRooms)
		throws SystemException {
		bookingRooms = toUnwrappedModel(bookingRooms);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, bookingRooms);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(bookingRooms);

		return bookingRooms;
	}

	@Override
	public BookingRooms updateImpl(
		com.cignexdatamatics.wrm.model.BookingRooms bookingRooms, boolean merge)
		throws SystemException {
		bookingRooms = toUnwrappedModel(bookingRooms);

		boolean isNew = bookingRooms.isNew();

		BookingRoomsModelImpl bookingRoomsModelImpl = (BookingRoomsModelImpl)bookingRooms;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, bookingRooms, merge);

			bookingRooms.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BookingRoomsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bookingRoomsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(bookingRoomsModelImpl.getOriginalBookingId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKINGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID,
					args);

				args = new Object[] {
						Long.valueOf(bookingRoomsModelImpl.getBookingId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKINGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID,
					args);
			}

			if ((bookingRoomsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(bookingRoomsModelImpl.getOriginalRoomId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID,
					args);

				args = new Object[] {
						Long.valueOf(bookingRoomsModelImpl.getRoomId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID,
					args);
			}

			if ((bookingRoomsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bookingRoomsModelImpl.getOriginalBookingDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKINGDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGDATE,
					args);

				args = new Object[] { bookingRoomsModelImpl.getBookingDate() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKINGDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGDATE,
					args);
			}

			if ((bookingRoomsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMIDANDBOOKINGDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(bookingRoomsModelImpl.getOriginalRoomId()),
						
						bookingRoomsModelImpl.getOriginalBookingDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMIDANDBOOKINGDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMIDANDBOOKINGDATE,
					args);

				args = new Object[] {
						Long.valueOf(bookingRoomsModelImpl.getRoomId()),
						
						bookingRoomsModelImpl.getBookingDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMIDANDBOOKINGDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMIDANDBOOKINGDATE,
					args);
			}
		}

		EntityCacheUtil.putResult(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomsImpl.class, bookingRooms.getPrimaryKey(), bookingRooms);

		return bookingRooms;
	}

	protected BookingRooms toUnwrappedModel(BookingRooms bookingRooms) {
		if (bookingRooms instanceof BookingRoomsImpl) {
			return bookingRooms;
		}

		BookingRoomsImpl bookingRoomsImpl = new BookingRoomsImpl();

		bookingRoomsImpl.setNew(bookingRooms.isNew());
		bookingRoomsImpl.setPrimaryKey(bookingRooms.getPrimaryKey());

		bookingRoomsImpl.setBRMappingId(bookingRooms.getBRMappingId());
		bookingRoomsImpl.setBookingId(bookingRooms.getBookingId());
		bookingRoomsImpl.setRoomId(bookingRooms.getRoomId());
		bookingRoomsImpl.setBookingDate(bookingRooms.getBookingDate());

		return bookingRoomsImpl;
	}

	/**
	 * Returns the booking rooms with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking rooms
	 * @return the booking rooms
	 * @throws com.liferay.portal.NoSuchModelException if a booking rooms with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingRooms findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the booking rooms with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchBookingRoomsException} if it could not be found.
	 *
	 * @param BRMappingId the primary key of the booking rooms
	 * @return the booking rooms
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a booking rooms with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms findByPrimaryKey(long BRMappingId)
		throws NoSuchBookingRoomsException, SystemException {
		BookingRooms bookingRooms = fetchByPrimaryKey(BRMappingId);

		if (bookingRooms == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + BRMappingId);
			}

			throw new NoSuchBookingRoomsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				BRMappingId);
		}

		return bookingRooms;
	}

	/**
	 * Returns the booking rooms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking rooms
	 * @return the booking rooms, or <code>null</code> if a booking rooms with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingRooms fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the booking rooms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param BRMappingId the primary key of the booking rooms
	 * @return the booking rooms, or <code>null</code> if a booking rooms with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms fetchByPrimaryKey(long BRMappingId)
		throws SystemException {
		BookingRooms bookingRooms = (BookingRooms)EntityCacheUtil.getResult(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
				BookingRoomsImpl.class, BRMappingId);

		if (bookingRooms == _nullBookingRooms) {
			return null;
		}

		if (bookingRooms == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				bookingRooms = (BookingRooms)session.get(BookingRoomsImpl.class,
						Long.valueOf(BRMappingId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (bookingRooms != null) {
					cacheResult(bookingRooms);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BookingRoomsModelImpl.ENTITY_CACHE_ENABLED,
						BookingRoomsImpl.class, BRMappingId, _nullBookingRooms);
				}

				closeSession(session);
			}
		}

		return bookingRooms;
	}

	/**
	 * Returns all the booking roomses where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @return the matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findByBookingId(long bookingId)
		throws SystemException {
		return findByBookingId(bookingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the booking roomses where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of booking roomses
	 * @param end the upper bound of the range of booking roomses (not inclusive)
	 * @return the range of matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findByBookingId(long bookingId, int start, int end)
		throws SystemException {
		return findByBookingId(bookingId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking roomses where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of booking roomses
	 * @param end the upper bound of the range of booking roomses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findByBookingId(long bookingId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID;
			finderArgs = new Object[] { bookingId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKINGID;
			finderArgs = new Object[] { bookingId, start, end, orderByComparator };
		}

		List<BookingRooms> list = (List<BookingRooms>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BookingRooms bookingRooms : list) {
				if ((bookingId != bookingRooms.getBookingId())) {
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

			query.append(_SQL_SELECT_BOOKINGROOMS_WHERE);

			query.append(_FINDER_COLUMN_BOOKINGID_BOOKINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BookingRoomsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bookingId);

				list = (List<BookingRooms>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first booking rooms in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking rooms
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms findByBookingId_First(long bookingId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingRoomsException, SystemException {
		BookingRooms bookingRooms = fetchByBookingId_First(bookingId,
				orderByComparator);

		if (bookingRooms != null) {
			return bookingRooms;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookingId=");
		msg.append(bookingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingRoomsException(msg.toString());
	}

	/**
	 * Returns the first booking rooms in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms fetchByBookingId_First(long bookingId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BookingRooms> list = findByBookingId(bookingId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking rooms in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking rooms
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms findByBookingId_Last(long bookingId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingRoomsException, SystemException {
		BookingRooms bookingRooms = fetchByBookingId_Last(bookingId,
				orderByComparator);

		if (bookingRooms != null) {
			return bookingRooms;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookingId=");
		msg.append(bookingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingRoomsException(msg.toString());
	}

	/**
	 * Returns the last booking rooms in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms fetchByBookingId_Last(long bookingId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBookingId(bookingId);

		List<BookingRooms> list = findByBookingId(bookingId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking roomses before and after the current booking rooms in the ordered set where bookingId = &#63;.
	 *
	 * @param BRMappingId the primary key of the current booking rooms
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking rooms
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a booking rooms with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms[] findByBookingId_PrevAndNext(long BRMappingId,
		long bookingId, OrderByComparator orderByComparator)
		throws NoSuchBookingRoomsException, SystemException {
		BookingRooms bookingRooms = findByPrimaryKey(BRMappingId);

		Session session = null;

		try {
			session = openSession();

			BookingRooms[] array = new BookingRoomsImpl[3];

			array[0] = getByBookingId_PrevAndNext(session, bookingRooms,
					bookingId, orderByComparator, true);

			array[1] = bookingRooms;

			array[2] = getByBookingId_PrevAndNext(session, bookingRooms,
					bookingId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookingRooms getByBookingId_PrevAndNext(Session session,
		BookingRooms bookingRooms, long bookingId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKINGROOMS_WHERE);

		query.append(_FINDER_COLUMN_BOOKINGID_BOOKINGID_2);

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
			query.append(BookingRoomsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(bookingId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bookingRooms);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookingRooms> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the booking roomses where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @return the matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findByRoomId(long roomId)
		throws SystemException {
		return findByRoomId(roomId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking roomses where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param roomId the room ID
	 * @param start the lower bound of the range of booking roomses
	 * @param end the upper bound of the range of booking roomses (not inclusive)
	 * @return the range of matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findByRoomId(long roomId, int start, int end)
		throws SystemException {
		return findByRoomId(roomId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking roomses where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param roomId the room ID
	 * @param start the lower bound of the range of booking roomses
	 * @param end the upper bound of the range of booking roomses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findByRoomId(long roomId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<BookingRooms> list = (List<BookingRooms>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BookingRooms bookingRooms : list) {
				if ((roomId != bookingRooms.getRoomId())) {
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

			query.append(_SQL_SELECT_BOOKINGROOMS_WHERE);

			query.append(_FINDER_COLUMN_ROOMID_ROOMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BookingRoomsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roomId);

				list = (List<BookingRooms>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first booking rooms in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking rooms
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms findByRoomId_First(long roomId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingRoomsException, SystemException {
		BookingRooms bookingRooms = fetchByRoomId_First(roomId,
				orderByComparator);

		if (bookingRooms != null) {
			return bookingRooms;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roomId=");
		msg.append(roomId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingRoomsException(msg.toString());
	}

	/**
	 * Returns the first booking rooms in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms fetchByRoomId_First(long roomId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BookingRooms> list = findByRoomId(roomId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking rooms in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking rooms
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms findByRoomId_Last(long roomId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingRoomsException, SystemException {
		BookingRooms bookingRooms = fetchByRoomId_Last(roomId, orderByComparator);

		if (bookingRooms != null) {
			return bookingRooms;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roomId=");
		msg.append(roomId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingRoomsException(msg.toString());
	}

	/**
	 * Returns the last booking rooms in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms fetchByRoomId_Last(long roomId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRoomId(roomId);

		List<BookingRooms> list = findByRoomId(roomId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking roomses before and after the current booking rooms in the ordered set where roomId = &#63;.
	 *
	 * @param BRMappingId the primary key of the current booking rooms
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking rooms
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a booking rooms with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms[] findByRoomId_PrevAndNext(long BRMappingId,
		long roomId, OrderByComparator orderByComparator)
		throws NoSuchBookingRoomsException, SystemException {
		BookingRooms bookingRooms = findByPrimaryKey(BRMappingId);

		Session session = null;

		try {
			session = openSession();

			BookingRooms[] array = new BookingRoomsImpl[3];

			array[0] = getByRoomId_PrevAndNext(session, bookingRooms, roomId,
					orderByComparator, true);

			array[1] = bookingRooms;

			array[2] = getByRoomId_PrevAndNext(session, bookingRooms, roomId,
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

	protected BookingRooms getByRoomId_PrevAndNext(Session session,
		BookingRooms bookingRooms, long roomId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKINGROOMS_WHERE);

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

		else {
			query.append(BookingRoomsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(roomId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bookingRooms);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookingRooms> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the booking roomses where bookingDate = &#63;.
	 *
	 * @param bookingDate the booking date
	 * @return the matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findByBookingDate(Date bookingDate)
		throws SystemException {
		return findByBookingDate(bookingDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking roomses where bookingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookingDate the booking date
	 * @param start the lower bound of the range of booking roomses
	 * @param end the upper bound of the range of booking roomses (not inclusive)
	 * @return the range of matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findByBookingDate(Date bookingDate, int start,
		int end) throws SystemException {
		return findByBookingDate(bookingDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking roomses where bookingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookingDate the booking date
	 * @param start the lower bound of the range of booking roomses
	 * @param end the upper bound of the range of booking roomses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findByBookingDate(Date bookingDate, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGDATE;
			finderArgs = new Object[] { bookingDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKINGDATE;
			finderArgs = new Object[] { bookingDate, start, end, orderByComparator };
		}

		List<BookingRooms> list = (List<BookingRooms>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BookingRooms bookingRooms : list) {
				if (!Validator.equals(bookingDate, bookingRooms.getBookingDate())) {
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

			query.append(_SQL_SELECT_BOOKINGROOMS_WHERE);

			if (bookingDate == null) {
				query.append(_FINDER_COLUMN_BOOKINGDATE_BOOKINGDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_BOOKINGDATE_BOOKINGDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BookingRoomsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bookingDate != null) {
					qPos.add(CalendarUtil.getTimestamp(bookingDate));
				}

				list = (List<BookingRooms>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first booking rooms in the ordered set where bookingDate = &#63;.
	 *
	 * @param bookingDate the booking date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking rooms
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms findByBookingDate_First(Date bookingDate,
		OrderByComparator orderByComparator)
		throws NoSuchBookingRoomsException, SystemException {
		BookingRooms bookingRooms = fetchByBookingDate_First(bookingDate,
				orderByComparator);

		if (bookingRooms != null) {
			return bookingRooms;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookingDate=");
		msg.append(bookingDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingRoomsException(msg.toString());
	}

	/**
	 * Returns the first booking rooms in the ordered set where bookingDate = &#63;.
	 *
	 * @param bookingDate the booking date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms fetchByBookingDate_First(Date bookingDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<BookingRooms> list = findByBookingDate(bookingDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking rooms in the ordered set where bookingDate = &#63;.
	 *
	 * @param bookingDate the booking date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking rooms
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms findByBookingDate_Last(Date bookingDate,
		OrderByComparator orderByComparator)
		throws NoSuchBookingRoomsException, SystemException {
		BookingRooms bookingRooms = fetchByBookingDate_Last(bookingDate,
				orderByComparator);

		if (bookingRooms != null) {
			return bookingRooms;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookingDate=");
		msg.append(bookingDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingRoomsException(msg.toString());
	}

	/**
	 * Returns the last booking rooms in the ordered set where bookingDate = &#63;.
	 *
	 * @param bookingDate the booking date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms fetchByBookingDate_Last(Date bookingDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBookingDate(bookingDate);

		List<BookingRooms> list = findByBookingDate(bookingDate, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking roomses before and after the current booking rooms in the ordered set where bookingDate = &#63;.
	 *
	 * @param BRMappingId the primary key of the current booking rooms
	 * @param bookingDate the booking date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking rooms
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a booking rooms with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms[] findByBookingDate_PrevAndNext(long BRMappingId,
		Date bookingDate, OrderByComparator orderByComparator)
		throws NoSuchBookingRoomsException, SystemException {
		BookingRooms bookingRooms = findByPrimaryKey(BRMappingId);

		Session session = null;

		try {
			session = openSession();

			BookingRooms[] array = new BookingRoomsImpl[3];

			array[0] = getByBookingDate_PrevAndNext(session, bookingRooms,
					bookingDate, orderByComparator, true);

			array[1] = bookingRooms;

			array[2] = getByBookingDate_PrevAndNext(session, bookingRooms,
					bookingDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookingRooms getByBookingDate_PrevAndNext(Session session,
		BookingRooms bookingRooms, Date bookingDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKINGROOMS_WHERE);

		if (bookingDate == null) {
			query.append(_FINDER_COLUMN_BOOKINGDATE_BOOKINGDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_BOOKINGDATE_BOOKINGDATE_2);
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
			query.append(BookingRoomsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bookingDate != null) {
			qPos.add(CalendarUtil.getTimestamp(bookingDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bookingRooms);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookingRooms> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the booking roomses where roomId = &#63; and bookingDate = &#63;.
	 *
	 * @param roomId the room ID
	 * @param bookingDate the booking date
	 * @return the matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findByRoomIdAndBookingDate(long roomId,
		Date bookingDate) throws SystemException {
		return findByRoomIdAndBookingDate(roomId, bookingDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking roomses where roomId = &#63; and bookingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param roomId the room ID
	 * @param bookingDate the booking date
	 * @param start the lower bound of the range of booking roomses
	 * @param end the upper bound of the range of booking roomses (not inclusive)
	 * @return the range of matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findByRoomIdAndBookingDate(long roomId,
		Date bookingDate, int start, int end) throws SystemException {
		return findByRoomIdAndBookingDate(roomId, bookingDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking roomses where roomId = &#63; and bookingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param roomId the room ID
	 * @param bookingDate the booking date
	 * @param start the lower bound of the range of booking roomses
	 * @param end the upper bound of the range of booking roomses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findByRoomIdAndBookingDate(long roomId,
		Date bookingDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMIDANDBOOKINGDATE;
			finderArgs = new Object[] { roomId, bookingDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOMIDANDBOOKINGDATE;
			finderArgs = new Object[] {
					roomId, bookingDate,
					
					start, end, orderByComparator
				};
		}

		List<BookingRooms> list = (List<BookingRooms>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BookingRooms bookingRooms : list) {
				if ((roomId != bookingRooms.getRoomId()) ||
						!Validator.equals(bookingDate,
							bookingRooms.getBookingDate())) {
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

			query.append(_SQL_SELECT_BOOKINGROOMS_WHERE);

			query.append(_FINDER_COLUMN_ROOMIDANDBOOKINGDATE_ROOMID_2);

			if (bookingDate == null) {
				query.append(_FINDER_COLUMN_ROOMIDANDBOOKINGDATE_BOOKINGDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_ROOMIDANDBOOKINGDATE_BOOKINGDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BookingRoomsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roomId);

				if (bookingDate != null) {
					qPos.add(CalendarUtil.getTimestamp(bookingDate));
				}

				list = (List<BookingRooms>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first booking rooms in the ordered set where roomId = &#63; and bookingDate = &#63;.
	 *
	 * @param roomId the room ID
	 * @param bookingDate the booking date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking rooms
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms findByRoomIdAndBookingDate_First(long roomId,
		Date bookingDate, OrderByComparator orderByComparator)
		throws NoSuchBookingRoomsException, SystemException {
		BookingRooms bookingRooms = fetchByRoomIdAndBookingDate_First(roomId,
				bookingDate, orderByComparator);

		if (bookingRooms != null) {
			return bookingRooms;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roomId=");
		msg.append(roomId);

		msg.append(", bookingDate=");
		msg.append(bookingDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingRoomsException(msg.toString());
	}

	/**
	 * Returns the first booking rooms in the ordered set where roomId = &#63; and bookingDate = &#63;.
	 *
	 * @param roomId the room ID
	 * @param bookingDate the booking date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms fetchByRoomIdAndBookingDate_First(long roomId,
		Date bookingDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<BookingRooms> list = findByRoomIdAndBookingDate(roomId,
				bookingDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking rooms in the ordered set where roomId = &#63; and bookingDate = &#63;.
	 *
	 * @param roomId the room ID
	 * @param bookingDate the booking date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking rooms
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms findByRoomIdAndBookingDate_Last(long roomId,
		Date bookingDate, OrderByComparator orderByComparator)
		throws NoSuchBookingRoomsException, SystemException {
		BookingRooms bookingRooms = fetchByRoomIdAndBookingDate_Last(roomId,
				bookingDate, orderByComparator);

		if (bookingRooms != null) {
			return bookingRooms;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roomId=");
		msg.append(roomId);

		msg.append(", bookingDate=");
		msg.append(bookingDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingRoomsException(msg.toString());
	}

	/**
	 * Returns the last booking rooms in the ordered set where roomId = &#63; and bookingDate = &#63;.
	 *
	 * @param roomId the room ID
	 * @param bookingDate the booking date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking rooms, or <code>null</code> if a matching booking rooms could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms fetchByRoomIdAndBookingDate_Last(long roomId,
		Date bookingDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByRoomIdAndBookingDate(roomId, bookingDate);

		List<BookingRooms> list = findByRoomIdAndBookingDate(roomId,
				bookingDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking roomses before and after the current booking rooms in the ordered set where roomId = &#63; and bookingDate = &#63;.
	 *
	 * @param BRMappingId the primary key of the current booking rooms
	 * @param roomId the room ID
	 * @param bookingDate the booking date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking rooms
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingRoomsException if a booking rooms with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingRooms[] findByRoomIdAndBookingDate_PrevAndNext(
		long BRMappingId, long roomId, Date bookingDate,
		OrderByComparator orderByComparator)
		throws NoSuchBookingRoomsException, SystemException {
		BookingRooms bookingRooms = findByPrimaryKey(BRMappingId);

		Session session = null;

		try {
			session = openSession();

			BookingRooms[] array = new BookingRoomsImpl[3];

			array[0] = getByRoomIdAndBookingDate_PrevAndNext(session,
					bookingRooms, roomId, bookingDate, orderByComparator, true);

			array[1] = bookingRooms;

			array[2] = getByRoomIdAndBookingDate_PrevAndNext(session,
					bookingRooms, roomId, bookingDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookingRooms getByRoomIdAndBookingDate_PrevAndNext(
		Session session, BookingRooms bookingRooms, long roomId,
		Date bookingDate, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKINGROOMS_WHERE);

		query.append(_FINDER_COLUMN_ROOMIDANDBOOKINGDATE_ROOMID_2);

		if (bookingDate == null) {
			query.append(_FINDER_COLUMN_ROOMIDANDBOOKINGDATE_BOOKINGDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_ROOMIDANDBOOKINGDATE_BOOKINGDATE_2);
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
			query.append(BookingRoomsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(roomId);

		if (bookingDate != null) {
			qPos.add(CalendarUtil.getTimestamp(bookingDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bookingRooms);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookingRooms> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the booking roomses.
	 *
	 * @return the booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking roomses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking roomses
	 * @param end the upper bound of the range of booking roomses (not inclusive)
	 * @return the range of booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking roomses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking roomses
	 * @param end the upper bound of the range of booking roomses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingRooms> findAll(int start, int end,
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

		List<BookingRooms> list = (List<BookingRooms>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BOOKINGROOMS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKINGROOMS.concat(BookingRoomsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<BookingRooms>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<BookingRooms>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the booking roomses where bookingId = &#63; from the database.
	 *
	 * @param bookingId the booking ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBookingId(long bookingId) throws SystemException {
		for (BookingRooms bookingRooms : findByBookingId(bookingId)) {
			remove(bookingRooms);
		}
	}

	/**
	 * Removes all the booking roomses where roomId = &#63; from the database.
	 *
	 * @param roomId the room ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByRoomId(long roomId) throws SystemException {
		for (BookingRooms bookingRooms : findByRoomId(roomId)) {
			remove(bookingRooms);
		}
	}

	/**
	 * Removes all the booking roomses where bookingDate = &#63; from the database.
	 *
	 * @param bookingDate the booking date
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBookingDate(Date bookingDate) throws SystemException {
		for (BookingRooms bookingRooms : findByBookingDate(bookingDate)) {
			remove(bookingRooms);
		}
	}

	/**
	 * Removes all the booking roomses where roomId = &#63; and bookingDate = &#63; from the database.
	 *
	 * @param roomId the room ID
	 * @param bookingDate the booking date
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByRoomIdAndBookingDate(long roomId, Date bookingDate)
		throws SystemException {
		for (BookingRooms bookingRooms : findByRoomIdAndBookingDate(roomId,
				bookingDate)) {
			remove(bookingRooms);
		}
	}

	/**
	 * Removes all the booking roomses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (BookingRooms bookingRooms : findAll()) {
			remove(bookingRooms);
		}
	}

	/**
	 * Returns the number of booking roomses where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @return the number of matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBookingId(long bookingId) throws SystemException {
		Object[] finderArgs = new Object[] { bookingId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BOOKINGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKINGROOMS_WHERE);

			query.append(_FINDER_COLUMN_BOOKINGID_BOOKINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bookingId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BOOKINGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of booking roomses where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @return the number of matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByRoomId(long roomId) throws SystemException {
		Object[] finderArgs = new Object[] { roomId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROOMID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKINGROOMS_WHERE);

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
	 * Returns the number of booking roomses where bookingDate = &#63;.
	 *
	 * @param bookingDate the booking date
	 * @return the number of matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBookingDate(Date bookingDate) throws SystemException {
		Object[] finderArgs = new Object[] { bookingDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BOOKINGDATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKINGROOMS_WHERE);

			if (bookingDate == null) {
				query.append(_FINDER_COLUMN_BOOKINGDATE_BOOKINGDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_BOOKINGDATE_BOOKINGDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bookingDate != null) {
					qPos.add(CalendarUtil.getTimestamp(bookingDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BOOKINGDATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of booking roomses where roomId = &#63; and bookingDate = &#63;.
	 *
	 * @param roomId the room ID
	 * @param bookingDate the booking date
	 * @return the number of matching booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByRoomIdAndBookingDate(long roomId, Date bookingDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { roomId, bookingDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROOMIDANDBOOKINGDATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BOOKINGROOMS_WHERE);

			query.append(_FINDER_COLUMN_ROOMIDANDBOOKINGDATE_ROOMID_2);

			if (bookingDate == null) {
				query.append(_FINDER_COLUMN_ROOMIDANDBOOKINGDATE_BOOKINGDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_ROOMIDANDBOOKINGDATE_BOOKINGDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roomId);

				if (bookingDate != null) {
					qPos.add(CalendarUtil.getTimestamp(bookingDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROOMIDANDBOOKINGDATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of booking roomses.
	 *
	 * @return the number of booking roomses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOOKINGROOMS);

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
	 * Initializes the booking rooms persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cignexdatamatics.wrm.model.BookingRooms")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BookingRooms>> listenersList = new ArrayList<ModelListener<BookingRooms>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BookingRooms>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BookingRoomsImpl.class.getName());
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
	private static final String _SQL_SELECT_BOOKINGROOMS = "SELECT bookingRooms FROM BookingRooms bookingRooms";
	private static final String _SQL_SELECT_BOOKINGROOMS_WHERE = "SELECT bookingRooms FROM BookingRooms bookingRooms WHERE ";
	private static final String _SQL_COUNT_BOOKINGROOMS = "SELECT COUNT(bookingRooms) FROM BookingRooms bookingRooms";
	private static final String _SQL_COUNT_BOOKINGROOMS_WHERE = "SELECT COUNT(bookingRooms) FROM BookingRooms bookingRooms WHERE ";
	private static final String _FINDER_COLUMN_BOOKINGID_BOOKINGID_2 = "bookingRooms.bookingId = ?";
	private static final String _FINDER_COLUMN_ROOMID_ROOMID_2 = "bookingRooms.roomId = ?";
	private static final String _FINDER_COLUMN_BOOKINGDATE_BOOKINGDATE_1 = "bookingRooms.bookingDate IS NULL";
	private static final String _FINDER_COLUMN_BOOKINGDATE_BOOKINGDATE_2 = "bookingRooms.bookingDate = ?";
	private static final String _FINDER_COLUMN_ROOMIDANDBOOKINGDATE_ROOMID_2 = "bookingRooms.roomId = ? AND ";
	private static final String _FINDER_COLUMN_ROOMIDANDBOOKINGDATE_BOOKINGDATE_1 =
		"bookingRooms.bookingDate IS NULL";
	private static final String _FINDER_COLUMN_ROOMIDANDBOOKINGDATE_BOOKINGDATE_2 =
		"bookingRooms.bookingDate = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bookingRooms.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BookingRooms exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BookingRooms exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BookingRoomsPersistenceImpl.class);
	private static BookingRooms _nullBookingRooms = new BookingRoomsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BookingRooms> toCacheModel() {
				return _nullBookingRoomsCacheModel;
			}
		};

	private static CacheModel<BookingRooms> _nullBookingRoomsCacheModel = new CacheModel<BookingRooms>() {
			public BookingRooms toEntityModel() {
				return _nullBookingRooms;
			}
		};
}