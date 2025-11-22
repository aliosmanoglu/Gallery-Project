package com.alihaydar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adress")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adress extends BaseEntity{

	@Column
	private String city;
	
	@Column
	private String district;
	
	@Column
	private String neighborhood;
	
	@Column
	private String street;
	
}
