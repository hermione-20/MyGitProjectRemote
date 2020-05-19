<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页：检查登陆的拦截器</title>
</head>
<body>

<%--如果要来到本页面（主页）,必须得先登陆--%>
主页<hr/>
<a href="${pageContext.request.contextPath}/showOther.action">访问另一个页面</a>
</body>
</html>