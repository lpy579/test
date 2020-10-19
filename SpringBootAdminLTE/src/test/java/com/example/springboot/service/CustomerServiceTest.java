/**
 * 
 */
package com.example.springboot.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.springboot.model.Customer;

/**
 * Integration test for CustomerService.
 * 
 * @author bobyuan
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Tag("junit5")
public class CustomerServiceTest {
	@Autowired
	private CustomerService service;

	@Test
	@DisplayName("Test the auto-wired object.")
	public void testAutowiredObjects() {
		Assertions.assertNotNull(service);
	}

	@Test
	@Rollback
	public void test_findById() {
		Customer newCust = new Customer();
		newCust.setFirstname("test_findById_firstname");
		newCust.setLastname("test_findById_lastname");
		newCust.setEmail("test_findById_email@hotmail.com");

		Customer savedCust = service.save(newCust);
		Long id = savedCust.getId();
		
		Customer cust1 = service.findById(id);
		Assertions.assertEquals(id, cust1.getId());
		Assertions.assertEquals("test_findById_firstname", cust1.getFirstname());
	}

	@Test
	@Rollback
	public void test_findByEmail() {
		Customer newCust = new Customer();
		newCust.setFirstname("test_findByEmail_firstname");
		newCust.setLastname("test_findByEmail_lastname");
		newCust.setEmail("test_findByEmail_email@hotmail.com");

		Customer savedCust = service.save(newCust);
		Long id = savedCust.getId();

		Customer cust1 = service.findByEmail("test_findByEmail_email@hotmail.com");
		Assertions.assertEquals(id, cust1.getId());
		Assertions.assertEquals("test_findByEmail_email@hotmail.com", cust1.getEmail());
	}

	@Test
	@Rollback
	public void test_findAll() {
		List<Customer> custList = service.findAll();
		Assertions.assertTrue(custList.size() >= 0);
	}

	@Test
	@Rollback
	public void test_save() {
		Customer newCust = new Customer();
		newCust.setFirstname("test_save_firstname");
		newCust.setLastname("test_save_lastname");
		newCust.setEmail("test_save_email@hotmail.com");

		// ---- test insert ----
		Customer savedCust = service.save(newCust);
		Assertions.assertNotNull(savedCust.getId()); // ID should now be filled.

		// All other properties should be the same.
		Assertions.assertEquals(newCust.getFirstname(), savedCust.getFirstname());
		Assertions.assertEquals(newCust.getLastname(), savedCust.getLastname());
		Assertions.assertEquals(newCust.getEmail(), savedCust.getEmail());

		// ---- test update ----
		savedCust.setEmail("test_save_email@hotmail.com.updated");
		Customer updatedCust = service.save(savedCust);

		// ID should stay the same.
		Assertions.assertEquals(savedCust.getId(), updatedCust.getId());

		// Email is updated.
		Assertions.assertEquals(savedCust.getEmail(), updatedCust.getEmail());

		// Check the records availability in database.
		Assertions.assertNull(service.findByEmail("test_save_email@hotmail.com"));
		Assertions.assertNotNull(service.findByEmail("test_save_email@hotmail.com.updated"));
	}

	@Test
	@Rollback
	public void test_deleteById() {
		Customer newCust = new Customer();
		newCust.setFirstname("test_deleteById_firstname");
		newCust.setLastname("test_deleteById_lastname");
		newCust.setEmail("test_deleteById_email@hotmail.com");

		Customer savedCust = service.save(newCust);
		Long id = savedCust.getId();
		
		service.deleteById(id);
		Assertions.assertNull(service.findById(id));
	}

	@Test
	@Rollback
	public void test_deleteByEmail() {
		final String EMAIL = "test_deleteByEmail_email@hotmail.com";

		Customer newCust = new Customer();
		newCust.setFirstname("test_deleteByEmail_firstname");
		newCust.setLastname("test_deleteByEmail_lastname");
		newCust.setEmail(EMAIL);

		Customer savedCust = service.save(newCust);
		Long id = savedCust.getId();
		
		service.deleteByEmail(EMAIL);
		Assertions.assertNull(service.findByEmail(EMAIL));
		Assertions.assertNull(service.findById(id));
	}

	@Test
	@Rollback
	public void test_count_findAll_deleteAll() {
		long count = service.count();

		Customer newCust = new Customer();
		newCust.setFirstname("test_count_firstname");
		newCust.setLastname("test_count_lastname");
		newCust.setEmail("test_count_email@hotmail.com");

		service.save(newCust);
		Assertions.assertEquals(count + 1, service.count());

		List<Customer> custList = service.findAll();
		Assertions.assertEquals(count + 1, custList.size());

		service.deleteAll();
		Assertions.assertEquals(0, service.count());

		custList = service.findAll();
		Assertions.assertEquals(0, custList.size());
	}
}
