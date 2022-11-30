<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>all</h3>
		<p>principal : <sec:authentication property="principal"/></p>
		<p>Member : <sec:authentication property="principal.member"/></p>
		<p>사용자 이름 : <sec:authentication property="principal.member.username"/></p>
		<p>사용자ID : <sec:authentication property="principal.member.userid"/></p>
		<p>사용자ID(username) : <sec:authentication property="principal.username"/></p> <!-- principal을 가지는 username은 우리가 만든 userid가 됨 -->
		<p>권한 : <sec:authentication property="principal.member.authList"/></p>
</body>
</html>