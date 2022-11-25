<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>

<script>
$(function() {
	loadData("","");  // 시작하자마자 DB에 들어있는 값들을 부르기 위해서 
	$("#send").click(function(){
		var postString = {
			"name" : $("#name").val(),
			"content" : $("#content").val(),
			"grade" : $("input:radio[name=grade]:checked").val()
		}
		$.ajax({
			type:"post",
			url: "insert",
			contentType:"application/json;charset=utf-8", //전달하고자 하는 형태가 json형태의 문자열이라는 것을 알려줌
			data:JSON.stringify(postString),  // stringify : JSON형태의 문자열로 바꿔줌
			success:function(resp){
				alert(resp)
				loadData("","");
			},
			beforeSend:showRequest,
			error:function(e) {
				alert("실패" + e)
			}
		})  // ajax
	})  // send
	
	$("#btnSearch").click(function(){
		loadData($("#field").val(),$("#word").val());
	})
})  //document

function loadData(field, word){
	$.getJSON(
			"list",
			{"field":field, "word":word},  // 값을 list에 넘겨줘야함
			function(resp) {
				var str="<br>";
				$("#cntDiv").text("개수 : "+resp.count)
				$.each(resp.arr, function(key,val){
					str += val.num+"  "
					str += "<a href='javascript:fview("+val.num+")'>"+val.name+"</a>  "
					str += val.content+"  "
					str += val.grade+"  "
					str += "<a href='javascript:fdelete("+val.num+")'>삭제</a><br/>"  // 자바스크립트를 부를려면 javascript를 입력해야함.
				})
				$("#result").html(str)
				
			} //resp
	)  //getJSON
}  //loadData

// 삭제
function fdelete(num){
	$.ajax({
		type:"DELETE",
		url : "delete/"+num,  // delete / 숫자 => restful
		success:function(resp){
			if(resp=="success") {
				alert("삭제성공")
				loadData("","");
			}
		},
		error : function(e){
			alert("삭제실패 : " + e)
		}
	})  //ajax
}  // fdelete


// 상세보기
function fview(num) {
	$.getJSON("view", {"num" : num}, function(val) {
		var str="";
		str += "이름 : "+val.name+" / "
		str += "내용 : "+val.content+" / "
		str += "등급 : "+val.grade+" / "
		str += "작성일자 : "+val.created+" "
		$("#viewDiv").html(str)
	})
} 

// 값을 입력하지 않았을 때
function showRequest(){
	if($("#name").val()==""){
		alert("글쓴이를 입력하세요")
		$("#name").focus();
		return false;
	}
	if(!$("#content").val()){
		alert("내용을 입력하세요")
		$("#content").focus();
		return false;
	}
	if($("input:radio[name=grade]:checked").length==0) { 
		alert("평가하세요")
		return false;
	}
	return true;
}

</script>
</head>
<body>
<form action="insert" method="post">
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
		<td colspan="2"><input type="button" value="입력" id="send"></td>
	</tr>
	</table>
	<div align="center">
		<select name="field" id="field">
			<option value="name">이름</option>
			<option value="content">내용</option>
		</select>
		<input type="text" name="word" id="word">
		<input type="button" value="찾기" id="btnSearch">
	</div>
</form>
<hr>

<div id="cntDiv"></div> <!-- 이 영역에 DB에 들어가 있는 값을 넣을 것임 -->
<div id="result"></div>
<hr>
<div id="viewDiv"></div>

</body>
</html>