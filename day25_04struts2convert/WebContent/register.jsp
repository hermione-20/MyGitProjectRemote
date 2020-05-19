<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/register.action" method="post">
用户名：<input type="text" name="username"/><br/>
密码：<input type="password" name="password"/><br/>
生日：<input type="text" name="birthday"/><br/>
爱好：<input type="checkbox" name="hobby" value="吃饭"/>吃饭
<input type="checkbox" name="hobby" value="睡觉"/>睡觉
<input type="checkbox" name="hobby" value="写代码"/>写代码
<br/>
已婚：<input type="checkbox" name="married" value="true"/><br/>
<input type="submit" value="提交"/>

</form>
</body>
</html>