package com.alihaydar.controller;


import com.alihaydar.dto.CurrencyRequest;
import com.alihaydar.dto.CurrencyResponse;

public interface ICurrencyController {

	public RootEntity<CurrencyResponse> getCurrency(CurrencyRequest currencyRequest);
	
}
