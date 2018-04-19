<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="stus?opt=update" method="post">
		编号：<input type="text" name="id" value="${stusa.id }"/><br/>
		用户名：<input type="text" name="name" value="${stusa.name }"/><br/>
		密码：<input type="text" name="pwd" value="${stusa.pwd }"/><br/> 
		年龄：<input type="text" name="age" value="${stusa.age }"/><br/>
	<input type="submit" value="修改"/>
	</form>
</body>
</html>