<%@page import="java.util.List" %>
<%@page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	//1. 사용자 입력 정보 추출 (TODO)
	//2. DB 연동처리
	BoardVO vo = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> boardList = boardDAO.getBoardList(vo);
	
	//3. 응답화면 구성
%>

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
	<h1>글 목록</h1>
	<h3>테스트님 환영합니다...<a href="logout_proc.jsp">Log-out</a></h3>
	
	<!-- 검색 시작 -->
	<form action="getBoardList.jsp" method="post">
	<table border="1">
		<tr>
			<td align="right">
				<select name="searchCondition">
					<option value="TITLE">제목</option>
					<option value="CONTENT">내용</option>
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
		
		<% for(BoardVO board : boardList) { %>	
		<tr>
			<td><%=board.getSeq() %></td>
			<td align="left"><a href="getBoard.jsp?seq=<%= board.getSeq() %>"><%= board.getTitle() %></a></td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getRegDate() %></td>
			<td><%=board.getCnt() %></td>
		</tr>
		<% } %>
	</table>
	<br>
	<a href="insertBoard.jsp">새글 등록</a>	
	</div>
</body>
</html>