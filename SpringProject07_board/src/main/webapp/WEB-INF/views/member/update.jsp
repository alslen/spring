<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SpringBoard MemberUpdate</h1>      
  </div>
</div>

<div class = "container">
	 <div class="form-group">
      	<label for="id">아이디:</label>
      	<input type="text" class="form-control" id="id" placeholder="Enter id" name="id" value="${sMember.id}" readonly="readonly">
    </div>
    
     <div class="form-group">
      <label for="pass">비밀번호:</label>
      <input type="password" class="form-control" id="pass" placeholder="Enter pass" name="pass" readonly="readonly" value="${sMember.pass}">
    </div>
    
     <div class="form-group">
      <label for="pass_check">비밀번호 확인:</label>
      <input type="password" class="form-control" id="pass_check" placeholder="Enter Password_Check" name="pass_check" >
    </div>
    
    <div class="form-group">
      <label for="name">이름:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${sMember.name}">
    </div>
   
    <div class="form-group">
      <label for="addr">주소:</label>
      <input type="text" class="form-control" id="addr" placeholder="Enter addr" name="addr" value="${sMember.addr}">
    </div>
    
    <button type="button" class="btn btn-primary" id="btnModify">수정하기</button>
</div>

 <script>
  	$("#btnModify").click(function(){
  		// 유효성 검사
  		if($("#pass").val()==""){
  			alert('비밀번호를 입력해주세요')
  			$("#pass").focus();
  			return false;
  		}
  		if($("#pass").val()!=$("#pass_check").val()){
  			alert('비밀번호가 일치하지 않습니다.')
  			$("#pass_check").focus();
  			return false;
  		}
  		if($("#name").val()==""){
  			alert('이름을 입력해주세요')
  			$("#name").focus();
  			return false;
  		}
  		if($("#addr").val()==""){
  			alert('주소를 입력해주세요')
  			$("#addr").focus();
  			return false;
  		}
  		
  		data = {
  				"id" : $("#id").val(),
  				"pass" : $("#pass").val(),
  				"name" : $("#name").val(),
  				"addr" : $("#addr").val()
  		}
  		$.ajax({
  			type:'put',
  			url:'/app07/member/update',
  			contentType:'application/json;charset=utf-8',
  			data:JSON.stringify(data)  // 제이슨 형태로 값을 전달
  		}) // ajax
  		.done(function(resp){
  			if(resp=="success") {
  				alert("회원변경 성공.")
  				location.href="login"
  			}
  		})  // done
  		.fail(function(){
  			alert("회원변경 실패.")
  		})
  	})  // btnJoin
  </script>

<%@include file="../includes/footer.jsp" %>