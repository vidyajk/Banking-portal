package com.banking.controller;

import java.util.List;

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
import com.banking.entity.Transaction;
import com.banking.repository.TransactionRepository;
import com.banking.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping
	public List<Transaction> list(){
		return transactionRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Transaction create(@RequestBody Transaction trx) {
		return transactionRepository.save(trx);
	}
	
	@GetMapping("/{AccId}")
	public List<Transaction> get(@PathVariable("AccId") long AccId) {
		return transactionRepository.findByAccount_Id(AccId);
	}
	@PostMapping("/amtTransfer")
	public Transaction IMPSTransfer(@RequestBody BankTransfer bankTransfer) {
		return transactionService.IMPSTransfer(bankTransfer);
	}
	
}
