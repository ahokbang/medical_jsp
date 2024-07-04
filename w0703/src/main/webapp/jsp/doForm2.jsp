<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8");
	String[] hobby = request.getParameterValues("hobby");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보</title>
		<style>
		table, th, td{border: 1px solid black; border-collapse : collapse;}
		th{width: 120px;}
		</style>
	</head>
	<body>
<%-- 		<%
			request.setCharacterEncoding("utf-8");
/* 			String id = request.getParameter("id");
			out.println("id : " + id + "<br>");
			String pw = request.getParameter("pw");
			out.println("pw : " + pw + "<br>"); */
		%> --%>
		
		<h2>회원정보</h2>
		<table>
		<tr>
			<th>제목</th>
			<th>내용</th>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%= request.getParameter("id") %></td>
			<%-- <td><% out.println(id); %></td> --%>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><%= request.getParameter("pw") %></td>
			<%-- <td><%= pw %></td> --%>
		</tr>
		<tr>
			<td>이름</td>
			<td><%= request.getParameter("name") %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%= request.getParameter("gender") %></td>
		</tr>
		
		<% for(int i=0; i<hobby.length; i++){ %>
			<tr>
				<td>취미</td>
				<td><%= hobby[i] %></td>
			</tr>			
		<%} %>
		
		</table>
	</body>
</html>