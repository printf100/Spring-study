<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>DETAIL</h1>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<td>${dto.MYNAME }</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${dto.MYDATE }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.MYTITLE }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="20" cols="40" readonly="readonly">${dto.MYCONTENT }</textarea></td>
		</tr>
	</table>
	
	<input type="button" value="삭제" onclick="location.href='delete.do?MYNO=${dto.MYNO }'">
	<input type="button" value="수정" onclick="location.href='updatepage.do?MYNO=${dto.MYNO }'">

</body>
</html>