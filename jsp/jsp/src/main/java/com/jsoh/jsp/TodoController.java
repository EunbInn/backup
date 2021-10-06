package com.jsoh.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/TodoController"})
public class TodoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	String title = request.getParameter("todo");

	TodoRepository repository = TodoRepository.getInstance();
	repository.addTodo(title);

	HttpSession session = request.getSession();
	session.setAttribute("todos", repository.getTodos());
	
	request.getRequestDispatcher("todolist3.jsp")
		.forward(request, resp);
    }

}











