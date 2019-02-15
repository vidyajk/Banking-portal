package com.banking.repository;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.banking.entity.Customer;

@Repository
public class CustomerRepository  {

	@PersistenceContext
	private EntityManager entityManager;

	public void add(Customer customer) {
		entityManager.persist(customer);
	}

	public Customer fetch(int id) {
		return entityManager.find(Customer.class, id);
	}

	public List<Customer> fetchAll(String email,String password) {
		Query q = entityManager.createQuery("select obj from Customer as obj where obj.email=?1  and obj.password=?2");
	   q.setParameter(1,email);
	   q.setParameter(2,password);
    	return q.getResultList();
	}

}
