<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="security/reg" method="post">
	<ul style="list-style: none;">
		<li>用户名:<input type="text" name="loginName"/></li>
		<li>密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password"/></li>
		<li>姓&nbsp;&nbsp;&nbsp;名:<input type="text" name="name"/></li>
		<li>邮&nbsp;&nbsp;&nbsp;箱:<input type="text" name="email"/></li>
		<li><input type="submit" value="注册"/></li>
	</ul>
	</form>
</div>
</body>
</html>