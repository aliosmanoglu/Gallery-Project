package com.alihaydar.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alihaydar.dto.DtoAdress;
import com.alihaydar.dto.DtoCustomerIU;
import com.alihaydar.dto.DtoGallerist;
import com.alihaydar.dto.DtoGalleristIU;
import com.alihaydar.enums.MessageType;
import com.alihaydar.exception.BaseException;
import com.alihaydar.exception.ErrorMessage;
import com.alihaydar.model.Account;
import com.alihaydar.model.Adress;
import com.alihaydar.model.Customer;
import com.alihaydar.model.Gallerist;
import com.alihaydar.repository.AdressRepository;
import com.alihaydar.repository.GalleristRepository;
import com.alihaydar.service.IGalleristService;


@Service
public class GalleristServiceImpl implements IGalleristService {

	
	@Autowired
	private AdressRepository adressRepository;
	
	@Autowired
	private GalleristRepository galleristRepository;
	
	private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {
		Gallerist gallerist = new Gallerist();
		gallerist.setCreatedDate(new Date());
		
		
		Optional<Adress> optAdress = adressRepository.findById(dtoGalleristIU.getAdressId());
		if (optAdress.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXCIST, dtoGalleristIU.getAdressId().toString()));
		}
		
		gallerist.setAdress(optAdress.get());
		
		BeanUtils.copyProperties(dtoGalleristIU, gallerist);
		
		return gallerist;
		
	}
	
	
	@Override
	public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {
		DtoGallerist dtoGallerist = new DtoGallerist();
		DtoAdress dtoAdress = new DtoAdress();
		
		
		Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGalleristIU));
		BeanUtils.copyProperties(savedGallerist.getAdress(), dtoAdress);

		dtoGallerist.setAdress(dtoAdress);
		
		BeanUtils.copyProperties(savedGallerist, dtoGallerist);
		
		return dtoGallerist;
	}

	
	
}
