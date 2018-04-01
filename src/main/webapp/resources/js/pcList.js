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