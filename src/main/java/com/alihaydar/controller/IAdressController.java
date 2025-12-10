package com.alihaydar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alihaydar.dto.DtoAdress;
import com.alihaydar.dto.DtoAdressIU;


public interface IAdressController {

	public RootEntity<DtoAdress> saveAdress(DtoAdressIU adress);
	
}
