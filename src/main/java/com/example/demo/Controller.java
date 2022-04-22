package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class Controller {
	
	@GetMapping()
	@ResponseBody
	public String test() {
		System.out.println( " Queried " );
		return "Hello World !!! V:0.0.3";
	}

}
