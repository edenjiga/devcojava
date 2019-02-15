package com.example.demo.service.impl;

import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Min;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.example.demo.service.NumberConverterService;

@Service
public class NumberConverterServiceImpl implements NumberConverterService {

	private TreeMap<Integer, String> romanNumberMap;

	@PostConstruct
	public void init() {
		romanNumberMap = new TreeMap<Integer, String>();
		romanNumberMap.put(1, "I");
		romanNumberMap.put(4, "IV");
		romanNumberMap.put(5, "V");
		romanNumberMap.put(9, "IX");
		romanNumberMap.put(10, "X");
		romanNumberMap.put(40, "XL");
		romanNumberMap.put(50, "L");
		romanNumberMap.put(90, "XC");
		romanNumberMap.put(100, "C");
		romanNumberMap.put(400, "CD");
		romanNumberMap.put(500, "D");
		romanNumberMap.put(900, "CM");
		romanNumberMap.put(1000, "M");
	}

	@Override
	public String convertArabToRoman(@Min(1) int arabNum) {
		if (arabNum <= 0) {
			return StringUtils.EMPTY;
		}

		return toRoman(arabNum);
	}

	public final String toRoman(int number) {
		int closestRomanKey = romanNumberMap.floorKey(number);
		if (number == closestRomanKey) {
			return romanNumberMap.get(number);
		}
		return romanNumberMap.get(closestRomanKey) + toRoman(number - closestRomanKey);
	}

}
