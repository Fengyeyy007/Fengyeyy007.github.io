<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	${msg}
	<form action="stus?opt=login" method="post">
		用户名：<input type="text" name="name" id="name"/><br/>
		密&nbsp;&nbsp;码：<input type="text" name="pwd" id="pwd"/><br/>
		<input type="submit" value="登录"/><a href="save.jsp">注册</a>
	</form>
</body>
</html>