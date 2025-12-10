package com.alihaydar.controller;

import com.alihaydar.dto.DtoGallerist;
import com.alihaydar.dto.DtoGalleristIU;
import com.alihaydar.model.Gallerist;

public interface IGalleristController {

	public RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);
	
}
