<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite3/assets/css/user.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="/mysite3/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
 /* 	$(function() {
		$("#join-form").submit(function() {
			//이름 체크
			if ($("#name").val() == "") {
				alert("이름이 비어있습니다.");
				$("#name").focus();
				return false;
			}

			//이메일 중복체크
			if ($("#checked").is(":visible") == false) {
				alert("이메일 중복체크를 해주세요.");
				$("#email").focus();
				return false;
			}

			//비밀번호
			if ($("#password").val() == "") {
				alert("비밀번호를 입력해주세요.");
				$("#password").focus();
				return false;
			}

			//약관동의
			if ($("#agree-prov").is(":visible") == false) {
				alert("약관에 동의해주세요.");
				return false;
			}

			return true;
		});

		$("#email").change(function() {
			$("#checked").hide();
			$("#btn-check").show();
		});

		$("#btn-check").click(function() {
			var email = $("#email").val();
			if (email == "") {
				return;
			}
			$.ajax({

				url : "/mysite3/api/member",
				type : "get",
				dataType : "json",
				data : "a=checkemail&email=" + email,
				contentType : 'application/json',
				success : function(response) {
					console.log(response);
					if (response.result == "fail") {
						console.error(response.message);
						return;
					}

					if (response.data == false) {
						alert("이미 가입된 이메일입니다.");
						$("#email").focus();
						return;
					}

					//등록 가능한 이메일 처리
					$("#checked").show();
					$("#btn-check").hide();

				},
				error : function(jqXHR, status, e) {
					alert(status + " : " + e);
				}
			});
		});
	}); */
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<div id="content">
			<div id="user">

				<form id="join-form" name="joinForm" method="post"
					action="/mysite3/user/modify">
					<p id="email-fix" style = "text-align:center">
					${vo.email}
					</p>	
					<input placeholder="${vo.name}" id="name" name="name" type="text" value="">
					<img id="checked" src="/mysite3/assets/images/checked.png" style="width: 15px; display: none"> 
					<input placeholder="비밀번호" id="password" name="password" type="password" value="">

					<fieldset>
						<label>성별 :</label> 
						<c:choose>
							<c:when test="${vo.gender == 'female'}">
								<label>여</label> <input type="radio" name="gender" value="female" checked="checked"> 
								<label>남</label> <input type="radio" name="gender" value="male">
							</c:when>
							<c:otherwise>
								<label>여</label> <input type="radio" name="gender" value="female"> 
								<label>남</label> <input type="radio" name="gender" value="male" checked="checked">
							</c:otherwise>
						</c:choose>						
					</fieldset>

					<input type="submit" value="수정하기">

				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</div>
</body>
</html>