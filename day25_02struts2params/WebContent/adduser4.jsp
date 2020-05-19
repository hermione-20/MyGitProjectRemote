<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>动态参数封装</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/action4.action" method="post">
<%--注意name属性的取值已经不是一个普通的字符串了 --%>
用户名：<input type="text" name="username"/> <br/>
年龄：<input type="text" name="age"/><br/>
<input type="submit" value="提交"/>
</form>
</body>
</html>