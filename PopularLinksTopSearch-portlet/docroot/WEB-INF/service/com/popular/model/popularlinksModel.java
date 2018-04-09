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

package com.popular.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the popularlinks service. Represents a row in the &quot;chola_popularlinks&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.popular.model.impl.popularlinksModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.popular.model.impl.popularlinksImpl}.
 * </p>
 *
 * @author CloverLiferay02
 * @see popularlinks
 * @see com.popular.model.impl.popularlinksImpl
 * @see com.popular.model.impl.popularlinksModelImpl
 * @generated
 */
@ProviderType
public interface popularlinksModel extends BaseModel<popularlinks> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a popularlinks model instance should use the {@link popularlinks} interface instead.
	 */

	/**
	 * Returns the primary key of this popularlinks.
	 *
	 * @return the primary key of this popularlinks
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this popularlinks.
	 *
	 * @param primaryKey the primary key of this popularlinks
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this popularlinks.
	 *
	 * @return the ID of this popularlinks
	 */
	public long getId();

	/**
	 * Sets the ID of this popularlinks.
	 *
	 * @param id the ID of this popularlinks
	 */
	public void setId(long id);

	/**
	 * Returns the userid of this popularlinks.
	 *
	 * @return the userid of this popularlinks
	 */
	public long getUserid();

	/**
	 * Sets the userid of this popularlinks.
	 *
	 * @param userid the userid of this popularlinks
	 */
	public void setUserid(long userid);

	/**
	 * Returns the url of this popularlinks.
	 *
	 * @return the url of this popularlinks
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this popularlinks.
	 *
	 * @param url the url of this popularlinks
	 */
	public void setUrl(String url);

	/**
	 * Returns the tag of this popularlinks.
	 *
	 * @return the tag of this popularlinks
	 */
	@AutoEscape
	public String getTag();

	/**
	 * Sets the tag of this popularlinks.
	 *
	 * @param tag the tag of this popularlinks
	 */
	public void setTag(String tag);

	/**
	 * Returns the count of this popularlinks.
	 *
	 * @return the count of this popularlinks
	 */
	public long getCount();

	/**
	 * Sets the count of this popularlinks.
	 *
	 * @param count the count of this popularlinks
	 */
	public void setCount(long count);

	/**
	 * Returns the flag of this popularlinks.
	 *
	 * @return the flag of this popularlinks
	 */
	public int getFlag();

	/**
	 * Sets the flag of this popularlinks.
	 *
	 * @param flag the flag of this popularlinks
	 */
	public void setFlag(int flag);

	/**
	 * Returns the create date of this popularlinks.
	 *
	 * @return the create date of this popularlinks
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this popularlinks.
	 *
	 * @param createDate the create date of this popularlinks
	 */
	public void setCreateDate(Date createDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.popular.model.popularlinks popularlinks);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.popular.model.popularlinks> toCacheModel();

	@Override
	public com.popular.model.popularlinks toEscapedModel();

	@Override
	public com.popular.model.popularlinks toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}