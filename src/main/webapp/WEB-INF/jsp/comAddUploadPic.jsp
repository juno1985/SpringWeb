<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<form method="post" action="/demo/compUpload/add" enctype="multipart/form-data">
商品名称:<input type="text" name="tradeMark" ><br/>
商品价格:<input type="text" name="price"><br/>
商品图片:<input type="file" name="pic"><br/>
<input type="submit" value="提交">
</form>
</body>
</html>