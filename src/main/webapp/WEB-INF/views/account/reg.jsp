<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<base href="<%=basePath%>">
</head>
<body>
<div style="width:200px;height:100px;margin:200px auto;">
	<form:form modelAttribute="signupCommand">
	<form:errors path="*" element="div" cssClass="errors"/>
	<ul style="list-style: none;">
		<li>用户名:<form:input path="username"/></li>
		<li>密&nbsp;&nbsp;&nbsp;码:<form:input path="password"/></li>
		<li>姓&nbsp;&nbsp;&nbsp;名:<form:input path="name"/></li>
		<li>邮&nbsp;&nbsp;&nbsp;箱:<form:input path="email"/></li>
		<li><input type="submit" value="注册" onclick="regV();"/></li>
	</ul>
	</form:form>
</div>
</body>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/regValidate.js"></script>
</html>