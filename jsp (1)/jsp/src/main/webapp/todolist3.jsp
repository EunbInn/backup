<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.done {
  text-decoration: line-through;
  color: red;
}
</style>
<script>
function toggle(id, done) {
  // ajax 
  /* var xhr = new XMLHttpRequest();
  xhr.open("POST", "TodoController", true);
  xhr.setRequestHeader("Content-Type", "application/json");
  
  var json = {
    todo: "test"
  };
  
  xhr.send(JSON.stringify(json)); */
  
  $.ajax({  
    type: "POST" 
 	,url: "addTodo"
    ,data: {id:id, done:done}
    ,success:function(data) {
   	  //alert("성공");
   	  // refresh
   	  location.href = "todolist3.jsp";
   	}
   	,error:function(data) {
     alert("error");
   	}
   });


}
</script>
</head>
<body>
  <form action="TodoController" method="post">
    <input type="text" name="todo" placeholder="할 일" />
    <button>추가</button>
  </form>

  <ul>
    <c:forEach var="todo" items="${todos}">
      <li onclick="toggle(${todo.id}, ${todo.done})">${todo}</li>
    </c:forEach>

    <!-- <li class="done">1</li> -->
  </ul>
</body>
</html>








