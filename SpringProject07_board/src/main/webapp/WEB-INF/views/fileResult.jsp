<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SpringBoard FileUpload</h1>      
  </div>
</div>

<div class="container">
<c:forEach items="${uploadFileName}" var="file">
	uploadFileName : ${file}<br>
</c:forEach>
</div>

<%@include file="includes/footer.jsp" %>