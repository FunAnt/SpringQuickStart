<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���</title>
</head>
<body>
<div align="center">
<h1>�� ���</h1>
<a href="logout.do">Log-out</a>
<hr>
<form action="insertBoard.do" method="post" enctype="multipart/form-data">
<table border="1">
	<tr>
		<td width="70" style="background-color: orange">����</td>
		<td align="left"><input name="title" type="text"/></td>
	</tr>	
	<tr>
		<td style="background-color: orange">�ۼ���</td>
		<td align="left"><input name="writer" type="text"/></td>
	</tr>	
	<tr>
		<td style="background-color: orange">����</td>
		<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
	</tr>
	<tr>
		<td style="background-color: orange">���ε�</td>
		<td align="left"><input type="file" name="uploadFile" /></td> 
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="���� ���" />
		</td>
	</tr>
</table>	
</form>
<hr>
<a href="getBoardList.do">�� ��� ����</a>
</div>
</body>
</html>