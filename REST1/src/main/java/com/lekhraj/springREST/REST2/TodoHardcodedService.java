package com.lekhraj.springREST.REST2 ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TodoHardcodedService {
	
	// No database backednd, hardcoded tado list
	private static List<Todo> todos = new ArrayList<>();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "Lekhraj Dinkar","Learn Spring Boot security with JWT Outh2 and Basic Auth", new Date(), false ));
		todos.add(new Todo(++idCounter, "Lekhraj Dinkar","Learn angular redux", new Date(), false ));
		todos.add(new Todo(++idCounter, "Lekhraj Dinkar","Learn Angular Security", new Date(), false ));
		
		todos.add(new Todo(++idCounter, "sachin ","Learn Spring Boot security with JWT Outh2 and Basic Auth", new Date(), false ));
		todos.add(new Todo(++idCounter, "sachin","Learn angular redux", new Date(), false ));
		todos.add(new Todo(++idCounter, "sachin","Learn Angular Security", new Date(), false ));
	}
	
	//----- Utility methods on todos
	// 1.1 find all todos
	public List<Todo> findAll() {
		return todos;
	}
	
	// 1.2 Find specific todo item
		public Todo findById(long id) {
			for(Todo todo:todos) {
				if(todo.getId() == id) {
					return todo;
				}
			}
			
			return null;
		}

	//2. Save new Todo item
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	// 3. Delete Todo
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		
		if(todo==null) return null;
		
		if(todos.remove(todo)) {
			return todo;
		}
		
		return null;
	}

	
	
}
