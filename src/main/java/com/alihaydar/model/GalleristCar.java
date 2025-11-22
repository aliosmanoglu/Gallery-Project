package com.alihaydar.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gallerist_car",
uniqueConstraints = {@UniqueConstraint(columnNames = {"gallerist_id","car_id"}, name = "uq_gallerist_car")})
public class GalleristCar extends BaseEntity{
	
	@ManyToOne
	private Gallerist gallerist;
	
	@ManyToOne
	private Car car;
	
}
