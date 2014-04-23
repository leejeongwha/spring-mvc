<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
java.util.Date toDay = new java.util.Date(); 
java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd"); 

response.setContentType("application/vnd.ms-excel; charset=UTF-8");
response.setHeader("Content-Disposition", "attachment;filename=stock_"+sdf.format(toDay)+".xls");
response.setHeader("Content-Description", "JSP Generated Data");
%>
<title>엑셀 다운로드</title>
</head>
<body>
	<div>
		<table border="1">
			<thead>
			<tr>
				<c:forEach items="${keySet }" var="key">
					<th>${key} &nbsp; &nbsp; &nbsp; &nbsp;</th>
				</c:forEach>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${dataElementList}" var="dataElement">
				<tr>
					<c:forEach items="${dataElement }" var="data">
						<td>="<c:out value="${data}" />"</td>
					</c:forEach>
				</tr>
			</c:forEach>
			<tbody>
		</table>
	</div>
</body>
</html>