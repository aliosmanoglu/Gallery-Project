package com.alihaydar.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alihaydar.dto.DtoCar;
import com.alihaydar.dto.DtoGallerist;
import com.alihaydar.dto.DtoGalleristCar;
import com.alihaydar.dto.DtoGalleristCarIU;
import com.alihaydar.enums.MessageType;
import com.alihaydar.exception.BaseException;
import com.alihaydar.exception.ErrorMessage;
import com.alihaydar.model.Car;
import com.alihaydar.model.Gallerist;
import com.alihaydar.model.GalleristCar;
import com.alihaydar.repository.CarRepository;
import com.alihaydar.repository.GalleristCarRepository;
import com.alihaydar.repository.GalleristRepository;
import com.alihaydar.service.IGalleristCarService;

public class GalleristCarServiceImpl implements IGalleristCarService{

	@Autowired
	private GalleristCarRepository galleristCarRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private GalleristRepository galleristRepository;
	
	public GalleristCar createGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
		Optional<Gallerist> optGalerist = galleristRepository.findById(dtoGalleristCarIU.getGalleristId());
		
		if(optGalerist.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXCIST,dtoGalleristCarIU.getGalleristId().toString()));
		}
		
		
		Optional<Car> optCar = carRepository.findById(dtoGalleristCarIU.getCarId());
		if(optCar.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXCIST,dtoGalleristCarIU.getCarId().toString()));
		}
		
		GalleristCar galleristCar = new GalleristCar();
		
		galleristCar.setCar(optCar.get());
		galleristCar.setCreatedDate(new Date());
		galleristCar.setGallerist(optGalerist.get());
		
		return galleristCar;
	}
	
	@Override
	public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
		DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
		
		GalleristCar savedGalleristCar = galleristCarRepository.save(createGalleristCar(dtoGalleristCarIU));
		
		DtoGallerist dtoGallerist = new DtoGallerist();
		BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
		
		DtoCar dtoCar = new DtoCar();
		BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);
		
		dtoGalleristCar.setCar(dtoCar);
		dtoGalleristCar.setGallerist(dtoGallerist);
		
		return dtoGalleristCar;
	}

	
	
}
