package com.alihaydar.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alihaydar.controller.IGalleristController;
import com.alihaydar.controller.RestEntityBase;
import com.alihaydar.controller.RootEntity;
import com.alihaydar.dto.DtoGallerist;
import com.alihaydar.dto.DtoGalleristIU;
import com.alihaydar.model.Gallerist;
import com.alihaydar.service.impl.GalleristServiceImpl;

@RestController
@RequestMapping("/rest/api/gallerist")
public class GalleristControllerImpl extends RestEntityBase implements IGalleristController{

	@Autowired
	private GalleristServiceImpl galleristServiceImpl;
	
	@Override
	@PostMapping("/save")
	public RootEntity<DtoGallerist> saveGallerist(@RequestBody DtoGalleristIU dtoGalleristIU) {
		return ok(galleristServiceImpl.saveGallerist(dtoGalleristIU));
	}

}
