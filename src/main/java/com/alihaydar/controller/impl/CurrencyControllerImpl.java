package com.alihaydar.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alihaydar.controller.ICurrencyController;
import com.alihaydar.controller.RestEntityBase;
import com.alihaydar.controller.RootEntity;
import com.alihaydar.dto.CurrencyRequest;
import com.alihaydar.dto.CurrencyResponse;
import com.alihaydar.service.impl.CurrencyServiceImpl;

@RestController
@RequestMapping("/rest/api/service")
public class CurrencyControllerImpl extends RestEntityBase implements ICurrencyController{

	@Autowired
	private CurrencyServiceImpl currencyServiceImpl;
	
	@Override
	@GetMapping("/get-currency")
	public RootEntity<CurrencyResponse> getCurrency(@RequestBody CurrencyRequest currencyRequest) {
		return ok(currencyServiceImpl.getCurrency(currencyRequest.getStartDate(), currencyRequest.getEndDate()));
	}

}
