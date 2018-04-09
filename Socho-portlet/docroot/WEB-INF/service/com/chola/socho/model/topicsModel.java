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

package com.chola.socho.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the topics service. Represents a row in the &quot;socho_topics&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.socho.model.impl.topicsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.socho.model.impl.topicsImpl}.
 * </p>
 *
 * @author CloverLiferay02
 * @see topics
 * @see com.chola.socho.model.impl.topicsImpl
 * @see com.chola.socho.model.impl.topicsModelImpl
 * @generated
 */
@ProviderType
public interface topicsModel extends BaseModel<topics> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a topics model instance should use the {@link topics} interface instead.
	 */

	/**
	 * Returns the primary key of this topics.
	 *
	 * @return the primary key of this topics
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this topics.
	 *
	 * @param primaryKey the primary key of this topics
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this topics.
	 *
	 * @return the ID of this topics
	 */
	public long getId();

	/**
	 * Sets the ID of this topics.
	 *
	 * @param id the ID of this topics
	 */
	public void setId(long id);

	/**
	 * Returns the topic name of this topics.
	 *
	 * @return the topic name of this topics
	 */
	@AutoEscape
	public String getTopicName();

	/**
	 * Sets the topic name of this topics.
	 *
	 * @param topicName the topic name of this topics
	 */
	public void setTopicName(String topicName);

	/**
	 * Returns the flag of this topics.
	 *
	 * @return the flag of this topics
	 */
	public long getFlag();

	/**
	 * Sets the flag of this topics.
	 *
	 * @param flag the flag of this topics
	 */
	public void setFlag(long flag);

	/**
	 * Returns the created by of this topics.
	 *
	 * @return the created by of this topics
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this topics.
	 *
	 * @param createdBy the created by of this topics
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the created on of this topics.
	 *
	 * @return the created on of this topics
	 */
	public Date getCreatedOn();

	/**
	 * Sets the created on of this topics.
	 *
	 * @param createdOn the created on of this topics
	 */
	public void setCreatedOn(Date createdOn);

	/**
	 * Returns the modified by of this topics.
	 *
	 * @return the modified by of this topics
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this topics.
	 *
	 * @param modifiedBy the modified by of this topics
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the modified on of this topics.
	 *
	 * @return the modified on of this topics
	 */
	public Date getModifiedOn();

	/**
	 * Sets the modified on of this topics.
	 *
	 * @param modifiedOn the modified on of this topics
	 */
	public void setModifiedOn(Date modifiedOn);

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
	public int compareTo(com.chola.socho.model.topics topics);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.chola.socho.model.topics> toCacheModel();

	@Override
	public com.chola.socho.model.topics toEscapedModel();

	@Override
	public com.chola.socho.model.topics toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}