package com.lekhraj.springREST.REST1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();

	private static int usersCount = 3;

	//Hardcoded  List
	static {
		users.add(new User(10001, "Lekhraj Dinkar", new Date()));
		users.add(new User(10002, "Abhishek Mukherjee", new Date()));
		users.add(new User(10003, "Reena Joshi", new Date()));
	}

	//Utlilities methods
	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

}
