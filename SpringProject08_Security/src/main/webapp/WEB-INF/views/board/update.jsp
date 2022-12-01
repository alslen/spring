<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SpringBoard Update</h1>      
  </div>
</div>

<div class = "container">
<input type="hidden" id="num" name="num" value="${board.num }"/> <!-- num값은 기본키이기 때문에 반드시 넘겨줘야함 -->
	 <div class="form-group">
      	<label for="userid">title:</label>
      	<input type="text" class="form-control" id="title" placeholder="Enter title" name="title" value=${board.title }>
    </div>
    
     <div class="form-group">
      	<label for="subject">writer:</label>
      	<input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" value="${board.writer}" readonly="readonly">
    </div>
    
     <div class="form-group">
      	<label for="content">Content:</label>
      	<textarea class="form-control" rows="5" id="content" name="content">${board.content}</textarea>
    </div>
    <button type="button" class="btn btn-primary" id="btnModify">수정하기</button>
</div>

<script>
	$("#btnModify").click(function(){
		data = {
				"num" : $("#num").val(),
				"title" : $("#title").val(),
				"content" : $("#content").val(),
		}
		$.ajax({
			type:'put',
			url:'/app08/board/update',
			contentType:"application/json;charset=utf-8",
			data:JSON.stringify(data),
			success:function(resp){
				alert("수정완료")
				location.href="/app08/board/list";
			},
			error:function(e){
				alert("수정실패 : "+e)
			}
		})  // ajax
	})  // btnModify
</script>

<%@include file="../includes/footer.jsp" %>