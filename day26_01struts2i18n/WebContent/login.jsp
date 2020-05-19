<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
	pageEncoding="UTF-8"%>
	
	<%
	Locale locale=request.getLocale();
	ResourceBundle bundle=ResourceBundle.getBundle("com.itheima.resource.message",locale);
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=bundle.getString("jsp.login.title") %></title>
</head>
<body>
	<form action="">
		<%=bundle.getString("jsp.login.username") %>：<input type="text" name="username" /><br /> 
		<%=bundle.getString("jsp.login.password") %>：<input type="password" name="password" /><br /> 
		<input type="submit" value="<%=bundle.getString("jsp.login.submit") %>" />
	</form>
</body>
</html>