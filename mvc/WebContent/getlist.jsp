<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- jstl -->
	<c:forEach var="stu" items="${aa}">
		${stu.id} --${stu.name }--${stu.pwd }--${stu.age }&nbsp;&nbsp;
		<a href="stus?opt=getId&id=${stu.id}">详细信息</a>&nbsp;&nbsp;
		<a href="stus?opt=del&id=${stu.id}">删除</a><br/>
	</c:forEach>
</body>
</html>