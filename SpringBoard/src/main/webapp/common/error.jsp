<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>기본 에러 화면</title>
<style>
	table{
		width:100%;
		border:1px solid;
		padding:0px;
	}	
</style>

<body bgcolor="#ffffff" text="#000000">
<!-- 타이틀 시작 -->
<table>
	<tr>
		<td align="center" bgcolor="orange"><b>기본 에러 화면입니다.</b></td>
	</tr>
</table>

<!-- 에러메시지 -->
<table>
	<tr>
		<td align="center"><br><br><br><br><br>Message : ${exception.message}<br><br><br><br><br></td>
	</tr>
</table>

</body>
</html>