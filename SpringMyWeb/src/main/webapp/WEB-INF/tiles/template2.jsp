<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--타일즈 태그를 사용하기 위한 선언 --%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<tiles:insertAttribute name="header"/>
	
	<tiles:insertAttribute name="body"/>
	
</body>
</html>