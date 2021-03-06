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

package com.chola.swagatam.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.chola.swagatam.model.swagatamdata;
import com.chola.swagatam.model.swagatamdataModel;
import com.chola.swagatam.model.swagatamdataSoap;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the swagatamdata service. Represents a row in the &quot;cholas_swagatamdata&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link swagatamdataModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link swagatamdataImpl}.
 * </p>
 *
 * @author CloverLiferay02
 * @see swagatamdataImpl
 * @see swagatamdata
 * @see swagatamdataModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class swagatamdataModelImpl extends BaseModelImpl<swagatamdata>
	implements swagatamdataModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a swagatamdata model instance should use the {@link swagatamdata} interface instead.
	 */
	public static final String TABLE_NAME = "cholas_swagatamdata";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "empId", Types.VARCHAR },
			{ "watched", Types.VARCHAR },
			{ "acknowledged", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("empId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("watched", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("acknowledged", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table cholas_swagatamdata (id_ LONG not null primary key,empId VARCHAR(75) null,watched VARCHAR(75) null,acknowledged VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table cholas_swagatamdata";
	public static final String ORDER_BY_JPQL = " ORDER BY swagatamdata.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY cholas_swagatamdata.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.chola.swagatam.model.swagatamdata"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.chola.swagatam.model.swagatamdata"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static swagatamdata toModel(swagatamdataSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		swagatamdata model = new swagatamdataImpl();

		model.setId(soapModel.getId());
		model.setEmpId(soapModel.getEmpId());
		model.setWatched(soapModel.getWatched());
		model.setAcknowledged(soapModel.getAcknowledged());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<swagatamdata> toModels(swagatamdataSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<swagatamdata> models = new ArrayList<swagatamdata>(soapModels.length);

		for (swagatamdataSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.chola.swagatam.model.swagatamdata"));

	public swagatamdataModelImpl() {
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
		return swagatamdata.class;
	}

	@Override
	public String getModelClassName() {
		return swagatamdata.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("empId", getEmpId());
		attributes.put("watched", getWatched());
		attributes.put("acknowledged", getAcknowledged());

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

		String empId = (String)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String watched = (String)attributes.get("watched");

		if (watched != null) {
			setWatched(watched);
		}

		String acknowledged = (String)attributes.get("acknowledged");

		if (acknowledged != null) {
			setAcknowledged(acknowledged);
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
	public String getEmpId() {
		if (_empId == null) {
			return StringPool.BLANK;
		}
		else {
			return _empId;
		}
	}

	@Override
	public void setEmpId(String empId) {
		_empId = empId;
	}

	@JSON
	@Override
	public String getWatched() {
		if (_watched == null) {
			return StringPool.BLANK;
		}
		else {
			return _watched;
		}
	}

	@Override
	public void setWatched(String watched) {
		_watched = watched;
	}

	@JSON
	@Override
	public String getAcknowledged() {
		if (_acknowledged == null) {
			return StringPool.BLANK;
		}
		else {
			return _acknowledged;
		}
	}

	@Override
	public void setAcknowledged(String acknowledged) {
		_acknowledged = acknowledged;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			swagatamdata.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public swagatamdata toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (swagatamdata)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		swagatamdataImpl swagatamdataImpl = new swagatamdataImpl();

		swagatamdataImpl.setId(getId());
		swagatamdataImpl.setEmpId(getEmpId());
		swagatamdataImpl.setWatched(getWatched());
		swagatamdataImpl.setAcknowledged(getAcknowledged());

		swagatamdataImpl.resetOriginalValues();

		return swagatamdataImpl;
	}

	@Override
	public int compareTo(swagatamdata swagatamdata) {
		long primaryKey = swagatamdata.getPrimaryKey();

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

		if (!(obj instanceof swagatamdata)) {
			return false;
		}

		swagatamdata swagatamdata = (swagatamdata)obj;

		long primaryKey = swagatamdata.getPrimaryKey();

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
	public CacheModel<swagatamdata> toCacheModel() {
		swagatamdataCacheModel swagatamdataCacheModel = new swagatamdataCacheModel();

		swagatamdataCacheModel.id = getId();

		swagatamdataCacheModel.empId = getEmpId();

		String empId = swagatamdataCacheModel.empId;

		if ((empId != null) && (empId.length() == 0)) {
			swagatamdataCacheModel.empId = null;
		}

		swagatamdataCacheModel.watched = getWatched();

		String watched = swagatamdataCacheModel.watched;

		if ((watched != null) && (watched.length() == 0)) {
			swagatamdataCacheModel.watched = null;
		}

		swagatamdataCacheModel.acknowledged = getAcknowledged();

		String acknowledged = swagatamdataCacheModel.acknowledged;

		if ((acknowledged != null) && (acknowledged.length() == 0)) {
			swagatamdataCacheModel.acknowledged = null;
		}

		return swagatamdataCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", watched=");
		sb.append(getWatched());
		sb.append(", acknowledged=");
		sb.append(getAcknowledged());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.chola.swagatam.model.swagatamdata");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>watched</column-name><column-value><![CDATA[");
		sb.append(getWatched());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>acknowledged</column-name><column-value><![CDATA[");
		sb.append(getAcknowledged());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = swagatamdata.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			swagatamdata.class
		};
	private long _id;
	private String _empId;
	private String _watched;
	private String _acknowledged;
	private swagatamdata _escapedModel;
}