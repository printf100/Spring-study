<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시물 목록</h1>
	
	<table border="1">
		<colgroup>
			<col width="50">
			<col width="200">
			<col width="100">
			<col width="300">
		</colgroup>
		
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		
		<tbody>
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="4" align="center">작성된 글이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list }" var="list">
						<tr>
							<td>${list.MYNO }</td>
							<td><a href="detail.do?MYNO=${list.MYNO }">${list.MYTITLE }</a></td>
							<td>${list.MYNAME }</td>
							<td>${list.MYDATE }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		
		<tfoot>
			<tr>
				<td colspan="4" align="right">
					<input type="button" value="글 작성하기" onclick="location.href='writepage.do'">
				</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>