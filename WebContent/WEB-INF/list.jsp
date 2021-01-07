<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.javaex.vo.PersonVo" %>
<%

	List<PersonVo> personList = (List<PersonVo>)request.getAttribute("plist");
	System.out.println("=====list=====");
	System.out.println(personList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 리스트</h1>

	<p>입력한 전화번호 내역입니다</p>
	
	<%for(int i = 0; i <personList.size();i++){ %>
	<table border="1">
	
		<tr>
			<td>(정보)</td>
			<td><a href="/phonebook2/pnc?action=delete&no=<%=personList.get(i).getPersonId() %>">(삭제)</a>
			   /<a href="/phonebook2/pnc?action=upform&no=<%=personList.get(i).getPersonId()%>" > (변경)</a></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=personList.get(i).getName() %></td>	
		</tr>
		<tr>
			<td>핸드폰</td>
			<td><%=personList.get(i).getHp() %></td>
			
		</tr>
		<tr>
			<td>회사</td>
			<td><%=personList.get(i).getCompany() %></td>
			
		</tr>
		
		
		
		
		
		
	</table>
	<br>
	<%} %>
	<a href="/phonebook2/pnc?action=wform">추가번호 등록</a>


</body>
</html>