package com.banking.service;
import com.banking.entity.BankTransfer;
import com.banking.entity.Transaction;

public interface TransactionService {

	Transaction IMPSTransfer(BankTransfer bankTransfer);
}
