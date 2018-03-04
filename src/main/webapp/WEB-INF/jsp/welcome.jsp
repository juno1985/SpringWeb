<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<title>Insert title here</title>
</head>
<body>
<table border="1" >
<tr><th>名称</th><th>价格</th></tr>
<tr>
<c:forEach items="${mList }" var="mobile">
	<tr><td>${mobile.tradeMark }</td><td>${mobile.price }</td></tr>
</c:forEach>
</tr>
</table>
</body>
</html>