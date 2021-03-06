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

package com.chola.anniversary.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author CloverLiferay02
 * @generated
 */
@ProviderType
public class anniversarywishFinderUtil {
	public static boolean insertData(java.lang.String message,
		java.lang.String postedBy, java.lang.String postedOn) {
		return getFinder().insertData(message, postedBy, postedOn);
	}

	public static java.util.List getEmpData(java.lang.String date) {
		return getFinder().getEmpData(date);
	}

	public static anniversarywishFinder getFinder() {
		if (_finder == null) {
			_finder = (anniversarywishFinder)PortletBeanLocatorUtil.locate(com.chola.anniversary.service.ClpSerializer.getServletContextName(),
					anniversarywishFinder.class.getName());

			ReferenceRegistry.registerReference(anniversarywishFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(anniversarywishFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(anniversarywishFinderUtil.class,
			"_finder");
	}

	private static anniversarywishFinder _finder;
}