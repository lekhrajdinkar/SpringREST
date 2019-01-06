package com.lekhraj.springREST.REST1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class FirstService {

		@RequestMapping(path = "/hello-world")
		public String helloWorld1() {
			return "Hello World 1";
		}
		
		@GetMapping(path = "/hello-world")
		public String helloWorld2() {
			return "Hello World 2";
		}

		@GetMapping(path = "/hello-world-bean")
		public FirstBean helloWorldBean() {
			return new FirstBean("Hello World");
		}
		
		///hello-world/path-variable/in28minutes
		@GetMapping(path = "/hello-world/path-variable/{name}")
		public FirstBean helloWorldPathVariable(@PathVariable String name) {
			return new FirstBean(String.format("Hello World, %s", name));
		}
		
	}



