package com.codeimmig.yannick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeimmig.yannick.entity.Customer;
import com.codeimmig.yannick.exception.CustomerNotFoundException;
import com.codeimmig.yannick.service.ICustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerRestController {
	
	@Autowired
	private ICustomerService service;
	//1.create Customer 
	@PostMapping("/create")
	public ResponseEntity<String> createCustomer(@RequestBody  Customer customer){
		ResponseEntity<String> response=null;
		Long id=service.saveCustomer(customer);
		response=ResponseEntity.ok("Customer '"+id+"'Created");
		return response;
	}
	
	//2.Fetch all customers
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		ResponseEntity<List<Customer>> response=null;
		List<Customer> list=service.getAllCustomer();
		response=ResponseEntity.ok(list);
		return response;
	}
	
	//3.fetch one customer by email
	
	@GetMapping("/find/{mail}")
	public ResponseEntity<Customer> getOneCustomerByEmail(
			@PathVariable String mail
			) 
	{
		ResponseEntity<Customer> response = null;
		try {
			Customer cust = service.getOneCustomerByEmail(mail);
			response = new ResponseEntity<Customer>(cust,HttpStatus.OK);
		} catch (CustomerNotFoundException cnfe) {
			cnfe.printStackTrace();
			throw cnfe;
		}
		return response;
	}
	
	//2.fetch one customer by mobile
	
	@GetMapping("/checher/{aahardId}")
	public ResponseEntity<Customer> getOneCustomerByAadhard(@PathVariable String aahardId){
		ResponseEntity<Customer> response=null;
		try {
			Customer cust=service.getOneCustomerByAadhar(aahardId);
			response=new ResponseEntity<Customer>(cust, HttpStatus.OK);
			
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;	
	}
	
	@GetMapping("/findby/{mobile}")
	public ResponseEntity<Customer> getOneCustomerByMobile(@PathVariable String mobile){
		ResponseEntity<Customer> response=null;
		try {
			Customer cust=service.getOneCustomerByMobile(mobile);
			response=new ResponseEntity<Customer>(cust, HttpStatus.OK);
			
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;	
	}

		
	//4.fetch one customer by pancard
	
		/*@GetMapping("/find/{pancard}")
		public ResponseEntity<Customer> getOneCustomerByPancard(@PathVariable String pancard){
			ResponseEntity<Customer> response=null;
			try {
				Customer cust=service.getOneCustomerByPanCard(pancard);
				response=new ResponseEntity<Customer>(cust, HttpStatus.OK);
				
			} catch (CustomerNotFoundException e) {
				e.printStackTrace();
				throw e;
			}
			return response;	
		}
		
		//5.fetch one customer by mobile
		
			
			}*/
			
			

}
