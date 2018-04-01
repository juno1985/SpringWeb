<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<!-- 引入BootStrap CSS样式文件 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<!-- 引入jQuery文件 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/popper.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
</head>
<style type="text/css">
body{
	margin-top:20px;
}
</style>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<form class="form" method="post" action="/demo/RESTComputer/comAddUseMybatis" enctype="multipart/form-data">
			 <div class="form-group">
				商品名称:<input type="text" name="tradeMark" >
			 </div>
			 <div class="form-group">
				商品价格:<input type="text" name="price">
			 </div>
			 <div class="form-group">
				商品图片:<div id="uploadWrapper"><div><input type="file" name="pic"><br/></div></div>
			 </div>
				<input class="float-right btn btn-success" type="submit" value="提交">
			</form><br/>
		</div>
	</div>
</div>
</body>
</html>