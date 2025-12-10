package com.alihaydar.controller;

import com.alihaydar.dto.DtoGalleristCar;
import com.alihaydar.dto.DtoGalleristCarIU;

public interface IGalleristCarController {

	
	public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
