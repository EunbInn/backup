package com.jsoh.jsp;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/TodoController", "/addTodo" })
public class TodoController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	String command = request.getRequestURI().substring(request.getContextPath().length());

	if ("/TodoController".equals(command)) {
	    String title = request.getParameter("todo");

	    Enumeration<String> params = request.getParameterNames();
	    while (params.hasMoreElements()) {
		System.out.println(params.nextElement());
	    }

	    System.out.println("doPost!!!!!!!!!!" + title);

	    TodoRepository repository = TodoRepository.getInstance();
	    repository.addTodo(title);

	    HttpSession session = request.getSession();
	    session.setAttribute("todos", repository.getTodos());

	    request.getRequestDispatcher("todolist3.jsp").forward(request, resp);
	} else if ("/addTodo".equals(command)) {
	    String id = request.getParameter("id");
	    String done = request.getParameter("done");
	    
	    TodoRepository.getInstance().toggle(
		    Long.valueOf(id), 
		    Boolean.valueOf(done));
	    request.getRequestDispatcher("todolist3.jsp").forward(request, resp);
	}

    }

}













