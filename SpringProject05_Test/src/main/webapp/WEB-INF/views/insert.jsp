<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ginsert" method="post">
	<table align="center">
	<tr>
		<td>글쓴이</td>
		<td><input type="text" name="name" id="name"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" name="content" id="content" size="80"></td>
	</tr>
	<tr>
		<td>평가</td>
		<td>
		<input type="radio" name="grade" value="excellent" checked>아주잘함(excellent)
		<input type="radio" name="grade" value="good">잘함(good)
		<input type="radio" name="grade" value="normal">보통(normal)
		<input type="radio" name="grade" value="fail">노력(fail)
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="입력"></td>
	</tr>
	</table>
</form>

<div align="center">
	<a href="glist">전체보기</a>
</div>

</body>
</html>