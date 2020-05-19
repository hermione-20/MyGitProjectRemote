<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--使用通配符访问动作类和动作方法 
  <a href="${pageContext.request.contextPath }/add_User.action">添加用户</a>
  <a href="${pageContext.request.contextPath }/update_User.action">更新用户</a>
  <a href="${pageContext.request.contextPath }/delete_User.action">删除用户</a>
  <a href="${pageContext.request.contextPath }/find_User.action">查找用户</a>
  
  --%>
  
  <%--动态方法调用
          动作名称!动作方法名称.action    注：!是英文字符下的符号。
          动作名称!动作方法名称
   --%>
  <a href="${pageContext.request.contextPath }/user!addUser.action">添加用户</a>
  <a href="${pageContext.request.contextPath }/user!updateUser.action">更新用户</a>
  <a href="${pageContext.request.contextPath }/user!deleteUser.action">删除用户</a>
  <a href="${pageContext.request.contextPath }/user!findUser.action">查找用户</a>
  
</body>
</html>