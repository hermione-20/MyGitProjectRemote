<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>struts2中的国际化</title>
</head>
<body>
struts2中的国际化，在jsp页面访问消息资源包，必须使用struts2的标签
<%--使用s:text获取消息资源包的值 
当直接访问JSP时，因为没有经过动作类，所以只会访问全局消息资源包，如果经过了动作类，就会先访问动作类资源包。
--%>
<s:text name="key"></s:text><hr/>
<%--当在消息资源包中都找不到name值时，直接把name属性的值输出到页面上 --%>
<s:text name="abc"></s:text><hr/>

<%--s:i18n标签，读取指定消息资源包--%>
<s:i18n name="com.itheima.resource.message">
<s:text name="key"></s:text>
</s:i18n>

<%--当自由指定读取消息资源包不存在时，是按照资源包的搜索顺序去查找 --%>

<s:i18n name="cn.itcast.resource.message">
<s:text name="key"></s:text>
</s:i18n>
</body>
</html>