<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script> 
</head>
<body>
<h2>개인 정보 수정</h2>
<form action="person_update.go" method="post">
		이름 : <input type="text" name="name" value="${person.name}"> <br />
		아이디 : <input type="text" name="id" value="${person.id }" readonly="readonly"> <br /> 
		비밀번호 : <input type="password" name="password" value="${person.password }" readonly="readonly"> <br /> 
		성별 : 
		남자<input type="radio" name="gender" value='남' checked>
		여자<input type="radio" name="gender" value='여'><br>
		직업 : <select name="job" id="job">
				<option>학생</option>
				<option>공무원</option>
				<option>회사원</option>
				<option>기타</option>
			</select>
			<br> 
			<script>
				$("input:radio[value='${person.gender}']").prop("checked", true);
				
				$("#job option").each(function(){
					if($(this).val()=="{person.job}"){
						$(this).prop("selected", true)
					}
				})
			</script>
		<input type="submit" value='클릭' />
	</form>
</body>
</html>