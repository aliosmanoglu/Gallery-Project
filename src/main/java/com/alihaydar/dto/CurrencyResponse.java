package com.alihaydar.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyResponse {

	@JsonProperty("totalCount")
	private String totalCount;
	
	@JsonProperty("items")
	private List<CurrencyItems> items;
	
}
