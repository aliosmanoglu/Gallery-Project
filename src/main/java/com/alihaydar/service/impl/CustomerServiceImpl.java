package com.alihaydar.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.alihaydar.dto.DtoAccount;
import com.alihaydar.dto.DtoAdress;
import com.alihaydar.dto.DtoCustomer;
import com.alihaydar.dto.DtoCustomerIU;
import com.alihaydar.enums.MessageType;
import com.alihaydar.exception.BaseException;
import com.alihaydar.exception.ErrorMessage;
import com.alihaydar.model.Account;
import com.alihaydar.model.Adress;
import com.alihaydar.model.Customer;
import com.alihaydar.repository.AccountRepository;
import com.alihaydar.repository.AdressRepository;
import com.alihaydar.repository.CustomerRepository;
import com.alihaydar.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{


	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AdressRepository adressRepository;
	
	@Autowired
	private AccountRepository accountRepository;

   
	
	private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
		Customer customer = new Customer();
		customer.setCreatedDate(new Date());
		
		
		Optional<Adress> optAdress = adressRepository.findById(dtoCustomerIU.getAdressId());
		if (optAdress.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXCIST, dtoCustomerIU.getAdressId().toString()));
		}
		
		Optional<Account> optAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
		
		if (optAccount.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXCIST, dtoCustomerIU.getAccountId().toString()));
		}
		
		customer.setAccount(optAccount.get());
		customer.setAdress(optAdress.get());
		
		BeanUtils.copyProperties(dtoCustomerIU, customer);
		
		return customer;
		
	}
	
	@Override
	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAdress dtoAdress = new DtoAdress();
		DtoAccount dtoAccount = new DtoAccount();
		
		Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));
		
		BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);
		BeanUtils.copyProperties(savedCustomer.getAdress(), dtoAdress);

		dtoCustomer.setAdress(dtoAdress);
		dtoCustomer.setAccount(dtoAccount);
		
		BeanUtils.copyProperties(savedCustomer, dtoCustomer);
		
		
		return dtoCustomer;
	}

}
