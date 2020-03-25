<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

	$(function() {
		
		$("#result").hide();
		$("#join").hide();
		
	});
	
	function idchk() {
		
		var memberid = $("#memberid").val().trim();
		
		var idchkVal = {
				"memberid" : memberid
		}
		
		if(memberid != null && memberid != "") {
			
			$.ajax({
				type: "POST",
				url: "ajaxidchk.do",
				data: JSON.stringify(idchkVal),
				contentType: "application/json",
				dataType: "JSON",
				success: function(msg) {
					
					if(msg.result == true) {
						$("#idchk").show().html("중복된 아이디입니다.");
					} else {
						$("#idchk").show().html("사용 가능한 아이디입니다.");
					}
				},
				error: function() {
					alert("아이디 중복체크 통신 실패");
				}
			});
			
		}
	}
	
	function join() {
		
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		var membername = $("#membername").val().trim();
		
		if(memberid == null || memberid == "" || memberpw == null || memberpw == "" || membername == null || membername != "") {
			alert("모두 입력해주세요.");
		} else {
			var joinVal = {
					"memberid" : memberid,
					"memberpw" : memberpw,
					"membername" : membername
			}
			
			$.ajax({
				type: "POST",
				url: "ajaxjoin.do",
				data: JSON.stringify(joinVal),
				contentType: "application/json",
				dataType: "JSON",
				success: function(msg) {
					
					if(msg.result == true) {
						location.href = "loginpage.do";
					} else {
						$("#join").show().html("회원가입을 실패했습니다.");
					}
				},
				error: function() {
					alert("회원가입 통신 실패");
				}
			});
		}
	}

</script>

<body>

	<h1>JOIN</h1>

	<table>
		<tr>
			<th>아이디</th>
			<th><input type="text" id="memberid"></th>
			<th><input type="button" value="중복체크" onclick="idchk();"></th>
		</tr>
		<tr>
			<td colspan="2" align="center" id="idchk"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<th><input type="password" id="memberpw"></th>
		</tr>
		<tr>
			<th>이름</th>
			<th><input type="text" id="membername"></th>
		</tr>
		<tr>
			<td colspan="2" align="center" id="join"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="회원가입" onclick="join();">
			</td>
		</tr>
	</table>

</body>
</html>