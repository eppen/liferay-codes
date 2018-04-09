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

import com.cignexdatamatics.wrm.NoSuchNewBookingException;
import com.cignexdatamatics.wrm.model.NewBooking;
import com.cignexdatamatics.wrm.model.impl.NewBookingImpl;
import com.cignexdatamatics.wrm.model.impl.NewBookingModelImpl;

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
 * The persistence implementation for the new booking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewBookingPersistence
 * @see NewBookingUtil
 * @generated
 */
public class NewBookingPersistenceImpl extends BasePersistenceImpl<NewBooking>
	implements NewBookingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NewBookingUtil} to access the new booking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NewBookingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKEDROOMBYDATEANDTIME =
		new FinderPath(NewBookingModelImpl.ENTITY_CACHE_ENABLED,
			NewBookingModelImpl.FINDER_CACHE_ENABLED, NewBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBookedRoomByDateandTime",
			new String[] {
				Date.class.getName(), Date.class.getName(),
				String.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKEDROOMBYDATEANDTIME =
		new FinderPath(NewBookingModelImpl.ENTITY_CACHE_ENABLED,
			NewBookingModelImpl.FINDER_CACHE_ENABLED, NewBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBookedRoomByDateandTime",
			new String[] {
				Date.class.getName(), Date.class.getName(),
				String.class.getName(), String.class.getName()
			},
			NewBookingModelImpl.FROMDATE_COLUMN_BITMASK |
			NewBookingModelImpl.TODATE_COLUMN_BITMASK |
			NewBookingModelImpl.STARTTIME_COLUMN_BITMASK |
			NewBookingModelImpl.ENDTIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKEDROOMBYDATEANDTIME = new FinderPath(NewBookingModelImpl.ENTITY_CACHE_ENABLED,
			NewBookingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBookedRoomByDateandTime",
			new String[] {
				Date.class.getName(), Date.class.getName(),
				String.class.getName(), String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NewBookingModelImpl.ENTITY_CACHE_ENABLED,
			NewBookingModelImpl.FINDER_CACHE_ENABLED, NewBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NewBookingModelImpl.ENTITY_CACHE_ENABLED,
			NewBookingModelImpl.FINDER_CACHE_ENABLED, NewBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NewBookingModelImpl.ENTITY_CACHE_ENABLED,
			NewBookingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the new booking in the entity cache if it is enabled.
	 *
	 * @param newBooking the new booking
	 */
	public void cacheResult(NewBooking newBooking) {
		EntityCacheUtil.putResult(NewBookingModelImpl.ENTITY_CACHE_ENABLED,
			NewBookingImpl.class, newBooking.getPrimaryKey(), newBooking);

		newBooking.resetOriginalValues();
	}

	/**
	 * Caches the new bookings in the entity cache if it is enabled.
	 *
	 * @param newBookings the new bookings
	 */
	public void cacheResult(List<NewBooking> newBookings) {
		for (NewBooking newBooking : newBookings) {
			if (EntityCacheUtil.getResult(
						NewBookingModelImpl.ENTITY_CACHE_ENABLED,
						NewBookingImpl.class, newBooking.getPrimaryKey()) == null) {
				cacheResult(newBooking);
			}
			else {
				newBooking.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all new bookings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NewBookingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NewBookingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the new booking.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NewBooking newBooking) {
		EntityCacheUtil.removeResult(NewBookingModelImpl.ENTITY_CACHE_ENABLED,
			NewBookingImpl.class, newBooking.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NewBooking> newBookings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NewBooking newBooking : newBookings) {
			EntityCacheUtil.removeResult(NewBookingModelImpl.ENTITY_CACHE_ENABLED,
				NewBookingImpl.class, newBooking.getPrimaryKey());
		}
	}

	/**
	 * Creates a new new booking with the primary key. Does not add the new booking to the database.
	 *
	 * @param bookingId the primary key for the new new booking
	 * @return the new new booking
	 */
	public NewBooking create(long bookingId) {
		NewBooking newBooking = new NewBookingImpl();

		newBooking.setNew(true);
		newBooking.setPrimaryKey(bookingId);

		return newBooking;
	}

	/**
	 * Removes the new booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingId the primary key of the new booking
	 * @return the new booking that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchNewBookingException if a new booking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NewBooking remove(long bookingId)
		throws NoSuchNewBookingException, SystemException {
		return remove(Long.valueOf(bookingId));
	}

	/**
	 * Removes the new booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the new booking
	 * @return the new booking that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchNewBookingException if a new booking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NewBooking remove(Serializable primaryKey)
		throws NoSuchNewBookingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NewBooking newBooking = (NewBooking)session.get(NewBookingImpl.class,
					primaryKey);

			if (newBooking == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNewBookingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(newBooking);
		}
		catch (NoSuchNewBookingException nsee) {
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
	protected NewBooking removeImpl(NewBooking newBooking)
		throws SystemException {
		newBooking = toUnwrappedModel(newBooking);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, newBooking);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(newBooking);

		return newBooking;
	}

	@Override
	public NewBooking updateImpl(
		com.cignexdatamatics.wrm.model.NewBooking newBooking, boolean merge)
		throws SystemException {
		newBooking = toUnwrappedModel(newBooking);

		boolean isNew = newBooking.isNew();

		NewBookingModelImpl newBookingModelImpl = (NewBookingModelImpl)newBooking;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, newBooking, merge);

			newBooking.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NewBookingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((newBookingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKEDROOMBYDATEANDTIME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						newBookingModelImpl.getOriginalFromDate(),
						
						newBookingModelImpl.getOriginalToDate(),
						
						newBookingModelImpl.getOriginalStartTime(),
						
						newBookingModelImpl.getOriginalEndTime()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKEDROOMBYDATEANDTIME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKEDROOMBYDATEANDTIME,
					args);

				args = new Object[] {
						newBookingModelImpl.getFromDate(),
						
						newBookingModelImpl.getToDate(),
						
						newBookingModelImpl.getStartTime(),
						
						newBookingModelImpl.getEndTime()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKEDROOMBYDATEANDTIME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKEDROOMBYDATEANDTIME,
					args);
			}
		}

		EntityCacheUtil.putResult(NewBookingModelImpl.ENTITY_CACHE_ENABLED,
			NewBookingImpl.class, newBooking.getPrimaryKey(), newBooking);

		return newBooking;
	}

	protected NewBooking toUnwrappedModel(NewBooking newBooking) {
		if (newBooking instanceof NewBookingImpl) {
			return newBooking;
		}

		NewBookingImpl newBookingImpl = new NewBookingImpl();

		newBookingImpl.setNew(newBooking.isNew());
		newBookingImpl.setPrimaryKey(newBooking.getPrimaryKey());

		newBookingImpl.setBookingId(newBooking.getBookingId());
		newBookingImpl.setMeetingTitle(newBooking.getMeetingTitle());
		newBookingImpl.setMeetingDesc(newBooking.getMeetingDesc());
		newBookingImpl.setHostId(newBooking.getHostId());
		newBookingImpl.setFromDate(newBooking.getFromDate());
		newBookingImpl.setToDate(newBooking.getToDate());
		newBookingImpl.setStartTime(newBooking.getStartTime());
		newBookingImpl.setEndTime(newBooking.getEndTime());

		return newBookingImpl;
	}

	/**
	 * Returns the new booking with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the new booking
	 * @return the new booking
	 * @throws com.liferay.portal.NoSuchModelException if a new booking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NewBooking findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the new booking with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchNewBookingException} if it could not be found.
	 *
	 * @param bookingId the primary key of the new booking
	 * @return the new booking
	 * @throws com.cignexdatamatics.wrm.NoSuchNewBookingException if a new booking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NewBooking findByPrimaryKey(long bookingId)
		throws NoSuchNewBookingException, SystemException {
		NewBooking newBooking = fetchByPrimaryKey(bookingId);

		if (newBooking == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bookingId);
			}

			throw new NoSuchNewBookingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bookingId);
		}

		return newBooking;
	}

	/**
	 * Returns the new booking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the new booking
	 * @return the new booking, or <code>null</code> if a new booking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NewBooking fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the new booking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the new booking
	 * @return the new booking, or <code>null</code> if a new booking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NewBooking fetchByPrimaryKey(long bookingId)
		throws SystemException {
		NewBooking newBooking = (NewBooking)EntityCacheUtil.getResult(NewBookingModelImpl.ENTITY_CACHE_ENABLED,
				NewBookingImpl.class, bookingId);

		if (newBooking == _nullNewBooking) {
			return null;
		}

		if (newBooking == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				newBooking = (NewBooking)session.get(NewBookingImpl.class,
						Long.valueOf(bookingId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (newBooking != null) {
					cacheResult(newBooking);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(NewBookingModelImpl.ENTITY_CACHE_ENABLED,
						NewBookingImpl.class, bookingId, _nullNewBooking);
				}

				closeSession(session);
			}
		}

		return newBooking;
	}

	/**
	 * Returns all the new bookings where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param startTime the start time
	 * @param endTime the end time
	 * @return the matching new bookings
	 * @throws SystemException if a system exception occurred
	 */
	public List<NewBooking> findByBookedRoomByDateandTime(Date fromDate,
		Date toDate, String startTime, String endTime)
		throws SystemException {
		return findByBookedRoomByDateandTime(fromDate, toDate, startTime,
			endTime, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the new bookings where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param start the lower bound of the range of new bookings
	 * @param end the upper bound of the range of new bookings (not inclusive)
	 * @return the range of matching new bookings
	 * @throws SystemException if a system exception occurred
	 */
	public List<NewBooking> findByBookedRoomByDateandTime(Date fromDate,
		Date toDate, String startTime, String endTime, int start, int end)
		throws SystemException {
		return findByBookedRoomByDateandTime(fromDate, toDate, startTime,
			endTime, start, end, null);
	}

	/**
	 * Returns an ordered range of all the new bookings where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param start the lower bound of the range of new bookings
	 * @param end the upper bound of the range of new bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching new bookings
	 * @throws SystemException if a system exception occurred
	 */
	public List<NewBooking> findByBookedRoomByDateandTime(Date fromDate,
		Date toDate, String startTime, String endTime, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKEDROOMBYDATEANDTIME;
			finderArgs = new Object[] { fromDate, toDate, startTime, endTime };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKEDROOMBYDATEANDTIME;
			finderArgs = new Object[] {
					fromDate, toDate, startTime, endTime,
					
					start, end, orderByComparator
				};
		}

		List<NewBooking> list = (List<NewBooking>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (NewBooking newBooking : list) {
				if (!Validator.equals(fromDate, newBooking.getFromDate()) ||
						!Validator.equals(toDate, newBooking.getToDate()) ||
						!Validator.equals(startTime, newBooking.getStartTime()) ||
						!Validator.equals(endTime, newBooking.getEndTime())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_NEWBOOKING_WHERE);

			if (fromDate == null) {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_FROMDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_FROMDATE_2);
			}

			if (toDate == null) {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_TODATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_TODATE_2);
			}

			if (startTime == null) {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_STARTTIME_1);
			}
			else {
				if (startTime.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_STARTTIME_3);
				}
				else {
					query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_STARTTIME_2);
				}
			}

			if (endTime == null) {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_ENDTIME_1);
			}
			else {
				if (endTime.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_ENDTIME_3);
				}
				else {
					query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_ENDTIME_2);
				}
			}

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

				if (fromDate != null) {
					qPos.add(CalendarUtil.getTimestamp(fromDate));
				}

				if (toDate != null) {
					qPos.add(CalendarUtil.getTimestamp(toDate));
				}

				if (startTime != null) {
					qPos.add(startTime);
				}

				if (endTime != null) {
					qPos.add(endTime);
				}

				list = (List<NewBooking>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first new booking in the ordered set where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching new booking
	 * @throws com.cignexdatamatics.wrm.NoSuchNewBookingException if a matching new booking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NewBooking findByBookedRoomByDateandTime_First(Date fromDate,
		Date toDate, String startTime, String endTime,
		OrderByComparator orderByComparator)
		throws NoSuchNewBookingException, SystemException {
		NewBooking newBooking = fetchByBookedRoomByDateandTime_First(fromDate,
				toDate, startTime, endTime, orderByComparator);

		if (newBooking != null) {
			return newBooking;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fromDate=");
		msg.append(fromDate);

		msg.append(", toDate=");
		msg.append(toDate);

		msg.append(", startTime=");
		msg.append(startTime);

		msg.append(", endTime=");
		msg.append(endTime);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNewBookingException(msg.toString());
	}

	/**
	 * Returns the first new booking in the ordered set where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching new booking, or <code>null</code> if a matching new booking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NewBooking fetchByBookedRoomByDateandTime_First(Date fromDate,
		Date toDate, String startTime, String endTime,
		OrderByComparator orderByComparator) throws SystemException {
		List<NewBooking> list = findByBookedRoomByDateandTime(fromDate, toDate,
				startTime, endTime, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last new booking in the ordered set where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching new booking
	 * @throws com.cignexdatamatics.wrm.NoSuchNewBookingException if a matching new booking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NewBooking findByBookedRoomByDateandTime_Last(Date fromDate,
		Date toDate, String startTime, String endTime,
		OrderByComparator orderByComparator)
		throws NoSuchNewBookingException, SystemException {
		NewBooking newBooking = fetchByBookedRoomByDateandTime_Last(fromDate,
				toDate, startTime, endTime, orderByComparator);

		if (newBooking != null) {
			return newBooking;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fromDate=");
		msg.append(fromDate);

		msg.append(", toDate=");
		msg.append(toDate);

		msg.append(", startTime=");
		msg.append(startTime);

		msg.append(", endTime=");
		msg.append(endTime);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNewBookingException(msg.toString());
	}

	/**
	 * Returns the last new booking in the ordered set where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching new booking, or <code>null</code> if a matching new booking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NewBooking fetchByBookedRoomByDateandTime_Last(Date fromDate,
		Date toDate, String startTime, String endTime,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBookedRoomByDateandTime(fromDate, toDate, startTime,
				endTime);

		List<NewBooking> list = findByBookedRoomByDateandTime(fromDate, toDate,
				startTime, endTime, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the new bookings before and after the current new booking in the ordered set where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	 *
	 * @param bookingId the primary key of the current new booking
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next new booking
	 * @throws com.cignexdatamatics.wrm.NoSuchNewBookingException if a new booking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NewBooking[] findByBookedRoomByDateandTime_PrevAndNext(
		long bookingId, Date fromDate, Date toDate, String startTime,
		String endTime, OrderByComparator orderByComparator)
		throws NoSuchNewBookingException, SystemException {
		NewBooking newBooking = findByPrimaryKey(bookingId);

		Session session = null;

		try {
			session = openSession();

			NewBooking[] array = new NewBookingImpl[3];

			array[0] = getByBookedRoomByDateandTime_PrevAndNext(session,
					newBooking, fromDate, toDate, startTime, endTime,
					orderByComparator, true);

			array[1] = newBooking;

			array[2] = getByBookedRoomByDateandTime_PrevAndNext(session,
					newBooking, fromDate, toDate, startTime, endTime,
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

	protected NewBooking getByBookedRoomByDateandTime_PrevAndNext(
		Session session, NewBooking newBooking, Date fromDate, Date toDate,
		String startTime, String endTime, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NEWBOOKING_WHERE);

		if (fromDate == null) {
			query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_FROMDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_FROMDATE_2);
		}

		if (toDate == null) {
			query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_TODATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_TODATE_2);
		}

		if (startTime == null) {
			query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_STARTTIME_1);
		}
		else {
			if (startTime.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_STARTTIME_3);
			}
			else {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_STARTTIME_2);
			}
		}

		if (endTime == null) {
			query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_ENDTIME_1);
		}
		else {
			if (endTime.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_ENDTIME_3);
			}
			else {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_ENDTIME_2);
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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (fromDate != null) {
			qPos.add(CalendarUtil.getTimestamp(fromDate));
		}

		if (toDate != null) {
			qPos.add(CalendarUtil.getTimestamp(toDate));
		}

		if (startTime != null) {
			qPos.add(startTime);
		}

		if (endTime != null) {
			qPos.add(endTime);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(newBooking);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NewBooking> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the new bookings.
	 *
	 * @return the new bookings
	 * @throws SystemException if a system exception occurred
	 */
	public List<NewBooking> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the new bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of new bookings
	 * @param end the upper bound of the range of new bookings (not inclusive)
	 * @return the range of new bookings
	 * @throws SystemException if a system exception occurred
	 */
	public List<NewBooking> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the new bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of new bookings
	 * @param end the upper bound of the range of new bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of new bookings
	 * @throws SystemException if a system exception occurred
	 */
	public List<NewBooking> findAll(int start, int end,
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

		List<NewBooking> list = (List<NewBooking>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NEWBOOKING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NEWBOOKING;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<NewBooking>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<NewBooking>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the new bookings where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63; from the database.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param startTime the start time
	 * @param endTime the end time
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBookedRoomByDateandTime(Date fromDate, Date toDate,
		String startTime, String endTime) throws SystemException {
		for (NewBooking newBooking : findByBookedRoomByDateandTime(fromDate,
				toDate, startTime, endTime)) {
			remove(newBooking);
		}
	}

	/**
	 * Removes all the new bookings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (NewBooking newBooking : findAll()) {
			remove(newBooking);
		}
	}

	/**
	 * Returns the number of new bookings where fromDate = &#63; and toDate = &#63; and startTime = &#63; and endTime = &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param startTime the start time
	 * @param endTime the end time
	 * @return the number of matching new bookings
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBookedRoomByDateandTime(Date fromDate, Date toDate,
		String startTime, String endTime) throws SystemException {
		Object[] finderArgs = new Object[] { fromDate, toDate, startTime, endTime };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BOOKEDROOMBYDATEANDTIME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_NEWBOOKING_WHERE);

			if (fromDate == null) {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_FROMDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_FROMDATE_2);
			}

			if (toDate == null) {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_TODATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_TODATE_2);
			}

			if (startTime == null) {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_STARTTIME_1);
			}
			else {
				if (startTime.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_STARTTIME_3);
				}
				else {
					query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_STARTTIME_2);
				}
			}

			if (endTime == null) {
				query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_ENDTIME_1);
			}
			else {
				if (endTime.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_ENDTIME_3);
				}
				else {
					query.append(_FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_ENDTIME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (fromDate != null) {
					qPos.add(CalendarUtil.getTimestamp(fromDate));
				}

				if (toDate != null) {
					qPos.add(CalendarUtil.getTimestamp(toDate));
				}

				if (startTime != null) {
					qPos.add(startTime);
				}

				if (endTime != null) {
					qPos.add(endTime);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BOOKEDROOMBYDATEANDTIME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of new bookings.
	 *
	 * @return the number of new bookings
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NEWBOOKING);

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
	 * Initializes the new booking persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cignexdatamatics.wrm.model.NewBooking")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NewBooking>> listenersList = new ArrayList<ModelListener<NewBooking>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NewBooking>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NewBookingImpl.class.getName());
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
	private static final String _SQL_SELECT_NEWBOOKING = "SELECT newBooking FROM NewBooking newBooking";
	private static final String _SQL_SELECT_NEWBOOKING_WHERE = "SELECT newBooking FROM NewBooking newBooking WHERE ";
	private static final String _SQL_COUNT_NEWBOOKING = "SELECT COUNT(newBooking) FROM NewBooking newBooking";
	private static final String _SQL_COUNT_NEWBOOKING_WHERE = "SELECT COUNT(newBooking) FROM NewBooking newBooking WHERE ";
	private static final String _FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_FROMDATE_1 =
		"newBooking.fromDate IS NULL AND ";
	private static final String _FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_FROMDATE_2 =
		"newBooking.fromDate = ? AND ";
	private static final String _FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_TODATE_1 = "newBooking.toDate IS NULL AND ";
	private static final String _FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_TODATE_2 = "newBooking.toDate = ? AND ";
	private static final String _FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_STARTTIME_1 =
		"newBooking.startTime IS NULL AND ";
	private static final String _FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_STARTTIME_2 =
		"newBooking.startTime = ? AND ";
	private static final String _FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_STARTTIME_3 =
		"(newBooking.startTime IS NULL OR newBooking.startTime = ?) AND ";
	private static final String _FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_ENDTIME_1 =
		"newBooking.endTime IS NULL";
	private static final String _FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_ENDTIME_2 =
		"newBooking.endTime = ?";
	private static final String _FINDER_COLUMN_BOOKEDROOMBYDATEANDTIME_ENDTIME_3 =
		"(newBooking.endTime IS NULL OR newBooking.endTime = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "newBooking.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NewBooking exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NewBooking exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NewBookingPersistenceImpl.class);
	private static NewBooking _nullNewBooking = new NewBookingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NewBooking> toCacheModel() {
				return _nullNewBookingCacheModel;
			}
		};

	private static CacheModel<NewBooking> _nullNewBookingCacheModel = new CacheModel<NewBooking>() {
			public NewBooking toEntityModel() {
				return _nullNewBooking;
			}
		};
}