package com.alihaydar.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alihaydar.dto.DtoAdress;
import com.alihaydar.dto.DtoAdressIU;
import com.alihaydar.model.Adress;
import com.alihaydar.repository.AdressRepository;
import com.alihaydar.service.IAdressService;

@Service
public class AdressServiceImpl implements IAdressService{

	@Autowired
	AdressRepository adressRepository;
	
	public Adress createUser(DtoAdressIU dtoAdressIU) {
		Adress adress = new Adress();
		
		adress.setCreatedDate(new Date());
		
		BeanUtils.copyProperties(dtoAdressIU, adress);
		
		return adress;
	}
	
	
	@Override
	public DtoAdress saveAdress(DtoAdressIU dtoAdressIU) {
		DtoAdress dtoAdress = new DtoAdress();
		
		Adress savedAdress = adressRepository.save(createUser(dtoAdressIU));
		
		BeanUtils.copyProperties(savedAdress, dtoAdress);
		
		return dtoAdress;
	}

}
