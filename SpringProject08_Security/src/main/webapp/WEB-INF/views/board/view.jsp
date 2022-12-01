<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/includes/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>SecurityBoard View</h1>      
  </div>
</div>

<div class = "container">
<table class="table">
<input type="hidden" id="num" name="num" value="${board.num}"/>
	<tr>
		<th>번호</th>
		<td>${board.num }</td>
		<th>조회수</th>
		<td>${board.hitcount}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${board.writer }</td>
		<th>작성일</th>
		<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
	</tr>
	<tr>
		<th>글제목</th>
		<td colspan="3">${board.title }</td>
	</tr>
	<tr>
		<th>글내용</th>
		<td colspan="3">${board.content }</td>
	</tr>
	<tr>
		<td colspan="4" align="right">
		<sec:authorize access="isAuthenticated()"> <!-- 권한이 있을 때 밑에 부분이 실행됨-->
		<c:if test="${pinfo.username == board.writer }">
			<button type="button" class="btn btn-success" id="btnUpdate">수정</button>
			<button type="button" class="btn btn-success" id="btnDelete">삭제</button>
		</c:if>
		</sec:authorize>
		</td>
	</tr>
</table>

	<br>
	<br>
	<div align="center">
		<textarea rows="3" cols="50" id="msg"></textarea>
		<button type="button" class="btn btn-success" id="btnComment">댓글쓰기</button>
	</div>
	<hr/>
	<div id="replyResult"></div>
	<sec:authorize access="isAnonymous()">
		<input type="hidden" id="prin" name="prin" value="null">
	</sec:authorize>
	
</div>

<script>

// 댓글 삭제
function fdel(cnum){
	$.ajax({
		type:"DELETE",
		url:"/app08/reply/commentDelete/"+cnum
	})
	.done(function(resp){
		alert(resp+"번 글 삭제 완료")
		init();
	})
	.fail(function(e){
		alert("댓글 삭제 실패 : "+e)
	})
}
// 댓글 보기
var init = function(){
	$.ajax({
		type:'get',
		url:'/app08/reply/commentList/${board.num}'
	})
	.done(function(resp){
		str = "댓글("+resp.count+")<br/>";
		
		$.each(resp.carr, function(key,val){
			str += val.userid+" "
			str += val.content+" "
			str += val.regdate+" "
			<sec:authorize access="isAuthenticated()">
			if("${pinfo.username}"==val.userid){
				str += "<a href='javascript:fdel("+val.cnum+")'>삭제</a>"
			}
			</sec:authorize>
			str += "<br/>"
			
		})
		$("#replyResult").html(str)
	})
	.fail(function(e){
		alert("실패")
	})
}
		// 삭제
		$("#btnDelete").click(function(){
			if(!confirm('정말 삭제할까요?')){
				return false;
			}
			$.ajax({
				type:"DELETE",
				url:"/app08/board/delete/${board.num}",
				success:function(resp){
					if(resp=="success") {
						alert("삭제성공")
						location.href="/app08/board/list"
					}
				},
				error : function(e){
					alert("삭제 실패 : "+e)
				}
			}) // ajax
		}) // btnDelete 
		
	// 수정폼
	$("#btnUpdate").click(function() {
		if(!confirm("정말 수정할까요?"))
			return false;
		location.href="/app08/board/update/${board.num}"
	})
	
	// 댓글 추가
	$("#btnComment").click(function(){
		if($("#prin").val()=="null"){
			alert("로그인하세요")
			location.href="/app08/customLogin"
			return;
		}
		
		if($("#msg").val()==""){
			alert("댓글입력")
			return;
		}
		dataStr={
				"bnum" : $("#num").val(),
				"content" : $("#msg").val(),
				<sec:authorize access="isAuthenticated()">
				"userid" : "${pinfo.username}"
				</sec:authorize>
		};
		$.ajax({  // commentInsert
			type:'post',
			url:'/app08/reply/commentInsert',
			contentType:'application/json;charset=utf-8',
			data:JSON.stringify(dataStr)
		})
		.done(function(){
			alert("댓글 추가 성공")
			init();
		})
		.fail(function(e){
			alert("댓글 추가 실패 : "+e)
		})
	})
	init();
</script>

<%@include file="/WEB-INF/views/includes/footer.jsp" %>
