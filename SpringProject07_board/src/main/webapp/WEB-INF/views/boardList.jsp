<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="includes/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>SpringBoard List(${count })</h1>      
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
			<td><a href="view/${board.num}">${board.title}</a></td>
			<td>${board.writer}</td>
			<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
			<td>${board.hitcount}</td>
		</tr>
	</c:forEach>
	</tbody>

</table>

<!-- <form action="list">
		<select name="field" id="field">
			<option value="title">제목</option>
			<option value="writer">작가</option>
		</select>
		<input type="text" name="word" id="word">  
		<input type="submit" value="찾기">
</form> -->
</div>

<%@include file="includes/footer.jsp" %>
    