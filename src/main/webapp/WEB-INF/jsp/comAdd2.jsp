<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.serializejson.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

</head>

<body>
<input type="hidden" id="ctx" value="<%=request.getContextPath() %>"/>
<script type="text/javascript">
function addComputer(){
	var computer = $('#comForm').serializeJSON();
/* 	alert(JSON.stringify(computer)); */
	
	$.ajax({
		url: "${ctx}/demo/RESTComputer/add",
		type: "POST",
		contentType:"application/json",
		data:JSON.stringify(computer),
		dataType: "json",
		success:function(data){
			alert(data.msg);
		}
	
	});
}

</script>


<form id="comForm" method="post">
商品名称:<input type="text" name="tradeMark"><br/>
商品价格:<input type="text" name="price"><br/>

</form>
<button onclick="addComputer()">添加</button>
</body>
</html>