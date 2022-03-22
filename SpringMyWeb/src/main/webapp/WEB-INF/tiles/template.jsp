<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--타일즈 태그를 사용하기 위한 선언 --%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 부트스트랩 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css">
	<script src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
	
	<!-- 개인디자인 -->
	<link rel="stylesheet" href="/myweb/resources/css/style.css">

</head>
<body>

	<!-- 화면템플릿을 사용하기 위한 모형 -->
	<%-- 
	<tiles:insertAttribute name="타일즈에 선언된 이름"/>
	--%>
	
	<tiles:insertAttribute name="header"/>
	
	<tiles:insertAttribute name="body"/>
	
	<tiles:insertAttribute name="footer"/>
	
</body>
</html>