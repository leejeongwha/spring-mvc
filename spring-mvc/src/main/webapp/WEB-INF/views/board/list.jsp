<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<link rel="stylesheet" type="text/css" href="/resources/css/table.css"/>
</head>
<body>
<table class="basic">
	<colgroup span="4">
        <col width="200"></col>
        <col width="*"></col>
        <col width="200"></col>
        <col width="200"></col>
    </colgroup>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>나이</th>
		<th>직위</th>
	</tr>
	<c:forEach var="boarUser" items="${boardUserList}">
		<tr>
			<td><a href="/board/get/${boarUser.id}">${boarUser.id}</a></td>
			<td>${boarUser.userName}</td>
			<td>${boarUser.age}</td>
			<td>${boarUser.role}</td>
		</tr>
	</c:forEach>
</table>
<div align="center">
<%@ include file="paging.jsp" %>
</div>

</body>
</html>
