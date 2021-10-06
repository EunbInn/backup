package com.jsoh.jsp;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private static TodoRepository instance;
    
    public static TodoRepository getInstance() {
	if (instance == null) {
	    instance = new TodoRepository();
	}
	return instance;
    }
    
    private TodoRepository() {
	
    }
    
    private List<Todo> todos = new ArrayList<Todo>();
    
    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(String todo) {
	todos.add(new Todo(todo));
    }
}
