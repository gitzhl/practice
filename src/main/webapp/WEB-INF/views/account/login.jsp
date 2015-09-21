<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/styles/sample.css"/>"/> 
<style type="text/css" >
	ul{
		list-style:none;
	}
	#box{
		width:200px;
		height:100px;
		margin:200px auto;
	}
</style>
</head>
<body>
<div id="box">
        <div class="content">
        	<form:form modelAttribute="loginCommand" commandName="loginCommand">
        		 <form:errors path="*" element="div" cssClass="errors"/>
        		 <ul>
                <li><div class="form-label">用户名:</div><form:input path="username"/></li>
                <li><div class="form-label">密码:</div><form:password path="password"/></li>
                <li><form:checkbox path="rememberMe"/> 记住</li>
                <li><input type="submit" value="登录"/></li>
                 </ul>
        	</form:form>
            <div align="right"><a href="<c:url value="/security/reg"/>">注册</a></div>
        </div>
    </div>
    <script type="text/javascript">
        document.getElementById('username').focus();
    </script>
</body>
</html>