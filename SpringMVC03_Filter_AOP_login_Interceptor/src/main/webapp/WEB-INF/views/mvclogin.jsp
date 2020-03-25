<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

	$(function() {
		
		$("#loginchk").hide();
		
	});

	function login() {
		
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		
		console.log(memberid + " / " + memberpw);
		
		if(memberid == null || memberid == "" || memberpw == null || memberpw == "") {
			alert("아이디와 비밀번호를 모두 입력해주세요.");
		
		} else {
			
			var loginVal = {
					"memberid" : memberid,
					"memberpw" : memberpw
			}
			
			$.ajax({
				type: "POST",
				url: "ajaxlogin.do",
				data: JSON.stringify(loginVal),
				contentType: "application/json",
				dataType: "JSON",
				success: function(msg) {
					
					if(msg.check == true) {
						location.href="list.do";	
					} else {
						$("#loginchk").show();
						$("#loginchk").html("아이디 또는 비밀번호가 잘못되었습니다.");
					}
					
				},
				error: function() {
					alert("통신 실패");
				}
			});
		}
	}

</script>

</head>
<body>

	<h1>LOGIN</h1>

	<table>
		<tr>
			<th>아이디</th>
			<th><input type="text" id="memberid"></th>
		</tr>
		<tr>
			<th>비밀번호</th>
			<th><input type="password" id="memberpw"></th>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginchk"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="로그인" onclick="login();">
			</td>
		</tr>
	</table>

</body>
</html>