package com.example.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.springboot.model.Customer;

public interface CustomerService {
	/** Get list of object in pagination */
	public Page<Customer> getList(int pageNumber, int pageSize);
	
	public List<Customer> findAll();

	public Customer findById(Long id);

	public Customer findByEmail(String email);

	public Customer save(Customer entity);

	public long count();

	public void deleteById(Long id);

	public void deleteByEmail(String email);

	public void deleteAll();
}
