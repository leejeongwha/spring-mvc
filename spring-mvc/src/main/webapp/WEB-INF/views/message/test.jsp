<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<spring:message code='test' arguments='메시지테스트' var="testMessage"/>
<spring:message code='test1' var="testMessage1"/>
${testMessage}
<br>
${testMessage1}
</body>
</html>
