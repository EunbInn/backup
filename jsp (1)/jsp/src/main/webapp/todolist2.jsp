<%@page import="com.jsoh.jsp.TodoRepository"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  .done {
    text-decoration: line-through;
    color: red;
  }
</style>
</head>
<body>
  <%
  String title = request.getParameter("todo");
  
  TodoRepository repository = TodoRepository.getInstance();
  repository.addTodo(title);
  
  session.setAttribute("todos", repository.getTodos());
  %>

  <form method="post">
    <input type="text" name="todo" placeholder="할 일" />
    <button>추가</button>
  </form>
  
  <ul>
    <c:forEach var="todo" items="${todos}">
      <li>${todo.title}</li>
    </c:forEach>
    
    <!-- <li class="done">1</li> -->
  </ul>
</body>
</html>








