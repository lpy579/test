package com.example.springboot.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Integration test for HomeController.
 * 
 * @author bobyuan
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Tag("junit5")
@AutoConfigureMockMvc
public class HomeControllerIntegrationTest {
	@Autowired
    private MockMvc mockMvc;

	@Test
	public void test_favicon() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/favicon.ico").accept(MediaType.IMAGE_PNG);
		mockMvc.perform(builder).andExpect(status().isOk());
	}

	@Test
	public void test_welcome() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML);
		mockMvc.perform(builder).andExpect(status().isOk())
				// .andDo(MockMvcResultHandlers.print())
				.andExpect(view().name("home"))
				.andExpect(model().attribute("message", "Welcome!"))
				.andExpect(model().attributeExists("date"));
	}

}
