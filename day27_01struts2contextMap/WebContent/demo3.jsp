
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL表达式和OGNL表达式</title>
</head>
<body>
EL表达式：${name} <%--pageContext.findAttribute("name") --%>
<hr/>
<%--我们知道就行，开发中不要这麽写
当我们不写#号时，它会从值栈的栈顶找对应的属性，如果没有属性，还要去ActionContext中再把value的值作为key去查找。
 --%>
OGNL表达式：<s:property value="name"/>
<s:debug/>
</body>

</html>