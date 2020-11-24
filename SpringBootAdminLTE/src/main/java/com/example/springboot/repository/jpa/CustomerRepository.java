package com.example.springboot.repository.jpa;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	/**
	 * This method will be implemented by JPA automatically.
	 * @param email The email to lookup.
	 * @return A customer object been found from DB.
	 */
	Optional<Customer> findByEmail(String email);
}
