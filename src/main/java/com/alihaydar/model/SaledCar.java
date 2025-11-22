package com.alihaydar.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "saled_car",
uniqueConstraints = {
    @UniqueConstraint(columnNames = {"gallerist_id", "car_id", "customer_id"})
}
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaledCar extends BaseEntity{

	@ManyToOne
	private Gallerist gallerist;
	
	@ManyToOne
	private Car car;
	
	@ManyToOne
	private Customer customer;
	
}
