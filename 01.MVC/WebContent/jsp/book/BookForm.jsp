<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>출판사 선택하기</title>
	</head>
	<body>
	<h3>출판사 선택하기</h3>
		<form>
			<select name = publisher>
			<c:forEach var="publisher" items="${publisher}">
				<option value="${publisher.publisher}">${publisher.publisher}</option>
			</c:forEach>
			</select>
			<input type ="submit"  value ="제출" />
		</form>	
	</body>
</html>