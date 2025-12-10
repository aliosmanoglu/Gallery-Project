package com.alihaydar.dto;

import java.util.Date;

import com.alihaydar.model.Account;
import com.alihaydar.model.Adress;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DtoCustomer extends DtoBase{

	private String firstName;
	
	private String lastName;	
	
	private String tckn;
	
	private Date birtOfDat;
	
	private DtoAdress adress;
	
	private DtoAccount account;
	
}
