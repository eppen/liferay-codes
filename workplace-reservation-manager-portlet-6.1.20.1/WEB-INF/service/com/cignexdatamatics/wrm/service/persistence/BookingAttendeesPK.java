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

package com.cignexdatamatics.wrm.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class BookingAttendeesPK implements Comparable<BookingAttendeesPK>,
	Serializable {
	public long attendeesId;
	public long bookingId;

	public BookingAttendeesPK() {
	}

	public BookingAttendeesPK(long attendeesId, long bookingId) {
		this.attendeesId = attendeesId;
		this.bookingId = bookingId;
	}

	public long getAttendeesId() {
		return attendeesId;
	}

	public void setAttendeesId(long attendeesId) {
		this.attendeesId = attendeesId;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public int compareTo(BookingAttendeesPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (attendeesId < pk.attendeesId) {
			value = -1;
		}
		else if (attendeesId > pk.attendeesId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (bookingId < pk.bookingId) {
			value = -1;
		}
		else if (bookingId > pk.bookingId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BookingAttendeesPK pk = null;

		try {
			pk = (BookingAttendeesPK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((attendeesId == pk.attendeesId) && (bookingId == pk.bookingId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(attendeesId) + String.valueOf(bookingId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("attendeesId");
		sb.append(StringPool.EQUAL);
		sb.append(attendeesId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("bookingId");
		sb.append(StringPool.EQUAL);
		sb.append(bookingId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}