package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
	RestTemplate rest = new RestTemplate();
	
	@GetMapping()
	@ResponseBody
	public String test() {
		System.out.println( " Queried " );
		return "Hello World !!! V:0.1.1";
	}
	
	@Value( "${SOURCE_SERVICE_URL}" )
	private String sourceService;
	
	@GetMapping("/date")
	public String getByDate(String nomAxe, String nomMatiere ) {
		String dateUrl = sourceService +"/date";
		String response = " Demo demande la date "+ rest.getForObject( dateUrl, String.class);
		return response;
	}

}
