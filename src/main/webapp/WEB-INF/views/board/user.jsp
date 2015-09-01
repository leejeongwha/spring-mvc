<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<link rel="stylesheet" type="text/css" href="/resources/css/table.css"/>
</head>
<body>
<form id="boardForm" action="/board/add">
<table class="basic">
	<tr>
		<th>아이디</th>
		<td><input type="test" name="id" value="${boardUser.id}"/></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="test" name="userName" value="${boardUser.userName}"/></td>
	</tr>
	<tr>
		<th>나이</th>
		<td><input type="test" name="age" value="${boardUser.age}"/></td>
	</tr>
	<tr>
		<th>직위</th>
		<td><input type="test" name="role" value="${boardUser.role}"/></td>
	</tr>
	<tr>
		<th>패스워드</th>
		<td><input type="test" name="passwd" value="${boardUser.passwd}"/></td>
	</tr>
</table>
<button type="submit">submit</button>
</form>
</body>
</html>