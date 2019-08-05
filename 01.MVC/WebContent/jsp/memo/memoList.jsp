<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html >
<html>
	<head>
		  <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<title> 메모 리스트 </title><br />
	</head>
	<style>
	div {
 		table class = text-center;
	}

	#select{
		font-size : 50px;	
	}
	
</style>	
	
	
	<body>
		<div class="container">
		<h2>메모 리스트</h2>
		<div style="text-align:right">
		<form action="memo_search" method="post">
			<input type="text"  placeholder="이름을 입력해주세요." class="form-control" style="width:500px; display:inline; " name="name" /> 
			<input type="submit"  class="btn btn-outline-success" value="검　색">
		</form>
		</div>
		
		<c:if test="${empty memos}"> 
			<hr />
			검색된 결과가 존재하지 않습니다. </c:if>
			<hr />
		<c:if test="${!empty memos}"> 
		
		<table class="table table-bordered table-sm" style="text-align: center;">
			<thead>
			      <tr>
			        <th> 메모 번호 </th>
			        <th> 이      름  </th>
			        <th> 나      이 </th>
			        <!-- <td> 상세 보기 </td> -->
			      </tr>			
				<c:forEach var="memo" items="${memos}">
				<tr>
					<td>${memo.memoid}</td>
					<td><a href="memo_detail?memoid=${memo.memoid}">${memo.name}</a></td>
					<td>${memo.age}</td>
					<%-- td><a href="memo_detail?memoid=${memo.memoid}">상세보기 버튼</a></td> --%> <!-- 물음표 다음에 파라미터값(memoid=${memo.memoid})이 옴 -->
				</tr>
				</c:forEach>				
			</table>
		</c:if>
	<!-- 페이징 처리 부분 -->
		<c:if test="${pageGroupResult.beforePage}">
		<a href="memo_req_list?reqPage=${pageGroupResult.groupStartNumber-1}"> ◀</a>
		</c:if>
			
		<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
			<c:choose>
			<c:when test="${pageGroupResult.selectPageNumber==index}">
				<span id="select"><a href="memo_req_list?reqPage=${index}">${index}</a></span>
			</c:when>
			<c:otherwise>	
				<a href="memo_req_list?reqPage=${index}">${index}</a>
			</c:otherwise>	
			</c:choose>					
		</c:forEach>
					
		<c:if test="${pageGroupResult.afterPage}">
			<a href="memo_req_list?reqPage=${pageGroupResult.groupEndNumber+1}"> ▶</a>
		</c:if>
			
			
		<br />			
		<br />		
		<a href= memo_input class="btn btn-outline-info"> 메모 등록</a>
		<a href= index.jsp class="btn btn-outline-secondary"> 메인으로 </a>
		</div>
	</body>
</html>