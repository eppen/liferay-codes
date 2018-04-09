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

package com.cignexdatamatics.wrm.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link NewBookingService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       NewBookingService
 * @generated
 */
public class NewBookingServiceWrapper implements NewBookingService,
	ServiceWrapper<NewBookingService> {
	public NewBookingServiceWrapper(NewBookingService newBookingService) {
		_newBookingService = newBookingService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _newBookingService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_newBookingService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _newBookingService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public NewBookingService getWrappedNewBookingService() {
		return _newBookingService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedNewBookingService(NewBookingService newBookingService) {
		_newBookingService = newBookingService;
	}

	public NewBookingService getWrappedService() {
		return _newBookingService;
	}

	public void setWrappedService(NewBookingService newBookingService) {
		_newBookingService = newBookingService;
	}

	private NewBookingService _newBookingService;
}