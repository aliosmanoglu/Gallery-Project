package com.alihaydar.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alihaydar.enums.CarStatusType;
import com.alihaydar.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity{

	private String plate;
	
	private String brand;
	
	private String model;
	
	@Column(name = "production_year")
	private Integer productionYear;
	
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;
	
	
	@Column(name = "damage_price")
	private BigDecimal damagePrice;
	
	@Column(name = "car_status")
	@Enumerated(EnumType.STRING)
	private CarStatusType carStatusType;
	
}
