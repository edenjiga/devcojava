package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.service.impl.NumberConverterServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class NumberConverterServiceImplTest {

	@InjectMocks
	private NumberConverterServiceImpl numberConverterService;

	@Before
	public void init() {
		numberConverterService.init();
	}

	@Test
	public void testConverToRomanWhenNumberIsValid() {
		String romanNum = numberConverterService.convertArabToRoman(148);
		assertThat(romanNum).isEqualTo("CXLVIII");
	}

	@Test
	public void testConverToRomanWhenBigNumberIsValid() {
		String romanNum = numberConverterService.convertArabToRoman(3584);
		assertThat(romanNum).isEqualTo("MMMDLXXXIV");
	}

	@Test
	public void testConverToRomanWhenNumberIsZero() {
		String romanNum = numberConverterService.convertArabToRoman(0);
		assertThat(romanNum).isEmpty();
	}

}
