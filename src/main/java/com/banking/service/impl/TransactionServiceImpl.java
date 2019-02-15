package com.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.entity.BankTransfer;
import com.banking.entity.Transaction;
import com.banking.repository.TransactionRepository;
import com.banking.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction IMPSTransfer(BankTransfer bankTransfer) {
		System.out.println("hello");
		Transaction findOneByFromAccId = transactionRepository.findOneByAccount_Id(bankTransfer.getFromacc());
		Transaction findOneByToAccId = transactionRepository.findOneByAccount_Id(bankTransfer.getToacc());
		if (findOneByFromAccId != null && findOneByToAccId != null) {
			long amount = bankTransfer.getAmount();
			if (findOneByFromAccId.getBalance() >= amount) {
				findOneByToAccId.setBalance(findOneByFromAccId.getBalance() - amount);
				transactionRepository.save(findOneByFromAccId);//withdraw
			}
			findOneByToAccId.setBalance(findOneByToAccId.getBalance()+amount);
			transactionRepository.save(findOneByToAccId);//deposit
			
		}
		return findOneByFromAccId;
	}

}
