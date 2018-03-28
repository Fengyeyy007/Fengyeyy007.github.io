<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
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
	${cmpName }
	<form action="cmpt?opt=update" method="post">
		<fmt:message key="bianhao"></fmt:message>
		：<input type="text" name="cmpId" value="${cmps.cmpId }" /><br />
		<fmt:message key="zhanghao"></fmt:message>
		：<input type="text" name="cmpName" value="${cmps.cmpName }" /><br />
		<fmt:message key="mima"></fmt:message>
		：<input type="text" name="cmpPwd" value="${cmps.cmpPwd }" /><br />
		<fmt:message key="youxiang"></fmt:message>
		：<input type="text" name="cmpEmail" value="${cmps.cmpEmail }" /><br />
		<input type="submit" value="<fmt:message key='xiugai'></fmt:message>" />
	</form>
</body>
</html>