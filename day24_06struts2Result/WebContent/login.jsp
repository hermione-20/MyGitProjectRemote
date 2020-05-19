<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="captchaAction" method="post">
             用户名：<input type="text" name="username"/><br/>
             密码：<input type="password" name="password"/><br/>
             验证码：<input type="text" name="validateCode"/>
             <image src="${pageContext.request.contextPath }/captchaAction"/>
             <br/>
   <input type="submit" value="登陆"/>
   </form>
</body>
</html>