package com.alihaydar.service;

import com.alihaydar.dto.DtoCustomer;
import com.alihaydar.dto.DtoCustomerIU;

public interface ICustomerService {

	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
	
	
}
