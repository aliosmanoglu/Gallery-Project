package com.alihaydar.service;

import com.alihaydar.dto.CurrencyResponse;

public interface ICurrencyService {

	public CurrencyResponse getCurrency(String startDate,String endDate);
	
}
