<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp" %>
    
<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SpringBoard Write</h1>      
  </div>
</div>
    
<div class = "container">
<form action="fileInsert" method="post" enctype="multipart/form-data">

	 <div class="form-group">
      	<label for="title">제목:</label>
      	<input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
    </div>
    
     <div class="form-group">
      	<label for="writer">글쓴이:</label>
      	<input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" value="${sessionScope.sMember.id}">
    </div>
    
     <div class="form-group">
      	<label for="content">내용:</label>
      	<textarea class="form-control" rows="5" id="content" name="content"></textarea>
    </div>
    
      <div class="form-group">
      	<label for="upload">파일:</label>
      	<input type="file" class="form-control" id="upload" placeholder="Enter File" name="upload">
    </div>
    
    <button type="submit" class="btn btn-primary">글쓰기</button>
 </form>
</div>

<%@include file="includes/footer.jsp" %>