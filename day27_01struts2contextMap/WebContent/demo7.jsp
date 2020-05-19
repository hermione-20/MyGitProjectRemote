
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一个表单的小例子</title>
</head>
<body>
<s:form action="saveCustomer">
<s:textfield name="name" label="用户名"></s:textfield>
<s:password name="password" label="密码"></s:password>
<s:checkbox name="married" label="已婚" value="true"></s:checkbox>
<s:checkboxlist name="hobby" list="{'读书','摄影','旅游' }" label="爱好"></s:checkboxlist>
<s:select name="city" label="故乡" list="#{'BJ':'北京','SH':'上海','SZ':'苏州'}" headerKey="" headerValue="---请选择---"></s:select>
<s:textarea name="description" label="个人介绍" rows="5" cols="25" ></s:textarea>
<s:radio name="gender" label="性别" list="#{'male':'男','female':'女'}" value="male"><%--value是一个OGNL表达式 --%>
</s:radio>
<s:submit value="提交"></s:submit>
<s:reset value="重置"></s:reset>
</s:form>

<%-- <s:debug/> --%>
</body>

</html>