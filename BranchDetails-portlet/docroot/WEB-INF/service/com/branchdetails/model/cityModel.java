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

package com.branchdetails.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the city service. Represents a row in the &quot;branch_city&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.branchdetails.model.impl.cityModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.branchdetails.model.impl.cityImpl}.
 * </p>
 *
 * @author adms.java1
 * @see city
 * @see com.branchdetails.model.impl.cityImpl
 * @see com.branchdetails.model.impl.cityModelImpl
 * @generated
 */
@ProviderType
public interface cityModel extends BaseModel<city> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a city model instance should use the {@link city} interface instead.
	 */

	/**
	 * Returns the primary key of this city.
	 *
	 * @return the primary key of this city
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this city.
	 *
	 * @param primaryKey the primary key of this city
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the city_id of this city.
	 *
	 * @return the city_id of this city
	 */
	public long getCity_id();

	/**
	 * Sets the city_id of this city.
	 *
	 * @param city_id the city_id of this city
	 */
	public void setCity_id(long city_id);

	/**
	 * Returns the city_name of this city.
	 *
	 * @return the city_name of this city
	 */
	@AutoEscape
	public String getCity_name();

	/**
	 * Sets the city_name of this city.
	 *
	 * @param city_name the city_name of this city
	 */
	public void setCity_name(String city_name);

	/**
	 * Returns the state_id of this city.
	 *
	 * @return the state_id of this city
	 */
	public long getState_id();

	/**
	 * Sets the state_id of this city.
	 *
	 * @param state_id the state_id of this city
	 */
	public void setState_id(long state_id);

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
	public int compareTo(com.branchdetails.model.city city);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.branchdetails.model.city> toCacheModel();

	@Override
	public com.branchdetails.model.city toEscapedModel();

	@Override
	public com.branchdetails.model.city toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}