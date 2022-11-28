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
			<td><a href="view/${board.num}">${board.title}[${board.replyCnt}]</a></td>
			<td>${board.writer}</td>
			<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
			<td>${board.hitcount}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<!-- 페이징처리 -->
<div class="d-flex justify-content-between"> <!-- 양쪽으로 두겠다. -->
 <ul class="pagination mt-3">
 	<!-- 이전 -->
 	<c:if test="${p.startPage > p.blockPage}">
 		<li class="page-item"><a class="page-link" href="list?PageNum=${p.startPage-p.blockPage}">Previous</a></li>
 	</c:if>
    
    <!-- 페이지 -->
    <c:forEach begin="${p.startPage}" end="${p.endPage}" var="i">
	    <c:if test="${p.currentPage==i}">
	    	<li class="page-item active"><a class="page-link" href="#">${i}</a></li>
	    </c:if>
	     <c:if test="${p.currentPage!=i}">
	    	<li class="page-item"><a class="page-link" href="list?PageNum=${i}">${i}</a></li>
	    </c:if>
    </c:forEach>
    
    <!-- 다음 -->
    <c:if test="${p.endPage < p.totPage}">
    	<li class="page-item"><a class="page-link" href="list?PageNum=${p.endPage+1}">Next</a></li>
    </c:if>
  </ul>

	<form class="form-inline" action="/app07/list" method="get">
			<select name="field" id="field" class="form-control mr-sm-1">
				<option value="writer">작성자</option>
				<option value="content">내용</option>
			</select>
			<input type="text" name="word" id="word" class="form-control" placeholder="Search">  
			<button class="btn btn-secondary">Search</button>
	</form>
</div>

</div>

<%@include file="includes/footer.jsp" %>
    