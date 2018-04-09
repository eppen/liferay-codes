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

package com.cignexdatamatics.wrm.model.impl;

import com.cignexdatamatics.wrm.model.NewBooking;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing NewBooking in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see NewBooking
 * @generated
 */
public class NewBookingCacheModel implements CacheModel<NewBooking>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{bookingId=");
		sb.append(bookingId);
		sb.append(", meetingTitle=");
		sb.append(meetingTitle);
		sb.append(", meetingDesc=");
		sb.append(meetingDesc);
		sb.append(", hostId=");
		sb.append(hostId);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append("}");

		return sb.toString();
	}

	public NewBooking toEntityModel() {
		NewBookingImpl newBookingImpl = new NewBookingImpl();

		newBookingImpl.setBookingId(bookingId);

		if (meetingTitle == null) {
			newBookingImpl.setMeetingTitle(StringPool.BLANK);
		}
		else {
			newBookingImpl.setMeetingTitle(meetingTitle);
		}

		if (meetingDesc == null) {
			newBookingImpl.setMeetingDesc(StringPool.BLANK);
		}
		else {
			newBookingImpl.setMeetingDesc(meetingDesc);
		}

		newBookingImpl.setHostId(hostId);

		if (fromDate == Long.MIN_VALUE) {
			newBookingImpl.setFromDate(null);
		}
		else {
			newBookingImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			newBookingImpl.setToDate(null);
		}
		else {
			newBookingImpl.setToDate(new Date(toDate));
		}

		if (startTime == null) {
			newBookingImpl.setStartTime(StringPool.BLANK);
		}
		else {
			newBookingImpl.setStartTime(startTime);
		}

		if (endTime == null) {
			newBookingImpl.setEndTime(StringPool.BLANK);
		}
		else {
			newBookingImpl.setEndTime(endTime);
		}

		newBookingImpl.resetOriginalValues();

		return newBookingImpl;
	}

	public long bookingId;
	public String meetingTitle;
	public String meetingDesc;
	public long hostId;
	public long fromDate;
	public long toDate;
	public String startTime;
	public String endTime;
}