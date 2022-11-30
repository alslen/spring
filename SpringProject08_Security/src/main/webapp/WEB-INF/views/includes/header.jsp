<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
<div class="container">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="/app07/">HOME</a>
  
  <!-- Links -->
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <a class="nav-link" href="/app07/insert">글쓰기</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="/app07/uploadFile">File</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/app07/fileInsert">FileBoardWriter</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/app07/fileList">FileBoard</a>
    </li>
  </ul>
  
  <!-- Links -->
  <ul class="navbar-nav">
  <c:choose>
  
  	<c:when test="${empty sessionScope.sMember}">
  	 <li class="nav-item">
      <a class="nav-link" href="/app07/member/join">회원가입</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/app07/member/login">로그인</a>
    </li>
  	</c:when>
  	
  	<c:otherwise>
  		<li class="nav-item">
      <a class="nav-link" href="/app07/member/update">회원변경</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="/app07/member/logout">로그아웃(${sessionScope.sMember.getId()})</a>
    </li>
  	</c:otherwise>
  	
  </c:choose>
  </ul>
  
 </div>
</nav>
