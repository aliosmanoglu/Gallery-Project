package com.alihaydar.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alihaydar.controller.ICustomerController;
import com.alihaydar.controller.RestEntityBase;
import com.alihaydar.controller.RootEntity;
import com.alihaydar.dto.DtoCustomer;
import com.alihaydar.dto.DtoCustomerIU;
import com.alihaydar.model.Customer;
import com.alihaydar.service.impl.CustomerServiceImpl;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl extends RestEntityBase implements ICustomerController{

	@Autowired
	private CustomerServiceImpl customerService;
	
	@Override
	@PostMapping("/save")
	public RootEntity<DtoCustomer> saveCustomer(@RequestBody DtoCustomerIU dtoCustomerIU) {
		return ok(customerService.saveCustomer(dtoCustomerIU));
	}

	
}
