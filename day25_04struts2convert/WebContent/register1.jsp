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
<s:fielderror></s:fielderror><%--字段错误 --%>

<%--struts2的form表单，它提供了和原始html表单标签几乎一致的属性
   action:请求的地址，直接写动作名称，不用写contextPath;
   method:请求的方式，在这里不用写。struts2的表单默认就是post；
   enctype:表单编码的MIME类型

 --%>
<s:form action="register.action">
<s:textfield name="username" label="用户名"></s:textfield>
<s:password name="password" label="密码"></s:password>
<s:textfield name="birthday" label="生日"></s:textfield>
<s:submit value="注册"></s:submit>


</s:form>






<%-- 
<form action="${pageContext.request.contextPath }/register.action" method="post">
用户名：<input type="text" name="username"/><br/>
密码：<input type="password" name="password"/><br/>
生日：<input type="text" name="birthday"/><br/>
爱好：<input type="checkbox" name="hobby" value="吃饭"/>吃饭
<input type="checkbox" name="hobby" value="睡觉"/>睡觉
<input type="checkbox" name="hobby" value="写代码"/>写代码
<br/>
已婚：<input type="checkbox" name="married" value="true"/><br/>
<input type="submit" value="提交"/>

</form>
--%>
</body>
</html>