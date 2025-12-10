package com.alihaydar.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alihaydar.controller.IAdressController;
import com.alihaydar.controller.RestEntityBase;
import com.alihaydar.controller.RootEntity;
import com.alihaydar.dto.DtoAdress;
import com.alihaydar.dto.DtoAdressIU;
import com.alihaydar.service.impl.AdressServiceImpl;


@RestController
@RequestMapping("/rest/api/adress")
public class AdressControllerImpl extends RestEntityBase implements IAdressController{

	@Autowired
	private AdressServiceImpl adressService;
	
	@Override
	@PostMapping("/save")
	public RootEntity<DtoAdress> saveAdress(@RequestBody DtoAdressIU adress) {
		return ok(adressService.saveAdress(adress));
	}

	
	
	
}
