<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 목록</title>
<style>
	table{		
		border:1px solid #222;		
	}
	
	th{
		background-color: orange;
	}
</style>
</head>
<body>
	<div align="left">
	<h1>게시글 목록</h1>
	<h3>${userName}님! 게시판에 오신걸 환영합니다...<a href="logout.do">Log-out</a></h3>
	
	<!-- 검색 시작 -->
	<form action="getBoardList.do" method="post">
	<table border="1">
		<tr>
			<td align="right">
				<select name="searchCondition">
					<c:forEach items="${conditionMap }" var="option">
						<option value="${option.value }">${option.key }
					</c:forEach>
				</select>
				<input name="searchKeyword" type="text" />
				<input type="submit" value="검색" />
			</td>
		</tr>	
	</table>
	</form>
	<!-- 검색 종료 -->
	
	<table border="1">
		<tr>
			<th width="100">번호</th>
			<th width="200">제목</th>
			<th width="150">작성자</th>
			<th width="150">등록일</th>
			<th width="100">조회수</th>
		</tr>
				
		<c:forEach items="${boardList}" var="board">	
		<tr>
			<td>${board.seq }</td>
			<td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
			<td>${board.writer}</td>
			<td>${board.regDate}</td>
			<td>${board.cnt}</td>
		</tr>
		</c:forEach>
		
	</table>
	<br>
	<a href="insertBoard.jsp">새글 등록</a>	
	</div>
</body>
</html>