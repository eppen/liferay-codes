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

package com.chola.feedforward.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the feedforwardgalleryusers service. Represents a row in the &quot;chola_feedforwardgalleryusers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.feedforward.model.impl.feedforwardgalleryusersModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.feedforward.model.impl.feedforwardgalleryusersImpl}.
 * </p>
 *
 * @author CloverLiferay02
 * @see feedforwardgalleryusers
 * @see com.chola.feedforward.model.impl.feedforwardgalleryusersImpl
 * @see com.chola.feedforward.model.impl.feedforwardgalleryusersModelImpl
 * @generated
 */
@ProviderType
public interface feedforwardgalleryusersModel extends BaseModel<feedforwardgalleryusers> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a feedforwardgalleryusers model instance should use the {@link feedforwardgalleryusers} interface instead.
	 */

	/**
	 * Returns the primary key of this feedforwardgalleryusers.
	 *
	 * @return the primary key of this feedforwardgalleryusers
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this feedforwardgalleryusers.
	 *
	 * @param primaryKey the primary key of this feedforwardgalleryusers
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this feedforwardgalleryusers.
	 *
	 * @return the ID of this feedforwardgalleryusers
	 */
	public long getId();

	/**
	 * Sets the ID of this feedforwardgalleryusers.
	 *
	 * @param id the ID of this feedforwardgalleryusers
	 */
	public void setId(long id);

	/**
	 * Returns the user_id of this feedforwardgalleryusers.
	 *
	 * @return the user_id of this feedforwardgalleryusers
	 */
	public long getUser_id();

	/**
	 * Sets the user_id of this feedforwardgalleryusers.
	 *
	 * @param user_id the user_id of this feedforwardgalleryusers
	 */
	public void setUser_id(long user_id);

	/**
	 * Returns the album_id of this feedforwardgalleryusers.
	 *
	 * @return the album_id of this feedforwardgalleryusers
	 */
	public long getAlbum_id();

	/**
	 * Sets the album_id of this feedforwardgalleryusers.
	 *
	 * @param album_id the album_id of this feedforwardgalleryusers
	 */
	public void setAlbum_id(long album_id);

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
	public int compareTo(
		com.chola.feedforward.model.feedforwardgalleryusers feedforwardgalleryusers);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.chola.feedforward.model.feedforwardgalleryusers> toCacheModel();

	@Override
	public com.chola.feedforward.model.feedforwardgalleryusers toEscapedModel();

	@Override
	public com.chola.feedforward.model.feedforwardgalleryusers toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}