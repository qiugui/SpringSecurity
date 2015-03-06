<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
</head>
<body>
	<h3>Message: ${message }</h3>
	<h3>Username: ${username }</h3>
	<a href="${pageContext.request.contextPath }/j_spring_security_logout">Logout</a>
</body>
</html>