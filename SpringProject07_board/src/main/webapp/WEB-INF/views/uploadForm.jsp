<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SpringBoard File</h1>      
  </div>
</div>

<div class="container">
<form action="fileAction" method="post" enctype="multipart/form-data">
	<input type="file" name="uploads"><br>
	<input type="file" name="uploads"><br>
	<input type="file" name="uploads"><br><br>
	<button>Submit</button>
</form>
</div>

<%@include file="includes/footer.jsp" %>