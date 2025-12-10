package com.alihaydar.controller;

import com.alihaydar.dto.DtoCustomer;
import com.alihaydar.dto.DtoCustomerIU;
import com.alihaydar.model.Customer;

public interface ICustomerController {

	public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
	
}
