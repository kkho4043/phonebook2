<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.javaex.vo.PersonVo" %>    
<%
System.out.println("여기1");
	PersonVo updatelist = (PersonVo)request.getAttribute("ulist");
	System.out.println("여기2");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 변경</h1>
	
	<p>전화번호를 변경하려면 <br>
	   아래 항목을 기입하고 "변경"을 누르시오</p>
	 <!--  http://localhost:8088/phonebook1/insert.jsp?name=%EA%B0%95%ED%83%9C%EC%9A%B1&hp=010-4444-4444&company=02-0202-0202-->
	<form action = "/phonebook2/pnc" method="get"> 
	이름 : <input type="text" name = "name"  value = "<%=updatelist.getName()%>"> <br>
	핸드폰 : <input type="text" name = "hp" value = "<%=updatelist.getHp() %>"> <br>
	회사 : <input type="text" name = "company" value = "<%=updatelist.getCompany() %>"> <br>
	<input type="hidden" name = "no" value = "<%=updatelist.getPersonId() %>">
	<input type="hidden" name = "action" value="update">
	<button type = "submit">변경</button>	
	</form>
</body>
</html>