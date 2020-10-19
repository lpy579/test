package com.example.springboot.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * This is a pure JUnit 5 test case for Customer.
 * 
 * @author bobyuan
 */
@Tag("junit5")
public class CustomerTest {

	@Test
	public void testCustomerEntity() {
		Customer obj = new Customer();

		// initial state.
		Assertions.assertEquals(Long.valueOf(0L), obj.getId());
		Assertions.assertNull(obj.getFirstname());
		Assertions.assertNull(obj.getLastname());
		Assertions.assertNull(obj.getEmail());

		// test getter and setter.
		obj.setId(1L);
		Assertions.assertEquals(Long.valueOf(1L), obj.getId());
		obj.setFirstname("Firstname1");
		Assertions.assertEquals("Firstname1", obj.getFirstname());
		obj.setLastname("Lastname1");
		Assertions.assertEquals("Lastname1", obj.getLastname());
		obj.setEmail("email1@hotmail.com");
		Assertions.assertEquals("email1@hotmail.com", obj.getEmail());

		// test toString.
		String s = obj.toString();
		//System.out.println(s);
		// com.example.springboot.model.Customer@64485a47[id=1,firstname=Firstname1,lastname=Lastname1,email=email1@hotmail.com]
		Assertions.assertTrue(s.indexOf("id=1") > 0);
		Assertions.assertTrue(s.indexOf("firstname=Firstname1") > 0);
		Assertions.assertTrue(s.indexOf("lastname=Lastname1") > 0);
		Assertions.assertTrue(s.indexOf("email=email1@hotmail.com") > 0);
	}

	@Test
	public void testCustomerEntityEquals() {
		Customer obj1 = new Customer();
		Customer obj2 = new Customer();
		Customer obj3 = new Customer();
		Customer obj4 = new Customer();

		obj1.setId(1L);
		obj1.setFirstname("Firstname1");
		obj1.setLastname("Lastname1");
		obj1.setEmail("email1@hotmail.com");

		obj2.setId(2L);
		obj2.setFirstname("Firstname2");
		obj2.setLastname("Lastname2");
		obj2.setEmail("email2@hotmail.com");

		obj3.setId(3L);
		obj3.setFirstname("Firstname3");
		obj3.setLastname("Lastname3");
		obj3.setEmail("email3@hotmail.com");

		obj4.setId(1L);
		obj4.setFirstname("Firstname1");
		obj4.setLastname("Lastname1");
		obj4.setEmail("email1@hotmail.com");

		Assertions.assertEquals(obj1, obj1);
		Assertions.assertNotEquals(obj1, "a_string");

		Assertions.assertNotEquals(obj1, obj2);
		Assertions.assertNotEquals(obj2, obj3);
		Assertions.assertEquals(obj1, obj4);
	}
}
