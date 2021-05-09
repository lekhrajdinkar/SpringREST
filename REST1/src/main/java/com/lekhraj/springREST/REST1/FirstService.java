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
		
		
		@GetMapping(path = "/hello-world/path-variable/{name1}")
		public FirstBean helloWorldPathVariable(@PathVariable(name="name1") String name) {
			System.out.println("path Param : " + name);
			return new FirstBean(String.format("Hello World, %s", name));
		}
		
	}



