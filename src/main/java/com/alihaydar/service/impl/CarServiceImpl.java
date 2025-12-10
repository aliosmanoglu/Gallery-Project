package com.alihaydar.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alihaydar.dto.DtoCar;
import com.alihaydar.dto.DtoCarIU;
import com.alihaydar.model.Car;
import com.alihaydar.repository.CarRepository;
import com.alihaydar.service.ICarService;

public class CarServiceImpl implements ICarService{

	@Autowired
	private CarRepository carRepository;
	
	public Car createCar(DtoCarIU dtoCarIU) {
		Car car = new Car();
		
		BeanUtils.copyProperties(dtoCarIU, car);
		return car;
	}
	
	
	@Override
	public DtoCar saveCar(DtoCarIU dtoCarIU) {
		DtoCar dtoCar = new DtoCar();
		
		Car savedCar = carRepository.save(createCar(dtoCarIU));
		
		BeanUtils.copyProperties(savedCar, dtoCar);
		
		return dtoCar;
	}

}
