<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<c:if test="${language=='chiness'}">
		<fmt:setLocale variant="variant" value="zh" scope="session" />
		<fmt:setBundle basename="proper" scope="session" />
	</c:if>
	<c:if test="${language=='english'}">
		<fmt:setLocale variant="variant" value="en" scope="session" />
		<fmt:setBundle basename="proper" scope="session" />
	</c:if>
	<c:if test="${empty language}">
		<fmt:setLocale variant="variant" value="zh" scope="session" />
		<fmt:setBundle basename="proper" scope="session" />
	</c:if>


	<a href="country?opt=i18n&language=chiness">中文</a>
	<a href="country?opt=i18n&language=english">英文</a>
	<br /> ${msg }
	<form action="cmpt?opt=login" method="post">
		<fmt:message key="zhanghao"></fmt:message>
		：<input type="text" name="cmpName" value="${cmpName }" /><br />
		<fmt:message key="mima"></fmt:message>
		：<input type="text" name="cmpPwd" value="${cmpPwd }" /><br />
		<fmt:message key="yanzhengma"></fmt:message>
		：<input type="text" name="randomss" /> <img src="image.jsp" /> <input
			type="submit" value="<fmt:message key='denglu'></fmt:message>" /> <a
			href="save.jsp"><fmt:message key="zhuce"></fmt:message></a>
	</form>
</body>
</html>