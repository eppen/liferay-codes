/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.cignexdatamatics.wrm.model;

import com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the RoomFacilityMapping service. Represents a row in the &quot;wrm_RoomFacilityMapping&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.cignexdatamatics.wrm.model.impl.RoomFacilityMappingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.cignexdatamatics.wrm.model.impl.RoomFacilityMappingImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomFacilityMapping
 * @see com.cignexdatamatics.wrm.model.impl.RoomFacilityMappingImpl
 * @see com.cignexdatamatics.wrm.model.impl.RoomFacilityMappingModelImpl
 * @generated
 */
public interface RoomFacilityMappingModel extends BaseModel<RoomFacilityMapping> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a room facility mapping model instance should use the {@link RoomFacilityMapping} interface instead.
	 */

	/**
	 * Returns the primary key of this room facility mapping.
	 *
	 * @return the primary key of this room facility mapping
	 */
	public RoomFacilityMappingPK getPrimaryKey();

	/**
	 * Sets the primary key of this room facility mapping.
	 *
	 * @param primaryKey the primary key of this room facility mapping
	 */
	public void setPrimaryKey(RoomFacilityMappingPK primaryKey);

	/**
	 * Returns the room ID of this room facility mapping.
	 *
	 * @return the room ID of this room facility mapping
	 */
	public long getRoomId();

	/**
	 * Sets the room ID of this room facility mapping.
	 *
	 * @param roomId the room ID of this room facility mapping
	 */
	public void setRoomId(long roomId);

	/**
	 * Returns the facilities ID of this room facility mapping.
	 *
	 * @return the facilities ID of this room facility mapping
	 */
	public long getFacilitiesId();

	/**
	 * Sets the facilities ID of this room facility mapping.
	 *
	 * @param facilitiesId the facilities ID of this room facility mapping
	 */
	public void setFacilitiesId(long facilitiesId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(RoomFacilityMapping roomFacilityMapping);

	public int hashCode();

	public CacheModel<RoomFacilityMapping> toCacheModel();

	public RoomFacilityMapping toEscapedModel();

	public String toString();

	public String toXmlString();
}