<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite3/assets/css/user.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="post" action="/mysite3/user/login">
					<input placeholder="이메일" id="email" name="email" type="text" value="">
					<input placeholder="비밀번호" id="password" name="password" type="password" value="">

					<c:if test="${param.result == 'error'}">
					<p>
						로그인이 실패 했습니다.
					</p>
					</c:if> 

					<input type="submit" value="로그인">
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</div>
</body>
</html>