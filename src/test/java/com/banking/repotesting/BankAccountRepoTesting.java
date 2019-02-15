package com.banking.repotesting;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.banking.BankingPortalApplication;
import com.banking.entity.Customer;
import com.banking.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BankingPortalApplication.class)
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BankAccountRepoTesting {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	@Transactional
	public void add() {
		Customer customer = new Customer();
		
		customer.setFirstName("Vidya");
		customer.setLastName("Ashok");
		customer.setPassword("abc");
		customer.setEmail("abc@gmail.com");
		
		customerRepository.add(customer);
	}

	@Test
	@Transactional
	public void fetchByid() {
		com.banking.entity.Customer customer = new Customer();
		customer = customerRepository.fetch(1);
		System.out.println(customer.getId());
	}

	@Test
	@Transactional
	public void verifyCustomer() {
		Customer customer = new Customer();
		customer = customerRepository.fetch(52);
		System.out.println(customer.getId());
		}
}
