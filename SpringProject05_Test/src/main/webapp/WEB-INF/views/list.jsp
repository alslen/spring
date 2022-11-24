<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest List</title>
</head>
<body>
<h2>Guest List(${count})</h2>

<c:forEach items="${guest}" var="guest">
	이름 : ${guest.name }<br>
	내용 : ${guest.content }<br>
	평점 : ${guest.grade }<br>
	날짜 : ${guest.created}<br><br>
</c:forEach>

<form action="glist">
	<select name="field">
		<option value="name">이름</option>
		<option value="content">내용</option>
	</select>
	<input type="text" name="word">
	<input type="submit" value="찾기">
</form>

</body>
</html>