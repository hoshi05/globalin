<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>    <!-- jsp선언문 -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3> Input Element </h3>
		<form method="post" action ="input_01">       <!-- form태그는 서버한테 정보(입력값)를 전송할 때 사용 --> <!-- action은 내가 가고자하는 주소 작성 -->
			 이름  <input type = "text" name ="username" />
			비밀번호  <input type = "password" name="password" />
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