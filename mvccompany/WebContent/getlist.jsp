<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<!-- jstl -->
	<c:forEach var="cmp" items="${aa}">
		${cmp.cmpId}--${cmp.cmpName}--${cmp.cmpPwd }--${cmp.cmpEmail}&nbsp;&nbsp;  
		<a href="cmpt?opt=getId&cmpId=${cmp.cmpId }"><fmt:message key="xiangxixinxi"></fmt:message></a>&nbsp;&nbsp;&nbsp;
		<!-- url重写   拦截路径?名称=值&名称=值 -->
		<a href="cmpt?opt=del&cmpId=${cmp.cmpId }"><fmt:message key="shanchu"></fmt:message></a>
		<br>
	</c:forEach>
</body>
</html>