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

package com.chola.birthday.service.messaging;

import aQute.bnd.annotation.ProviderType;

import com.chola.birthday.service.ClpSerializer;
import com.chola.birthday.service.birthdaywishLocalServiceUtil;
import com.chola.birthday.service.birthdaywishServiceUtil;
import com.chola.birthday.service.predefinedmessagesLocalServiceUtil;
import com.chola.birthday.service.predefinedmessagesServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author CloverLiferay02
 */
@ProviderType
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			birthdaywishLocalServiceUtil.clearService();

			birthdaywishServiceUtil.clearService();
			predefinedmessagesLocalServiceUtil.clearService();

			predefinedmessagesServiceUtil.clearService();
		}
	}
}