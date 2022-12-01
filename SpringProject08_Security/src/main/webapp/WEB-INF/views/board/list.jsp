<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/includes/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>SecurityBoard List(${count })</h1>      
  </div>
</div>

<div class="container mt-5">
	<table class="table table-hover">	
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${board}" var="board">
				<tr>
					<td>${board.num}</td>
					<td><a href="view/${board.num}">${board.title}[${board.replyCnt}]</a></td>
					<td>${board.writer}</td>
					<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
					<td>${board.hitcount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@include file="/WEB-INF/views/includes/footer.jsp" %>