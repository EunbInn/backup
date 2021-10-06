package com.jsoh.jsp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
    
    public void toggle(long id, boolean currentDone) {
	Todo result = todos.stream()
		.filter((todo) -> todo.getId() == id)
		.findFirst()
		.get();
	
	result.setDone(!currentDone);
	
//	Todo result;
//	for (Todo todo: todos) {
//	    if (todo.getId() == id) {
//		result = todo;
//		break;
//	    }
//	}
	
	
    }
}














