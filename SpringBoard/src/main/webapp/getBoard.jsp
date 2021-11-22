<%@page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	///���ǿ� ����� �� ��� ����
	BoardVO board = (BoardVO)session.getAttribute("board");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ��</title>
<style>
	table{		
		border:1px solid #222;		
	}	
</style>
</head>
<body>
<div align="center">
<h1>�� ��</h1>
<a href="logout.do">Log-out</a>
<hr>
<form action="updateBoard.do" method="post">
<input name="seq" type="hidden" value="<%=board.getSeq() %>" />
<table border="1">
	<tr>
		<td width="70" style="background-color: orange">����</td>
		<td align="left"><input name="title" type="text" value="<%=board.getTitle() %>" /></td>
	</tr>
	
	<tr>
		<td style="background-color: orange">�ۼ���</td>
		<td align="left"><%=board.getWriter()%></td>
	</tr>
	
	<tr>
		<td style="background-color: orange">����</td>
		<td align="left"><textarea name="content" cols="40" rows="10"><%=board.getContent() %></textarea></td>
	</tr>
	
	<tr>
		<td style="background-color: orange">�����</td>
		<td align="left"><%=board.getRegDate() %></td>
	</tr>
	
	<tr>
		<td style="background-color: orange">��ȸ��</td>
		<td align="left"><%=board.getCnt() %></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="�� ����" />
		</td>
	</tr>
</table>	
</form>
<br>
<a href="insertBoard.jsp">�۵��</a>&nbsp;&nbsp;&nbsp;	
<a href="deleteBoard.do?seq=<%=board.getSeq()%>">�� ����</a>&nbsp;&nbsp;&nbsp;	
<a href="getBoardList.do">�� ���</a>
</div>	
</body>
</html>