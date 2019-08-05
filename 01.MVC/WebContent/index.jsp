<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title> MEMO </title>
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style type="text/css">

* {text-align: center;}

div {
  border: 1px solid black;
  margin-top: 50px;
  margin-bottom:15px;
  margin-right:0px;
  margin-left:0px;
  
  padding-top: 30px;
  padding-right: 0px;
  padding-bottom: 50px;
  padding-left: 0px;
}
</style>

	</head>
	<body>
	<div class="container">
		<h3> 메모  </h3><br /><br/>
		
			<a href = "memo_input" class="btn btn-outline-primary">메모　저장</a><br /><br />
			<a href = "memo_list" class="btn btn-outline-primary"> 메모　리스트 </a><br /><br />
			<a href = "memo_req_list?reqPage=1" class="btn btn-outline-primary"> 메모 요청 리스트 </a><br /><br />
			<a href = "inputForm" class="btn btn-outline-primary"> input 화면으로 가기 </a><br /><br />
			<a href = "publisher_select" class="btn btn-outline-primary"> 출판사 선택하기</a><br /><br />
		
	</body>
</html>