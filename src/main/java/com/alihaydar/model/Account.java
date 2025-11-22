package com.alihaydar.model;

import java.math.BigDecimal;

import com.alihaydar.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity{

	@Column(name = "account_no")
	private String accountNo;
	
	private String iban;
	
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "currency_type")
	private CurrencyType currencyType;
	
}
