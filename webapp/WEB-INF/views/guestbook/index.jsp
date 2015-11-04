<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% 
	String newLine = "\n";
	pageContext.setAttribute("newLine", "\n");
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite3/assets/css/guestbook.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/mysite3/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
$(function(){
	$("#guestbook-form").submit(function(){
		
		if($("#name").val() == ""){
			alert("이름이 비어있습니다.");
			$("#name").focus();
			return false;
		}		
	});
});

</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<div id="content">
			<div id="guestbook">
				<form id="guestbook-form" action="/mysite3/guestbook/insert" method="post">
					<table class="table-gb">
						<tr>
							<td class="info"><input placeholder="이름" id ="name" class="textinput" type="text" name="name"></td>
							<td class="info"><input placeholder="비밀번호" id ="password" class="textinput" type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4 ><textarea name="message" id="textarea-content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				
				<ul>
					<li>
						<c:set var='count' value='${fn:length(list)}'></c:set>
						<c:forEach items='${list}' var="vo" varStatus="status">
						<table class="table-list">							
							<tr>
								<td class="content-view" colspan=4>
								${fn:replace(vo.message, newLine,'<br>')}
								</td>
							</tr>
							<tr>
								<td class="content-cnt">${count-status.index}</td>
								<td class="content-name">${vo.name}</td>
								<td class="content-date">${vo.regDate}</td>
								<td class="content-del"><a href="/mysite3/guestbook/deleteform/${vo.no}">delete</a></td>
							</tr>
						</table>
						</c:forEach>

						<br>
					</li>
				</ul>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</div>
</body>
</html>