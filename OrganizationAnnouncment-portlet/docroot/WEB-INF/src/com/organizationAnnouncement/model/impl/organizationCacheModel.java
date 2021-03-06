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

package com.organizationAnnouncement.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.organizationAnnouncement.model.organization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing organization in entity cache.
 *
 * @author adms.java1
 * @see organization
 * @generated
 */
@ProviderType
public class organizationCacheModel implements CacheModel<organization>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof organizationCacheModel)) {
			return false;
		}

		organizationCacheModel organizationCacheModel = (organizationCacheModel)obj;

		if (organization_id == organizationCacheModel.organization_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, organization_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{organization_id=");
		sb.append(organization_id);
		sb.append(", organization_tite=");
		sb.append(organization_tite);
		sb.append(", organization_description=");
		sb.append(organization_description);
		sb.append(", organization_image_name=");
		sb.append(organization_image_name);
		sb.append(", organization_image_path=");
		sb.append(organization_image_path);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public organization toEntityModel() {
		organizationImpl organizationImpl = new organizationImpl();

		organizationImpl.setOrganization_id(organization_id);

		if (organization_tite == null) {
			organizationImpl.setOrganization_tite(StringPool.BLANK);
		}
		else {
			organizationImpl.setOrganization_tite(organization_tite);
		}

		if (organization_description == null) {
			organizationImpl.setOrganization_description(StringPool.BLANK);
		}
		else {
			organizationImpl.setOrganization_description(organization_description);
		}

		if (organization_image_name == null) {
			organizationImpl.setOrganization_image_name(StringPool.BLANK);
		}
		else {
			organizationImpl.setOrganization_image_name(organization_image_name);
		}

		if (organization_image_path == null) {
			organizationImpl.setOrganization_image_path(StringPool.BLANK);
		}
		else {
			organizationImpl.setOrganization_image_path(organization_image_path);
		}

		if (createDate == Long.MIN_VALUE) {
			organizationImpl.setCreateDate(null);
		}
		else {
			organizationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			organizationImpl.setModifiedDate(null);
		}
		else {
			organizationImpl.setModifiedDate(new Date(modifiedDate));
		}

		organizationImpl.resetOriginalValues();

		return organizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		organization_id = objectInput.readLong();
		organization_tite = objectInput.readUTF();
		organization_description = objectInput.readUTF();
		organization_image_name = objectInput.readUTF();
		organization_image_path = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(organization_id);

		if (organization_tite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(organization_tite);
		}

		if (organization_description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(organization_description);
		}

		if (organization_image_name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(organization_image_name);
		}

		if (organization_image_path == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(organization_image_path);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long organization_id;
	public String organization_tite;
	public String organization_description;
	public String organization_image_name;
	public String organization_image_path;
	public long createDate;
	public long modifiedDate;
}