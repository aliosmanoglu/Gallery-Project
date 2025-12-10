package com.alihaydar.service;

import com.alihaydar.dto.DtoAdress;
import com.alihaydar.dto.DtoAdressIU;

public interface IAdressService {

	public DtoAdress saveAdress(DtoAdressIU adress);
	
}
