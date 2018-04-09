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

package com.chola.calendar.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the eventcalendar service. Represents a row in the &quot;events_eventcalendar&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.calendar.model.impl.eventcalendarModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.calendar.model.impl.eventcalendarImpl}.
 * </p>
 *
 * @author adms.java1
 * @see eventcalendar
 * @see com.chola.calendar.model.impl.eventcalendarImpl
 * @see com.chola.calendar.model.impl.eventcalendarModelImpl
 * @generated
 */
@ProviderType
public interface eventcalendarModel extends BaseModel<eventcalendar> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a eventcalendar model instance should use the {@link eventcalendar} interface instead.
	 */

	/**
	 * Returns the primary key of this eventcalendar.
	 *
	 * @return the primary key of this eventcalendar
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this eventcalendar.
	 *
	 * @param primaryKey the primary key of this eventcalendar
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this eventcalendar.
	 *
	 * @return the ID of this eventcalendar
	 */
	public long getId();

	/**
	 * Sets the ID of this eventcalendar.
	 *
	 * @param id the ID of this eventcalendar
	 */
	public void setId(long id);

	/**
	 * Returns the name of this eventcalendar.
	 *
	 * @return the name of this eventcalendar
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this eventcalendar.
	 *
	 * @param name the name of this eventcalendar
	 */
	public void setName(String name);

	/**
	 * Returns the startdate of this eventcalendar.
	 *
	 * @return the startdate of this eventcalendar
	 */
	public Date getStartdate();

	/**
	 * Sets the startdate of this eventcalendar.
	 *
	 * @param startdate the startdate of this eventcalendar
	 */
	public void setStartdate(Date startdate);

	/**
	 * Returns the enddate of this eventcalendar.
	 *
	 * @return the enddate of this eventcalendar
	 */
	public Date getEnddate();

	/**
	 * Sets the enddate of this eventcalendar.
	 *
	 * @param enddate the enddate of this eventcalendar
	 */
	public void setEnddate(Date enddate);

	/**
	 * Returns the color of this eventcalendar.
	 *
	 * @return the color of this eventcalendar
	 */
	@AutoEscape
	public String getColor();

	/**
	 * Sets the color of this eventcalendar.
	 *
	 * @param color the color of this eventcalendar
	 */
	public void setColor(String color);

	/**
	 * Returns the url of this eventcalendar.
	 *
	 * @return the url of this eventcalendar
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this eventcalendar.
	 *
	 * @param url the url of this eventcalendar
	 */
	public void setUrl(String url);

	/**
	 * Returns the userid of this eventcalendar.
	 *
	 * @return the userid of this eventcalendar
	 */
	@AutoEscape
	public String getUserid();

	/**
	 * Sets the userid of this eventcalendar.
	 *
	 * @param userid the userid of this eventcalendar
	 */
	public void setUserid(String userid);

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
	public int compareTo(com.chola.calendar.model.eventcalendar eventcalendar);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.chola.calendar.model.eventcalendar> toCacheModel();

	@Override
	public com.chola.calendar.model.eventcalendar toEscapedModel();

	@Override
	public com.chola.calendar.model.eventcalendar toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}