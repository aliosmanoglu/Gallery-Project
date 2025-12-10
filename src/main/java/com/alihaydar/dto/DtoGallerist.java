package com.alihaydar.dto;

import com.alihaydar.model.Adress;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DtoGallerist extends DtoBase {

	private String firstName;
	
	private String lastName;
	
	private DtoAdress adress;
	
	
}
