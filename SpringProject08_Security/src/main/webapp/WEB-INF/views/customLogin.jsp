<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SpringBoard Login</h1>      
  </div>
</div>

<!-- 꼭 아이디의 name은 username, 비밀번호의 name은 password로 해줘야함. -->
<div class="container">
  <form action="/app08/login" method="post">
    <div class="form-group">
      <label for="username">아이디:</label>
      <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
    </div>
    
     <div class="form-group">
      <label for="password">비밀번호:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter Password" name="password">
    </div>
 
    <button class="btn btn-primary" id="btnLogin">로그인</button>
    <br><br>
  </form>
</div>

<%@include file="/WEB-INF/views/includes/footer.jsp" %>