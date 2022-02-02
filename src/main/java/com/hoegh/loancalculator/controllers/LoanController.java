package com.hoegh.loancalculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoanController {

	@GetMapping("/")
	public String toIndex(Model model) {
		return "index";
	}

}
