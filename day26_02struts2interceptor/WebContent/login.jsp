<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login.action"
		method="post">
		用户名：<input type="text" name="username" /><br /> 密码：<input
			type="password" name="password"><br /> <input type="submit"
			value="登陆" />

	</form>

</body>
</html>