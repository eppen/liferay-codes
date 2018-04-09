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

package com.cignexdatamatics.wrm.service.messaging;

import com.cignexdatamatics.wrm.service.BookingAttendeesLocalServiceUtil;
import com.cignexdatamatics.wrm.service.BookingFacilityMappingLocalServiceUtil;
import com.cignexdatamatics.wrm.service.BookingRoomsLocalServiceUtil;
import com.cignexdatamatics.wrm.service.CityMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.ClpSerializer;
import com.cignexdatamatics.wrm.service.FacilityMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.FloorMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.LocationMasterLocalServiceUtil;
import com.cignexdatamatics.wrm.service.NewBookingLocalServiceUtil;
import com.cignexdatamatics.wrm.service.NewBookingServiceUtil;
import com.cignexdatamatics.wrm.service.RoomFacilityMappingLocalServiceUtil;
import com.cignexdatamatics.wrm.service.RoomMasterLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Brian Wing Shun Chan
 */
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
			BookingAttendeesLocalServiceUtil.clearService();

			BookingFacilityMappingLocalServiceUtil.clearService();

			BookingRoomsLocalServiceUtil.clearService();

			CityMasterLocalServiceUtil.clearService();

			FacilityMasterLocalServiceUtil.clearService();

			FloorMasterLocalServiceUtil.clearService();

			LocationMasterLocalServiceUtil.clearService();

			NewBookingLocalServiceUtil.clearService();

			NewBookingServiceUtil.clearService();
			RoomFacilityMappingLocalServiceUtil.clearService();

			RoomMasterLocalServiceUtil.clearService();
		}
	}
}