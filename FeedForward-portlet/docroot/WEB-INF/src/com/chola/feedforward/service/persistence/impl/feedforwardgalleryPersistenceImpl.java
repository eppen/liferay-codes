/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.chola.feedforward.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.chola.feedforward.exception.NoSuchfeedforwardgalleryException;
import com.chola.feedforward.model.feedforwardgallery;
import com.chola.feedforward.model.impl.feedforwardgalleryImpl;
import com.chola.feedforward.model.impl.feedforwardgalleryModelImpl;
import com.chola.feedforward.service.persistence.feedforwardgalleryPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the feedforwardgallery service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CloverLiferay02
 * @see feedforwardgalleryPersistence
 * @see com.chola.feedforward.service.persistence.feedforwardgalleryUtil
 * @generated
 */
@ProviderType
public class feedforwardgalleryPersistenceImpl extends BasePersistenceImpl<feedforwardgallery>
	implements feedforwardgalleryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link feedforwardgalleryUtil} to access the feedforwardgallery persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = feedforwardgalleryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
			feedforwardgalleryModelImpl.FINDER_CACHE_ENABLED,
			feedforwardgalleryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
			feedforwardgalleryModelImpl.FINDER_CACHE_ENABLED,
			feedforwardgalleryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
			feedforwardgalleryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENT_ID =
		new FinderPath(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
			feedforwardgalleryModelImpl.FINDER_CACHE_ENABLED,
			feedforwardgalleryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCONTENT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT_ID =
		new FinderPath(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
			feedforwardgalleryModelImpl.FINDER_CACHE_ENABLED,
			feedforwardgalleryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCONTENT_ID",
			new String[] { Long.class.getName() },
			feedforwardgalleryModelImpl.CONTENT_ID_COLUMN_BITMASK |
			feedforwardgalleryModelImpl.CREATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTENT_ID = new FinderPath(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
			feedforwardgalleryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCONTENT_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the feedforwardgalleries where content_id = &#63;.
	 *
	 * @param content_id the content_id
	 * @return the matching feedforwardgalleries
	 */
	@Override
	public List<feedforwardgallery> findByCONTENT_ID(long content_id) {
		return findByCONTENT_ID(content_id, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedforwardgalleries where content_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link feedforwardgalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param content_id the content_id
	 * @param start the lower bound of the range of feedforwardgalleries
	 * @param end the upper bound of the range of feedforwardgalleries (not inclusive)
	 * @return the range of matching feedforwardgalleries
	 */
	@Override
	public List<feedforwardgallery> findByCONTENT_ID(long content_id,
		int start, int end) {
		return findByCONTENT_ID(content_id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedforwardgalleries where content_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link feedforwardgalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param content_id the content_id
	 * @param start the lower bound of the range of feedforwardgalleries
	 * @param end the upper bound of the range of feedforwardgalleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feedforwardgalleries
	 */
	@Override
	public List<feedforwardgallery> findByCONTENT_ID(long content_id,
		int start, int end,
		OrderByComparator<feedforwardgallery> orderByComparator) {
		return findByCONTENT_ID(content_id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feedforwardgalleries where content_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link feedforwardgalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param content_id the content_id
	 * @param start the lower bound of the range of feedforwardgalleries
	 * @param end the upper bound of the range of feedforwardgalleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching feedforwardgalleries
	 */
	@Override
	public List<feedforwardgallery> findByCONTENT_ID(long content_id,
		int start, int end,
		OrderByComparator<feedforwardgallery> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT_ID;
			finderArgs = new Object[] { content_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENT_ID;
			finderArgs = new Object[] { content_id, start, end, orderByComparator };
		}

		List<feedforwardgallery> list = null;

		if (retrieveFromCache) {
			list = (List<feedforwardgallery>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (feedforwardgallery feedforwardgallery : list) {
					if ((content_id != feedforwardgallery.getContent_id())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FEEDFORWARDGALLERY_WHERE);

			query.append(_FINDER_COLUMN_CONTENT_ID_CONTENT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(feedforwardgalleryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(content_id);

				if (!pagination) {
					list = (List<feedforwardgallery>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<feedforwardgallery>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first feedforwardgallery in the ordered set where content_id = &#63;.
	 *
	 * @param content_id the content_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedforwardgallery
	 * @throws NoSuchfeedforwardgalleryException if a matching feedforwardgallery could not be found
	 */
	@Override
	public feedforwardgallery findByCONTENT_ID_First(long content_id,
		OrderByComparator<feedforwardgallery> orderByComparator)
		throws NoSuchfeedforwardgalleryException {
		feedforwardgallery feedforwardgallery = fetchByCONTENT_ID_First(content_id,
				orderByComparator);

		if (feedforwardgallery != null) {
			return feedforwardgallery;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("content_id=");
		msg.append(content_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchfeedforwardgalleryException(msg.toString());
	}

	/**
	 * Returns the first feedforwardgallery in the ordered set where content_id = &#63;.
	 *
	 * @param content_id the content_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedforwardgallery, or <code>null</code> if a matching feedforwardgallery could not be found
	 */
	@Override
	public feedforwardgallery fetchByCONTENT_ID_First(long content_id,
		OrderByComparator<feedforwardgallery> orderByComparator) {
		List<feedforwardgallery> list = findByCONTENT_ID(content_id, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feedforwardgallery in the ordered set where content_id = &#63;.
	 *
	 * @param content_id the content_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedforwardgallery
	 * @throws NoSuchfeedforwardgalleryException if a matching feedforwardgallery could not be found
	 */
	@Override
	public feedforwardgallery findByCONTENT_ID_Last(long content_id,
		OrderByComparator<feedforwardgallery> orderByComparator)
		throws NoSuchfeedforwardgalleryException {
		feedforwardgallery feedforwardgallery = fetchByCONTENT_ID_Last(content_id,
				orderByComparator);

		if (feedforwardgallery != null) {
			return feedforwardgallery;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("content_id=");
		msg.append(content_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchfeedforwardgalleryException(msg.toString());
	}

	/**
	 * Returns the last feedforwardgallery in the ordered set where content_id = &#63;.
	 *
	 * @param content_id the content_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedforwardgallery, or <code>null</code> if a matching feedforwardgallery could not be found
	 */
	@Override
	public feedforwardgallery fetchByCONTENT_ID_Last(long content_id,
		OrderByComparator<feedforwardgallery> orderByComparator) {
		int count = countByCONTENT_ID(content_id);

		if (count == 0) {
			return null;
		}

		List<feedforwardgallery> list = findByCONTENT_ID(content_id, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feedforwardgalleries before and after the current feedforwardgallery in the ordered set where content_id = &#63;.
	 *
	 * @param id the primary key of the current feedforwardgallery
	 * @param content_id the content_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feedforwardgallery
	 * @throws NoSuchfeedforwardgalleryException if a feedforwardgallery with the primary key could not be found
	 */
	@Override
	public feedforwardgallery[] findByCONTENT_ID_PrevAndNext(long id,
		long content_id, OrderByComparator<feedforwardgallery> orderByComparator)
		throws NoSuchfeedforwardgalleryException {
		feedforwardgallery feedforwardgallery = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			feedforwardgallery[] array = new feedforwardgalleryImpl[3];

			array[0] = getByCONTENT_ID_PrevAndNext(session, feedforwardgallery,
					content_id, orderByComparator, true);

			array[1] = feedforwardgallery;

			array[2] = getByCONTENT_ID_PrevAndNext(session, feedforwardgallery,
					content_id, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected feedforwardgallery getByCONTENT_ID_PrevAndNext(Session session,
		feedforwardgallery feedforwardgallery, long content_id,
		OrderByComparator<feedforwardgallery> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FEEDFORWARDGALLERY_WHERE);

		query.append(_FINDER_COLUMN_CONTENT_ID_CONTENT_ID_2);

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
			query.append(feedforwardgalleryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(content_id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feedforwardgallery);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<feedforwardgallery> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feedforwardgalleries where content_id = &#63; from the database.
	 *
	 * @param content_id the content_id
	 */
	@Override
	public void removeByCONTENT_ID(long content_id) {
		for (feedforwardgallery feedforwardgallery : findByCONTENT_ID(
				content_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(feedforwardgallery);
		}
	}

	/**
	 * Returns the number of feedforwardgalleries where content_id = &#63;.
	 *
	 * @param content_id the content_id
	 * @return the number of matching feedforwardgalleries
	 */
	@Override
	public int countByCONTENT_ID(long content_id) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTENT_ID;

		Object[] finderArgs = new Object[] { content_id };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEEDFORWARDGALLERY_WHERE);

			query.append(_FINDER_COLUMN_CONTENT_ID_CONTENT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(content_id);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONTENT_ID_CONTENT_ID_2 = "feedforwardgallery.content_id = ?";

	public feedforwardgalleryPersistenceImpl() {
		setModelClass(feedforwardgallery.class);
	}

	/**
	 * Caches the feedforwardgallery in the entity cache if it is enabled.
	 *
	 * @param feedforwardgallery the feedforwardgallery
	 */
	@Override
	public void cacheResult(feedforwardgallery feedforwardgallery) {
		entityCache.putResult(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
			feedforwardgalleryImpl.class, feedforwardgallery.getPrimaryKey(),
			feedforwardgallery);

		feedforwardgallery.resetOriginalValues();
	}

	/**
	 * Caches the feedforwardgalleries in the entity cache if it is enabled.
	 *
	 * @param feedforwardgalleries the feedforwardgalleries
	 */
	@Override
	public void cacheResult(List<feedforwardgallery> feedforwardgalleries) {
		for (feedforwardgallery feedforwardgallery : feedforwardgalleries) {
			if (entityCache.getResult(
						feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
						feedforwardgalleryImpl.class,
						feedforwardgallery.getPrimaryKey()) == null) {
				cacheResult(feedforwardgallery);
			}
			else {
				feedforwardgallery.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all feedforwardgalleries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(feedforwardgalleryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the feedforwardgallery.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(feedforwardgallery feedforwardgallery) {
		entityCache.removeResult(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
			feedforwardgalleryImpl.class, feedforwardgallery.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<feedforwardgallery> feedforwardgalleries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (feedforwardgallery feedforwardgallery : feedforwardgalleries) {
			entityCache.removeResult(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
				feedforwardgalleryImpl.class, feedforwardgallery.getPrimaryKey());
		}
	}

	/**
	 * Creates a new feedforwardgallery with the primary key. Does not add the feedforwardgallery to the database.
	 *
	 * @param id the primary key for the new feedforwardgallery
	 * @return the new feedforwardgallery
	 */
	@Override
	public feedforwardgallery create(long id) {
		feedforwardgallery feedforwardgallery = new feedforwardgalleryImpl();

		feedforwardgallery.setNew(true);
		feedforwardgallery.setPrimaryKey(id);

		return feedforwardgallery;
	}

	/**
	 * Removes the feedforwardgallery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the feedforwardgallery
	 * @return the feedforwardgallery that was removed
	 * @throws NoSuchfeedforwardgalleryException if a feedforwardgallery with the primary key could not be found
	 */
	@Override
	public feedforwardgallery remove(long id)
		throws NoSuchfeedforwardgalleryException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the feedforwardgallery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the feedforwardgallery
	 * @return the feedforwardgallery that was removed
	 * @throws NoSuchfeedforwardgalleryException if a feedforwardgallery with the primary key could not be found
	 */
	@Override
	public feedforwardgallery remove(Serializable primaryKey)
		throws NoSuchfeedforwardgalleryException {
		Session session = null;

		try {
			session = openSession();

			feedforwardgallery feedforwardgallery = (feedforwardgallery)session.get(feedforwardgalleryImpl.class,
					primaryKey);

			if (feedforwardgallery == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchfeedforwardgalleryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(feedforwardgallery);
		}
		catch (NoSuchfeedforwardgalleryException nsee) {
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
	protected feedforwardgallery removeImpl(
		feedforwardgallery feedforwardgallery) {
		feedforwardgallery = toUnwrappedModel(feedforwardgallery);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(feedforwardgallery)) {
				feedforwardgallery = (feedforwardgallery)session.get(feedforwardgalleryImpl.class,
						feedforwardgallery.getPrimaryKeyObj());
			}

			if (feedforwardgallery != null) {
				session.delete(feedforwardgallery);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (feedforwardgallery != null) {
			clearCache(feedforwardgallery);
		}

		return feedforwardgallery;
	}

	@Override
	public feedforwardgallery updateImpl(feedforwardgallery feedforwardgallery) {
		feedforwardgallery = toUnwrappedModel(feedforwardgallery);

		boolean isNew = feedforwardgallery.isNew();

		feedforwardgalleryModelImpl feedforwardgalleryModelImpl = (feedforwardgalleryModelImpl)feedforwardgallery;

		Session session = null;

		try {
			session = openSession();

			if (feedforwardgallery.isNew()) {
				session.save(feedforwardgallery);

				feedforwardgallery.setNew(false);
			}
			else {
				feedforwardgallery = (feedforwardgallery)session.merge(feedforwardgallery);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !feedforwardgalleryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((feedforwardgalleryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feedforwardgalleryModelImpl.getOriginalContent_id()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CONTENT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT_ID,
					args);

				args = new Object[] { feedforwardgalleryModelImpl.getContent_id() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CONTENT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT_ID,
					args);
			}
		}

		entityCache.putResult(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
			feedforwardgalleryImpl.class, feedforwardgallery.getPrimaryKey(),
			feedforwardgallery, false);

		feedforwardgallery.resetOriginalValues();

		return feedforwardgallery;
	}

	protected feedforwardgallery toUnwrappedModel(
		feedforwardgallery feedforwardgallery) {
		if (feedforwardgallery instanceof feedforwardgalleryImpl) {
			return feedforwardgallery;
		}

		feedforwardgalleryImpl feedforwardgalleryImpl = new feedforwardgalleryImpl();

		feedforwardgalleryImpl.setNew(feedforwardgallery.isNew());
		feedforwardgalleryImpl.setPrimaryKey(feedforwardgallery.getPrimaryKey());

		feedforwardgalleryImpl.setId(feedforwardgallery.getId());
		feedforwardgalleryImpl.setAlbumName(feedforwardgallery.getAlbumName());
		feedforwardgalleryImpl.setAlbumDesc(feedforwardgallery.getAlbumDesc());
		feedforwardgalleryImpl.setAlbumId(feedforwardgallery.getAlbumId());
		feedforwardgalleryImpl.setCreatedDate(feedforwardgallery.getCreatedDate());
		feedforwardgalleryImpl.setCreatedBy(feedforwardgallery.getCreatedBy());
		feedforwardgalleryImpl.setUpdatedDate(feedforwardgallery.getUpdatedDate());
		feedforwardgalleryImpl.setUpdatedBy(feedforwardgallery.getUpdatedBy());
		feedforwardgalleryImpl.setFlag(feedforwardgallery.getFlag());
		feedforwardgalleryImpl.setContent_id(feedforwardgallery.getContent_id());

		return feedforwardgalleryImpl;
	}

	/**
	 * Returns the feedforwardgallery with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the feedforwardgallery
	 * @return the feedforwardgallery
	 * @throws NoSuchfeedforwardgalleryException if a feedforwardgallery with the primary key could not be found
	 */
	@Override
	public feedforwardgallery findByPrimaryKey(Serializable primaryKey)
		throws NoSuchfeedforwardgalleryException {
		feedforwardgallery feedforwardgallery = fetchByPrimaryKey(primaryKey);

		if (feedforwardgallery == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchfeedforwardgalleryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return feedforwardgallery;
	}

	/**
	 * Returns the feedforwardgallery with the primary key or throws a {@link NoSuchfeedforwardgalleryException} if it could not be found.
	 *
	 * @param id the primary key of the feedforwardgallery
	 * @return the feedforwardgallery
	 * @throws NoSuchfeedforwardgalleryException if a feedforwardgallery with the primary key could not be found
	 */
	@Override
	public feedforwardgallery findByPrimaryKey(long id)
		throws NoSuchfeedforwardgalleryException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the feedforwardgallery with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the feedforwardgallery
	 * @return the feedforwardgallery, or <code>null</code> if a feedforwardgallery with the primary key could not be found
	 */
	@Override
	public feedforwardgallery fetchByPrimaryKey(Serializable primaryKey) {
		feedforwardgallery feedforwardgallery = (feedforwardgallery)entityCache.getResult(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
				feedforwardgalleryImpl.class, primaryKey);

		if (feedforwardgallery == _nullfeedforwardgallery) {
			return null;
		}

		if (feedforwardgallery == null) {
			Session session = null;

			try {
				session = openSession();

				feedforwardgallery = (feedforwardgallery)session.get(feedforwardgalleryImpl.class,
						primaryKey);

				if (feedforwardgallery != null) {
					cacheResult(feedforwardgallery);
				}
				else {
					entityCache.putResult(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
						feedforwardgalleryImpl.class, primaryKey,
						_nullfeedforwardgallery);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
					feedforwardgalleryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return feedforwardgallery;
	}

	/**
	 * Returns the feedforwardgallery with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the feedforwardgallery
	 * @return the feedforwardgallery, or <code>null</code> if a feedforwardgallery with the primary key could not be found
	 */
	@Override
	public feedforwardgallery fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, feedforwardgallery> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, feedforwardgallery> map = new HashMap<Serializable, feedforwardgallery>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			feedforwardgallery feedforwardgallery = fetchByPrimaryKey(primaryKey);

			if (feedforwardgallery != null) {
				map.put(primaryKey, feedforwardgallery);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			feedforwardgallery feedforwardgallery = (feedforwardgallery)entityCache.getResult(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
					feedforwardgalleryImpl.class, primaryKey);

			if (feedforwardgallery == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, feedforwardgallery);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FEEDFORWARDGALLERY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (feedforwardgallery feedforwardgallery : (List<feedforwardgallery>)q.list()) {
				map.put(feedforwardgallery.getPrimaryKeyObj(),
					feedforwardgallery);

				cacheResult(feedforwardgallery);

				uncachedPrimaryKeys.remove(feedforwardgallery.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(feedforwardgalleryModelImpl.ENTITY_CACHE_ENABLED,
					feedforwardgalleryImpl.class, primaryKey,
					_nullfeedforwardgallery);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the feedforwardgalleries.
	 *
	 * @return the feedforwardgalleries
	 */
	@Override
	public List<feedforwardgallery> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedforwardgalleries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link feedforwardgalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedforwardgalleries
	 * @param end the upper bound of the range of feedforwardgalleries (not inclusive)
	 * @return the range of feedforwardgalleries
	 */
	@Override
	public List<feedforwardgallery> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedforwardgalleries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link feedforwardgalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedforwardgalleries
	 * @param end the upper bound of the range of feedforwardgalleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of feedforwardgalleries
	 */
	@Override
	public List<feedforwardgallery> findAll(int start, int end,
		OrderByComparator<feedforwardgallery> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feedforwardgalleries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link feedforwardgalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedforwardgalleries
	 * @param end the upper bound of the range of feedforwardgalleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of feedforwardgalleries
	 */
	@Override
	public List<feedforwardgallery> findAll(int start, int end,
		OrderByComparator<feedforwardgallery> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<feedforwardgallery> list = null;

		if (retrieveFromCache) {
			list = (List<feedforwardgallery>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FEEDFORWARDGALLERY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FEEDFORWARDGALLERY;

				if (pagination) {
					sql = sql.concat(feedforwardgalleryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<feedforwardgallery>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<feedforwardgallery>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the feedforwardgalleries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (feedforwardgallery feedforwardgallery : findAll()) {
			remove(feedforwardgallery);
		}
	}

	/**
	 * Returns the number of feedforwardgalleries.
	 *
	 * @return the number of feedforwardgalleries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FEEDFORWARDGALLERY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return feedforwardgalleryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the feedforwardgallery persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(feedforwardgalleryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_FEEDFORWARDGALLERY = "SELECT feedforwardgallery FROM feedforwardgallery feedforwardgallery";
	private static final String _SQL_SELECT_FEEDFORWARDGALLERY_WHERE_PKS_IN = "SELECT feedforwardgallery FROM feedforwardgallery feedforwardgallery WHERE id_ IN (";
	private static final String _SQL_SELECT_FEEDFORWARDGALLERY_WHERE = "SELECT feedforwardgallery FROM feedforwardgallery feedforwardgallery WHERE ";
	private static final String _SQL_COUNT_FEEDFORWARDGALLERY = "SELECT COUNT(feedforwardgallery) FROM feedforwardgallery feedforwardgallery";
	private static final String _SQL_COUNT_FEEDFORWARDGALLERY_WHERE = "SELECT COUNT(feedforwardgallery) FROM feedforwardgallery feedforwardgallery WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "feedforwardgallery.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No feedforwardgallery exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No feedforwardgallery exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(feedforwardgalleryPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static final feedforwardgallery _nullfeedforwardgallery = new feedforwardgalleryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<feedforwardgallery> toCacheModel() {
				return _nullfeedforwardgalleryCacheModel;
			}
		};

	private static final CacheModel<feedforwardgallery> _nullfeedforwardgalleryCacheModel =
		new CacheModel<feedforwardgallery>() {
			@Override
			public feedforwardgallery toEntityModel() {
				return _nullfeedforwardgallery;
			}
		};
}