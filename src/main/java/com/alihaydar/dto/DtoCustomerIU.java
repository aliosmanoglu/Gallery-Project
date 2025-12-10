package com.alihaydar.dto;

import java.util.Date;

import com.alihaydar.model.Account;
import com.alihaydar.model.Adress;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCustomerIU {

	private String firstName;
	
	private String lastName;	
	
	private String tckn;
	
	private Date birtOfDat;
	
	private Long adressId;
	
	private Long accountId;
	
}
