<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Refresh" content="3; url=activiti/main"/> 
<title>注册结果</title>
<script type="text/javascript">
	
	var interval;
	function countdown(){
		var sec = parseInt(document.getElementById("sec").innerHTML);
		document.getElementById("sec").innerHTML=sec;
		if(sec == 0) clearInterval(interval);
		sec--;
	}
	
	function onl(){
		interval = setInterval("countdown()",1000);
	}
	onl();
</script>
</head>
<body>
<h1>注册成功,<span id="sec">3</span>秒后跳转到工作台...</h1>
</body>
</html>