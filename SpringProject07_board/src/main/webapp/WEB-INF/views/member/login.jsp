<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SpringBoard Login</h1>      
  </div>
</div>

<div class="container">
  <form>
    <div class="form-group">
      <label for="id">아이디:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter userid" name="id">
    </div>
    
     <div class="form-group">
      <label for="pass">비밀번호:</label>
      <input type="password" class="form-control" id="pass" placeholder="Enter Password" name="pass">
    </div>
 
    <button type="button" class="btn btn-primary" id="btnLogin">로그인</button>
    <br><br>
  </form>
</div>

<script>
	$("#btnLogin").click(function(){
		$.ajax({
			type:'post',
			url:'/app07/member/login',
			contentType:'application/json;charset=utf-8',
			data:JSON.stringify({"id":$("#id").val(), "pass":$("#pass").val()})
		})
		.done(function(resp){
			if(resp=="no") {
				alert("회원이 아닙니다. 회원가입하세요.")
				location.href="join";
			} else if(resp=="success"){
				alert("로그인 성공")
				location.href="/app07/"
			} else {
				alert("비밀번호를 확인하세요")
			}	
		})
		.fail(function(e){
			alert("로그인 실패"+e)
		})
	})  // btnLogin
</script>
  
<%@include file="../includes/footer.jsp" %>