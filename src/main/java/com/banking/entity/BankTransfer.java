package com.banking.entity;


public class BankTransfer {
	 
private long fromacc;
private long toacc;
private long amount;
public long getFromacc() {
	return fromacc;
}
public void setFromacc(long fromacc) {
	this.fromacc = fromacc;
}
public long getToacc() {
	return toacc;
}
public void setToacc(long toacc) {
	this.toacc = toacc;
}
public long getAmount() {
	return amount;
}
public void setAmount(long amount) {
	this.amount = amount;
}
}
