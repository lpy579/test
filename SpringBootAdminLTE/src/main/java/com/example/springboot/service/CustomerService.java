package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Customer;
import com.example.springboot.repository.CustomerRepository;

@Service
public class CustomerService {
	private final CustomerRepository repository;

	/** Default constructor */
	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	/** Get list of object in pagination */
	public Page<Customer> getList(int pageNumber, int pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, 
				Sort.Direction.ASC, "id");
		return repository.findAll(pageRequest);
	}
	
	public List<Customer> findAll() {
		List<Customer> entityList = repository.findAll();
		return entityList;
	}

	public Customer findById(Long id) {
		Optional<Customer> entityInDb = repository.findById(id);
		return entityInDb.isPresent() ? entityInDb.get() : null;
	}

	public Customer findByEmail(String email) {
		Optional<Customer> entityInDb = repository.findByEmail(email);
		return entityInDb.isPresent() ? entityInDb.get() : null;
	}

	public Customer save(Customer entity) {
		return repository.save(entity);
	}

	public long count() {
		return repository.count();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public void deleteByEmail(String email) {
		Customer entityInDb = findByEmail(email);
		if (entityInDb != null) {
			repository.deleteById(entityInDb.getId());
		}
	}

	public void deleteAll() {
		repository.deleteAll();
	}
}
