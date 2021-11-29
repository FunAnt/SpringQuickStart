<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>새글 등록</title>
</head>
<body>
<div align="center">
<h1>글 등록</h1>
<a href="logout.do">Log-out</a>
<hr>
<form action="insertBoard.do" method="post" enctype="multipart/form-data">
<table border="1">
	<tr>
		<td width="70" style="background-color: orange">제목</td>
		<td align="left"><input name="title" type="text"/></td>
	</tr>	
	<tr>
		<td style="background-color: orange">작성자</td>
		<td align="left"><input name="writer" type="text"/></td>
	</tr>	
	<tr>
		<td style="background-color: orange">내용</td>
		<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
	</tr>
	<tr>
		<td style="background-color: orange">업로드</td>
		<td align="left"><input type="file" name="uploadFile" /></td> 
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="새글 등록" />
		</td>
	</tr>
</table>	
</form>
<hr>
<a href="getBoardList.do">글 목록 가기</a>
</div>
</body>
</html>