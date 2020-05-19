<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>struts2的表单提交</title>
</head>
<body>
	<s:form action="login1">
	<s:token></s:token>
		<s:textfield name="name" label="用户名"></s:textfield>
		<s:submit value="提交"/>
	</s:form>
</body>
</html>