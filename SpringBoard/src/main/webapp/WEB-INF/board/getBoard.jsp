<%@page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 상세</title>
<style>
	table{		
		border:1px solid #222;		
	}	
</style>
</head>
<body>
<div align="center">
<h1>글 상세</h1>
<a href="logout.do">Log-out</a>
<hr>
<form action="updateBoard.do" method="post">
<input name="seq" type="hidden" value="${board.seq }" />
<table border="1">
	<tr>
		<td width="70" style="background-color: orange">제목</td>
		<td align="left"><input name="title" type="text" value="${board.title }" /></td>
	</tr>
	
	<tr>
		<td style="background-color: orange">작성자</td>
		<td align="left">${board.writer }</td>
	</tr>
	
	<tr>
		<td style="background-color: orange">내용</td>
		<td align="left"><textarea name="content" cols="40" rows="10">${board.content }</textarea></td>
	</tr>
	
	<tr>
		<td style="background-color: orange">등록일</td>
		<td align="left">${board.regDate }</td>
	</tr>
	
	<tr>
		<td style="background-color: orange">조회수</td>
		<td align="left">${board.cnt }</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="글 수정" />
		</td>
	</tr>
</table>	
</form>
<br>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;	
<a href="deleteBoard.do?seq=${board.seq}">글 삭제</a>&nbsp;&nbsp;&nbsp;	
<a href="getBoardList.do">글 목록</a>
</div>	
</body>
</html>