<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
  <style>
div {
  border: 1px solid black;
  margin-top: 50px;
  margin-bottom:100px;
  margin-right:60;
  margin-left:50px;
  
  padding-top: 30px;
  padding-right: 50px;
  padding-bottom: 50px;
  padding-left: 50px;
}
h3 {text-align :center;}


</style>

	<head>
		<meta charset="utf-8">
		<title>메모 등록 폼</title>
	</head>
	<body>
	<div class="container text-center">
		<h3 > 메모 저장  </h3><br /><br />
		<form method="post" action="memo_save">
			 <input type ="text"  class="form-control" style="width:500px; display:inline;" placeholder="이름을 입력해주세요." name="name"/></b><br />
			<br /> <input type ="text"  class="form-control"  style="width:500px; display:inline;" placeholder="나이를 입력해주세요." name="age"/></b><br />
			<br /><input type ="submit" class="btn btn-outline-info" value ="메모 등록" /> &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;
			<a href = "memo_list" class="btn btn-outline-warning" value="메모리스트"> 메모 리스트 </a>
		</form>
		</div>
	</body>
</html>