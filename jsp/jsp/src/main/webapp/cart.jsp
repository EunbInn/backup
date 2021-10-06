<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jsoh.jsp.Cart" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>장바구니</h1>
  <%
  Set<Cart> cartItems = (HashSet<Cart>) session.getAttribute("cartItems");
  if (cartItems == null) {
      cartItems = new HashSet<Cart>();
  }
  
  String name = request.getParameter("name");
  String amount = request.getParameter("amount");
  if (name != null && !name.isEmpty() && amount != null && !amount.isEmpty()) {
    cartItems.add(new Cart(name, Integer.parseInt(amount)));
  }
  
  session.setAttribute("cartItems", cartItems);
  %>
  
  <form method="post">
    <input name="name" type="text" placeholder="상품명">
    <input name="amount" type="text" placeholder="수량">
    <button>추가</button>
  </form>
  
  <ul>
    <c:forEach var="cart" items="${cartItems}">
      <li>${cart}</li>  
    </c:forEach>
  </ul>
</body>
</html>





