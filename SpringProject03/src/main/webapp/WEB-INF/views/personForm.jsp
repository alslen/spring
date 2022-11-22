<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insert" method="post">
		이름 : <input type="text" name="name"> <br />
		아이디 : <input type="text" name="id"> <br /> 
		패스워드 : <input type="password" name="password"><br/>
		성별 : 
		남자<input type="radio" name="gender" value='남' checked>
		여자<input type="radio" name="gender" value='여'><br>
		직업 : <select name="job">
				<option>학생</option>
				<option>공무원</option>
				<option>회사원</option>
				<option>기타</option>
			</select>
			<br> 
		<input type="submit" value='클릭' />
	</form>
</body>
</html>