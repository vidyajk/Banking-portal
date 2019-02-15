package com.banking.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.banking.entity.Account;
import com.banking.entity.Customer;
import com.banking.repository.AccountRepository;
import com.banking.repository.LoginRepository;
import com.banking.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public Customer login(Customer cust) {
		long id = cust.getId();
		String password = cust.getPassword();
		boolean notLocked = cust.isNotLocked();
		Customer findOneByIdAndPassword = null;
		if(!notLocked) {
			Customer findOneById = loginRepository.findOneById(id);
			if(findOneById!=null) {
				findOneByIdAndPassword = loginRepository.findOneByIdAndPassword(id, password);
				if(findOneByIdAndPassword==null) {
					cust.setCount(findOneById.getCount()+1);
					cust.setPassword(findOneById.getPassword());
					cust.setEmail(findOneById.getEmail());
					cust.setFirstName(findOneById.getFirstName());
					cust.setLastName(findOneById.getLastName());
					cust.setNotLocked(findOneById.isNotLocked());
					if(cust.getCount()>=3) {
						cust.setNotLocked(true);
					}
					loginRepository.save(cust);
				}
			} 
		}
		return findOneByIdAndPassword;
	}
	
	
		
}
