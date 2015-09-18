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
<title>用户登录</title>
<base href="<%=basePath%>">
</head>
<body>
<div style="width:200px;height:100px;margin:200px auto;">
	<form action="security/login" method="post">
	<ul style="list-style: none;">
		<li>用户名:<input type="text" name="username"/></li>
		<li>密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password"/></li>
		<li><input type="submit" value="登录"/></li>
	</ul>
	</form>
</div>
</body>
</html>