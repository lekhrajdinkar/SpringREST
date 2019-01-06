package com.lekhraj.springREST.REST1;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		return service.findOne(id);
	}
	
	//Add New User
	//3. Now returning ResponseEntity.
	@PostMapping("/users")
	public ResponseEntity<Object> save(@RequestBody User u) {
		 User savedUser = service.save(u);
		 
		 //1. Build URI of newly created user
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedUser.getId()).toUri();
		 //2. It will send response code as 201:Created.
		 return ResponseEntity.created(uri).build(); 
		 
		//return service.save(u);
	}

}
