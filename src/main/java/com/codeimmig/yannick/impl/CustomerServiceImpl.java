package com.codeimmig.yannick.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeimmig.yannick.entity.Customer;
import com.codeimmig.yannick.exception.CustomerNotFoundException;
import com.codeimmig.yannick.repo.CustomerRepository;
import com.codeimmig.yannick.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerRepository repo;
	
	private Customer validationInput(Optional<Customer> opt, String input) {
		
		return opt.orElseThrow(()->new CustomerNotFoundException("Customer'" +input+ "' not found"));
		    
	}

	@Override
	public Long saveCustomer(Customer cust) {
		
		return repo.save(cust).getId();
	}

	@Override
	public Customer getOneCustomer(Long id) {
	
		Optional<Customer> opt=repo.findById(id);
		return validationInput(opt, id.toString());
	}

	@Override
	public Customer getOneCustomerByEmail(String email) {
		Optional<Customer> opt=repo.findByEmail(email);
		return validationInput(opt, email);
	}

	@Override
	public Customer getOneCustomerByPanCard(String panCard) {
		Optional<Customer> opt=repo.findByPanCardId(panCard);
		return validationInput(opt, panCard) ;
	}

	@Override
	public Customer getOneCustomerByMobile(String mobile) {
		Optional<Customer> opt=repo.findByMobile(mobile);
		return validationInput(opt, mobile);
	}

	@Override
	public Customer getOneCustomerByAadhar(String aadhar) {
		Optional<Customer> opt=repo.findByAadharId(aadhar);
		return validationInput(opt, aadhar);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return repo.findAll();
	}

}
