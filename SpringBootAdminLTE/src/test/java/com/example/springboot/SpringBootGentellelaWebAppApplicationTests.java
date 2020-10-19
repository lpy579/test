package com.example.springboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringBootGentellelaWebAppApplicationTests {

	@BeforeEach
	void beforeEach() {
		//do something before launching each test case.
	}
	
	@Test
	void contextLoads() {
		//do any test here.
	}
}
