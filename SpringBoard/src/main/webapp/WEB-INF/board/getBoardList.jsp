<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ���</title>
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
	<h1>�� ���</h1>
	<h3>�׽�Ʈ�� ȯ���մϴ�...<a href="logout.do">Log-out</a></h3>
	
	<!-- �˻� ���� -->
	<form action="getBoardList.jsp" method="post">
	<table border="1">
		<tr>
			<td align="right">
				<select name="searchCondition">
					<option value="TITLE">����</option>
					<option value="CONTENT">����</option>
				</select>
				<input name="searchKeyword" type="text" />
				<input type="submit" value="�˻�" />
			</td>
		</tr>	
	</table>
	</form>
	<!-- �˻� ���� -->
	
	<table border="1">
		<tr>
			<th width="100">��ȣ</th>
			<th width="200">����</th>
			<th width="150">�ۼ���</th>
			<th width="150">�����</th>
			<th width="100">��ȸ��</th>
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
	<a href="insertBoard.jsp">���� ���</a>	
	</div>
</body>
</html>