package com.alihaydar.service.impl;


import java.net.http.HttpRequest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alihaydar.dto.CurrencyResponse;
import com.alihaydar.enums.MessageType;
import com.alihaydar.exception.BaseException;
import com.alihaydar.exception.ErrorMessage;
import com.alihaydar.service.ICurrencyService;


@Service
public class CurrencyServiceImpl implements ICurrencyService{

	@Override
	public CurrencyResponse getCurrency(String startDate, String endDate) {
		
		String currency = "TP.DK.USD.A";
		
		String endPoint = "https://evds2.tcmb.gov.tr/service/evds/series=" + currency + "&startDate=" + startDate + "&endDate=" + endDate + "&type=json"; 
			
		HttpHeaders headers = new HttpHeaders();
		headers.set("key", "s4MgGJIgOK");
		
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
	    ResponseEntity<CurrencyResponse> response = restTemplate.exchange(endPoint, HttpMethod.GET,httpEntity,new ParameterizedTypeReference<CurrencyResponse>() {
		});
	    
	    if(!response.getStatusCode().is2xxSuccessful()) {
	    	throw new BaseException(new ErrorMessage(MessageType.CURRENCY_ERROR_OCCURED,response.getStatusCode().toString()));
	    }
				
		return response.getBody();
	}

	
	
}
