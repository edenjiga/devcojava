package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.NumberConverterService;

@RestController
public class NumberConverterController {

	@Autowired
	private NumberConverterService numberConverterService;

	@GetMapping("/arab-to-roman")
	public ResponseEntity<String> convertArabToRomanNumber(@RequestParam("num") Integer arabNum) {
		if (arabNum <= 0) {
			return ResponseEntity.badRequest().body("Num must be greater than or equal to 1");
		}

		String romanNumber = numberConverterService.convertArabToRoman(arabNum);
		return ResponseEntity.ok(romanNumber);
	}

}
