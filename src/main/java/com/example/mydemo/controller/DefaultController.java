package com.example.mydemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
	
	@RequestMapping("/home")
	public String home() {
		return "Reporting for duty!";
	}

}
