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
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/pcList.js"></script> --%>

</head>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		url: "${ctx}/demo/RESTComputer/list",
		type: "GET",
		dataType: "json",
		success:function(data){
			
			var content = "<thead><tr><th>商品id</th><th>商品名称</th><th>商品价格</th><th>更新</th><th>删除</th></tr></thead>";
			
			//v-value, i-index
			data.forEach(function(v,i){
				/* console.log(v.cid + ' ' + v.tradeMark + ' ' + v.price + ' ' + v.pic); */
				content += "<tr><td>"+v.cid+"</td><td>"+v.tradeMark+"</td><td>"+v.price+"元</td>"+
							'<td><a href="/RESTComputer/update/'+v.cid+'">更新</a></td>'+
							'<td><a href="/RESTComputer/delete/'+v.cid+'">删除</a></td>'+
							"</tr>";
			}); 
			$('#pcTable').append("<tbody>"+content+"</tbody>");
		}
	
	});
});

</script>
<body>
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