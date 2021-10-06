<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Hello World</h1>
  
  <%@ page import="com.jsoh.jsp.Person" %>
  
  <%
  Person person1 = new Person("홍길동", 10); // 100번지
  Person person2 = new Person("홍길동", 10); // 200번지

  out.print(person1.equals(person2)); // 값 비교
  out.print(person1 == person2);  // 레퍼런스(주소) 비교
  %>
  <br>
  <h1>hashcode</h1>
  <%
  out.print(person1);
  %>
  <br>
  <%
  out.print(person2);
  %>
  <br>  
  <%@ page import="java.util.*" %>
  
  <%!
  void something(ArrayList<Person> list, Person person) {
      list.add(person);
  }
  
  void something2(List<Person> list, Person person) {
      list.add(person);
  }
  %>
  
  <%
  List<Person> items2 = new ArrayList<Person>();
  List<Person> items3 = new LinkedList<Person>();
  // something(items2, person1);
  out.print(items2);
  something2(items2, person1);
  something2(items3, person1);
  %>
  
  <%
    // 레퍼런스 기반으로 순서대로 저장, 중복 허용
    List<Person> items = new ArrayList<Person>();
    items.add(person1);
    items.add(person2);
    
    items.remove(person2);
    
    out.print("ArrayList: " + items);
    out.print("<br>");
    
    // 해시값 기반으로 집합을 표현, 중복 불허, 무진장 빨라!
    Set<Person> itemSet = new HashSet<Person>();
    itemSet.add(person1);
    itemSet.add(person1);
    itemSet.add(person1);
    itemSet.add(person2);
    
    
    out.print("HashSet : " + itemSet);
    
  %>
  
  <jsp:useBean id="person3" class="com.jsoh.jsp.Person" scope="page" />
  
  <%
  out.print(person3);
  %>
  
  
</body>
</html>







