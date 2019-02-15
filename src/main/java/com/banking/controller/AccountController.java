package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.banking.entity.Account;
import com.banking.entity.BankTransfer;
import com.banking.repository.AccountRepository;
import com.banking.service.impl.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountService accountService;

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Account create(@RequestBody Account acc) {
		return accountRepository.save(acc);
	}
	
	@GetMapping("/{id}")
	public Account get(@PathVariable("id") long id) {
		return accountRepository.getOne(id);
	}
	

	 
}
