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

import com.cignexdatamatics.wrm.NoSuchBookingAttendeesException;
import com.cignexdatamatics.wrm.model.BookingAttendees;
import com.cignexdatamatics.wrm.model.impl.BookingAttendeesImpl;
import com.cignexdatamatics.wrm.model.impl.BookingAttendeesModelImpl;

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
 * The persistence implementation for the booking attendees service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingAttendeesPersistence
 * @see BookingAttendeesUtil
 * @generated
 */
public class BookingAttendeesPersistenceImpl extends BasePersistenceImpl<BookingAttendees>
	implements BookingAttendeesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BookingAttendeesUtil} to access the booking attendees persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BookingAttendeesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTENDEESID =
		new FinderPath(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
			BookingAttendeesModelImpl.FINDER_CACHE_ENABLED,
			BookingAttendeesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAttendeesId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTENDEESID =
		new FinderPath(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
			BookingAttendeesModelImpl.FINDER_CACHE_ENABLED,
			BookingAttendeesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAttendeesId",
			new String[] { Long.class.getName() },
			BookingAttendeesModelImpl.ATTENDEESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ATTENDEESID = new FinderPath(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
			BookingAttendeesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAttendeesId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKINGID =
		new FinderPath(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
			BookingAttendeesModelImpl.FINDER_CACHE_ENABLED,
			BookingAttendeesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBookingId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID =
		new FinderPath(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
			BookingAttendeesModelImpl.FINDER_CACHE_ENABLED,
			BookingAttendeesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBookingId",
			new String[] { Long.class.getName() },
			BookingAttendeesModelImpl.BOOKINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKINGID = new FinderPath(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
			BookingAttendeesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBookingId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
			BookingAttendeesModelImpl.FINDER_CACHE_ENABLED,
			BookingAttendeesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
			BookingAttendeesModelImpl.FINDER_CACHE_ENABLED,
			BookingAttendeesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
			BookingAttendeesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the booking attendees in the entity cache if it is enabled.
	 *
	 * @param bookingAttendees the booking attendees
	 */
	public void cacheResult(BookingAttendees bookingAttendees) {
		EntityCacheUtil.putResult(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
			BookingAttendeesImpl.class, bookingAttendees.getPrimaryKey(),
			bookingAttendees);

		bookingAttendees.resetOriginalValues();
	}

	/**
	 * Caches the booking attendeeses in the entity cache if it is enabled.
	 *
	 * @param bookingAttendeeses the booking attendeeses
	 */
	public void cacheResult(List<BookingAttendees> bookingAttendeeses) {
		for (BookingAttendees bookingAttendees : bookingAttendeeses) {
			if (EntityCacheUtil.getResult(
						BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
						BookingAttendeesImpl.class,
						bookingAttendees.getPrimaryKey()) == null) {
				cacheResult(bookingAttendees);
			}
			else {
				bookingAttendees.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all booking attendeeses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BookingAttendeesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BookingAttendeesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the booking attendees.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BookingAttendees bookingAttendees) {
		EntityCacheUtil.removeResult(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
			BookingAttendeesImpl.class, bookingAttendees.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BookingAttendees> bookingAttendeeses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BookingAttendees bookingAttendees : bookingAttendeeses) {
			EntityCacheUtil.removeResult(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
				BookingAttendeesImpl.class, bookingAttendees.getPrimaryKey());
		}
	}

	/**
	 * Creates a new booking attendees with the primary key. Does not add the booking attendees to the database.
	 *
	 * @param bookingAttendeesPK the primary key for the new booking attendees
	 * @return the new booking attendees
	 */
	public BookingAttendees create(BookingAttendeesPK bookingAttendeesPK) {
		BookingAttendees bookingAttendees = new BookingAttendeesImpl();

		bookingAttendees.setNew(true);
		bookingAttendees.setPrimaryKey(bookingAttendeesPK);

		return bookingAttendees;
	}

	/**
	 * Removes the booking attendees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingAttendeesPK the primary key of the booking attendees
	 * @return the booking attendees that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a booking attendees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees remove(BookingAttendeesPK bookingAttendeesPK)
		throws NoSuchBookingAttendeesException, SystemException {
		return remove((Serializable)bookingAttendeesPK);
	}

	/**
	 * Removes the booking attendees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the booking attendees
	 * @return the booking attendees that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a booking attendees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingAttendees remove(Serializable primaryKey)
		throws NoSuchBookingAttendeesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BookingAttendees bookingAttendees = (BookingAttendees)session.get(BookingAttendeesImpl.class,
					primaryKey);

			if (bookingAttendees == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookingAttendeesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bookingAttendees);
		}
		catch (NoSuchBookingAttendeesException nsee) {
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
	protected BookingAttendees removeImpl(BookingAttendees bookingAttendees)
		throws SystemException {
		bookingAttendees = toUnwrappedModel(bookingAttendees);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, bookingAttendees);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(bookingAttendees);

		return bookingAttendees;
	}

	@Override
	public BookingAttendees updateImpl(
		com.cignexdatamatics.wrm.model.BookingAttendees bookingAttendees,
		boolean merge) throws SystemException {
		bookingAttendees = toUnwrappedModel(bookingAttendees);

		boolean isNew = bookingAttendees.isNew();

		BookingAttendeesModelImpl bookingAttendeesModelImpl = (BookingAttendeesModelImpl)bookingAttendees;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, bookingAttendees, merge);

			bookingAttendees.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BookingAttendeesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bookingAttendeesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTENDEESID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(bookingAttendeesModelImpl.getOriginalAttendeesId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTENDEESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTENDEESID,
					args);

				args = new Object[] {
						Long.valueOf(bookingAttendeesModelImpl.getAttendeesId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTENDEESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTENDEESID,
					args);
			}

			if ((bookingAttendeesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(bookingAttendeesModelImpl.getOriginalBookingId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKINGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID,
					args);

				args = new Object[] {
						Long.valueOf(bookingAttendeesModelImpl.getBookingId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKINGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID,
					args);
			}
		}

		EntityCacheUtil.putResult(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
			BookingAttendeesImpl.class, bookingAttendees.getPrimaryKey(),
			bookingAttendees);

		return bookingAttendees;
	}

	protected BookingAttendees toUnwrappedModel(
		BookingAttendees bookingAttendees) {
		if (bookingAttendees instanceof BookingAttendeesImpl) {
			return bookingAttendees;
		}

		BookingAttendeesImpl bookingAttendeesImpl = new BookingAttendeesImpl();

		bookingAttendeesImpl.setNew(bookingAttendees.isNew());
		bookingAttendeesImpl.setPrimaryKey(bookingAttendees.getPrimaryKey());

		bookingAttendeesImpl.setAttendeesId(bookingAttendees.getAttendeesId());
		bookingAttendeesImpl.setBookingId(bookingAttendees.getBookingId());

		return bookingAttendeesImpl;
	}

	/**
	 * Returns the booking attendees with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking attendees
	 * @return the booking attendees
	 * @throws com.liferay.portal.NoSuchModelException if a booking attendees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingAttendees findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((BookingAttendeesPK)primaryKey);
	}

	/**
	 * Returns the booking attendees with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchBookingAttendeesException} if it could not be found.
	 *
	 * @param bookingAttendeesPK the primary key of the booking attendees
	 * @return the booking attendees
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a booking attendees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees findByPrimaryKey(
		BookingAttendeesPK bookingAttendeesPK)
		throws NoSuchBookingAttendeesException, SystemException {
		BookingAttendees bookingAttendees = fetchByPrimaryKey(bookingAttendeesPK);

		if (bookingAttendees == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					bookingAttendeesPK);
			}

			throw new NoSuchBookingAttendeesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bookingAttendeesPK);
		}

		return bookingAttendees;
	}

	/**
	 * Returns the booking attendees with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking attendees
	 * @return the booking attendees, or <code>null</code> if a booking attendees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingAttendees fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((BookingAttendeesPK)primaryKey);
	}

	/**
	 * Returns the booking attendees with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingAttendeesPK the primary key of the booking attendees
	 * @return the booking attendees, or <code>null</code> if a booking attendees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees fetchByPrimaryKey(
		BookingAttendeesPK bookingAttendeesPK) throws SystemException {
		BookingAttendees bookingAttendees = (BookingAttendees)EntityCacheUtil.getResult(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
				BookingAttendeesImpl.class, bookingAttendeesPK);

		if (bookingAttendees == _nullBookingAttendees) {
			return null;
		}

		if (bookingAttendees == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				bookingAttendees = (BookingAttendees)session.get(BookingAttendeesImpl.class,
						bookingAttendeesPK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (bookingAttendees != null) {
					cacheResult(bookingAttendees);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BookingAttendeesModelImpl.ENTITY_CACHE_ENABLED,
						BookingAttendeesImpl.class, bookingAttendeesPK,
						_nullBookingAttendees);
				}

				closeSession(session);
			}
		}

		return bookingAttendees;
	}

	/**
	 * Returns all the booking attendeeses where attendeesId = &#63;.
	 *
	 * @param attendeesId the attendees ID
	 * @return the matching booking attendeeses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingAttendees> findByAttendeesId(long attendeesId)
		throws SystemException {
		return findByAttendeesId(attendeesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking attendeeses where attendeesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param attendeesId the attendees ID
	 * @param start the lower bound of the range of booking attendeeses
	 * @param end the upper bound of the range of booking attendeeses (not inclusive)
	 * @return the range of matching booking attendeeses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingAttendees> findByAttendeesId(long attendeesId,
		int start, int end) throws SystemException {
		return findByAttendeesId(attendeesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking attendeeses where attendeesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param attendeesId the attendees ID
	 * @param start the lower bound of the range of booking attendeeses
	 * @param end the upper bound of the range of booking attendeeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking attendeeses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingAttendees> findByAttendeesId(long attendeesId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTENDEESID;
			finderArgs = new Object[] { attendeesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTENDEESID;
			finderArgs = new Object[] { attendeesId, start, end, orderByComparator };
		}

		List<BookingAttendees> list = (List<BookingAttendees>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BookingAttendees bookingAttendees : list) {
				if ((attendeesId != bookingAttendees.getAttendeesId())) {
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

			query.append(_SQL_SELECT_BOOKINGATTENDEES_WHERE);

			query.append(_FINDER_COLUMN_ATTENDEESID_ATTENDEESID_2);

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

				qPos.add(attendeesId);

				list = (List<BookingAttendees>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first booking attendees in the ordered set where attendeesId = &#63;.
	 *
	 * @param attendeesId the attendees ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking attendees
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a matching booking attendees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees findByAttendeesId_First(long attendeesId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingAttendeesException, SystemException {
		BookingAttendees bookingAttendees = fetchByAttendeesId_First(attendeesId,
				orderByComparator);

		if (bookingAttendees != null) {
			return bookingAttendees;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attendeesId=");
		msg.append(attendeesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingAttendeesException(msg.toString());
	}

	/**
	 * Returns the first booking attendees in the ordered set where attendeesId = &#63;.
	 *
	 * @param attendeesId the attendees ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking attendees, or <code>null</code> if a matching booking attendees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees fetchByAttendeesId_First(long attendeesId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BookingAttendees> list = findByAttendeesId(attendeesId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking attendees in the ordered set where attendeesId = &#63;.
	 *
	 * @param attendeesId the attendees ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking attendees
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a matching booking attendees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees findByAttendeesId_Last(long attendeesId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingAttendeesException, SystemException {
		BookingAttendees bookingAttendees = fetchByAttendeesId_Last(attendeesId,
				orderByComparator);

		if (bookingAttendees != null) {
			return bookingAttendees;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attendeesId=");
		msg.append(attendeesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingAttendeesException(msg.toString());
	}

	/**
	 * Returns the last booking attendees in the ordered set where attendeesId = &#63;.
	 *
	 * @param attendeesId the attendees ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking attendees, or <code>null</code> if a matching booking attendees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees fetchByAttendeesId_Last(long attendeesId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAttendeesId(attendeesId);

		List<BookingAttendees> list = findByAttendeesId(attendeesId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking attendeeses before and after the current booking attendees in the ordered set where attendeesId = &#63;.
	 *
	 * @param bookingAttendeesPK the primary key of the current booking attendees
	 * @param attendeesId the attendees ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking attendees
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a booking attendees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees[] findByAttendeesId_PrevAndNext(
		BookingAttendeesPK bookingAttendeesPK, long attendeesId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingAttendeesException, SystemException {
		BookingAttendees bookingAttendees = findByPrimaryKey(bookingAttendeesPK);

		Session session = null;

		try {
			session = openSession();

			BookingAttendees[] array = new BookingAttendeesImpl[3];

			array[0] = getByAttendeesId_PrevAndNext(session, bookingAttendees,
					attendeesId, orderByComparator, true);

			array[1] = bookingAttendees;

			array[2] = getByAttendeesId_PrevAndNext(session, bookingAttendees,
					attendeesId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookingAttendees getByAttendeesId_PrevAndNext(Session session,
		BookingAttendees bookingAttendees, long attendeesId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKINGATTENDEES_WHERE);

		query.append(_FINDER_COLUMN_ATTENDEESID_ATTENDEESID_2);

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

		qPos.add(attendeesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bookingAttendees);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookingAttendees> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the booking attendeeses where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @return the matching booking attendeeses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingAttendees> findByBookingId(long bookingId)
		throws SystemException {
		return findByBookingId(bookingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the booking attendeeses where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of booking attendeeses
	 * @param end the upper bound of the range of booking attendeeses (not inclusive)
	 * @return the range of matching booking attendeeses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingAttendees> findByBookingId(long bookingId, int start,
		int end) throws SystemException {
		return findByBookingId(bookingId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking attendeeses where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of booking attendeeses
	 * @param end the upper bound of the range of booking attendeeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking attendeeses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingAttendees> findByBookingId(long bookingId, int start,
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

		List<BookingAttendees> list = (List<BookingAttendees>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BookingAttendees bookingAttendees : list) {
				if ((bookingId != bookingAttendees.getBookingId())) {
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

			query.append(_SQL_SELECT_BOOKINGATTENDEES_WHERE);

			query.append(_FINDER_COLUMN_BOOKINGID_BOOKINGID_2);

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

				qPos.add(bookingId);

				list = (List<BookingAttendees>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first booking attendees in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking attendees
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a matching booking attendees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees findByBookingId_First(long bookingId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingAttendeesException, SystemException {
		BookingAttendees bookingAttendees = fetchByBookingId_First(bookingId,
				orderByComparator);

		if (bookingAttendees != null) {
			return bookingAttendees;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookingId=");
		msg.append(bookingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingAttendeesException(msg.toString());
	}

	/**
	 * Returns the first booking attendees in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking attendees, or <code>null</code> if a matching booking attendees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees fetchByBookingId_First(long bookingId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BookingAttendees> list = findByBookingId(bookingId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking attendees in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking attendees
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a matching booking attendees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees findByBookingId_Last(long bookingId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingAttendeesException, SystemException {
		BookingAttendees bookingAttendees = fetchByBookingId_Last(bookingId,
				orderByComparator);

		if (bookingAttendees != null) {
			return bookingAttendees;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookingId=");
		msg.append(bookingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingAttendeesException(msg.toString());
	}

	/**
	 * Returns the last booking attendees in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking attendees, or <code>null</code> if a matching booking attendees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees fetchByBookingId_Last(long bookingId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBookingId(bookingId);

		List<BookingAttendees> list = findByBookingId(bookingId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking attendeeses before and after the current booking attendees in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingAttendeesPK the primary key of the current booking attendees
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking attendees
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingAttendeesException if a booking attendees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingAttendees[] findByBookingId_PrevAndNext(
		BookingAttendeesPK bookingAttendeesPK, long bookingId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingAttendeesException, SystemException {
		BookingAttendees bookingAttendees = findByPrimaryKey(bookingAttendeesPK);

		Session session = null;

		try {
			session = openSession();

			BookingAttendees[] array = new BookingAttendeesImpl[3];

			array[0] = getByBookingId_PrevAndNext(session, bookingAttendees,
					bookingId, orderByComparator, true);

			array[1] = bookingAttendees;

			array[2] = getByBookingId_PrevAndNext(session, bookingAttendees,
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

	protected BookingAttendees getByBookingId_PrevAndNext(Session session,
		BookingAttendees bookingAttendees, long bookingId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKINGATTENDEES_WHERE);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(bookingId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bookingAttendees);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookingAttendees> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the booking attendeeses.
	 *
	 * @return the booking attendeeses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingAttendees> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking attendeeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking attendeeses
	 * @param end the upper bound of the range of booking attendeeses (not inclusive)
	 * @return the range of booking attendeeses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingAttendees> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking attendeeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking attendeeses
	 * @param end the upper bound of the range of booking attendeeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of booking attendeeses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingAttendees> findAll(int start, int end,
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

		List<BookingAttendees> list = (List<BookingAttendees>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BOOKINGATTENDEES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKINGATTENDEES;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<BookingAttendees>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<BookingAttendees>)QueryUtil.list(q,
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
	 * Removes all the booking attendeeses where attendeesId = &#63; from the database.
	 *
	 * @param attendeesId the attendees ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAttendeesId(long attendeesId) throws SystemException {
		for (BookingAttendees bookingAttendees : findByAttendeesId(attendeesId)) {
			remove(bookingAttendees);
		}
	}

	/**
	 * Removes all the booking attendeeses where bookingId = &#63; from the database.
	 *
	 * @param bookingId the booking ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBookingId(long bookingId) throws SystemException {
		for (BookingAttendees bookingAttendees : findByBookingId(bookingId)) {
			remove(bookingAttendees);
		}
	}

	/**
	 * Removes all the booking attendeeses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (BookingAttendees bookingAttendees : findAll()) {
			remove(bookingAttendees);
		}
	}

	/**
	 * Returns the number of booking attendeeses where attendeesId = &#63;.
	 *
	 * @param attendeesId the attendees ID
	 * @return the number of matching booking attendeeses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAttendeesId(long attendeesId) throws SystemException {
		Object[] finderArgs = new Object[] { attendeesId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ATTENDEESID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKINGATTENDEES_WHERE);

			query.append(_FINDER_COLUMN_ATTENDEESID_ATTENDEESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attendeesId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ATTENDEESID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of booking attendeeses where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @return the number of matching booking attendeeses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBookingId(long bookingId) throws SystemException {
		Object[] finderArgs = new Object[] { bookingId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BOOKINGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKINGATTENDEES_WHERE);

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
	 * Returns the number of booking attendeeses.
	 *
	 * @return the number of booking attendeeses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOOKINGATTENDEES);

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
	 * Initializes the booking attendees persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cignexdatamatics.wrm.model.BookingAttendees")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BookingAttendees>> listenersList = new ArrayList<ModelListener<BookingAttendees>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BookingAttendees>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BookingAttendeesImpl.class.getName());
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
	private static final String _SQL_SELECT_BOOKINGATTENDEES = "SELECT bookingAttendees FROM BookingAttendees bookingAttendees";
	private static final String _SQL_SELECT_BOOKINGATTENDEES_WHERE = "SELECT bookingAttendees FROM BookingAttendees bookingAttendees WHERE ";
	private static final String _SQL_COUNT_BOOKINGATTENDEES = "SELECT COUNT(bookingAttendees) FROM BookingAttendees bookingAttendees";
	private static final String _SQL_COUNT_BOOKINGATTENDEES_WHERE = "SELECT COUNT(bookingAttendees) FROM BookingAttendees bookingAttendees WHERE ";
	private static final String _FINDER_COLUMN_ATTENDEESID_ATTENDEESID_2 = "bookingAttendees.id.attendeesId = ?";
	private static final String _FINDER_COLUMN_BOOKINGID_BOOKINGID_2 = "bookingAttendees.id.bookingId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bookingAttendees.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BookingAttendees exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BookingAttendees exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BookingAttendeesPersistenceImpl.class);
	private static BookingAttendees _nullBookingAttendees = new BookingAttendeesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BookingAttendees> toCacheModel() {
				return _nullBookingAttendeesCacheModel;
			}
		};

	private static CacheModel<BookingAttendees> _nullBookingAttendeesCacheModel = new CacheModel<BookingAttendees>() {
			public BookingAttendees toEntityModel() {
				return _nullBookingAttendees;
			}
		};
}