package com.alihaydar.controller.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alihaydar.controller.ISaledCarController;
import com.alihaydar.controller.RestEntityBase;
import com.alihaydar.controller.RootEntity;
import com.alihaydar.dto.DtoSaledCar;
import com.alihaydar.dto.DtoSaledCarIU;
import com.alihaydar.service.ISaledCarService;


@RestController
@RequestMapping("/rest/api/saled-car")
public class SaledCarControllerImpl extends RestEntityBase implements ISaledCarController{

	@Autowired
	private ISaledCarService saledCarService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoSaledCar> buyCar(@RequestBody DtoSaledCarIU dtoSaledCarIU) {
		return ok(saledCarService.buyCar(dtoSaledCarIU));
	}

}
