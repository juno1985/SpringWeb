<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
/*页面加载时执行如下*/
$(document).ready(function(){
	$('body').on('click','.deleteFile',function(event){
		
		/* console.log('删除被点击了'); */
		
		$(this).parent('div').remove();
	});
});

function addFileUpload(){
	/* console.log("button clicked!"); */
	$('#uploadWrapper').append('<div><input type="file" name="pic"><a href="#" class="deleteFile">删除</a><br/></div>');
}

</script>

<form method="post" action="/demo/compUpload/add" enctype="multipart/form-data">
商品名称:<input type="text" name="tradeMark" ><br/>
商品价格:<input type="text" name="price"><br/>
商品图片:<div id="uploadWrapper"><div><input type="file" name="pic"><a href="#" class="deleteFile">删除</a><br/></div></div>
<input type="submit" value="提交">
</form>
<button onClick="addFileUpload()">添加附件</button>
</body>
</html>