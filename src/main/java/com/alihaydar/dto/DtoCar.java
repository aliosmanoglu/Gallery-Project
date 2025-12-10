package com.alihaydar.dto;

import java.math.BigDecimal;

import com.alihaydar.enums.CurrencyType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCar extends DtoBase{
	private String plate;
	
	private String brand;
	
	private String model;
	
	private Integer productionYear;
	
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;
	
	
	private BigDecimal damagePrice;
	
	private Boolean carStatusType;
}
