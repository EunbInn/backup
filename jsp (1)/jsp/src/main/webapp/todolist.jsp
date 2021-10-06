<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jsoh.jsp.Todo" %>
<%@ page import="java.util.*" %>
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
  
  Todo todo = new Todo(title);
  
  List<Todo> todos = (ArrayList<Todo>) session.getAttribute("todos");
  
  if (todos == null) {
      todos = new ArrayList<Todo>();    
  }
  
  todos.add(todo);
  
  session.setAttribute("todos", todos);
  
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








