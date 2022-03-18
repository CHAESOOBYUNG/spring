<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>점수결과</h3>
	<c:forEach var="vo" items="${list }" varStatus="num">
		번호:${num.index }
		이름:${vo.name }
		국어:${vo.kor }
		영어:${vo.eng }
		수학:${vo.math }	
		<button type="button" onclick="location.href='scoreDelete?num=${num.index}' ">삭제하기</button>
		<br>
	</c:forEach>
	
	<a href="scoreRegist">추가 등록하기</a>
	
	<script>
		var msg = '${msg}'; //msg값이 없다면 공백문자
		if(msg != ''){
			alert(msg);
		}
		
	</script>
	
</body>
</html>