<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<style>
	.errorblock {
		color: #ff0000;
		background-color: #ffeeee;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
	}
</style>
</head>
<body onload="document.f.j_username.focus();">

	<h3>自定义登陆页面</h3>
	
	<c:if test="${not empty error }">
		<div class="errorblock">
			登陆失败<br>
			原因：${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
		</div>
	</c:if>

	<form name="f" action="${pageContext.request.contextPath }/j_spring_security_check" method="post">
		<table>
			<tbody>
				<tr>
					<td>用户：</td>
					<td><input type="text" name="j_username" value=""></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="j_password"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" name="submit" value="submit">
						<input type="reset" name="reset">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>