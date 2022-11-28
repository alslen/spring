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
<input type="hidden" name="num" id="num" value="${board.num}"> <!-- num값을 넘겨줘야함. -->
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
	
	<br>
	<br>
	<div align="center">
		<textarea rows="3" cols="50" id="msg"></textarea>
		<button type="button" class="btn btn-primary" id="btnComment">댓글쓰기</button>
	</div>
	<hr/>
	<div id="replyResult"></div>
	
</div>

<script>
var init = function(){
	$.ajax({
		type:'get',
		url : '/app07/reply/commentList/${board.num}'
	/*	url:'/app07/reply/commentList',
		data:{"bnum" : $("#num").val()} */
	})
	.done(function(resp){
		var str = "";
		$.each(resp, function(key,val){
			str += val.userid+" "
			str += val.content+" "
			str += val.regdate+" "
			str += "<a href='javascript:fdel("+val.cnum+")'>삭제</a><br/>"
		})  // each
		$("#replyResult").html(str);
	})  // done
	.fail(function(e){
		alert("실패")
	})  // fail
}  // init

// 댓글삭제
function fdel(cnum) {
	$.ajax({
		type:"Delete",
		url:"/app07/reply/delete/"+cnum
	})
	.done(function(resp){
		alert(resp+"번 글 삭제 완료")
		init()
	})
	.fail(function(e){
		alert("댓글 삭제 실패 : "+e)
	})  // ajax
}  // fdel

// 댓글쓰기
$("#btnComment").click(function(){
	if($("#msg").val()==""){
		alert("댓글 입력하세요");
		return;
	}
	data = {
			"bnum": $("#num").val(),  // num의 값을 bnum에 담음
			"content":$("#msg").val()
	}
	$.ajax({
		type:"post",
		url:'/app07/reply/commentInsert',
		contentType:"application/json;charset=utf-8",
		data:JSON.stringify(data),  // JSON형태로 값을 전달
		success : function(resp){
			if(resp=="success")	alert("댓글 추가 성공")
			init();
		},
		error:function(){
			alert("댓글 추가 실패")
		}
	})  // ajax
})  // btnComment


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

init();  // init함수는 댓글을 쓰든 안쓰든 보여야하기 때문에 선언해줌.

</script>
	
<%@include file="includes/footer.jsp" %>