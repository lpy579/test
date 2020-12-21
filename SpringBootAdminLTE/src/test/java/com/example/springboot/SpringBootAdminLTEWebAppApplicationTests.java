package com.example.springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

@Disabled
@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringBootAdminLTEWebAppApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	void beforeEach() {
		//do something before launching each test case.
		Assertions.assertNotNull(webApplicationContext);
	}
	
	@Test
	void contextLoads() {
		//do any test here.
	}
}
