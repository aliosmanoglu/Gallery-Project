package com.alihaydar.service;

import com.alihaydar.dto.DtoCar;
import com.alihaydar.dto.DtoCarIU;

public interface ICarService {

	public DtoCar saveCar(DtoCarIU dtoCarIU);
	
}
