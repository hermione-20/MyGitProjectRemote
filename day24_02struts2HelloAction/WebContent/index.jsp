<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Struts2的入门案例</title>
</head>
<body>
<%--在Struts2中，控制器会默认拦截后缀为.action的请求（以.action为后缀的url）除此之外，什么都不写也可以 --%>
<a href="${pageContext.request.contextPath}/hello.action">访问Struts2的第一个入门案例</a>
<a href="${pageContext.request.contextPath}/hello">访问Struts2的第一个入门案例，没有.action</a>
</body>
</html>