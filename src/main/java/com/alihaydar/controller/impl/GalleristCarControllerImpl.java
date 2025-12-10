package com.alihaydar.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alihaydar.controller.IGalleristCarController;
import com.alihaydar.controller.RestEntityBase;
import com.alihaydar.controller.RootEntity;
import com.alihaydar.dto.DtoGalleristCar;
import com.alihaydar.dto.DtoGalleristCarIU;
import com.alihaydar.service.impl.GalleristCarServiceImpl;

@RestController
@RequestMapping("/rest/api/gallerist-car")
public class GalleristCarControllerImpl extends RestEntityBase implements IGalleristCarController{

	@Autowired
	private GalleristCarServiceImpl galleristCarServiceImpl;
	
	@Override
	@PostMapping("/save")
	public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
		return ok(galleristCarServiceImpl.saveGalleristCar(dtoGalleristCarIU));
	}

}
