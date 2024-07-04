<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String chk = null;
	String cookName="";
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("remember")){
				chk="checked";
				cookName = cookie.getValue();
				System.out.println("cookName : "+cookName);
			}
		}
	}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쿠키</title>
	</head>
	<body>
	 <!-- 쿠키 -->
	 <!--        co.jsp                               doco.jsp
	 	이름, 국어, 영어, 수학 체크 : 이름저장 -> 이름, 국어, 영어, 수학, 합계, 평균 입력창으로 이동
		체크박스, 전송버튼                    입력창 버튼을 클릭하면 이동
	 	이름은 자동으로 입력되도록 하시오.  	 
	  -->
	  <h2></h2>
	  <from action="doco.jsp" method="post">
	  <label>이름</label>
	  <input type="text" name="name" value=<%=cookName %>>
	  <input type="checkbox" name="remember" id="remember" <%=chk %> 
	  value="remember" checked>
	  <label for="remember">이름 저장</label>
	  <br>
	  <label>국어</label>
	  <input type="text" name="kor"><br>
	  <label>영어</label>
	  <input type="text" name="eng"><br>
	  <label>수학</label>
	  <input type="text" name="math"><br>
	  
	  <input type="submit" value="전송">
	  </from>  
	</body>
</html>