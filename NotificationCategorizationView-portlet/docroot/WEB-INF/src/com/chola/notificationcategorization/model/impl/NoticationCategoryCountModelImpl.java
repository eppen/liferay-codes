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

package com.chola.notificationcategorization.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.chola.notificationcategorization.model.NoticationCategoryCount;
import com.chola.notificationcategorization.model.NoticationCategoryCountModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the NoticationCategoryCount service. Represents a row in the &quot;notify_NoticationCategoryCount&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link NoticationCategoryCountModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NoticationCategoryCountImpl}.
 * </p>
 *
 * @author cloverliferay03
 * @see NoticationCategoryCountImpl
 * @see NoticationCategoryCount
 * @see NoticationCategoryCountModel
 * @generated
 */
@ProviderType
public class NoticationCategoryCountModelImpl extends BaseModelImpl<NoticationCategoryCount>
	implements NoticationCategoryCountModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a notication category count model instance should use the {@link NoticationCategoryCount} interface instead.
	 */
	public static final String TABLE_NAME = "notify_NoticationCategoryCount";
	public static final Object[][] TABLE_COLUMNS = {
			{ "eventId", Types.BIGINT },
			{ "username", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("eventId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("username", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table notify_NoticationCategoryCount (eventId LONG not null primary key,username VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table notify_NoticationCategoryCount";
	public static final String ORDER_BY_JPQL = " ORDER BY noticationCategoryCount.eventId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY notify_NoticationCategoryCount.eventId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.chola.notificationcategorization.model.NoticationCategoryCount"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.chola.notificationcategorization.model.NoticationCategoryCount"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.chola.notificationcategorization.model.NoticationCategoryCount"));

	public NoticationCategoryCountModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _eventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return NoticationCategoryCount.class;
	}

	@Override
	public String getModelClassName() {
		return NoticationCategoryCount.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventId", getEventId());
		attributes.put("username", getUsername());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}
	}

	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	@Override
	public String getUsername() {
		if (_username == null) {
			return StringPool.BLANK;
		}
		else {
			return _username;
		}
	}

	@Override
	public void setUsername(String username) {
		_username = username;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			NoticationCategoryCount.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NoticationCategoryCount toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (NoticationCategoryCount)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		NoticationCategoryCountImpl noticationCategoryCountImpl = new NoticationCategoryCountImpl();

		noticationCategoryCountImpl.setEventId(getEventId());
		noticationCategoryCountImpl.setUsername(getUsername());

		noticationCategoryCountImpl.resetOriginalValues();

		return noticationCategoryCountImpl;
	}

	@Override
	public int compareTo(NoticationCategoryCount noticationCategoryCount) {
		long primaryKey = noticationCategoryCount.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NoticationCategoryCount)) {
			return false;
		}

		NoticationCategoryCount noticationCategoryCount = (NoticationCategoryCount)obj;

		long primaryKey = noticationCategoryCount.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<NoticationCategoryCount> toCacheModel() {
		NoticationCategoryCountCacheModel noticationCategoryCountCacheModel = new NoticationCategoryCountCacheModel();

		noticationCategoryCountCacheModel.eventId = getEventId();

		noticationCategoryCountCacheModel.username = getUsername();

		String username = noticationCategoryCountCacheModel.username;

		if ((username != null) && (username.length() == 0)) {
			noticationCategoryCountCacheModel.username = null;
		}

		return noticationCategoryCountCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{eventId=");
		sb.append(getEventId());
		sb.append(", username=");
		sb.append(getUsername());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append(
			"com.chola.notificationcategorization.model.NoticationCategoryCount");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>username</column-name><column-value><![CDATA[");
		sb.append(getUsername());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = NoticationCategoryCount.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			NoticationCategoryCount.class
		};
	private long _eventId;
	private String _username;
	private NoticationCategoryCount _escapedModel;
}