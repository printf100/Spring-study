<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>UPDATE</h1>
	
	<form action="update.do" method="POST">
		<input type="hidden" name="MYNO" value="${dto.MYNO }">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="MYNAME" value="${dto.MYNAME }"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="MYTITLE" value="${dto.MYTITLE }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="40" name="MYCONTENT">${dto.MYCONTENT }</textarea></td>
			</tr>
		</table>
		
		<input type="submit" value="수정하기">
	</form>

</body>
</html>