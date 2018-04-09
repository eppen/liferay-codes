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

package com.branchdetails.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.List;

import com.branchdetails.service.base.productLocalServiceBaseImpl;

/**
 * The implementation of the product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.branchdetails.service.productLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author adms.java1
 * @see productLocalServiceBaseImpl
 * @see com.branchdetails.service.productLocalServiceUtil
 */
@ProviderType
public class productLocalServiceImpl extends productLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *  
	 * Never reference this class directly. Always use {@link com.branchdetails.service.productLocalServiceUtil} to access the product local service.
	 */
	
	public List<String> getProducts()
	{
		return productFinder.getProducts();
	}
	
	public List<String> getState(long product_id)
	{
		return productFinder.getState(product_id);
	}
	
	public List<String> getCity(long product_id,long state_id)
	{
		return productFinder.getCity(product_id,state_id);
	}
	
	public List<String> getBranch(long product_id,long state_id,long city_id)
	{
		return productFinder.getBranch(product_id,state_id,city_id);
	}
}