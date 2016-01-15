<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base
	href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath}/">
</head>
<body>
	<h1>用户列表</h1><a href="admin/user-add-ui">增加用户</a>
	<table>
		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.userId }</td>
				<td>${u.userName }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>