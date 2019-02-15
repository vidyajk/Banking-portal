package com.banking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bank_transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "trx_id_seq")
	private int id;

	@Column(length = 5)
	private int transId;

	@Column(length = 10)
	private double balance;

	@Column(length = 10)
	private long transWith;

	@ManyToOne
	private Account account;
	
	//private Date date;
	
	private double amount;
	
	private String type;
	

	public Transaction() {
		super();
		this.transId = transId;
		this.balance = balance;
		this.transWith = transWith;
	}

	public Transaction(int transId, double balance, long transWith) {
		super();
		this.transId = transId;
		this.balance = balance;
		this.transWith = transWith;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public long getTransWith() {
		return transWith;
	}

	public void setTransWith(long transWith) {
		this.transWith = transWith;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

/*	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date= date;
	}
	*/
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount= amount;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transId=" + transId + ", balance=" + balance + ", transWith=" + transWith
				+ ", account=" + account + "]";
	}
}
