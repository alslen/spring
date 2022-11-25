<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="includes/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin:">
    <h1>SpringBoard Detail</h1>      
  </div>
</div>

<div class = "container">
	<table class="table">
	<tr>
		<th>번호</th>
		<td>${board.num }</td>
		<th>조회수</th>
		<td>${board.hitcount }</td>
	<tr>
	
	<tr>
		<th>작성자</th>
		<td>${board.writer }</td>
		<th>작성일</th>
		<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
	<tr>

	<tr>
		<th>글제목</th>
		<td colspan="3">${board.title }</td>
	<tr>
	<tr>
		<th>글내용</th>
		<td colspan="3">${board.content}</td>
	<tr>
	<tr>
		<td colspan="4">
			<button type="button" class="btn btn-primary" id="btnUpdate">수정</button>
			<button type="button" class="btn btn-primary" id="btnDelete">삭제</button>
			<a href="/app07/delete/${board.num}">삭제</a>
		</td>
	</tr>
	</table>
</div>

<script>
// 수정폼
$("#btnUpdate").click(function() {
	if(!confirm('정말 수정할까요?'))  // false
		return false;
	location.href="/app07/update/${board.num}";
})

// 삭제
$("#btnDelete").click(function() {
	if(!confirm('정말 삭제할까요?')){  // false
		return false;
	}
	$.ajax({
		type:"DELETE",  // DELETE타입으로 넘기기 때문에
		url:"/app07/delete/${board.num}",
		success:function(resp){
			if(resp=="success"){
				alert("삭제성공")
				location.href="/app07/list"
			}
		},
		error:function(e){
			alert("삭제 실패 : "+e)
		}
	})  // ajax
})  // btnDelete

</script>
	
<%@include file="includes/footer.jsp" %>