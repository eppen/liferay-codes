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

package com.chola.learningbites.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.chola.learningbites.model.lbusers;
import com.chola.learningbites.model.lbusersModel;
import com.chola.learningbites.model.lbusersSoap;

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

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the lbusers service. Represents a row in the &quot;chola_lbusers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link lbusersModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link lbusersImpl}.
 * </p>
 *
 * @author cloverliferay01
 * @see lbusersImpl
 * @see lbusers
 * @see lbusersModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class lbusersModelImpl extends BaseModelImpl<lbusers>
	implements lbusersModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lbusers model instance should use the {@link lbusers} interface instead.
	 */
	public static final String TABLE_NAME = "chola_lbusers";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "user_id", Types.BIGINT },
			{ "lb_id", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("user_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lb_id", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table chola_lbusers (id_ LONG not null primary key,user_id LONG,lb_id LONG)";
	public static final String TABLE_SQL_DROP = "drop table chola_lbusers";
	public static final String ORDER_BY_JPQL = " ORDER BY lbusers.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY chola_lbusers.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.chola.learningbites.model.lbusers"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.chola.learningbites.model.lbusers"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.chola.learningbites.model.lbusers"),
			true);
	public static final long LB_ID_COLUMN_BITMASK = 1L;
	public static final long USER_ID_COLUMN_BITMASK = 2L;
	public static final long ID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static lbusers toModel(lbusersSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		lbusers model = new lbusersImpl();

		model.setId(soapModel.getId());
		model.setUser_id(soapModel.getUser_id());
		model.setLb_id(soapModel.getLb_id());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<lbusers> toModels(lbusersSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<lbusers> models = new ArrayList<lbusers>(soapModels.length);

		for (lbusersSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.chola.learningbites.model.lbusers"));

	public lbusersModelImpl() {
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
		return lbusers.class;
	}

	@Override
	public String getModelClassName() {
		return lbusers.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("user_id", getUser_id());
		attributes.put("lb_id", getLb_id());

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

		Long user_id = (Long)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
		}

		Long lb_id = (Long)attributes.get("lb_id");

		if (lb_id != null) {
			setLb_id(lb_id);
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
	public long getUser_id() {
		return _user_id;
	}

	@Override
	public void setUser_id(long user_id) {
		_columnBitmask |= USER_ID_COLUMN_BITMASK;

		if (!_setOriginalUser_id) {
			_setOriginalUser_id = true;

			_originalUser_id = _user_id;
		}

		_user_id = user_id;
	}

	public long getOriginalUser_id() {
		return _originalUser_id;
	}

	@JSON
	@Override
	public long getLb_id() {
		return _lb_id;
	}

	@Override
	public void setLb_id(long lb_id) {
		_columnBitmask |= LB_ID_COLUMN_BITMASK;

		if (!_setOriginalLb_id) {
			_setOriginalLb_id = true;

			_originalLb_id = _lb_id;
		}

		_lb_id = lb_id;
	}

	public long getOriginalLb_id() {
		return _originalLb_id;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			lbusers.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public lbusers toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (lbusers)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		lbusersImpl lbusersImpl = new lbusersImpl();

		lbusersImpl.setId(getId());
		lbusersImpl.setUser_id(getUser_id());
		lbusersImpl.setLb_id(getLb_id());

		lbusersImpl.resetOriginalValues();

		return lbusersImpl;
	}

	@Override
	public int compareTo(lbusers lbusers) {
		long primaryKey = lbusers.getPrimaryKey();

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

		if (!(obj instanceof lbusers)) {
			return false;
		}

		lbusers lbusers = (lbusers)obj;

		long primaryKey = lbusers.getPrimaryKey();

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
		lbusersModelImpl lbusersModelImpl = this;

		lbusersModelImpl._originalUser_id = lbusersModelImpl._user_id;

		lbusersModelImpl._setOriginalUser_id = false;

		lbusersModelImpl._originalLb_id = lbusersModelImpl._lb_id;

		lbusersModelImpl._setOriginalLb_id = false;

		lbusersModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<lbusers> toCacheModel() {
		lbusersCacheModel lbusersCacheModel = new lbusersCacheModel();

		lbusersCacheModel.id = getId();

		lbusersCacheModel.user_id = getUser_id();

		lbusersCacheModel.lb_id = getLb_id();

		return lbusersCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", user_id=");
		sb.append(getUser_id());
		sb.append(", lb_id=");
		sb.append(getLb_id());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.chola.learningbites.model.lbusers");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>user_id</column-name><column-value><![CDATA[");
		sb.append(getUser_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lb_id</column-name><column-value><![CDATA[");
		sb.append(getLb_id());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = lbusers.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			lbusers.class
		};
	private long _id;
	private long _user_id;
	private long _originalUser_id;
	private boolean _setOriginalUser_id;
	private long _lb_id;
	private long _originalLb_id;
	private boolean _setOriginalLb_id;
	private long _columnBitmask;
	private lbusers _escapedModel;
}