<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 

<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<head>
		<meta charset="utf-8">
		
		<title>메모 상세보기</title>
	</head>
	<body>
		<h4> 상세보기 </h4>
		<form action="memo_update" method="post"> 
			<input type="hidden"" class="form-control" name="memoid" value="${memo.memoid}"> <br />
			<input type ="text"  class="form-control" placeholder="이름을 입력해주세요." name="name" value="${memo.name}"/><br />
			<input type ="text"  class="form-control" placeholder="나이를 입력해주세요." name="age" value="${memo.age}"/><br />
			<input type ="submit" class="btn btn-outline-warning" value ="수정">
		
		<a href="memo_delete?memoid=${memo.memoid}" class="btn btn-outline-danger" > 삭 제  </a>
		<a href= memo_input class="btn btn-outline-info"> 메모 등록</a>
		</form>
	</body>
</html>