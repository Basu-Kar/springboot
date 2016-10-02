package com.ksoft.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/testspringboot")

public class PingController {

	@RequestMapping("/ping")
	public String ping(){
		return "success";
	}
	
	
	
}
