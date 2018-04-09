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

import com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException;
import com.cignexdatamatics.wrm.model.BookingFacilityMapping;
import com.cignexdatamatics.wrm.model.impl.BookingFacilityMappingImpl;
import com.cignexdatamatics.wrm.model.impl.BookingFacilityMappingModelImpl;

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
 * The persistence implementation for the booking facility mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingFacilityMappingPersistence
 * @see BookingFacilityMappingUtil
 * @generated
 */
public class BookingFacilityMappingPersistenceImpl extends BasePersistenceImpl<BookingFacilityMapping>
	implements BookingFacilityMappingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BookingFacilityMappingUtil} to access the booking facility mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BookingFacilityMappingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKINGID =
		new FinderPath(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			BookingFacilityMappingModelImpl.FINDER_CACHE_ENABLED,
			BookingFacilityMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybookingId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID =
		new FinderPath(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			BookingFacilityMappingModelImpl.FINDER_CACHE_ENABLED,
			BookingFacilityMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybookingId",
			new String[] { Long.class.getName() },
			BookingFacilityMappingModelImpl.BOOKINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKINGID = new FinderPath(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			BookingFacilityMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybookingId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FACILITIESID =
		new FinderPath(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			BookingFacilityMappingModelImpl.FINDER_CACHE_ENABLED,
			BookingFacilityMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfacilitiesId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITIESID =
		new FinderPath(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			BookingFacilityMappingModelImpl.FINDER_CACHE_ENABLED,
			BookingFacilityMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfacilitiesId",
			new String[] { Long.class.getName() },
			BookingFacilityMappingModelImpl.FACILITIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FACILITIESID = new FinderPath(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			BookingFacilityMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfacilitiesId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			BookingFacilityMappingModelImpl.FINDER_CACHE_ENABLED,
			BookingFacilityMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			BookingFacilityMappingModelImpl.FINDER_CACHE_ENABLED,
			BookingFacilityMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			BookingFacilityMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the booking facility mapping in the entity cache if it is enabled.
	 *
	 * @param bookingFacilityMapping the booking facility mapping
	 */
	public void cacheResult(BookingFacilityMapping bookingFacilityMapping) {
		EntityCacheUtil.putResult(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			BookingFacilityMappingImpl.class,
			bookingFacilityMapping.getPrimaryKey(), bookingFacilityMapping);

		bookingFacilityMapping.resetOriginalValues();
	}

	/**
	 * Caches the booking facility mappings in the entity cache if it is enabled.
	 *
	 * @param bookingFacilityMappings the booking facility mappings
	 */
	public void cacheResult(
		List<BookingFacilityMapping> bookingFacilityMappings) {
		for (BookingFacilityMapping bookingFacilityMapping : bookingFacilityMappings) {
			if (EntityCacheUtil.getResult(
						BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
						BookingFacilityMappingImpl.class,
						bookingFacilityMapping.getPrimaryKey()) == null) {
				cacheResult(bookingFacilityMapping);
			}
			else {
				bookingFacilityMapping.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all booking facility mappings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BookingFacilityMappingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BookingFacilityMappingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the booking facility mapping.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BookingFacilityMapping bookingFacilityMapping) {
		EntityCacheUtil.removeResult(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			BookingFacilityMappingImpl.class,
			bookingFacilityMapping.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BookingFacilityMapping> bookingFacilityMappings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BookingFacilityMapping bookingFacilityMapping : bookingFacilityMappings) {
			EntityCacheUtil.removeResult(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
				BookingFacilityMappingImpl.class,
				bookingFacilityMapping.getPrimaryKey());
		}
	}

	/**
	 * Creates a new booking facility mapping with the primary key. Does not add the booking facility mapping to the database.
	 *
	 * @param bookingFacilityMappingPK the primary key for the new booking facility mapping
	 * @return the new booking facility mapping
	 */
	public BookingFacilityMapping create(
		BookingFacilityMappingPK bookingFacilityMappingPK) {
		BookingFacilityMapping bookingFacilityMapping = new BookingFacilityMappingImpl();

		bookingFacilityMapping.setNew(true);
		bookingFacilityMapping.setPrimaryKey(bookingFacilityMappingPK);

		return bookingFacilityMapping;
	}

	/**
	 * Removes the booking facility mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingFacilityMappingPK the primary key of the booking facility mapping
	 * @return the booking facility mapping that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a booking facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingFacilityMapping remove(
		BookingFacilityMappingPK bookingFacilityMappingPK)
		throws NoSuchBookingFacilityMappingException, SystemException {
		return remove((Serializable)bookingFacilityMappingPK);
	}

	/**
	 * Removes the booking facility mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the booking facility mapping
	 * @return the booking facility mapping that was removed
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a booking facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingFacilityMapping remove(Serializable primaryKey)
		throws NoSuchBookingFacilityMappingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BookingFacilityMapping bookingFacilityMapping = (BookingFacilityMapping)session.get(BookingFacilityMappingImpl.class,
					primaryKey);

			if (bookingFacilityMapping == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookingFacilityMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bookingFacilityMapping);
		}
		catch (NoSuchBookingFacilityMappingException nsee) {
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
	protected BookingFacilityMapping removeImpl(
		BookingFacilityMapping bookingFacilityMapping)
		throws SystemException {
		bookingFacilityMapping = toUnwrappedModel(bookingFacilityMapping);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, bookingFacilityMapping);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(bookingFacilityMapping);

		return bookingFacilityMapping;
	}

	@Override
	public BookingFacilityMapping updateImpl(
		com.cignexdatamatics.wrm.model.BookingFacilityMapping bookingFacilityMapping,
		boolean merge) throws SystemException {
		bookingFacilityMapping = toUnwrappedModel(bookingFacilityMapping);

		boolean isNew = bookingFacilityMapping.isNew();

		BookingFacilityMappingModelImpl bookingFacilityMappingModelImpl = (BookingFacilityMappingModelImpl)bookingFacilityMapping;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, bookingFacilityMapping, merge);

			bookingFacilityMapping.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BookingFacilityMappingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bookingFacilityMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(bookingFacilityMappingModelImpl.getOriginalBookingId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKINGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID,
					args);

				args = new Object[] {
						Long.valueOf(bookingFacilityMappingModelImpl.getBookingId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKINGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID,
					args);
			}

			if ((bookingFacilityMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITIESID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(bookingFacilityMappingModelImpl.getOriginalFacilitiesId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITIESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITIESID,
					args);

				args = new Object[] {
						Long.valueOf(bookingFacilityMappingModelImpl.getFacilitiesId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITIESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITIESID,
					args);
			}
		}

		EntityCacheUtil.putResult(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
			BookingFacilityMappingImpl.class,
			bookingFacilityMapping.getPrimaryKey(), bookingFacilityMapping);

		return bookingFacilityMapping;
	}

	protected BookingFacilityMapping toUnwrappedModel(
		BookingFacilityMapping bookingFacilityMapping) {
		if (bookingFacilityMapping instanceof BookingFacilityMappingImpl) {
			return bookingFacilityMapping;
		}

		BookingFacilityMappingImpl bookingFacilityMappingImpl = new BookingFacilityMappingImpl();

		bookingFacilityMappingImpl.setNew(bookingFacilityMapping.isNew());
		bookingFacilityMappingImpl.setPrimaryKey(bookingFacilityMapping.getPrimaryKey());

		bookingFacilityMappingImpl.setBookingId(bookingFacilityMapping.getBookingId());
		bookingFacilityMappingImpl.setFacilitiesId(bookingFacilityMapping.getFacilitiesId());

		return bookingFacilityMappingImpl;
	}

	/**
	 * Returns the booking facility mapping with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking facility mapping
	 * @return the booking facility mapping
	 * @throws com.liferay.portal.NoSuchModelException if a booking facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingFacilityMapping findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((BookingFacilityMappingPK)primaryKey);
	}

	/**
	 * Returns the booking facility mapping with the primary key or throws a {@link com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException} if it could not be found.
	 *
	 * @param bookingFacilityMappingPK the primary key of the booking facility mapping
	 * @return the booking facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a booking facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingFacilityMapping findByPrimaryKey(
		BookingFacilityMappingPK bookingFacilityMappingPK)
		throws NoSuchBookingFacilityMappingException, SystemException {
		BookingFacilityMapping bookingFacilityMapping = fetchByPrimaryKey(bookingFacilityMappingPK);

		if (bookingFacilityMapping == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					bookingFacilityMappingPK);
			}

			throw new NoSuchBookingFacilityMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bookingFacilityMappingPK);
		}

		return bookingFacilityMapping;
	}

	/**
	 * Returns the booking facility mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking facility mapping
	 * @return the booking facility mapping, or <code>null</code> if a booking facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingFacilityMapping fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((BookingFacilityMappingPK)primaryKey);
	}

	/**
	 * Returns the booking facility mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingFacilityMappingPK the primary key of the booking facility mapping
	 * @return the booking facility mapping, or <code>null</code> if a booking facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingFacilityMapping fetchByPrimaryKey(
		BookingFacilityMappingPK bookingFacilityMappingPK)
		throws SystemException {
		BookingFacilityMapping bookingFacilityMapping = (BookingFacilityMapping)EntityCacheUtil.getResult(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
				BookingFacilityMappingImpl.class, bookingFacilityMappingPK);

		if (bookingFacilityMapping == _nullBookingFacilityMapping) {
			return null;
		}

		if (bookingFacilityMapping == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				bookingFacilityMapping = (BookingFacilityMapping)session.get(BookingFacilityMappingImpl.class,
						bookingFacilityMappingPK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (bookingFacilityMapping != null) {
					cacheResult(bookingFacilityMapping);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BookingFacilityMappingModelImpl.ENTITY_CACHE_ENABLED,
						BookingFacilityMappingImpl.class,
						bookingFacilityMappingPK, _nullBookingFacilityMapping);
				}

				closeSession(session);
			}
		}

		return bookingFacilityMapping;
	}

	/**
	 * Returns all the booking facility mappings where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @return the matching booking facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingFacilityMapping> findBybookingId(long bookingId)
		throws SystemException {
		return findBybookingId(bookingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the booking facility mappings where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of booking facility mappings
	 * @param end the upper bound of the range of booking facility mappings (not inclusive)
	 * @return the range of matching booking facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingFacilityMapping> findBybookingId(long bookingId,
		int start, int end) throws SystemException {
		return findBybookingId(bookingId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking facility mappings where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of booking facility mappings
	 * @param end the upper bound of the range of booking facility mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingFacilityMapping> findBybookingId(long bookingId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<BookingFacilityMapping> list = (List<BookingFacilityMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BookingFacilityMapping bookingFacilityMapping : list) {
				if ((bookingId != bookingFacilityMapping.getBookingId())) {
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

			query.append(_SQL_SELECT_BOOKINGFACILITYMAPPING_WHERE);

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

				list = (List<BookingFacilityMapping>)QueryUtil.list(q,
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
	 * Returns the first booking facility mapping in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a matching booking facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingFacilityMapping findBybookingId_First(long bookingId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingFacilityMappingException, SystemException {
		BookingFacilityMapping bookingFacilityMapping = fetchBybookingId_First(bookingId,
				orderByComparator);

		if (bookingFacilityMapping != null) {
			return bookingFacilityMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookingId=");
		msg.append(bookingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingFacilityMappingException(msg.toString());
	}

	/**
	 * Returns the first booking facility mapping in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking facility mapping, or <code>null</code> if a matching booking facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingFacilityMapping fetchBybookingId_First(long bookingId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BookingFacilityMapping> list = findBybookingId(bookingId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking facility mapping in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a matching booking facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingFacilityMapping findBybookingId_Last(long bookingId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingFacilityMappingException, SystemException {
		BookingFacilityMapping bookingFacilityMapping = fetchBybookingId_Last(bookingId,
				orderByComparator);

		if (bookingFacilityMapping != null) {
			return bookingFacilityMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookingId=");
		msg.append(bookingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingFacilityMappingException(msg.toString());
	}

	/**
	 * Returns the last booking facility mapping in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking facility mapping, or <code>null</code> if a matching booking facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingFacilityMapping fetchBybookingId_Last(long bookingId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybookingId(bookingId);

		List<BookingFacilityMapping> list = findBybookingId(bookingId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking facility mappings before and after the current booking facility mapping in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingFacilityMappingPK the primary key of the current booking facility mapping
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a booking facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingFacilityMapping[] findBybookingId_PrevAndNext(
		BookingFacilityMappingPK bookingFacilityMappingPK, long bookingId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingFacilityMappingException, SystemException {
		BookingFacilityMapping bookingFacilityMapping = findByPrimaryKey(bookingFacilityMappingPK);

		Session session = null;

		try {
			session = openSession();

			BookingFacilityMapping[] array = new BookingFacilityMappingImpl[3];

			array[0] = getBybookingId_PrevAndNext(session,
					bookingFacilityMapping, bookingId, orderByComparator, true);

			array[1] = bookingFacilityMapping;

			array[2] = getBybookingId_PrevAndNext(session,
					bookingFacilityMapping, bookingId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookingFacilityMapping getBybookingId_PrevAndNext(
		Session session, BookingFacilityMapping bookingFacilityMapping,
		long bookingId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKINGFACILITYMAPPING_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(bookingFacilityMapping);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookingFacilityMapping> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the booking facility mappings where facilitiesId = &#63;.
	 *
	 * @param facilitiesId the facilities ID
	 * @return the matching booking facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingFacilityMapping> findByfacilitiesId(long facilitiesId)
		throws SystemException {
		return findByfacilitiesId(facilitiesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking facility mappings where facilitiesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param facilitiesId the facilities ID
	 * @param start the lower bound of the range of booking facility mappings
	 * @param end the upper bound of the range of booking facility mappings (not inclusive)
	 * @return the range of matching booking facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingFacilityMapping> findByfacilitiesId(long facilitiesId,
		int start, int end) throws SystemException {
		return findByfacilitiesId(facilitiesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking facility mappings where facilitiesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param facilitiesId the facilities ID
	 * @param start the lower bound of the range of booking facility mappings
	 * @param end the upper bound of the range of booking facility mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingFacilityMapping> findByfacilitiesId(long facilitiesId,
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

		List<BookingFacilityMapping> list = (List<BookingFacilityMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BookingFacilityMapping bookingFacilityMapping : list) {
				if ((facilitiesId != bookingFacilityMapping.getFacilitiesId())) {
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

			query.append(_SQL_SELECT_BOOKINGFACILITYMAPPING_WHERE);

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

				list = (List<BookingFacilityMapping>)QueryUtil.list(q,
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
	 * Returns the first booking facility mapping in the ordered set where facilitiesId = &#63;.
	 *
	 * @param facilitiesId the facilities ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a matching booking facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingFacilityMapping findByfacilitiesId_First(long facilitiesId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingFacilityMappingException, SystemException {
		BookingFacilityMapping bookingFacilityMapping = fetchByfacilitiesId_First(facilitiesId,
				orderByComparator);

		if (bookingFacilityMapping != null) {
			return bookingFacilityMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facilitiesId=");
		msg.append(facilitiesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingFacilityMappingException(msg.toString());
	}

	/**
	 * Returns the first booking facility mapping in the ordered set where facilitiesId = &#63;.
	 *
	 * @param facilitiesId the facilities ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking facility mapping, or <code>null</code> if a matching booking facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingFacilityMapping fetchByfacilitiesId_First(long facilitiesId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BookingFacilityMapping> list = findByfacilitiesId(facilitiesId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking facility mapping in the ordered set where facilitiesId = &#63;.
	 *
	 * @param facilitiesId the facilities ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a matching booking facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingFacilityMapping findByfacilitiesId_Last(long facilitiesId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingFacilityMappingException, SystemException {
		BookingFacilityMapping bookingFacilityMapping = fetchByfacilitiesId_Last(facilitiesId,
				orderByComparator);

		if (bookingFacilityMapping != null) {
			return bookingFacilityMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facilitiesId=");
		msg.append(facilitiesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingFacilityMappingException(msg.toString());
	}

	/**
	 * Returns the last booking facility mapping in the ordered set where facilitiesId = &#63;.
	 *
	 * @param facilitiesId the facilities ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking facility mapping, or <code>null</code> if a matching booking facility mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingFacilityMapping fetchByfacilitiesId_Last(long facilitiesId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByfacilitiesId(facilitiesId);

		List<BookingFacilityMapping> list = findByfacilitiesId(facilitiesId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking facility mappings before and after the current booking facility mapping in the ordered set where facilitiesId = &#63;.
	 *
	 * @param bookingFacilityMappingPK the primary key of the current booking facility mapping
	 * @param facilitiesId the facilities ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking facility mapping
	 * @throws com.cignexdatamatics.wrm.NoSuchBookingFacilityMappingException if a booking facility mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookingFacilityMapping[] findByfacilitiesId_PrevAndNext(
		BookingFacilityMappingPK bookingFacilityMappingPK, long facilitiesId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingFacilityMappingException, SystemException {
		BookingFacilityMapping bookingFacilityMapping = findByPrimaryKey(bookingFacilityMappingPK);

		Session session = null;

		try {
			session = openSession();

			BookingFacilityMapping[] array = new BookingFacilityMappingImpl[3];

			array[0] = getByfacilitiesId_PrevAndNext(session,
					bookingFacilityMapping, facilitiesId, orderByComparator,
					true);

			array[1] = bookingFacilityMapping;

			array[2] = getByfacilitiesId_PrevAndNext(session,
					bookingFacilityMapping, facilitiesId, orderByComparator,
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

	protected BookingFacilityMapping getByfacilitiesId_PrevAndNext(
		Session session, BookingFacilityMapping bookingFacilityMapping,
		long facilitiesId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKINGFACILITYMAPPING_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(bookingFacilityMapping);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookingFacilityMapping> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the booking facility mappings.
	 *
	 * @return the booking facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingFacilityMapping> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking facility mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking facility mappings
	 * @param end the upper bound of the range of booking facility mappings (not inclusive)
	 * @return the range of booking facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingFacilityMapping> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking facility mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking facility mappings
	 * @param end the upper bound of the range of booking facility mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of booking facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookingFacilityMapping> findAll(int start, int end,
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

		List<BookingFacilityMapping> list = (List<BookingFacilityMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BOOKINGFACILITYMAPPING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKINGFACILITYMAPPING;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<BookingFacilityMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<BookingFacilityMapping>)QueryUtil.list(q,
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
	 * Removes all the booking facility mappings where bookingId = &#63; from the database.
	 *
	 * @param bookingId the booking ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBybookingId(long bookingId) throws SystemException {
		for (BookingFacilityMapping bookingFacilityMapping : findBybookingId(
				bookingId)) {
			remove(bookingFacilityMapping);
		}
	}

	/**
	 * Removes all the booking facility mappings where facilitiesId = &#63; from the database.
	 *
	 * @param facilitiesId the facilities ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByfacilitiesId(long facilitiesId)
		throws SystemException {
		for (BookingFacilityMapping bookingFacilityMapping : findByfacilitiesId(
				facilitiesId)) {
			remove(bookingFacilityMapping);
		}
	}

	/**
	 * Removes all the booking facility mappings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (BookingFacilityMapping bookingFacilityMapping : findAll()) {
			remove(bookingFacilityMapping);
		}
	}

	/**
	 * Returns the number of booking facility mappings where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @return the number of matching booking facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public int countBybookingId(long bookingId) throws SystemException {
		Object[] finderArgs = new Object[] { bookingId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BOOKINGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKINGFACILITYMAPPING_WHERE);

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
	 * Returns the number of booking facility mappings where facilitiesId = &#63;.
	 *
	 * @param facilitiesId the facilities ID
	 * @return the number of matching booking facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public int countByfacilitiesId(long facilitiesId) throws SystemException {
		Object[] finderArgs = new Object[] { facilitiesId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FACILITIESID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKINGFACILITYMAPPING_WHERE);

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
	 * Returns the number of booking facility mappings.
	 *
	 * @return the number of booking facility mappings
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOOKINGFACILITYMAPPING);

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
	 * Initializes the booking facility mapping persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cignexdatamatics.wrm.model.BookingFacilityMapping")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BookingFacilityMapping>> listenersList = new ArrayList<ModelListener<BookingFacilityMapping>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BookingFacilityMapping>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BookingFacilityMappingImpl.class.getName());
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
	private static final String _SQL_SELECT_BOOKINGFACILITYMAPPING = "SELECT bookingFacilityMapping FROM BookingFacilityMapping bookingFacilityMapping";
	private static final String _SQL_SELECT_BOOKINGFACILITYMAPPING_WHERE = "SELECT bookingFacilityMapping FROM BookingFacilityMapping bookingFacilityMapping WHERE ";
	private static final String _SQL_COUNT_BOOKINGFACILITYMAPPING = "SELECT COUNT(bookingFacilityMapping) FROM BookingFacilityMapping bookingFacilityMapping";
	private static final String _SQL_COUNT_BOOKINGFACILITYMAPPING_WHERE = "SELECT COUNT(bookingFacilityMapping) FROM BookingFacilityMapping bookingFacilityMapping WHERE ";
	private static final String _FINDER_COLUMN_BOOKINGID_BOOKINGID_2 = "bookingFacilityMapping.id.bookingId = ?";
	private static final String _FINDER_COLUMN_FACILITIESID_FACILITIESID_2 = "bookingFacilityMapping.id.facilitiesId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bookingFacilityMapping.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BookingFacilityMapping exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BookingFacilityMapping exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BookingFacilityMappingPersistenceImpl.class);
	private static BookingFacilityMapping _nullBookingFacilityMapping = new BookingFacilityMappingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BookingFacilityMapping> toCacheModel() {
				return _nullBookingFacilityMappingCacheModel;
			}
		};

	private static CacheModel<BookingFacilityMapping> _nullBookingFacilityMappingCacheModel =
		new CacheModel<BookingFacilityMapping>() {
			public BookingFacilityMapping toEntityModel() {
				return _nullBookingFacilityMapping;
			}
		};
}