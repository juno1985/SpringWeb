<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>PC列表</title>
<!-- 引入BootStrap CSS样式文件 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<!-- 引入jQuery文件 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/popper.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/pcList.js"></script>

</head>

<body>

<jsp:include page="/jsp/pop-window.jsp" />

<input type="hidden" id="ctx" value="<%=request.getContextPath() %>"/>

<div class="container">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<table id="pcTable" class="table table-condensed"></table>
		</div>
	</div>
</div>
</body>
</html>