package com.alihaydar.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity{

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	
	private String tckn;
	
	private Date birtOfDat;
	
	@OneToOne
	private Adress adress;
	
	@OneToOne
	private Account account;
	
}
