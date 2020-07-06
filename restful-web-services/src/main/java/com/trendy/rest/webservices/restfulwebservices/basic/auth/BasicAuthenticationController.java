package com.trendy.rest.webservices.restfulwebservices.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BasicAuthenticationController {
	
	/*@GetMapping(path="/hello-world")
	public String helloWorld() {
		return " Hello World";
	
	}*/
	
	@GetMapping(path="/basicauth")
	public  HelloWorldBean helloWorldBean() {
		return  new HelloWorldBean(" You are authenticated");
	}

	/*@GetMapping(path="/hello-world/path-variable/{name}")
	public  HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return  new HelloWorldBean(String.format(" Hello World,%s",name));
	}*/

}
