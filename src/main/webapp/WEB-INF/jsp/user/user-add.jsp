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
	<h1>用户增加</h1>
	<c:if test="${allErrors != null }">
		<ul>
			<c:forEach items="${allErrors}" var="error">
				<li>${error.defaultMessage}
				</li>
			</c:forEach>
		</ul>
	</c:if>
	<form action="admin/user-add-submit">
		用户名：<input name="userName"> <input type="submit" value="提交">
	</form>

</body>
</html>