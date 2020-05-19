<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.itheima.com/functions/myfunction" prefix="myfn" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OGNL-expression</title>
</head>
<body>

<%--
EL表达式：${}
jsp表达式：<%=%>
 --%>
<%--EL表达式，只能调用静态方法 --%>
abcdefg----->ABCEDFG
${myfn:touppercase("abcdefg") }
<hr/>

<%--OGNL表达式，可以访问普通方法 
OGNL表达式，必须写在struts2的标签中
s:property就类似于jsp表达式，把值输到浏览器上

value属性中的内容不再是我们看到的字符串，它是一个OGNL表达式
如果想让他变成一个普通的字符串，在值外面套上单引号
--%>

<s:property value="OGNL-expression"/>这是一个OGNL表达式<br/>
<s:property value="'OGNL-expression'"/>这是一个普通的字符串<br/>
<s:property value="'OGNL-expression'.length()"/>使用普通的字符串调用了获取长度的方法<br/>

<hr/>

<%--OGNL访问静态属性。访问静态属性的方式：@全类名@静态属性名称 --%>
<s:property value="@java.lang.Integer@MAX_VALUE"/><br/>
<hr/>
<%--OGNL访问静态方法 
访问静态方法的方式：@全类名@静态方法名
struts2的框架默认禁止静态方法调用的，我们可以通过配置开启
struts.ognl.allowStaticMethodAccess=false，把它改为true；
--%>
<s:property value="@java.lang.Math@random()"/>
<hr/>

<%--OGNL操作map和list --%>
<%--使用s:radio标签，创建list集合
{}相当于创建了一个list集合
list属性里的取值是一个OGNL表达式
 --%>
 
 <s:radio name="gender" list="{'男','女'}"></s:radio><br/>
 
 <%--使用s:radio创建一个map
 #{}表示创建一个map
 1和0作为value给radio标签的value属性赋值
 男和女作为key，显示到页面的内容
  --%>
  <s:radio name="gender" list="#{'1':'男','0':'女'}"></s:radio>
</body>
</html>