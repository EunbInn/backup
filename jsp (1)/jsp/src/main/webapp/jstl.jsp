<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table>
  <c:forEach var="i" begin="1" end="9">
    <tr>
      <td>${i}</td>
    </tr>
  </c:forEach>
  </table>
</body>
</html>