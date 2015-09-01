<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<table class="basic">
	<tr>
		<th>이름</th>
		<td>${result.name}</td>
	</tr>
	<tr>
		<th>나이</th>
		<td>${result.age}</td>
	</tr>
</table>
</body>
</html>
