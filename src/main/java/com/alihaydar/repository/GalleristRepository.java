package com.alihaydar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alihaydar.model.Gallerist;

@Repository
public interface GalleristRepository extends JpaRepository<Gallerist, Long>{

	
	
}
