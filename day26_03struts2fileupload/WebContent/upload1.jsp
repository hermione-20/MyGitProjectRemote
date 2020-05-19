<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>struts2中的文件上传</title>
</head>
<body>
<!-- 文件上传的必要前提：
1.请求方式必须是post；
2.enctype属性的取值必须是multipart/form-data;
3.提供一个文件选择域
 -->
 <s:actionerror/>
<s:form action="upload.action" enctype="multipart/form-data">
<s:textfield name="username" label="用户名"></s:textfield>
<s:file name="photo" label="照片"></s:file>
<s:submit value="上传"></s:submit>

</s:form>
</body>
</html>