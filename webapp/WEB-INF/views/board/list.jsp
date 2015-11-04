<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite3/assets/css/board.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value=""> <input type="submit" value="찾기">
				</form>
				<table id="hoverboard" class="tbl-ex" >
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:set var='count' value='${fn:length(list)}'></c:set>
					<c:forEach items='${list}' var="list" varStatus="status">
						<tr>
							<td id ="center">${count-status.index}</td>
							<td id ="title" style="padding-left: ${(list.depth -1)*10}px">
							<c:if test="${list.depth > 1}">
								<img src="/mysite3/assets/images/reply.png" style="width:20px">
							</c:if>
							<a href="/mysite3/board/view/${list.no}">${list.title}</a></td>
							<td>${list.memberName}</td>
							<td id ="center">${list.viewCnt}</td>
							<td>${list.regDate}</td>
							<td><c:choose>
									<c:when
										test="${(not empty authUser) && (authUser.no == list.memberNo)}">
										<a href="/mysite3/board/delete/${list.no}" class="del">삭제</a>
									</c:when>
									<c:otherwise>
							&nbsp;
						</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</table>
				
				<div class="pager">
					<ul>
						<li class="pg-prev"><a href="">◀ 이전</a></li>
						<li><a href="">11</a></li>
						<li><a href="">12</a></li>
						<li>13</li>
						<li><a href="">14</a></li>
						<li><a href="">15</a></li>
						<li class="pg-next"><a href="">다음 ▶</a></li>
					</ul>
				</div>
				
				<div class="bottom">
					
					<c:choose>
						<c:when test="${not empty authUser}">
							<a href="/mysite3/board/write" id="new-book">글쓰기</a>
						</c:when>
						<c:otherwise>
						&nbsp;
					</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</div>
</body>
</html>