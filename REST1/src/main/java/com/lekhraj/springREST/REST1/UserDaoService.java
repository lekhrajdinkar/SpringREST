package com.lekhraj.springREST.REST1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();

	private static int usersCount = 10003;

	//Hardcoded  List
	static {
		users.add(new User(10001, "Lekhraj Dinkar", new Date()));
		users.add(new User(10002, "Abhishek Mukherjee", new Date()));
		users.add(new User(10003, "Reena Joshi", new Date()));
	}

	
	
	//findAll Users
	public List<User> findAll() {
		return users;
	}

	
	//Find Specific user
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	//Save new User
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	//Delete User
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
