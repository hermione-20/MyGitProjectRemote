<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%--导入struts2的标签库 --%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册,使用的是struts2的标签</title>
</head>
<body>
<s:actionerror/><%--动作错误 --%>

<%-- <s:fielderror></s:fielderror><%--字段错误 --%>
<%--struts2的form表单，它提供了和原始html表单标签几乎一致的属性
   action:请求的地址，直接写动作名称，不用写contextPath;
   method:请求的方式，在这里不用写。struts2的表单默认就是post；
   enctype:表单编码的MIME类型

 --%>
<s:form action="addStudent.action">
<s:textfield name="username" label="用户名"></s:textfield>
<s:textfield name="age" label="年龄"></s:textfield>
<s:textfield name="email" label="邮箱"></s:textfield>
<s:textfield name="password" label="密码"></s:textfield>
<s:textfield name="repassword" label="确认密码"></s:textfield>
<s:textfield name="score" label="成绩"></s:textfield>
<s:textfield name="url" label="个人主页"></s:textfield>
<%--list的取值是生成一个list集合，并往集合中放入元素 --%>
<s:radio name="gender" list="{'男','女'}" label="性别"></s:radio>
<s:submit value="注册"></s:submit>


</s:form>


</body>
</html>