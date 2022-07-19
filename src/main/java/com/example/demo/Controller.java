package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
	RestTemplate rest = new RestTemplate();
	
	@Value( "${SOURCE_SERVICE_URL}" )
	private String sourceService;
	
	@GetMapping()
	@ResponseBody
	public String test() {
		System.out.println( " Queried " );
		return "Bienvenue aux soutenances de Voufack Jazet Harol !!! V:10    SourceURL = "+sourceService;
	}
	
	
	
	@GetMapping("/date")
	public String getByDate(String nomAxe, String nomMatiere ) {
		String dateUrl = "http://"+sourceService +"/date";
		String response = rest.getForObject( dateUrl, String.class);
//		String response = " Demo demande la date "+ rest.getForObject( dateUrl, String.class);
		return response;
	}

}
