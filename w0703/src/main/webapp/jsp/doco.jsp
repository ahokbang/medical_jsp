<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
		table, th, td{border: 1px solid black; border-collapse : collapse;}
		th{width: 120px;}
		</style>
	</head>
	<body>
		<h2></h2>
		<table>
			<tr>
				<th>제목</th>
				<th>내용</th>				
			</tr>
			<tr>
				<td>이름</td>
				<td><%= request.getParameter("name") %></td>
			</tr>
			<tr>
				<td>국어</td>
				<td><%= request.getParameter("kor") %></td>				
			</tr>
			<tr>
				<td>영어</td>
				<td><%= request.getParameter("eng") %></td>				
			</tr>
			<tr>
				<td>수학</td>
				<td><%= request.getParameter("math") %></td>				
			</tr>
			<tr>
				<td>합계</td>
				<td><%= request.getParameter("kor+eng+math") %></td>				
			</tr>
			<tr>
				<td>평균</td>				
				<td><%= request.getParameter("(kor+eng+math)/3.0") %></td>								
			</tr>
			<%
			
			%>
			<a href="co.jsp">이전 페이지로 이동</a>
			
		</table>
	</body>
</html>