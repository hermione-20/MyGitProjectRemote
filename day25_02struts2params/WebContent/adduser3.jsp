<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>动态参数封装</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/action3.action" method="post">
<%--表单中的name属性取值必须与动作类中数据模型的set方法后面的名称一致 --%>
用户名：<input type="text" name="user.username"> <br/>
年龄：<input type="text" name="user.age"/><br/>
<input type="submit" value="提交"/>
</form>
</body>
</html>