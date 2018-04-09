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

package com.usertheme.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

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

import com.usertheme.exception.NoSuchthemecolorException;

import com.usertheme.model.impl.themecolorImpl;
import com.usertheme.model.impl.themecolorModelImpl;
import com.usertheme.model.themecolor;

import com.usertheme.service.persistence.themecolorPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the themecolor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CloverLiferay02
 * @see themecolorPersistence
 * @see com.usertheme.service.persistence.themecolorUtil
 * @generated
 */
@ProviderType
public class themecolorPersistenceImpl extends BasePersistenceImpl<themecolor>
	implements themecolorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link themecolorUtil} to access the themecolor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = themecolorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(themecolorModelImpl.ENTITY_CACHE_ENABLED,
			themecolorModelImpl.FINDER_CACHE_ENABLED, themecolorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(themecolorModelImpl.ENTITY_CACHE_ENABLED,
			themecolorModelImpl.FINDER_CACHE_ENABLED, themecolorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(themecolorModelImpl.ENTITY_CACHE_ENABLED,
			themecolorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(themecolorModelImpl.ENTITY_CACHE_ENABLED,
			themecolorModelImpl.FINDER_CACHE_ENABLED, themecolorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUSERID",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(themecolorModelImpl.ENTITY_CACHE_ENABLED,
			themecolorModelImpl.FINDER_CACHE_ENABLED, themecolorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUSERID",
			new String[] { String.class.getName() },
			themecolorModelImpl.USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(themecolorModelImpl.ENTITY_CACHE_ENABLED,
			themecolorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUSERID",
			new String[] { String.class.getName() });

	/**
	 * Returns all the themecolors where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @return the matching themecolors
	 */
	@Override
	public List<themecolor> findByUSERID(String user_id) {
		return findByUSERID(user_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the themecolors where user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link themecolorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param user_id the user_id
	 * @param start the lower bound of the range of themecolors
	 * @param end the upper bound of the range of themecolors (not inclusive)
	 * @return the range of matching themecolors
	 */
	@Override
	public List<themecolor> findByUSERID(String user_id, int start, int end) {
		return findByUSERID(user_id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the themecolors where user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link themecolorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param user_id the user_id
	 * @param start the lower bound of the range of themecolors
	 * @param end the upper bound of the range of themecolors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching themecolors
	 */
	@Override
	public List<themecolor> findByUSERID(String user_id, int start, int end,
		OrderByComparator<themecolor> orderByComparator) {
		return findByUSERID(user_id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the themecolors where user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link themecolorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param user_id the user_id
	 * @param start the lower bound of the range of themecolors
	 * @param end the upper bound of the range of themecolors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching themecolors
	 */
	@Override
	public List<themecolor> findByUSERID(String user_id, int start, int end,
		OrderByComparator<themecolor> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { user_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { user_id, start, end, orderByComparator };
		}

		List<themecolor> list = null;

		if (retrieveFromCache) {
			list = (List<themecolor>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (themecolor themecolor : list) {
					if (!Objects.equals(user_id, themecolor.getUser_id())) {
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

			query.append(_SQL_SELECT_THEMECOLOR_WHERE);

			boolean bindUser_id = false;

			if (user_id == null) {
				query.append(_FINDER_COLUMN_USERID_USER_ID_1);
			}
			else if (user_id.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERID_USER_ID_3);
			}
			else {
				bindUser_id = true;

				query.append(_FINDER_COLUMN_USERID_USER_ID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(themecolorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUser_id) {
					qPos.add(user_id);
				}

				if (!pagination) {
					list = (List<themecolor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<themecolor>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first themecolor in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themecolor
	 * @throws NoSuchthemecolorException if a matching themecolor could not be found
	 */
	@Override
	public themecolor findByUSERID_First(String user_id,
		OrderByComparator<themecolor> orderByComparator)
		throws NoSuchthemecolorException {
		themecolor themecolor = fetchByUSERID_First(user_id, orderByComparator);

		if (themecolor != null) {
			return themecolor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchthemecolorException(msg.toString());
	}

	/**
	 * Returns the first themecolor in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themecolor, or <code>null</code> if a matching themecolor could not be found
	 */
	@Override
	public themecolor fetchByUSERID_First(String user_id,
		OrderByComparator<themecolor> orderByComparator) {
		List<themecolor> list = findByUSERID(user_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last themecolor in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themecolor
	 * @throws NoSuchthemecolorException if a matching themecolor could not be found
	 */
	@Override
	public themecolor findByUSERID_Last(String user_id,
		OrderByComparator<themecolor> orderByComparator)
		throws NoSuchthemecolorException {
		themecolor themecolor = fetchByUSERID_Last(user_id, orderByComparator);

		if (themecolor != null) {
			return themecolor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchthemecolorException(msg.toString());
	}

	/**
	 * Returns the last themecolor in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themecolor, or <code>null</code> if a matching themecolor could not be found
	 */
	@Override
	public themecolor fetchByUSERID_Last(String user_id,
		OrderByComparator<themecolor> orderByComparator) {
		int count = countByUSERID(user_id);

		if (count == 0) {
			return null;
		}

		List<themecolor> list = findByUSERID(user_id, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the themecolors before and after the current themecolor in the ordered set where user_id = &#63;.
	 *
	 * @param id the primary key of the current themecolor
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next themecolor
	 * @throws NoSuchthemecolorException if a themecolor with the primary key could not be found
	 */
	@Override
	public themecolor[] findByUSERID_PrevAndNext(long id, String user_id,
		OrderByComparator<themecolor> orderByComparator)
		throws NoSuchthemecolorException {
		themecolor themecolor = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			themecolor[] array = new themecolorImpl[3];

			array[0] = getByUSERID_PrevAndNext(session, themecolor, user_id,
					orderByComparator, true);

			array[1] = themecolor;

			array[2] = getByUSERID_PrevAndNext(session, themecolor, user_id,
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

	protected themecolor getByUSERID_PrevAndNext(Session session,
		themecolor themecolor, String user_id,
		OrderByComparator<themecolor> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THEMECOLOR_WHERE);

		boolean bindUser_id = false;

		if (user_id == null) {
			query.append(_FINDER_COLUMN_USERID_USER_ID_1);
		}
		else if (user_id.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERID_USER_ID_3);
		}
		else {
			bindUser_id = true;

			query.append(_FINDER_COLUMN_USERID_USER_ID_2);
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
			query.append(themecolorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUser_id) {
			qPos.add(user_id);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(themecolor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<themecolor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the themecolors where user_id = &#63; from the database.
	 *
	 * @param user_id the user_id
	 */
	@Override
	public void removeByUSERID(String user_id) {
		for (themecolor themecolor : findByUSERID(user_id, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(themecolor);
		}
	}

	/**
	 * Returns the number of themecolors where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @return the number of matching themecolors
	 */
	@Override
	public int countByUSERID(String user_id) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { user_id };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THEMECOLOR_WHERE);

			boolean bindUser_id = false;

			if (user_id == null) {
				query.append(_FINDER_COLUMN_USERID_USER_ID_1);
			}
			else if (user_id.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERID_USER_ID_3);
			}
			else {
				bindUser_id = true;

				query.append(_FINDER_COLUMN_USERID_USER_ID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUser_id) {
					qPos.add(user_id);
				}

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

	private static final String _FINDER_COLUMN_USERID_USER_ID_1 = "themecolor.user_id IS NULL";
	private static final String _FINDER_COLUMN_USERID_USER_ID_2 = "themecolor.user_id = ?";
	private static final String _FINDER_COLUMN_USERID_USER_ID_3 = "(themecolor.user_id IS NULL OR themecolor.user_id = '')";

	public themecolorPersistenceImpl() {
		setModelClass(themecolor.class);
	}

	/**
	 * Caches the themecolor in the entity cache if it is enabled.
	 *
	 * @param themecolor the themecolor
	 */
	@Override
	public void cacheResult(themecolor themecolor) {
		entityCache.putResult(themecolorModelImpl.ENTITY_CACHE_ENABLED,
			themecolorImpl.class, themecolor.getPrimaryKey(), themecolor);

		themecolor.resetOriginalValues();
	}

	/**
	 * Caches the themecolors in the entity cache if it is enabled.
	 *
	 * @param themecolors the themecolors
	 */
	@Override
	public void cacheResult(List<themecolor> themecolors) {
		for (themecolor themecolor : themecolors) {
			if (entityCache.getResult(
						themecolorModelImpl.ENTITY_CACHE_ENABLED,
						themecolorImpl.class, themecolor.getPrimaryKey()) == null) {
				cacheResult(themecolor);
			}
			else {
				themecolor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all themecolors.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(themecolorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the themecolor.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(themecolor themecolor) {
		entityCache.removeResult(themecolorModelImpl.ENTITY_CACHE_ENABLED,
			themecolorImpl.class, themecolor.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<themecolor> themecolors) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (themecolor themecolor : themecolors) {
			entityCache.removeResult(themecolorModelImpl.ENTITY_CACHE_ENABLED,
				themecolorImpl.class, themecolor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new themecolor with the primary key. Does not add the themecolor to the database.
	 *
	 * @param id the primary key for the new themecolor
	 * @return the new themecolor
	 */
	@Override
	public themecolor create(long id) {
		themecolor themecolor = new themecolorImpl();

		themecolor.setNew(true);
		themecolor.setPrimaryKey(id);

		return themecolor;
	}

	/**
	 * Removes the themecolor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the themecolor
	 * @return the themecolor that was removed
	 * @throws NoSuchthemecolorException if a themecolor with the primary key could not be found
	 */
	@Override
	public themecolor remove(long id) throws NoSuchthemecolorException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the themecolor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the themecolor
	 * @return the themecolor that was removed
	 * @throws NoSuchthemecolorException if a themecolor with the primary key could not be found
	 */
	@Override
	public themecolor remove(Serializable primaryKey)
		throws NoSuchthemecolorException {
		Session session = null;

		try {
			session = openSession();

			themecolor themecolor = (themecolor)session.get(themecolorImpl.class,
					primaryKey);

			if (themecolor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchthemecolorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(themecolor);
		}
		catch (NoSuchthemecolorException nsee) {
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
	protected themecolor removeImpl(themecolor themecolor) {
		themecolor = toUnwrappedModel(themecolor);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(themecolor)) {
				themecolor = (themecolor)session.get(themecolorImpl.class,
						themecolor.getPrimaryKeyObj());
			}

			if (themecolor != null) {
				session.delete(themecolor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (themecolor != null) {
			clearCache(themecolor);
		}

		return themecolor;
	}

	@Override
	public themecolor updateImpl(themecolor themecolor) {
		themecolor = toUnwrappedModel(themecolor);

		boolean isNew = themecolor.isNew();

		themecolorModelImpl themecolorModelImpl = (themecolorModelImpl)themecolor;

		Session session = null;

		try {
			session = openSession();

			if (themecolor.isNew()) {
				session.save(themecolor);

				themecolor.setNew(false);
			}
			else {
				themecolor = (themecolor)session.merge(themecolor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !themecolorModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((themecolorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						themecolorModelImpl.getOriginalUser_id()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { themecolorModelImpl.getUser_id() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		entityCache.putResult(themecolorModelImpl.ENTITY_CACHE_ENABLED,
			themecolorImpl.class, themecolor.getPrimaryKey(), themecolor, false);

		themecolor.resetOriginalValues();

		return themecolor;
	}

	protected themecolor toUnwrappedModel(themecolor themecolor) {
		if (themecolor instanceof themecolorImpl) {
			return themecolor;
		}

		themecolorImpl themecolorImpl = new themecolorImpl();

		themecolorImpl.setNew(themecolor.isNew());
		themecolorImpl.setPrimaryKey(themecolor.getPrimaryKey());

		themecolorImpl.setId(themecolor.getId());
		themecolorImpl.setUser_id(themecolor.getUser_id());
		themecolorImpl.setColor(themecolor.getColor());
		themecolorImpl.setUpdatedDate(themecolor.getUpdatedDate());

		return themecolorImpl;
	}

	/**
	 * Returns the themecolor with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the themecolor
	 * @return the themecolor
	 * @throws NoSuchthemecolorException if a themecolor with the primary key could not be found
	 */
	@Override
	public themecolor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchthemecolorException {
		themecolor themecolor = fetchByPrimaryKey(primaryKey);

		if (themecolor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchthemecolorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return themecolor;
	}

	/**
	 * Returns the themecolor with the primary key or throws a {@link NoSuchthemecolorException} if it could not be found.
	 *
	 * @param id the primary key of the themecolor
	 * @return the themecolor
	 * @throws NoSuchthemecolorException if a themecolor with the primary key could not be found
	 */
	@Override
	public themecolor findByPrimaryKey(long id)
		throws NoSuchthemecolorException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the themecolor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the themecolor
	 * @return the themecolor, or <code>null</code> if a themecolor with the primary key could not be found
	 */
	@Override
	public themecolor fetchByPrimaryKey(Serializable primaryKey) {
		themecolor themecolor = (themecolor)entityCache.getResult(themecolorModelImpl.ENTITY_CACHE_ENABLED,
				themecolorImpl.class, primaryKey);

		if (themecolor == _nullthemecolor) {
			return null;
		}

		if (themecolor == null) {
			Session session = null;

			try {
				session = openSession();

				themecolor = (themecolor)session.get(themecolorImpl.class,
						primaryKey);

				if (themecolor != null) {
					cacheResult(themecolor);
				}
				else {
					entityCache.putResult(themecolorModelImpl.ENTITY_CACHE_ENABLED,
						themecolorImpl.class, primaryKey, _nullthemecolor);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(themecolorModelImpl.ENTITY_CACHE_ENABLED,
					themecolorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return themecolor;
	}

	/**
	 * Returns the themecolor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the themecolor
	 * @return the themecolor, or <code>null</code> if a themecolor with the primary key could not be found
	 */
	@Override
	public themecolor fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, themecolor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, themecolor> map = new HashMap<Serializable, themecolor>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			themecolor themecolor = fetchByPrimaryKey(primaryKey);

			if (themecolor != null) {
				map.put(primaryKey, themecolor);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			themecolor themecolor = (themecolor)entityCache.getResult(themecolorModelImpl.ENTITY_CACHE_ENABLED,
					themecolorImpl.class, primaryKey);

			if (themecolor == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, themecolor);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_THEMECOLOR_WHERE_PKS_IN);

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

			for (themecolor themecolor : (List<themecolor>)q.list()) {
				map.put(themecolor.getPrimaryKeyObj(), themecolor);

				cacheResult(themecolor);

				uncachedPrimaryKeys.remove(themecolor.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(themecolorModelImpl.ENTITY_CACHE_ENABLED,
					themecolorImpl.class, primaryKey, _nullthemecolor);
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
	 * Returns all the themecolors.
	 *
	 * @return the themecolors
	 */
	@Override
	public List<themecolor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the themecolors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link themecolorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of themecolors
	 * @param end the upper bound of the range of themecolors (not inclusive)
	 * @return the range of themecolors
	 */
	@Override
	public List<themecolor> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the themecolors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link themecolorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of themecolors
	 * @param end the upper bound of the range of themecolors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of themecolors
	 */
	@Override
	public List<themecolor> findAll(int start, int end,
		OrderByComparator<themecolor> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the themecolors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link themecolorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of themecolors
	 * @param end the upper bound of the range of themecolors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of themecolors
	 */
	@Override
	public List<themecolor> findAll(int start, int end,
		OrderByComparator<themecolor> orderByComparator,
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

		List<themecolor> list = null;

		if (retrieveFromCache) {
			list = (List<themecolor>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_THEMECOLOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_THEMECOLOR;

				if (pagination) {
					sql = sql.concat(themecolorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<themecolor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<themecolor>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the themecolors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (themecolor themecolor : findAll()) {
			remove(themecolor);
		}
	}

	/**
	 * Returns the number of themecolors.
	 *
	 * @return the number of themecolors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_THEMECOLOR);

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
		return themecolorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the themecolor persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(themecolorImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_THEMECOLOR = "SELECT themecolor FROM themecolor themecolor";
	private static final String _SQL_SELECT_THEMECOLOR_WHERE_PKS_IN = "SELECT themecolor FROM themecolor themecolor WHERE id_ IN (";
	private static final String _SQL_SELECT_THEMECOLOR_WHERE = "SELECT themecolor FROM themecolor themecolor WHERE ";
	private static final String _SQL_COUNT_THEMECOLOR = "SELECT COUNT(themecolor) FROM themecolor themecolor";
	private static final String _SQL_COUNT_THEMECOLOR_WHERE = "SELECT COUNT(themecolor) FROM themecolor themecolor WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "themecolor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No themecolor exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No themecolor exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(themecolorPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static final themecolor _nullthemecolor = new themecolorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<themecolor> toCacheModel() {
				return _nullthemecolorCacheModel;
			}
		};

	private static final CacheModel<themecolor> _nullthemecolorCacheModel = new CacheModel<themecolor>() {
			@Override
			public themecolor toEntityModel() {
				return _nullthemecolor;
			}
		};
}