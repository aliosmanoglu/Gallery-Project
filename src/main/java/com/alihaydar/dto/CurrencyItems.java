package com.alihaydar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyItems {

	@JsonProperty("Tarih")
	private String date;
	
	@JsonProperty("TP_DK_USD_A")
	private String usd;
	
}
