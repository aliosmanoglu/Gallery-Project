package com.alihaydar.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alihaydar.model.SaledCar;


@Repository
public interface SaledCarRepository extends JpaRepository<SaledCar, Long>{

}
