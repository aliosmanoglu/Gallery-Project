package com.alihaydar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alihaydar.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
