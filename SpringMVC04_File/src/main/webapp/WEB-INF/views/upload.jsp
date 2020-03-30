<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- modelAttribute : request로부터 찾을때 사용할 이름 -->
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		
		<h3>UPLOAD FORM</h3>
		
		file<br>
		<input type="file" name="mpfile">
		<br>
		
		<!-- 에러정보를 출력, path 속성에 지정된 프로퍼티와 관련된 에러 메세지를 출력할 수 있다. -->
		<p style="color: red; font-weight: bold;">
			<form:errors path="mpfile"></form:errors>
		</p>
		<br>
		
		description<br>
		<textarea rows="10" cols="60" name="desc"></textarea>
		<br>
		
		<input type="submit" value="SEND">
		
	</form:form>
	
	<!-- 
		enctype 속성
		1. application/www-form-urlencoded : 문자들이 encodin됨 (default)
		2. multipart/form-data : file upload 가능 (POST로 해야함)
		3. text/plain : encoding되지 않음
	 -->

</body>
</html>