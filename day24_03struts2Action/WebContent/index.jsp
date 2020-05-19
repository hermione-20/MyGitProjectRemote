<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>struts2的配置文件</title>
</head>
<body>
  <a href="${pageContext.request.contextPath}/action1.action">以.action结尾的</a>
  <a href="${pageContext.request.contextPath}/action1">没有后缀</a>
  <a href="${pageContext.request.contextPath}/action1.do">以.do结尾的</a>
  <a href="${pageContext.request.contextPath}/action1.abc">以.abc结尾的</a>
  <a href="${pageContext.request.contextPath}/action1.abcd">以.abcd结尾的</a>
</body>
</html>