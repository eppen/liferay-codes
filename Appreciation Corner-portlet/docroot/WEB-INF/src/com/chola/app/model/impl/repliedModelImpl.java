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

package com.chola.app.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.chola.app.model.replied;
import com.chola.app.model.repliedModel;
import com.chola.app.model.repliedSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the replied service. Represents a row in the &quot;appreciation_replied&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link repliedModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link repliedImpl}.
 * </p>
 *
 * @author CloverLiferay02
 * @see repliedImpl
 * @see replied
 * @see repliedModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class repliedModelImpl extends BaseModelImpl<replied>
	implements repliedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a replied model instance should use the {@link replied} interface instead.
	 */
	public static final String TABLE_NAME = "appreciation_replied";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "repliedOnPost", Types.BIGINT },
			{ "repliedTo", Types.VARCHAR },
			{ "repliedBy", Types.VARCHAR },
			{ "repliedMessage", Types.VARCHAR },
			{ "repliedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("repliedOnPost", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("repliedTo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("repliedBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("repliedMessage", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("repliedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table appreciation_replied (id_ LONG not null primary key,repliedOnPost LONG,repliedTo VARCHAR(75) null,repliedBy VARCHAR(75) null,repliedMessage TEXT null,repliedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table appreciation_replied";
	public static final String ORDER_BY_JPQL = " ORDER BY replied.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY appreciation_replied.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.chola.app.model.replied"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.chola.app.model.replied"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static replied toModel(repliedSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		replied model = new repliedImpl();

		model.setId(soapModel.getId());
		model.setRepliedOnPost(soapModel.getRepliedOnPost());
		model.setRepliedTo(soapModel.getRepliedTo());
		model.setRepliedBy(soapModel.getRepliedBy());
		model.setRepliedMessage(soapModel.getRepliedMessage());
		model.setRepliedDate(soapModel.getRepliedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<replied> toModels(repliedSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<replied> models = new ArrayList<replied>(soapModels.length);

		for (repliedSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.chola.app.model.replied"));

	public repliedModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return replied.class;
	}

	@Override
	public String getModelClassName() {
		return replied.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("repliedOnPost", getRepliedOnPost());
		attributes.put("repliedTo", getRepliedTo());
		attributes.put("repliedBy", getRepliedBy());
		attributes.put("repliedMessage", getRepliedMessage());
		attributes.put("repliedDate", getRepliedDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long repliedOnPost = (Long)attributes.get("repliedOnPost");

		if (repliedOnPost != null) {
			setRepliedOnPost(repliedOnPost);
		}

		String repliedTo = (String)attributes.get("repliedTo");

		if (repliedTo != null) {
			setRepliedTo(repliedTo);
		}

		String repliedBy = (String)attributes.get("repliedBy");

		if (repliedBy != null) {
			setRepliedBy(repliedBy);
		}

		String repliedMessage = (String)attributes.get("repliedMessage");

		if (repliedMessage != null) {
			setRepliedMessage(repliedMessage);
		}

		Date repliedDate = (Date)attributes.get("repliedDate");

		if (repliedDate != null) {
			setRepliedDate(repliedDate);
		}
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@JSON
	@Override
	public long getRepliedOnPost() {
		return _repliedOnPost;
	}

	@Override
	public void setRepliedOnPost(long repliedOnPost) {
		_repliedOnPost = repliedOnPost;
	}

	@JSON
	@Override
	public String getRepliedTo() {
		if (_repliedTo == null) {
			return StringPool.BLANK;
		}
		else {
			return _repliedTo;
		}
	}

	@Override
	public void setRepliedTo(String repliedTo) {
		_repliedTo = repliedTo;
	}

	@JSON
	@Override
	public String getRepliedBy() {
		if (_repliedBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _repliedBy;
		}
	}

	@Override
	public void setRepliedBy(String repliedBy) {
		_repliedBy = repliedBy;
	}

	@JSON
	@Override
	public String getRepliedMessage() {
		if (_repliedMessage == null) {
			return StringPool.BLANK;
		}
		else {
			return _repliedMessage;
		}
	}

	@Override
	public void setRepliedMessage(String repliedMessage) {
		_repliedMessage = repliedMessage;
	}

	@JSON
	@Override
	public Date getRepliedDate() {
		return _repliedDate;
	}

	@Override
	public void setRepliedDate(Date repliedDate) {
		_repliedDate = repliedDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			replied.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public replied toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (replied)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		repliedImpl repliedImpl = new repliedImpl();

		repliedImpl.setId(getId());
		repliedImpl.setRepliedOnPost(getRepliedOnPost());
		repliedImpl.setRepliedTo(getRepliedTo());
		repliedImpl.setRepliedBy(getRepliedBy());
		repliedImpl.setRepliedMessage(getRepliedMessage());
		repliedImpl.setRepliedDate(getRepliedDate());

		repliedImpl.resetOriginalValues();

		return repliedImpl;
	}

	@Override
	public int compareTo(replied replied) {
		long primaryKey = replied.getPrimaryKey();

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

		if (!(obj instanceof replied)) {
			return false;
		}

		replied replied = (replied)obj;

		long primaryKey = replied.getPrimaryKey();

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
	public CacheModel<replied> toCacheModel() {
		repliedCacheModel repliedCacheModel = new repliedCacheModel();

		repliedCacheModel.id = getId();

		repliedCacheModel.repliedOnPost = getRepliedOnPost();

		repliedCacheModel.repliedTo = getRepliedTo();

		String repliedTo = repliedCacheModel.repliedTo;

		if ((repliedTo != null) && (repliedTo.length() == 0)) {
			repliedCacheModel.repliedTo = null;
		}

		repliedCacheModel.repliedBy = getRepliedBy();

		String repliedBy = repliedCacheModel.repliedBy;

		if ((repliedBy != null) && (repliedBy.length() == 0)) {
			repliedCacheModel.repliedBy = null;
		}

		repliedCacheModel.repliedMessage = getRepliedMessage();

		String repliedMessage = repliedCacheModel.repliedMessage;

		if ((repliedMessage != null) && (repliedMessage.length() == 0)) {
			repliedCacheModel.repliedMessage = null;
		}

		Date repliedDate = getRepliedDate();

		if (repliedDate != null) {
			repliedCacheModel.repliedDate = repliedDate.getTime();
		}
		else {
			repliedCacheModel.repliedDate = Long.MIN_VALUE;
		}

		return repliedCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", repliedOnPost=");
		sb.append(getRepliedOnPost());
		sb.append(", repliedTo=");
		sb.append(getRepliedTo());
		sb.append(", repliedBy=");
		sb.append(getRepliedBy());
		sb.append(", repliedMessage=");
		sb.append(getRepliedMessage());
		sb.append(", repliedDate=");
		sb.append(getRepliedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.chola.app.model.replied");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repliedOnPost</column-name><column-value><![CDATA[");
		sb.append(getRepliedOnPost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repliedTo</column-name><column-value><![CDATA[");
		sb.append(getRepliedTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repliedBy</column-name><column-value><![CDATA[");
		sb.append(getRepliedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repliedMessage</column-name><column-value><![CDATA[");
		sb.append(getRepliedMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repliedDate</column-name><column-value><![CDATA[");
		sb.append(getRepliedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = replied.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			replied.class
		};
	private long _id;
	private long _repliedOnPost;
	private String _repliedTo;
	private String _repliedBy;
	private String _repliedMessage;
	private Date _repliedDate;
	private replied _escapedModel;
}