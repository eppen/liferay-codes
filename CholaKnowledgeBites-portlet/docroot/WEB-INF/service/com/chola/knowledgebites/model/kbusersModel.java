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

package com.chola.knowledgebites.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the kbusers service. Represents a row in the &quot;chola_kbusers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.knowledgebites.model.impl.kbusersModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.knowledgebites.model.impl.kbusersImpl}.
 * </p>
 *
 * @author cloverliferay01
 * @see kbusers
 * @see com.chola.knowledgebites.model.impl.kbusersImpl
 * @see com.chola.knowledgebites.model.impl.kbusersModelImpl
 * @generated
 */
@ProviderType
public interface kbusersModel extends BaseModel<kbusers> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a kbusers model instance should use the {@link kbusers} interface instead.
	 */

	/**
	 * Returns the primary key of this kbusers.
	 *
	 * @return the primary key of this kbusers
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kbusers.
	 *
	 * @param primaryKey the primary key of this kbusers
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this kbusers.
	 *
	 * @return the ID of this kbusers
	 */
	public long getId();

	/**
	 * Sets the ID of this kbusers.
	 *
	 * @param id the ID of this kbusers
	 */
	public void setId(long id);

	/**
	 * Returns the user_id of this kbusers.
	 *
	 * @return the user_id of this kbusers
	 */
	public long getUser_id();

	/**
	 * Sets the user_id of this kbusers.
	 *
	 * @param user_id the user_id of this kbusers
	 */
	public void setUser_id(long user_id);

	/**
	 * Returns the kbdetails_id of this kbusers.
	 *
	 * @return the kbdetails_id of this kbusers
	 */
	public long getKbdetails_id();

	/**
	 * Sets the kbdetails_id of this kbusers.
	 *
	 * @param kbdetails_id the kbdetails_id of this kbusers
	 */
	public void setKbdetails_id(long kbdetails_id);

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
	public int compareTo(com.chola.knowledgebites.model.kbusers kbusers);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.chola.knowledgebites.model.kbusers> toCacheModel();

	@Override
	public com.chola.knowledgebites.model.kbusers toEscapedModel();

	@Override
	public com.chola.knowledgebites.model.kbusers toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}