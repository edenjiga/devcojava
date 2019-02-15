package com.example.demo.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.NumberConverterService;

@RunWith(MockitoJUnitRunner.class)
public class NumberConverterControllerTest {

	@InjectMocks
	private NumberConverterController numberConverterController;

	@Mock
	private NumberConverterService numberConverterService;

	@Autowired
    private MockMvc mockMvc;

	@Test
	public void testConvertArabToRomanNumberWhenParamIsValid() throws Exception {
		when(numberConverterService.convertArabToRoman(any())).thenReturn("CC");

		mockMvc.perform(get("/arab-to-roman?num=200"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.content", is("C")));
	}

}
