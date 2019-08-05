<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				/* radio */
				var gender = "${gender}";
				
				$('input[type=radio]').each(function(){
					if(gender==$(this).val()){
						$(this).attr('checked','checked');
					}
				});
				/* checkbox */
				<c:forEach var="vehicle" items="${vehicles}">
					var value='<c:out value="${vehicle}"/>';
					
					$('input[type=checkbox]').each(function(){
						if(value==$(this).val()){
							$(this).attr('checked','checked');
						}
					});					
				</c:forEach>			
				/* select */
				var cars = "${cars}";
				
				$('option').each(function(){
					if(cars==$(this).val()){
						$(this).attr('selected','selected');
					}
				});
					
			}); 
					
		</script>
	</head>
	<body>
		<h3> Result Element </h3>
		<form method="post" action ="input_01">
			 이름  <input type = "text" name ="username" value="${name}" />
			비밀번호  <input type = "password" name="password" value="${password}" />
			<input type = "reset" /><input type = "submit" />
			
		</form>
		
		<form method="post" action ="input_02">
			<input type = "radio" name="gender" value="male"> 남자
			<input type = "radio" name="gender" value="fmale"> 여자
			<input type = "radio" name="gender" value="other"> 기타
			<input type = "submit" />		
		</form>
		
		<form method="post" action ="input_03">
			<input type = "checkbox" name="vehicle" value="Bike"> 자전거
			<input type = "checkbox" name="vehicle" value="Car"> 자동차
			<input type = "checkbox" name="vehicle" value="Subway"> 지하철
			<input type = "checkbox" name="vehicle" value="Bus"> 버스
			<input type = "submit" />
		</form>		
		
		<form method="post" action="select">
			<select name = cars>
				<option value="volvo"> Volvo </option>
				<option value="audi"> Audi </option>
				<option value="bmw"> Bmw </option>
			</select>
			<input type ="submit" />
		</form>
		
		<form method="post" action="textarea">
			<textarea name="message" row="50" cols="70" ></textarea>
			<input type ="submit" />
		</form>	
	</body>
</html>