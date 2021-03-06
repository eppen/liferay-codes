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

package com.chola.knowledgebites.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.chola.knowledgebites.model.kbpath;
import com.chola.knowledgebites.model.kbpathModel;
import com.chola.knowledgebites.model.kbpathSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
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
 * The base model implementation for the kbpath service. Represents a row in the &quot;chola_kbpath&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link kbpathModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link kbpathImpl}.
 * </p>
 *
 * @author cloverliferay01
 * @see kbpathImpl
 * @see kbpath
 * @see kbpathModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class kbpathModelImpl extends BaseModelImpl<kbpath>
	implements kbpathModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kbpath model instance should use the {@link kbpath} interface instead.
	 */
	public static final String TABLE_NAME = "chola_kbpath";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "kbfiledoc", Types.VARCHAR },
			{ "kbfilepath", Types.VARCHAR },
			{ "createdDate", Types.TIMESTAMP },
			{ "createdBy", Types.BIGINT },
			{ "flag", Types.VARCHAR },
			{ "kbdetails_id", Types.BIGINT },
			{ "content_id", Types.BIGINT },
			{ "kbfilename", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kbfiledoc", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("kbfilepath", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createdDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("flag", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("kbdetails_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("content_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kbfilename", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table chola_kbpath (id_ LONG not null primary key,kbfiledoc VARCHAR(500) null,kbfilepath VARCHAR(500) null,createdDate DATE null,createdBy LONG,flag VARCHAR(75) null,kbdetails_id LONG,content_id LONG,kbfilename VARCHAR(500) null)";
	public static final String TABLE_SQL_DROP = "drop table chola_kbpath";
	public static final String ORDER_BY_JPQL = " ORDER BY kbpath.createdDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY chola_kbpath.createdDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.chola.knowledgebites.model.kbpath"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.chola.knowledgebites.model.kbpath"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.chola.knowledgebites.model.kbpath"),
			true);
	public static final long CONTENT_ID_COLUMN_BITMASK = 1L;
	public static final long CREATEDDATE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static kbpath toModel(kbpathSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		kbpath model = new kbpathImpl();

		model.setId(soapModel.getId());
		model.setKbfiledoc(soapModel.getKbfiledoc());
		model.setKbfilepath(soapModel.getKbfilepath());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setFlag(soapModel.getFlag());
		model.setKbdetails_id(soapModel.getKbdetails_id());
		model.setContent_id(soapModel.getContent_id());
		model.setKbfilename(soapModel.getKbfilename());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<kbpath> toModels(kbpathSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<kbpath> models = new ArrayList<kbpath>(soapModels.length);

		for (kbpathSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.chola.knowledgebites.model.kbpath"));

	public kbpathModelImpl() {
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
		return kbpath.class;
	}

	@Override
	public String getModelClassName() {
		return kbpath.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("kbfiledoc", getKbfiledoc());
		attributes.put("kbfilepath", getKbfilepath());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("flag", getFlag());
		attributes.put("kbdetails_id", getKbdetails_id());
		attributes.put("content_id", getContent_id());
		attributes.put("kbfilename", getKbfilename());

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

		String kbfiledoc = (String)attributes.get("kbfiledoc");

		if (kbfiledoc != null) {
			setKbfiledoc(kbfiledoc);
		}

		String kbfilepath = (String)attributes.get("kbfilepath");

		if (kbfilepath != null) {
			setKbfilepath(kbfilepath);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		String flag = (String)attributes.get("flag");

		if (flag != null) {
			setFlag(flag);
		}

		Long kbdetails_id = (Long)attributes.get("kbdetails_id");

		if (kbdetails_id != null) {
			setKbdetails_id(kbdetails_id);
		}

		Long content_id = (Long)attributes.get("content_id");

		if (content_id != null) {
			setContent_id(content_id);
		}

		String kbfilename = (String)attributes.get("kbfilename");

		if (kbfilename != null) {
			setKbfilename(kbfilename);
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
	public String getKbfiledoc() {
		if (_kbfiledoc == null) {
			return StringPool.BLANK;
		}
		else {
			return _kbfiledoc;
		}
	}

	@Override
	public void setKbfiledoc(String kbfiledoc) {
		_kbfiledoc = kbfiledoc;
	}

	@JSON
	@Override
	public String getKbfilepath() {
		if (_kbfilepath == null) {
			return StringPool.BLANK;
		}
		else {
			return _kbfilepath;
		}
	}

	@Override
	public void setKbfilepath(String kbfilepath) {
		_kbfilepath = kbfilepath;
	}

	@JSON
	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_columnBitmask = -1L;

		_createdDate = createdDate;
	}

	@JSON
	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	@JSON
	@Override
	public String getFlag() {
		if (_flag == null) {
			return StringPool.BLANK;
		}
		else {
			return _flag;
		}
	}

	@Override
	public void setFlag(String flag) {
		_flag = flag;
	}

	@JSON
	@Override
	public long getKbdetails_id() {
		return _kbdetails_id;
	}

	@Override
	public void setKbdetails_id(long kbdetails_id) {
		_kbdetails_id = kbdetails_id;
	}

	@JSON
	@Override
	public long getContent_id() {
		return _content_id;
	}

	@Override
	public void setContent_id(long content_id) {
		_columnBitmask |= CONTENT_ID_COLUMN_BITMASK;

		if (!_setOriginalContent_id) {
			_setOriginalContent_id = true;

			_originalContent_id = _content_id;
		}

		_content_id = content_id;
	}

	public long getOriginalContent_id() {
		return _originalContent_id;
	}

	@JSON
	@Override
	public String getKbfilename() {
		if (_kbfilename == null) {
			return StringPool.BLANK;
		}
		else {
			return _kbfilename;
		}
	}

	@Override
	public void setKbfilename(String kbfilename) {
		_kbfilename = kbfilename;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			kbpath.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public kbpath toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (kbpath)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		kbpathImpl kbpathImpl = new kbpathImpl();

		kbpathImpl.setId(getId());
		kbpathImpl.setKbfiledoc(getKbfiledoc());
		kbpathImpl.setKbfilepath(getKbfilepath());
		kbpathImpl.setCreatedDate(getCreatedDate());
		kbpathImpl.setCreatedBy(getCreatedBy());
		kbpathImpl.setFlag(getFlag());
		kbpathImpl.setKbdetails_id(getKbdetails_id());
		kbpathImpl.setContent_id(getContent_id());
		kbpathImpl.setKbfilename(getKbfilename());

		kbpathImpl.resetOriginalValues();

		return kbpathImpl;
	}

	@Override
	public int compareTo(kbpath kbpath) {
		int value = 0;

		value = DateUtil.compareTo(getCreatedDate(), kbpath.getCreatedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof kbpath)) {
			return false;
		}

		kbpath kbpath = (kbpath)obj;

		long primaryKey = kbpath.getPrimaryKey();

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
		kbpathModelImpl kbpathModelImpl = this;

		kbpathModelImpl._originalContent_id = kbpathModelImpl._content_id;

		kbpathModelImpl._setOriginalContent_id = false;

		kbpathModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<kbpath> toCacheModel() {
		kbpathCacheModel kbpathCacheModel = new kbpathCacheModel();

		kbpathCacheModel.id = getId();

		kbpathCacheModel.kbfiledoc = getKbfiledoc();

		String kbfiledoc = kbpathCacheModel.kbfiledoc;

		if ((kbfiledoc != null) && (kbfiledoc.length() == 0)) {
			kbpathCacheModel.kbfiledoc = null;
		}

		kbpathCacheModel.kbfilepath = getKbfilepath();

		String kbfilepath = kbpathCacheModel.kbfilepath;

		if ((kbfilepath != null) && (kbfilepath.length() == 0)) {
			kbpathCacheModel.kbfilepath = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			kbpathCacheModel.createdDate = createdDate.getTime();
		}
		else {
			kbpathCacheModel.createdDate = Long.MIN_VALUE;
		}

		kbpathCacheModel.createdBy = getCreatedBy();

		kbpathCacheModel.flag = getFlag();

		String flag = kbpathCacheModel.flag;

		if ((flag != null) && (flag.length() == 0)) {
			kbpathCacheModel.flag = null;
		}

		kbpathCacheModel.kbdetails_id = getKbdetails_id();

		kbpathCacheModel.content_id = getContent_id();

		kbpathCacheModel.kbfilename = getKbfilename();

		String kbfilename = kbpathCacheModel.kbfilename;

		if ((kbfilename != null) && (kbfilename.length() == 0)) {
			kbpathCacheModel.kbfilename = null;
		}

		return kbpathCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", kbfiledoc=");
		sb.append(getKbfiledoc());
		sb.append(", kbfilepath=");
		sb.append(getKbfilepath());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", flag=");
		sb.append(getFlag());
		sb.append(", kbdetails_id=");
		sb.append(getKbdetails_id());
		sb.append(", content_id=");
		sb.append(getContent_id());
		sb.append(", kbfilename=");
		sb.append(getKbfilename());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.chola.knowledgebites.model.kbpath");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kbfiledoc</column-name><column-value><![CDATA[");
		sb.append(getKbfiledoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kbfilepath</column-name><column-value><![CDATA[");
		sb.append(getKbfilepath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flag</column-name><column-value><![CDATA[");
		sb.append(getFlag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kbdetails_id</column-name><column-value><![CDATA[");
		sb.append(getKbdetails_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content_id</column-name><column-value><![CDATA[");
		sb.append(getContent_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kbfilename</column-name><column-value><![CDATA[");
		sb.append(getKbfilename());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = kbpath.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			kbpath.class
		};
	private long _id;
	private String _kbfiledoc;
	private String _kbfilepath;
	private Date _createdDate;
	private long _createdBy;
	private String _flag;
	private long _kbdetails_id;
	private long _content_id;
	private long _originalContent_id;
	private boolean _setOriginalContent_id;
	private String _kbfilename;
	private long _columnBitmask;
	private kbpath _escapedModel;
}