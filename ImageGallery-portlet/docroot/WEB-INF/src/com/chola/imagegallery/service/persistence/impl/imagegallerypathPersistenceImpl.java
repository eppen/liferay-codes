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

package com.chola.imagegallery.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.chola.imagegallery.exception.NoSuchimagegallerypathException;
import com.chola.imagegallery.model.imagegallerypath;
import com.chola.imagegallery.model.impl.imagegallerypathImpl;
import com.chola.imagegallery.model.impl.imagegallerypathModelImpl;
import com.chola.imagegallery.service.persistence.imagegallerypathPersistence;

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
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the imagegallerypath service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CloverLiferay02
 * @see imagegallerypathPersistence
 * @see com.chola.imagegallery.service.persistence.imagegallerypathUtil
 * @generated
 */
@ProviderType
public class imagegallerypathPersistenceImpl extends BasePersistenceImpl<imagegallerypath>
	implements imagegallerypathPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link imagegallerypathUtil} to access the imagegallerypath persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = imagegallerypathImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
			imagegallerypathModelImpl.FINDER_CACHE_ENABLED,
			imagegallerypathImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
			imagegallerypathModelImpl.FINDER_CACHE_ENABLED,
			imagegallerypathImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
			imagegallerypathModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALBUM_ID = new FinderPath(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
			imagegallerypathModelImpl.FINDER_CACHE_ENABLED,
			imagegallerypathImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByALBUM_ID",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUM_ID =
		new FinderPath(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
			imagegallerypathModelImpl.FINDER_CACHE_ENABLED,
			imagegallerypathImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByALBUM_ID",
			new String[] { String.class.getName() },
			imagegallerypathModelImpl.ALBUMID_COLUMN_BITMASK |
			imagegallerypathModelImpl.CREATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALBUM_ID = new FinderPath(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
			imagegallerypathModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByALBUM_ID",
			new String[] { String.class.getName() });

	/**
	 * Returns all the imagegallerypaths where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @return the matching imagegallerypaths
	 */
	@Override
	public List<imagegallerypath> findByALBUM_ID(String albumId) {
		return findByALBUM_ID(albumId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the imagegallerypaths where albumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link imagegallerypathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param albumId the album ID
	 * @param start the lower bound of the range of imagegallerypaths
	 * @param end the upper bound of the range of imagegallerypaths (not inclusive)
	 * @return the range of matching imagegallerypaths
	 */
	@Override
	public List<imagegallerypath> findByALBUM_ID(String albumId, int start,
		int end) {
		return findByALBUM_ID(albumId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the imagegallerypaths where albumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link imagegallerypathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param albumId the album ID
	 * @param start the lower bound of the range of imagegallerypaths
	 * @param end the upper bound of the range of imagegallerypaths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching imagegallerypaths
	 */
	@Override
	public List<imagegallerypath> findByALBUM_ID(String albumId, int start,
		int end, OrderByComparator<imagegallerypath> orderByComparator) {
		return findByALBUM_ID(albumId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the imagegallerypaths where albumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link imagegallerypathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param albumId the album ID
	 * @param start the lower bound of the range of imagegallerypaths
	 * @param end the upper bound of the range of imagegallerypaths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching imagegallerypaths
	 */
	@Override
	public List<imagegallerypath> findByALBUM_ID(String albumId, int start,
		int end, OrderByComparator<imagegallerypath> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUM_ID;
			finderArgs = new Object[] { albumId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALBUM_ID;
			finderArgs = new Object[] { albumId, start, end, orderByComparator };
		}

		List<imagegallerypath> list = null;

		if (retrieveFromCache) {
			list = (List<imagegallerypath>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (imagegallerypath imagegallerypath : list) {
					if (!Objects.equals(albumId, imagegallerypath.getAlbumId())) {
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

			query.append(_SQL_SELECT_IMAGEGALLERYPATH_WHERE);

			boolean bindAlbumId = false;

			if (albumId == null) {
				query.append(_FINDER_COLUMN_ALBUM_ID_ALBUMID_1);
			}
			else if (albumId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALBUM_ID_ALBUMID_3);
			}
			else {
				bindAlbumId = true;

				query.append(_FINDER_COLUMN_ALBUM_ID_ALBUMID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(imagegallerypathModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAlbumId) {
					qPos.add(albumId);
				}

				if (!pagination) {
					list = (List<imagegallerypath>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<imagegallerypath>)QueryUtil.list(q,
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
	 * Returns the first imagegallerypath in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching imagegallerypath
	 * @throws NoSuchimagegallerypathException if a matching imagegallerypath could not be found
	 */
	@Override
	public imagegallerypath findByALBUM_ID_First(String albumId,
		OrderByComparator<imagegallerypath> orderByComparator)
		throws NoSuchimagegallerypathException {
		imagegallerypath imagegallerypath = fetchByALBUM_ID_First(albumId,
				orderByComparator);

		if (imagegallerypath != null) {
			return imagegallerypath;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("albumId=");
		msg.append(albumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchimagegallerypathException(msg.toString());
	}

	/**
	 * Returns the first imagegallerypath in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching imagegallerypath, or <code>null</code> if a matching imagegallerypath could not be found
	 */
	@Override
	public imagegallerypath fetchByALBUM_ID_First(String albumId,
		OrderByComparator<imagegallerypath> orderByComparator) {
		List<imagegallerypath> list = findByALBUM_ID(albumId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last imagegallerypath in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching imagegallerypath
	 * @throws NoSuchimagegallerypathException if a matching imagegallerypath could not be found
	 */
	@Override
	public imagegallerypath findByALBUM_ID_Last(String albumId,
		OrderByComparator<imagegallerypath> orderByComparator)
		throws NoSuchimagegallerypathException {
		imagegallerypath imagegallerypath = fetchByALBUM_ID_Last(albumId,
				orderByComparator);

		if (imagegallerypath != null) {
			return imagegallerypath;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("albumId=");
		msg.append(albumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchimagegallerypathException(msg.toString());
	}

	/**
	 * Returns the last imagegallerypath in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching imagegallerypath, or <code>null</code> if a matching imagegallerypath could not be found
	 */
	@Override
	public imagegallerypath fetchByALBUM_ID_Last(String albumId,
		OrderByComparator<imagegallerypath> orderByComparator) {
		int count = countByALBUM_ID(albumId);

		if (count == 0) {
			return null;
		}

		List<imagegallerypath> list = findByALBUM_ID(albumId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the imagegallerypaths before and after the current imagegallerypath in the ordered set where albumId = &#63;.
	 *
	 * @param id the primary key of the current imagegallerypath
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next imagegallerypath
	 * @throws NoSuchimagegallerypathException if a imagegallerypath with the primary key could not be found
	 */
	@Override
	public imagegallerypath[] findByALBUM_ID_PrevAndNext(long id,
		String albumId, OrderByComparator<imagegallerypath> orderByComparator)
		throws NoSuchimagegallerypathException {
		imagegallerypath imagegallerypath = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			imagegallerypath[] array = new imagegallerypathImpl[3];

			array[0] = getByALBUM_ID_PrevAndNext(session, imagegallerypath,
					albumId, orderByComparator, true);

			array[1] = imagegallerypath;

			array[2] = getByALBUM_ID_PrevAndNext(session, imagegallerypath,
					albumId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected imagegallerypath getByALBUM_ID_PrevAndNext(Session session,
		imagegallerypath imagegallerypath, String albumId,
		OrderByComparator<imagegallerypath> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IMAGEGALLERYPATH_WHERE);

		boolean bindAlbumId = false;

		if (albumId == null) {
			query.append(_FINDER_COLUMN_ALBUM_ID_ALBUMID_1);
		}
		else if (albumId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ALBUM_ID_ALBUMID_3);
		}
		else {
			bindAlbumId = true;

			query.append(_FINDER_COLUMN_ALBUM_ID_ALBUMID_2);
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
			query.append(imagegallerypathModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAlbumId) {
			qPos.add(albumId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(imagegallerypath);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<imagegallerypath> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the imagegallerypaths where albumId = &#63; from the database.
	 *
	 * @param albumId the album ID
	 */
	@Override
	public void removeByALBUM_ID(String albumId) {
		for (imagegallerypath imagegallerypath : findByALBUM_ID(albumId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(imagegallerypath);
		}
	}

	/**
	 * Returns the number of imagegallerypaths where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @return the number of matching imagegallerypaths
	 */
	@Override
	public int countByALBUM_ID(String albumId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALBUM_ID;

		Object[] finderArgs = new Object[] { albumId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMAGEGALLERYPATH_WHERE);

			boolean bindAlbumId = false;

			if (albumId == null) {
				query.append(_FINDER_COLUMN_ALBUM_ID_ALBUMID_1);
			}
			else if (albumId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALBUM_ID_ALBUMID_3);
			}
			else {
				bindAlbumId = true;

				query.append(_FINDER_COLUMN_ALBUM_ID_ALBUMID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAlbumId) {
					qPos.add(albumId);
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

	private static final String _FINDER_COLUMN_ALBUM_ID_ALBUMID_1 = "imagegallerypath.albumId IS NULL";
	private static final String _FINDER_COLUMN_ALBUM_ID_ALBUMID_2 = "imagegallerypath.albumId = ?";
	private static final String _FINDER_COLUMN_ALBUM_ID_ALBUMID_3 = "(imagegallerypath.albumId IS NULL OR imagegallerypath.albumId = '')";

	public imagegallerypathPersistenceImpl() {
		setModelClass(imagegallerypath.class);
	}

	/**
	 * Caches the imagegallerypath in the entity cache if it is enabled.
	 *
	 * @param imagegallerypath the imagegallerypath
	 */
	@Override
	public void cacheResult(imagegallerypath imagegallerypath) {
		entityCache.putResult(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
			imagegallerypathImpl.class, imagegallerypath.getPrimaryKey(),
			imagegallerypath);

		imagegallerypath.resetOriginalValues();
	}

	/**
	 * Caches the imagegallerypaths in the entity cache if it is enabled.
	 *
	 * @param imagegallerypaths the imagegallerypaths
	 */
	@Override
	public void cacheResult(List<imagegallerypath> imagegallerypaths) {
		for (imagegallerypath imagegallerypath : imagegallerypaths) {
			if (entityCache.getResult(
						imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
						imagegallerypathImpl.class,
						imagegallerypath.getPrimaryKey()) == null) {
				cacheResult(imagegallerypath);
			}
			else {
				imagegallerypath.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all imagegallerypaths.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(imagegallerypathImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the imagegallerypath.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(imagegallerypath imagegallerypath) {
		entityCache.removeResult(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
			imagegallerypathImpl.class, imagegallerypath.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<imagegallerypath> imagegallerypaths) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (imagegallerypath imagegallerypath : imagegallerypaths) {
			entityCache.removeResult(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
				imagegallerypathImpl.class, imagegallerypath.getPrimaryKey());
		}
	}

	/**
	 * Creates a new imagegallerypath with the primary key. Does not add the imagegallerypath to the database.
	 *
	 * @param id the primary key for the new imagegallerypath
	 * @return the new imagegallerypath
	 */
	@Override
	public imagegallerypath create(long id) {
		imagegallerypath imagegallerypath = new imagegallerypathImpl();

		imagegallerypath.setNew(true);
		imagegallerypath.setPrimaryKey(id);

		return imagegallerypath;
	}

	/**
	 * Removes the imagegallerypath with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the imagegallerypath
	 * @return the imagegallerypath that was removed
	 * @throws NoSuchimagegallerypathException if a imagegallerypath with the primary key could not be found
	 */
	@Override
	public imagegallerypath remove(long id)
		throws NoSuchimagegallerypathException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the imagegallerypath with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the imagegallerypath
	 * @return the imagegallerypath that was removed
	 * @throws NoSuchimagegallerypathException if a imagegallerypath with the primary key could not be found
	 */
	@Override
	public imagegallerypath remove(Serializable primaryKey)
		throws NoSuchimagegallerypathException {
		Session session = null;

		try {
			session = openSession();

			imagegallerypath imagegallerypath = (imagegallerypath)session.get(imagegallerypathImpl.class,
					primaryKey);

			if (imagegallerypath == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchimagegallerypathException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(imagegallerypath);
		}
		catch (NoSuchimagegallerypathException nsee) {
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
	protected imagegallerypath removeImpl(imagegallerypath imagegallerypath) {
		imagegallerypath = toUnwrappedModel(imagegallerypath);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(imagegallerypath)) {
				imagegallerypath = (imagegallerypath)session.get(imagegallerypathImpl.class,
						imagegallerypath.getPrimaryKeyObj());
			}

			if (imagegallerypath != null) {
				session.delete(imagegallerypath);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (imagegallerypath != null) {
			clearCache(imagegallerypath);
		}

		return imagegallerypath;
	}

	@Override
	public imagegallerypath updateImpl(imagegallerypath imagegallerypath) {
		imagegallerypath = toUnwrappedModel(imagegallerypath);

		boolean isNew = imagegallerypath.isNew();

		imagegallerypathModelImpl imagegallerypathModelImpl = (imagegallerypathModelImpl)imagegallerypath;

		Session session = null;

		try {
			session = openSession();

			if (imagegallerypath.isNew()) {
				session.save(imagegallerypath);

				imagegallerypath.setNew(false);
			}
			else {
				imagegallerypath = (imagegallerypath)session.merge(imagegallerypath);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !imagegallerypathModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((imagegallerypathModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUM_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						imagegallerypathModelImpl.getOriginalAlbumId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ALBUM_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUM_ID,
					args);

				args = new Object[] { imagegallerypathModelImpl.getAlbumId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ALBUM_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUM_ID,
					args);
			}
		}

		entityCache.putResult(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
			imagegallerypathImpl.class, imagegallerypath.getPrimaryKey(),
			imagegallerypath, false);

		imagegallerypath.resetOriginalValues();

		return imagegallerypath;
	}

	protected imagegallerypath toUnwrappedModel(
		imagegallerypath imagegallerypath) {
		if (imagegallerypath instanceof imagegallerypathImpl) {
			return imagegallerypath;
		}

		imagegallerypathImpl imagegallerypathImpl = new imagegallerypathImpl();

		imagegallerypathImpl.setNew(imagegallerypath.isNew());
		imagegallerypathImpl.setPrimaryKey(imagegallerypath.getPrimaryKey());

		imagegallerypathImpl.setId(imagegallerypath.getId());
		imagegallerypathImpl.setAlbumId(imagegallerypath.getAlbumId());
		imagegallerypathImpl.setContent_id(imagegallerypath.getContent_id());
		imagegallerypathImpl.setAlbumImagePath(imagegallerypath.getAlbumImagePath());
		imagegallerypathImpl.setCreatedDate(imagegallerypath.getCreatedDate());
		imagegallerypathImpl.setCreatedBy(imagegallerypath.getCreatedBy());
		imagegallerypathImpl.setUpdatedDate(imagegallerypath.getUpdatedDate());
		imagegallerypathImpl.setUpdatedBy(imagegallerypath.getUpdatedBy());
		imagegallerypathImpl.setFlag(imagegallerypath.getFlag());

		return imagegallerypathImpl;
	}

	/**
	 * Returns the imagegallerypath with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the imagegallerypath
	 * @return the imagegallerypath
	 * @throws NoSuchimagegallerypathException if a imagegallerypath with the primary key could not be found
	 */
	@Override
	public imagegallerypath findByPrimaryKey(Serializable primaryKey)
		throws NoSuchimagegallerypathException {
		imagegallerypath imagegallerypath = fetchByPrimaryKey(primaryKey);

		if (imagegallerypath == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchimagegallerypathException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return imagegallerypath;
	}

	/**
	 * Returns the imagegallerypath with the primary key or throws a {@link NoSuchimagegallerypathException} if it could not be found.
	 *
	 * @param id the primary key of the imagegallerypath
	 * @return the imagegallerypath
	 * @throws NoSuchimagegallerypathException if a imagegallerypath with the primary key could not be found
	 */
	@Override
	public imagegallerypath findByPrimaryKey(long id)
		throws NoSuchimagegallerypathException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the imagegallerypath with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the imagegallerypath
	 * @return the imagegallerypath, or <code>null</code> if a imagegallerypath with the primary key could not be found
	 */
	@Override
	public imagegallerypath fetchByPrimaryKey(Serializable primaryKey) {
		imagegallerypath imagegallerypath = (imagegallerypath)entityCache.getResult(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
				imagegallerypathImpl.class, primaryKey);

		if (imagegallerypath == _nullimagegallerypath) {
			return null;
		}

		if (imagegallerypath == null) {
			Session session = null;

			try {
				session = openSession();

				imagegallerypath = (imagegallerypath)session.get(imagegallerypathImpl.class,
						primaryKey);

				if (imagegallerypath != null) {
					cacheResult(imagegallerypath);
				}
				else {
					entityCache.putResult(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
						imagegallerypathImpl.class, primaryKey,
						_nullimagegallerypath);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
					imagegallerypathImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return imagegallerypath;
	}

	/**
	 * Returns the imagegallerypath with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the imagegallerypath
	 * @return the imagegallerypath, or <code>null</code> if a imagegallerypath with the primary key could not be found
	 */
	@Override
	public imagegallerypath fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, imagegallerypath> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, imagegallerypath> map = new HashMap<Serializable, imagegallerypath>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			imagegallerypath imagegallerypath = fetchByPrimaryKey(primaryKey);

			if (imagegallerypath != null) {
				map.put(primaryKey, imagegallerypath);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			imagegallerypath imagegallerypath = (imagegallerypath)entityCache.getResult(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
					imagegallerypathImpl.class, primaryKey);

			if (imagegallerypath == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, imagegallerypath);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_IMAGEGALLERYPATH_WHERE_PKS_IN);

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

			for (imagegallerypath imagegallerypath : (List<imagegallerypath>)q.list()) {
				map.put(imagegallerypath.getPrimaryKeyObj(), imagegallerypath);

				cacheResult(imagegallerypath);

				uncachedPrimaryKeys.remove(imagegallerypath.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(imagegallerypathModelImpl.ENTITY_CACHE_ENABLED,
					imagegallerypathImpl.class, primaryKey,
					_nullimagegallerypath);
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
	 * Returns all the imagegallerypaths.
	 *
	 * @return the imagegallerypaths
	 */
	@Override
	public List<imagegallerypath> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the imagegallerypaths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link imagegallerypathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of imagegallerypaths
	 * @param end the upper bound of the range of imagegallerypaths (not inclusive)
	 * @return the range of imagegallerypaths
	 */
	@Override
	public List<imagegallerypath> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the imagegallerypaths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link imagegallerypathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of imagegallerypaths
	 * @param end the upper bound of the range of imagegallerypaths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of imagegallerypaths
	 */
	@Override
	public List<imagegallerypath> findAll(int start, int end,
		OrderByComparator<imagegallerypath> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the imagegallerypaths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link imagegallerypathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of imagegallerypaths
	 * @param end the upper bound of the range of imagegallerypaths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of imagegallerypaths
	 */
	@Override
	public List<imagegallerypath> findAll(int start, int end,
		OrderByComparator<imagegallerypath> orderByComparator,
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

		List<imagegallerypath> list = null;

		if (retrieveFromCache) {
			list = (List<imagegallerypath>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_IMAGEGALLERYPATH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMAGEGALLERYPATH;

				if (pagination) {
					sql = sql.concat(imagegallerypathModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<imagegallerypath>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<imagegallerypath>)QueryUtil.list(q,
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
	 * Removes all the imagegallerypaths from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (imagegallerypath imagegallerypath : findAll()) {
			remove(imagegallerypath);
		}
	}

	/**
	 * Returns the number of imagegallerypaths.
	 *
	 * @return the number of imagegallerypaths
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_IMAGEGALLERYPATH);

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
		return imagegallerypathModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the imagegallerypath persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(imagegallerypathImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_IMAGEGALLERYPATH = "SELECT imagegallerypath FROM imagegallerypath imagegallerypath";
	private static final String _SQL_SELECT_IMAGEGALLERYPATH_WHERE_PKS_IN = "SELECT imagegallerypath FROM imagegallerypath imagegallerypath WHERE id_ IN (";
	private static final String _SQL_SELECT_IMAGEGALLERYPATH_WHERE = "SELECT imagegallerypath FROM imagegallerypath imagegallerypath WHERE ";
	private static final String _SQL_COUNT_IMAGEGALLERYPATH = "SELECT COUNT(imagegallerypath) FROM imagegallerypath imagegallerypath";
	private static final String _SQL_COUNT_IMAGEGALLERYPATH_WHERE = "SELECT COUNT(imagegallerypath) FROM imagegallerypath imagegallerypath WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "imagegallerypath.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No imagegallerypath exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No imagegallerypath exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(imagegallerypathPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static final imagegallerypath _nullimagegallerypath = new imagegallerypathImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<imagegallerypath> toCacheModel() {
				return _nullimagegallerypathCacheModel;
			}
		};

	private static final CacheModel<imagegallerypath> _nullimagegallerypathCacheModel =
		new CacheModel<imagegallerypath>() {
			@Override
			public imagegallerypath toEntityModel() {
				return _nullimagegallerypath;
			}
		};
}