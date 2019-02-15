package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.entity.Customer;

@Repository
public interface LoginRepository extends JpaRepository<Customer, Long> {

	Customer findOneById(long id);

	Customer findOneByIdAndPassword(long id, String password);

	Customer getOneByEmail(String email);

}
