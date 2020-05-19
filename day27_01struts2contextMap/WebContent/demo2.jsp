<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
    <%@page import="java.util.*,com.opensymphony.xwork2.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>取ValueStack数据</title>
</head>
<body>
<%--使用s:property标签，获取ValueStack元素
 value属性的取值是一个OGNL表达式，它只能获得元素中的属性。
 注意：取ValueStack对象的属性时，不使用#
 它是从栈顶逐个对象查找指定的属性名称，只要找到了，就不再继续查找
 --%>
 
 <s:property value="name"/><br/>
 
 <%--获取ValueStack指定位置的元素 
 使用的是：[索引].属性名称
 --%>
 <s:property value="[1].name"/><br/>
 
 <%--取栈顶map中的元素 --%>
 <s:property value="s1.name"/><br/>
 
 <%--当s:property什么都不写，默认取栈顶元素 --%>
 <s:property/>
 
 <%//模拟原理：其实全是valueStack的findvalue和findString
 ValueStack vs=ActionContext.getContext().getValueStack();
 Object obj=vs.findValue("name");
 out.print("<br/>---------------<br/>");
 out.print(obj);
 
 %>

<s:debug></s:debug>

</body>

</html>