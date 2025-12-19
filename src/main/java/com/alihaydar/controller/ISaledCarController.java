package com.alihaydar.controller;

import org.springframework.web.bind.annotation.RequestBody;

import com.alihaydar.dto.DtoSaledCar;
import com.alihaydar.dto.DtoSaledCarIU;

public interface ISaledCarController {

	
	public RootEntity<DtoSaledCar> buyCar(@RequestBody DtoSaledCarIU dtoSaledCarIU);
	
}
