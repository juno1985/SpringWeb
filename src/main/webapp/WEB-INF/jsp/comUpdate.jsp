<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<form method="post">
商品名称:<input type="text" name="tradeMark" value="${comp.tradeMark }"><br/>
商品价格:<input type="text" name="price" value="${comp.price }"><br/>
<input type="submit" value="更新">
</form>
</body>
</html>