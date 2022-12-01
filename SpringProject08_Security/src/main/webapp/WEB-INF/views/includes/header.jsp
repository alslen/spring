<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> <!-- security를 사용하기 위해 taglib를 사용함. -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Project</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-success navbar-dark">
<div class="container">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="/app08/">HOME</a>
  
  <!-- Links -->
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <a class="nav-link" href="/app08/board/insert">글쓰기</a>
    </li>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
	    <li class="nav-item">
	      <a class="nav-link" href="#">Product</a>
	    </li>
    </sec:authorize>
  </ul>
  
  <sec:authentication property="principal" var="pinfo"/> <!-- principal은 ContextHolder안에 있는 값들을 총징함 -->
   <ul class="navbar-nav">
   <sec:authorize access="isAnonymous()">  <!-- 접근권한 : 누구나 -->
	    <li class="nav-item">
	      <a class="nav-link" href="/app08/customLogin">로그인</a>
	    </li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()"> <!-- 접근권한 : ContextHolder안에 있으면 -->
	     <li class="nav-item">
	      <a class="nav-link" href="/app08/customLogout">로그아웃(${pinfo.username})</a>
	      <!-- 로그아웃(<sec:authentication property="principal.username"/>) : 둘 다 같은 결과가 출력됨.-->
	    </li>
    </sec:authorize>
    </ul>
  
 </div>
</nav>
