package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entity.Customer;
import com.banking.repository.LoginRepository;
import com.banking.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> list(){
		return loginRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Customer create(@RequestBody Customer cust) {
		return loginRepository.save(cust);
	}
	
	@GetMapping("/{id}")
	public Customer get(@PathVariable("id") long id) {
		return loginRepository.getOne(id);
	}
	
	@GetMapping("/login")
	public Customer login(@RequestBody Customer cust) {
		Customer findOneByIdAndPassword = customerService.login(cust);
		return findOneByIdAndPassword;
	}
	
}
