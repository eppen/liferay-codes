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

package com.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the mapping service. Represents a row in the &quot;Branch_mapping&quot; database table, with each column mapped to a property of this class.
 *
 * @author adms.java1
 * @see mappingModel
 * @see com.model.impl.mappingImpl
 * @see com.model.impl.mappingModelImpl
 * @generated
 */
@ImplementationClassName("com.model.impl.mappingImpl")
@ProviderType
public interface mapping extends mappingModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.model.impl.mappingImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<mapping, Long> MAPPING_ID_ACCESSOR = new Accessor<mapping, Long>() {
			@Override
			public Long get(mapping mapping) {
				return mapping.getMapping_id();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<mapping> getTypeClass() {
				return mapping.class;
			}
		};
}